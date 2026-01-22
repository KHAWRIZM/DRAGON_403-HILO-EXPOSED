package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.a;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f٢٨٠٣a = aVar.p(iconCompat.f٢٨٠٣a, 1);
        iconCompat.f٢٨٠٥c = aVar.j(iconCompat.f٢٨٠٥c, 2);
        iconCompat.f٢٨٠٦d = aVar.r(iconCompat.f٢٨٠٦d, 3);
        iconCompat.f٢٨٠٧e = aVar.p(iconCompat.f٢٨٠٧e, 4);
        iconCompat.f٢٨٠٨f = aVar.p(iconCompat.f٢٨٠٨f, 5);
        iconCompat.f٢٨٠٩g = (ColorStateList) aVar.r(iconCompat.f٢٨٠٩g, 6);
        iconCompat.f٢٨١١i = aVar.t(iconCompat.f٢٨١١i, 7);
        iconCompat.f٢٨١٢j = aVar.t(iconCompat.f٢٨١٢j, 8);
        iconCompat.j();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.k(aVar.f());
        int i10 = iconCompat.f٢٨٠٣a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f٢٨٠٥c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f٢٨٠٦d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f٢٨٠٧e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f٢٨٠٨f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f٢٨٠٩g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f٢٨١١i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f٢٨١٢j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
