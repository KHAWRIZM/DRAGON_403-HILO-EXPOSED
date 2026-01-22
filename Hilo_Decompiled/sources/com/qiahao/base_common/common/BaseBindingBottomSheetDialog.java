package com.qiahao.base_common.common;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u001c\u0010\u0010\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/common/BaseBindingBottomSheetDialog;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/qiahao/base_common/common/BaseBottomSheetDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "init", "", "dismiss", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseBindingBottomSheetDialog<B extends ViewDataBinding> extends BaseBottomSheetDialog {
    protected B binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBindingBottomSheetDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.core.component.SuperBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        try {
            getBinding().unbind();
        } catch (Exception e10) {
            ILog.DefaultImpls.logE$default((ILog) this, "dismiss() unbind error:" + e10, (String) null, true, 2, (Object) null);
        }
    }

    @NotNull
    protected final B getBinding() {
        B b10 = this.binding;
        if (b10 != null) {
            return b10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.core.component.SuperBottomSheetDialog
    public void init() {
        int layoutResId = getLayoutResId();
        if (layoutResId != -1) {
            setBinding(androidx.databinding.g.h(getLayoutInflater(), layoutResId, null, false));
            setContentView(getBinding().getRoot());
            return;
        }
        View createView = createView();
        if (createView != null) {
            ViewDataBinding a10 = androidx.databinding.g.a(createView);
            Intrinsics.checkNotNull(a10);
            setBinding(a10);
            setContentView(getBinding().getRoot());
        }
    }

    protected final void setBinding(@NotNull B b10) {
        Intrinsics.checkNotNullParameter(b10, "<set-?>");
        this.binding = b10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBindingBottomSheetDialog(@NotNull Context context, int i10) {
        super(context, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBindingBottomSheetDialog(@NotNull Context context, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
