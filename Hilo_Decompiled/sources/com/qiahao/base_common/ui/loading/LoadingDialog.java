package com.qiahao.base_common.ui.loading;

import android.content.Context;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/ui/loading/LoadingDialog;", "Lcom/qiahao/base_common/common/BaseDialog;", "context", "Landroid/content/Context;", "cancelable", "", "<init>", "(Landroid/content/Context;Z)V", "onInitialize", "", "getLayoutResId", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LoadingDialog extends BaseDialog {
    private final boolean cancelable;

    public /* synthetic */ LoadingDialog(Context context, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? true : z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.base_dialog_loading;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        setCancelable(this.cancelable);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingDialog(@NotNull Context context, boolean z10) {
        super(context, R.style.base_dialog_transparent);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cancelable = z10;
    }
}
