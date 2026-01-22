package com.oudi.core.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.component.IVmComponent;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.component.bridge.ComponentActionHandler;
import com.oudi.core.loading.ILoading;
import com.oudi.core.model.ResultLiveData;
import com.oudi.core.vm.viewmodel.SuperViewModel;
import com.oudi.utils.LifecycleTask;
import com.oudi.utils.ktx.ContextKtxKt;
import com.oudi.utils.ktx.ToastKtxKt;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J!\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J!\u0010%\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u0010(J\u0017\u0010)\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010*J\n\u0010\t\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\"\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u000103H\u0016J\"\u00104\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u000103H\u0014R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u00065"}, d2 = {"Lcom/oudi/core/component/SuperFragment;", "Lcom/oudi/core/component/SuperLazyFragment;", "Lcom/oudi/core/component/IVmComponent;", "Lcom/oudi/core/loading/ILoading;", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskOwner;", "<init>", "()V", "lifecycleTask", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "getLifecycleTask", "()Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "lifecycleTask$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentFirstVisible", "", "getLayoutResId", "", "createView", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "findViewById", "T", "id", "(I)Landroid/view/View;", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "getMyLifecycle", "Landroidx/lifecycle/Lifecycle;", "showLoading", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "Lcom/oudi/utils/LifecycleTask;", "onBackPressedIntercept", "", "getLayoutInflater", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "dispatchActivityResult", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperFragment.kt\ncom/oudi/core/component/SuperFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1863#2,2:160\n1863#2,2:162\n1#3:164\n*S KotlinDebug\n*F\n+ 1 SuperFragment.kt\ncom/oudi/core/component/SuperFragment\n*L\n127#1:160,2\n155#1:162,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperFragment extends SuperLazyFragment implements IVmComponent, ILoading, LifecycleTask.LifecycleTaskOwner {

    /* renamed from: lifecycleTask$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleTask = LazyKt.lazy(new Function0() { // from class: com.oudi.core.component.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1;
            lifecycleTask_delegate$lambda$1 = SuperFragment.lifecycleTask_delegate$lambda$1(SuperFragment.this);
            return lifecycleTask_delegate$lambda$1;
        }
    });

    private final LifecycleTask.LifecycleTaskImpl getLifecycleTask() {
        return (LifecycleTask.LifecycleTaskImpl) this.lifecycleTask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$1(SuperFragment superFragment) {
        Lifecycle myLifecycle = superFragment.getMyLifecycle();
        if (myLifecycle != null) {
            return new LifecycleTask.LifecycleTaskImpl(myLifecycle);
        }
        return null;
    }

    @Override // com.oudi.core.component.IVmComponent
    public void addViewModel(@Nullable SuperViewModel superViewModel) {
        IVmComponent.DefaultImpls.addViewModel(this, superViewModel);
    }

    @Nullable
    public View createView() {
        return null;
    }

    @Override // com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
        ILoading iLoading;
        FullyDrawnReporterOwner activity = getActivity();
        if (activity instanceof ILoading) {
            iLoading = (ILoading) activity;
        } else {
            iLoading = null;
        }
        if (iLoading != null) {
            iLoading.dismissLoading(id);
        }
    }

    public void dispatchActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            ((Fragment) it.next()).onActivityResult(requestCode, resultCode, data);
        }
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

    @NotNull
    public LayoutInflater getLayoutInflater(@NotNull LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Integer themeRes = getThemeRes();
        if (themeRes != null) {
            LayoutInflater cloneInContext = inflater.cloneInContext(new ContextThemeWrapper(inflater.getContext(), themeRes.intValue()));
            Intrinsics.checkNotNullExpressionValue(cloneInContext, "cloneInContext(...)");
            return cloneInContext;
        }
        return inflater;
    }

    public int getLayoutResId() {
        return -1;
    }

    @Override // com.oudi.core.component.IVmComponent
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        return viewLifecycleOwner;
    }

    @Nullable
    public Lifecycle getMyLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
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

    @Override // com.oudi.core.component.IVmComponent
    public <T> void observe(@NotNull ResultLiveData<T> resultLiveData, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        IVmComponent.DefaultImpls.observe(this, resultLiveData, function1, function12);
    }

    @Override // com.oudi.core.component.IVmComponent, com.oudi.core.component.bridge.ComponentActionHandler
    public void onAction(@NotNull ComponentAction action) {
        ComponentActionHandler componentActionHandler;
        Intrinsics.checkNotNullParameter(action, "action");
        IVmComponent.DefaultImpls.onAction(this, action);
        FullyDrawnReporterOwner activity = getActivity();
        if (activity instanceof ComponentActionHandler) {
            componentActionHandler = (ComponentActionHandler) activity;
        } else {
            componentActionHandler = null;
        }
        if (componentActionHandler != null) {
            componentActionHandler.onAction(action);
            return;
        }
        if (action instanceof ComponentAction.ShowLoading) {
            ILoading.DefaultImpls.showLoading$default(this, null, ((ComponentAction.ShowLoading) action).getMessage(), 1, null);
            return;
        }
        if (action instanceof ComponentAction.DismissLoading) {
            ILoading.DefaultImpls.dismissLoading$default(this, null, 1, null);
        } else if (action instanceof ComponentAction.Toast) {
            ToastKtxKt.toast$default((Fragment) this, ((ComponentAction.Toast) action).getMessage(), 0, 2, (Object) null);
        } else if (action instanceof ComponentAction.BuildDialog) {
            ((ComponentAction.BuildDialog) action).getBuild().invoke(getActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dispatchActivityResult(requestCode, resultCode, data);
    }

    public boolean onBackPressedIntercept() {
        SuperFragment superFragment;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof SuperFragment) {
                superFragment = (SuperFragment) fragment;
            } else {
                superFragment = null;
            }
            if (superFragment != null && superFragment.onBackPressedIntercept()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            return getLayoutInflater(inflater).inflate(layoutResId, container, false);
        }
        return createView();
    }

    @Override // com.oudi.core.component.SuperLazyFragment
    public void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
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

    @Override // com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
        ILoading iLoading;
        FullyDrawnReporterOwner activity = getActivity();
        if (activity instanceof ILoading) {
            iLoading = (ILoading) activity;
        } else {
            iLoading = null;
        }
        if (iLoading != null) {
            iLoading.showLoading(id, message);
        }
    }

    @Override // com.oudi.utils.LifecycleTask.LifecycleTaskOwner
    @Nullable
    /* renamed from: getLifecycleTask, reason: contains not printable characters */
    public LifecycleTask mo٥١٥getLifecycleTask() {
        return getLifecycleTask();
    }
}
