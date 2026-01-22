package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogProgressBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/HiloProgressDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogProgressBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onInitialize", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloProgressDialog extends BaseBindingDialog<DialogProgressBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloProgressDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_progress;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
    }
}
