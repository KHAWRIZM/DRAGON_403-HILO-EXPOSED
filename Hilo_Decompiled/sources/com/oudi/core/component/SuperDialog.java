package com.oudi.core.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.common.LifecycleCleared;
import com.oudi.core.component.IComponent;
import com.oudi.utils.ktx.ContextKtxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0015J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\tH\u0015J(\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0004J\u001c\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0004J\u0012\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\tH\u0004J\u0012\u0010\"\u001a\u00020\u00112\b\b\u0003\u0010#\u001a\u00020\tH\u0004J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0004J\u0012\u0010'\u001a\u00020\u00112\b\b\u0001\u0010#\u001a\u00020\tH\u0004J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0017J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u00020\u0011H\u0016J\r\u00100\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0011H\u0016¨\u00063"}, d2 = {"Lcom/oudi/core/component/SuperDialog;", "Landroid/app/Dialog;", "Lcom/oudi/core/component/IComponent;", "Lcom/oudi/core/common/LifecycleCleared;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "createView", "Landroid/view/View;", "getLayoutResId", "setPadding", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "setSize", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setGravity", "gravity", "setFullScreen", "color", "setBackgroundDrawable", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "Landroid/graphics/drawable/Drawable;", "setBackgroundDrawableColor", "setBackgroundDimAmount", "amount", "", "show", "isEnabledLifecycleClear", "getTargetLifecycle", "Landroidx/lifecycle/Lifecycle;", "onTargetCleared", "getThemeRes", "()Ljava/lang/Integer;", "dismiss", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperDialog extends Dialog implements IComponent, LifecycleCleared {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    public static /* synthetic */ void setFullScreen$default(SuperDialog superDialog, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                i10 = 0;
            }
            superDialog.setFullScreen(i10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFullScreen");
    }

    public static /* synthetic */ void setGravity$default(SuperDialog superDialog, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                i10 = 17;
            }
            superDialog.setGravity(i10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setGravity");
    }

    public static /* synthetic */ void setSize$default(SuperDialog superDialog, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i10 = -2;
            }
            if ((i12 & 2) != 0) {
                i11 = -2;
            }
            superDialog.setSize(i10, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSize");
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void bindLifecycleClear() {
        LifecycleCleared.DefaultImpls.bindLifecycleClear(this);
    }

    @Nullable
    public View createView() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        unBindLifecycleClear();
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle.Event getClearEvent() {
        return LifecycleCleared.DefaultImpls.getClearEvent(this);
    }

    public int getLayoutResId() {
        return -1;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public final Lifecycle getTargetLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public final Integer getThemeRes() {
        return IComponent.DefaultImpls.getThemeRes(this);
    }

    public void init() {
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            setContentView(layoutResId);
            return;
        }
        View createView = createView();
        if (createView != null) {
            setContentView(createView);
        }
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public boolean isEnabledLifecycleClear() {
        return true;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitialize() {
        IComponent.DefaultImpls.onInitialize(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        IComponent.DefaultImpls.onInitializeAfter(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        IComponent.DefaultImpls.onInitializeBefore(this);
    }

    @Override // com.oudi.core.common.LifecycleCleared, androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        LifecycleCleared.DefaultImpls.onStateChanged(this, lifecycleOwner, event);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void onTargetCleared() {
        dismiss();
    }

    @RequiresApi(14)
    public void setBackgroundDimAmount(float amount) {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(amount);
        }
    }

    public final void setBackgroundDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(drawable);
        }
    }

    public final void setBackgroundDrawableColor(int color) {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(color));
        }
    }

    public final void setFullScreen(int color) {
        setBackgroundDrawableColor(color);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }

    public final void setGravity(int gravity) {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = gravity;
            window.setAttributes(attributes);
        }
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(left, top, right, bottom);
        }
    }

    public final void setSize(int width, int height) {
        Window window = getWindow();
        if (window != null) {
            window.setLayout(width, height);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        bindLifecycleClear();
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void unBindLifecycleClear() {
        LifecycleCleared.DefaultImpls.unBindLifecycleClear(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperDialog(@NotNull Context context, int i10) {
        super(context, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperDialog(@NotNull Context context, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }
}
