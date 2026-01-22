package com.oudi.core.component;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0015J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u001dH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0014J\r\u0010#\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010$J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0014J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J!\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\u000f2\u0006\u0010-\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dH\u0004J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u001dH\u0004J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J!\u00107\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J\u0017\u0010;\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010<J\n\u0010\n\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u0004\u0018\u00010&J\b\u0010?\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020\u0017H\u0016R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006A"}, d2 = {"Lcom/oudi/core/component/SuperDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/oudi/core/component/IVmComponent;", "Lcom/oudi/core/loading/ILoading;", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskOwner;", "Lcom/oudi/core/common/LifecycleCleared;", "<init>", "()V", "lifecycleTask", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "getLifecycleTask", "()Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "lifecycleTask$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "onActivityCreated", "initStyle", "createView", "getLayoutResId", "", "getCanceled", "", "getWidth", "getHeight", "getGravity", "getThemeRes", "()Ljava/lang/Integer;", "getMyLifecycle", "Landroidx/lifecycle/Lifecycle;", "getDialogBackground", "Landroid/graphics/drawable/Drawable;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "findViewById", "T", "id", "(I)Landroid/view/View;", "setSize", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setGravity", "gravity", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "showLoading", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "Lcom/oudi/utils/LifecycleTask;", "getTargetLifecycle", "onTargetCleared", "onDestroy", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperDialogFragment.kt\ncom/oudi/core/component/SuperDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n1#2:195\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperDialogFragment extends DialogFragment implements IVmComponent, ILoading, LifecycleTask.LifecycleTaskOwner, LifecycleCleared {

    /* renamed from: lifecycleTask$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleTask = LazyKt.lazy(new Function0() { // from class: com.oudi.core.component.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1;
            lifecycleTask_delegate$lambda$1 = SuperDialogFragment.lifecycleTask_delegate$lambda$1(SuperDialogFragment.this);
            return lifecycleTask_delegate$lambda$1;
        }
    });

    private final LifecycleTask.LifecycleTaskImpl getLifecycleTask() {
        return (LifecycleTask.LifecycleTaskImpl) this.lifecycleTask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1(SuperDialogFragment superDialogFragment) {
        Lifecycle myLifecycle = superDialogFragment.getMyLifecycle();
        if (myLifecycle != null) {
            return new LifecycleTask.LifecycleTaskImpl(myLifecycle);
        }
        return null;
    }

    @Override // com.oudi.core.component.IVmComponent
    public void addViewModel(@Nullable SuperViewModel superViewModel) {
        IVmComponent.DefaultImpls.addViewModel(this, superViewModel);
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

    public boolean getCanceled() {
        return true;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle.Event getClearEvent() {
        return LifecycleCleared.DefaultImpls.getClearEvent(this);
    }

    @NotNull
    public Drawable getDialogBackground() {
        return new ColorDrawable(0);
    }

    public int getGravity() {
        return 0;
    }

    public int getHeight() {
        return -2;
    }

    public int getLayoutResId() {
        return -1;
    }

    @Override // com.oudi.core.component.IVmComponent
    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Nullable
    public Lifecycle getMyLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public final Lifecycle getTargetLifecycle() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getLifecycle();
        }
        return null;
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public final Integer getThemeRes() {
        return IVmComponent.DefaultImpls.getThemeRes(this);
    }

    public int getWidth() {
        return -1;
    }

    public void initStyle() {
        setSize(getWidth(), getHeight());
        setGravity(getGravity());
    }

    @Override // com.oudi.core.component.IVmComponent
    public boolean isAutoInitObserve() {
        return IVmComponent.DefaultImpls.isAutoInitObserve(this);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public boolean isEnabledLifecycleClear() {
        return LifecycleCleared.DefaultImpls.isEnabledLifecycleClear(this);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(getDialogBackground());
        }
        super.onActivityCreated(savedInstanceState);
        initStyle();
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        bindLifecycleClear();
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
    }

    public final void setGravity(int gravity) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setGravity(gravity);
        }
    }

    public final void setSize(int width, int height) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(width, height);
        }
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
