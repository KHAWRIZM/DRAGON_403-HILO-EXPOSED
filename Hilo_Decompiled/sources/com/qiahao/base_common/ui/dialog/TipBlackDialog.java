package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogTipBlackBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.HiloUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010'\u001a\u00020\u0006H\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0013J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u001fJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#¨\u00065"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/TipBlackDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogTipBlackBinding;", "context", "Landroid/content/Context;", "diamond", "", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "getDiamond", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "confirmText", "getConfirmText", "setConfirmText", "cancelText", "getCancelText", "setCancelText", "hideCancel", "", "getHideCancel", "()Z", "setHideCancel", "(Z)V", "mTouchOutsideHide", "getMTouchOutsideHide", "setMTouchOutsideHide", "getLayoutResId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTipContent", "tip", "setConfirmContent", "confirm", "setCancelContent", "cancel", "isHide", "touchOutsideHide", "setDialogListener", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TipBlackDialog extends BaseBindingDialog<DialogTipBlackBinding> {

    @NotNull
    private String cancelText;

    @NotNull
    private String confirmText;

    @NotNull
    private String content;

    @Nullable
    private final Integer diamond;
    private boolean hideCancel;

    @Nullable
    private OnCommonDialogListener listener;
    private boolean mTouchOutsideHide;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipBlackDialog(@NotNull Context context, @Nullable Integer num) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamond = num;
        this.content = "";
        this.confirmText = "";
        this.cancelText = "";
        this.mTouchOutsideHide = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(TipBlackDialog tipBlackDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipBlackDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.confirm();
            }
            tipBlackDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(TipBlackDialog tipBlackDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipBlackDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.cancel();
            }
            tipBlackDialog.dismiss();
        }
    }

    @NotNull
    public final String getCancelText() {
        return this.cancelText;
    }

    @NotNull
    public final String getConfirmText() {
        return this.confirmText;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getDiamond() {
        return this.diamond;
    }

    public final boolean getHideCancel() {
        return this.hideCancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_tip_black;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    public final boolean getMTouchOutsideHide() {
        return this.mTouchOutsideHide;
    }

    @NotNull
    public final TipBlackDialog hideCancel(boolean isHide) {
        this.hideCancel = isHide;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.base_common.common.BaseDialog, com.oudi.core.component.SuperDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBinding().content.setText(this.content);
        if (!TextUtils.isEmpty(this.confirmText)) {
            getBinding().confirm.setText(this.confirmText);
        }
        if (!TextUtils.isEmpty(this.cancelText)) {
            getBinding().cancel.setText(this.cancelText);
        }
        if (this.hideCancel) {
            getBinding().cancel.setVisibility(8);
        }
        getBinding().confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipBlackDialog.onCreate$lambda$0(TipBlackDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(this.mTouchOutsideHide);
        getBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipBlackDialog.onCreate$lambda$1(TipBlackDialog.this, view);
            }
        });
    }

    @NotNull
    public final TipBlackDialog setCancelContent(@NotNull String cancel) {
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.cancelText = cancel;
        return this;
    }

    public final void setCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancelText = str;
    }

    @NotNull
    public final TipBlackDialog setConfirmContent(@NotNull String confirm) {
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
    public final TipBlackDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
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
    public final TipBlackDialog setTipContent(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.content = tip;
        return this;
    }

    @NotNull
    public final TipBlackDialog touchOutsideHide(boolean isHide) {
        this.mTouchOutsideHide = isHide;
        return this;
    }

    public /* synthetic */ TipBlackDialog(Context context, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? 0 : num);
    }
}
