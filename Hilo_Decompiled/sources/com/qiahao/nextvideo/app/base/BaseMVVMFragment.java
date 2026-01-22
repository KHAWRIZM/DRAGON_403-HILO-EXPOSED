package com.qiahao.nextvideo.app.base;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.taobao.accs.common.Constants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 3*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005:\u00013B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0007J\u0011\u0010\u0016\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0007R\"\u0010\u001d\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00028\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00102\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u001b¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/app/base/BaseMVVMFragment;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "M", "Lcom/qiahao/nextvideo/app/base/BaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initiate", "initViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "", Constants.KEY_FLAGS, "dismiss", "(I)V", "onDestroy", "mBinding", "Landroidx/databinding/ViewDataBinding;", "getMBinding", "()Landroidx/databinding/ViewDataBinding;", "setMBinding", "(Landroidx/databinding/ViewDataBinding;)V", "mViewModel", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "getMViewModel", "setMViewModel", "(Lcom/qiahao/base_common/viewmodel/BaseViewModel;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "getViewRes", "()I", "setViewRes", "viewRes", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseMVVMFragment<V extends ViewDataBinding, M extends BaseViewModel> extends BaseFragment {

    @NotNull
    private static final String TAG = "BaseMVVMFragment";
    public V mBinding;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();
    public M mViewModel;

    public static /* synthetic */ void dismiss$default(BaseMVVMFragment baseMVVMFragment, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            baseMVVMFragment.dismiss(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
    }

    public final void dismiss(int flags) {
        FragmentManager fragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            fragmentManager = activity.getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            fragmentManager.popBackStack(getTag(), flags);
        }
    }

    @NotNull
    public final V getMBinding() {
        V v = this.mBinding;
        if (v != null) {
            return v;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final M getMViewModel() {
        M m = this.mViewModel;
        if (m != null) {
            return m;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    public abstract int getViewRes();

    @Nullable
    public M initViewModel() {
        Application application;
        Type genericSuperclass = getClass().getGenericSuperclass();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            application = activity.getApplication();
        } else {
            application = null;
        }
        if (genericSuperclass == null || !(genericSuperclass instanceof ParameterizedType) || application == null) {
            return null;
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application));
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<M of com.qiahao.nextvideo.app.base.BaseMVVMFragment>");
        return viewModelProvider.get((Class) type);
    }

    public abstract void initiate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.BaseFragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Log.d(TAG, "onCreateView: ---------------------------------");
        ViewDataBinding a = androidx.databinding.g.a(inflater.inflate(getViewRes(), container, false));
        if (a != null) {
            setMBinding(a);
            return getMBinding().getRoot();
        }
        throw new Exception("视图布局必须要实现");
    }

    @Override // com.qiahao.nextvideo.app.base.BaseFragment
    public void onDestroy() {
        this.mCompositeDisposable.d();
        this.mCompositeDisposable.dispose();
        super.onDestroy();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        M initViewModel = initViewModel();
        Intrinsics.checkNotNull(initViewModel);
        setMViewModel(initViewModel);
        initiate();
    }

    public final void setMBinding(@NotNull V v) {
        Intrinsics.checkNotNullParameter(v, "<set-?>");
        this.mBinding = v;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMViewModel(@NotNull M m) {
        Intrinsics.checkNotNullParameter(m, "<set-?>");
        this.mViewModel = m;
    }

    public abstract void setViewRes(int i);
}
