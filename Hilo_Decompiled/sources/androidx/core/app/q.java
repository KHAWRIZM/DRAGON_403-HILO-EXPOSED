package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.o;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.bolts.AppLinks;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f٢٧٠٢a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f٢٧٠٣b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(o.a aVar) {
        int i10;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat d10 = aVar.d();
        if (d10 != null) {
            i10 = d10.e();
        } else {
            i10 = 0;
        }
        bundle2.putInt("icon", i10);
        bundle2.putCharSequence("title", aVar.h());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.c() != null) {
            bundle = new Bundle(aVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle(AppLinks.KEY_NAME_EXTRAS, bundle);
        bundle2.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle2.putBoolean("showsUserInterface", aVar.g());
        bundle2.putInt("semanticAction", aVar.f());
        return bundle2;
    }

    private static Bundle b(t tVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(t[] tVarArr) {
        if (tVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[tVarArr.length];
        for (int i10 = 0; i10 < tVarArr.length; i10++) {
            t tVar = tVarArr[i10];
            bundleArr[i10] = b(null);
        }
        return bundleArr;
    }
}
