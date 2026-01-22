package e2;

import a2.o;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends f {
        a() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setAlpha(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends f {

        /* renamed from: l, reason: collision with root package name */
        String f١٣٨٧٤l;

        /* renamed from: m, reason: collision with root package name */
        SparseArray f١٣٨٧٥m;

        /* renamed from: n, reason: collision with root package name */
        SparseArray f١٣٨٧٦n = new SparseArray();

        /* renamed from: o, reason: collision with root package name */
        float[] f١٣٨٧٧o;

        /* renamed from: p, reason: collision with root package name */
        float[] f١٣٨٧٨p;

        public b(String str, SparseArray sparseArray) {
            this.f١٣٨٧٤l = str.split(",")[1];
            this.f١٣٨٧٥m = sparseArray;
        }

        @Override // a2.o
        public void d(int i10) {
            int size = this.f١٣٨٧٥m.size();
            int g10 = ((androidx.constraintlayout.widget.a) this.f١٣٨٧٥m.valueAt(0)).g();
            double[] dArr = new double[size];
            int i11 = g10 + 2;
            this.f١٣٨٧٧o = new float[i11];
            this.f١٣٨٧٨p = new float[g10];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f١٣٨٧٥m.keyAt(i12);
                androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f١٣٨٧٥m.valueAt(i12);
                float[] fArr = (float[]) this.f١٣٨٧٦n.valueAt(i12);
                dArr[i12] = keyAt * 0.01d;
                aVar.e(this.f١٣٨٧٧o);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f١٣٨٧٧o.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[g10] = fArr[0];
                dArr3[g10 + 1] = fArr[1];
            }
            this.f٢٠٧a = a2.b.a(i10, dArr, dArr2);
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            boolean z10;
            this.f٢٠٧a.e(f10, this.f١٣٨٧٧o);
            float[] fArr = this.f١٣٨٧٧o;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f٢١٥i;
            if (Float.isNaN(this.f٢١٦j)) {
                float a10 = dVar.a(view, this.f١٣٨٧٤l, 0);
                this.f٢١٦j = a10;
                if (Float.isNaN(a10)) {
                    this.f٢١٦j = DownloadProgress.UNKNOWN_PROGRESS;
                }
            }
            float f13 = (float) ((this.f٢١٦j + ((j11 * 1.0E-9d) * f11)) % 1.0d);
            this.f٢١٦j = f13;
            this.f٢١٥i = j10;
            float a11 = a(f13);
            this.f٢١٤h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f١٣٨٧٨p;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z11 = this.f٢١٤h;
                float f14 = this.f١٣٨٧٧o[i10];
                if (f14 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f٢١٤h = z11 | z10;
                fArr2[i10] = (f14 * a11) + f12;
                i10++;
            }
            e2.a.b((androidx.constraintlayout.widget.a) this.f١٣٨٧٥m.valueAt(0), view, this.f١٣٨٧٨p);
            if (f11 != DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٢١٤h = true;
            }
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends f {
        c() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setElevation(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends f {
        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            return this.f٢١٤h;
        }

        public boolean i(View view, a2.d dVar, float f10, long j10, double d10, double d11) {
            view.setRotation(e(f10, j10, view, dVar) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e extends f {

        /* renamed from: l, reason: collision with root package name */
        boolean f١٣٨٧٩l = false;

        e() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(e(f10, j10, view, dVar));
            } else {
                if (this.f١٣٨٧٩l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f١٣٨٧٩l = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(e(f10, j10, view, dVar)));
                    } catch (IllegalAccessException e10) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    }
                }
            }
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e2.f$f, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠١٥٧f extends f {
        C٠١٥٧f() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setRotation(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g extends f {
        g() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setRotationX(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class h extends f {
        h() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setRotationY(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class i extends f {
        i() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setScaleX(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class j extends f {
        j() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setScaleY(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class k extends f {
        k() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setTranslationX(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class l extends f {
        l() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setTranslationY(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class m extends f {
        m() {
        }

        @Override // e2.f
        public boolean h(View view, float f10, long j10, a2.d dVar) {
            view.setTranslationZ(e(f10, j10, view, dVar));
            return this.f٢١٤h;
        }
    }

    public static f f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x009c. Please report as an issue. */
    public static f g(String str, long j10) {
        f gVar;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c10 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 11;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                gVar = new g();
                gVar.b(j10);
                return gVar;
            case 1:
                gVar = new h();
                gVar.b(j10);
                return gVar;
            case 2:
                gVar = new k();
                gVar.b(j10);
                return gVar;
            case 3:
                gVar = new l();
                gVar.b(j10);
                return gVar;
            case 4:
                gVar = new m();
                gVar.b(j10);
                return gVar;
            case 5:
                gVar = new e();
                gVar.b(j10);
                return gVar;
            case 6:
                gVar = new i();
                gVar.b(j10);
                return gVar;
            case 7:
                gVar = new j();
                gVar.b(j10);
                return gVar;
            case '\b':
                gVar = new C٠١٥٧f();
                gVar.b(j10);
                return gVar;
            case '\t':
                gVar = new c();
                gVar.b(j10);
                return gVar;
            case '\n':
                gVar = new d();
                gVar.b(j10);
                return gVar;
            case 11:
                gVar = new a();
                gVar.b(j10);
                return gVar;
            default:
                return null;
        }
    }

    public float e(float f10, long j10, View view, a2.d dVar) {
        boolean z10;
        this.f٢٠٧a.e(f10, this.f٢١٣g);
        float[] fArr = this.f٢١٣g;
        float f11 = fArr[1];
        if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٢١٤h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f٢١٦j)) {
            float a10 = dVar.a(view, this.f٢١٢f, 0);
            this.f٢١٦j = a10;
            if (Float.isNaN(a10)) {
                this.f٢١٦j = DownloadProgress.UNKNOWN_PROGRESS;
            }
        }
        float f12 = (float) ((this.f٢١٦j + (((j10 - this.f٢١٥i) * 1.0E-9d) * f11)) % 1.0d);
        this.f٢١٦j = f12;
        dVar.b(view, this.f٢١٢f, 0, f12);
        this.f٢١٥i = j10;
        float f13 = this.f٢١٣g[0];
        float a11 = (a(this.f٢١٦j) * f13) + this.f٢١٣g[2];
        if (f13 == DownloadProgress.UNKNOWN_PROGRESS && f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f٢١٤h = z10;
        return a11;
    }

    public abstract boolean h(View view, float f10, long j10, a2.d dVar);
}
