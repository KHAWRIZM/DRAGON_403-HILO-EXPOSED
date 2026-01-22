package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0014J0\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020$R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/AnimatedNumberTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spacing", "", "textView", "Lcom/qiahao/nextvideo/ui/reusable/views/DiamondTickTextView;", "iconImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "p0", "", "l", "t", "r", "b", "newValue", "", FamilySettingFragment.FAMILY_NUMBER, "getNumber", "()J", "setNumber", "(J)V", "setText", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimatedNumberTextView extends FrameLayout {

    @NotNull
    private final AppCompatImageView iconImageView;
    private long number;
    private int spacing;

    @NotNull
    private final DiamondTickTextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.TextView, android.view.View, com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView] */
    public AnimatedNumberTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Dimens dimens = Dimens.INSTANCE;
        this.spacing = dimens.dpToPx(4);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ?? diamondTickTextView = new DiamondTickTextView(context2);
        diamondTickTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        diamondTickTextView.setLines(1);
        diamondTickTextView.setTextSize(dimens.getFontSizeSmall());
        diamondTickTextView.setGravity(8388627);
        diamondTickTextView.setTextColor(-1);
        this.textView = diamondTickTextView;
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.iconImageView = appCompatImageView;
        setClipChildren(false);
        setClipToPadding(false);
        addView(appCompatImageView);
        addView(diamondTickTextView);
    }

    @NotNull
    public final AppCompatImageView getIconImageView() {
        return this.iconImageView;
    }

    public final long getNumber() {
        return this.number;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean p0, int l, int t, int r, int b) {
        AppCompatImageView appCompatImageView = this.iconImageView;
        int i = b - t;
        ViewUtilitiesKt.setFrame(appCompatImageView, 0, (i - appCompatImageView.getMeasuredHeight()) / 2, this.iconImageView.getMeasuredWidth(), this.iconImageView.getMeasuredHeight());
        int measuredWidth = this.iconImageView.getMeasuredWidth() + this.spacing;
        AppCompatTextView appCompatTextView = this.textView;
        int i2 = (r - l) - measuredWidth;
        ViewUtilitiesKt.setFrame(appCompatTextView, measuredWidth, (i - appCompatTextView.getMeasuredHeight()) / 2, i2, this.textView.getMeasuredHeight());
        this.textView.getLayoutParams().width = i2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChild(this.iconImageView, widthMeasureSpec, heightMeasureSpec);
        measureChild(this.textView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.iconImageView.getMeasuredWidth() + this.spacing + this.textView.getMeasuredWidth(), Math.max(this.iconImageView.getMeasuredHeight(), this.textView.getMeasuredHeight()));
    }

    public final void setNumber(long j) {
        this.number = j;
        this.textView.setText(String.valueOf(j));
    }

    public final void setText(double number) {
        this.textView.setText((long) number);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.widget.TextView, android.view.View, com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView] */
    public AnimatedNumberTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Dimens dimens = Dimens.INSTANCE;
        this.spacing = dimens.dpToPx(4);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ?? diamondTickTextView = new DiamondTickTextView(context2);
        diamondTickTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        diamondTickTextView.setLines(1);
        diamondTickTextView.setTextSize(dimens.getFontSizeSmall());
        diamondTickTextView.setGravity(8388627);
        diamondTickTextView.setTextColor(-1);
        this.textView = diamondTickTextView;
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.iconImageView = appCompatImageView;
        setClipChildren(false);
        setClipToPadding(false);
        addView(appCompatImageView);
        addView(diamondTickTextView);
    }
}
