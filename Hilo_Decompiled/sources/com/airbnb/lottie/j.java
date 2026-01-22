package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private Map f٦١٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private Map f٦١٨٥d;

    /* renamed from: e, reason: collision with root package name */
    private float f٦١٨٦e;

    /* renamed from: f, reason: collision with root package name */
    private Map f٦١٨٧f;

    /* renamed from: g, reason: collision with root package name */
    private List f٦١٨٨g;

    /* renamed from: h, reason: collision with root package name */
    private SparseArrayCompat f٦١٨٩h;

    /* renamed from: i, reason: collision with root package name */
    private LongSparseArray f٦١٩٠i;

    /* renamed from: j, reason: collision with root package name */
    private List f٦١٩١j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f٦١٩٢k;

    /* renamed from: l, reason: collision with root package name */
    private float f٦١٩٣l;

    /* renamed from: m, reason: collision with root package name */
    private float f٦١٩٤m;

    /* renamed from: n, reason: collision with root package name */
    private float f٦١٩٥n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٦١٩٦o;

    /* renamed from: a, reason: collision with root package name */
    private final r0 f٦١٨٢a = new r0();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f٦١٨٣b = new HashSet();

    /* renamed from: p, reason: collision with root package name */
    private int f٦١٩٧p = 0;

    public void a(String str) {
        x3.f.c(str);
        this.f٦١٨٣b.add(str);
    }

    public Rect b() {
        return this.f٦١٩٢k;
    }

    public SparseArrayCompat c() {
        return this.f٦١٨٩h;
    }

    public float d() {
        return (e() / this.f٦١٩٥n) * 1000.0f;
    }

    public float e() {
        return this.f٦١٩٤m - this.f٦١٩٣l;
    }

    public float f() {
        return this.f٦١٩٤m;
    }

    public Map g() {
        return this.f٦١٨٧f;
    }

    public float h(float f10) {
        return x3.k.i(this.f٦١٩٣l, this.f٦١٩٤m, f10);
    }

    public float i() {
        return this.f٦١٩٥n;
    }

    public Map j() {
        float e10 = x3.l.e();
        if (e10 != this.f٦١٨٦e) {
            for (Map.Entry entry : this.f٦١٨٥d.entrySet()) {
                this.f٦١٨٥d.put((String) entry.getKey(), ((k0) entry.getValue()).a(this.f٦١٨٦e / e10));
            }
        }
        this.f٦١٨٦e = e10;
        return this.f٦١٨٥d;
    }

    public List k() {
        return this.f٦١٩١j;
    }

    public q3.h l(String str) {
        int size = this.f٦١٨٨g.size();
        for (int i10 = 0; i10 < size; i10++) {
            q3.h hVar = (q3.h) this.f٦١٨٨g.get(i10);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f٦١٩٧p;
    }

    public r0 n() {
        return this.f٦١٨٢a;
    }

    public List o(String str) {
        return (List) this.f٦١٨٤c.get(str);
    }

    public float p() {
        return this.f٦١٩٣l;
    }

    public boolean q() {
        return this.f٦١٩٦o;
    }

    public void r(int i10) {
        this.f٦١٩٧p += i10;
    }

    public void s(Rect rect, float f10, float f11, float f12, List list, LongSparseArray longSparseArray, Map map, Map map2, float f13, SparseArrayCompat sparseArrayCompat, Map map3, List list2) {
        this.f٦١٩٢k = rect;
        this.f٦١٩٣l = f10;
        this.f٦١٩٤m = f11;
        this.f٦١٩٥n = f12;
        this.f٦١٩١j = list;
        this.f٦١٩٠i = longSparseArray;
        this.f٦١٨٤c = map;
        this.f٦١٨٥d = map2;
        this.f٦١٨٦e = f13;
        this.f٦١٨٩h = sparseArrayCompat;
        this.f٦١٨٧f = map3;
        this.f٦١٨٨g = list2;
    }

    public t3.e t(long j10) {
        return (t3.e) this.f٦١٩٠i.get(j10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f٦١٩١j.iterator();
        while (it.hasNext()) {
            sb.append(((t3.e) it.next()).z("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z10) {
        this.f٦١٩٦o = z10;
    }

    public void v(boolean z10) {
        this.f٦١٨٢a.b(z10);
    }
}
