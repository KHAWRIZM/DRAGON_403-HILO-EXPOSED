package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Landroid/content/Context;Ljava/lang/Float;)V", "getDiamond", "()Ljava/lang/Float;", "setDiamond", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "animation", "Landroid/view/animation/RotateAnimation;", "getAnimation", "()Landroid/view/animation/RotateAnimation;", "setAnimation", "(Landroid/view/animation/RotateAnimation;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "show", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonLoadingDialog extends AppCompatDialog {

    @Nullable
    private RotateAnimation animation;

    @Nullable
    private Float diamond;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLoadingDialog(@NotNull Context context, @Nullable Float f) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamond = f;
    }

    public void dismiss() {
        super.dismiss();
        RotateAnimation rotateAnimation = this.animation;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
    }

    @Nullable
    public final RotateAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final Float getDiamond() {
        return this.diamond;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setContentView(R.layout.dialog_common_loading);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        ImageView imageView = (ImageView) findViewById(R.id.loading_view);
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(android.R.color.transparent);
        }
        Float f = this.diamond;
        if (f != null) {
            float floatValue = f.floatValue();
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setDimAmount(floatValue);
            }
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 1000 * 360.0f, 1, 0.5f, 1, 0.5f);
        this.animation = rotateAnimation;
        rotateAnimation.setDuration(3000000);
        RotateAnimation rotateAnimation2 = this.animation;
        if (rotateAnimation2 != null) {
            rotateAnimation2.setRepeatCount(-1);
        }
        RotateAnimation rotateAnimation3 = this.animation;
        if (rotateAnimation3 != null) {
            rotateAnimation3.setInterpolator(new LinearInterpolator());
        }
        RotateAnimation rotateAnimation4 = this.animation;
        if (rotateAnimation4 != null) {
            rotateAnimation4.setFillAfter(true);
        }
        if (imageView != null) {
            imageView.setAnimation(this.animation);
        }
    }

    public final void setAnimation(@Nullable RotateAnimation rotateAnimation) {
        this.animation = rotateAnimation;
    }

    public final void setDiamond(@Nullable Float f) {
        this.diamond = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        RotateAnimation rotateAnimation = this.animation;
        if (rotateAnimation != null) {
            rotateAnimation.start();
        }
    }

    public /* synthetic */ CommonLoadingDialog(Context context, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : f);
    }
}
