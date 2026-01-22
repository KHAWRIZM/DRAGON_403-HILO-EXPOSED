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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/common/BaseBindingBottomSheetDialogFragment;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/qiahao/base_common/common/BaseBottomSheetDialogFragment;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseBindingBottomSheetDialogFragment<B extends ViewDataBinding> extends BaseBottomSheetDialogFragment implements ILog {
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
    @Override // com.oudi.core.component.SuperBottomSheetDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            setBinding(androidx.databinding.g.h(inflater, layoutResId, container, false));
            return getBinding().getRoot();
        }
        View createView = createView();
        Intrinsics.checkNotNull(createView);
        ViewDataBinding a10 = androidx.databinding.g.a(createView);
        Intrinsics.checkNotNull(a10);
        setBinding(a10);
        return getBinding().getRoot();
    }

    @Override // com.oudi.core.component.SuperBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
