package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogTipBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.HiloUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0014J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u001aJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u00064"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/TipDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogTipBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "confirmText", "getConfirmText", "setConfirmText", "cancelText", "getCancelText", "setCancelText", "hideCancel", "", "getHideCancel", "()Z", "setHideCancel", "(Z)V", "mTouchOutsideHide", "getMTouchOutsideHide", "setMTouchOutsideHide", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTipContent", "tip", "setConfirmContent", "confirm", "isHide", "touchOutsideHide", "setCancelContent", "cancel", "setDialogListener", "getConfirmButton", "Landroid/widget/TextView;", "getTipText", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TipDialog extends BaseBindingDialog<DialogTipBinding> {

    @NotNull
    private String cancelText;

    @NotNull
    private String confirmText;

    @NotNull
    private String content;
    private boolean hideCancel;

    @Nullable
    private OnCommonDialogListener listener;
    private boolean mTouchOutsideHide;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = "";
        this.confirmText = "";
        this.cancelText = "";
        this.mTouchOutsideHide = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(TipDialog tipDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.confirm();
            }
            tipDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(TipDialog tipDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.cancel();
            }
            tipDialog.dismiss();
        }
    }

    @NotNull
    public final String getCancelText() {
        return this.cancelText;
    }

    @NotNull
    public final TextView getConfirmButton() {
        TextView confirm = getBinding().confirm;
        Intrinsics.checkNotNullExpressionValue(confirm, "confirm");
        return confirm;
    }

    @NotNull
    public final String getConfirmText() {
        return this.confirmText;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final boolean getHideCancel() {
        return this.hideCancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_tip;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    public final boolean getMTouchOutsideHide() {
        return this.mTouchOutsideHide;
    }

    @NotNull
    public final TextView getTipText() {
        AppCompatTextView content = getBinding().content;
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }

    @NotNull
    public final TipDialog hideCancel(boolean isHide) {
        this.hideCancel = isHide;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.base_common.common.BaseDialog, com.oudi.core.component.SuperDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!TextUtils.isEmpty(this.content)) {
            getBinding().content.setText(this.content);
        }
        if (!TextUtils.isEmpty(this.confirmText)) {
            getBinding().confirm.setText(this.confirmText);
        }
        if (!TextUtils.isEmpty(this.cancelText)) {
            getBinding().cancel.setText(this.cancelText);
        }
        if (this.hideCancel) {
            getBinding().cancel.setVisibility(8);
        }
        setCanceledOnTouchOutside(this.mTouchOutsideHide);
        getBinding().confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipDialog.onCreate$lambda$0(TipDialog.this, view);
            }
        });
        getBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipDialog.onCreate$lambda$1(TipDialog.this, view);
            }
        });
    }

    @NotNull
    public final TipDialog setCancelContent(@NotNull String cancel) {
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.cancelText = cancel;
        return this;
    }

    public final void setCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancelText = str;
    }

    @NotNull
    public final TipDialog setConfirmContent(@NotNull String confirm) {
        Intrinsics.checkNotNullParameter(confirm, "confirm");
        this.confirmText = confirm;
        return this;
    }

    public final void setConfirmText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.confirmText = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    @NotNull
    public final TipDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void setHideCancel(boolean z10) {
        this.hideCancel = z10;
    }

    public final void setListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.listener = onCommonDialogListener;
    }

    public final void setMTouchOutsideHide(boolean z10) {
        this.mTouchOutsideHide = z10;
    }

    @NotNull
    public final TipDialog setTipContent(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.content = tip;
        return this;
    }

    @NotNull
    public final TipDialog touchOutsideHide(boolean isHide) {
        this.mTouchOutsideHide = isHide;
        return this;
    }
}
