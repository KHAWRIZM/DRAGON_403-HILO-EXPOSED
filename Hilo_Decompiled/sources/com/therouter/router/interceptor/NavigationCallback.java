package com.therouter.router.interceptor;

import android.app.Activity;
import com.therouter.router.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/therouter/router/interceptor/NavigationCallback;", "", "()V", "onActivityCreated", "", "navigator", "Lcom/therouter/router/Navigator;", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "onArrival", "onFound", "onLost", "requestCode", "", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NavigationCallback {
    public void onActivityCreated(@NotNull Navigator navigator, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
    }

    public void onArrival(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onFound(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onLost(@NotNull Navigator navigator, int requestCode) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }
}
