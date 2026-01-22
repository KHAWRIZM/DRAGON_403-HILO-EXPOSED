package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.view.View;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogReportBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/ReportDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogReportBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mReportDialogListener", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "getMReportDialogListener", "()Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "setMReportDialogListener", "(Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;)V", "getLayoutResId", "", "setListener", "reportDialogListener", "onInitialize", "", "confirmButtonPressed", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ReportDialog extends BaseBindingDialog<DialogReportBinding> {

    @Nullable
    private ReportDialogListener mReportDialogListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmButtonPressed() {
        int checkedRadioButtonId = getBinding().reportTypesRadioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.firstRadioButton) {
            ReportDialogListener reportDialogListener = this.mReportDialogListener;
            if (reportDialogListener != null) {
                reportDialogListener.reportDialogCheck(5, ResourcesKtxKt.getStringById(this, R.string.pornography));
            }
        } else if (checkedRadioButtonId == R.id.secondRadioButton) {
            ReportDialogListener reportDialogListener2 = this.mReportDialogListener;
            if (reportDialogListener2 != null) {
                reportDialogListener2.reportDialogCheck(6, ResourcesKtxKt.getStringById(this, R.string.underage));
            }
        } else if (checkedRadioButtonId == R.id.threeRadioButton) {
            ReportDialogListener reportDialogListener3 = this.mReportDialogListener;
            if (reportDialogListener3 != null) {
                reportDialogListener3.reportDialogCheck(7, ResourcesKtxKt.getStringById(this, R.string.advertise));
            }
        } else if (checkedRadioButtonId == R.id.fourRadioButton) {
            ReportDialogListener reportDialogListener4 = this.mReportDialogListener;
            if (reportDialogListener4 != null) {
                reportDialogListener4.reportDialogCheck(8, ResourcesKtxKt.getStringById(this, R.string.other_violations));
            }
        } else {
            if (checkedRadioButtonId == -1) {
                return;
            }
            ReportDialogListener reportDialogListener5 = this.mReportDialogListener;
            if (reportDialogListener5 != null) {
                reportDialogListener5.reportDialogCheck(8, ResourcesKtxKt.getStringById(this, R.string.other_violations));
            }
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_report;
    }

    @Nullable
    public final ReportDialogListener getMReportDialogListener() {
        return this.mReportDialogListener;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        getBinding().cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportDialog.this.dismiss();
            }
        });
        getBinding().confirmReportButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportDialog.this.confirmButtonPressed();
            }
        });
    }

    @NotNull
    public final ReportDialog setListener(@NotNull ReportDialogListener reportDialogListener) {
        Intrinsics.checkNotNullParameter(reportDialogListener, "reportDialogListener");
        this.mReportDialogListener = reportDialogListener;
        return this;
    }

    public final void setMReportDialogListener(@Nullable ReportDialogListener reportDialogListener) {
        this.mReportDialogListener = reportDialogListener;
    }
}
