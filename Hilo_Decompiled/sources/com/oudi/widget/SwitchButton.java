package com.oudi.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SwitchButton extends View implements View.OnClickListener {
    private static final int DEF_H = 60;
    private static final int DEF_W = 120;
    private int BALL_X_RIGHT;
    private Paint mBallPaint;
    private Paint mBgPaint;
    private RectF mBgStrokeRectF;
    private State mCurrentState;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private float mSolidRadius;
    private int mStrokeRadius;
    private float mSwitchBallx;
    private int mViewHeight;
    private int mViewWidth;
    private int selectColor;
    private int switchViewBallColor;
    private int switchViewBgColor;
    private int switchViewBgDefaultColor;
    private boolean switchViewCheck;
    private float switchViewStrockWidth;
    private int unselectColor;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum State {
        OPEN,
        CLOSE
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    private void animate(int i10, int i11, int i12, int i13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i10, i11);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oudi.widget.SwitchButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchButton.this.mSwitchBallx = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SwitchButton.this.postInvalidate();
            }
        });
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i12), Integer.valueOf(i13));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oudi.widget.SwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwitchButton.this.switchViewBgColor = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwitchButton switchButton = SwitchButton.this;
                switchButton.mBgPaint.setColor(switchButton.switchViewBgColor);
                SwitchButton.this.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofObject);
        animatorSet.setDuration(200L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oudi.widget.SwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwitchButton.this.setClickable(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchButton.this.setClickable(false);
            }
        });
        animatorSet.start();
    }

    private Paint createPaint(int i10, int i11, Paint.Style style, int i12) {
        Paint paint = new Paint(1);
        paint.setColor(i10);
        paint.setStrokeWidth(i12);
        paint.setDither(true);
        paint.setTextSize(i11);
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }

    private void drawSwitchBall(Canvas canvas) {
        canvas.drawCircle(this.mSwitchBallx, this.mStrokeRadius, this.mSolidRadius, this.mBallPaint);
    }

    private void drawSwitchBg(Canvas canvas) {
        RectF rectF = this.mBgStrokeRectF;
        float f10 = this.mStrokeRadius;
        canvas.drawRoundRect(rectF, f10, f10, this.mBgPaint);
    }

    private void initData() {
        this.selectColor = this.switchViewBgColor;
        this.unselectColor = this.switchViewBgDefaultColor;
        this.mBallPaint = createPaint(this.switchViewBallColor, 0, Paint.Style.FILL, 0);
        updateStatus();
        setOnClickListener(this);
    }

    private void updateStatus() {
        if (this.switchViewCheck) {
            this.mBgPaint = createPaint(this.selectColor, 0, Paint.Style.FILL, 0);
            this.mCurrentState = State.OPEN;
        } else {
            this.mBgPaint = createPaint(this.unselectColor, 0, Paint.Style.FILL, 0);
            this.mCurrentState = State.CLOSE;
        }
    }

    public boolean getCheck() {
        if (this.mCurrentState == State.OPEN) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        State state;
        boolean z10;
        State state2 = this.mCurrentState;
        State state3 = State.CLOSE;
        if (state2 == state3) {
            state = State.OPEN;
        } else {
            state = state3;
        }
        this.mCurrentState = state;
        if (state == state3) {
            animate(this.BALL_X_RIGHT, this.mStrokeRadius, this.selectColor, this.unselectColor);
        } else {
            animate(this.mStrokeRadius, this.BALL_X_RIGHT, this.unselectColor, this.selectColor);
        }
        OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            if (this.mCurrentState == State.OPEN) {
                z10 = true;
            } else {
                z10 = false;
            }
            onCheckedChangeListener.onCheckedChanged(this, z10);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        drawSwitchBg(canvas);
        drawSwitchBall(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 120.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 60.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.mViewHeight = i11;
        this.mViewWidth = i10;
        float f10 = (i10 * 1.0f) / 30.0f;
        this.switchViewStrockWidth = f10;
        int i14 = i11 / 2;
        this.mStrokeRadius = i14;
        this.mSolidRadius = (i11 - (f10 * 2.0f)) / 2.0f;
        int i15 = i10 - i14;
        this.BALL_X_RIGHT = i15;
        if (this.mCurrentState == State.OPEN) {
            this.mSwitchBallx = i15;
        } else {
            this.mSwitchBallx = i14;
        }
        this.mBgStrokeRectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.mViewWidth, this.mViewHeight);
    }

    public void setCheck(boolean z10) {
        if (z10) {
            if (this.mCurrentState != State.OPEN) {
                this.mSwitchBallx = this.BALL_X_RIGHT;
                this.switchViewCheck = true;
                updateStatus();
                postInvalidate();
                return;
            }
            return;
        }
        if (this.mCurrentState != State.CLOSE) {
            this.mSwitchBallx = this.mStrokeRadius;
            this.switchViewCheck = false;
            updateStatus();
            postInvalidate();
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwitchButton, i10, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.SwitchButton_switch_bg_color) {
                this.switchViewBgColor = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchButton_switch_ball_color) {
                this.switchViewBallColor = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchButton_switch_check) {
                this.switchViewCheck = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.SwitchButton_switch_bg_default_color) {
                this.switchViewBgDefaultColor = obtainStyledAttributes.getColor(index, Color.parseColor("#E4E4E4"));
            }
        }
        obtainStyledAttributes.recycle();
        initData();
    }
}
