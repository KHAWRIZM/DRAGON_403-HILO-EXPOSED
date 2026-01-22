package com.amazonaws.http.protocol;

import com.amazonaws.util.AWSRequestMetrics;
import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SdkHttpRequestExecutor extends HttpRequestExecutor {
    @Override // org.apache.http.protocol.HttpRequestExecutor
    protected HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        AWSRequestMetrics aWSRequestMetrics = (AWSRequestMetrics) httpContext.getAttribute(AWSRequestMetrics.class.getSimpleName());
        if (aWSRequestMetrics == null) {
            return super.doReceiveResponse(httpRequest, httpClientConnection, httpContext);
        }
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.HttpClientReceiveResponseTime;
        aWSRequestMetrics.startEvent(field);
        try {
            HttpResponse doReceiveResponse = super.doReceiveResponse(httpRequest, httpClientConnection, httpContext);
            aWSRequestMetrics.endEvent(field);
            return doReceiveResponse;
        } catch (Throwable th) {
            aWSRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
            throw th;
        }
    }

    @Override // org.apache.http.protocol.HttpRequestExecutor
    protected HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException, HttpException {
        AWSRequestMetrics aWSRequestMetrics = (AWSRequestMetrics) httpContext.getAttribute(AWSRequestMetrics.class.getSimpleName());
        if (aWSRequestMetrics == null) {
            return super.doSendRequest(httpRequest, httpClientConnection, httpContext);
        }
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.HttpClientSendRequestTime;
        aWSRequestMetrics.startEvent(field);
        try {
            HttpResponse doSendRequest = super.doSendRequest(httpRequest, httpClientConnection, httpContext);
            aWSRequestMetrics.endEvent(field);
            return doSendRequest;
        } catch (Throwable th) {
            aWSRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientSendRequestTime);
            throw th;
        }
    }
}
