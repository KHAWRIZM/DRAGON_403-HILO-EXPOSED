package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class u {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 != 0 && i11 != -1) {
                service.startForeground(i10, notification, i11 & KotlinVersion.MAX_COMPONENT_VALUE);
            } else {
                service.startForeground(i10, notification, i11);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 != 0 && i11 != -1) {
                service.startForeground(i10, notification, i11 & 1073745919);
            } else {
                service.startForeground(i10, notification, i11);
            }
        }
    }

    public static void a(Service service, int i10, Notification notification, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 34) {
            b.a(service, i10, notification, i11);
        } else if (i12 >= 29) {
            a.a(service, i10, notification, i11);
        } else {
            service.startForeground(i10, notification);
        }
    }
}
