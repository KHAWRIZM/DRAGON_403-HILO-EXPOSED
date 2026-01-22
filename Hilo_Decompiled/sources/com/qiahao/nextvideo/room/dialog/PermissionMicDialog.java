package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogMatchPermissionsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/PermissionMicDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "onPermissionMicDialogListener", "Lcom/qiahao/nextvideo/room/dialog/OnPermissionMicDialogListener;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/room/dialog/OnPermissionMicDialogListener;)V", "mCurrentContext", "getMCurrentContext", "()Landroid/content/Context;", "setMCurrentContext", "(Landroid/content/Context;)V", "mOnPermissionMicDialogListener", "getMOnPermissionMicDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/OnPermissionMicDialogListener;", "setMOnPermissionMicDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/OnPermissionMicDialogListener;)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogMatchPermissionsBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogMatchPermissionsBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogMatchPermissionsBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PermissionMicDialog extends AppCompatDialog {
    public DialogMatchPermissionsBinding binding;

    @NotNull
    private Context mCurrentContext;

    @NotNull
    private OnPermissionMicDialogListener mOnPermissionMicDialogListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionMicDialog(@NotNull Context context, @NotNull OnPermissionMicDialogListener onPermissionMicDialogListener) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onPermissionMicDialogListener, "onPermissionMicDialogListener");
        this.mCurrentContext = context;
        this.mOnPermissionMicDialogListener = onPermissionMicDialogListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PermissionMicDialog permissionMicDialog, View view) {
        permissionMicDialog.dismiss();
        permissionMicDialog.mOnPermissionMicDialogListener.requestPermission();
    }

    @NotNull
    public final DialogMatchPermissionsBinding getBinding() {
        DialogMatchPermissionsBinding dialogMatchPermissionsBinding = this.binding;
        if (dialogMatchPermissionsBinding != null) {
            return dialogMatchPermissionsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @NotNull
    public final OnPermissionMicDialogListener getMOnPermissionMicDialogListener() {
        return this.mOnPermissionMicDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        DialogMatchPermissionsBinding inflate = DialogMatchPermissionsBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        setBinding(inflate);
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        ViewGroup.LayoutParams layoutParams = getBinding().bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        getBinding().bgRoot.setLayoutParams(layoutParams2);
        getBinding().cameraFrameLayout.setVisibility(8);
        getBinding().allowButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionMicDialog.onCreate$lambda$2(PermissionMicDialog.this, view);
            }
        });
    }

    public final void setBinding(@NotNull DialogMatchPermissionsBinding dialogMatchPermissionsBinding) {
        Intrinsics.checkNotNullParameter(dialogMatchPermissionsBinding, "<set-?>");
        this.binding = dialogMatchPermissionsBinding;
    }

    public final void setMCurrentContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mCurrentContext = context;
    }

    public final void setMOnPermissionMicDialogListener(@NotNull OnPermissionMicDialogListener onPermissionMicDialogListener) {
        Intrinsics.checkNotNullParameter(onPermissionMicDialogListener, "<set-?>");
        this.mOnPermissionMicDialogListener = onPermissionMicDialogListener;
    }
}
