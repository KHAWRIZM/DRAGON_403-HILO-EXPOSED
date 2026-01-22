package com.oudi.core.component;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.oudi.core.common.LifecycleCleared;
import com.oudi.core.component.IComponent;
import com.oudi.utils.ktx.ContextKtxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0006\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\bH\u0014¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\bH\u0014¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\"\u0010\u001eJ\u0011\u0010#\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b#\u0010\u001aJ\u0017\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010$H\u0014¢\u0006\u0004\b%\u0010&J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010\u0012J\u000f\u0010,\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010\u0012R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/oudi/core/component/SuperBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Lcom/oudi/core/component/IComponent;", "Lcom/oudi/core/common/LifecycleCleared;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "theme", "(Landroid/content/Context;I)V", "", "cancelable", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "", "initBottomSheetBehavior", "()V", "init", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "createView", "()Landroid/view/View;", "getLayoutResId", "()I", "getCanceled", "()Z", "isCanSlideClose", "getMaxHeight", "getPeekHeight", "isExpandedState", "getBottomSheetLayout", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/lifecycle/Lifecycle;", "getTargetLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onTargetCleared", "show", "dismiss", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$g;", "bottomSheetCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$g;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperBottomSheetDialog extends BottomSheetDialog implements IComponent, LifecycleCleared {

    @Nullable
    private BottomSheetBehavior.g bottomSheetCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBottomSheetDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void initBottomSheetBehavior() {
        int i10;
        CoordinatorLayout.f fVar;
        View bottomSheetLayout = getBottomSheetLayout();
        if (bottomSheetLayout != null) {
            ViewGroup.LayoutParams layoutParams = bottomSheetLayout.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                fVar = (CoordinatorLayout.f) layoutParams;
            } else {
                fVar = null;
            }
            int maxHeight = getMaxHeight();
            if (maxHeight > 0 && fVar != null) {
                ((ViewGroup.MarginLayoutParams) fVar).height = maxHeight;
            }
        }
        final BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            int peekHeight = getPeekHeight();
            if (peekHeight > 0) {
                bottomSheetBehavior.Y0(peekHeight);
            }
            if (isExpandedState()) {
                i10 = 3;
            } else {
                i10 = 4;
            }
            bottomSheetBehavior.c(i10);
            BottomSheetBehavior.g gVar = new BottomSheetBehavior.g() { // from class: com.oudi.core.component.SuperBottomSheetDialog$initBottomSheetBehavior$2$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onStateChanged(View bottomSheet, int state) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    if (state != 1) {
                        if (state == 5) {
                            SuperBottomSheetDialog.this.dismiss();
                        }
                    } else if (!SuperBottomSheetDialog.this.isCanSlideClose()) {
                        bottomSheetBehavior.c(3);
                    }
                }
            };
            this.bottomSheetCallback = gVar;
            BottomSheetBehavior<View> bottomSheetBehavior2 = getBottomSheetBehavior();
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.e0(gVar);
            }
        }
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void bindLifecycleClear() {
        LifecycleCleared.DefaultImpls.bindLifecycleClear(this);
    }

    @Nullable
    public View createView() {
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        super.dismiss();
        unBindLifecycleClear();
        BottomSheetBehavior.g gVar = this.bottomSheetCallback;
        if (gVar != null && (bottomSheetBehavior = getBottomSheetBehavior()) != null) {
            bottomSheetBehavior.I0(gVar);
        }
    }

    @Nullable
    public BottomSheetBehavior<View> getBottomSheetBehavior() {
        View bottomSheetLayout = getBottomSheetLayout();
        if (bottomSheetLayout != null) {
            return BottomSheetBehavior.s0(bottomSheetLayout);
        }
        return null;
    }

    @Nullable
    public View getBottomSheetLayout() {
        androidx.appcompat.app.e delegate = getDelegate();
        if (delegate != null) {
            return delegate.j(R.id.design_bottom_sheet);
        }
        return null;
    }

    public boolean getCanceled() {
        return true;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle.Event getClearEvent() {
        return LifecycleCleared.DefaultImpls.getClearEvent(this);
    }

    public int getLayoutResId() {
        return -1;
    }

    public int getMaxHeight() {
        return -1;
    }

    public int getPeekHeight() {
        return -1;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle getTargetLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public Integer getThemeRes() {
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

    public boolean isCanSlideClose() {
        return true;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public boolean isEnabledLifecycleClear() {
        return LifecycleCleared.DefaultImpls.isEnabledLifecycleClear(this);
    }

    public boolean isExpandedState() {
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(getCanceled());
        initBottomSheetBehavior();
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
    public SuperBottomSheetDialog(@NotNull Context context, int i10) {
        super(context, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBottomSheetDialog(@NotNull Context context, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }
}
