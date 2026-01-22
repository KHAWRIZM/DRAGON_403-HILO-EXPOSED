package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogRoomTipBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0014J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001aJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomTipDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRoomTipBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "confirmText", "getConfirmText", "setConfirmText", "cancelText", "getCancelText", "setCancelText", "autoDismiss", "", "getAutoDismiss", "()Z", "setAutoDismiss", "(Z)V", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTipContent", "tip", "setConfirmContent", "confirm", "isDismiss", "setCancelContent", "cancel", "setDialogListener", "getBinding", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomTipDialog extends BaseBindingDialog<DialogRoomTipBinding> {
    private boolean autoDismiss;

    @NotNull
    private String cancelText;

    @NotNull
    private String confirmText;

    @NotNull
    private String content;

    @Nullable
    private OnCommonDialogListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTipDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = "";
        this.confirmText = "";
        this.cancelText = "";
        this.autoDismiss = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(RoomTipDialog roomTipDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = roomTipDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.confirm();
            }
            if (roomTipDialog.autoDismiss) {
                roomTipDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(RoomTipDialog roomTipDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = roomTipDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.cancel();
            }
            roomTipDialog.dismiss();
        }
    }

    public final boolean getAutoDismiss() {
        return this.autoDismiss;
    }

    @NotNull
    public final DialogRoomTipBinding getBinding() {
        return (DialogRoomTipBinding) getBinding();
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

    protected int getLayoutResId() {
        return R.layout.dialog_room_tip;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        ((DialogRoomTipBinding) getBinding()).content.setText(this.content);
        if (!TextUtils.isEmpty(this.confirmText)) {
            ((DialogRoomTipBinding) getBinding()).confirm.setText(this.confirmText);
        }
        if (!TextUtils.isEmpty(this.cancelText)) {
            ((DialogRoomTipBinding) getBinding()).cancel.setText(this.cancelText);
        }
        ((DialogRoomTipBinding) getBinding()).confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.w3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomTipDialog.onCreate$lambda$0(RoomTipDialog.this, view);
            }
        });
        ((DialogRoomTipBinding) getBinding()).cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomTipDialog.onCreate$lambda$1(RoomTipDialog.this, view);
            }
        });
    }

    /* renamed from: setAutoDismiss, reason: collision with other method in class */
    public final void m٦٠setAutoDismiss(boolean z) {
        this.autoDismiss = z;
    }

    @NotNull
    public final RoomTipDialog setCancelContent(@NotNull String cancel) {
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.cancelText = cancel;
        return this;
    }

    public final void setCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancelText = str;
    }

    @NotNull
    public final RoomTipDialog setConfirmContent(@NotNull String confirm) {
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
    public final RoomTipDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void setListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.listener = onCommonDialogListener;
    }

    @NotNull
    public final RoomTipDialog setTipContent(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.content = tip;
        return this;
    }

    @NotNull
    public final RoomTipDialog setAutoDismiss(boolean isDismiss) {
        this.autoDismiss = isDismiss;
        return this;
    }
}
