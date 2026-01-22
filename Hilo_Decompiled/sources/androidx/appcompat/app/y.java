package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class y {
    private static androidx.core.os.f a(androidx.core.os.f fVar, androidx.core.os.f fVar2) {
        Locale d10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i10 = 0; i10 < fVar.g() + fVar2.g(); i10++) {
            if (i10 < fVar.g()) {
                d10 = fVar.d(i10);
            } else {
                d10 = fVar2.d(i10 - fVar.g());
            }
            if (d10 != null) {
                linkedHashSet.add(d10);
            }
        }
        return androidx.core.os.f.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.os.f b(androidx.core.os.f fVar, androidx.core.os.f fVar2) {
        if (fVar != null && !fVar.f()) {
            return a(fVar, fVar2);
        }
        return androidx.core.os.f.e();
    }
}
