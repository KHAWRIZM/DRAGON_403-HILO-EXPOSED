package androidx.media;

import android.media.session.MediaSessionManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f٣٩٦٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, int i10, int i11) {
        this.f٣٩٦٩a = h.a(str, i10, i11);
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            equals = this.f٣٩٦٩a.equals(((i) obj).f٣٩٦٩a);
            return equals;
        }
        return false;
    }

    public int hashCode() {
        return androidx.core.util.f.b(this.f٣٩٦٩a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f٣٩٦٩a = remoteUserInfo;
    }
}
