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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/qiahao/base_common/common/BaseDialogFragment;", "<init>", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseBindingDialogFragment<B extends ViewDataBinding> extends BaseDialogFragment {
    protected B binding;

    @NotNull
    protected final B getBinding() {
        B b10 = this.binding;
        if (b10 != null) {
            return b10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.core.component.SuperDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNull(onCreateView);
        ViewDataBinding a10 = androidx.databinding.g.a(onCreateView);
        Intrinsics.checkNotNull(a10);
        setBinding(a10);
        getBinding().setLifecycleOwner(getViewLifecycleOwner());
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            getBinding().unbind();
        } catch (Exception e10) {
            ILog.DefaultImpls.logE$default((ILog) this, "onDestroyView() unbind error:" + e10, (String) null, true, 2, (Object) null);
        }
    }

    protected final void setBinding(@NotNull B b10) {
        Intrinsics.checkNotNullParameter(b10, "<set-?>");
        this.binding = b10;
    }
}
