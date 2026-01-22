package com.amazonaws.mobile.auth.core.signin.ui.buttons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.R;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SignInButton extends LinearLayout {
    private static final int BORDER_COLOR = -16777216;
    private static final float MIN_TEXT_SIZE_SP = 8.0f;
    private final SignInButtonAttributes attributes;
    protected Bitmap bitmap;
    protected ImageView imageView;
    protected boolean isSmallStyle;
    protected TextView textView;
    private static final int IMAGE_LEFT_MARGIN = DisplayUtils.dp(8);
    private static final int IMAGE_RIGHT_MARGIN = DisplayUtils.dp(8);
    private static final int TEXT_LEFT_MARGIN = DisplayUtils.dp(2);
    private static final int TEXT_RIGHT_MARGIN = DisplayUtils.dp(8);
    private static final float MAX_TEXT_SIZE_PX = DisplayUtils.dp(50);

    public SignInButton(Context context, AttributeSet attributeSet, int i10, SignInButtonAttributes signInButtonAttributes) {
        super(context, attributeSet, i10);
        this.isSmallStyle = false;
        this.attributes = signInButtonAttributes;
        setFocusable(true);
        setClickable(true);
        setOrientation(0);
        setGravity(16);
        setBackgroundDrawable(getBackgroundStatesDrawable());
        this.imageView = new ImageView(context);
        this.bitmap = BitmapFactory.decodeResource(getResources(), signInButtonAttributes.getImageIconResourceId());
        this.imageView.setImageDrawable(new BitmapDrawable(getResources(), this.bitmap));
        this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imageView.setAdjustViewBounds(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(IMAGE_LEFT_MARGIN, 0, IMAGE_RIGHT_MARGIN, 0);
        layoutParams.weight = 0.0f;
        addView(this.imageView, layoutParams);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(signInButtonAttributes.getTextColor());
        String str = null;
        this.textView.setTypeface(null, 1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SignInButton);
            if (obtainStyledAttributes.getInt(R.styleable.SignInButton_button_style, 0) > 0) {
                this.isSmallStyle = true;
            }
            str = obtainStyledAttributes.getString(R.styleable.SignInButton_text);
            obtainStyledAttributes.recycle();
        }
        if (str != null) {
            this.textView.setText(str);
        } else {
            this.textView.setText(signInButtonAttributes.getDefaultTextResourceId());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(DisplayUtils.dp(TEXT_LEFT_MARGIN), 0, DisplayUtils.dp(TEXT_RIGHT_MARGIN), 0);
        layoutParams2.weight = 1.0f;
        addView(this.textView, layoutParams2);
        updateStyle();
        invalidate();
    }

    private boolean doesTextViewFit(float f10, RectF rectF) {
        String charSequence;
        TextPaint textPaint = new TextPaint(this.textView.getPaint());
        textPaint.setTextSize(f10);
        TransformationMethod transformationMethod = this.textView.getTransformationMethod();
        if (transformationMethod == null) {
            charSequence = this.textView.getText().toString();
        } else {
            charSequence = transformationMethod.getTransformation(this.textView.getText(), this.textView).toString();
        }
        return rectF.contains(new RectF(0.0f, 0.0f, textPaint.measureText(charSequence), textPaint.getFontSpacing()));
    }

    private float findBestSize(float f10, float f11, RectF rectF) {
        float f12 = f11;
        float f13 = f10;
        while (f10 <= f12) {
            float f14 = (f10 + f12) / 2.0f;
            if (doesTextViewFit(f14, rectF)) {
                f10 = f14 + 0.5f;
                f13 = f14;
            } else {
                f12 = f14 - 0.5f;
            }
        }
        return f13;
    }

    private Drawable getBackgroundStatesDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, getButtonBackground(this.attributes.getBackgroundColorPressed()));
        stateListDrawable.addState(new int[0], getButtonBackground(this.attributes.getBackgroundColor()));
        return stateListDrawable;
    }

    private Drawable getButtonBackground(int i10) {
        ShapeDrawable roundedRectangleBackground = DisplayUtils.getRoundedRectangleBackground(this.attributes.getCornerRadius(), i10);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{this.attributes.getTopShadowColor(), this.attributes.getTopShadowColor()});
        gradientDrawable.setCornerRadius(DisplayUtils.dp(r0));
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{this.attributes.getBottomShadowColor(), this.attributes.getBottomShadowColor()});
        gradientDrawable2.setCornerRadius(DisplayUtils.dp(r0));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2, roundedRectangleBackground});
        layerDrawable.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable.setLayerInset(1, this.attributes.getTopShadowThickness(), this.attributes.getTopShadowThickness(), 0, 0);
        layerDrawable.setLayerInset(2, this.attributes.getTopShadowThickness(), this.attributes.getTopShadowThickness(), this.attributes.getBottomShadowThickness(), this.attributes.getBottomShadowThickness());
        return layerDrawable;
    }

    private void resizeButtonText() {
        if (getMeasuredWidth() != 0 && !this.isSmallStyle) {
            float applyDimension = TypedValue.applyDimension(2, MIN_TEXT_SIZE_SP, getResources().getDisplayMetrics());
            RectF rectF = new RectF();
            rectF.right = (this.textView.getMeasuredWidth() - this.textView.getCompoundPaddingLeft()) - this.textView.getCompoundPaddingRight();
            rectF.bottom = (this.textView.getMeasuredHeight() - this.textView.getCompoundPaddingBottom()) - this.textView.getCompoundPaddingTop();
            this.textView.setTextSize(0, findBestSize(applyDimension, MAX_TEXT_SIZE_PX, rectF));
        }
    }

    private void updateStyle() {
        if (this.isSmallStyle) {
            this.textView.setVisibility(8);
            setGravity(17);
        } else {
            this.textView.setVisibility(0);
            setGravity(16);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        int measuredHeight = (int) (getMeasuredHeight() * 0.72d);
        if (measuredHeight > this.bitmap.getHeight()) {
            measuredHeight = this.bitmap.getHeight();
        }
        layoutParams.height = measuredHeight;
        layoutParams.width = measuredHeight;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12 || i11 != i13) {
            resizeButtonText();
        }
    }

    public void setButtonText(String str) {
        this.textView.setText(str);
        resizeButtonText();
    }

    public void setSmallStyle(boolean z10) {
        this.isSmallStyle = z10;
        updateStyle();
    }

    public void setButtonText(int i10) {
        this.textView.setText(i10);
        resizeButtonText();
    }
}
