package com.qhqc.core.basic.uiframe.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.expand.ViewBindUtilKt;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import j3.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH$¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\rH$¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010\bR\"\u0010#\u001a\u00028\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010'R\"\u0010(\u001a\u00028\u00008\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicFragment;", "Lj3/a;", "D", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "M", "Lcom/qhqc/core/basic/uiframe/ui/VisibilityFragment;", "Lcom/qhqc/core/basic/uiframe/ui/ILoadingDelegate;", "<init>", "()V", "getBaseViewModel", "()Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "", "onInit", "(Landroid/os/Bundle;)V", "initEvent", "initData", "", "getViewModelKey", "()Ljava/lang/String;", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onFirstVisible", "viewModel", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "getViewModel", "setViewModel", "(Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;)V", "binding", "Lj3/a;", "getBinding", "()Lj3/a;", "setBinding", "(Lj3/a;)V", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicFragment<D extends j3.a, M extends BaseViewModel> extends VisibilityFragment implements ILoadingDelegate {
    protected D binding;
    protected M viewModel;

    private final M getBaseViewModel() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<M of com.qhqc.core.basic.uiframe.ui.BasicFragment>");
            return (M) new ViewModelProvider(getViewModelOwner()).get(getViewModelKey(), (Class) type);
        }
        throw new IllegalArgumentException("There is no generic of Activity.");
    }

    @NotNull
    protected final D getBinding() {
        D d10 = this.binding;
        if (d10 != null) {
            return d10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    protected final M getViewModel() {
        M m10 = this.viewModel;
        if (m10 != null) {
            return m10;
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

    protected abstract void initData();

    protected abstract void initEvent();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(ViewBindUtilKt.inflateWithGeneric(this, inflater, container, false));
        setViewModel(getBaseViewModel());
        return getBinding().getRoot();
    }

    @Override // com.qhqc.core.basic.uiframe.ui.VisibilityFragment, com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    public void onFirstVisible() {
        super.onFirstVisible();
        initData();
    }

    protected abstract void onInit(@Nullable Bundle savedInstanceState);

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        onInit(savedInstanceState);
        initEvent();
    }

    protected final void setBinding(@NotNull D d10) {
        Intrinsics.checkNotNullParameter(d10, "<set-?>");
        this.binding = d10;
    }

    protected final void setViewModel(@NotNull M m10) {
        Intrinsics.checkNotNullParameter(m10, "<set-?>");
        this.viewModel = m10;
    }
}
