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
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogTakeMicTaskCompleteDiamondBinding;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/TakeMicTaskCompleteDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Landroid/content/Context;I)V", "getDiamond", "()I", "binding", "Lcom/qiahao/nextvideo/databinding/DialogTakeMicTaskCompleteDiamondBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogTakeMicTaskCompleteDiamondBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogTakeMicTaskCompleteDiamondBinding;)V", "mTakeMicTaskCompleteDialogListener", "Lcom/qiahao/nextvideo/room/dialog/TakeMicTaskCompleteDialogListener;", "getMTakeMicTaskCompleteDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/TakeMicTaskCompleteDialogListener;", "setMTakeMicTaskCompleteDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/TakeMicTaskCompleteDialogListener;)V", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TakeMicTaskCompleteDialog extends AppCompatDialog {
    public DialogTakeMicTaskCompleteDiamondBinding binding;
    private final int diamond;

    @Nullable
    private TakeMicTaskCompleteDialogListener mTakeMicTaskCompleteDialogListener;

    @NotNull
    private final RotateAnimation rotateAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeMicTaskCompleteDialog(@NotNull Context context, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(TakeMicTaskCompleteDialog takeMicTaskCompleteDialog, View view) {
        TakeMicTaskCompleteDialogListener takeMicTaskCompleteDialogListener = takeMicTaskCompleteDialog.mTakeMicTaskCompleteDialogListener;
        if (takeMicTaskCompleteDialogListener != null) {
            takeMicTaskCompleteDialogListener.confirm();
        }
        takeMicTaskCompleteDialog.dismiss();
    }

    @NotNull
    public final DialogTakeMicTaskCompleteDiamondBinding getBinding() {
        DialogTakeMicTaskCompleteDiamondBinding dialogTakeMicTaskCompleteDiamondBinding = this.binding;
        if (dialogTakeMicTaskCompleteDiamondBinding != null) {
            return dialogTakeMicTaskCompleteDiamondBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final TakeMicTaskCompleteDialogListener getMTakeMicTaskCompleteDialogListener() {
        return this.mTakeMicTaskCompleteDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding((DialogTakeMicTaskCompleteDiamondBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.dialog_take_mic_task_complete_diamond, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        Dimens dimens = Dimens.INSTANCE;
        attributes.width = dimens.getScreenWidth() - dimens.dpToPx(68);
        attributes.height = -2;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setDimAmount(0.0f);
        getBinding().diamond.setText("x" + this.diamond);
        TextView textView = getBinding().tip1;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952357), Arrays.copyOf(new Object[]{String.valueOf(this.diamond)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        getBinding().light2.setAnimation(this.rotateAnimation);
        getBinding().light2.getAnimation().startNow();
        getBinding().close.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.c4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TakeMicTaskCompleteDialog.this.dismiss();
            }
        });
        getBinding().okButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TakeMicTaskCompleteDialog.onCreate$lambda$3(TakeMicTaskCompleteDialog.this, view);
            }
        });
    }

    public final void setBinding(@NotNull DialogTakeMicTaskCompleteDiamondBinding dialogTakeMicTaskCompleteDiamondBinding) {
        Intrinsics.checkNotNullParameter(dialogTakeMicTaskCompleteDiamondBinding, "<set-?>");
        this.binding = dialogTakeMicTaskCompleteDiamondBinding;
    }

    public final void setMTakeMicTaskCompleteDialogListener(@Nullable TakeMicTaskCompleteDialogListener takeMicTaskCompleteDialogListener) {
        this.mTakeMicTaskCompleteDialogListener = takeMicTaskCompleteDialogListener;
    }
}
