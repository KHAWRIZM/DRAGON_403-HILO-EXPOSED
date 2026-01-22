package anetwork.channel.entity;

import android.text.TextUtils;
import anet.channel.request.BodyEntry;
import anet.channel.request.Request;
import anet.channel.util.ALog;
import anetwork.channel.Header;
import anetwork.channel.IBodyHandler;
import anetwork.channel.Param;
import anetwork.channel.Request;
import anetwork.channel.util.RequestConstant;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RequestImpl implements Request {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private URI f٥١٩٠a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private URL f٥١٩١b;

    /* renamed from: c, reason: collision with root package name */
    private String f٥١٩٢c;

    /* renamed from: e, reason: collision with root package name */
    private List<Header> f٥١٩٤e;

    /* renamed from: g, reason: collision with root package name */
    private List<Param> f٥١٩٦g;

    /* renamed from: k, reason: collision with root package name */
    private int f٥٢٠٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f٥٢٠١l;

    /* renamed from: m, reason: collision with root package name */
    private String f٥٢٠٢m;

    /* renamed from: n, reason: collision with root package name */
    private String f٥٢٠٣n;

    /* renamed from: o, reason: collision with root package name */
    private Map<String, String> f٥٢٠٤o;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٥١٩٣d = true;

    /* renamed from: f, reason: collision with root package name */
    private String f٥١٩٥f = Request.Method.GET;

    /* renamed from: h, reason: collision with root package name */
    private int f٥١٩٧h = 2;

    /* renamed from: i, reason: collision with root package name */
    private String f٥١٩٨i = "utf-8";

    /* renamed from: j, reason: collision with root package name */
    private BodyEntry f٥١٩٩j = null;

    public RequestImpl() {
    }

    @Override // anetwork.channel.Request
    public void addHeader(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.f٥١٩٤e == null) {
                this.f٥١٩٤e = new ArrayList();
            }
            this.f٥١٩٤e.add(new BasicHeader(str, str2));
        }
    }

    @Override // anetwork.channel.Request
    public String getBizId() {
        return this.f٥٢٠٢m;
    }

    @Override // anetwork.channel.Request
    public BodyEntry getBodyEntry() {
        return this.f٥١٩٩j;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public IBodyHandler getBodyHandler() {
        return null;
    }

    @Override // anetwork.channel.Request
    public String getCharset() {
        return this.f٥١٩٨i;
    }

    @Override // anetwork.channel.Request
    public int getConnectTimeout() {
        return this.f٥٢٠٠k;
    }

    @Override // anetwork.channel.Request
    public Map<String, String> getExtProperties() {
        return this.f٥٢٠٤o;
    }

    @Override // anetwork.channel.Request
    public String getExtProperty(String str) {
        Map<String, String> map = this.f٥٢٠٤o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // anetwork.channel.Request
    public boolean getFollowRedirects() {
        return this.f٥١٩٣d;
    }

    @Override // anetwork.channel.Request
    public List<Header> getHeaders() {
        return this.f٥١٩٤e;
    }

    @Override // anetwork.channel.Request
    public String getMethod() {
        return this.f٥١٩٥f;
    }

    @Override // anetwork.channel.Request
    public List<Param> getParams() {
        return this.f٥١٩٦g;
    }

    @Override // anetwork.channel.Request
    public int getReadTimeout() {
        return this.f٥٢٠١l;
    }

    @Override // anetwork.channel.Request
    public int getRetryTime() {
        return this.f٥١٩٧h;
    }

    @Override // anetwork.channel.Request
    public String getSeqNo() {
        return this.f٥٢٠٣n;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URI getURI() {
        URI uri = this.f٥١٩٠a;
        if (uri != null) {
            return uri;
        }
        if (this.f٥١٩٢c != null) {
            try {
                this.f٥١٩٠a = new URI(this.f٥١٩٢c);
            } catch (Exception e10) {
                ALog.e("anet.RequestImpl", "uri error", this.f٥٢٠٣n, e10, new Object[0]);
            }
        }
        return this.f٥١٩٠a;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URL getURL() {
        URL url = this.f٥١٩١b;
        if (url != null) {
            return url;
        }
        if (this.f٥١٩٢c != null) {
            try {
                this.f٥١٩١b = new URL(this.f٥١٩٢c);
            } catch (Exception e10) {
                ALog.e("anet.RequestImpl", "url error", this.f٥٢٠٣n, e10, new Object[0]);
            }
        }
        return this.f٥١٩١b;
    }

    @Override // anetwork.channel.Request
    public String getUrlString() {
        return this.f٥١٩٢c;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public boolean isCookieEnabled() {
        return !RequestConstant.FALSE.equals(getExtProperty(RequestConstant.ENABLE_COOKIE));
    }

    @Override // anetwork.channel.Request
    public void removeHeader(Header header) {
        List<Header> list = this.f٥١٩٤e;
        if (list != null) {
            list.remove(header);
        }
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setBizId(int i10) {
        this.f٥٢٠٢m = String.valueOf(i10);
    }

    @Override // anetwork.channel.Request
    public void setBodyEntry(BodyEntry bodyEntry) {
        this.f٥١٩٩j = bodyEntry;
    }

    @Override // anetwork.channel.Request
    public void setBodyHandler(IBodyHandler iBodyHandler) {
        this.f٥١٩٩j = new BodyHandlerEntry(iBodyHandler);
    }

    @Override // anetwork.channel.Request
    public void setCharset(String str) {
        this.f٥١٩٨i = str;
    }

    @Override // anetwork.channel.Request
    public void setConnectTimeout(int i10) {
        this.f٥٢٠٠k = i10;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setCookieEnabled(boolean z10) {
        String str;
        if (z10) {
            str = "true";
        } else {
            str = RequestConstant.FALSE;
        }
        setExtProperty(RequestConstant.ENABLE_COOKIE, str);
    }

    @Override // anetwork.channel.Request
    public void setExtProperty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f٥٢٠٤o == null) {
            this.f٥٢٠٤o = new HashMap();
        }
        this.f٥٢٠٤o.put(str, str2);
    }

    @Override // anetwork.channel.Request
    public void setFollowRedirects(boolean z10) {
        this.f٥١٩٣d = z10;
    }

    @Override // anetwork.channel.Request
    public void setHeader(Header header) {
        if (header == null) {
            return;
        }
        if (this.f٥١٩٤e == null) {
            this.f٥١٩٤e = new ArrayList();
        }
        int size = this.f٥١٩٤e.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            if (header.getName().equalsIgnoreCase(this.f٥١٩٤e.get(i10).getName())) {
                this.f٥١٩٤e.set(i10, header);
                break;
            }
            i10++;
        }
        if (i10 < this.f٥١٩٤e.size()) {
            this.f٥١٩٤e.add(header);
        }
    }

    @Override // anetwork.channel.Request
    public void setHeaders(List<Header> list) {
        this.f٥١٩٤e = list;
    }

    @Override // anetwork.channel.Request
    public void setMethod(String str) {
        this.f٥١٩٥f = str;
    }

    @Override // anetwork.channel.Request
    public void setParams(List<Param> list) {
        this.f٥١٩٦g = list;
    }

    @Override // anetwork.channel.Request
    public void setReadTimeout(int i10) {
        this.f٥٢٠١l = i10;
    }

    @Override // anetwork.channel.Request
    public void setRetryTime(int i10) {
        this.f٥١٩٧h = i10;
    }

    @Override // anetwork.channel.Request
    public void setSeqNo(String str) {
        this.f٥٢٠٣n = str;
    }

    @Deprecated
    public void setUrL(URL url) {
        this.f٥١٩١b = url;
        this.f٥١٩٢c = url.toString();
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setUri(URI uri) {
        this.f٥١٩٠a = uri;
    }

    @Override // anetwork.channel.Request
    public Header[] getHeaders(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f٥١٩٤e == null) {
            return null;
        }
        for (int i10 = 0; i10 < this.f٥١٩٤e.size(); i10++) {
            if (this.f٥١٩٤e.get(i10) != null && this.f٥١٩٤e.get(i10).getName() != null && this.f٥١٩٤e.get(i10).getName().equalsIgnoreCase(str)) {
                arrayList.add(this.f٥١٩٤e.get(i10));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Header[] headerArr = new Header[arrayList.size()];
        arrayList.toArray(headerArr);
        return headerArr;
    }

    @Override // anetwork.channel.Request
    public void setBizId(String str) {
        this.f٥٢٠٢m = str;
    }

    @Deprecated
    public RequestImpl(URI uri) {
        this.f٥١٩٠a = uri;
        this.f٥١٩٢c = uri.toString();
    }

    @Deprecated
    public RequestImpl(URL url) {
        this.f٥١٩١b = url;
        this.f٥١٩٢c = url.toString();
    }

    public RequestImpl(String str) {
        this.f٥١٩٢c = str;
    }
}
