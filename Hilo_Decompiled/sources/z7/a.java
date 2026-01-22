package z7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static boolean a(float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (fArr[i10] != f10) {
                return false;
            }
        }
        return true;
    }

    public static float b(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f12 - f10, f13 - f11);
    }

    public static float c(float f10, float f11, float f12, float f13, float f14, float f15) {
        return g(b(f10, f11, f12, f13), b(f10, f11, f14, f13), b(f10, f11, f14, f15), b(f10, f11, f12, f15));
    }

    public static int d(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i12 * i11 != i10) {
            i12--;
        }
        return i10 - (i12 * i11);
    }

    public static boolean e(float f10, float f11, float f12) {
        if (f10 + f12 >= f11) {
            return true;
        }
        return false;
    }

    public static float f(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    private static float g(float f10, float f11, float f12, float f13) {
        if (f10 <= f11 || f10 <= f12 || f10 <= f13) {
            if (f11 > f12 && f11 > f13) {
                return f11;
            }
            if (f12 > f13) {
                return f12;
            }
            return f13;
        }
        return f10;
    }
}
