package com.qiahao.nextvideo.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.g;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogBlockTextBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J \u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0012J0\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0012J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205H\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/ui/base/BlockTextDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mDialogBlockTextBinding", "Lcom/qiahao/nextvideo/databinding/DialogBlockTextBinding;", "getMDialogBlockTextBinding", "()Lcom/qiahao/nextvideo/databinding/DialogBlockTextBinding;", "setMDialogBlockTextBinding", "(Lcom/qiahao/nextvideo/databinding/DialogBlockTextBinding;)V", "mOnCommonDialogListener", "Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;", "getMOnCommonDialogListener", "()Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;", "setMOnCommonDialogListener", "(Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;)V", "mShowCancel", "", "getMShowCancel", "()Z", "setMShowCancel", "(Z)V", "mConfirmText", "", "getMConfirmText", "()Ljava/lang/String;", "setMConfirmText", "(Ljava/lang/String;)V", "mCancelText", "getMCancelText", "setMCancelText", "mContent", "getMContent", "setMContent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentText", "content", "showCancel", "onCommonDialogListener", "confirmText", "cancelText", "onClick", "v", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BlockTextDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private String mCancelText;

    @NotNull
    private String mConfirmText;

    @NotNull
    private String mContent;

    @NotNull
    private Context mContext;

    @Nullable
    private DialogBlockTextBinding mDialogBlockTextBinding;

    @Nullable
    private OnBlockCommonDialogListener mOnCommonDialogListener;
    private boolean mShowCancel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockTextDialog(@NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        this.mShowCancel = true;
        this.mConfirmText = "";
        this.mCancelText = "";
        this.mContent = "";
    }

    public static /* synthetic */ void setContentText$default(BlockTextDialog blockTextDialog, String str, boolean z, OnBlockCommonDialogListener onBlockCommonDialogListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        blockTextDialog.setContentText(str, z, onBlockCommonDialogListener);
    }

    @NotNull
    public final String getMCancelText() {
        return this.mCancelText;
    }

    @NotNull
    public final String getMConfirmText() {
        return this.mConfirmText;
    }

    @NotNull
    public final String getMContent() {
        return this.mContent;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final DialogBlockTextBinding getMDialogBlockTextBinding() {
        return this.mDialogBlockTextBinding;
    }

    @Nullable
    public final OnBlockCommonDialogListener getMOnCommonDialogListener() {
        return this.mOnCommonDialogListener;
    }

    public final boolean getMShowCancel() {
        return this.mShowCancel;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362224) {
            if (id2 == 2131362424) {
                OnBlockCommonDialogListener onBlockCommonDialogListener = this.mOnCommonDialogListener;
                if (onBlockCommonDialogListener != null && onBlockCommonDialogListener != null) {
                    onBlockCommonDialogListener.blockTextDialogConfirm();
                }
                dismiss();
                return;
            }
            return;
        }
        OnBlockCommonDialogListener onBlockCommonDialogListener2 = this.mOnCommonDialogListener;
        if (onBlockCommonDialogListener2 != null && onBlockCommonDialogListener2 != null) {
            onBlockCommonDialogListener2.blockTextCancel();
        }
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        int i = 0;
        DialogBlockTextBinding dialogBlockTextBinding = (DialogBlockTextBinding) g.h(LayoutInflater.from(this.mContext), R.layout.dialog_block_text, (ViewGroup) null, false);
        this.mDialogBlockTextBinding = dialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding);
        setContentView(dialogBlockTextBinding.getRoot());
        DialogBlockTextBinding dialogBlockTextBinding2 = this.mDialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding2);
        dialogBlockTextBinding2.setClick(this);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        attributes.dimAmount = 0.0f;
        DialogBlockTextBinding dialogBlockTextBinding3 = this.mDialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding3);
        ViewGroup.LayoutParams layoutParams = dialogBlockTextBinding3.bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        DialogBlockTextBinding dialogBlockTextBinding4 = this.mDialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding4);
        dialogBlockTextBinding4.bgRoot.setLayoutParams(layoutParams2);
        DialogBlockTextBinding dialogBlockTextBinding5 = this.mDialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding5);
        dialogBlockTextBinding5.contentText.setText(this.mContent);
        DialogBlockTextBinding dialogBlockTextBinding6 = this.mDialogBlockTextBinding;
        Intrinsics.checkNotNull(dialogBlockTextBinding6);
        TextView textView = dialogBlockTextBinding6.cancelButton;
        if (!this.mShowCancel) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public final void setContentText(@NotNull String content, boolean showCancel, @NotNull OnBlockCommonDialogListener onCommonDialogListener) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(onCommonDialogListener, "onCommonDialogListener");
        this.mContent = content;
        this.mShowCancel = showCancel;
        DialogBlockTextBinding dialogBlockTextBinding = this.mDialogBlockTextBinding;
        if (dialogBlockTextBinding != null) {
            Intrinsics.checkNotNull(dialogBlockTextBinding);
            dialogBlockTextBinding.contentText.setText(this.mContent);
            DialogBlockTextBinding dialogBlockTextBinding2 = this.mDialogBlockTextBinding;
            Intrinsics.checkNotNull(dialogBlockTextBinding2);
            dialogBlockTextBinding2.cancelButton.setVisibility(this.mShowCancel ? 0 : 8);
        }
        this.mOnCommonDialogListener = onCommonDialogListener;
    }

    public final void setMCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCancelText = str;
    }

    public final void setMConfirmText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mConfirmText = str;
    }

    public final void setMContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMDialogBlockTextBinding(@Nullable DialogBlockTextBinding dialogBlockTextBinding) {
        this.mDialogBlockTextBinding = dialogBlockTextBinding;
    }

    public final void setMOnCommonDialogListener(@Nullable OnBlockCommonDialogListener onBlockCommonDialogListener) {
        this.mOnCommonDialogListener = onBlockCommonDialogListener;
    }

    public final void setMShowCancel(boolean z) {
        this.mShowCancel = z;
    }

    public final void setContentText(@NotNull String content, boolean showCancel, @NotNull String confirmText, @NotNull String cancelText, @NotNull OnBlockCommonDialogListener onCommonDialogListener) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(onCommonDialogListener, "onCommonDialogListener");
        this.mContent = content;
        this.mShowCancel = showCancel;
        this.mConfirmText = confirmText;
        this.mCancelText = cancelText;
        DialogBlockTextBinding dialogBlockTextBinding = this.mDialogBlockTextBinding;
        if (dialogBlockTextBinding != null) {
            Intrinsics.checkNotNull(dialogBlockTextBinding);
            dialogBlockTextBinding.contentText.setText(this.mContent);
            DialogBlockTextBinding dialogBlockTextBinding2 = this.mDialogBlockTextBinding;
            Intrinsics.checkNotNull(dialogBlockTextBinding2);
            dialogBlockTextBinding2.cancelButton.setVisibility(this.mShowCancel ? 0 : 8);
            DialogBlockTextBinding dialogBlockTextBinding3 = this.mDialogBlockTextBinding;
            Intrinsics.checkNotNull(dialogBlockTextBinding3);
            dialogBlockTextBinding3.confirmButton.setText(confirmText);
            DialogBlockTextBinding dialogBlockTextBinding4 = this.mDialogBlockTextBinding;
            Intrinsics.checkNotNull(dialogBlockTextBinding4);
            dialogBlockTextBinding4.cancelButton.setText(cancelText);
        }
        this.mOnCommonDialogListener = onCommonDialogListener;
    }
}
