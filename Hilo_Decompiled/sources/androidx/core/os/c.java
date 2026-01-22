package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        static void b(Configuration configuration, f fVar) {
            configuration.setLocales((LocaleList) fVar.i());
        }
    }

    public static f a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return f.j(a.a(configuration));
        }
        return f.a(configuration.locale);
    }

    public static void b(Configuration configuration, f fVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(configuration, fVar);
        } else if (!fVar.f()) {
            configuration.setLocale(fVar.d(0));
        }
    }
}
