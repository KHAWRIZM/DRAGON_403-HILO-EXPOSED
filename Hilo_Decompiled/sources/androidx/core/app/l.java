package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }
    }

    public static androidx.core.os.f a(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            Object b10 = b(context);
            if (b10 != null) {
                return androidx.core.os.f.j(a.a(b10));
            }
            return androidx.core.os.f.e();
        }
        return androidx.core.os.f.c(e.b(context));
    }

    private static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
