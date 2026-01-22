package com.qiahao.nextvideo.app.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCommonTextBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0014J \u00105\u001a\u0002022\u0006\u00106\u001a\u00020!2\b\b\u0002\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0015J0\u00105\u001a\u0002022\u0006\u00106\u001a\u00020!2\b\b\u0002\u00107\u001a\u00020\u001b2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020!2\u0006\u00108\u001a\u00020\u0015J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000202H\u0016R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dimAmount", "", "<init>", "(Landroid/content/Context;F)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDialogCommonTextBinding", "Lcom/qiahao/nextvideo/databinding/DialogCommonTextBinding;", "getMDialogCommonTextBinding", "()Lcom/qiahao/nextvideo/databinding/DialogCommonTextBinding;", "setMDialogCommonTextBinding", "(Lcom/qiahao/nextvideo/databinding/DialogCommonTextBinding;)V", "mOnCommonDialogListener", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getMOnCommonDialogListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setMOnCommonDialogListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "mShowCancel", "", "getMShowCancel", "()Z", "setMShowCancel", "(Z)V", "mConfirmText", "", "getMConfirmText", "()Ljava/lang/String;", "setMConfirmText", "(Ljava/lang/String;)V", "mCancelText", "getMCancelText", "setMCancelText", "mDimAmount", "getMDimAmount", "()F", "setMDimAmount", "(F)V", "mContent", "getMContent", "setMContent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentText", "content", "showCancel", "onCommonDialogListener", "confirmText", "cancelText", "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonTextDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private String mCancelText;

    @NotNull
    private String mConfirmText;

    @NotNull
    private String mContent;

    @NotNull
    private Context mContext;

    @Nullable
    private DialogCommonTextBinding mDialogCommonTextBinding;
    private float mDimAmount;

    @Nullable
    private OnCommonDialogListener mOnCommonDialogListener;
    private boolean mShowCancel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonTextDialog(@NotNull Context context, float f) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        this.mShowCancel = true;
        this.mConfirmText = "";
        this.mCancelText = "";
        this.mContent = "";
        this.mDimAmount = f;
    }

    public static /* synthetic */ void setContentText$default(CommonTextDialog commonTextDialog, String str, boolean z, OnCommonDialogListener onCommonDialogListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        commonTextDialog.setContentText(str, z, onCommonDialogListener);
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
    public final DialogCommonTextBinding getMDialogCommonTextBinding() {
        return this.mDialogCommonTextBinding;
    }

    public final float getMDimAmount() {
        return this.mDimAmount;
    }

    @Nullable
    public final OnCommonDialogListener getMOnCommonDialogListener() {
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
                OnCommonDialogListener onCommonDialogListener = this.mOnCommonDialogListener;
                if (onCommonDialogListener != null && onCommonDialogListener != null) {
                    onCommonDialogListener.confirm();
                }
                dismiss();
                return;
            }
            return;
        }
        OnCommonDialogListener onCommonDialogListener2 = this.mOnCommonDialogListener;
        if (onCommonDialogListener2 != null && onCommonDialogListener2 != null) {
            onCommonDialogListener2.cancel();
        }
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        int i = 0;
        DialogCommonTextBinding inflate = DialogCommonTextBinding.inflate(LayoutInflater.from(this.mContext), null, false);
        this.mDialogCommonTextBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        DialogCommonTextBinding dialogCommonTextBinding = this.mDialogCommonTextBinding;
        Intrinsics.checkNotNull(dialogCommonTextBinding);
        dialogCommonTextBinding.setClick(this);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        attributes.dimAmount = this.mDimAmount;
        DialogCommonTextBinding dialogCommonTextBinding2 = this.mDialogCommonTextBinding;
        Intrinsics.checkNotNull(dialogCommonTextBinding2);
        ViewGroup.LayoutParams layoutParams = dialogCommonTextBinding2.bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        DialogCommonTextBinding dialogCommonTextBinding3 = this.mDialogCommonTextBinding;
        Intrinsics.checkNotNull(dialogCommonTextBinding3);
        dialogCommonTextBinding3.bgRoot.setLayoutParams(layoutParams2);
        DialogCommonTextBinding dialogCommonTextBinding4 = this.mDialogCommonTextBinding;
        Intrinsics.checkNotNull(dialogCommonTextBinding4);
        dialogCommonTextBinding4.contentText.setText(this.mContent);
        if (!TextUtils.isEmpty(this.mConfirmText)) {
            DialogCommonTextBinding dialogCommonTextBinding5 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding5);
            dialogCommonTextBinding5.confirmButton.setText(this.mConfirmText);
        }
        if (!TextUtils.isEmpty(this.mCancelText)) {
            DialogCommonTextBinding dialogCommonTextBinding6 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding6);
            dialogCommonTextBinding6.cancelButton.setText(this.mCancelText);
        }
        DialogCommonTextBinding dialogCommonTextBinding7 = this.mDialogCommonTextBinding;
        Intrinsics.checkNotNull(dialogCommonTextBinding7);
        TextView textView = dialogCommonTextBinding7.cancelButton;
        if (!this.mShowCancel) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.mOnCommonDialogListener = null;
    }

    public final void setContentText(@NotNull String content, boolean showCancel, @NotNull OnCommonDialogListener onCommonDialogListener) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(onCommonDialogListener, "onCommonDialogListener");
        this.mContent = content;
        this.mShowCancel = showCancel;
        DialogCommonTextBinding dialogCommonTextBinding = this.mDialogCommonTextBinding;
        if (dialogCommonTextBinding != null) {
            Intrinsics.checkNotNull(dialogCommonTextBinding);
            dialogCommonTextBinding.contentText.setText(this.mContent);
            DialogCommonTextBinding dialogCommonTextBinding2 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding2);
            dialogCommonTextBinding2.cancelButton.setVisibility(this.mShowCancel ? 0 : 8);
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

    public final void setMDialogCommonTextBinding(@Nullable DialogCommonTextBinding dialogCommonTextBinding) {
        this.mDialogCommonTextBinding = dialogCommonTextBinding;
    }

    public final void setMDimAmount(float f) {
        this.mDimAmount = f;
    }

    public final void setMOnCommonDialogListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.mOnCommonDialogListener = onCommonDialogListener;
    }

    public final void setMShowCancel(boolean z) {
        this.mShowCancel = z;
    }

    public final void setContentText(@NotNull String content, boolean showCancel, @NotNull String confirmText, @NotNull String cancelText, @NotNull OnCommonDialogListener onCommonDialogListener) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(onCommonDialogListener, "onCommonDialogListener");
        this.mContent = content;
        this.mShowCancel = showCancel;
        this.mConfirmText = confirmText;
        this.mCancelText = cancelText;
        DialogCommonTextBinding dialogCommonTextBinding = this.mDialogCommonTextBinding;
        if (dialogCommonTextBinding != null) {
            Intrinsics.checkNotNull(dialogCommonTextBinding);
            dialogCommonTextBinding.contentText.setText(this.mContent);
            DialogCommonTextBinding dialogCommonTextBinding2 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding2);
            dialogCommonTextBinding2.cancelButton.setVisibility(this.mShowCancel ? 0 : 8);
            DialogCommonTextBinding dialogCommonTextBinding3 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding3);
            dialogCommonTextBinding3.confirmButton.setText(confirmText);
            DialogCommonTextBinding dialogCommonTextBinding4 = this.mDialogCommonTextBinding;
            Intrinsics.checkNotNull(dialogCommonTextBinding4);
            dialogCommonTextBinding4.cancelButton.setText(cancelText);
        }
        this.mOnCommonDialogListener = onCommonDialogListener;
    }

    public /* synthetic */ CommonTextDialog(Context context, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0.0f : f);
    }
}
