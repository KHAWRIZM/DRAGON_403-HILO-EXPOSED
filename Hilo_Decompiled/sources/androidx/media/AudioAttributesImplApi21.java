package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    AudioAttributes f٣٨٦٩a;

    /* renamed from: b, reason: collision with root package name */
    int f٣٨٧٠b = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f٣٨٦٩a.equals(((AudioAttributesImplApi21) obj).f٣٨٦٩a);
    }

    public int hashCode() {
        return this.f٣٨٦٩a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f٣٨٦٩a;
    }
}
