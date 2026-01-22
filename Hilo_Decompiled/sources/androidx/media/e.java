package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    f f٣٩٦٨a;

    public e(String str, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f٣٩٦٨a = new i(str, i10, i11);
        } else {
            this.f٣٩٦٨a = new j(str, i10, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f٣٩٦٨a.equals(((e) obj).f٣٩٦٨a);
    }

    public int hashCode() {
        return this.f٣٩٦٨a.hashCode();
    }

    public e(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f٣٩٦٨a = new i(remoteUserInfo);
    }
}
