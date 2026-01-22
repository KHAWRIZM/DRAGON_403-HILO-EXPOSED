package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import e2.c;
import e2.d;
import e2.f;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m {

    /* renamed from: B, reason: collision with root package name */
    private HashMap f٢٠١٨B;
    private HashMap C;
    private HashMap D;
    private k[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;

    /* renamed from: b, reason: collision with root package name */
    View f٢٠٢٠b;

    /* renamed from: c, reason: collision with root package name */
    int f٢٠٢١c;

    /* renamed from: e, reason: collision with root package name */
    String f٢٠٢٣e;

    /* renamed from: k, reason: collision with root package name */
    private a2.b[] f٢٠٢٩k;

    /* renamed from: l, reason: collision with root package name */
    private a2.b f٢٠٣٠l;

    /* renamed from: p, reason: collision with root package name */
    float f٢٠٣٤p;

    /* renamed from: q, reason: collision with root package name */
    float f٢٠٣٥q;

    /* renamed from: r, reason: collision with root package name */
    private int[] f٢٠٣٦r;

    /* renamed from: s, reason: collision with root package name */
    private double[] f٢٠٣٧s;

    /* renamed from: t, reason: collision with root package name */
    private double[] f٢٠٣٨t;

    /* renamed from: u, reason: collision with root package name */
    private String[] f٢٠٣٩u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f٢٠٤٠v;

    /* renamed from: a, reason: collision with root package name */
    Rect f٢٠١٩a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    boolean f٢٠٢٢d = false;

    /* renamed from: f, reason: collision with root package name */
    private int f٢٠٢٤f = -1;

    /* renamed from: g, reason: collision with root package name */
    private o f٢٠٢٥g = new o();

    /* renamed from: h, reason: collision with root package name */
    private o f٢٠٢٦h = new o();

    /* renamed from: i, reason: collision with root package name */
    private l f٢٠٢٧i = new l();

    /* renamed from: j, reason: collision with root package name */
    private l f٢٠٢٨j = new l();

    /* renamed from: m, reason: collision with root package name */
    float f٢٠٣١m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    float f٢٠٣٢n = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: o, reason: collision with root package name */
    float f٢٠٣٣o = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    private int f٢٠٤١w = 4;

    /* renamed from: x, reason: collision with root package name */
    private float[] f٢٠٤٢x = new float[4];

    /* renamed from: y, reason: collision with root package name */
    private ArrayList f٢٠٤٣y = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    private float[] f٢٠٤٤z = new float[1];
    private ArrayList A = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a2.c f٢٠٤٥a;

        a(a2.c cVar) {
            this.f٢٠٤٥a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f٢٠٤٥a.a(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view) {
        int i10 = d.f١٩٥١f;
        this.F = i10;
        this.G = i10;
        this.H = null;
        this.I = i10;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    private float g(float f10, float[] fArr) {
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f٢٠٣٣o;
            if (f13 != 1.0d) {
                float f14 = this.f٢٠٣٢n;
                if (f10 < f14) {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (f10 > f14 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f14) * f13, 1.0f);
                }
            }
        }
        a2.c cVar = this.f٢٠٢٥g.f٢٠٤٧a;
        Iterator it = this.f٢٠٤٣y.iterator();
        float f15 = Float.NaN;
        while (it.hasNext()) {
            o oVar = (o) it.next();
            a2.c cVar2 = oVar.f٢٠٤٧a;
            if (cVar2 != null) {
                float f16 = oVar.f٢٠٤٩c;
                if (f16 < f10) {
                    cVar = cVar2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = oVar.f٢٠٤٩c;
                }
            }
        }
        if (cVar != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (f10 - f11) / f17;
            f10 = (((float) cVar.a(d10)) * f17) + f11;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d10);
            }
        }
        return f10;
    }

    private static Interpolator p(Context context, int i10, String str, int i11) {
        if (i10 != -2) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    return null;
                                }
                                return new OvershootInterpolator();
                            }
                            return new BounceInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new a(a2.c.c(str));
        }
        return AnimationUtils.loadInterpolator(context, i11);
    }

    private float s() {
        char c10;
        float f10;
        float[] fArr = new float[2];
        float f11 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        while (i10 < 100) {
            float f13 = i10 * f11;
            double d12 = f13;
            a2.c cVar = this.f٢٠٢٥g.f٢٠٤٧a;
            Iterator it = this.f٢٠٤٣y.iterator();
            float f14 = Float.NaN;
            float f15 = DownloadProgress.UNKNOWN_PROGRESS;
            while (it.hasNext()) {
                o oVar = (o) it.next();
                a2.c cVar2 = oVar.f٢٠٤٧a;
                if (cVar2 != null) {
                    float f16 = oVar.f٢٠٤٩c;
                    if (f16 < f13) {
                        cVar = cVar2;
                        f15 = f16;
                    } else if (Float.isNaN(f14)) {
                        f14 = oVar.f٢٠٤٩c;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                d12 = (((float) cVar.a((f13 - f15) / r17)) * (f14 - f15)) + f15;
            }
            this.f٢٠٢٩k[0].d(d12, this.f٢٠٣٧s);
            float f17 = f12;
            int i11 = i10;
            this.f٢٠٢٥g.g(d12, this.f٢٠٣٦r, this.f٢٠٣٧s, fArr, 0);
            if (i11 > 0) {
                c10 = 0;
                f10 = (float) (f17 + Math.hypot(d11 - fArr[1], d10 - fArr[0]));
            } else {
                c10 = 0;
                f10 = f17;
            }
            d10 = fArr[c10];
            i10 = i11 + 1;
            f12 = f10;
            d11 = fArr[1];
        }
        return f12;
    }

    private void w(o oVar) {
        if (Collections.binarySearch(this.f٢٠٤٣y, oVar) == 0) {
            Log.e("MotionController", " KeyPath position \"" + oVar.f٢٠٥٠d + "\" outside of range");
        }
        this.f٢٠٤٣y.add((-r0) - 1, oVar);
    }

    private void y(o oVar) {
        oVar.q((int) this.f٢٠٢٠b.getX(), (int) this.f٢٠٢٠b.getY(), this.f٢٠٢٠b.getWidth(), this.f٢٠٢٠b.getHeight());
    }

    void A(Rect rect, Rect rect2, int i10, int i11, int i12) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        int i13 = rect.left + rect.right;
                        rect2.left = i11 - (((rect.bottom + rect.top) + rect.width()) / 2);
                        rect2.top = (i13 - rect.height()) / 2;
                        rect2.right = rect2.left + rect.width();
                        rect2.bottom = rect2.top + rect.height();
                        return;
                    }
                    return;
                }
                int i14 = rect.left + rect.right;
                rect2.left = ((rect.height() / 2) + rect.top) - (i14 / 2);
                rect2.top = i12 - ((i14 + rect.height()) / 2);
                rect2.right = rect2.left + rect.width();
                rect2.bottom = rect2.top + rect.height();
                return;
            }
            int i15 = rect.left + rect.right;
            rect2.left = i11 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i15 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        int i16 = rect.left + rect.right;
        rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
        rect2.top = i12 - ((i16 + rect.height()) / 2);
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(View view) {
        o oVar = this.f٢٠٢٥g;
        oVar.f٢٠٤٩c = DownloadProgress.UNKNOWN_PROGRESS;
        oVar.f٢٠٥٠d = DownloadProgress.UNKNOWN_PROGRESS;
        this.L = true;
        oVar.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f٢٠٢٦h.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f٢٠٢٧i.j(view);
        this.f٢٠٢٨j.j(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        int i12 = cVar.f٢٤١١d;
        if (i12 != 0) {
            A(rect, this.f٢٠١٩a, i12, i10, i11);
            rect = this.f٢٠١٩a;
        }
        o oVar = this.f٢٠٢٦h;
        oVar.f٢٠٤٩c = 1.0f;
        oVar.f٢٠٥٠d = 1.0f;
        y(oVar);
        this.f٢٠٢٦h.q(rect.left, rect.top, rect.width(), rect.height());
        this.f٢٠٢٦h.a(cVar.z(this.f٢٠٢١c));
        this.f٢٠٢٨j.i(rect, cVar, i12, this.f٢٠٢١c);
    }

    public void D(int i10) {
        this.F = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(View view) {
        o oVar = this.f٢٠٢٥g;
        oVar.f٢٠٤٩c = DownloadProgress.UNKNOWN_PROGRESS;
        oVar.f٢٠٥٠d = DownloadProgress.UNKNOWN_PROGRESS;
        oVar.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f٢٠٢٧i.j(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        int i12 = cVar.f٢٤١١d;
        if (i12 != 0) {
            A(rect, this.f٢٠١٩a, i12, i10, i11);
        }
        o oVar = this.f٢٠٢٥g;
        oVar.f٢٠٤٩c = DownloadProgress.UNKNOWN_PROGRESS;
        oVar.f٢٠٥٠d = DownloadProgress.UNKNOWN_PROGRESS;
        y(oVar);
        this.f٢٠٢٥g.q(rect.left, rect.top, rect.width(), rect.height());
        c.a z10 = cVar.z(this.f٢٠٢١c);
        this.f٢٠٢٥g.a(z10);
        this.f٢٠٣١m = z10.f٢٤١٨d.f٢٤٨٧g;
        this.f٢٠٢٧i.i(rect, cVar, i12, this.f٢٠٢١c);
        this.G = z10.f٢٤٢٠f.f٢٥٠٩i;
        c.C٠٠١٩c r82 = z10.f٢٤١٨d;
        this.I = r82.f٢٤٩١k;
        this.J = r82.f٢٤٩٠j;
        Context context = this.f٢٠٢٠b.getContext();
        c.C٠٠١٩c r92 = z10.f٢٤١٨d;
        this.K = p(context, r92.f٢٤٩٣m, r92.f٢٤٩٢l, r92.f٢٤٩٤n);
    }

    public void G(e2.e eVar, View view, int i10, int i11, int i12) {
        o oVar = this.f٢٠٢٥g;
        oVar.f٢٠٤٩c = DownloadProgress.UNKNOWN_PROGRESS;
        oVar.f٢٠٥٠d = DownloadProgress.UNKNOWN_PROGRESS;
        Rect rect = new Rect();
        if (i10 != 1) {
            if (i10 != 2) {
                this.f٢٠٢٥g.q(rect.left, rect.top, rect.width(), rect.height());
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public void H(View view) {
        this.f٢٠٢٠b = view;
        this.f٢٠٢١c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f٢٠٢٣e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void I(int i10, int i11, float f10, long j10) {
        String[] strArr;
        boolean z10;
        double[][] dArr;
        androidx.constraintlayout.widget.a aVar;
        int i12;
        e2.f g10;
        androidx.constraintlayout.widget.a aVar2;
        int i13;
        Integer num;
        e2.d g11;
        androidx.constraintlayout.widget.a aVar3;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i14 = this.F;
        if (i14 != d.f١٩٥١f) {
            this.f٢٠٢٥g.f٢٠٥٧k = i14;
        }
        this.f٢٠٢٧i.g(this.f٢٠٢٨j, hashSet2);
        ArrayList arrayList = this.A;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof h) {
                    h hVar = (h) dVar;
                    w(new o(i10, i11, hVar, this.f٢٠٢٥g, this.f٢٠٢٦h));
                    int i15 = hVar.f١٩٩٠g;
                    if (i15 != d.f١٩٥١f) {
                        this.f٢٠٢٤f = i15;
                    }
                } else {
                    dVar.h(hashMap);
                    dVar.d(hashSet2);
                }
            }
        }
        char c10 = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator it3 = this.A.iterator();
                    while (it3.hasNext()) {
                        d dVar2 = (d) it3.next();
                        HashMap hashMap2 = dVar2.f١٩٥٦e;
                        if (hashMap2 != null && (aVar3 = (androidx.constraintlayout.widget.a) hashMap2.get(str2)) != null) {
                            sparseArray.append(dVar2.f١٩٥٢a, aVar3);
                        }
                    }
                    g11 = e2.d.f(str, sparseArray);
                } else {
                    g11 = e2.d.g(str);
                }
                if (g11 != null) {
                    g11.d(str);
                    this.C.put(str, g11);
                }
            }
            ArrayList arrayList2 = this.A;
            if (arrayList2 != null) {
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    d dVar3 = (d) it4.next();
                    if (dVar3 instanceof e) {
                        dVar3.a(this.C);
                    }
                }
            }
            this.f٢٠٢٧i.a(this.C, 0);
            this.f٢٠٢٨j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                if (hashMap.containsKey(str3) && (num = (Integer) hashMap.get(str3)) != null) {
                    i13 = num.intValue();
                } else {
                    i13 = 0;
                }
                a2.j jVar = (a2.j) this.C.get(str3);
                if (jVar != null) {
                    jVar.e(i13);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.f٢٠١٨B == null) {
                this.f٢٠١٨B = new HashMap();
            }
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String str4 = (String) it5.next();
                if (!this.f٢٠١٨B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        Iterator it6 = this.A.iterator();
                        while (it6.hasNext()) {
                            d dVar4 = (d) it6.next();
                            HashMap hashMap3 = dVar4.f١٩٥٦e;
                            if (hashMap3 != null && (aVar2 = (androidx.constraintlayout.widget.a) hashMap3.get(str5)) != null) {
                                sparseArray2.append(dVar4.f١٩٥٢a, aVar2);
                            }
                        }
                        g10 = e2.f.f(str4, sparseArray2);
                    } else {
                        g10 = e2.f.g(str4, j10);
                    }
                    if (g10 != null) {
                        g10.c(str4);
                        this.f٢٠١٨B.put(str4, g10);
                    }
                }
            }
            ArrayList arrayList3 = this.A;
            if (arrayList3 != null) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                }
            }
            for (String str6 : this.f٢٠١٨B.keySet()) {
                if (hashMap.containsKey(str6)) {
                    i12 = ((Integer) hashMap.get(str6)).intValue();
                } else {
                    i12 = 0;
                }
                ((e2.f) this.f٢٠١٨B.get(str6)).d(i12);
            }
        }
        int size = this.f٢٠٤٣y.size();
        int i16 = size + 2;
        o[] oVarArr = new o[i16];
        oVarArr[0] = this.f٢٠٢٥g;
        oVarArr[size + 1] = this.f٢٠٢٦h;
        if (this.f٢٠٤٣y.size() > 0 && this.f٢٠٢٤f == -1) {
            this.f٢٠٢٤f = 0;
        }
        Iterator it8 = this.f٢٠٤٣y.iterator();
        int i17 = 1;
        while (it8.hasNext()) {
            oVarArr[i17] = (o) it8.next();
            i17++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f٢٠٢٦h.f٢٠٦١o.keySet()) {
            if (this.f٢٠٢٥g.f٢٠٦١o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f٢٠٣٩u = strArr2;
        this.f٢٠٤٠v = new int[strArr2.length];
        int i18 = 0;
        while (true) {
            strArr = this.f٢٠٣٩u;
            if (i18 >= strArr.length) {
                break;
            }
            String str8 = strArr[i18];
            this.f٢٠٤٠v[i18] = 0;
            int i19 = 0;
            while (true) {
                if (i19 >= i16) {
                    break;
                }
                if (oVarArr[i19].f٢٠٦١o.containsKey(str8) && (aVar = (androidx.constraintlayout.widget.a) oVarArr[i19].f٢٠٦١o.get(str8)) != null) {
                    int[] iArr = this.f٢٠٤٠v;
                    iArr[i18] = iArr[i18] + aVar.g();
                    break;
                }
                i19++;
            }
            i18++;
        }
        if (oVarArr[0].f٢٠٥٧k != d.f١٩٥١f) {
            z10 = true;
        } else {
            z10 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i20 = 1; i20 < i16; i20++) {
            oVarArr[i20].e(oVarArr[i20 - 1], zArr, this.f٢٠٣٩u, z10);
        }
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                i21++;
            }
        }
        this.f٢٠٣٦r = new int[i21];
        int i23 = 2;
        int max = Math.max(2, i21);
        this.f٢٠٣٧s = new double[max];
        this.f٢٠٣٨t = new double[max];
        int i24 = 0;
        for (int i25 = 1; i25 < length; i25++) {
            if (zArr[i25]) {
                this.f٢٠٣٦r[i24] = i25;
                i24++;
            }
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, this.f٢٠٣٦r.length);
        double[] dArr3 = new double[i16];
        for (int i26 = 0; i26 < i16; i26++) {
            oVarArr[i26].f(dArr2[i26], this.f٢٠٣٦r);
            dArr3[i26] = oVarArr[i26].f٢٠٤٩c;
        }
        int i27 = 0;
        while (true) {
            int[] iArr2 = this.f٢٠٣٦r;
            if (i27 >= iArr2.length) {
                break;
            }
            if (iArr2[i27] < o.f٢٠٤٦t.length) {
                String str9 = o.f٢٠٤٦t[this.f٢٠٣٦r[i27]] + " [";
                for (int i28 = 0; i28 < i16; i28++) {
                    str9 = str9 + dArr2[i28][i27];
                }
            }
            i27++;
        }
        this.f٢٠٢٩k = new a2.b[this.f٢٠٣٩u.length + 1];
        int i29 = 0;
        while (true) {
            String[] strArr3 = this.f٢٠٣٩u;
            if (i29 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i29];
            double[] dArr4 = null;
            double[][] dArr5 = null;
            int i30 = 0;
            int i31 = 0;
            while (i30 < i16) {
                if (oVarArr[i30].l(str10)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i16];
                        int[] iArr3 = new int[i23];
                        iArr3[c10] = oVarArr[i30].j(str10);
                        iArr3[0] = i16;
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    o oVar = oVarArr[i30];
                    dArr = dArr2;
                    dArr4[i31] = oVar.f٢٠٤٩c;
                    oVar.i(str10, dArr5[i31], 0);
                    i31++;
                } else {
                    dArr = dArr2;
                }
                i30++;
                dArr2 = dArr;
                i23 = 2;
                c10 = 1;
            }
            i29++;
            this.f٢٠٢٩k[i29] = a2.b.a(this.f٢٠٢٤f, Arrays.copyOf(dArr4, i31), (double[][]) Arrays.copyOf(dArr5, i31));
            dArr2 = dArr2;
            i23 = 2;
            c10 = 1;
        }
        this.f٢٠٢٩k[0] = a2.b.a(this.f٢٠٢٤f, dArr3, dArr2);
        if (oVarArr[0].f٢٠٥٧k != d.f١٩٥١f) {
            int[] iArr4 = new int[i16];
            double[] dArr6 = new double[i16];
            double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, 2);
            for (int i32 = 0; i32 < i16; i32++) {
                iArr4[i32] = oVarArr[i32].f٢٠٥٧k;
                dArr6[i32] = r9.f٢٠٤٩c;
                double[] dArr8 = dArr7[i32];
                dArr8[0] = r9.f٢٠٥١e;
                dArr8[1] = r9.f٢٠٥٢f;
            }
            this.f٢٠٣٠l = a2.b.b(iArr4, dArr6, dArr7);
        }
        this.D = new HashMap();
        if (this.A != null) {
            Iterator it9 = hashSet3.iterator();
            float f11 = Float.NaN;
            while (it9.hasNext()) {
                String str11 = (String) it9.next();
                e2.c f12 = e2.c.f(str11);
                if (f12 != null) {
                    if (f12.e() && Float.isNaN(f11)) {
                        f11 = s();
                    }
                    f12.c(str11);
                    this.D.put(str11, f12);
                }
            }
            Iterator it10 = this.A.iterator();
            while (it10.hasNext()) {
            }
            Iterator it11 = this.D.values().iterator();
            while (it11.hasNext()) {
                ((e2.c) it11.next()).d(f11);
            }
        }
    }

    public void J(m mVar) {
        this.f٢٠٢٥g.t(mVar, mVar.f٢٠٢٥g);
        this.f٢٠٢٦h.t(mVar, mVar.f٢٠٢٦h);
    }

    public void a(d dVar) {
        this.A.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h10 = this.f٢٠٢٩k[0].h();
        if (iArr != null) {
            Iterator it = this.f٢٠٤٣y.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = ((o) it.next()).f٢٠٦٢p;
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < h10.length; i12++) {
            this.f٢٠٢٩k[0].d(h10[i12], this.f٢٠٣٧s);
            this.f٢٠٢٥g.g(h10[i12], this.f٢٠٣٦r, this.f٢٠٣٧s, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float[] fArr, int i10) {
        a2.j jVar;
        a2.j jVar2;
        e2.c cVar;
        double d10;
        float f10 = 1.0f;
        float f11 = 1.0f / (i10 - 1);
        HashMap hashMap = this.C;
        e2.c cVar2 = null;
        if (hashMap == null) {
            jVar = null;
        } else {
            jVar = (a2.j) hashMap.get("translationX");
        }
        HashMap hashMap2 = this.C;
        if (hashMap2 == null) {
            jVar2 = null;
        } else {
            jVar2 = (a2.j) hashMap2.get("translationY");
        }
        HashMap hashMap3 = this.D;
        if (hashMap3 == null) {
            cVar = null;
        } else {
            cVar = (e2.c) hashMap3.get("translationX");
        }
        HashMap hashMap4 = this.D;
        if (hashMap4 != null) {
            cVar2 = (e2.c) hashMap4.get("translationY");
        }
        e2.c cVar3 = cVar2;
        int i11 = 0;
        while (i11 < i10) {
            float f12 = i11 * f11;
            float f13 = this.f٢٠٣٣o;
            float f14 = DownloadProgress.UNKNOWN_PROGRESS;
            if (f13 != f10) {
                float f15 = this.f٢٠٣٢n;
                if (f12 < f15) {
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (f12 > f15 && f12 < 1.0d) {
                    f12 = Math.min((f12 - f15) * f13, f10);
                }
            }
            float f16 = f12;
            double d11 = f16;
            a2.c cVar4 = this.f٢٠٢٥g.f٢٠٤٧a;
            Iterator it = this.f٢٠٤٣y.iterator();
            float f17 = Float.NaN;
            while (it.hasNext()) {
                o oVar = (o) it.next();
                a2.c cVar5 = oVar.f٢٠٤٧a;
                double d12 = d11;
                if (cVar5 != null) {
                    float f18 = oVar.f٢٠٤٩c;
                    if (f18 < f16) {
                        f14 = f18;
                        cVar4 = cVar5;
                    } else if (Float.isNaN(f17)) {
                        f17 = oVar.f٢٠٤٩c;
                    }
                }
                d11 = d12;
            }
            double d13 = d11;
            if (cVar4 != null) {
                if (Float.isNaN(f17)) {
                    f17 = 1.0f;
                }
                d10 = (((float) cVar4.a((f16 - f14) / r16)) * (f17 - f14)) + f14;
            } else {
                d10 = d13;
            }
            this.f٢٠٢٩k[0].d(d10, this.f٢٠٣٧s);
            a2.b bVar = this.f٢٠٣٠l;
            if (bVar != null) {
                double[] dArr = this.f٢٠٣٧s;
                if (dArr.length > 0) {
                    bVar.d(d10, dArr);
                }
            }
            int i12 = i11 * 2;
            int i13 = i11;
            this.f٢٠٢٥g.g(d10, this.f٢٠٣٦r, this.f٢٠٣٧s, fArr, i12);
            if (cVar != null) {
                fArr[i12] = fArr[i12] + cVar.a(f16);
            } else if (jVar != null) {
                fArr[i12] = fArr[i12] + jVar.a(f16);
            }
            if (cVar3 != null) {
                int i14 = i12 + 1;
                fArr[i14] = fArr[i14] + cVar3.a(f16);
            } else if (jVar2 != null) {
                int i15 = i12 + 1;
                fArr[i15] = fArr[i15] + jVar2.a(f16);
            }
            i11 = i13 + 1;
            f10 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f10, float[] fArr, int i10) {
        this.f٢٠٢٩k[0].d(g(f10, null), this.f٢٠٣٧s);
        this.f٢٠٢٥g.k(this.f٢٠٣٦r, this.f٢٠٣٧s, fArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z10) {
        k[] kVarArr;
        if ("button".equals(androidx.constraintlayout.motion.widget.a.d(this.f٢٠٢٠b)) && (kVarArr = this.E) != null && kVarArr.length > 0) {
            k kVar = kVarArr[0];
            throw null;
        }
    }

    public int h() {
        return this.f٢٠٢٥g.f٢٠٥٨l;
    }

    public void i(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f٢٠٢٩k[0].d(d10, dArr);
        this.f٢٠٢٩k[0].g(d10, dArr2);
        Arrays.fill(fArr2, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٢٠٢٥g.h(d10, this.f٢٠٣٦r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f٢٠٣٤p;
    }

    public float k() {
        return this.f٢٠٣٥q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float g10 = g(f10, this.f٢٠٤٤z);
        a2.b[] bVarArr = this.f٢٠٢٩k;
        int i10 = 0;
        if (bVarArr != null) {
            double d10 = g10;
            bVarArr[0].g(d10, this.f٢٠٣٨t);
            this.f٢٠٢٩k[0].d(d10, this.f٢٠٣٧s);
            float f13 = this.f٢٠٤٤z[0];
            while (true) {
                dArr = this.f٢٠٣٨t;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] * f13;
                i10++;
            }
            a2.b bVar = this.f٢٠٣٠l;
            if (bVar != null) {
                double[] dArr2 = this.f٢٠٣٧s;
                if (dArr2.length > 0) {
                    bVar.d(d10, dArr2);
                    this.f٢٠٣٠l.g(d10, this.f٢٠٣٨t);
                    this.f٢٠٢٥g.r(f11, f12, fArr, this.f٢٠٣٦r, this.f٢٠٣٨t, this.f٢٠٣٧s);
                    return;
                }
                return;
            }
            this.f٢٠٢٥g.r(f11, f12, fArr, this.f٢٠٣٦r, dArr, this.f٢٠٣٧s);
            return;
        }
        o oVar = this.f٢٠٢٦h;
        float f14 = oVar.f٢٠٥١e;
        o oVar2 = this.f٢٠٢٥g;
        float f15 = f14 - oVar2.f٢٠٥١e;
        float f16 = oVar.f٢٠٥٢f - oVar2.f٢٠٥٢f;
        float f17 = (oVar.f٢٠٥٣g - oVar2.f٢٠٥٣g) + f15;
        float f18 = (oVar.f٢٠٥٤h - oVar2.f٢٠٥٤h) + f16;
        fArr[0] = (f15 * (1.0f - f11)) + (f17 * f11);
        fArr[1] = (f16 * (1.0f - f12)) + (f18 * f12);
    }

    public int m() {
        int i10 = this.f٢٠٢٥g.f٢٠٤٨b;
        Iterator it = this.f٢٠٤٣y.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, ((o) it.next()).f٢٠٤٨b);
        }
        return Math.max(i10, this.f٢٠٢٦h.f٢٠٤٨b);
    }

    public float n() {
        return this.f٢٠٢٦h.f٢٠٥١e;
    }

    public float o() {
        return this.f٢٠٢٦h.f٢٠٥٢f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o q(int i10) {
        return (o) this.f٢٠٤٣y.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        a2.j jVar;
        a2.j jVar2;
        a2.j jVar3;
        a2.j jVar4;
        a2.j jVar5;
        e2.c cVar;
        e2.c cVar2;
        e2.c cVar3;
        e2.c cVar4;
        float g10 = g(f10, this.f٢٠٤٤z);
        HashMap hashMap = this.C;
        e2.c cVar5 = null;
        if (hashMap == null) {
            jVar = null;
        } else {
            jVar = (a2.j) hashMap.get("translationX");
        }
        HashMap hashMap2 = this.C;
        if (hashMap2 == null) {
            jVar2 = null;
        } else {
            jVar2 = (a2.j) hashMap2.get("translationY");
        }
        HashMap hashMap3 = this.C;
        if (hashMap3 == null) {
            jVar3 = null;
        } else {
            jVar3 = (a2.j) hashMap3.get("rotation");
        }
        HashMap hashMap4 = this.C;
        if (hashMap4 == null) {
            jVar4 = null;
        } else {
            jVar4 = (a2.j) hashMap4.get("scaleX");
        }
        HashMap hashMap5 = this.C;
        if (hashMap5 == null) {
            jVar5 = null;
        } else {
            jVar5 = (a2.j) hashMap5.get("scaleY");
        }
        HashMap hashMap6 = this.D;
        if (hashMap6 == null) {
            cVar = null;
        } else {
            cVar = (e2.c) hashMap6.get("translationX");
        }
        HashMap hashMap7 = this.D;
        if (hashMap7 == null) {
            cVar2 = null;
        } else {
            cVar2 = (e2.c) hashMap7.get("translationY");
        }
        HashMap hashMap8 = this.D;
        if (hashMap8 == null) {
            cVar3 = null;
        } else {
            cVar3 = (e2.c) hashMap8.get("rotation");
        }
        HashMap hashMap9 = this.D;
        if (hashMap9 == null) {
            cVar4 = null;
        } else {
            cVar4 = (e2.c) hashMap9.get("scaleX");
        }
        HashMap hashMap10 = this.D;
        if (hashMap10 != null) {
            cVar5 = (e2.c) hashMap10.get("scaleY");
        }
        a2.p pVar = new a2.p();
        pVar.b();
        pVar.d(jVar3, g10);
        pVar.h(jVar, jVar2, g10);
        pVar.f(jVar4, jVar5, g10);
        pVar.c(cVar3, g10);
        pVar.g(cVar, cVar2, g10);
        pVar.e(cVar4, cVar5, g10);
        a2.b bVar = this.f٢٠٣٠l;
        if (bVar != null) {
            double[] dArr = this.f٢٠٣٧s;
            if (dArr.length > 0) {
                double d10 = g10;
                bVar.d(d10, dArr);
                this.f٢٠٣٠l.g(d10, this.f٢٠٣٨t);
                this.f٢٠٢٥g.r(f11, f12, fArr, this.f٢٠٣٦r, this.f٢٠٣٨t, this.f٢٠٣٧s);
            }
            pVar.a(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.f٢٠٢٩k != null) {
            double g11 = g(g10, this.f٢٠٤٤z);
            this.f٢٠٢٩k[0].g(g11, this.f٢٠٣٨t);
            this.f٢٠٢٩k[0].d(g11, this.f٢٠٣٧s);
            float f13 = this.f٢٠٤٤z[0];
            while (true) {
                double[] dArr2 = this.f٢٠٣٨t;
                if (i12 < dArr2.length) {
                    dArr2[i12] = dArr2[i12] * f13;
                    i12++;
                } else {
                    this.f٢٠٢٥g.r(f11, f12, fArr, this.f٢٠٣٦r, dArr2, this.f٢٠٣٧s);
                    pVar.a(f11, f12, i10, i11, fArr);
                    return;
                }
            }
        } else {
            o oVar = this.f٢٠٢٦h;
            float f14 = oVar.f٢٠٥١e;
            o oVar2 = this.f٢٠٢٥g;
            float f15 = f14 - oVar2.f٢٠٥١e;
            e2.c cVar6 = cVar5;
            float f16 = oVar.f٢٠٥٢f - oVar2.f٢٠٥٢f;
            e2.c cVar7 = cVar4;
            float f17 = (oVar.f٢٠٥٣g - oVar2.f٢٠٥٣g) + f15;
            float f18 = (oVar.f٢٠٥٤h - oVar2.f٢٠٥٤h) + f16;
            fArr[0] = (f15 * (1.0f - f11)) + (f17 * f11);
            fArr[1] = (f16 * (1.0f - f12)) + (f18 * f12);
            pVar.b();
            pVar.d(jVar3, g10);
            pVar.h(jVar, jVar2, g10);
            pVar.f(jVar4, jVar5, g10);
            pVar.c(cVar3, g10);
            pVar.g(cVar, cVar2, g10);
            pVar.e(cVar7, cVar6, g10);
            pVar.a(f11, f12, i10, i11, fArr);
        }
    }

    public float t() {
        return this.f٢٠٢٥g.f٢٠٥١e;
    }

    public String toString() {
        return " start: x: " + this.f٢٠٢٥g.f٢٠٥١e + " y: " + this.f٢٠٢٥g.f٢٠٥٢f + " end: x: " + this.f٢٠٢٦h.f٢٠٥١e + " y: " + this.f٢٠٢٦h.f٢٠٥٢f;
    }

    public float u() {
        return this.f٢٠٢٥g.f٢٠٥٢f;
    }

    public View v() {
        return this.f٢٠٢٠b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(View view, float f10, long j10, a2.d dVar) {
        f.d dVar2;
        boolean z10;
        int i10;
        double d10;
        int i11;
        float f11;
        float g10 = g(f10, null);
        int i12 = this.I;
        if (i12 != d.f١٩٥١f) {
            float f12 = 1.0f / i12;
            float floor = ((float) Math.floor(g10 / f12)) * f12;
            float f13 = (g10 % f12) / f12;
            if (!Float.isNaN(this.J)) {
                f13 = (f13 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f13);
            } else if (f13 > 0.5d) {
                f11 = 1.0f;
            } else {
                f11 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            g10 = (f11 * f12) + floor;
        }
        float f14 = g10;
        HashMap hashMap = this.C;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((e2.d) it.next()).h(view, f14);
            }
        }
        HashMap hashMap2 = this.f٢٠١٨B;
        if (hashMap2 != null) {
            dVar2 = null;
            boolean z11 = false;
            for (e2.f fVar : hashMap2.values()) {
                if (fVar instanceof f.d) {
                    dVar2 = (f.d) fVar;
                } else {
                    z11 |= fVar.h(view, f14, j10, dVar);
                }
            }
            z10 = z11;
        } else {
            dVar2 = null;
            z10 = false;
        }
        a2.b[] bVarArr = this.f٢٠٢٩k;
        if (bVarArr != null) {
            double d11 = f14;
            bVarArr[0].d(d11, this.f٢٠٣٧s);
            this.f٢٠٢٩k[0].g(d11, this.f٢٠٣٨t);
            a2.b bVar = this.f٢٠٣٠l;
            if (bVar != null) {
                double[] dArr = this.f٢٠٣٧s;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                    this.f٢٠٣٠l.g(d11, this.f٢٠٣٨t);
                }
            }
            if (!this.L) {
                d10 = d11;
                i11 = 1;
                this.f٢٠٢٥g.s(f14, view, this.f٢٠٣٦r, this.f٢٠٣٧s, this.f٢٠٣٨t, null, this.f٢٠٢٢d);
                this.f٢٠٢٢d = false;
            } else {
                d10 = d11;
                i11 = 1;
            }
            if (this.G != d.f١٩٥١f) {
                if (this.H == null) {
                    this.H = ((View) view.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top = (r1.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap hashMap3 = this.C;
            if (hashMap3 != null) {
                for (a2.j jVar : hashMap3.values()) {
                    if (jVar instanceof d.C٠١٥٦d) {
                        double[] dArr2 = this.f٢٠٣٨t;
                        if (dArr2.length > i11) {
                            ((d.C٠١٥٦d) jVar).i(view, f14, dArr2[0], dArr2[i11]);
                        }
                    }
                }
            }
            if (dVar2 != null) {
                double[] dArr3 = this.f٢٠٣٨t;
                double d12 = dArr3[0];
                double d13 = dArr3[i11];
                i10 = 0;
                z10 |= dVar2.i(view, dVar, f14, j10, d12, d13);
            } else {
                i10 = 0;
            }
            int i13 = 1;
            while (true) {
                a2.b[] bVarArr2 = this.f٢٠٢٩k;
                if (i13 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i13].e(d10, this.f٢٠٤٢x);
                e2.a.b((androidx.constraintlayout.widget.a) this.f٢٠٢٥g.f٢٠٦١o.get(this.f٢٠٣٩u[i13 - 1]), view, this.f٢٠٤٢x);
                i13++;
            }
            l lVar = this.f٢٠٢٧i;
            if (lVar.f١٩٩٣b == 0) {
                if (f14 <= DownloadProgress.UNKNOWN_PROGRESS) {
                    view.setVisibility(lVar.f١٩٩٤c);
                } else if (f14 >= 1.0f) {
                    view.setVisibility(this.f٢٠٢٨j.f١٩٩٤c);
                } else if (this.f٢٠٢٨j.f١٩٩٤c != lVar.f١٩٩٤c) {
                    view.setVisibility(i10);
                }
            }
            k[] kVarArr = this.E;
            if (kVarArr != null && kVarArr.length > 0) {
                k kVar = kVarArr[i10];
                throw null;
            }
        } else {
            i10 = 0;
            o oVar = this.f٢٠٢٥g;
            float f15 = oVar.f٢٠٥١e;
            o oVar2 = this.f٢٠٢٦h;
            float f16 = f15 + ((oVar2.f٢٠٥١e - f15) * f14);
            float f17 = oVar.f٢٠٥٢f;
            float f18 = f17 + ((oVar2.f٢٠٥٢f - f17) * f14);
            float f19 = oVar.f٢٠٥٣g;
            float f20 = oVar2.f٢٠٥٣g;
            float f21 = oVar.f٢٠٥٤h;
            float f22 = oVar2.f٢٠٥٤h;
            float f23 = f16 + 0.5f;
            int i14 = (int) f23;
            float f24 = f18 + 0.5f;
            int i15 = (int) f24;
            int i16 = (int) (f23 + ((f20 - f19) * f14) + f19);
            int i17 = (int) (f24 + ((f22 - f21) * f14) + f21);
            int i18 = i16 - i14;
            int i19 = i17 - i15;
            if (f20 != f19 || f22 != f21 || this.f٢٠٢٢d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                this.f٢٠٢٢d = false;
            }
            view.layout(i14, i15, i16, i17);
        }
        HashMap hashMap4 = this.D;
        if (hashMap4 != null) {
            for (e2.c cVar : hashMap4.values()) {
                if (cVar instanceof c.d) {
                    double[] dArr4 = this.f٢٠٣٨t;
                    ((c.d) cVar).h(view, f14, dArr4[i10], dArr4[1]);
                } else {
                    cVar.g(view, f14);
                }
            }
        }
        return z10;
    }

    public void z() {
        this.f٢٠٢٢d = true;
    }
}
