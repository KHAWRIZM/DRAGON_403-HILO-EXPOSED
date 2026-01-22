package com.oudi.core.component;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.oudi.core.common.LifecycleCleared;
import com.oudi.core.component.IVmComponent;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.loading.ILoading;
import com.oudi.core.model.ResultLiveData;
import com.oudi.core.vm.viewmodel.SuperViewModel;
import com.oudi.utils.LifecycleTask;
import com.oudi.utils.ktx.ContextKtxKt;
import com.oudi.utils.ktx.ToastKtxKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001d*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0017H\u0014¢\u0006\u0004\b%\u0010\u0019J\u000f\u0010&\u001a\u00020\u0017H\u0014¢\u0006\u0004\b&\u0010\u0019J\u000f\u0010(\u001a\u00020'H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0014¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020'H\u0014¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\u0007J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b2\u00103J#\u00106\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b=\u00103J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010\u0007J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010\u0007J>\u0010G\u001a\u00020\b2\u0006\u0010A\u001a\u00020@2'\u0010.\u001a#\b\u0001\u0012\u0004\u0012\u00020C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0D\u0012\u0006\u0012\u0004\u0018\u00010E0B¢\u0006\u0002\bF¢\u0006\u0004\bG\u0010HR\u001d\u0010M\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\b;\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/oudi/core/component/SuperBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/d;", "Lcom/oudi/core/component/IVmComponent;", "Lcom/oudi/core/loading/ILoading;", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskOwner;", "Lcom/oudi/core/common/LifecycleCleared;", "<init>", "()V", "", "initBottomSheetBehavior", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onActivityCreated", "(Landroid/os/Bundle;)V", "createView", "()Landroid/view/View;", "", "getLayoutResId", "()I", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "T", "id", "findViewById", "(I)Landroid/view/View;", "getBottomSheetLayout", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getPeekHeight", "getMaxHeight", "", "isExpandedState", "()Z", "getCanceled", "isCanSlideClose", "onDestroyView", "Lcom/oudi/core/component/bridge/ComponentAction;", NativeProtocol.WEB_DIALOG_ACTION, "onAction", "(Lcom/oudi/core/component/bridge/ComponentAction;)V", "Landroidx/lifecycle/Lifecycle;", "getMyLifecycle", "()Landroidx/lifecycle/Lifecycle;", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "showLoading", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "Lcom/oudi/utils/LifecycleTask;", "getLifecycleTask", "()Lcom/oudi/utils/LifecycleTask;", "getTargetLifecycle", "onTargetCleared", "onDestroy", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "bind", "(Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;)V", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "lifecycleTask$delegate", "Lkotlin/Lazy;", "()Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "lifecycleTask", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$g;", "bottomSheetCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$g;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperBottomSheetDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperBottomSheetDialogFragment.kt\ncom/oudi/core/component/SuperBottomSheetDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,249:1\n1#2:250\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperBottomSheetDialogFragment extends com.google.android.material.bottomsheet.d implements IVmComponent, ILoading, LifecycleTask.LifecycleTaskOwner, LifecycleCleared {

    @Nullable
    private BottomSheetBehavior.g bottomSheetCallback;

    /* renamed from: lifecycleTask$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleTask = LazyKt.lazy(new Function0() { // from class: com.oudi.core.component.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1;
            lifecycleTask_delegate$lambda$1 = SuperBottomSheetDialogFragment.lifecycleTask_delegate$lambda$1(SuperBottomSheetDialogFragment.this);
            return lifecycleTask_delegate$lambda$1;
        }
    });

    private final LifecycleTask.LifecycleTaskImpl getLifecycleTask() {
        return (LifecycleTask.LifecycleTaskImpl) this.lifecycleTask.getValue();
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
            BottomSheetBehavior.g gVar = new BottomSheetBehavior.g() { // from class: com.oudi.core.component.SuperBottomSheetDialogFragment$initBottomSheetBehavior$2$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
                public void onStateChanged(View bottomSheet, int state) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    if (state != 1) {
                        if (state == 5) {
                            SuperBottomSheetDialogFragment.this.dismiss();
                        }
                    } else if (!SuperBottomSheetDialogFragment.this.isCanSlideClose()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1(SuperBottomSheetDialogFragment superBottomSheetDialogFragment) {
        Lifecycle myLifecycle = superBottomSheetDialogFragment.getMyLifecycle();
        if (myLifecycle != null) {
            return new LifecycleTask.LifecycleTaskImpl(myLifecycle);
        }
        return null;
    }

    @Override // com.oudi.core.component.IVmComponent
    public void addViewModel(@Nullable SuperViewModel superViewModel) {
        IVmComponent.DefaultImpls.addViewModel(this, superViewModel);
    }

    public final void bind(@NotNull Lifecycle.State state, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SuperBottomSheetDialogFragment$bind$1(this, state, action, null), 3, null);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void bindLifecycleClear() {
        LifecycleCleared.DefaultImpls.bindLifecycleClear(this);
    }

    @Nullable
    public View createView() {
        return null;
    }

    @Override // com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public <T extends View> T findViewById(int id) {
        View view = getView();
        if (view != null) {
            return (T) view.findViewById(id);
        }
        return null;
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
        BottomSheetDialog bottomSheetDialog;
        androidx.appcompat.app.e delegate;
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            bottomSheetDialog = (BottomSheetDialog) dialog;
        } else {
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog == null || (delegate = bottomSheetDialog.getDelegate()) == null) {
            return null;
        }
        return delegate.j(R.id.design_bottom_sheet);
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

    @Override // com.oudi.core.component.IVmComponent
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public int getMaxHeight() {
        return -1;
    }

    @Nullable
    public Lifecycle getMyLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    public int getPeekHeight() {
        return -1;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle getTargetLifecycle() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getLifecycle();
        }
        return null;
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public Integer getThemeRes() {
        return IVmComponent.DefaultImpls.getThemeRes(this);
    }

    @Override // com.oudi.core.component.IVmComponent
    public boolean isAutoInitObserve() {
        return IVmComponent.DefaultImpls.isAutoInitObserve(this);
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

    @Override // com.oudi.core.component.IVmComponent
    public <T> void observe(@NotNull ResultLiveData<T> resultLiveData, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        IVmComponent.DefaultImpls.observe(this, resultLiveData, function1, function12);
    }

    @Override // com.oudi.core.component.IVmComponent, com.oudi.core.component.bridge.ComponentActionHandler
    public void onAction(@NotNull ComponentAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        IVmComponent.DefaultImpls.onAction(this, action);
        if (action instanceof ComponentAction.ShowLoading) {
            ILoading.DefaultImpls.showLoading$default(this, null, ((ComponentAction.ShowLoading) action).getMessage(), 1, null);
            return;
        }
        if (action instanceof ComponentAction.DismissLoading) {
            ILoading.DefaultImpls.dismissLoading$default(this, null, 1, null);
        } else if (action instanceof ComponentAction.Toast) {
            ToastKtxKt.toast$default((Fragment) this, ((ComponentAction.Toast) action).getMessage(), 0, 2, (Object) null);
        } else if (action instanceof ComponentAction.BuildDialog) {
            ((ComponentAction.BuildDialog) action).getBuild().invoke(requireActivity());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @SuppressLint({"MissingSuperCall"})
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog;
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            bottomSheetDialog = (BottomSheetDialog) dialog;
        } else {
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog != null) {
            bottomSheetDialog.setCanceledOnTouchOutside(getCanceled());
        }
        bindLifecycleClear();
        initBottomSheetBehavior();
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            return getLayoutInflater().inflate(layoutResId, container, false);
        }
        return createView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unBindLifecycleClear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        super.onDestroyView();
        BottomSheetBehavior.g gVar = this.bottomSheetCallback;
        if (gVar != null && (bottomSheetBehavior = getBottomSheetBehavior()) != null) {
            bottomSheetBehavior.I0(gVar);
        }
    }

    @Override // com.oudi.core.component.IVmComponent, com.oudi.core.component.IComponent
    public void onInitialize() {
        IVmComponent.DefaultImpls.onInitialize(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        IVmComponent.DefaultImpls.onInitializeAfter(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        IVmComponent.DefaultImpls.onInitializeBefore(this);
    }

    @Override // com.oudi.core.common.LifecycleCleared, androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        LifecycleCleared.DefaultImpls.onStateChanged(this, lifecycleOwner, event);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void onTargetCleared() {
        dismissAllowingStateLoss();
    }

    @Override // com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void unBindLifecycleClear() {
        LifecycleCleared.DefaultImpls.unBindLifecycleClear(this);
    }

    @Override // com.oudi.utils.LifecycleTask.LifecycleTaskOwner
    @Nullable
    /* renamed from: getLifecycleTask, reason: contains not printable characters */
    public LifecycleTask mo٥١٥getLifecycleTask() {
        return getLifecycleTask();
    }
}
