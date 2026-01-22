package com.liulishuo.okdownload.core.connection;

import com.liulishuo.okdownload.IRedirectHandler;
import com.liulishuo.okdownload.RedirectUtil;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadUrlConnection implements DownloadConnection, DownloadConnection.Connected {
    private static final String TAG = "DownloadUrlConnection";
    private Configuration configuration;
    protected URLConnection connection;
    private IRedirectHandler redirectHandler;
    private URL url;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Configuration {
        private Integer connectTimeout;
        private Proxy proxy;
        private Integer readTimeout;

        public Configuration connectTimeout(int i10) {
            this.connectTimeout = Integer.valueOf(i10);
            return this;
        }

        public Configuration proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Configuration readTimeout(int i10) {
            this.readTimeout = Integer.valueOf(i10);
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Factory implements DownloadConnection.Factory {
        private final Configuration configuration;

        public Factory() {
            this(null);
        }

        public DownloadConnection create(URL url) {
            return new DownloadUrlConnection(url, this.configuration);
        }

        public Factory(Configuration configuration) {
            this.configuration = configuration;
        }

        @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) {
            return new DownloadUrlConnection(str, this.configuration);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class RedirectHandler implements IRedirectHandler {
        String redirectLocation;

        @Override // com.liulishuo.okdownload.IRedirectHandler
        public String getRedirectLocation() {
            return this.redirectLocation;
        }

        @Override // com.liulishuo.okdownload.IRedirectHandler
        public void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map<String, List<String>> map) {
            DownloadUrlConnection downloadUrlConnection = (DownloadUrlConnection) downloadConnection;
            int i10 = 0;
            for (int responseCode = connected.getResponseCode(); RedirectUtil.isRedirect(responseCode); responseCode = downloadUrlConnection.getResponseCode()) {
                downloadUrlConnection.release();
                i10++;
                if (i10 <= 10) {
                    this.redirectLocation = RedirectUtil.getRedirectedUrl(connected, responseCode);
                    downloadUrlConnection.url = new URL(this.redirectLocation);
                    downloadUrlConnection.configUrlConnection();
                    Util.addRequestHeaderFields(map, downloadUrlConnection);
                    downloadUrlConnection.connection.connect();
                } else {
                    throw new ProtocolException("Too many redirect requests: " + i10);
                }
            }
        }
    }

    public DownloadUrlConnection(URLConnection uRLConnection) {
        this(uRLConnection, new RedirectHandler());
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        this.connection.addRequestProperty(str, str2);
    }

    public void configUrlConnection() {
        Proxy proxy;
        Util.d(TAG, "config connection for " + this.url);
        Configuration configuration = this.configuration;
        if (configuration != null && (proxy = configuration.proxy) != null) {
            this.connection = this.url.openConnection(proxy);
        } else {
            this.connection = this.url.openConnection();
        }
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        Configuration configuration2 = this.configuration;
        if (configuration2 != null) {
            Integer num = configuration2.readTimeout;
            if (num != null) {
                this.connection.setReadTimeout(num.intValue());
            }
            Integer num2 = this.configuration.connectTimeout;
            if (num2 != null) {
                this.connection.setConnectTimeout(num2.intValue());
            }
        }
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() {
        Map<String, List<String>> requestProperties = getRequestProperties();
        this.connection.connect();
        this.redirectHandler.handleRedirect(this, this, requestProperties);
        return this;
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() {
        return this.connection.getInputStream();
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        return this.redirectHandler.getRedirectLocation();
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.connection.getRequestProperties();
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        return this.connection.getRequestProperty(str);
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        return this.connection.getHeaderField(str);
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.connection.getHeaderFields();
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public void release() {
        try {
            InputStream inputStream = this.connection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.liulishuo.okdownload.core.connection.DownloadConnection
    public boolean setRequestMethod(String str) {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setRequestMethod(str);
            return true;
        }
        return false;
    }

    public DownloadUrlConnection(URLConnection uRLConnection, IRedirectHandler iRedirectHandler) {
        this.connection = uRLConnection;
        this.url = uRLConnection.getURL();
        this.redirectHandler = iRedirectHandler;
    }

    public DownloadUrlConnection(String str, Configuration configuration) {
        this(new URL(str), configuration);
    }

    public DownloadUrlConnection(URL url, Configuration configuration) {
        this(url, configuration, new RedirectHandler());
    }

    public DownloadUrlConnection(URL url, Configuration configuration, IRedirectHandler iRedirectHandler) {
        this.configuration = configuration;
        this.url = url;
        this.redirectHandler = iRedirectHandler;
        configUrlConnection();
    }

    public DownloadUrlConnection(String str) {
        this(str, (Configuration) null);
    }
}
