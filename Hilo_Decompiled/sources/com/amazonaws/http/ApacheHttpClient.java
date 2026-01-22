package com.amazonaws.http;

import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ApacheHttpClient implements HttpClient {
    private final org.apache.http.client.HttpClient httpClient;
    private HttpParams params = null;

    public ApacheHttpClient(ClientConfiguration clientConfiguration) {
        org.apache.http.client.HttpClient createHttpClient = new HttpClientFactory().createHttpClient(clientConfiguration);
        this.httpClient = createHttpClient;
        ((AbstractHttpClient) createHttpClient).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        ((SSLSocketFactory) createHttpClient.getConnectionManager().getSchemeRegistry().getScheme(HttpConstant.HTTPS).getSocketFactory()).setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private HttpUriRequest createHttpRequest(HttpRequest httpRequest) {
        HttpRequestBase httpRequestBase;
        String method = httpRequest.getMethod();
        if (Request.Method.POST.equals(method)) {
            HttpPost httpPost = new HttpPost(httpRequest.getUri());
            httpRequestBase = httpPost;
            if (httpRequest.getContent() != null) {
                httpPost.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpRequestBase = httpPost;
            }
        } else if (Request.Method.GET.equals(method)) {
            httpRequestBase = new HttpGet(httpRequest.getUri());
        } else if (Request.Method.PUT.equals(method)) {
            HttpPut httpPut = new HttpPut(httpRequest.getUri());
            httpRequestBase = httpPut;
            if (httpRequest.getContent() != null) {
                httpPut.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpRequestBase = httpPut;
            }
        } else if (Request.Method.DELETE.equals(method)) {
            httpRequestBase = new HttpDelete(httpRequest.getUri());
        } else if ("HEAD".equals(method)) {
            httpRequestBase = new HttpHead(httpRequest.getUri());
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + method);
        }
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals("Host")) {
                    httpRequestBase.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.params == null) {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            this.params = basicHttpParams;
            basicHttpParams.setParameter("http.protocol.handle-redirects", Boolean.FALSE);
        }
        httpRequestBase.setParams(this.params);
        return httpRequestBase;
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        InputStream inputStream;
        org.apache.http.HttpResponse execute = this.httpClient.execute(createHttpRequest(httpRequest));
        String reasonPhrase = execute.getStatusLine().getReasonPhrase();
        int statusCode = execute.getStatusLine().getStatusCode();
        if (execute.getEntity() != null) {
            inputStream = execute.getEntity().getContent();
        } else {
            inputStream = null;
        }
        HttpResponse.Builder content = HttpResponse.builder().statusCode(statusCode).statusText(reasonPhrase).content(inputStream);
        for (Header header : execute.getAllHeaders()) {
            content.header(header.getName(), header.getValue());
        }
        return content.build();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
        this.httpClient.getConnectionManager().shutdown();
    }
}
