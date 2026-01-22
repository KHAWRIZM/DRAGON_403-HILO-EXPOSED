package androidx.media;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(androidx.versionedparcelable.a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f٣٨٧١a = aVar.p(audioAttributesImplBase.f٣٨٧١a, 1);
        audioAttributesImplBase.f٣٨٧٢b = aVar.p(audioAttributesImplBase.f٣٨٧٢b, 2);
        audioAttributesImplBase.f٣٨٧٣c = aVar.p(audioAttributesImplBase.f٣٨٧٣c, 3);
        audioAttributesImplBase.f٣٨٧٤d = aVar.p(audioAttributesImplBase.f٣٨٧٤d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f٣٨٧١a, 1);
        aVar.F(audioAttributesImplBase.f٣٨٧٢b, 2);
        aVar.F(audioAttributesImplBase.f٣٨٧٣c, 3);
        aVar.F(audioAttributesImplBase.f٣٨٧٤d, 4);
    }
}
