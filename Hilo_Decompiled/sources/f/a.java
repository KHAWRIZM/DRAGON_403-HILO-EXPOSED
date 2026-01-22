package f;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.bolts.AppLinks;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.base.utils.Utils;
import u.h;
import u.j;
import u.l;
import wf.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f١٣٩٩٨a;

    /* renamed from: b, reason: collision with root package name */
    public String f١٣٩٩٩b;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f١٤٠٠٨k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f١٤٠٠٩l;

    /* renamed from: m, reason: collision with root package name */
    public Integer f١٤٠١٠m;

    /* renamed from: n, reason: collision with root package name */
    public e f١٤٠١١n;

    /* renamed from: o, reason: collision with root package name */
    public Long f١٤٠١٢o;

    /* renamed from: p, reason: collision with root package name */
    public Integer f١٤٠١٣p;

    /* renamed from: q, reason: collision with root package name */
    public Long f١٤٠١٤q;

    /* renamed from: r, reason: collision with root package name */
    public Integer f١٤٠١٥r;

    /* renamed from: s, reason: collision with root package name */
    public Long f١٤٠١٦s;

    /* renamed from: t, reason: collision with root package name */
    public Long f١٤٠١٧t;

    /* renamed from: u, reason: collision with root package name */
    public Long f١٤٠١٨u;

    /* renamed from: d, reason: collision with root package name */
    public String f١٤٠٠١d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f١٤٠٠٢e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f١٤٠٠٣f = "success";

    /* renamed from: g, reason: collision with root package name */
    public String f١٤٠٠٤g = "";

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f١٤٠٠٧j = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final long f١٤٠٠٥h = System.currentTimeMillis();

    /* renamed from: i, reason: collision with root package name */
    public final long f١٤٠٠٦i = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

    /* renamed from: c, reason: collision with root package name */
    public String f١٤٠٠٠c = j.b(UUID.randomUUID().toString());

    public a(String str) {
        this.f١٣٩٩٨a = str;
        this.f١٣٩٩٩b = d.a(str);
    }

    public static void a(JSONObject jSONObject) {
        Application app = Utils.getApp();
        if (app == null) {
            jSONObject.put("proxy", "");
            return;
        }
        jSONObject.put("net_type", l.a(app));
        StringBuilder sb = new StringBuilder();
        boolean c10 = l.c(app);
        boolean b10 = l.b(app);
        if (c10) {
            sb.append("proxy");
        }
        if (b10) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append("vpn");
        }
        jSONObject.put("proxy", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0071, code lost:
    
        if (r5 == null) goto L٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        Object obj;
        long longValue;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.TAG_KEY, "SudMGP");
            jSONObject.put("app_id", e.d.f١٣٧٢٤g);
            jSONObject.put("mg_id", this.f١٤٠٠٤g);
            jSONObject.put("is_test_env", e.d.f١٣٧٢٠c);
            jSONObject.put("env_type", e.d.f١٣٧٢٣f);
            jSONObject.put(RestUrlWrapper.FIELD_SDK_VERSION, "1.6.6.1277");
            jSONObject.put("sdk_version_alias", "v1.6.6.1277-static");
            jSONObject.put("et_is_dynamic", false);
            jSONObject.put("sud_is_dynamic", false);
            jSONObject.put("event", this.f١٣٩٩٨a);
            jSONObject.put("event_id", this.f١٣٩٩٩b);
            jSONObject.put("trace_id", e.d.f١٣٧٢٧j);
            String str = this.f١٤٠٠٤g;
            String str2 = d.f١٤٠٢٣a;
            if (!TextUtils.isEmpty(str)) {
                obj = (String) d.f١٤٠٢٦d.get(str);
            }
            obj = "";
            jSONObject.put("span_id", obj);
            jSONObject.put("request_id", this.f١٤٠٠٠c);
            jSONObject.put("user_id", d.f١٤٠٢٣a);
            jSONObject.put("platform", 2);
            jSONObject.put("bundle_id", e.d.d());
            jSONObject.put("start_timestamp", this.f١٤٠٠٥h);
            jSONObject.put("end_timestamp", System.currentTimeMillis());
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.f١٤٠٠٦i;
            Long l10 = this.f١٤٠١٢o;
            long j10 = 0;
            if (l10 == null) {
                longValue = 0;
            } else {
                longValue = l10.longValue();
            }
            long j11 = millis - longValue;
            Long l11 = this.f١٤٠١٨u;
            if (l11 != null) {
                j10 = l11.longValue();
            }
            jSONObject.put("cost_time", j11 - j10);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : this.f١٤٠٠٧j.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject2.put("ret_msg", this.f١٤٠٠٣f);
            jSONObject2.put("ret_code", this.f١٤٠٠٢e);
            jSONObject2.put("resp", this.f١٤٠٠١d);
            jSONObject.put(AppLinks.KEY_NAME_EXTRAS, jSONObject2);
            jSONObject.put("ret_code", this.f١٤٠٠٢e);
            jSONObject.put("ret_msg", this.f١٤٠٠٣f);
            a(jSONObject);
            jSONObject.put("device_brand", h.a());
            jSONObject.put("os_version", h.d());
            jSONObject.put("device_id", h.c());
            Object obj2 = this.f١٤٠٠٨k;
            if (obj2 != null) {
                jSONObject.put("local_pkg", obj2);
            }
            Object obj3 = this.f١٤٠٠٩l;
            if (obj3 != null) {
                jSONObject.put("local_core", obj3);
            }
            if (this.f١٤٠١١n != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("dns", this.f١٤٠١١n.a);
                jSONObject3.put("secure_connect", this.f١٤٠١١n.c);
                jSONObject3.put("connect", this.f١٤٠١١n.b);
                jSONObject3.put("request", this.f١٤٠١١n.d);
                jSONObject3.put("response", this.f١٤٠١١n.e);
                jSONObject3.put("chain_reuse", this.f١٤٠١١n.g);
                jSONObject3.put("server_response", this.f١٤٠١١n.f);
                jSONObject2.put("cost_time_detail", jSONObject3);
            }
            Object obj4 = this.f١٤٠١٠m;
            if (obj4 != null) {
                jSONObject.put("timeout_code", obj4);
            }
            Object obj5 = this.f١٤٠١٢o;
            if (obj5 != null) {
                jSONObject.put("pause_cost_time", obj5);
            }
            Object obj6 = this.f١٤٠١٣p;
            if (obj6 != null) {
                jSONObject.put("last_percent", obj6);
            }
            Object obj7 = this.f١٤٠١٤q;
            if (obj7 != null) {
                jSONObject.put("last_wait_timestamp", obj7);
            }
            Object obj8 = this.f١٤٠١٥r;
            if (obj8 != null) {
                jSONObject.put("is_background", obj8);
            }
            Object obj9 = this.f١٤٠١٦s;
            if (obj9 != null) {
                jSONObject.put("total_space", obj9);
            }
            Object obj10 = this.f١٤٠١٧t;
            if (obj10 != null) {
                jSONObject.put("free_space", obj10);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
