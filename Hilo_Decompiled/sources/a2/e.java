package a2;

import androidx.appcompat.app.a0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private a2.b f١٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private b f١٣١b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٣d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f١٣٤e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f١٣٥f = 0;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f١٣٦g = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Comparator {
        a() {
        }

        public int a(c cVar, c cVar2) {
            throw null;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a0.a(obj);
            a0.a(obj2);
            return a(null, null);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f١٣٨a;

        /* renamed from: b, reason: collision with root package name */
        h f١٣٩b;

        /* renamed from: c, reason: collision with root package name */
        private final int f١٤٠c;

        /* renamed from: d, reason: collision with root package name */
        private final int f١٤١d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١٤٢e;

        /* renamed from: f, reason: collision with root package name */
        float[] f١٤٣f;

        /* renamed from: g, reason: collision with root package name */
        double[] f١٤٤g;

        /* renamed from: h, reason: collision with root package name */
        float[] f١٤٥h;

        /* renamed from: i, reason: collision with root package name */
        float[] f١٤٦i;

        /* renamed from: j, reason: collision with root package name */
        float[] f١٤٧j;

        /* renamed from: k, reason: collision with root package name */
        float[] f١٤٨k;

        /* renamed from: l, reason: collision with root package name */
        int f١٤٩l;

        /* renamed from: m, reason: collision with root package name */
        a2.b f١٥٠m;

        /* renamed from: n, reason: collision with root package name */
        double[] f١٥١n;

        /* renamed from: o, reason: collision with root package name */
        double[] f١٥٢o;

        /* renamed from: p, reason: collision with root package name */
        float f١٥٣p;

        b(int i10, String str, int i11, int i12) {
            h hVar = new h();
            this.f١٣٩b = hVar;
            this.f١٤٠c = 0;
            this.f١٤١d = 1;
            this.f١٤٢e = 2;
            this.f١٤٩l = i10;
            this.f١٣٨a = i11;
            hVar.g(i10, str);
            this.f١٤٣f = new float[i12];
            this.f١٤٤g = new double[i12];
            this.f١٤٥h = new float[i12];
            this.f١٤٦i = new float[i12];
            this.f١٤٧j = new float[i12];
            this.f١٤٨k = new float[i12];
        }

        public double a(float f10) {
            a2.b bVar = this.f١٥٠m;
            if (bVar != null) {
                double d10 = f10;
                bVar.g(d10, this.f١٥٢o);
                this.f١٥٠m.d(d10, this.f١٥١n);
            } else {
                double[] dArr = this.f١٥٢o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f10;
            double e10 = this.f١٣٩b.e(d11, this.f١٥١n[1]);
            double d12 = this.f١٣٩b.d(d11, this.f١٥١n[1], this.f١٥٢o[1]);
            double[] dArr2 = this.f١٥٢o;
            return dArr2[0] + (e10 * dArr2[2]) + (d12 * this.f١٥١n[2]);
        }

        public double b(float f10) {
            a2.b bVar = this.f١٥٠m;
            if (bVar != null) {
                bVar.d(f10, this.f١٥١n);
            } else {
                double[] dArr = this.f١٥١n;
                dArr[0] = this.f١٤٦i[0];
                dArr[1] = this.f١٤٧j[0];
                dArr[2] = this.f١٤٣f[0];
            }
            double[] dArr2 = this.f١٥١n;
            return dArr2[0] + (this.f١٣٩b.e(f10, dArr2[1]) * this.f١٥١n[2]);
        }

        public void c(float f10) {
            this.f١٥٣p = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f١٤٤g.length, 3);
            float[] fArr = this.f١٤٣f;
            this.f١٥١n = new double[fArr.length + 2];
            this.f١٥٢o = new double[fArr.length + 2];
            if (this.f١٤٤g[0] > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.f١٣٩b.a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.f١٤٥h[0]);
            }
            double[] dArr2 = this.f١٤٤g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f١٣٩b.a(1.0d, this.f١٤٥h[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.f١٤٦i[i10];
                dArr3[1] = this.f١٤٧j[i10];
                dArr3[2] = this.f١٤٣f[i10];
                this.f١٣٩b.a(this.f١٤٤g[i10], this.f١٤٥h[i10]);
            }
            this.f١٣٩b.f();
            double[] dArr4 = this.f١٤٤g;
            if (dArr4.length > 1) {
                this.f١٥٠m = a2.b.a(0, dArr4, dArr);
            } else {
                this.f١٥٠m = null;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class c {
    }

    public float a(float f10) {
        return (float) this.f١٣١b.b(f10);
    }

    public float b(float f10) {
        return (float) this.f١٣١b.a(f10);
    }

    public void c(String str) {
        this.f١٣٢c = str;
    }

    public void d(float f10) {
        int size = this.f١٣٦g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f١٣٦g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f١٣١b = new b(this.f١٣٣d, this.f١٣٤e, this.f١٣٥f, size);
        Iterator it = this.f١٣٦g.iterator();
        if (!it.hasNext()) {
            this.f١٣١b.c(f10);
            this.f١٣٠a = a2.b.a(0, dArr, dArr2);
        } else {
            a0.a(it.next());
            throw null;
        }
    }

    public boolean e() {
        if (this.f١٣٥f == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = this.f١٣٢c;
        new DecimalFormat("##.##");
        Iterator it = this.f١٣٦g.iterator();
        if (!it.hasNext()) {
            return str;
        }
        a0.a(it.next());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("[");
        throw null;
    }
}
