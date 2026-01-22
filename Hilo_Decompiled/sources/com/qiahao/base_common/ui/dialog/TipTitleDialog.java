package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogTipTitleBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.HiloUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010-\u001a\u00020#H\u0014J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u000eJ\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u001dJ\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020#J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020#J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u000eJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010*\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'¨\u0006?"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/TipTitleDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogTipTitleBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "confirmText", "getConfirmText", "setConfirmText", "cancelText", "getCancelText", "setCancelText", "title", "getTitle", "setTitle", "hideCancel", "", "getHideCancel", "()Z", "setHideCancel", "(Z)V", "subColor", "", "getSubColor", "()I", "setSubColor", "(I)V", "isRoom", "setRoom", "mSubAlign", "getMSubAlign", "setMSubAlign", "getLayoutResId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTitleContent", "setTipContent", "tip", "setConfirmContent", "confirm", "isHide", "setTipColor", "color", "setTipAlign", "align", "setCancelContent", "cancel", "setDialogListener", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TipTitleDialog extends BaseBindingDialog<DialogTipTitleBinding> {

    @NotNull
    private String cancelText;

    @NotNull
    private String confirmText;

    @NotNull
    private String content;
    private boolean hideCancel;
    private boolean isRoom;

    @Nullable
    private OnCommonDialogListener listener;
    private int mSubAlign;
    private int subColor;

    @NotNull
    private String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipTitleDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = "";
        this.confirmText = "";
        this.cancelText = "";
        this.title = "";
        this.mSubAlign = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(TipTitleDialog tipTitleDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipTitleDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.confirm();
            }
            tipTitleDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(TipTitleDialog tipTitleDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = tipTitleDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.cancel();
            }
            tipTitleDialog.dismiss();
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

    public final boolean getHideCancel() {
        return this.hideCancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_tip_title;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    public final int getMSubAlign() {
        return this.mSubAlign;
    }

    public final int getSubColor() {
        return this.subColor;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final TipTitleDialog hideCancel(boolean isHide) {
        this.hideCancel = isHide;
        return this;
    }

    /* renamed from: isRoom, reason: from getter */
    public final boolean getIsRoom() {
        return this.isRoom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.base_common.common.BaseDialog, com.oudi.core.component.SuperDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBinding().content.setText(this.content);
        getBinding().content.setGravity(this.mSubAlign);
        if (!TextUtils.isEmpty(this.confirmText)) {
            getBinding().confirm.setText(this.confirmText);
        }
        if (!TextUtils.isEmpty(this.cancelText)) {
            getBinding().cancel.setText(this.cancelText);
        }
        if (!TextUtils.isEmpty(this.title)) {
            getBinding().title.setText(this.title);
        }
        if (this.hideCancel) {
            getBinding().cancel.setVisibility(8);
        }
        if (this.subColor != 0) {
            getBinding().content.setTextColor(this.subColor);
        }
        if (this.isRoom) {
            getBinding().rootView.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.bg_common_dialog));
            getBinding().title.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.white));
            getBinding().content.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.color_C9C9C9));
            getBinding().cancel.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.color_d0d0d0));
            getBinding().cancel.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.bg_common_dialog_cancel_room));
        } else {
            getBinding().rootView.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_ffffff_14));
            getBinding().title.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.color_333333));
            getBinding().content.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.color_999999));
            getBinding().cancel.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.color_666666));
            getBinding().cancel.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.bg_common_dialog_cancel2));
        }
        getBinding().confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipTitleDialog.onCreate$lambda$0(TipTitleDialog.this, view);
            }
        });
        getBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipTitleDialog.onCreate$lambda$1(TipTitleDialog.this, view);
            }
        });
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.6f);
        }
    }

    @NotNull
    public final TipTitleDialog setCancelContent(@NotNull String cancel) {
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.cancelText = cancel;
        return this;
    }

    public final void setCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancelText = str;
    }

    @NotNull
    public final TipTitleDialog setConfirmContent(@NotNull String confirm) {
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
    public final TipTitleDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
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

    public final void setMSubAlign(int i10) {
        this.mSubAlign = i10;
    }

    /* renamed from: setRoom, reason: collision with other method in class */
    public final void m٥٢٨setRoom(boolean z10) {
        this.isRoom = z10;
    }

    public final void setSubColor(int i10) {
        this.subColor = i10;
    }

    @NotNull
    public final TipTitleDialog setTipAlign(int align) {
        this.mSubAlign = align;
        return this;
    }

    @NotNull
    public final TipTitleDialog setTipColor(int color) {
        this.subColor = color;
        return this;
    }

    @NotNull
    public final TipTitleDialog setTipContent(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.content = tip;
        return this;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public final TipTitleDialog setTitleContent(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }

    @NotNull
    public final TipTitleDialog setRoom(boolean isRoom) {
        this.isRoom = isRoom;
        return this;
    }
}
