package com.oudi.utils.ktx;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"asLifecycle", "Landroidx/lifecycle/Lifecycle;", "Landroid/content/Context;", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ContextKtxKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Lifecycle asLifecycle(Context context) {
        if (context == 0) {
            return null;
        }
        if (context instanceof LifecycleOwner) {
            return ((LifecycleOwner) context).getLifecycle();
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return asLifecycle(((ContextWrapper) context).getBaseContext());
    }
}
