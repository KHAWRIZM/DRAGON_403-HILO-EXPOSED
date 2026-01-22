package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(androidx.versionedparcelable.a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f٣٨٦٩a = (AudioAttributes) aVar.r(audioAttributesImplApi21.f٣٨٦٩a, 1);
        audioAttributesImplApi21.f٣٨٧٠b = aVar.p(audioAttributesImplApi21.f٣٨٧٠b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi21.f٣٨٦٩a, 1);
        aVar.F(audioAttributesImplApi21.f٣٨٧٠b, 2);
    }
}
