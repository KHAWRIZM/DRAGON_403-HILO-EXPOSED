package com.therouter.router.action.interceptor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.therouter.router.Navigator;
import com.therouter.router.NavigatorKt;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/therouter/router/action/interceptor/ActionInterceptor;", "", "()V", "args", "Landroid/os/Bundle;", "priority", "", "getPriority", "()I", "getArguments", "handle", "", "context", "Landroid/content/Context;", "navigator", "Lcom/therouter/router/Navigator;", "onFinish", "", "optActivity", "Landroid/app/Activity;", "setArguments", "b", "setArguments$router_release", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ActionInterceptor {

    @NotNull
    private Bundle args = new Bundle();

    @NotNull
    /* renamed from: getArguments, reason: from getter */
    public final Bundle getArgs() {
        return this.args;
    }

    public int getPriority() {
        return 5;
    }

    public boolean handle(@NotNull Context context, @NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return false;
    }

    public void onFinish() {
    }

    @Nullable
    public final Activity optActivity() {
        Object obj;
        SoftReference<Object> softReference = NavigatorKt.getArguments().get(NavigatorKt.KEY_OBJECT_ACTIVITY);
        if (softReference != null) {
            obj = softReference.get();
        } else {
            obj = null;
        }
        if (!(obj instanceof Activity)) {
            return null;
        }
        return (Activity) obj;
    }

    public final void setArguments$router_release(@NotNull Bundle b) {
        Intrinsics.checkNotNullParameter(b, "b");
        this.args = b;
    }
}
