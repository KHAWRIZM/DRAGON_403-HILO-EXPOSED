package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static Method f٤٢٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f٤٢٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f٤٢٣١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static void a(Canvas canvas) {
            canvas.disableZ();
        }

        static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Canvas canvas, boolean z10) {
        Method method;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            if (z10) {
                a.b(canvas);
                return;
            } else {
                a.a(canvas);
                return;
            }
        }
        if (i10 != 28) {
            if (!f٤٢٣١c) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    f٤٢٢٩a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                    f٤٢٣٠b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f٤٢٣١c = true;
            }
            if (z10) {
                try {
                    Method method2 = f٤٢٢٩a;
                    if (method2 != null) {
                        method2.invoke(canvas, null);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException(e10.getCause());
                }
            }
            if (!z10 && (method = f٤٢٣٠b) != null) {
                method.invoke(canvas, null);
                return;
            }
            return;
        }
        throw new IllegalStateException("This method doesn't work on Pie!");
    }
}
