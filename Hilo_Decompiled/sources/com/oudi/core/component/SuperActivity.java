package com.oudi.core.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.component.IVmComponent;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.loading.ILoading;
import com.oudi.core.model.ResultLiveData;
import com.oudi.core.vm.viewmodel.SuperViewModel;
import com.oudi.utils.LifecycleTask;
import com.oudi.utils.ktx.ContextKtxKt;
import com.oudi.utils.ktx.ToastKtxKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00019B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0015J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010%J\n\u0010\u000b\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0010H\u0017J\b\u0010(\u001a\u00020)H\u0014J\"\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\"\u0010/\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J<\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u0002022'\u0010\u001d\u001a#\b\u0001\u0012\u0004\u0012\u000204\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001005\u0012\u0006\u0012\u0004\u0018\u00010603¢\u0006\u0002\b7¢\u0006\u0002\u00108R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006:"}, d2 = {"Lcom/oudi/core/component/SuperActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/oudi/core/component/IVmComponent;", "Lcom/oudi/core/loading/ILoading;", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskOwner;", "<init>", "()V", "backStackDepth", "", "lifecycleTask", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "getLifecycleTask", "()Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "lifecycleTask$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onInitializeBefore", "getMyLifecycle", "Landroidx/lifecycle/Lifecycle;", "onCreateView", "getLayoutResId", "getContext", "Landroid/content/Context;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "showLoading", "id", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "Lcom/oudi/utils/LifecycleTask;", "onBackPressed", "onBackPressedIntercept", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "dispatchActivityResult", "bind", "state", "Landroidx/lifecycle/Lifecycle$State;", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;)V", "Companion", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperActivity.kt\ncom/oudi/core/component/SuperActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,177:1\n1863#2,2:178\n1863#2,2:180\n*S KotlinDebug\n*F\n+ 1 SuperActivity.kt\ncom/oudi/core/component/SuperActivity\n*L\n142#1:178,2\n165#1:180,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperActivity extends AppCompatActivity implements IVmComponent, ILoading, LifecycleTask.LifecycleTaskOwner {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static final int MAX_BACK_STACK_DEPTH = 50;
    private int backStackDepth;

    /* renamed from: lifecycleTask$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleTask = LazyKt.lazy(new Function0() { // from class: com.oudi.core.component.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$0;
            lifecycleTask_delegate$lambda$0 = SuperActivity.lifecycleTask_delegate$lambda$0(SuperActivity.this);
            return lifecycleTask_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/oudi/core/component/SuperActivity$Companion;", "", "<init>", "()V", "MAX_BACK_STACK_DEPTH", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final LifecycleTask.LifecycleTaskImpl getLifecycleTask() {
        return (LifecycleTask.LifecycleTaskImpl) this.lifecycleTask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleTask.LifecycleTaskImpl lifecycleTask_delegate$lambda$0(SuperActivity superActivity) {
        Lifecycle lifecycle = superActivity.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        return new LifecycleTask.LifecycleTaskImpl(lifecycle);
    }

    @Override // com.oudi.core.component.IVmComponent
    public void addViewModel(@Nullable SuperViewModel superViewModel) {
        IVmComponent.DefaultImpls.addViewModel(this, superViewModel);
    }

    public final void bind(@NotNull Lifecycle.State state, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SuperActivity$bind$1(this, state, action, null), 3, null);
    }

    @Override // com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
    }

    public void dispatchActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            ((Fragment) it.next()).onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.oudi.core.component.IComponent
    @NotNull
    public Context getContext() {
        return this;
    }

    public int getLayoutResId() {
        return -1;
    }

    @Override // com.oudi.core.component.IVmComponent
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        return this;
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
        Intrinsics.checkNotNullParameter(action, "action");
        IVmComponent.DefaultImpls.onAction(this, action);
        if (action instanceof ComponentAction.ShowLoading) {
            ILoading.DefaultImpls.showLoading$default(this, null, ((ComponentAction.ShowLoading) action).getMessage(), 1, null);
            return;
        }
        if (action instanceof ComponentAction.DismissLoading) {
            ILoading.DefaultImpls.dismissLoading$default(this, null, 1, null);
        } else if (action instanceof ComponentAction.Toast) {
            ToastKtxKt.toast$default((Context) this, ((ComponentAction.Toast) action).getMessage(), 0, 2, (Object) null);
        } else if (action instanceof ComponentAction.BuildDialog) {
            ((ComponentAction.BuildDialog) action).getBuild().invoke(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dispatchActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        try {
            if (onBackPressedIntercept()) {
                return;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int i10 = this.backStackDepth;
        if (i10 < 50) {
            this.backStackDepth = i10 + 1;
            super.onBackPressed();
            this.backStackDepth = Math.max(0, this.backStackDepth - 1);
            return;
        }
        finish();
    }

    public boolean onBackPressedIntercept() {
        try {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
            for (Fragment fragment : fragments) {
                if ((fragment instanceof SuperFragment) && ((SuperFragment) fragment).onBackPressedIntercept()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
    }

    public void onCreateView() {
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            setContentView(layoutResId);
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
        onCreateView();
    }

    @Override // com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
    }

    @Override // com.oudi.utils.LifecycleTask.LifecycleTaskOwner
    @Nullable
    /* renamed from: getLifecycleTask, reason: collision with other method in class */
    public LifecycleTask mo٥١٥getLifecycleTask() {
        return getLifecycleTask();
    }
}
