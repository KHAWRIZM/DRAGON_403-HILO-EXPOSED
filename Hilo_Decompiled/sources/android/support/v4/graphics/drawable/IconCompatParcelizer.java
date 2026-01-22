package android.support.v4.graphics.drawable;

import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(aVar);
    }

    public static void write(IconCompat iconCompat, a aVar) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat, aVar);
    }
}
