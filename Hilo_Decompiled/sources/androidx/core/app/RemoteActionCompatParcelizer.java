package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f٢٦١٣a = (IconCompat) aVar.v(remoteActionCompat.f٢٦١٣a, 1);
        remoteActionCompat.f٢٦١٤b = aVar.l(remoteActionCompat.f٢٦١٤b, 2);
        remoteActionCompat.f٢٦١٥c = aVar.l(remoteActionCompat.f٢٦١٥c, 3);
        remoteActionCompat.f٢٦١٦d = (PendingIntent) aVar.r(remoteActionCompat.f٢٦١٦d, 4);
        remoteActionCompat.f٢٦١٧e = aVar.h(remoteActionCompat.f٢٦١٧e, 5);
        remoteActionCompat.f٢٦١٨f = aVar.h(remoteActionCompat.f٢٦١٨f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f٢٦١٣a, 1);
        aVar.D(remoteActionCompat.f٢٦١٤b, 2);
        aVar.D(remoteActionCompat.f٢٦١٥c, 3);
        aVar.H(remoteActionCompat.f٢٦١٦d, 4);
        aVar.z(remoteActionCompat.f٢٦١٧e, 5);
        aVar.z(remoteActionCompat.f٢٦١٨f, 6);
    }
}
