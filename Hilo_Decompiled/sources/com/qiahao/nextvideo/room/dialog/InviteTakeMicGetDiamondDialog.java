package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogInviteTakeMicGetDiamondBinding;
import com.qiahao.nextvideo.ui.task.TasksActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Landroid/content/Context;I)V", "getDiamond", "()I", "binding", "Lcom/qiahao/nextvideo/databinding/DialogInviteTakeMicGetDiamondBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogInviteTakeMicGetDiamondBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogInviteTakeMicGetDiamondBinding;)V", "mInviteTakeMicGetDiamondDialogListener", "Lcom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialogListener;", "getMInviteTakeMicGetDiamondDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialogListener;", "setMInviteTakeMicGetDiamondDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialogListener;)V", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInviteTakeMicGetDiamondDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InviteTakeMicGetDiamondDialog.kt\ncom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,84:1\n61#2,9:85\n61#2,9:94\n61#2,9:103\n*S KotlinDebug\n*F\n+ 1 InviteTakeMicGetDiamondDialog.kt\ncom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialog\n*L\n66#1:85,9\n69#1:94,9\n75#1:103,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class InviteTakeMicGetDiamondDialog extends AppCompatDialog {
    public DialogInviteTakeMicGetDiamondBinding binding;
    private final int diamond;

    @Nullable
    private InviteTakeMicGetDiamondDialogListener mInviteTakeMicGetDiamondDialogListener;

    @NotNull
    private final RotateAnimation rotateAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteTakeMicGetDiamondDialog(@NotNull Context context, int i) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamond = i;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation = rotateAnimation;
    }

    @NotNull
    public final DialogInviteTakeMicGetDiamondBinding getBinding() {
        DialogInviteTakeMicGetDiamondBinding dialogInviteTakeMicGetDiamondBinding = this.binding;
        if (dialogInviteTakeMicGetDiamondBinding != null) {
            return dialogInviteTakeMicGetDiamondBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final InviteTakeMicGetDiamondDialogListener getMInviteTakeMicGetDiamondDialogListener() {
        return this.mInviteTakeMicGetDiamondDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        super.onCreate(savedInstanceState);
        setBinding((DialogInviteTakeMicGetDiamondBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.dialog_invite_take_mic_get_diamond, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 17;
            Dimens dimens = Dimens.INSTANCE;
            attributes.width = dimens.getScreenWidth() - dimens.dpToPx(68);
            attributes.height = -2;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.0f);
        }
        getBinding().diamond.setText("x" + this.diamond);
        getBinding().light2.setAnimation(this.rotateAnimation);
        getBinding().light2.getAnimation().startNow();
        final ImageView imageView = getBinding().close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final TextView textView = getBinding().okButton;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialog$onCreate$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    InviteTakeMicGetDiamondDialogListener mInviteTakeMicGetDiamondDialogListener = this.getMInviteTakeMicGetDiamondDialogListener();
                    if (mInviteTakeMicGetDiamondDialogListener != null) {
                        mInviteTakeMicGetDiamondDialogListener.upMic();
                    }
                    this.dismiss();
                }
            }
        });
        getBinding().moreTask.getPaint().setFlags(8);
        getBinding().moreTask.getPaint().setAntiAlias(true);
        final TextView textView2 = getBinding().moreTask;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialog$onCreate$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    TasksActivity.Companion companion = TasksActivity.Companion;
                    Context context = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    TasksActivity.Companion.start$default(companion, context, 0, 2, null);
                    this.dismiss();
                }
            }
        });
    }

    public final void setBinding(@NotNull DialogInviteTakeMicGetDiamondBinding dialogInviteTakeMicGetDiamondBinding) {
        Intrinsics.checkNotNullParameter(dialogInviteTakeMicGetDiamondBinding, "<set-?>");
        this.binding = dialogInviteTakeMicGetDiamondBinding;
    }

    public final void setMInviteTakeMicGetDiamondDialogListener(@Nullable InviteTakeMicGetDiamondDialogListener inviteTakeMicGetDiamondDialogListener) {
        this.mInviteTakeMicGetDiamondDialogListener = inviteTakeMicGetDiamondDialogListener;
    }
}
