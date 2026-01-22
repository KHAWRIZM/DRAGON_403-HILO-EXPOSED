package ic;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class g {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static float b(float f10, float f11, float f12) {
        if (f10 < f11) {
            return f11;
        }
        if (f10 > f12) {
            return f12;
        }
        return f10;
    }

    public static int c(int i10, int i11, int i12) {
        if (i10 < i11) {
            return i11;
        }
        if (i10 > i12) {
            return i12;
        }
        return i10;
    }

    public static String d(int i10, int i11) {
        if (e(i10) > i11) {
            StringBuilder sb = new StringBuilder();
            for (int i12 = 1; i12 <= i11; i12++) {
                sb.append("9");
            }
            sb.append("+");
            return sb.toString();
        }
        return String.valueOf(i10);
    }

    public static int e(int i10) {
        if (i10 <= 0) {
            return 0;
        }
        return (int) (Math.log10(i10) + 1.0d);
    }

    public static boolean f(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean g(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }
}
