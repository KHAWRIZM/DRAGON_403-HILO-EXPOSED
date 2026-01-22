package com.qhqc.core.feature.community;

import android.content.Context;
import android.content.ContextWrapper;
import com.qhqc.core.basic.uiframe.ui.BasicActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/qhqc/core/feature/community/ActivityUtils;", "", "<init>", "()V", "getActivity", "Lcom/qhqc/core/basic/uiframe/ui/BasicActivity;", "context", "Landroid/content/Context;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ActivityUtils {

    @NotNull
    public static final ActivityUtils INSTANCE = new ActivityUtils();

    private ActivityUtils() {
    }

    @Nullable
    public final BasicActivity getActivity(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof BasicActivity) {
            return (BasicActivity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return getActivity(((ContextWrapper) context).getBaseContext());
    }
}
