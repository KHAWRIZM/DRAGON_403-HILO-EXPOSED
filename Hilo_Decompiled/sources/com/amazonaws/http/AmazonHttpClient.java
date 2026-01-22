package com.amazonaws.http;

import anet.channel.util.HttpConstant;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final int TIME_MILLISEC = 1000;
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog(AmazonHttpClient.class);

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    private String getServerDateFromException(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("(");
        if (str.contains(" + 15")) {
            indexOf = str.indexOf(" + 15");
        } else {
            indexOf = str.indexOf(" - 15");
        }
        return str.substring(indexOf2 + 1, indexOf);
    }

    private <T extends Throwable> T handleUnexpectedFailure(T t10, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.incrementCounter(field);
        aWSRequestMetrics.addProperty(field, t10);
        return t10;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        if (statusCode >= 200 && statusCode < HTTP_STATUS_MULTIPLE_CHOICES) {
            return true;
        }
        return false;
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get("Location");
        if (statusCode == HTTP_STATUS_TEMP_REDIRECT && str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i10, RetryPolicy retryPolicy) {
        int i11 = i10 - 2;
        long delayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i11);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + delayBeforeNextRetry + "ms, attempt number: " + i11);
        }
        try {
            Thread.sleep(delayBeforeNextRetry);
            return delayBeforeNextRetry;
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e10.getMessage(), e10);
        }
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i10, RetryPolicy retryPolicy) {
        int i11 = i10 - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i11 >= maxErrorRetry) {
            return false;
        }
        if (inputStream != null && !inputStream.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Content not repeatable");
            }
            return false;
        }
        return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i11);
    }

    void afterError(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterError(request, response, amazonClientException);
        }
    }

    <T> void afterResponse(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterResponse(request, response);
        }
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        Response<T> response;
        if (executionContext != null) {
            List<RequestHandler2> requestHandler2s = requestHandler2s(request, executionContext);
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            try {
                response = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
                try {
                    afterResponse(request, requestHandler2s, response, awsRequestMetrics.getTimingInfo().endTiming());
                    return response;
                } catch (AmazonClientException e10) {
                    e = e10;
                    afterError(request, response, requestHandler2s, e);
                    throw e;
                }
            } catch (AmazonClientException e11) {
                e = e11;
                response = null;
            }
        } else {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03ec A[Catch: all -> 0x03ab, TRY_ENTER, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0444 A[Catch: all -> 0x03ab, TRY_LEAVE, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0470 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    <T> Response<T> executeHelper(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        Throwable th;
        Object obj;
        Object obj2;
        HttpResponse httpResponse;
        Object obj3;
        Signer signer;
        Object obj4;
        Throwable th2;
        LinkedHashMap linkedHashMap;
        Log log2;
        AmazonClientException amazonClientException;
        Object obj5;
        Signer signer2;
        HttpRequest createHttpRequest;
        Object obj6;
        HttpRequest httpRequest;
        MetricType metricType;
        Object obj7;
        HttpResponse httpResponse2;
        HttpResponse httpResponse3;
        HttpResponse httpResponse4;
        Object obj8;
        Object obj9;
        Object obj10;
        AmazonClientException amazonClientException2;
        HttpResponse httpResponse5;
        ExecutionContext executionContext2 = executionContext;
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.ServiceName, request.getServiceName());
        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.ServiceEndpoint, request.getEndpoint());
        setUserAgent(request);
        request.addHeader(HEADER_SDK_TRANSACTION_ID, UUID.randomUUID().toString());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(request.getParameters());
        HashMap hashMap = new HashMap(request.getHeaders());
        InputStream content = request.getContent();
        if (content != null && content.markSupported()) {
            content.mark(-1);
        }
        AWSCredentials credentials = executionContext.getCredentials();
        int i10 = 0;
        long j10 = 0;
        boolean z10 = false;
        AmazonClientException amazonClientException3 = null;
        Signer signer3 = null;
        HttpResponse httpResponse6 = null;
        URI uri = null;
        HttpRequest httpRequest2 = null;
        while (true) {
            int i11 = i10 + 1;
            boolean z11 = z10;
            long j11 = j10;
            awsRequestMetrics.setCounter(AWSRequestMetrics.Field.RequestCount, i11);
            boolean z12 = true;
            if (i11 > 1) {
                request.setParameters(linkedHashMap2);
                request.setHeaders(hashMap);
                request.setContent(content);
            }
            if (uri != null && request.getEndpoint() == null && request.getResourcePath() == null) {
                request.setEndpoint(URI.create(uri.getScheme() + HttpConstant.SCHEME_SPLIT + uri.getAuthority()));
                request.setResourcePath(uri.getPath());
            }
            try {
                if (i11 > 1) {
                    try {
                        MetricType metricType2 = AWSRequestMetrics.Field.RetryPauseTime;
                        awsRequestMetrics.startEvent(metricType2);
                        try {
                            httpResponse = httpResponse6;
                            try {
                                j11 = pauseBeforeNextRetry(request.getOriginalRequest(), amazonClientException3, i11, this.config.getRetryPolicy());
                                try {
                                    try {
                                        try {
                                            awsRequestMetrics.endEvent(metricType2);
                                            InputStream content2 = request.getContent();
                                            if (content2 != null && content2.markSupported()) {
                                                content2.reset();
                                            }
                                        } catch (IOException e10) {
                                            e = e10;
                                            obj3 = "Cannot close the response content.";
                                            signer = signer3;
                                            linkedHashMap = linkedHashMap2;
                                            obj4 = obj3;
                                            try {
                                                log2 = log;
                                                if (log2.isDebugEnabled()) {
                                                    log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                }
                                                MetricType metricType3 = AWSRequestMetrics.Field.Exception;
                                                awsRequestMetrics.incrementCounter(metricType3);
                                                awsRequestMetrics.addProperty(metricType3, e);
                                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                                    resetRequestAfterError(request, e);
                                                    if (!z11 && httpResponse != null) {
                                                        try {
                                                            if (httpResponse.getRawContent() != null) {
                                                                httpResponse.getRawContent().close();
                                                            }
                                                        } catch (IOException e11) {
                                                            log.warn(obj4, e11);
                                                        }
                                                    }
                                                    z10 = z11;
                                                    j10 = j11;
                                                    httpResponse6 = httpResponse;
                                                    amazonClientException3 = amazonClientException;
                                                    signer3 = signer;
                                                    executionContext2 = executionContext;
                                                    i10 = i11;
                                                    linkedHashMap2 = linkedHashMap;
                                                } else {
                                                    throw amazonClientException;
                                                }
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                th = th2;
                                                obj5 = obj4;
                                                z12 = z11;
                                                httpResponse6 = httpResponse;
                                                obj = obj5;
                                                if (!z12) {
                                                    if (httpResponse6 != null) {
                                                        try {
                                                            if (httpResponse6.getRawContent() != null) {
                                                                httpResponse6.getRawContent().close();
                                                                throw th;
                                                            }
                                                            throw th;
                                                        } catch (IOException e12) {
                                                            log.warn(obj, e12);
                                                            throw th;
                                                        }
                                                    }
                                                    throw th;
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj5 = "Cannot close the response content.";
                                        z12 = z11;
                                        httpResponse6 = httpResponse;
                                        obj = obj5;
                                        if (!z12) {
                                        }
                                    }
                                } catch (Error e13) {
                                    e = e13;
                                    throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                } catch (RuntimeException e14) {
                                    e = e14;
                                    throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RetryPauseTime);
                                throw th;
                                break;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            httpResponse = httpResponse6;
                        }
                    } catch (IOException e15) {
                        e = e15;
                        httpResponse = httpResponse6;
                    } catch (Error e16) {
                        e = e16;
                        throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                    } catch (RuntimeException e17) {
                        e = e17;
                        throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                    } catch (Throwable th7) {
                        th = th7;
                        obj2 = "Cannot close the response content.";
                        z12 = z11;
                        obj = obj2;
                        if (!z12) {
                        }
                    }
                } else {
                    httpResponse = httpResponse6;
                }
                long j12 = j11;
                try {
                    try {
                        request.addHeader(HEADER_SDK_RETRY_INFO, i10 + "/" + j12);
                        if (signer3 == null) {
                            try {
                                signer3 = executionContext2.getSignerByURI(request.getEndpoint());
                            } catch (IOException e18) {
                                e = e18;
                                j11 = j12;
                                obj3 = "Cannot close the response content.";
                                signer = signer3;
                                linkedHashMap = linkedHashMap2;
                                obj4 = obj3;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                }
                                MetricType metricType32 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType32);
                                awsRequestMetrics.addProperty(metricType32, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                }
                            }
                        }
                        signer2 = signer3;
                        if (signer2 != null && credentials != null) {
                            try {
                                MetricType metricType4 = AWSRequestMetrics.Field.RequestSigningTime;
                                awsRequestMetrics.startEvent(metricType4);
                                try {
                                    signer2.sign(request, credentials);
                                    awsRequestMetrics.endEvent(metricType4);
                                } catch (Throwable th8) {
                                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestSigningTime);
                                    throw th8;
                                    break;
                                }
                            } catch (IOException e19) {
                                e = e19;
                                j11 = j12;
                                obj8 = "Cannot close the response content.";
                                signer = signer2;
                                obj3 = obj8;
                                linkedHashMap = linkedHashMap2;
                                obj4 = obj3;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                }
                                MetricType metricType322 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType322);
                                awsRequestMetrics.addProperty(metricType322, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                }
                            }
                        }
                        Log log3 = REQUEST_LOG;
                        if (log3.isDebugEnabled()) {
                            log3.debug("Sending Request: " + request.toString());
                        }
                        createHttpRequest = this.requestFactory.createHttpRequest(request, this.config, executionContext2);
                        try {
                            metricType = AWSRequestMetrics.Field.HttpRequestTime;
                            awsRequestMetrics.startEvent(metricType);
                        } catch (IOException e20) {
                            e = e20;
                            j11 = j12;
                            obj6 = "Cannot close the response content.";
                            httpRequest = createHttpRequest;
                            signer = signer2;
                            linkedHashMap = linkedHashMap2;
                        }
                    } catch (Throwable th9) {
                        th2 = th9;
                        obj4 = "Cannot close the response content.";
                        th = th2;
                        obj5 = obj4;
                        z12 = z11;
                        httpResponse6 = httpResponse;
                        obj = obj5;
                        if (!z12) {
                        }
                    }
                } catch (IOException e21) {
                    e = e21;
                    j11 = j12;
                    obj4 = "Cannot close the response content.";
                    linkedHashMap = linkedHashMap2;
                    signer = signer3;
                }
                try {
                    HttpResponse execute = this.httpClient.execute(createHttpRequest);
                    try {
                        try {
                            awsRequestMetrics.endEvent(metricType);
                        } catch (IOException e22) {
                            e = e22;
                            j11 = j12;
                        }
                        if (isRequestSuccessful(execute)) {
                            try {
                                try {
                                    j11 = j12;
                                    try {
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(execute.getStatusCode()));
                                        z12 = httpResponseHandler.needsConnectionLeftOpen();
                                    } catch (IOException e23) {
                                        e = e23;
                                    }
                                } catch (IOException e24) {
                                    e = e24;
                                    j11 = j12;
                                }
                            } catch (Error e25) {
                                e = e25;
                                throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                            } catch (RuntimeException e26) {
                                e = e26;
                                throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                            } catch (Throwable th10) {
                                th = th10;
                                obj2 = "Cannot close the response content.";
                                httpResponse6 = execute;
                                z12 = z11;
                                obj = obj2;
                                if (!z12) {
                                }
                            }
                            try {
                                Response<T> response = new Response<>(handleResponse(request, httpResponseHandler, execute, executionContext2), execute);
                                if (!z12) {
                                    try {
                                        if (execute.getRawContent() != null) {
                                            execute.getRawContent().close();
                                        }
                                    } catch (IOException e27) {
                                        log.warn("Cannot close the response content.", e27);
                                    }
                                }
                                return response;
                            } catch (IOException e28) {
                                e = e28;
                                z11 = z12;
                                obj8 = "Cannot close the response content.";
                                httpResponse = execute;
                                httpRequest2 = createHttpRequest;
                                signer = signer2;
                                obj3 = obj8;
                                linkedHashMap = linkedHashMap2;
                                obj4 = obj3;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                }
                                MetricType metricType3222 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType3222);
                                awsRequestMetrics.addProperty(metricType3222, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                }
                            } catch (Error e29) {
                                e = e29;
                                throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                            } catch (RuntimeException e30) {
                                e = e30;
                                throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                            } catch (Throwable th11) {
                                th = th11;
                                obj = "Cannot close the response content.";
                                httpResponse6 = execute;
                                if (!z12) {
                                }
                            }
                        } else {
                            j11 = j12;
                            try {
                                if (isTemporaryRedirect(execute)) {
                                    try {
                                        String str = execute.getHeaders().get("Location");
                                        Log log4 = log;
                                        StringBuilder sb = new StringBuilder();
                                        obj9 = "Cannot close the response content.";
                                        try {
                                            sb.append("Redirecting to: ");
                                            sb.append(str);
                                            log4.debug(sb.toString());
                                            uri = URI.create(str);
                                            request.setEndpoint(null);
                                            request.setResourcePath(null);
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(execute.getStatusCode()));
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.RedirectLocation, str);
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                            httpRequest = createHttpRequest;
                                            signer = signer2;
                                            z10 = z11;
                                            obj10 = obj9;
                                            amazonClientException2 = null;
                                            linkedHashMap = linkedHashMap2;
                                            httpResponse5 = execute;
                                        } catch (IOException e31) {
                                            e = e31;
                                            httpResponse = execute;
                                            httpRequest2 = createHttpRequest;
                                            signer = signer2;
                                            obj3 = obj9;
                                            linkedHashMap = linkedHashMap2;
                                            obj4 = obj3;
                                            log2 = log;
                                            if (log2.isDebugEnabled()) {
                                            }
                                            MetricType metricType32222 = AWSRequestMetrics.Field.Exception;
                                            awsRequestMetrics.incrementCounter(metricType32222);
                                            awsRequestMetrics.addProperty(metricType32222, e);
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                            amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                            if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                            }
                                        } catch (Error e32) {
                                            e = e32;
                                            throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                        } catch (RuntimeException e33) {
                                            e = e33;
                                            throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                        } catch (Throwable th12) {
                                            th = th12;
                                            th = th;
                                            httpResponse6 = execute;
                                            z12 = z11;
                                            obj = obj9;
                                            if (!z12) {
                                            }
                                        }
                                    } catch (IOException e34) {
                                        e = e34;
                                        obj9 = "Cannot close the response content.";
                                    } catch (Error e35) {
                                        e = e35;
                                        obj9 = "Cannot close the response content.";
                                    } catch (RuntimeException e36) {
                                        e = e36;
                                        obj9 = "Cannot close the response content.";
                                    } catch (Throwable th13) {
                                        th = th13;
                                        obj9 = "Cannot close the response content.";
                                    }
                                } else {
                                    try {
                                        boolean needsConnectionLeftOpen = httpResponseHandler2.needsConnectionLeftOpen();
                                        try {
                                            AmazonServiceException handleErrorResponse = handleErrorResponse(request, httpResponseHandler2, execute);
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, handleErrorResponse.getRequestId());
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSErrorCode, handleErrorResponse.getErrorCode());
                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(handleErrorResponse.getStatusCode()));
                                            obj6 = "Cannot close the response content.";
                                            linkedHashMap = linkedHashMap2;
                                            httpResponse5 = execute;
                                            httpRequest = createHttpRequest;
                                            signer = signer2;
                                            try {
                                                if (shouldRetry(request.getOriginalRequest(), createHttpRequest.getContent(), handleErrorResponse, i11, this.config.getRetryPolicy())) {
                                                    if (RetryUtils.isClockSkewError(handleErrorResponse)) {
                                                        SDKGlobalConfiguration.setGlobalTimeOffset(parseClockSkewOffset(httpResponse5, handleErrorResponse));
                                                    }
                                                    resetRequestAfterError(request, handleErrorResponse);
                                                    amazonClientException2 = handleErrorResponse;
                                                    z10 = needsConnectionLeftOpen;
                                                    obj10 = obj6;
                                                } else {
                                                    throw handleErrorResponse;
                                                    break;
                                                }
                                            } catch (IOException e37) {
                                                e = e37;
                                                httpResponse = httpResponse5;
                                                z11 = needsConnectionLeftOpen;
                                                httpRequest2 = httpRequest;
                                                obj4 = obj6;
                                                log2 = log;
                                                if (log2.isDebugEnabled()) {
                                                }
                                                MetricType metricType322222 = AWSRequestMetrics.Field.Exception;
                                                awsRequestMetrics.incrementCounter(metricType322222);
                                                awsRequestMetrics.addProperty(metricType322222, e);
                                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                                }
                                            } catch (Error e38) {
                                                e = e38;
                                                throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                            } catch (RuntimeException e39) {
                                                e = e39;
                                                throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                            } catch (Throwable th14) {
                                                th = th14;
                                                th = th;
                                                httpResponse6 = httpResponse5;
                                                z12 = needsConnectionLeftOpen;
                                                obj = obj6;
                                                if (!z12) {
                                                }
                                            }
                                        } catch (IOException e40) {
                                            e = e40;
                                            httpRequest = createHttpRequest;
                                            signer = signer2;
                                            obj6 = "Cannot close the response content.";
                                            linkedHashMap = linkedHashMap2;
                                            httpResponse5 = execute;
                                        } catch (Error e41) {
                                            e = e41;
                                            httpResponse5 = execute;
                                        } catch (RuntimeException e42) {
                                            e = e42;
                                            httpResponse5 = execute;
                                        } catch (Throwable th15) {
                                            th = th15;
                                            httpResponse5 = execute;
                                            obj6 = "Cannot close the response content.";
                                        }
                                    } catch (IOException e43) {
                                        e = e43;
                                        httpRequest = createHttpRequest;
                                        signer = signer2;
                                        obj6 = "Cannot close the response content.";
                                        linkedHashMap = linkedHashMap2;
                                        httpResponse = execute;
                                        httpRequest2 = httpRequest;
                                        obj4 = obj6;
                                        log2 = log;
                                        if (log2.isDebugEnabled()) {
                                        }
                                        MetricType metricType3222222 = AWSRequestMetrics.Field.Exception;
                                        awsRequestMetrics.incrementCounter(metricType3222222);
                                        awsRequestMetrics.addProperty(metricType3222222, e);
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                        amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                        if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                        }
                                    } catch (Error e44) {
                                        e = e44;
                                        httpResponse4 = execute;
                                        throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                    } catch (RuntimeException e45) {
                                        e = e45;
                                        httpResponse3 = execute;
                                        throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                    } catch (Throwable th16) {
                                        th = th16;
                                        httpResponse2 = execute;
                                        obj7 = "Cannot close the response content.";
                                        th = th;
                                        httpResponse6 = httpResponse2;
                                        obj2 = obj7;
                                        z12 = z11;
                                        obj = obj2;
                                        if (!z12) {
                                        }
                                    }
                                }
                                if (!z10 && httpResponse5 != null) {
                                    try {
                                        if (httpResponse5.getRawContent() != null) {
                                            httpResponse5.getRawContent().close();
                                        }
                                    } catch (IOException e46) {
                                        log.warn(obj10, e46);
                                    }
                                }
                                amazonClientException3 = amazonClientException2;
                                httpResponse6 = httpResponse5;
                                j10 = j11;
                                httpRequest2 = httpRequest;
                                signer3 = signer;
                            } catch (IOException e47) {
                                e = e47;
                                obj6 = "Cannot close the response content.";
                                httpRequest = createHttpRequest;
                                signer = signer2;
                                linkedHashMap = linkedHashMap2;
                                httpResponse = execute;
                                httpRequest2 = httpRequest;
                                obj4 = obj6;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                }
                                MetricType metricType32222222 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType32222222);
                                awsRequestMetrics.addProperty(metricType32222222, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                                }
                            }
                            executionContext2 = executionContext;
                            i10 = i11;
                            linkedHashMap2 = linkedHashMap;
                        }
                    } catch (Error e48) {
                        e = e48;
                        httpResponse4 = execute;
                    } catch (RuntimeException e49) {
                        e = e49;
                        httpResponse3 = execute;
                    } catch (Throwable th17) {
                        th = th17;
                        obj7 = "Cannot close the response content.";
                        httpResponse2 = execute;
                    }
                } catch (Throwable th18) {
                    j11 = j12;
                    obj6 = "Cannot close the response content.";
                    httpRequest = createHttpRequest;
                    signer = signer2;
                    linkedHashMap = linkedHashMap2;
                    try {
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpRequestTime);
                        throw th18;
                        break;
                    } catch (IOException e50) {
                        e = e50;
                        httpRequest2 = httpRequest;
                        obj4 = obj6;
                        log2 = log;
                        if (log2.isDebugEnabled()) {
                        }
                        MetricType metricType322222222 = AWSRequestMetrics.Field.Exception;
                        awsRequestMetrics.incrementCounter(metricType322222222);
                        awsRequestMetrics.addProperty(metricType322222222, e);
                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                        amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                        if (shouldRetry(request.getOriginalRequest(), httpRequest2.getContent(), amazonClientException, i11, this.config.getRetryPolicy())) {
                        }
                    } catch (Error e51) {
                        e = e51;
                        throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                    } catch (RuntimeException e52) {
                        e = e52;
                        throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                    }
                }
            } catch (Throwable th19) {
                th = th19;
                obj = executionContext2;
            }
        }
    }

    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e10) {
            if (statusCode == HTTP_STATUS_REQ_TOO_LONG) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_REQ_TOO_LONG);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == 503 && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                if (e10 instanceof IOException) {
                    throw ((IOException) e10);
                }
                throw new AmazonClientException("Unable to unmarshall error response (" + e10.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e10);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            awsRequestMetrics.startEvent(field);
            try {
                AmazonWebServiceResponse<T> handle = httpResponseHandler.handle(httpResponse);
                awsRequestMetrics.endEvent(field);
                if (handle != null) {
                    Log log2 = REQUEST_LOG;
                    if (log2.isDebugEnabled()) {
                        log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + handle.getRequestId());
                    }
                    awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, handle.getRequestId());
                    return handle.getResult();
                }
                throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
            } catch (Throwable th) {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (CRC32MismatchException e10) {
            throw e10;
        } catch (IOException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new AmazonClientException("Unable to unmarshall response (" + e12.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    int parseClockSkewOffset(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date parseRFC822Date;
        Date date = new Date();
        String str = httpResponse.getHeaders().get("Date");
        try {
            if (str != 0) {
                try {
                    if (!str.isEmpty()) {
                        parseRFC822Date = DateUtils.parseRFC822Date(str);
                        str = (int) ((date.getTime() - parseRFC822Date.getTime()) / 1000);
                        return str;
                    }
                } catch (RuntimeException e10) {
                    e = e10;
                    str = 0;
                    log.warn("Unable to parse clock skew offset from response: " + str, e);
                    return 0;
                }
            }
            parseRFC822Date = DateUtils.parseCompressedISO8601Date(getServerDateFromException(amazonServiceException.getMessage()));
            str = (int) ((date.getTime() - parseRFC822Date.getTime()) / 1000);
            return str;
        } catch (RuntimeException e11) {
            e = e11;
        }
    }

    List<RequestHandler2> requestHandler2s(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    void resetRequestAfterError(Request<?> request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (request.getContent().markSupported()) {
            try {
                request.getContent().reset();
                return;
            } catch (IOException unused) {
                throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
            }
        }
        throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
    }

    void setUserAgent(Request<?> request) {
        String str;
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str2 = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && (requestClientOptions = originalRequest.getRequestClientOptions()) != null && (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) != null) {
            str = createUserAgentString(str2, clientMarker);
        } else {
            str = str2;
        }
        if (!str2.equals(this.config.getUserAgent())) {
            str = createUserAgentString(str, this.config.getUserAgent());
        }
        request.addHeader("User-Agent", str);
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }
}
