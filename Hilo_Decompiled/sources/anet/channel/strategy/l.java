package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.facebook.internal.ServerProtocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f٥٠١٦a;

        /* renamed from: b, reason: collision with root package name */
        public final String f٥٠١٧b;

        /* renamed from: c, reason: collision with root package name */
        public final int f٥٠١٨c;

        /* renamed from: d, reason: collision with root package name */
        public final int f٥٠١٩d;

        /* renamed from: e, reason: collision with root package name */
        public final int f٥٠٢٠e;

        /* renamed from: f, reason: collision with root package name */
        public final int f٥٠٢١f;

        /* renamed from: g, reason: collision with root package name */
        public final String f٥٠٢٢g;

        /* renamed from: h, reason: collision with root package name */
        public final String f٥٠٢٣h;

        public a(JSONObject jSONObject) {
            this.f٥٠١٦a = jSONObject.optInt("port");
            this.f٥٠١٧b = jSONObject.optString("protocol");
            this.f٥٠١٨c = jSONObject.optInt("cto");
            this.f٥٠١٩d = jSONObject.optInt("rto");
            this.f٥٠٢٠e = jSONObject.optInt("retry");
            this.f٥٠٢١f = jSONObject.optInt("heartbeat");
            this.f٥٠٢٢g = jSONObject.optString("rtt", "");
            this.f٥٠٢٣h = jSONObject.optString("publickey");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f٥٠٢٤a;

        /* renamed from: b, reason: collision with root package name */
        public final int f٥٠٢٥b;

        /* renamed from: c, reason: collision with root package name */
        public final String f٥٠٢٦c;

        /* renamed from: d, reason: collision with root package name */
        public final String f٥٠٢٧d;

        /* renamed from: e, reason: collision with root package name */
        public final String f٥٠٢٨e;

        /* renamed from: f, reason: collision with root package name */
        public final String[] f٥٠٢٩f;

        /* renamed from: g, reason: collision with root package name */
        public final String[] f٥٠٣٠g;

        /* renamed from: h, reason: collision with root package name */
        public final a[] f٥٠٣١h;

        /* renamed from: i, reason: collision with root package name */
        public final e[] f٥٠٣٢i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f٥٠٣٣j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f٥٠٣٤k;

        /* renamed from: l, reason: collision with root package name */
        public final int f٥٠٣٥l;

        public b(JSONObject jSONObject) {
            this.f٥٠٢٤a = jSONObject.optString("host");
            this.f٥٠٢٥b = jSONObject.optInt("ttl");
            this.f٥٠٢٦c = jSONObject.optString("safeAisles");
            this.f٥٠٢٧d = jSONObject.optString("cname", null);
            this.f٥٠٢٨e = jSONObject.optString("unit", null);
            this.f٥٠٣٣j = jSONObject.optInt("clear") == 1;
            this.f٥٠٣٤k = jSONObject.optBoolean("effectNow");
            this.f٥٠٣٥l = jSONObject.optInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f٥٠٢٩f = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f٥٠٢٩f[i10] = optJSONArray.optString(i10);
                }
            } else {
                this.f٥٠٢٩f = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int length2 = optJSONArray2.length();
                this.f٥٠٣٠g = new String[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f٥٠٣٠g[i11] = optJSONArray2.optString(i11);
                }
            } else {
                this.f٥٠٣٠g = null;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.f٥٠٣١h = new a[length3];
                for (int i12 = 0; i12 < length3; i12++) {
                    this.f٥٠٣١h[i12] = new a(optJSONArray3.optJSONObject(i12));
                }
            } else {
                this.f٥٠٣١h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                int length4 = optJSONArray4.length();
                this.f٥٠٣٢i = new e[length4];
                for (int i13 = 0; i13 < length4; i13++) {
                    this.f٥٠٣٢i[i13] = new e(optJSONArray4.optJSONObject(i13));
                }
                return;
            }
            this.f٥٠٣٢i = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f٥٠٣٦a;

        /* renamed from: b, reason: collision with root package name */
        public final e[] f٥٠٣٧b;

        public c(JSONObject jSONObject) {
            this.f٥٠٣٦a = jSONObject.optString("host");
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f٥٠٣٧b = new e[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f٥٠٣٧b[i10] = new e(optJSONArray.optJSONObject(i10));
                }
                return;
            }
            this.f٥٠٣٧b = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f٥٠٣٨a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f٥٠٣٩b;

        /* renamed from: c, reason: collision with root package name */
        public final c[] f٥٠٤٠c;

        /* renamed from: d, reason: collision with root package name */
        public final String f٥٠٤١d;

        /* renamed from: e, reason: collision with root package name */
        public final String f٥٠٤٢e;

        /* renamed from: f, reason: collision with root package name */
        public final int f٥٠٤٣f;

        /* renamed from: g, reason: collision with root package name */
        public final int f٥٠٤٤g;

        /* renamed from: h, reason: collision with root package name */
        public final int f٥٠٤٥h;

        public d(JSONObject jSONObject) {
            this.f٥٠٣٨a = jSONObject.optString("ip");
            this.f٥٠٤١d = jSONObject.optString("uid", null);
            this.f٥٠٤٢e = jSONObject.optString(RestUrlWrapper.FIELD_UTDID, null);
            this.f٥٠٤٣f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f٥٠٤٤g = jSONObject.optInt("fcl");
            this.f٥٠٤٥h = jSONObject.optInt("fct");
            JSONArray optJSONArray = jSONObject.optJSONArray("dns");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f٥٠٣٩b = new b[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f٥٠٣٩b[i10] = new b(optJSONArray.optJSONObject(i10));
                }
            } else {
                this.f٥٠٣٩b = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.f٥٠٤٠c = new c[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f٥٠٤٠c[i11] = new c(optJSONArray2.optJSONObject(i11));
                }
                return;
            }
            this.f٥٠٤٠c = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f٥٠٤٦a;

        /* renamed from: b, reason: collision with root package name */
        public final a f٥٠٤٧b;

        /* renamed from: c, reason: collision with root package name */
        public final String f٥٠٤٨c;

        public e(JSONObject jSONObject) {
            this.f٥٠٤٦a = jSONObject.optString("ip");
            this.f٥٠٤٨c = jSONObject.optString("path");
            this.f٥٠٤٧b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e10) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e10, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
