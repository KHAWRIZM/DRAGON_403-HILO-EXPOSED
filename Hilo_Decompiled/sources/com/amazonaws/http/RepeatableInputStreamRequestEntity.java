package com.amazonaws.http;

import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricInputStreamEntity;
import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.metrics.internal.ServiceMetricTypeGuesser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class RepeatableInputStreamRequestEntity extends BasicHttpEntity {
    private static final Log log = LogFactory.getLog(AmazonHttpClient.class);
    private InputStream content;
    private boolean firstAttempt = true;
    private InputStreamEntity inputStreamRequestEntity;
    private IOException originalException;

    RepeatableInputStreamRequestEntity(Request<?> request) {
        setChunked(false);
        long j10 = -1;
        try {
            String str = request.getHeaders().get("Content-Length");
            if (str != null) {
                j10 = Long.parseLong(str);
            }
        } catch (NumberFormatException unused) {
            log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        }
        String str2 = request.getHeaders().get("Content-Type");
        ThroughputMetricType guessThroughputMetricType = ServiceMetricTypeGuesser.guessThroughputMetricType(request, ServiceMetricType.UPLOAD_THROUGHPUT_NAME_SUFFIX, ServiceMetricType.UPLOAD_BYTE_COUNT_NAME_SUFFIX);
        if (guessThroughputMetricType == null) {
            this.inputStreamRequestEntity = new InputStreamEntity(request.getContent(), j10);
        } else {
            this.inputStreamRequestEntity = new MetricInputStreamEntity(guessThroughputMetricType, request.getContent(), j10);
        }
        this.inputStreamRequestEntity.setContentType(str2);
        InputStream content = request.getContent();
        this.content = content;
        setContent(content);
        setContentType(str2);
        setContentLength(j10);
    }

    @Override // org.apache.http.entity.AbstractHttpEntity, org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.entity.BasicHttpEntity, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        if (!this.content.markSupported() && !this.inputStreamRequestEntity.isRepeatable()) {
            return false;
        }
        return true;
    }

    @Override // org.apache.http.entity.BasicHttpEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.firstAttempt && isRepeatable()) {
                this.content.reset();
            }
            this.firstAttempt = false;
            this.inputStreamRequestEntity.writeTo(outputStream);
        } catch (IOException e10) {
            if (this.originalException == null) {
                this.originalException = e10;
            }
            throw this.originalException;
        }
    }
}
