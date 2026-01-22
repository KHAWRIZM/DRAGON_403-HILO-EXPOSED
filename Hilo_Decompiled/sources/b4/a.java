package b4;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: q, reason: collision with root package name */
    public static ArrayList f٥٣٨٦q = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private Map f٥٣٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private String f٥٣٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private String f٥٣٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private String f٥٣٩٠d;

    /* renamed from: e, reason: collision with root package name */
    private String f٥٣٩١e;

    /* renamed from: f, reason: collision with root package name */
    private String f٥٣٩٢f;

    /* renamed from: g, reason: collision with root package name */
    private String f٥٣٩٣g;

    /* renamed from: h, reason: collision with root package name */
    private String f٥٣٩٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f٥٣٩٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f٥٣٩٦j;

    /* renamed from: k, reason: collision with root package name */
    private int f٥٣٩٧k = 0;

    /* renamed from: l, reason: collision with root package name */
    private String f٥٣٩٨l;

    /* renamed from: m, reason: collision with root package name */
    private String f٥٣٩٩m;

    /* renamed from: n, reason: collision with root package name */
    private String f٥٤٠٠n;

    /* renamed from: o, reason: collision with root package name */
    private String f٥٤٠١o;

    /* renamed from: p, reason: collision with root package name */
    private String f٥٤٠٢p;

    static {
        f٥٣٨٦q.add(-2);
        f٥٣٨٦q.add(0);
        f٥٣٨٦q.add(1);
        f٥٣٨٦q.add(-1);
        f٥٣٨٦q.add(2);
    }

    public void A(String str) {
        this.f٥٤٠١o = str;
    }

    public String B() {
        return this.f٥٣٩٤h;
    }

    public void C(String str) {
        this.f٥٤٠٢p = str;
    }

    public String D() {
        return this.f٥٤٠٠n;
    }

    public String E() {
        return this.f٥٤٠١o;
    }

    public String F() {
        return this.f٥٤٠٢p;
    }

    public int a() {
        return this.f٥٣٩٥i;
    }

    public void b(int i10) {
        this.f٥٣٩٥i = i10;
    }

    public void c(String str) {
        this.f٥٣٩٠d = str;
    }

    public void d(Map map) {
        this.f٥٣٨٧a = map;
    }

    public String e() {
        return this.f٥٣٩٠d;
    }

    public void f(int i10) {
        if (i10 < 0) {
            this.f٥٣٩٦j = i10 * (-1);
        } else {
            this.f٥٣٩٦j = i10;
        }
    }

    public void g(String str) {
        this.f٥٣٩١e = str;
    }

    public String h() {
        return this.f٥٣٩١e;
    }

    public void i(String str) {
        this.f٥٣٩٢f = str;
    }

    public String j() {
        return this.f٥٣٩٢f;
    }

    public void k(String str) {
        this.f٥٣٨٨b = str;
    }

    public Map l() {
        return this.f٥٣٨٧a;
    }

    public void m(String str) {
        this.f٥٣٨٩c = str;
    }

    public String n() {
        return this.f٥٣٨٨b;
    }

    public void o(String str) {
        this.f٥٣٩٣g = str;
    }

    public String p() {
        return this.f٥٣٨٩c;
    }

    public void q(String str) {
        try {
            if (f٥٣٨٦q.contains(Integer.valueOf(Integer.parseInt(str)))) {
                this.f٥٣٩٧k = Integer.parseInt(str);
            }
        } catch (NumberFormatException e10) {
            ALog.e("MPS:CPushNotification", "formar error:数字格式错误", e10, new Object[0]);
        }
    }

    public String r() {
        return this.f٥٣٩٣g;
    }

    public void s(String str) {
        this.f٥٣٩٨l = str;
    }

    public int t() {
        return this.f٥٣٩٦j;
    }

    public void u(String str) {
        this.f٥٣٩٩m = str;
    }

    public int v() {
        return this.f٥٣٩٧k;
    }

    public void w(String str) {
        this.f٥٣٩٤h = str;
    }

    public String x() {
        return this.f٥٣٩٨l;
    }

    public void y(String str) {
        this.f٥٤٠٠n = str;
    }

    public String z() {
        return this.f٥٣٩٩m;
    }
}
