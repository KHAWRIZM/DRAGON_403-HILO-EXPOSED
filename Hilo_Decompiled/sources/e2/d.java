package e2;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d extends a2.j {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a extends d {
        a() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setAlpha(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends d {

        /* renamed from: f, reason: collision with root package name */
        String f١٣٨٧٠f;

        /* renamed from: g, reason: collision with root package name */
        SparseArray f١٣٨٧١g;

        /* renamed from: h, reason: collision with root package name */
        float[] f١٣٨٧٢h;

        public b(String str, SparseArray sparseArray) {
            this.f١٣٨٧٠f = str.split(",")[1];
            this.f١٣٨٧١g = sparseArray;
        }

        @Override // a2.j
        public void c(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // a2.j
        public void e(int i10) {
            int size = this.f١٣٨٧١g.size();
            int g10 = ((androidx.constraintlayout.widget.a) this.f١٣٨٧١g.valueAt(0)).g();
            double[] dArr = new double[size];
            this.f١٣٨٧٢h = new float[g10];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, g10);
            for (int i11 = 0; i11 < size; i11++) {
                int keyAt = this.f١٣٨٧١g.keyAt(i11);
                androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f١٣٨٧١g.valueAt(i11);
                dArr[i11] = keyAt * 0.01d;
                aVar.e(this.f١٣٨٧٢h);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f١٣٨٧٢h.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f١٧٤a = a2.b.a(i10, dArr, dArr2);
        }

        @Override // e2.d
        public void h(View view, float f10) {
            this.f١٧٤a.e(f10, this.f١٣٨٧٢h);
            e2.a.b((androidx.constraintlayout.widget.a) this.f١٣٨٧١g.valueAt(0), view, this.f١٣٨٧٢h);
        }

        public void i(int i10, androidx.constraintlayout.widget.a aVar) {
            this.f١٣٨٧١g.append(i10, aVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class c extends d {
        c() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setElevation(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class e extends d {
        e() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setPivotX(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class f extends d {
        f() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setPivotY(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class g extends d {

        /* renamed from: f, reason: collision with root package name */
        boolean f١٣٨٧٣f = false;

        g() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f10));
                return;
            }
            if (this.f١٣٨٧٣f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f١٣٨٧٣f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("ViewSpline", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("ViewSpline", "unable to setProgress", e11);
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class h extends d {
        h() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setRotation(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class i extends d {
        i() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setRotationX(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class j extends d {
        j() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setRotationY(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class k extends d {
        k() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setScaleX(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class l extends d {
        l() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setScaleY(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class m extends d {
        m() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setTranslationX(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class n extends d {
        n() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setTranslationY(a(f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class o extends d {
        o() {
        }

        @Override // e2.d
        public void h(View view, float f10) {
            view.setTranslationZ(a(f10));
        }
    }

    public static d f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    public static d g(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c10 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c10 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = 15;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new a();
            case '\t':
                return new e();
            case '\n':
                return new f();
            case 11:
                return new h();
            case '\f':
                return new c();
            case '\r':
                return new C٠١٥٦d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f10);

    /* renamed from: e2.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠١٥٦d extends d {
        public void i(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        @Override // e2.d
        public void h(View view, float f10) {
        }
    }
}
