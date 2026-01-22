package t9;

import android.text.TextUtils;
import org.json.JSONObject;
import p9.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f١٨١٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٨١٦٣b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٨١٦٤c;

    /* renamed from: d, reason: collision with root package name */
    private String f١٨١٦٥d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٨١٦٦e;

    /* renamed from: f, reason: collision with root package name */
    private String f١٨١٦٧f;

    /* renamed from: g, reason: collision with root package name */
    private long f١٨١٦٨g;

    /* renamed from: h, reason: collision with root package name */
    private String f١٨١٦٩h;

    /* renamed from: i, reason: collision with root package name */
    private String f١٨١٧٠i;

    public c(String str, String str2) {
        this(4096, str, null, null, str2, "");
    }

    public void a(String str) {
        this.f١٨١٦٣b = str;
    }

    public void b(String str) {
        this.f١٨١٧٠i = str;
    }

    public void c(String str) {
        this.f١٨١٦٤c = str;
    }

    public void d(String str) {
        this.f١٨١٦٥d = str;
    }

    public void e(String str) {
        this.f١٨١٦٧f = str;
    }

    public void f(String str) {
        this.f١٨١٦٩h = str;
    }

    public void g(String str) {
        this.f١٨١٦٦e = str;
    }

    public void h(int i10) {
        this.f١٨١٦٢a = i10;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("messageType", Integer.valueOf(this.f١٨١٦٢a));
            jSONObject.putOpt("eventID", this.f١٨١٦٤c);
            jSONObject.putOpt("appPackage", this.f١٨١٦٣b);
            jSONObject.putOpt("eventTime", Long.valueOf(this.f١٨١٦٨g));
            if (!TextUtils.isEmpty(this.f١٨١٦٥d)) {
                jSONObject.putOpt("globalID", this.f١٨١٦٥d);
            }
            if (!TextUtils.isEmpty(this.f١٨١٦٦e)) {
                jSONObject.putOpt("taskID", this.f١٨١٦٦e);
            }
            if (!TextUtils.isEmpty(this.f١٨١٦٧f)) {
                jSONObject.putOpt("property", this.f١٨١٦٧f);
            }
            if (!TextUtils.isEmpty(this.f١٨١٦٩h)) {
                jSONObject.putOpt("statistics_extra", this.f١٨١٦٩h);
            }
            if (!TextUtils.isEmpty(this.f١٨١٧٠i)) {
                jSONObject.putOpt("data_extra", this.f١٨١٧٠i);
            }
        } catch (Exception e10) {
            d.b(e10.getLocalizedMessage());
        }
        return jSONObject.toString();
    }

    public c(int i10, String str, String str2, String str3, String str4, String str5) {
        this(i10, str, str2, str3, str4, str5, "", "");
    }

    public c(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f١٨١٦٢a = 4096;
        this.f١٨١٦٨g = System.currentTimeMillis();
        h(i10);
        a(str);
        d(str2);
        g(str3);
        c(str4);
        e(str5);
        f(str6);
        b(str7);
    }
}
