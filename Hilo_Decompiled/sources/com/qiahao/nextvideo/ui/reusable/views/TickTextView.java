package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u0013R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/TickTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "newValue", "", FamilySettingFragment.FAMILY_NUMBER, "setNumber", "(F)V", "animateTo", "Landroid/animation/ObjectAnimator;", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TickTextView extends AppCompatTextView {
    private float number;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TickTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setLines(1);
        setGravity(17);
        setTextColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setNumber(float f) {
        this.number = f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        setText(format);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ObjectAnimator animateTo(float number) {
        String valueOf;
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, FamilySettingFragment.FAMILY_NUMBER, this.number, number).setDuration(800L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        setTranslationY(0.0f);
        float f = number - this.number;
        if (f > 0.0f) {
            valueOf = "+" + f;
        } else {
            valueOf = String.valueOf(f);
        }
        setText(valueOf);
        duration.addListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.TickTextView$animateTo$1
            @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                TickTextView.this.setTranslationY(0.0f);
            }
        });
        duration.start();
        return duration;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TickTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setLines(1);
        setGravity(17);
        setTextColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ObjectAnimator animateTo(final double number) {
        String valueOf;
        if (number > 3.4028234663852886E38d) {
            setText(String.valueOf(number));
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, FamilySettingFragment.FAMILY_NUMBER, this.number, (float) number).setDuration(800L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        setTranslationY(0.0f);
        double d = number - this.number;
        if (d > 0.0d) {
            valueOf = "+" + d;
        } else {
            valueOf = String.valueOf(d);
        }
        setText(valueOf);
        duration.addListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.TickTextView$animateTo$2
            @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                TickTextView.this.setTranslationY(0.0f);
                AppCompatTextView appCompatTextView = TickTextView.this;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                CharSequence format = String.format("%.0f", Arrays.copyOf(new Object[]{Double.valueOf(number)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                appCompatTextView.setText(format);
            }
        });
        duration.start();
        return duration;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TickTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setLines(1);
        setGravity(17);
        setTextColor(-1);
    }
}
