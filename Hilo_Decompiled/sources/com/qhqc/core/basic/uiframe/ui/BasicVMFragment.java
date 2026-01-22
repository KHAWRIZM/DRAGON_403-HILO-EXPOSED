package com.qhqc.core.basic.uiframe.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0017J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0011H\u0014J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u0012\u0010)\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010,\u001a\u00020\u00112\b\b\u0001\u0010-\u001a\u00020\u0013H\u0004J\u0012\u0010,\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u001aH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006/"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicVMFragment;", "VM", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "Lcom/qhqc/core/basic/uiframe/ui/VisibilityFragment;", "()V", "isViewPrepared", "", "()Z", "setViewPrepared", "(Z)V", "viewModel", "getViewModel", "()Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;)V", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "bindVariable", "", "variableId", "", "dismissLoading", "getIndexViewModelParameterized", "getLayout", "getVariableId", "Ljava/lang/Class;", "getViewModelKey", "", "getViewModelOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "initData", "initEvent", "initViewModel", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onInit", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showLoading", "sRes", "s", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicVMFragment<VM extends BaseViewModel> extends VisibilityFragment {
    private boolean isViewPrepared;
    protected VM viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewModel(Bundle savedInstanceState) {
        Class viewModel = getViewModel();
        if (viewModel != null) {
            setViewModel((BaseViewModel) new ViewModelProvider(getViewModelOwner()).get(getViewModelKey(), viewModel));
            Log.d("view_model_key", m٥٢٢getViewModel().toString());
            if (getVariableId() != 0) {
                bindVariable(getVariableId());
            }
            if (!m٥٢٢getViewModel().getIsLoading().hasObservers()) {
                m٥٢٢getViewModel().getIsLoading().observe(getViewLifecycleOwner(), new BasicVMFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>(this) { // from class: com.qhqc.core.basic.uiframe.ui.BasicVMFragment$initViewModel$1$1
                    final /* synthetic */ BasicVMFragment<VM> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                        Intrinsics.checkNotNull(bool);
                        if (bool.booleanValue()) {
                            this.this$0.showLoading("");
                        } else {
                            this.this$0.dismissLoading();
                        }
                    }
                }));
            }
            if (!m٥٢٢getViewModel().getOnErrorAction().hasObservers()) {
                m٥٢٢getViewModel().getOnErrorAction().observe(getViewLifecycleOwner(), new BasicVMFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.qhqc.core.basic.uiframe.ui.BasicVMFragment$initViewModel$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
                        if (iToast != null) {
                            Intrinsics.checkNotNull(str);
                            iToast.showToast(str);
                        }
                    }
                }));
            }
            onInit(savedInstanceState);
            initEvent();
            initData();
        }
    }

    protected void bindVariable(int variableId) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
    }

    protected int getIndexViewModelParameterized() {
        return 0;
    }

    public int getLayout() {
        return 0;
    }

    protected int getVariableId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: getViewModel, reason: collision with other method in class */
    public final VM m٥٢٢getViewModel() {
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

    /* renamed from: isViewPrepared, reason: from getter */
    public boolean getIsViewPrepared() {
        return this.isViewPrepared;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getLayout(), container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        setViewPrepared(false);
    }

    public void onInit(@Nullable Bundle savedInstanceState) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getIsViewPrepared()) {
            return;
        }
        setViewPrepared(true);
        initViewModel(savedInstanceState);
    }

    protected final void setViewModel(@NotNull VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.viewModel = vm;
    }

    public void setViewPrepared(boolean z10) {
        this.isViewPrepared = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading(@Nullable String s10) {
        getIsViewPrepared();
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
