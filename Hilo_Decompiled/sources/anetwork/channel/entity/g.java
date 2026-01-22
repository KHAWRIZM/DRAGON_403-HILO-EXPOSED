package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.util.RequestConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public RequestStatistic f٥٢٢٥b;

    /* renamed from: c, reason: collision with root package name */
    public final int f٥٢٢٦c;

    /* renamed from: d, reason: collision with root package name */
    public final int f٥٢٢٧d;

    /* renamed from: e, reason: collision with root package name */
    public final String f٥٢٢٨e;

    /* renamed from: f, reason: collision with root package name */
    public final int f٥٢٢٩f;

    /* renamed from: g, reason: collision with root package name */
    private ParcelableRequest f٥٢٣٠g;

    /* renamed from: h, reason: collision with root package name */
    private Request f٥٢٣١h;

    /* renamed from: j, reason: collision with root package name */
    private int f٥٢٣٣j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f٥٢٣٤k;

    /* renamed from: i, reason: collision with root package name */
    private int f٥٢٣٢i = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f٥٢٢٤a = 0;

    public g(ParcelableRequest parcelableRequest, int i10, boolean z10) {
        String str;
        this.f٥٢٣١h = null;
        this.f٥٢٣٣j = 0;
        if (parcelableRequest != null) {
            this.f٥٢٣٠g = parcelableRequest;
            this.f٥٢٢٩f = i10;
            this.f٥٢٣٤k = z10;
            String str2 = parcelableRequest.seqNo;
            if (i10 == 0) {
                str = "HTTP";
            } else {
                str = "DGRD";
            }
            this.f٥٢٢٨e = anetwork.channel.util.a.a(str2, str);
            int i11 = parcelableRequest.connectTimeout;
            this.f٥٢٢٦c = i11 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i11;
            int i12 = parcelableRequest.readTimeout;
            this.f٥٢٢٧d = i12 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i12;
            int i13 = parcelableRequest.retryTime;
            this.f٥٢٣٣j = (i13 < 0 || i13 > 3) ? 2 : i13;
            HttpUrl l10 = l();
            RequestStatistic requestStatistic = new RequestStatistic(l10.host(), String.valueOf(parcelableRequest.bizId));
            this.f٥٢٢٥b = requestStatistic;
            requestStatistic.url = l10.simpleUrlString();
            this.f٥٢٣١h = b(l10);
            return;
        }
        throw new IllegalArgumentException("request is null");
    }

    private Request b(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.f٥٢٣٠g.method).setBody(this.f٥٢٣٠g.bodyEntry).setReadTimeout(this.f٥٢٢٧d).setConnectTimeout(this.f٥٢٢٦c).setRedirectEnable(this.f٥٢٣٠g.allowRedirect).setRedirectTimes(this.f٥٢٣٢i).setBizId(this.f٥٢٣٠g.bizId).setSeq(this.f٥٢٢٨e).setRequestStatistic(this.f٥٢٢٥b);
        requestStatistic.setParams(this.f٥٢٣٠g.params);
        String str = this.f٥٢٣٠g.charset;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(c(httpUrl));
        return requestStatistic.build();
    }

    private HttpUrl l() {
        HttpUrl parse = HttpUrl.parse(this.f٥٢٣٠g.url);
        if (parse != null) {
            if (!NetworkConfigCenter.isSSLEnabled()) {
                ALog.i("anet.RequestConfig", "request ssl disabled.", this.f٥٢٢٨e, new Object[0]);
                parse.downgradeSchemeAndLock();
            } else if (RequestConstant.FALSE.equalsIgnoreCase(this.f٥٢٣٠g.getExtProperty(RequestConstant.ENABLE_SCHEME_REPLACE))) {
                parse.lockScheme();
            }
            return parse;
        }
        throw new IllegalArgumentException("url is invalid. url=" + this.f٥٢٣٠g.url);
    }

    public Request a() {
        return this.f٥٢٣١h;
    }

    public boolean c() {
        return this.f٥٢٣٤k;
    }

    public boolean d() {
        if (this.f٥٢٢٤a < this.f٥٢٣٣j) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (NetworkConfigCenter.isHttpSessionEnable() && !RequestConstant.FALSE.equalsIgnoreCase(this.f٥٢٣٠g.getExtProperty(RequestConstant.ENABLE_HTTP_DNS)) && (NetworkConfigCenter.isAllowHttpIpRetry() || this.f٥٢٢٤a == 0)) {
            return true;
        }
        return false;
    }

    public HttpUrl f() {
        return this.f٥٢٣١h.getHttpUrl();
    }

    public String g() {
        return this.f٥٢٣١h.getUrlString();
    }

    public Map<String, String> h() {
        return this.f٥٢٣١h.getHeaders();
    }

    public boolean i() {
        return !RequestConstant.FALSE.equalsIgnoreCase(this.f٥٢٣٠g.getExtProperty(RequestConstant.ENABLE_COOKIE));
    }

    public boolean j() {
        return "true".equals(this.f٥٢٣٠g.getExtProperty(RequestConstant.CHECK_CONTENT_LENGTH));
    }

    public void k() {
        int i10 = this.f٥٢٢٤a + 1;
        this.f٥٢٢٤a = i10;
        this.f٥٢٢٥b.retryTimes = i10;
    }

    private Map<String, String> c(HttpUrl httpUrl) {
        String host = httpUrl.host();
        boolean z10 = !anet.channel.strategy.utils.c.a(host);
        if (host.length() > 2 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']' && anet.channel.strategy.utils.c.b(host.substring(1, host.length() - 1))) {
            z10 = false;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f٥٢٣٠g.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!"Host".equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean equalsIgnoreCase = "true".equalsIgnoreCase(this.f٥٢٣٠g.getExtProperty(RequestConstant.KEEP_CUSTOM_COOKIE));
                    if (!HttpConstant.COOKIE.equalsIgnoreCase(key) || equalsIgnoreCase) {
                        hashMap.put(key, entry.getValue());
                    }
                } else if (!z10) {
                    hashMap.put("Host", entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public void a(Request request) {
        this.f٥٢٣١h = request;
    }

    public String a(String str) {
        return this.f٥٢٣٠g.getExtProperty(str);
    }

    public void a(HttpUrl httpUrl) {
        ALog.i("anet.RequestConfig", "redirect", this.f٥٢٢٨e, "to url", httpUrl.toString());
        this.f٥٢٣٢i++;
        this.f٥٢٢٥b.url = httpUrl.simpleUrlString();
        this.f٥٢٣١h = b(httpUrl);
    }

    public int b() {
        return this.f٥٢٢٧d * (this.f٥٢٣٣j + 1);
    }
}
