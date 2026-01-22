package k3;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements w9.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f١٥٤٨٤a;

    public d(Function0 function0) {
        this.f١٥٤٨٤a = function0;
    }

    @Override // w9.c
    public final void onResult(List grantedList, List deniedList) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(grantedList, "grantedList");
        Intrinsics.checkNotNullParameter(deniedList, "deniedList");
        if (deniedList.isEmpty() && (function0 = this.f١٥٤٨٤a) != null) {
            function0.invoke();
        }
    }
}
