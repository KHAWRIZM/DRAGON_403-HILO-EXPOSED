package ic;

import android.content.Context;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static float f١٤٨٨٦a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    private static int f١٤٨٨٧b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static a f١٤٨٨٨c = a.Default;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private enum a {
        Default,
        Miui,
        Flyme,
        Android6
    }

    public static int a(Context context) {
        if (f١٤٨٨٧b == -1) {
            b(context);
        }
        return f١٤٨٨٧b;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Context context) {
        Throwable th;
        Field field;
        Object obj;
        Class<?> cls;
        Field field2 = null;
        try {
            cls = Class.forName("com.android.internal.R$dimen");
            obj = cls.newInstance();
        } catch (Throwable th2) {
            th = th2;
            field = null;
        }
        try {
            if (d.k()) {
                try {
                    field2 = cls.getField("status_bar_height_large");
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            if (field2 == null) {
                field2 = cls.getField("status_bar_height");
            }
        } catch (Throwable th4) {
            field = field2;
            field2 = obj;
            th = th4;
            th.printStackTrace();
            obj = field2;
            field2 = field;
            if (field2 != null) {
                try {
                    f١٤٨٨٧b = context.getResources().getDimensionPixelSize(Integer.parseInt(field2.get(obj).toString()));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            if (f١٤٨٨٧b > 0) {
            }
        }
        if (field2 != null && obj != null) {
            f١٤٨٨٧b = context.getResources().getDimensionPixelSize(Integer.parseInt(field2.get(obj).toString()));
        }
        if (f١٤٨٨٧b > 0) {
            float f10 = f١٤٨٨٦a;
            if (f10 == -1.0f) {
                f١٤٨٨٧b = e.a(context, 25);
            } else {
                f١٤٨٨٧b = (int) ((f10 * 25.0f) + 0.5f);
            }
        }
    }
}
