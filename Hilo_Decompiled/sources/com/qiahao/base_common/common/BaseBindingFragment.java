package com.qiahao.base_common.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/common/BaseBindingFragment;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/qiahao/base_common/common/BaseFragment;", "<init>", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createView", "onDestroyView", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BaseBindingFragment<B extends ViewDataBinding> extends BaseFragment {

    @Nullable
    private B binding;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperFragment
    @NotNull
    public View createView() {
        return new View(getContext());
    }

    @Nullable
    public final B getBinding() {
        return this.binding;
    }

    @Override // com.oudi.core.component.SuperFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            B b10 = (B) androidx.databinding.g.h(getLayoutInflater(inflater), layoutResId, container, false);
            this.binding = b10;
            if (b10 != null) {
                b10.setLifecycleOwner(getViewLifecycleOwner());
            }
            B b11 = this.binding;
            if (b11 != null) {
                return b11.getRoot();
            }
        } else {
            B b12 = (B) androidx.databinding.g.a(createView());
            Intrinsics.checkNotNull(b12);
            this.binding = b12;
            if (b12 != null) {
                return b12.getRoot();
            }
        }
        return null;
    }

    @Override // com.qiahao.base_common.common.BaseFragment, com.oudi.core.component.SuperLazyFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            B b10 = this.binding;
            if (b10 != null) {
                b10.unbind();
            }
            this.binding = null;
        } catch (Exception e10) {
            ILog.DefaultImpls.logE$default((ILog) this, "onDestroyView() unbind error:" + e10, (String) null, true, 2, (Object) null);
        }
    }

    public final void setBinding(@Nullable B b10) {
        this.binding = b10;
    }
}
