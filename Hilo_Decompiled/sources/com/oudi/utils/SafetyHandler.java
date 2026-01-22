package com.oudi.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oudi/utils/SafetyHandler;", "Landroid/os/Handler;", "Landroidx/lifecycle/LifecycleObserver;", "activityOrFragment", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "callback", "Landroid/os/Handler$Callback;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/os/Handler$Callback;)V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "bindLifecycle", "", "lifecycleOwner", "clear", "onDestroy", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SafetyHandler extends Handler implements LifecycleObserver {
    private Lifecycle lifecycle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafetyHandler(LifecycleOwner activityOrFragment) {
        super(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(activityOrFragment, "activityOrFragment");
        bindLifecycle(activityOrFragment);
    }

    private final void bindLifecycle(LifecycleOwner lifecycleOwner) {
        this.lifecycle = lifecycleOwner.getLifecycle();
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final void clear() {
        removeCallbacksAndMessages(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Log.e("SafetyHandler", "onDestroy()");
        clear();
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycle = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafetyHandler(LifecycleOwner activityOrFragment, Handler.Callback callback) {
        super(Looper.getMainLooper(), callback);
        Intrinsics.checkNotNullParameter(activityOrFragment, "activityOrFragment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        bindLifecycle(activityOrFragment);
    }
}
