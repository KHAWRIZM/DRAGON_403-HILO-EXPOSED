package com.oudi.core.common;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/oudi/core/common/LifecycleCleared;", "Landroidx/lifecycle/LifecycleEventObserver;", "isEnabledLifecycleClear", "", "getTargetLifecycle", "Landroidx/lifecycle/Lifecycle;", "onTargetCleared", "", "getClearEvent", "Landroidx/lifecycle/Lifecycle$Event;", "bindLifecycleClear", "unBindLifecycleClear", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface LifecycleCleared extends LifecycleEventObserver {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static void bindLifecycleClear(@NotNull LifecycleCleared lifecycleCleared) {
            Lifecycle targetLifecycle;
            if (lifecycleCleared.isEnabledLifecycleClear() && (targetLifecycle = lifecycleCleared.getTargetLifecycle()) != null) {
                targetLifecycle.addObserver(lifecycleCleared);
            }
        }

        @Nullable
        public static Lifecycle.Event getClearEvent(@NotNull LifecycleCleared lifecycleCleared) {
            return Lifecycle.Event.ON_DESTROY;
        }

        public static boolean isEnabledLifecycleClear(@NotNull LifecycleCleared lifecycleCleared) {
            return true;
        }

        public static void onStateChanged(@NotNull LifecycleCleared lifecycleCleared, @NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (lifecycleCleared.isEnabledLifecycleClear() && lifecycleCleared.getClearEvent() == event) {
                lifecycleCleared.unBindLifecycleClear();
                lifecycleCleared.onTargetCleared();
            }
        }

        public static void unBindLifecycleClear(@NotNull LifecycleCleared lifecycleCleared) {
            Lifecycle targetLifecycle;
            if (lifecycleCleared.isEnabledLifecycleClear() && (targetLifecycle = lifecycleCleared.getTargetLifecycle()) != null) {
                targetLifecycle.removeObserver(lifecycleCleared);
            }
        }
    }

    void bindLifecycleClear();

    @Nullable
    Lifecycle.Event getClearEvent();

    @Nullable
    Lifecycle getTargetLifecycle();

    boolean isEnabledLifecycleClear();

    @Override // androidx.lifecycle.LifecycleEventObserver
    void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event);

    void onTargetCleared();

    void unBindLifecycleClear();
}
