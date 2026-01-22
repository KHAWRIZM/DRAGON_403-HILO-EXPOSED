package com.alibaba.sdk.android.push.notification;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static AmsLogger f٦٧٤٧a = AmsLogger.getLogger("MPS:CPushNotification");

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<Integer> f٦٧٤٨b = new ArrayList<>();

    /* renamed from: B, reason: collision with root package name */
    private String f٦٧٤٩B;
    private String C;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f٦٧٥٠c;

    /* renamed from: d, reason: collision with root package name */
    private String f٦٧٥١d;

    /* renamed from: e, reason: collision with root package name */
    private String f٦٧٥٢e;

    /* renamed from: f, reason: collision with root package name */
    private String f٦٧٥٣f;

    /* renamed from: g, reason: collision with root package name */
    private String f٦٧٥٤g;

    /* renamed from: h, reason: collision with root package name */
    private String f٦٧٥٥h;

    /* renamed from: j, reason: collision with root package name */
    private String f٦٧٥٧j;

    /* renamed from: k, reason: collision with root package name */
    private String f٦٧٥٨k;

    /* renamed from: l, reason: collision with root package name */
    private String f٦٧٥٩l;

    /* renamed from: m, reason: collision with root package name */
    private String f٦٧٦٠m;

    /* renamed from: n, reason: collision with root package name */
    private String f٦٧٦١n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٦٧٦٢o;

    /* renamed from: p, reason: collision with root package name */
    private int f٦٧٦٣p;

    /* renamed from: i, reason: collision with root package name */
    private int f٦٧٥٦i = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f٦٧٦٤q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f٦٧٦٥r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f٦٧٦٦s = 1;

    /* renamed from: t, reason: collision with root package name */
    private int f٦٧٦٧t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f٦٧٦٨u = 3;

    /* renamed from: v, reason: collision with root package name */
    private int f٦٧٦٩v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f٦٧٧٠w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f٦٧٧١x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f٦٧٧٢y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f٦٧٧٣z = 0;
    private boolean A = false;

    static {
        f٦٧٤٨b.add(-2);
        f٦٧٤٨b.add(0);
        f٦٧٤٨b.add(1);
        f٦٧٤٨b.add(-1);
        f٦٧٤٨b.add(2);
    }

    public String a() {
        return this.f٦٧٥٤g;
    }

    public String b() {
        return this.f٦٧٥١d;
    }

    public String c() {
        return this.f٦٧٥٢e;
    }

    public int d() {
        return this.f٦٧٦٣p;
    }

    public void e(int i10) {
        this.f٦٧٦٨u = i10;
    }

    public int f() {
        return this.f٦٧٦٥r;
    }

    public int g() {
        return this.f٦٧٦٦s;
    }

    public int h() {
        return this.f٦٧٦٧t;
    }

    public int i() {
        return this.f٦٧٦٨u;
    }

    public int j() {
        return this.f٦٧٦٩v;
    }

    public int k() {
        return this.f٦٧٧٠w;
    }

    public int l() {
        return this.f٦٧٧١x;
    }

    public int m() {
        return this.f٦٧٧٢y;
    }

    public int n() {
        return this.f٦٧٧٣z;
    }

    public boolean o() {
        return this.A;
    }

    public int p() {
        return this.f٦٧٦٤q;
    }

    public String q() {
        return this.f٦٧٦١n;
    }

    public String r() {
        return this.f٦٧٥٥h;
    }

    public int s() {
        return this.f٦٧٥٦i;
    }

    public String t() {
        return this.f٦٧٥٧j;
    }

    public String u() {
        return this.f٦٧٥٨k;
    }

    public String v() {
        return this.f٦٧٥٩l;
    }

    public String w() {
        return this.f٦٧٦٠m;
    }

    public String x() {
        return this.f٦٧٤٩B;
    }

    public String y() {
        return this.C;
    }

    public void a(int i10) {
        this.f٦٧٦٣p = i10;
    }

    public void b(int i10) {
        this.f٦٧٦٥r = i10;
    }

    public void c(int i10) {
        this.f٦٧٦٦s = i10;
    }

    public void d(int i10) {
        this.f٦٧٦٧t = i10;
    }

    public void e(String str) {
        try {
            if (f٦٧٤٨b.contains(Integer.valueOf(Integer.parseInt(str)))) {
                this.f٦٧٦٤q = Integer.parseInt(str);
            }
        } catch (NumberFormatException e10) {
            f٦٧٤٧a.e("formar error:数字格式错误", e10);
        }
    }

    public void f(int i10) {
        this.f٦٧٦٩v = i10;
    }

    public void g(int i10) {
        this.f٦٧٧٠w = i10;
    }

    public void h(int i10) {
        this.f٦٧٧١x = i10;
    }

    public void i(int i10) {
        this.f٦٧٧٢y = i10;
    }

    public void j(int i10) {
        this.f٦٧٧٣z = i10;
    }

    public void k(int i10) {
        this.f٦٧٥٦i = i10;
    }

    public void l(String str) {
        this.f٦٧٤٩B = str;
    }

    public void m(String str) {
        this.C = str;
    }

    public void a(String str) {
        this.f٦٧٥٤g = str;
    }

    public void b(String str) {
        this.f٦٧٥١d = str;
    }

    public void c(String str) {
        this.f٦٧٥٢e = str;
    }

    public void d(String str) {
        this.f٦٧٥٣f = str;
    }

    public boolean e() {
        return this.f٦٧٦٢o;
    }

    public void f(String str) {
        this.f٦٧٦١n = str;
    }

    public void g(String str) {
        this.f٦٧٥٥h = str;
    }

    public void h(String str) {
        this.f٦٧٥٧j = str;
    }

    public void i(String str) {
        this.f٦٧٥٨k = str;
    }

    public void j(String str) {
        this.f٦٧٥٩l = str;
    }

    public void k(String str) {
        this.f٦٧٦٠m = str;
    }

    public void a(Map<String, String> map) {
        this.f٦٧٥٠c = map;
    }

    public void a(boolean z10) {
        this.A = z10;
    }
}
