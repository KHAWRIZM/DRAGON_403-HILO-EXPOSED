package com.luck.picture.lib.magical;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.viewpager2.widget.ViewPager2;
import com.luck.picture.lib.basic.InterpolatorFactory;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.DensityUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MagicalView extends FrameLayout {
    private final long animationDuration;
    private final int appInScreenHeight;
    private final View backgroundView;
    private final FrameLayout contentLayout;
    private boolean isAnimating;
    private final boolean isPreviewFullScreenMode;
    private float mAlpha;
    private int mOriginHeight;
    private int mOriginLeft;
    private int mOriginTop;
    private int mOriginWidth;
    private final MagicalViewWrapper magicalWrapper;
    private OnMagicalViewCallback onMagicalViewCallback;
    private int realHeight;
    private int realWidth;
    private int screenHeight;
    private int screenWidth;
    private final SelectorConfig selectorConfig;
    private int startX;
    private int startY;
    private int targetEndLeft;
    private int targetImageHeight;
    private int targetImageTop;
    private int targetImageWidth;

    public MagicalView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = 21)
    private void backToMinWithTransition() {
        this.contentLayout.post(new Runnable() { // from class: com.luck.picture.lib.magical.MagicalView.3
            @Override // java.lang.Runnable
            public void run() {
                TransitionManager.beginDelayedTransition((ViewGroup) MagicalView.this.contentLayout.getParent(), new TransitionSet().setDuration(250L).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()));
                MagicalView.this.beginBackToMin(true);
                MagicalView.this.contentLayout.setTranslationX(DownloadProgress.UNKNOWN_PROGRESS);
                MagicalView.this.contentLayout.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
                MagicalView.this.magicalWrapper.setWidth(MagicalView.this.mOriginWidth);
                MagicalView.this.magicalWrapper.setHeight(MagicalView.this.mOriginHeight);
                MagicalView.this.magicalWrapper.setMarginTop(MagicalView.this.mOriginTop);
                MagicalView.this.magicalWrapper.setMarginLeft(MagicalView.this.mOriginLeft);
                MagicalView.this.changeBackgroundViewAlpha(true);
            }
        });
    }

    private void backToMinWithoutView() {
        this.contentLayout.animate().alpha(DownloadProgress.UNKNOWN_PROGRESS).setDuration(250L).setListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
                }
            }
        }).start();
        this.backgroundView.animate().alpha(DownloadProgress.UNKNOWN_PROGRESS).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginBackToMin(boolean z10) {
        if (z10) {
            this.onMagicalViewCallback.onBeginBackMinMagicalFinish(true);
        }
    }

    private void beginShow(boolean z10) {
        Interpolator newInterpolator;
        if (z10) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
            showNormalMin(this.targetImageTop, this.targetEndLeft, this.targetImageWidth, this.targetImageHeight);
            setShowEndParams();
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.picture.lib.magical.MagicalView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.showNormalMin(floatValue, r0.mOriginTop, MagicalView.this.targetImageTop, MagicalView.this.mOriginLeft, MagicalView.this.targetEndLeft, MagicalView.this.mOriginWidth, MagicalView.this.targetImageWidth, MagicalView.this.mOriginHeight, MagicalView.this.targetImageHeight);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.setShowEndParams();
            }
        });
        InterpolatorFactory interpolatorFactory = this.selectorConfig.interpolatorFactory;
        if (interpolatorFactory != null && (newInterpolator = interpolatorFactory.newInterpolator()) != null) {
            ofFloat.setInterpolator(newInterpolator);
        }
        ofFloat.setDuration(250L).start();
        changeBackgroundViewAlpha(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBackgroundViewAlpha(final boolean z10) {
        float f10;
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mAlpha, f10);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.picture.lib.magical.MagicalView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicalView.this.isAnimating = true;
                MagicalView.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.backgroundView.setAlpha(MagicalView.this.mAlpha);
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onBackgroundAlpha(MagicalView.this.mAlpha);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.isAnimating = false;
                if (z10 && MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
                }
            }
        });
        ofFloat.setDuration(250L);
        ofFloat.start();
    }

    private void changeContentViewToFullscreen() {
        int i10 = this.screenHeight;
        this.targetImageHeight = i10;
        this.targetImageWidth = this.screenWidth;
        this.targetImageTop = 0;
        this.magicalWrapper.setHeight(i10);
        this.magicalWrapper.setWidth(this.screenWidth);
        this.magicalWrapper.setMarginTop(0);
        this.magicalWrapper.setMarginLeft(0);
    }

    private void getScreenSize() {
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        if (this.isPreviewFullScreenMode) {
            this.screenHeight = DensityUtil.getRealScreenHeight(getContext());
        } else {
            this.screenHeight = DensityUtil.getScreenHeight(getContext());
        }
    }

    private void setOriginParams() {
        this.contentLayout.getLocationOnScreen(new int[2]);
        this.targetEndLeft = 0;
        int i10 = this.screenWidth;
        int i11 = this.screenHeight;
        float f10 = i10 / i11;
        int i12 = this.realWidth;
        int i13 = this.realHeight;
        if (f10 < i12 / i13) {
            this.targetImageWidth = i10;
            int i14 = (int) (i10 * (i13 / i12));
            this.targetImageHeight = i14;
            this.targetImageTop = (i11 - i14) / 2;
        } else {
            this.targetImageHeight = i11;
            int i15 = (int) (i11 * (i12 / i13));
            this.targetImageWidth = i15;
            this.targetImageTop = 0;
            this.targetEndLeft = (i10 - i15) / 2;
        }
        this.magicalWrapper.setWidth(this.mOriginWidth);
        this.magicalWrapper.setHeight(this.mOriginHeight);
        this.magicalWrapper.setMarginLeft(this.mOriginLeft);
        this.magicalWrapper.setMarginTop(this.mOriginTop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowEndParams() {
        this.isAnimating = false;
        changeContentViewToFullscreen();
        OnMagicalViewCallback onMagicalViewCallback = this.onMagicalViewCallback;
        if (onMagicalViewCallback != null) {
            onMagicalViewCallback.onBeginMagicalAnimComplete(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalMin(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        showNormalMin(false, f10, f11, f12, f13, f14, f15, f16, f17, f18);
    }

    public void backToMin() {
        if (this.isAnimating) {
            return;
        }
        if (this.mOriginWidth != 0 && this.mOriginHeight != 0) {
            OnMagicalViewCallback onMagicalViewCallback = this.onMagicalViewCallback;
            if (onMagicalViewCallback != null) {
                onMagicalViewCallback.onBeginBackMinAnim();
            }
            beginBackToMin(false);
            backToMinWithTransition();
            return;
        }
        backToMinWithoutView();
    }

    public void changeRealScreenHeight(int i10, int i11, boolean z10) {
        int i12;
        int i13;
        if (!this.isPreviewFullScreenMode && (i12 = this.screenWidth) <= (i13 = this.screenHeight)) {
            if (((int) (i12 / (i10 / i11))) > i13) {
                this.screenHeight = this.appInScreenHeight;
                if (z10) {
                    this.magicalWrapper.setWidth(i12);
                    this.magicalWrapper.setHeight(this.screenHeight);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r1 != 3) goto L٢٥;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewPager2 viewPager2;
        View childAt = this.contentLayout.getChildAt(0);
        if (childAt instanceof ViewPager2) {
            viewPager2 = (ViewPager2) childAt;
        } else {
            viewPager2 = null;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int x10 = (int) motionEvent.getX();
                    int y10 = (int) motionEvent.getY();
                    if (Math.abs(x10 - this.startX) > Math.abs(y10 - this.startY)) {
                        if (viewPager2 != null) {
                            viewPager2.setUserInputEnabled(true);
                        }
                    } else if (viewPager2 != null) {
                        viewPager2.setUserInputEnabled(canScrollVertically(this.startY - y10));
                    }
                }
            }
            if (viewPager2 != null) {
                viewPager2.setUserInputEnabled(true);
            }
        } else {
            this.startX = (int) motionEvent.getX();
            this.startY = (int) motionEvent.getY();
            if (viewPager2 != null) {
                viewPager2.setUserInputEnabled(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void resetStart() {
        getScreenSize();
        start(true);
    }

    public void resetStartNormal(int i10, int i11, boolean z10) {
        getScreenSize();
        startNormal(i10, i11, z10);
    }

    public void setBackgroundAlpha(float f10) {
        this.mAlpha = f10;
        this.backgroundView.setAlpha(f10);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.backgroundView.setBackgroundColor(i10);
    }

    public void setMagicalContent(View view) {
        this.contentLayout.addView(view);
    }

    public void setOnMojitoViewCallback(OnMagicalViewCallback onMagicalViewCallback) {
        this.onMagicalViewCallback = onMagicalViewCallback;
    }

    public void setViewParams(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.realWidth = i14;
        this.realHeight = i15;
        this.mOriginLeft = i10;
        this.mOriginTop = i11;
        this.mOriginWidth = i12;
        this.mOriginHeight = i13;
    }

    public void start(boolean z10) {
        float f10;
        if (z10) {
            f10 = 1.0f;
            this.mAlpha = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.mAlpha = f10;
        this.backgroundView.setAlpha(f10);
        setVisibility(0);
        setOriginParams();
        beginShow(z10);
    }

    public void startNormal(int i10, int i11, boolean z10) {
        this.realWidth = i10;
        this.realHeight = i11;
        this.mOriginLeft = 0;
        this.mOriginTop = 0;
        this.mOriginWidth = 0;
        this.mOriginHeight = 0;
        setVisibility(0);
        setOriginParams();
        showNormalMin(this.targetImageTop, this.targetEndLeft, this.targetImageWidth, this.targetImageHeight);
        if (z10) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
        } else {
            this.mAlpha = DownloadProgress.UNKNOWN_PROGRESS;
            this.backgroundView.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            this.contentLayout.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            this.contentLayout.animate().alpha(1.0f).setDuration(250L).start();
            this.backgroundView.animate().alpha(1.0f).setDuration(250L).start();
        }
        setShowEndParams();
    }

    public MagicalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void showNormalMin(float f10, float f11, float f12, float f13) {
        showNormalMin(true, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, DownloadProgress.UNKNOWN_PROGRESS, f11, DownloadProgress.UNKNOWN_PROGRESS, f12, DownloadProgress.UNKNOWN_PROGRESS, f13);
    }

    public MagicalView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAlpha = DownloadProgress.UNKNOWN_PROGRESS;
        this.animationDuration = 250L;
        this.isAnimating = false;
        SelectorConfig selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        this.selectorConfig = selectorConfig;
        this.isPreviewFullScreenMode = selectorConfig.isPreviewFullScreenMode;
        this.appInScreenHeight = DensityUtil.getRealScreenHeight(getContext());
        getScreenSize();
        View view = new View(context);
        this.backgroundView = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setAlpha(this.mAlpha);
        addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        this.contentLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.magicalWrapper = new MagicalViewWrapper(frameLayout);
    }

    private void showNormalMin(boolean z10, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        if (z10) {
            this.magicalWrapper.setWidth(f16);
            this.magicalWrapper.setHeight(f18);
            this.magicalWrapper.setMarginLeft((int) f14);
            this.magicalWrapper.setMarginTop((int) f12);
            return;
        }
        float f19 = (f14 - f13) * f10;
        float f20 = (f16 - f15) * f10;
        float f21 = (f18 - f17) * f10;
        this.magicalWrapper.setWidth(f15 + f20);
        this.magicalWrapper.setHeight(f17 + f21);
        this.magicalWrapper.setMarginLeft((int) (f13 + f19));
        this.magicalWrapper.setMarginTop((int) (f11 + (f10 * (f12 - f11))));
    }
}
