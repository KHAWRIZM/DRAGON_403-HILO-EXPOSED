package com.qhqc.core.basic.uiframe.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.basic.utils.FixFragmentHelper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0014J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\rH\u0014J\u0012\u0010 \u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0012\u0010$\u001a\u00020\r2\b\b\u0001\u0010%\u001a\u00020\u000fH\u0004J\u0012\u0010$\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010'\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0014R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006("}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicVMActivity;", "VM", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "Lcom/qhqc/core/basic/uiframe/ui/BasicActivity;", "Lcom/qhqc/core/basic/uiframe/ui/ILoadingDelegate;", "()V", "viewModel", "getViewModel", "()Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;)V", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "binVariable", "", "variableId", "", "dismissLoading", "getDefaultLoadingTip", "", "getIndexViewModelParameterized", "getVariableId", "Ljava/lang/Class;", "getViewModelKey", "getViewModelOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "initData", "initEvent", "onBindingView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onInit", "onLoading", "tips", "onLoadingDismiss", "showLoading", "sRes", "s", "updateLoading", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicVMActivity<VM extends BaseViewModel> extends BasicActivity implements ILoadingDelegate {
    protected VM viewModel;

    protected void binVariable(int variableId) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String getDefaultLoadingTip() {
        return "";
    }

    protected int getIndexViewModelParameterized() {
        return 0;
    }

    protected int getVariableId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: getViewModel, reason: collision with other method in class */
    public final VM m٥٢١getViewModel() {
        VM vm = this.viewModel;
        if (vm != null) {
            return vm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @NotNull
    protected String getViewModelKey() {
        return "";
    }

    @NotNull
    protected ViewModelStoreOwner getViewModelOwner() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initEvent() {
    }

    protected void onBindingView() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FixFragmentHelper.intercept(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        onBindingView();
        Class viewModel = getViewModel();
        if (viewModel != null) {
            setViewModel((BaseViewModel) new ViewModelProvider(getViewModelOwner()).get(getViewModelKey(), viewModel));
            if (getVariableId() != 0) {
                binVariable(getVariableId());
            }
            onInit(savedInstanceState);
            initEvent();
        }
        m٥٢١getViewModel().getIsLoading().observe(this, new BasicVMActivity$sam$androidx_lifecycle_Observer$0(new BasicVMActivity$onCreate$2(this)));
        m٥٢١getViewModel().getOnErrorAction().observe(this, new BasicVMActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>(this) { // from class: com.qhqc.core.basic.uiframe.ui.BasicVMActivity$onCreate$3
            final /* synthetic */ BasicVMActivity<VM> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
                if (iToast != null) {
                    Context context = this.this$0;
                    Intrinsics.checkNotNull(str);
                    iToast.showToast(context, str);
                }
                this.this$0.onError();
            }
        }));
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInit(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.qhqc.core.basic.uiframe.ui.ILoadingDelegate
    public void onLoading(@Nullable String tips) {
        showLoading(tips);
    }

    @Override // com.qhqc.core.basic.uiframe.ui.ILoadingDelegate
    public void onLoadingDismiss() {
        dismissLoading();
    }

    protected final void setViewModel(@NotNull VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.viewModel = vm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading(@Nullable String s10) {
    }

    protected void updateLoading(@Nullable String s10) {
    }

    private final Class<VM> getViewModel() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Intrinsics.checkNotNull(actualTypeArguments);
        if (actualTypeArguments.length == 0) {
            return null;
        }
        Type type = actualTypeArguments[getIndexViewModelParameterized()];
        if (type instanceof Class) {
            return (Class) type;
        }
        return null;
    }

    protected final void showLoading(int sRes) {
        if (sRes == 0) {
            showLoading("");
        } else {
            showLoading(getString(sRes));
        }
    }
}
