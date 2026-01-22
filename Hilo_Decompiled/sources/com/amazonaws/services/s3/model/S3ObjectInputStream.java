package com.amazonaws.services.s3.model;

import com.amazonaws.internal.MetricAware;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.MetricFilterInputStream;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.HttpRequestBase;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class S3ObjectInputStream extends SdkFilterInputStream {
    private boolean eof;
    private final HttpRequestBase httpRequest;

    public S3ObjectInputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    private void doAbort() {
        try {
            close();
        } catch (IOException e10) {
            LogFactory.getLog(getClass()).debug("FYI", e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean wrapWithByteCounting(InputStream inputStream) {
        if (!AwsSdkMetrics.isMetricsEnabled()) {
            return false;
        }
        if (!(inputStream instanceof MetricAware)) {
            return true;
        }
        return !((MetricAware) inputStream).isMetricActivated();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream
    public void abort() {
        doAbort();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int available = super.available();
        if (available == 0) {
            return 1;
        }
        return available;
    }

    @Deprecated
    public HttpRequestBase getHttpRequest() {
        return this.httpRequest;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            this.eof = true;
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.eof = false;
    }

    @Deprecated
    public S3ObjectInputStream(InputStream inputStream, HttpRequestBase httpRequestBase) {
        this(inputStream, httpRequestBase, wrapWithByteCounting(inputStream));
    }

    @Deprecated
    public S3ObjectInputStream(InputStream inputStream, HttpRequestBase httpRequestBase, boolean z10) {
        super(z10 ? new MetricFilterInputStream(S3ServiceMetric.S3_DOWLOAD_THROUGHPUT, inputStream) : inputStream);
        this.httpRequest = httpRequestBase;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = super.read(bArr, i10, i11);
        if (read == -1) {
            this.eof = true;
        }
        return read;
    }
}
