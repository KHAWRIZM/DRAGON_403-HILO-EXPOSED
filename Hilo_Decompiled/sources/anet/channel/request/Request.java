package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* renamed from: a, reason: collision with root package name */
    public final RequestStatistic f٤٨٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private HttpUrl f٤٨٤٥b;

    /* renamed from: c, reason: collision with root package name */
    private HttpUrl f٤٨٤٦c;

    /* renamed from: d, reason: collision with root package name */
    private HttpUrl f٤٨٤٧d;

    /* renamed from: e, reason: collision with root package name */
    private URL f٤٨٤٨e;

    /* renamed from: f, reason: collision with root package name */
    private String f٤٨٤٩f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f٤٨٥٠g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f٤٨٥١h;

    /* renamed from: i, reason: collision with root package name */
    private String f٤٨٥٢i;

    /* renamed from: j, reason: collision with root package name */
    private BodyEntry f٤٨٥٣j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٤٨٥٤k;

    /* renamed from: l, reason: collision with root package name */
    private String f٤٨٥٥l;

    /* renamed from: m, reason: collision with root package name */
    private String f٤٨٥٦m;

    /* renamed from: n, reason: collision with root package name */
    private int f٤٨٥٧n;

    /* renamed from: o, reason: collision with root package name */
    private int f٤٨٥٨o;

    /* renamed from: p, reason: collision with root package name */
    private int f٤٨٥٩p;

    /* renamed from: q, reason: collision with root package name */
    private HostnameVerifier f٤٨٦٠q;

    /* renamed from: r, reason: collision with root package name */
    private SSLSocketFactory f٤٨٦١r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٤٨٦٢s;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private HttpUrl f٤٨٦٣a;

        /* renamed from: b, reason: collision with root package name */
        private HttpUrl f٤٨٦٤b;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f٤٨٦٧e;

        /* renamed from: f, reason: collision with root package name */
        private String f٤٨٦٨f;

        /* renamed from: g, reason: collision with root package name */
        private BodyEntry f٤٨٦٩g;

        /* renamed from: j, reason: collision with root package name */
        private HostnameVerifier f٤٨٧٢j;

        /* renamed from: k, reason: collision with root package name */
        private SSLSocketFactory f٤٨٧٣k;

        /* renamed from: l, reason: collision with root package name */
        private String f٤٨٧٤l;

        /* renamed from: m, reason: collision with root package name */
        private String f٤٨٧٥m;

        /* renamed from: q, reason: collision with root package name */
        private boolean f٤٨٧٩q;

        /* renamed from: c, reason: collision with root package name */
        private String f٤٨٦٥c = Method.GET;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f٤٨٦٦d = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        private boolean f٤٨٧٠h = true;

        /* renamed from: i, reason: collision with root package name */
        private int f٤٨٧١i = 0;

        /* renamed from: n, reason: collision with root package name */
        private int f٤٨٧٦n = 10000;

        /* renamed from: o, reason: collision with root package name */
        private int f٤٨٧٧o = 10000;

        /* renamed from: p, reason: collision with root package name */
        private RequestStatistic f٤٨٧٨p = null;

        public Builder addHeader(String str, String str2) {
            this.f٤٨٦٦d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f٤٨٦٧e == null) {
                this.f٤٨٦٧e = new HashMap();
            }
            this.f٤٨٦٧e.put(str, str2);
            this.f٤٨٦٤b = null;
            return this;
        }

        public Request build() {
            if (this.f٤٨٦٩g == null && this.f٤٨٦٧e == null && Method.a(this.f٤٨٦٥c)) {
                ALog.e("awcn.Request", "method " + this.f٤٨٦٥c + " must have a request body", null, new Object[0]);
            }
            if (this.f٤٨٦٩g != null && !Method.b(this.f٤٨٦٥c)) {
                ALog.e("awcn.Request", "method " + this.f٤٨٦٥c + " should not have a request body", null, new Object[0]);
                this.f٤٨٦٩g = null;
            }
            BodyEntry bodyEntry = this.f٤٨٦٩g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f٤٨٦٩g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z10) {
            this.f٤٨٧٩q = z10;
            return this;
        }

        public Builder setBizId(String str) {
            this.f٤٨٧٤l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f٤٨٦٩g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f٤٨٦٨f = str;
            this.f٤٨٦٤b = null;
            return this;
        }

        public Builder setConnectTimeout(int i10) {
            if (i10 > 0) {
                this.f٤٨٧٦n = i10;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f٤٨٦٦d.clear();
            if (map != null) {
                this.f٤٨٦٦d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f٤٨٧٢j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (Method.GET.equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = Method.GET;
                } else if (Method.POST.equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = Method.POST;
                } else if (Method.OPTION.equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = Method.OPTION;
                } else if ("HEAD".equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = "HEAD";
                } else if (Method.PUT.equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = Method.PUT;
                } else if (Method.DELETE.equalsIgnoreCase(str)) {
                    this.f٤٨٦٥c = Method.DELETE;
                } else {
                    this.f٤٨٦٥c = Method.GET;
                }
                return this;
            }
            throw new IllegalArgumentException("method is null or empty");
        }

        public Builder setParams(Map<String, String> map) {
            this.f٤٨٦٧e = map;
            this.f٤٨٦٤b = null;
            return this;
        }

        public Builder setReadTimeout(int i10) {
            if (i10 > 0) {
                this.f٤٨٧٧o = i10;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z10) {
            this.f٤٨٧٠h = z10;
            return this;
        }

        public Builder setRedirectTimes(int i10) {
            this.f٤٨٧١i = i10;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.f٤٨٧٨p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f٤٨٧٥m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f٤٨٧٣k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f٤٨٦٣a = httpUrl;
            this.f٤٨٦٤b = null;
            return this;
        }

        public Builder setUrl(String str) {
            HttpUrl parse = HttpUrl.parse(str);
            this.f٤٨٦٣a = parse;
            this.f٤٨٦٤b = null;
            if (parse != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            if (!str.equals(POST) && !str.equals(PUT)) {
                return false;
            }
            return true;
        }

        static boolean b(String str) {
            if (!a(str) && !str.equals(DELETE) && !str.equals(OPTION)) {
                return false;
            }
            return true;
        }
    }

    private Map<String, String> a() {
        if (AwcnConfig.isCookieHeaderRedundantFix()) {
            return new HashMap(this.f٤٨٥٠g);
        }
        return this.f٤٨٥٠g;
    }

    private void b() {
        String a10 = anet.channel.strategy.utils.c.a(this.f٤٨٥١h, getContentEncoding());
        if (!TextUtils.isEmpty(a10)) {
            if (Method.a(this.f٤٨٤٩f) && this.f٤٨٥٣j == null) {
                try {
                    this.f٤٨٥٣j = new ByteArrayEntry(a10.getBytes(getContentEncoding()));
                    this.f٤٨٥٠g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String urlString = this.f٤٨٤٥b.urlString();
                StringBuilder sb = new StringBuilder(urlString);
                if (sb.indexOf("?") == -1) {
                    sb.append('?');
                } else if (urlString.charAt(urlString.length() - 1) != '&') {
                    sb.append(Typography.amp);
                }
                sb.append(a10);
                HttpUrl parse = HttpUrl.parse(sb.toString());
                if (parse != null) {
                    this.f٤٨٤٦c = parse;
                }
            }
        }
        if (this.f٤٨٤٦c == null) {
            this.f٤٨٤٦c = this.f٤٨٤٥b;
        }
    }

    public boolean containsBody() {
        if (this.f٤٨٥٣j != null) {
            return true;
        }
        return false;
    }

    public String getBizId() {
        return this.f٤٨٥٥l;
    }

    public byte[] getBodyBytes() {
        if (this.f٤٨٥٣j != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
            try {
                postBody(byteArrayOutputStream);
            } catch (IOException unused) {
            }
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public int getConnectTimeout() {
        return this.f٤٨٥٨o;
    }

    public String getContentEncoding() {
        String str = this.f٤٨٥٢i;
        if (str == null) {
            return "UTF-8";
        }
        return str;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f٤٨٥٠g);
    }

    public String getHost() {
        return this.f٤٨٤٦c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f٤٨٦٠q;
    }

    public HttpUrl getHttpUrl() {
        return this.f٤٨٤٦c;
    }

    public String getMethod() {
        return this.f٤٨٤٩f;
    }

    public int getReadTimeout() {
        return this.f٤٨٥٩p;
    }

    public int getRedirectTimes() {
        return this.f٤٨٥٧n;
    }

    public String getSeq() {
        return this.f٤٨٥٦m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f٤٨٦١r;
    }

    public URL getUrl() {
        if (this.f٤٨٤٨e == null) {
            HttpUrl httpUrl = this.f٤٨٤٧d;
            if (httpUrl == null) {
                httpUrl = this.f٤٨٤٦c;
            }
            this.f٤٨٤٨e = httpUrl.toURL();
        }
        return this.f٤٨٤٨e;
    }

    public String getUrlString() {
        return this.f٤٨٤٦c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.f٤٨٦٢s;
    }

    public boolean isRedirectEnable() {
        return this.f٤٨٥٤k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f٤٨٦٥c = this.f٤٨٤٩f;
        builder.f٤٨٦٦d = a();
        builder.f٤٨٦٧e = this.f٤٨٥١h;
        builder.f٤٨٦٩g = this.f٤٨٥٣j;
        builder.f٤٨٦٨f = this.f٤٨٥٢i;
        builder.f٤٨٧٠h = this.f٤٨٥٤k;
        builder.f٤٨٧١i = this.f٤٨٥٧n;
        builder.f٤٨٧٢j = this.f٤٨٦٠q;
        builder.f٤٨٧٣k = this.f٤٨٦١r;
        builder.f٤٨٦٣a = this.f٤٨٤٥b;
        builder.f٤٨٦٤b = this.f٤٨٤٦c;
        builder.f٤٨٧٤l = this.f٤٨٥٥l;
        builder.f٤٨٧٥m = this.f٤٨٥٦m;
        builder.f٤٨٧٦n = this.f٤٨٥٨o;
        builder.f٤٨٧٧o = this.f٤٨٥٩p;
        builder.f٤٨٧٨p = this.f٤٨٤٤a;
        builder.f٤٨٧٩q = this.f٤٨٦٢s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.f٤٨٥٣j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i10) {
        if (str != null) {
            if (this.f٤٨٤٧d == null) {
                this.f٤٨٤٧d = new HttpUrl(this.f٤٨٤٦c);
            }
            this.f٤٨٤٧d.replaceIpAndPort(str, i10);
        } else {
            this.f٤٨٤٧d = null;
        }
        this.f٤٨٤٨e = null;
        this.f٤٨٤٤a.setIPAndPort(str, i10);
    }

    public void setUrlScheme(boolean z10) {
        String str;
        if (this.f٤٨٤٧d == null) {
            this.f٤٨٤٧d = new HttpUrl(this.f٤٨٤٦c);
        }
        HttpUrl httpUrl = this.f٤٨٤٧d;
        if (z10) {
            str = HttpConstant.HTTPS;
        } else {
            str = HttpConstant.HTTP;
        }
        httpUrl.setScheme(str);
        this.f٤٨٤٨e = null;
    }

    private Request(Builder builder) {
        this.f٤٨٤٩f = Method.GET;
        this.f٤٨٥٤k = true;
        this.f٤٨٥٧n = 0;
        this.f٤٨٥٨o = 10000;
        this.f٤٨٥٩p = 10000;
        this.f٤٨٤٩f = builder.f٤٨٦٥c;
        this.f٤٨٥٠g = builder.f٤٨٦٦d;
        this.f٤٨٥١h = builder.f٤٨٦٧e;
        this.f٤٨٥٣j = builder.f٤٨٦٩g;
        this.f٤٨٥٢i = builder.f٤٨٦٨f;
        this.f٤٨٥٤k = builder.f٤٨٧٠h;
        this.f٤٨٥٧n = builder.f٤٨٧١i;
        this.f٤٨٦٠q = builder.f٤٨٧٢j;
        this.f٤٨٦١r = builder.f٤٨٧٣k;
        this.f٤٨٥٥l = builder.f٤٨٧٤l;
        this.f٤٨٥٦m = builder.f٤٨٧٥m;
        this.f٤٨٥٨o = builder.f٤٨٧٦n;
        this.f٤٨٥٩p = builder.f٤٨٧٧o;
        this.f٤٨٤٥b = builder.f٤٨٦٣a;
        HttpUrl httpUrl = builder.f٤٨٦٤b;
        this.f٤٨٤٦c = httpUrl;
        if (httpUrl == null) {
            b();
        }
        this.f٤٨٤٤a = builder.f٤٨٧٨p != null ? builder.f٤٨٧٨p : new RequestStatistic(getHost(), this.f٤٨٥٥l);
        this.f٤٨٦٢s = builder.f٤٨٧٩q;
    }
}
