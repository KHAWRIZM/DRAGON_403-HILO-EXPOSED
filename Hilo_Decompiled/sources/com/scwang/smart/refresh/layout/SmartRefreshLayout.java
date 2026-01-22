package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.d1;
import androidx.core.view.e0;
import androidx.core.view.h0;
import androidx.core.view.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.kernel.R;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;
import com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;

@SuppressLint({"RestrictedApi"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SmartRefreshLayout extends ViewGroup implements tc.f, h0 {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static vc.b sFooterCreator;
    protected static vc.c sHeaderCreator;
    protected static vc.d sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableDisallowIntercept;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected uc.a mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected uc.a mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected tc.e mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected long mLastTimeOnActionDown;
    protected float mLastTouchX;
    protected float mLastTouchXOnActionDown;
    protected float mLastTouchY;
    protected float mLastTouchYOnActionDown;
    protected vc.e mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected e0 mNestedChild;
    protected boolean mNestedInProgress;
    protected i0 mNestedParent;
    protected vc.f mOnMultiListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected tc.b mRefreshContent;
    protected tc.a mRefreshFooter;
    protected tc.a mRefreshHeader;
    protected vc.g mRefreshListener;
    protected int mScreenHeightPixels;
    protected vc.j mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected uc.b mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected float mTwoLevelBottomPullUpToCloseRate;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected uc.b mViceState;
    protected ValueAnimator reboundAnimator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout.this.setStateDirectLoading(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
            SmartRefreshLayout.this.notifyStateChanged(uc.b.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            vc.g gVar = smartRefreshLayout.mRefreshListener;
            if (gVar != null) {
                if (this.a) {
                    gVar.onRefresh(smartRefreshLayout);
                }
            } else {
                smartRefreshLayout.getClass();
                SmartRefreshLayout.this.finishRefresh(HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            tc.a aVar = smartRefreshLayout2.mRefreshHeader;
            if (aVar != null) {
                float f = smartRefreshLayout2.mHeaderMaxDragRate;
                if (f < 10.0f) {
                    f *= smartRefreshLayout2.mHeaderHeight;
                }
                aVar.onStartAnimator(smartRefreshLayout2, smartRefreshLayout2.mHeaderHeight, (int) f);
            }
            SmartRefreshLayout.this.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            uc.b bVar;
            uc.b bVar2;
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mSpinner == 0 && (bVar = smartRefreshLayout.mState) != (bVar2 = uc.b.None) && !bVar.e && !bVar.d) {
                smartRefreshLayout.notifyStateChanged(bVar2);
                return;
            }
            uc.b bVar3 = smartRefreshLayout.mState;
            if (bVar3 != smartRefreshLayout.mViceState) {
                smartRefreshLayout.setViceState(bVar3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class d implements Runnable {
        int a = 0;
        final /* synthetic */ int b;
        final /* synthetic */ Boolean c;
        final /* synthetic */ boolean d;

        d(int i, Boolean bool, boolean z) {
            this.b = i;
            this.c = bool;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2 = this.a;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (i2 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                uc.b bVar = smartRefreshLayout.mState;
                uc.b bVar2 = uc.b.None;
                if (bVar == bVar2 && smartRefreshLayout.mViceState == uc.b.Refreshing) {
                    smartRefreshLayout.mViceState = bVar2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && bVar.a && (bVar.d || bVar == uc.b.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.reboundAnimator = null;
                        if (smartRefreshLayout2.mKernel.b(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(bVar2);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(uc.b.PullDownCanceled);
                        }
                    } else if (bVar == uc.b.Refreshing) {
                        this.a = i2 + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, this.b);
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.RefreshFinish);
                        if (this.c == Boolean.FALSE) {
                            SmartRefreshLayout.this.setNoMoreData(false);
                        }
                    }
                }
                if (this.c == Boolean.TRUE) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            tc.a aVar = smartRefreshLayout3.mRefreshHeader;
            if (aVar != null) {
                i = aVar.onFinish(smartRefreshLayout3, this.d);
                SmartRefreshLayout.this.getClass();
            } else {
                i = 0;
            }
            if (i < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.mIsBeingDragged || smartRefreshLayout4.mNestedInProgress) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mIsBeingDragged) {
                        float f = smartRefreshLayout5.mLastTouchY;
                        smartRefreshLayout5.mTouchY = f;
                        smartRefreshLayout5.mTouchSpinner = 0;
                        smartRefreshLayout5.mIsBeingDragged = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout5.mLastTouchX, (f + smartRefreshLayout5.mSpinner) - (smartRefreshLayout5.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout6.mLastTouchX, smartRefreshLayout6.mLastTouchY + smartRefreshLayout6.mSpinner, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mNestedInProgress) {
                        smartRefreshLayout7.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        smartRefreshLayout8.mNestedInProgress = false;
                        smartRefreshLayout8.mTouchSpinner = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i3 = smartRefreshLayout9.mSpinner;
                if (i3 > 0) {
                    ValueAnimator animSpinner = smartRefreshLayout9.animSpinner(0, i, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (smartRefreshLayout10.mEnableScrollContentWhenRefreshed) {
                        animatorUpdateListener = smartRefreshLayout10.mRefreshContent.e(smartRefreshLayout10.mSpinner);
                    }
                    if (animSpinner != null && animatorUpdateListener != null) {
                        animSpinner.addUpdateListener(animatorUpdateListener);
                        return;
                    }
                    return;
                }
                if (i3 < 0) {
                    smartRefreshLayout9.animSpinner(0, i, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                } else {
                    smartRefreshLayout9.mKernel.e(0, false);
                    SmartRefreshLayout.this.mKernel.d(uc.b.None);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class e implements Runnable {
        int a = 0;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class a extends AnimatorListenerAdapter {
            final /* synthetic */ boolean a;

            a(boolean z) {
                this.a = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.mFooterLocked = false;
                if (this.a) {
                    smartRefreshLayout.setNoMoreData(true);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.mState == uc.b.LoadFinish) {
                    smartRefreshLayout2.notifyStateChanged(uc.b.None);
                }
            }
        }

        e(int i, boolean z, boolean z2) {
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i, boolean z) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
            ValueAnimator valueAnimator;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mEnableScrollContentWhenLoaded && i < 0) {
                animatorUpdateListener = smartRefreshLayout.mRefreshContent.e(smartRefreshLayout.mSpinner);
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
            } else {
                animatorUpdateListener = null;
            }
            a aVar = new a(z);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i2 = smartRefreshLayout2.mSpinner;
            if (i2 > 0) {
                valueAnimator = smartRefreshLayout2.mKernel.b(0);
            } else {
                if (animatorUpdateListener == null && i2 != 0) {
                    if (z && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData) {
                        int i3 = smartRefreshLayout2.mFooterHeight;
                        if (i2 >= (-i3)) {
                            smartRefreshLayout2.notifyStateChanged(uc.b.None);
                        } else {
                            valueAnimator = smartRefreshLayout2.mKernel.b(-i3);
                        }
                    } else {
                        valueAnimator = smartRefreshLayout2.mKernel.b(0);
                    }
                } else {
                    ValueAnimator valueAnimator2 = smartRefreshLayout2.reboundAnimator;
                    if (valueAnimator2 != null) {
                        valueAnimator2.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout.this.reboundAnimator = null;
                    }
                    SmartRefreshLayout.this.mKernel.e(0, false);
                    SmartRefreshLayout.this.mKernel.d(uc.b.None);
                }
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.addListener(aVar);
            } else {
                aVar.onAnimationEnd(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
        
            if (r6.mRefreshContent.i() != false) goto L٤٤;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            int i3 = this.a;
            long j = 0;
            boolean z = true;
            if (i3 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                uc.b bVar = smartRefreshLayout.mState;
                uc.b bVar2 = uc.b.None;
                if (bVar == bVar2 && smartRefreshLayout.mViceState == uc.b.Loading) {
                    smartRefreshLayout.mViceState = bVar2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && ((bVar.d || bVar == uc.b.LoadReleased) && bVar.b)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.reboundAnimator = null;
                        if (smartRefreshLayout2.mKernel.b(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(bVar2);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(uc.b.PullUpCanceled);
                        }
                    } else if (bVar == uc.b.Loading && smartRefreshLayout.mRefreshFooter != null && smartRefreshLayout.mRefreshContent != null) {
                        this.a = i3 + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, this.b);
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.LoadFinish);
                        return;
                    }
                }
                if (this.c) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int onFinish = smartRefreshLayout3.mRefreshFooter.onFinish(smartRefreshLayout3, this.d);
            SmartRefreshLayout.this.getClass();
            if (onFinish < Integer.MAX_VALUE) {
                if (this.c) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData) {
                        if (smartRefreshLayout4.mSpinner < 0) {
                        }
                    }
                }
                z = false;
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout5.mSpinner;
                if (z) {
                    i = Math.max(i4, -smartRefreshLayout5.mFooterHeight);
                } else {
                    i = 0;
                }
                final int i5 = i4 - i;
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                if (smartRefreshLayout6.mIsBeingDragged || smartRefreshLayout6.mNestedInProgress) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mIsBeingDragged) {
                        float f = smartRefreshLayout7.mLastTouchY;
                        smartRefreshLayout7.mTouchY = f;
                        smartRefreshLayout7.mTouchSpinner = smartRefreshLayout7.mSpinner - i5;
                        smartRefreshLayout7.mIsBeingDragged = false;
                        if (smartRefreshLayout7.mEnableFooterTranslationContent) {
                            i2 = i5;
                        } else {
                            i2 = 0;
                        }
                        float f2 = i2;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout7.mLastTouchX, f + f2 + (smartRefreshLayout7.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY + f2, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.mNestedInProgress) {
                        smartRefreshLayout9.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        smartRefreshLayout10.mNestedInProgress = false;
                        smartRefreshLayout10.mTouchSpinner = 0;
                    }
                }
                Handler handler = SmartRefreshLayout.this.mHandler;
                final boolean z2 = this.c;
                Runnable runnable = new Runnable() { // from class: com.scwang.smart.refresh.layout.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmartRefreshLayout.e.this.b(i5, z2);
                    }
                };
                if (SmartRefreshLayout.this.mSpinner < 0) {
                    j = onFinish;
                }
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class f extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        f(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.mKernel.c(animator, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class g extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        g(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.mKernel.g(animator, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class h {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[uc.b.values().length];
            a = iArr;
            try {
                iArr[uc.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[uc.b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[uc.b.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[uc.b.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[uc.b.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[uc.b.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[uc.b.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[uc.b.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[uc.b.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[uc.b.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[uc.b.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[uc.b.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class i implements Runnable {
        int c;
        float f;
        int a = 0;
        int b = 10;
        float e = 0.0f;
        long d = AnimationUtils.currentAnimationTimeMillis();

        i(float f, int i) {
            this.f = f;
            this.c = i;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.b);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.d(uc.b.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.d(uc.b.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.f) {
                if (Math.abs(smartRefreshLayout.mSpinner) >= Math.abs(this.c)) {
                    if (this.c != 0) {
                        double d = this.f;
                        this.a = this.a + 1;
                        this.f = (float) (d * Math.pow(0.44999998807907104d, r2 * 2));
                    } else {
                        double d2 = this.f;
                        this.a = this.a + 1;
                        this.f = (float) (d2 * Math.pow(0.8500000238418579d, r2 * 2));
                    }
                } else {
                    double d3 = this.f;
                    this.a = this.a + 1;
                    this.f = (float) (d3 * Math.pow(0.949999988079071d, r2 * 2));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.f * ((((float) (currentAnimationTimeMillis - this.d)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.d = currentAnimationTimeMillis;
                    float f2 = this.e + f;
                    this.e = f2;
                    SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                    SmartRefreshLayout.this.mHandler.postDelayed(this, this.b);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                uc.b bVar = smartRefreshLayout2.mViceState;
                boolean z = bVar.d;
                if (z && bVar.a) {
                    smartRefreshLayout2.mKernel.d(uc.b.PullDownCanceled);
                } else if (z && bVar.b) {
                    smartRefreshLayout2.mKernel.d(uc.b.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.animationRunnable = null;
                if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.c)) {
                    int min = Math.min(Math.max((int) wc.c.i(Math.abs(SmartRefreshLayout.this.mSpinner - this.c)), 30), 100) * 10;
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.animSpinner(this.c, 0, smartRefreshLayout4.mReboundInterpolator, min);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class j implements Runnable {
        int a;
        float d;
        int b = 0;
        int c = 10;
        float e = 0.98f;
        long f = 0;
        long g = AnimationUtils.currentAnimationTimeMillis();

        j(float f) {
            this.d = f;
            this.a = SmartRefreshLayout.this.mSpinner;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
        
            if (r0.mSpinner > r0.mHeaderHeight) goto L٣٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0049, code lost:
        
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L٢٩;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Runnable a() {
            uc.b bVar;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            uc.b bVar2 = smartRefreshLayout.mState;
            if (bVar2.f) {
                return null;
            }
            if (smartRefreshLayout.mSpinner != 0) {
                if (bVar2.e || (smartRefreshLayout.mFooterNoMoreData && smartRefreshLayout.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout.mFooterNoMoreDataEffective && smartRefreshLayout.isEnableRefreshOrLoadMore(smartRefreshLayout.mEnableLoadMore))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState == uc.b.Loading || (smartRefreshLayout2.mFooterNoMoreData && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout2.mFooterNoMoreDataEffective && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mState == uc.b.Refreshing) {
                    }
                }
                int i = SmartRefreshLayout.this.mSpinner;
                float f = this.d;
                int i2 = 0;
                int i3 = i;
                while (true) {
                    if (i * i3 <= 0) {
                        break;
                    }
                    i2++;
                    f = (float) (f * Math.pow(this.e, (this.c * i2) / 10.0f));
                    float f2 = ((this.c * 1.0f) / 1000.0f) * f;
                    if (Math.abs(f2) < 1.0f) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        uc.b bVar3 = smartRefreshLayout5.mState;
                        if (!bVar3.e || ((bVar3 == (bVar = uc.b.Refreshing) && i3 > smartRefreshLayout5.mHeaderHeight) || (bVar3 != bVar && i3 < (-smartRefreshLayout5.mFooterHeight)))) {
                            return null;
                        }
                    } else {
                        i3 = (int) (i3 + f2);
                    }
                }
            }
            this.f = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.c);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.f) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j = currentAnimationTimeMillis - this.g;
                float pow = (float) (this.d * Math.pow(this.e, ((float) (currentAnimationTimeMillis - this.f)) / (1000.0f / this.c)));
                this.d = pow;
                float f = pow * ((((float) j) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.g = currentAnimationTimeMillis;
                    int i = (int) (this.a + f);
                    this.a = i;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mSpinner * i > 0) {
                        smartRefreshLayout2.mKernel.e(i, true);
                        SmartRefreshLayout.this.mHandler.postDelayed(this, this.c);
                        return;
                    }
                    smartRefreshLayout2.animationRunnable = null;
                    smartRefreshLayout2.mKernel.e(0, true);
                    wc.c.d(SmartRefreshLayout.this.mRefreshContent.f(), (int) (-this.d));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.mFooterLocked && f > 0.0f) {
                        smartRefreshLayout3.mFooterLocked = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.animationRunnable = null;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class l implements tc.e {
        public l() {
        }

        @Override // tc.e
        public tc.e a() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == uc.b.TwoLevel) {
                smartRefreshLayout.mKernel.d(uc.b.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    e(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(uc.b.None);
                } else {
                    b(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // tc.e
        public ValueAnimator b(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // tc.e
        public tc.e c(Animator animator, boolean z) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            uc.b bVar = smartRefreshLayout.mState;
            uc.b bVar2 = uc.b.ReleaseToRefresh;
            if (bVar != bVar2) {
                d(bVar2);
            }
            SmartRefreshLayout.this.setStateRefreshing(!z);
            return this;
        }

        @Override // tc.e
        public tc.e d(uc.b bVar) {
            switch (h.a[bVar.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    uc.b bVar2 = smartRefreshLayout.mState;
                    uc.b bVar3 = uc.b.None;
                    if (bVar2 != bVar3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(bVar3);
                        return null;
                    }
                    if (smartRefreshLayout.mSpinner != 0) {
                        b(0);
                        return null;
                    }
                    return null;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.e && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        uc.b bVar4 = smartRefreshLayout4.mState;
                        if (!bVar4.e && !bVar4.f && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(uc.b.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.e && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.PullDownCanceled);
                        d(uc.b.None);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.e && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(uc.b.PullUpCanceled);
                            d(uc.b.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.e && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        uc.b bVar5 = smartRefreshLayout10.mState;
                        if (!bVar5.e && !bVar5.f && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(uc.b.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.e && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.e && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.e && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(uc.b.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(uc.b.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                default:
                    SmartRefreshLayout.this.notifyStateChanged(bVar);
                    return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
        
            if (r9 > 0) goto L٥٥;
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
        @Override // tc.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public tc.e e(int i, boolean z) {
            int i2;
            boolean z2;
            tc.a aVar;
            tc.a aVar2;
            tc.a aVar3;
            tc.a aVar4;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mSpinner == i && (((aVar3 = smartRefreshLayout.mRefreshHeader) == null || !aVar3.isSupportHorizontalDrag()) && ((aVar4 = SmartRefreshLayout.this.mRefreshFooter) == null || !aVar4.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout2.mSpinner;
            smartRefreshLayout2.mSpinner = i;
            if (z) {
                uc.b bVar = smartRefreshLayout2.mViceState;
                if (bVar.d || bVar.e) {
                    float f = i;
                    float f2 = smartRefreshLayout2.mHeaderTriggerRate;
                    if (f2 < 10.0f) {
                        f2 *= smartRefreshLayout2.mHeaderHeight;
                    }
                    if (f > f2) {
                        if (smartRefreshLayout2.mState != uc.b.ReleaseToTwoLevel) {
                            smartRefreshLayout2.mKernel.d(uc.b.ReleaseToRefresh);
                        }
                    } else {
                        float f3 = -i;
                        float f4 = smartRefreshLayout2.mFooterTriggerRate;
                        if (f4 < 10.0f) {
                            f4 *= smartRefreshLayout2.mFooterHeight;
                        }
                        if (f3 > f4 && !smartRefreshLayout2.mFooterNoMoreData) {
                            smartRefreshLayout2.mKernel.d(uc.b.ReleaseToLoad);
                        } else if (i < 0 && !smartRefreshLayout2.mFooterNoMoreData) {
                            smartRefreshLayout2.mKernel.d(uc.b.PullUpToLoad);
                        } else if (i > 0) {
                            smartRefreshLayout2.mKernel.d(uc.b.PullDownToRefresh);
                        }
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (smartRefreshLayout3.mRefreshContent != null) {
                if (i >= 0) {
                    if (smartRefreshLayout3.isEnableTranslationContent(smartRefreshLayout3.mEnableHeaderTranslationContent, smartRefreshLayout3.mRefreshHeader)) {
                        i2 = i;
                    } else if (i3 < 0) {
                        i2 = 0;
                    }
                    z2 = true;
                    if (i <= 0) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.isEnableTranslationContent(smartRefreshLayout4.mEnableFooterTranslationContent, smartRefreshLayout4.mRefreshFooter)) {
                            i2 = i;
                        }
                        z2 = true;
                    }
                    if (z2) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.mRefreshContent.h(i2, smartRefreshLayout5.mHeaderTranslationViewId, smartRefreshLayout5.mFooterTranslationViewId);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.mFooterNoMoreData && smartRefreshLayout6.mFooterNoMoreDataEffective && smartRefreshLayout6.mEnableFooterFollowWhenNoMoreData) {
                            tc.a aVar5 = smartRefreshLayout6.mRefreshFooter;
                            if ((aVar5 instanceof tc.c) && aVar5.getSpinnerStyle() == uc.c.d) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableLoadMore)) {
                                    SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(Math.max(0, i2));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z3 = (smartRefreshLayout8.mEnableClipHeaderWhenFixedBehind && (aVar2 = smartRefreshLayout8.mRefreshHeader) != null && aVar2.getSpinnerStyle() == uc.c.f) || SmartRefreshLayout.this.mHeaderBackgroundColor != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z4 = (smartRefreshLayout9.mEnableClipFooterWhenFixedBehind && (aVar = smartRefreshLayout9.mRefreshFooter) != null && aVar.getSpinnerStyle() == uc.c.f) || SmartRefreshLayout.this.mFooterBackgroundColor != 0;
                        if ((z3 && (i2 >= 0 || i3 > 0)) || (z4 && (i2 <= 0 || i3 < 0))) {
                            smartRefreshLayout2.invalidate();
                        }
                    }
                }
                i2 = 0;
                z2 = false;
                if (i <= 0) {
                }
                if (z2) {
                }
            }
            if ((i >= 0 || i3 > 0) && SmartRefreshLayout.this.mRefreshHeader != null) {
                int max = Math.max(i, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout10.mHeaderHeight;
                float f5 = smartRefreshLayout10.mHeaderMaxDragRate;
                if (f5 < 10.0f) {
                    f5 *= i4;
                }
                int i5 = (int) f5;
                float f6 = max * 1.0f;
                float f7 = smartRefreshLayout10.mHeaderTriggerRate;
                if (f7 < 10.0f) {
                    f7 *= i4;
                }
                float f8 = f6 / f7;
                if (smartRefreshLayout10.isEnableRefreshOrLoadMore(smartRefreshLayout10.mEnableRefresh) || (SmartRefreshLayout.this.mState == uc.b.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout11.mSpinner) {
                        if (smartRefreshLayout11.mRefreshHeader.getSpinnerStyle() == uc.c.d) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (smartRefreshLayout12.mHeaderBackgroundColor != 0 && smartRefreshLayout12.mPaint != null && !smartRefreshLayout12.isEnableTranslationContent(smartRefreshLayout12.mEnableHeaderTranslationContent, smartRefreshLayout12.mRefreshHeader)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle().c) {
                            View view = SmartRefreshLayout.this.mRefreshHeader.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.sDefaultMarginLP;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.mSpinner - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i6 = marginLayoutParams.leftMargin;
                            int i7 = marginLayoutParams.topMargin + SmartRefreshLayout.this.mHeaderInsetStart;
                            view.layout(i6, i7, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + i7);
                        }
                        SmartRefreshLayout.this.mRefreshHeader.onMoving(z, f8, max, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                        int i8 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.mRefreshHeader.onHorizontalDrag(smartRefreshLayout13.mLastTouchX / (width == 0 ? 1 : width), i8, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout14.mSpinner) {
                    smartRefreshLayout14.getClass();
                }
            }
            if ((i <= 0 || i3 < 0) && SmartRefreshLayout.this.mRefreshFooter != null) {
                int i9 = -Math.min(i, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i10 = smartRefreshLayout15.mFooterHeight;
                float f9 = smartRefreshLayout15.mFooterMaxDragRate;
                if (f9 < 10.0f) {
                    f9 *= i10;
                }
                int i11 = (int) f9;
                float f10 = i9 * 1.0f;
                float f11 = smartRefreshLayout15.mFooterTriggerRate;
                if (f11 < 10.0f) {
                    f11 *= i10;
                }
                float f12 = f10 / f11;
                if (smartRefreshLayout15.isEnableRefreshOrLoadMore(smartRefreshLayout15.mEnableLoadMore) || (SmartRefreshLayout.this.mState == uc.b.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout16.mSpinner) {
                        if (smartRefreshLayout16.mRefreshFooter.getSpinnerStyle() == uc.c.d) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (smartRefreshLayout17.mFooterBackgroundColor != 0 && smartRefreshLayout17.mPaint != null && !smartRefreshLayout17.isEnableTranslationContent(smartRefreshLayout17.mEnableFooterTranslationContent, smartRefreshLayout17.mRefreshFooter)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle().c) {
                            View view2 = SmartRefreshLayout.this.mRefreshFooter.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.sDefaultMarginLP;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.mSpinner) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i12 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout2.getMeasuredHeight()) - SmartRefreshLayout.this.mFooterInsetStart;
                            view2.layout(i12, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i12, measuredHeight);
                        }
                        SmartRefreshLayout.this.mRefreshFooter.onMoving(z, f12, i9, i10, i11);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                        int i13 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width2 = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        smartRefreshLayout18.mRefreshFooter.onHorizontalDrag(smartRefreshLayout18.mLastTouchX / (width2 == 0 ? 1 : width2), i13, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout19.mSpinner) {
                    smartRefreshLayout19.getClass();
                }
            }
            return this;
        }

        @Override // tc.e
        public tc.e f(tc.a aVar, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (aVar.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (aVar.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        @Override // tc.e
        public tc.e g(Animator animator, boolean z) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mRefreshFooter != null) {
                uc.b bVar = smartRefreshLayout.mState;
                uc.b bVar2 = uc.b.ReleaseToLoad;
                if (bVar != bVar2) {
                    d(bVar2);
                }
                SmartRefreshLayout.this.setStateLoading(!z);
            } else {
                d(uc.b.None);
            }
            return this;
        }

        @Override // tc.e
        public tc.e h(tc.a aVar, boolean z) {
            if (aVar.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.mManualHeaderTranslationContent) {
                    smartRefreshLayout.mManualHeaderTranslationContent = true;
                    smartRefreshLayout.mEnableHeaderTranslationContent = z;
                }
            } else if (aVar.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.mManualFooterTranslationContent) {
                    smartRefreshLayout2.mManualFooterTranslationContent = true;
                    smartRefreshLayout2.mEnableFooterTranslationContent = z;
                }
            }
            return this;
        }

        @Override // tc.e
        public tc.f i() {
            return SmartRefreshLayout.this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ValueAnimator valueAnimator) {
        this.mKernel.e(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        if (this.reboundAnimator != null && this.mRefreshFooter != null) {
            this.mKernel.e(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i2, float f2, boolean z) {
        float f3;
        if (this.mViceState != uc.b.Loading) {
            return;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
        this.mKernel.d(uc.b.PullUpToLoad);
        tc.a aVar = this.mRefreshFooter;
        if (aVar != null && aVar.autoOpen(i2, f2, z)) {
            return;
        }
        int i3 = this.mFooterHeight;
        if (i3 == 0) {
            f3 = this.mFooterTriggerRate;
        } else {
            f3 = i3;
        }
        if (f2 < 10.0f) {
            f2 *= f3;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, -((int) f2));
        this.reboundAnimator = ofInt;
        ofInt.setDuration(i2);
        this.reboundAnimator.setInterpolator(new wc.c(wc.c.b));
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smart.refresh.layout.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SmartRefreshLayout.this.h(valueAnimator2);
            }
        });
        this.reboundAnimator.addListener(new g(z));
        this.reboundAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        if (this.reboundAnimator != null) {
            this.mKernel.e(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i2, float f2, boolean z) {
        float f3;
        if (this.mViceState != uc.b.Refreshing) {
            return;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
        this.mKernel.d(uc.b.PullDownToRefresh);
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null && aVar.autoOpen(i2, f2, z)) {
            return;
        }
        int i3 = this.mHeaderHeight;
        if (i3 == 0) {
            f3 = this.mHeaderTriggerRate;
        } else {
            f3 = i3;
        }
        if (f2 < 10.0f) {
            f2 *= f3;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, (int) f2);
        this.reboundAnimator = ofInt;
        ofInt.setDuration(i2);
        this.reboundAnimator.setInterpolator(new wc.c(wc.c.b));
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smart.refresh.layout.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SmartRefreshLayout.this.j(valueAnimator2);
            }
        });
        this.reboundAnimator.addListener(new f(z));
        this.reboundAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        vc.e eVar = this.mLoadMoreListener;
        if (eVar != null) {
            eVar.onLoadMore(this);
        } else {
            finishLoadMore(HonorResultCode.ADVANCED_RECORD_SUCCESS);
        }
    }

    public static void setDefaultRefreshFooterCreator(vc.b bVar) {
        sFooterCreator = bVar;
    }

    public static void setDefaultRefreshHeaderCreator(vc.c cVar) {
        sHeaderCreator = cVar;
    }

    protected ValueAnimator animSpinner(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.mSpinner == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.animationRunnable = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, i2);
        this.reboundAnimator = ofInt;
        ofInt.setDuration(i4);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new c());
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smart.refresh.layout.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SmartRefreshLayout.this.g(valueAnimator2);
            }
        });
        this.reboundAnimator.setStartDelay(i3);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    protected void animSpinnerBounce(float f2) {
        uc.b bVar;
        if (this.reboundAnimator == null) {
            if (f2 > 0.0f && ((bVar = this.mState) == uc.b.Refreshing || bVar == uc.b.TwoLevel)) {
                this.animationRunnable = new i(f2, this.mHeaderHeight);
                return;
            }
            if (f2 < 0.0f && (this.mState == uc.b.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != uc.b.Refreshing)))) {
                this.animationRunnable = new i(f2, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new i(f2, 0);
            }
        }
    }

    public boolean autoLoadMore() {
        return autoLoadMore(0, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, false);
    }

    public boolean autoLoadMoreAnimationOnly() {
        return autoLoadMore(0, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, true);
    }

    public boolean autoRefresh() {
        return autoRefresh(this.mAttachedToWindow ? 0 : 400, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public boolean autoRefreshAnimationOnly() {
        int i2;
        if (this.mAttachedToWindow) {
            i2 = 0;
        } else {
            i2 = 400;
        }
        return autoRefresh(i2, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, true);
    }

    public tc.f closeHeaderOrFooter() {
        uc.b bVar;
        uc.b bVar2 = this.mState;
        uc.b bVar3 = uc.b.None;
        if (bVar2 == bVar3 && ((bVar = this.mViceState) == uc.b.Refreshing || bVar == uc.b.Loading)) {
            this.mViceState = bVar3;
        }
        if (bVar2 == uc.b.Refreshing) {
            finishRefresh();
        } else if (bVar2 == uc.b.Loading) {
            finishLoadMore();
        } else if (this.mKernel.b(0) == null) {
            notifyStateChanged(bVar3);
        } else if (this.mState.a) {
            notifyStateChanged(uc.b.PullDownCanceled);
        } else {
            notifyStateChanged(uc.b.PullUpCanceled);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        float currVelocity;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.g())) || (finalY > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.i()))) {
                if (this.mVerticalPermit) {
                    if (finalY > 0) {
                        currVelocity = -this.mScroller.getCurrVelocity();
                    } else {
                        currVelocity = this.mScroller.getCurrVelocity();
                    }
                    animSpinnerBounce(currVelocity);
                }
                this.mScroller.forceFinished(true);
                return;
            }
            this.mVerticalPermit = true;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0150, code lost:
    
        if (r6 != 3) goto L٢٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d2, code lost:
    
        if (r2.f == false) goto L٧٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
    
        if (r2.a == false) goto L٧٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e4, code lost:
    
        if (r2.f == false) goto L٨١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e8, code lost:
    
        if (r2.b == false) goto L٨١;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i2;
        uc.b bVar;
        uc.b bVar2;
        char c2;
        uc.b bVar3;
        tc.a aVar;
        tc.a aVar2;
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 0;
        int i4 = 1;
        if (actionMasked == 6) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = motionEvent.getActionIndex();
        } else {
            i2 = -1;
        }
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i5 = 0; i5 < pointerCount; i5++) {
            if (i2 != i5) {
                f2 += motionEvent.getX(i5);
                f3 += motionEvent.getY(i5);
            }
        }
        if (z) {
            pointerCount--;
        }
        float f4 = pointerCount;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f6 - this.mLastTouchY;
        }
        this.mLastTouchX = f5;
        this.mLastTouchY = f6;
        if (actionMasked == 0) {
            this.mLastTouchXOnActionDown = f5;
            this.mLastTouchYOnActionDown = f6;
            this.mLastTimeOnActionDown = System.currentTimeMillis();
        }
        if (this.mNestedInProgress) {
            int i6 = this.mTotalUnconsumed;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i6 == this.mTotalUnconsumed) {
                int i7 = (int) this.mLastTouchX;
                int width = getWidth();
                float f7 = this.mLastTouchX;
                if (width != 0) {
                    i4 = width;
                }
                float f8 = f7 / i4;
                if (isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mSpinner > 0 && (aVar2 = this.mRefreshHeader) != null && aVar2.isSupportHorizontalDrag()) {
                    this.mRefreshHeader.onHorizontalDrag(f8, i7, width);
                } else if (isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mSpinner < 0 && (aVar = this.mRefreshFooter) != null && aVar.isSupportHorizontalDrag()) {
                    this.mRefreshFooter.onHorizontalDrag(f8, i7, width);
                }
            }
            return dispatchTouchEvent;
        }
        if (isEnabled() && (this.mEnableRefresh || this.mEnableLoadMore || this.mEnableOverScrollDrag)) {
            if (this.mHeaderNeedTouchEventWhenRefreshing) {
                uc.b bVar4 = this.mState;
                if (!bVar4.e) {
                }
            }
            if (this.mFooterNeedTouchEventWhenLoading) {
                uc.b bVar5 = this.mState;
                if (!bVar5.e) {
                }
            }
            if (this.mState.f) {
                if (actionMasked == 1 && System.currentTimeMillis() - this.mLastTimeOnActionDown < 500) {
                    float f9 = f5 - this.mLastTouchXOnActionDown;
                    float f10 = f6 - this.mLastTouchYOnActionDown;
                    if (Math.abs(f9) < this.mTouchSlop && Math.abs(f10) < this.mTouchSlop) {
                        motionEvent.setAction(0);
                        super.dispatchTouchEvent(motionEvent);
                        motionEvent.setAction(1);
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return true;
            }
            if (interceptAnimatorByAction(actionMasked) || (((bVar = this.mState) == (bVar2 = uc.b.Loading) && this.mDisableContentWhenLoading) || (bVar == uc.b.Refreshing && this.mDisableContentWhenRefresh))) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float f11 = f5 - this.mTouchX;
                        float f12 = f6 - this.mTouchY;
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (!this.mIsBeingDragged && !this.mEnableDisallowIntercept && (c2 = this.mDragDirection) != 'h' && this.mRefreshContent != null) {
                            if (c2 != 'v' && (Math.abs(f12) < this.mTouchSlop || Math.abs(f11) >= Math.abs(f12))) {
                                if (Math.abs(f11) >= this.mTouchSlop && Math.abs(f11) > Math.abs(f12) && this.mDragDirection != 'v') {
                                    this.mDragDirection = 'h';
                                }
                            } else {
                                this.mDragDirection = 'v';
                                if (f12 > 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.g()))) {
                                    this.mIsBeingDragged = true;
                                    this.mTouchY = f6 - this.mTouchSlop;
                                } else if (f12 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && ((this.mState == bVar2 && this.mFooterLocked) || this.mRefreshContent.i())))) {
                                    this.mIsBeingDragged = true;
                                    this.mTouchY = this.mTouchSlop + f6;
                                }
                                if (this.mIsBeingDragged) {
                                    f12 = f6 - this.mTouchY;
                                    if (this.mSuperDispatchTouchEvent) {
                                        motionEvent.setAction(3);
                                        super.dispatchTouchEvent(motionEvent);
                                    }
                                    tc.e eVar = this.mKernel;
                                    int i8 = this.mSpinner;
                                    if (i8 <= 0 && (i8 != 0 || f12 <= 0.0f)) {
                                        bVar3 = uc.b.PullUpToLoad;
                                    } else {
                                        bVar3 = uc.b.PullDownToRefresh;
                                    }
                                    eVar.d(bVar3);
                                    ViewParent parent = getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            int i9 = ((int) f12) + this.mTouchSpinner;
                            uc.b bVar6 = this.mViceState;
                            if ((bVar6.a && (i9 < 0 || this.mLastSpinner < 0)) || (bVar6.b && (i9 > 0 || this.mLastSpinner > 0))) {
                                this.mLastSpinner = i9;
                                long eventTime = motionEvent.getEventTime();
                                if (this.mFalsifyEvent == null) {
                                    MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f11, this.mTouchY, 0);
                                    this.mFalsifyEvent = obtain;
                                    super.dispatchTouchEvent(obtain);
                                }
                                MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f11, this.mTouchY + i9, 0);
                                super.dispatchTouchEvent(obtain2);
                                if (this.mFooterLocked && f12 > this.mTouchSlop && this.mSpinner < 0) {
                                    this.mFooterLocked = false;
                                }
                                if (i9 > 0 && ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.g())) {
                                    this.mLastTouchY = f6;
                                    this.mTouchY = f6;
                                    this.mTouchSpinner = 0;
                                    this.mKernel.d(uc.b.PullDownToRefresh);
                                } else if (i9 < 0 && ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && this.mRefreshContent.i())) {
                                    this.mLastTouchY = f6;
                                    this.mTouchY = f6;
                                    this.mTouchSpinner = 0;
                                    this.mKernel.d(uc.b.PullUpToLoad);
                                } else {
                                    i3 = i9;
                                }
                                uc.b bVar7 = this.mViceState;
                                if ((bVar7.a && i3 < 0) || (bVar7.b && i3 > 0)) {
                                    if (this.mSpinner != 0) {
                                        moveSpinnerInfinitely(0.0f);
                                    }
                                    return true;
                                }
                                if (this.mFalsifyEvent != null) {
                                    this.mFalsifyEvent = null;
                                    obtain2.setAction(3);
                                    super.dispatchTouchEvent(obtain2);
                                }
                                obtain2.recycle();
                                i9 = i3;
                            }
                            moveSpinnerInfinitely(i9);
                            return true;
                        }
                        if (this.mFooterLocked && f12 > this.mTouchSlop && this.mSpinner < 0) {
                            this.mFooterLocked = false;
                        }
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                this.mVelocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                startFlingIfNeed(0.0f);
                this.mVelocityTracker.clear();
                this.mDragDirection = 'n';
                MotionEvent motionEvent2 = this.mFalsifyEvent;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                    this.mFalsifyEvent = null;
                    long eventTime2 = motionEvent.getEventTime();
                    MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f6, 0);
                    super.dispatchTouchEvent(obtain3);
                    obtain3.recycle();
                }
                overSpinner();
                if (this.mIsBeingDragged) {
                    this.mIsBeingDragged = false;
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            this.mCurrentVelocity = 0;
            this.mVelocityTracker.addMovement(motionEvent);
            this.mScroller.forceFinished(true);
            this.mTouchX = f5;
            this.mTouchY = f6;
            this.mLastSpinner = 0;
            this.mTouchSpinner = this.mSpinner;
            this.mIsBeingDragged = false;
            this.mEnableDisallowIntercept = false;
            this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (this.mState == uc.b.TwoLevel && this.mTouchY < getMeasuredHeight() * (1.0f - this.mTwoLevelBottomPullUpToCloseRate)) {
                this.mDragDirection = 'h';
                return this.mSuperDispatchTouchEvent;
            }
            tc.b bVar8 = this.mRefreshContent;
            if (bVar8 != null) {
                bVar8.a(motionEvent);
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        View view2;
        Paint paint;
        Paint paint2;
        tc.b bVar = this.mRefreshContent;
        if (bVar != null) {
            view2 = bVar.getView();
        } else {
            view2 = null;
        }
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null && aVar.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i2 = this.mHeaderBackgroundColor;
                if (i2 != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i2);
                    if (this.mRefreshHeader.getSpinnerStyle().c) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == uc.c.d) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.mPaint);
                }
                if ((this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == uc.c.f) || this.mRefreshHeader.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null && aVar2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i3 = this.mFooterBackgroundColor;
                if (i3 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i3);
                    if (this.mRefreshFooter.getSpinnerStyle().c) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == uc.c.d) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.mPaint);
                }
                if ((this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == uc.c.f) || this.mRefreshFooter.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // tc.f
    public tc.f finishLoadMore() {
        return finishLoadMore(true);
    }

    public tc.f finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    @Override // tc.f
    public tc.f finishRefresh() {
        return finishRefresh(true);
    }

    public tc.f finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    @Override // tc.f
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedParent.a();
    }

    public tc.c getRefreshFooter() {
        tc.a aVar = this.mRefreshFooter;
        if (aVar instanceof tc.c) {
            return (tc.c) aVar;
        }
        return null;
    }

    public tc.d getRefreshHeader() {
        tc.a aVar = this.mRefreshHeader;
        if (aVar instanceof tc.d) {
            return (tc.d) aVar;
        }
        return null;
    }

    public uc.b getState() {
        return this.mState;
    }

    protected boolean interceptAnimatorByAction(int i2) {
        if (i2 == 0) {
            if (this.reboundAnimator != null) {
                uc.b bVar = this.mState;
                if (bVar.f || bVar == uc.b.TwoLevelReleased || bVar == uc.b.RefreshReleased || bVar == uc.b.LoadReleased) {
                    return true;
                }
                if (bVar == uc.b.PullDownCanceled) {
                    this.mKernel.d(uc.b.PullDownToRefresh);
                } else if (bVar == uc.b.PullUpCanceled) {
                    this.mKernel.d(uc.b.PullUpToLoad);
                }
                this.reboundAnimator.setDuration(0L);
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        if (this.reboundAnimator != null) {
            return true;
        }
        return false;
    }

    protected boolean isEnableRefreshOrLoadMore(boolean z) {
        if (z && !this.mEnablePureScrollMode) {
            return true;
        }
        return false;
    }

    protected boolean isEnableTranslationContent(boolean z, tc.a aVar) {
        if (!z && !this.mEnablePureScrollMode && aVar != null && aVar.getSpinnerStyle() != uc.c.f) {
            return false;
        }
        return true;
    }

    public boolean isLoading() {
        if (this.mState == uc.b.Loading) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        if (this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore)) {
            return true;
        }
        return false;
    }

    public boolean isRefreshing() {
        if (this.mState == uc.b.Refreshing) {
            return true;
        }
        return false;
    }

    protected void moveSpinnerInfinitely(float f2) {
        float f3;
        double d2;
        double d3;
        double d4;
        uc.b bVar;
        if (this.mNestedInProgress && !this.mEnableLoadMoreWhenContentNotFull && f2 < 0.0f && !this.mRefreshContent.i()) {
            f3 = 0.0f;
        } else {
            f3 = f2;
        }
        if (f3 > this.mScreenHeightPixels * 5 && getTag() == null) {
            int i2 = R.id.srl_tag;
            if (getTag(i2) == null) {
                float f4 = this.mLastTouchY;
                int i3 = this.mScreenHeightPixels;
                if (f4 < i3 / 6.0f && this.mLastTouchX < i3 / 16.0f) {
                    Toast.makeText(getContext(), "不要再拉了，臣妾做不到啊！", 0).show();
                    setTag(i2, "不要再拉了，臣妾做不到啊！");
                }
            }
        }
        uc.b bVar2 = this.mState;
        if (bVar2 == uc.b.TwoLevel && f3 > 0.0f) {
            this.mKernel.e(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (bVar2 == uc.b.Refreshing && f3 >= 0.0f) {
            int i4 = this.mHeaderHeight;
            if (f3 < i4) {
                this.mKernel.e((int) f3, true);
            } else {
                float f5 = this.mHeaderMaxDragRate;
                if (f5 < 10.0f) {
                    f5 *= i4;
                }
                double d5 = f5 - i4;
                int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i5 = this.mHeaderHeight;
                double d6 = max - i5;
                double max2 = Math.max(0.0f, (f3 - i5) * this.mDragRate);
                double d7 = -max2;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.mKernel.e(((int) Math.min(d5 * (1.0d - Math.pow(100.0d, d7 / d6)), max2)) + this.mHeaderHeight, true);
            }
        } else if (f3 < 0.0f && (bVar2 == uc.b.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i6 = this.mFooterHeight;
            if (f3 > (-i6)) {
                this.mKernel.e((int) f3, true);
            } else {
                float f6 = this.mFooterMaxDragRate;
                if (f6 < 10.0f) {
                    f6 *= i6;
                }
                double d8 = f6 - i6;
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i7 = this.mFooterHeight;
                double d9 = max3 - i7;
                double d10 = -Math.min(0.0f, (i7 + f3) * this.mDragRate);
                double d11 = -d10;
                if (d9 == 0.0d) {
                    d9 = 1.0d;
                }
                this.mKernel.e(((int) (-Math.min(d8 * (1.0d - Math.pow(100.0d, d11 / d9)), d10))) - this.mFooterHeight, true);
            }
        } else if (f3 >= 0.0f) {
            float f7 = this.mHeaderMaxDragRate;
            if (f7 < 10.0f) {
                d4 = this.mHeaderHeight * f7;
            } else {
                d4 = f7;
            }
            double max4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = Math.max(0.0f, this.mDragRate * f3);
            double d12 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.e((int) Math.min(d4 * (1.0d - Math.pow(100.0d, d12 / max4)), max5), true);
        } else {
            float f8 = this.mFooterMaxDragRate;
            if (f8 < 10.0f) {
                d2 = this.mFooterHeight * f8;
            } else {
                d2 = f8;
            }
            double max6 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d13 = -Math.min(0.0f, this.mDragRate * f3);
            double d14 = -d13;
            if (max6 == 0.0d) {
                d3 = 1.0d;
            } else {
                d3 = max6;
            }
            this.mKernel.e((int) (-Math.min(d2 * (1.0d - Math.pow(100.0d, d14 / d3)), d13)), true);
        }
        if (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && f3 < 0.0f && (bVar = this.mState) != uc.b.Refreshing && bVar != uc.b.Loading && bVar != uc.b.LoadFinish) {
            if (this.mDisableContentWhenLoading) {
                this.animationRunnable = null;
                this.mKernel.b(-this.mFooterHeight);
            }
            setStateDirectLoading(false);
            this.mHandler.postDelayed(new Runnable() { // from class: com.scwang.smart.refresh.layout.d
                @Override // java.lang.Runnable
                public final void run() {
                    SmartRefreshLayout.this.l();
                }
            }, this.mReboundDuration);
        }
    }

    protected void notifyStateChanged(uc.b bVar) {
        uc.b bVar2 = this.mState;
        if (bVar2 != bVar) {
            this.mState = bVar;
            this.mViceState = bVar;
            tc.a aVar = this.mRefreshHeader;
            tc.a aVar2 = this.mRefreshFooter;
            if (aVar != null) {
                aVar.onStateChanged(this, bVar2, bVar);
            }
            if (aVar2 != null) {
                aVar2.onStateChanged(this, bVar2, bVar);
            }
            if (bVar == uc.b.LoadFinish) {
                this.mFooterLocked = false;
                return;
            }
            return;
        }
        if (this.mViceState != bVar2) {
            this.mViceState = bVar2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        tc.a aVar;
        vc.c cVar;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null && (cVar = sHeaderCreator) != null) {
                tc.d a2 = cVar.a(getContext(), this);
                if (a2 != null) {
                    setRefreshHeader(a2);
                } else {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
            }
            if (this.mRefreshFooter == null) {
                vc.b bVar = sFooterCreator;
                if (bVar != null) {
                    tc.c a3 = bVar.a(getContext(), this);
                    if (a3 != null) {
                        setRefreshFooter(a3);
                    } else {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    tc.a aVar2 = this.mRefreshHeader;
                    if ((aVar2 == null || childAt != aVar2.getView()) && ((aVar = this.mRefreshFooter) == null || childAt != aVar.getView())) {
                        this.mRefreshContent = new xc.a(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int c2 = wc.c.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new k(-1, -1));
                xc.a aVar3 = new xc.a(textView);
                this.mRefreshContent = aVar3;
                aVar3.getView().setPadding(c2, c2, c2, c2);
            }
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.c(this.mScrollBoundaryDecider);
            this.mRefreshContent.d(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.b(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(uc.b.None);
                tc.b bVar2 = this.mRefreshContent;
                this.mSpinner = 0;
                bVar2.h(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            tc.a aVar4 = this.mRefreshHeader;
            if (aVar4 != null) {
                aVar4.setPrimaryColors(iArr);
            }
            tc.a aVar5 = this.mRefreshFooter;
            if (aVar5 != null) {
                aVar5.setPrimaryColors(this.mPrimaryColors);
            }
        }
        tc.b bVar3 = this.mRefreshContent;
        if (bVar3 != null) {
            super.bringChildToFront(bVar3.getView());
        }
        tc.a aVar6 = this.mRefreshHeader;
        if (aVar6 != null && aVar6.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        tc.a aVar7 = this.mRefreshFooter;
        if (aVar7 != null && aVar7.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null && this.mState == uc.b.Refreshing) {
            aVar.onFinish(this, false);
        }
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null && this.mState == uc.b.Loading) {
            aVar2.onFinish(this, false);
        }
        if (this.mSpinner != 0) {
            this.mKernel.e(0, true);
        }
        uc.b bVar = this.mState;
        uc.b bVar2 = uc.b.None;
        if (bVar != bVar2) {
            notifyStateChanged(bVar2);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mFooterLocked = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onFinishInflate() {
        int i2;
        int i3;
        int i4;
        tc.d refreshHeaderWrapper;
        boolean z;
        tc.c refreshFooterWrapper;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i5 = 0;
            int i6 = -1;
            char c2 = 0;
            while (true) {
                i2 = 2;
                if (i5 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i5);
                if (wc.c.e(childAt) && (c2 < 2 || i5 == 1)) {
                    i6 = i5;
                    c2 = 2;
                } else if (!(childAt instanceof tc.a) && c2 < 1) {
                    if (i5 > 0) {
                        c2 = 1;
                    } else {
                        c2 = 0;
                    }
                    i6 = i5;
                }
                i5++;
            }
            if (i6 >= 0) {
                this.mRefreshContent = new xc.a(super.getChildAt(i6));
                if (i6 == 1) {
                    if (childCount == 3) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        i2 = -1;
                    }
                } else if (childCount == 2) {
                    i3 = -1;
                    i2 = 1;
                }
                for (i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = super.getChildAt(i4);
                    if (i4 != i3 && (i4 == i2 || i3 != -1 || this.mRefreshHeader != null || !(childAt2 instanceof tc.d))) {
                        if (i4 == i2 || (i2 == -1 && (childAt2 instanceof tc.c))) {
                            if (!this.mEnableLoadMore && this.mManualLoadMore) {
                                z = false;
                            } else {
                                z = true;
                            }
                            this.mEnableLoadMore = z;
                            if (childAt2 instanceof tc.c) {
                                refreshFooterWrapper = (tc.c) childAt2;
                            } else {
                                refreshFooterWrapper = new RefreshFooterWrapper(childAt2);
                            }
                            this.mRefreshFooter = refreshFooterWrapper;
                        }
                    } else {
                        if (childAt2 instanceof tc.d) {
                            refreshHeaderWrapper = (tc.d) childAt2;
                        } else {
                            refreshHeaderWrapper = new RefreshHeaderWrapper(childAt2);
                        }
                        this.mRefreshHeader = refreshHeaderWrapper;
                    }
                }
                return;
            }
            i3 = -1;
            i2 = -1;
            while (i4 < childCount) {
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i6;
        int i7;
        int i8;
        boolean z2;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        boolean z3;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = super.getChildAt(i9);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R.id.srl_tag))) {
                tc.b bVar = this.mRefreshContent;
                boolean z4 = true;
                if (bVar != null && bVar.getView() == childAt) {
                    if (isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams3 = sDefaultMarginLP;
                    }
                    int i10 = marginLayoutParams3.leftMargin + paddingLeft;
                    int i11 = marginLayoutParams3.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i10;
                    int measuredHeight = view.getMeasuredHeight() + i11;
                    if (z3 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i12 = this.mHeaderHeight;
                        i11 += i12;
                        measuredHeight += i12;
                    }
                    view.layout(i10, i11, measuredWidth, measuredHeight);
                }
                tc.a aVar = this.mRefreshHeader;
                if (aVar != null && aVar.getView() == childAt) {
                    if (isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    } else {
                        marginLayoutParams2 = sDefaultMarginLP;
                    }
                    int i13 = marginLayoutParams2.leftMargin;
                    int i14 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i13;
                    int measuredHeight2 = view2.getMeasuredHeight() + i14;
                    if (!z2 && this.mRefreshHeader.getSpinnerStyle() == uc.c.d) {
                        int i15 = this.mHeaderHeight;
                        i14 -= i15;
                        measuredHeight2 -= i15;
                    }
                    view2.layout(i13, i14, measuredWidth2, measuredHeight2);
                }
                tc.a aVar2 = this.mRefreshFooter;
                if (aVar2 != null && aVar2.getView() == childAt) {
                    if (!isInEditMode() || !this.mEnablePreviewInEditMode || !isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        z4 = false;
                    }
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    uc.c spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i16 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == uc.c.d && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                            i8 = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
                        } else {
                            i8 = 0;
                        }
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + i8;
                    }
                    if (spinnerStyle == uc.c.h) {
                        measuredHeight3 = marginLayoutParams.topMargin - this.mFooterInsetStart;
                    } else {
                        if (!z4 && spinnerStyle != uc.c.g && spinnerStyle != uc.c.f) {
                            if (spinnerStyle.c && this.mSpinner < 0) {
                                if (isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                    i7 = -this.mSpinner;
                                } else {
                                    i7 = 0;
                                }
                                i6 = Math.max(i7, 0);
                            }
                        } else {
                            i6 = this.mFooterHeight;
                        }
                        measuredHeight3 -= i6;
                    }
                    view3.layout(i16, measuredHeight3, view3.getMeasuredWidth() + i16, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0264  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        uc.a aVar;
        int i7;
        int i8;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < childCount) {
            View childAt = super.getChildAt(i9);
            if (childAt.getVisibility() == 8 || "GONE".equals(childAt.getTag(R.id.srl_tag))) {
                i4 = childCount;
            } else {
                tc.a aVar2 = this.mRefreshHeader;
                if (aVar2 == null || aVar2.getView() != childAt) {
                    i4 = childCount;
                } else {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int i12 = this.mHeaderHeight;
                    uc.a aVar3 = this.mHeaderHeightStatus;
                    i4 = childCount;
                    if (aVar3.a < uc.a.i.a) {
                        int i13 = layoutParams.height;
                        if (i13 > 0) {
                            int i14 = i13 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            uc.a aVar4 = uc.a.g;
                            if (aVar3.a(aVar4)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.mHeaderHeightStatus = aVar4;
                            }
                            i12 = i14;
                        } else if (i13 == -2 && (this.mRefreshHeader.getSpinnerStyle() != uc.c.h || !this.mHeaderHeightStatus.b)) {
                            int max = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredHeight > 0) {
                                if (measuredHeight != max) {
                                    uc.a aVar5 = this.mHeaderHeightStatus;
                                    uc.a aVar6 = uc.a.e;
                                    if (aVar5.a(aVar6)) {
                                        this.mHeaderHeight = measuredHeight + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.mHeaderHeightStatus = aVar6;
                                    }
                                }
                                i12 = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == uc.c.h) {
                        i12 = View.MeasureSpec.getSize(i3);
                        i8 = -1;
                        i7 = 0;
                    } else {
                        if (!this.mRefreshHeader.getSpinnerStyle().c || z) {
                            i7 = 0;
                        } else {
                            i7 = 0;
                            i12 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableRefresh) ? this.mSpinner : 0);
                        }
                        i8 = -1;
                    }
                    if (i12 != i8) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i12 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i7), 1073741824));
                    }
                    uc.a aVar7 = this.mHeaderHeightStatus;
                    if (!aVar7.b) {
                        float f2 = this.mHeaderMaxDragRate;
                        if (f2 < 10.0f) {
                            f2 *= this.mHeaderHeight;
                        }
                        this.mHeaderHeightStatus = aVar7.b();
                        this.mRefreshHeader.onInitialized(this.mKernel, this.mHeaderHeight, (int) f2);
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        i10 += view.getMeasuredWidth();
                        i11 += view.getMeasuredHeight();
                    }
                }
                tc.a aVar8 = this.mRefreshFooter;
                if (aVar8 != null && aVar8.getView() == childAt) {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i15 = this.mFooterHeight;
                    uc.a aVar9 = this.mFooterHeightStatus;
                    if (aVar9.a < uc.a.i.a) {
                        int i16 = layoutParams2.height;
                        if (i16 > 0) {
                            i15 = marginLayoutParams2.bottomMargin + i16 + marginLayoutParams2.topMargin;
                            uc.a aVar10 = uc.a.g;
                            if (aVar9.a(aVar10)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = aVar10;
                            }
                        } else if (i16 == -2 && (this.mRefreshFooter.getSpinnerStyle() != uc.c.h || !this.mFooterHeightStatus.b)) {
                            int max2 = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != max2) {
                                    uc.a aVar11 = this.mFooterHeightStatus;
                                    uc.a aVar12 = uc.a.e;
                                    if (aVar11.a(aVar12)) {
                                        this.mFooterHeight = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.mFooterHeightStatus = aVar12;
                                    }
                                }
                                i5 = -1;
                                if (this.mRefreshFooter.getSpinnerStyle() != uc.c.h) {
                                    i5 = View.MeasureSpec.getSize(i3);
                                } else if (this.mRefreshFooter.getSpinnerStyle().c && !z) {
                                    i6 = 0;
                                    i5 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0);
                                    if (i5 != -1) {
                                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i5 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i6), 1073741824));
                                    }
                                    aVar = this.mFooterHeightStatus;
                                    if (!aVar.b) {
                                        float f3 = this.mFooterMaxDragRate;
                                        if (f3 < 10.0f) {
                                            f3 *= this.mFooterHeight;
                                        }
                                        this.mFooterHeightStatus = aVar.b();
                                        this.mRefreshFooter.onInitialized(this.mKernel, this.mFooterHeight, (int) f3);
                                    }
                                    if (z && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                        i10 += view2.getMeasuredWidth();
                                        i11 += view2.getMeasuredHeight();
                                    }
                                }
                                i6 = 0;
                                if (i5 != -1) {
                                }
                                aVar = this.mFooterHeightStatus;
                                if (!aVar.b) {
                                }
                                if (z) {
                                    i10 += view2.getMeasuredWidth();
                                    i11 += view2.getMeasuredHeight();
                                }
                            }
                        }
                    }
                    i5 = i15;
                    if (this.mRefreshFooter.getSpinnerStyle() != uc.c.h) {
                    }
                    i6 = 0;
                    if (i5 != -1) {
                    }
                    aVar = this.mFooterHeightStatus;
                    if (!aVar.b) {
                    }
                    if (z) {
                    }
                }
                tc.b bVar = this.mRefreshContent;
                if (bVar != null && bVar.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    view3.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((z && (this.mRefreshHeader != null && isEnableRefreshOrLoadMore(this.mEnableRefresh) && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader))) ? this.mHeaderHeight : 0) + ((z && (this.mRefreshFooter != null && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter))) ? this.mFooterHeight : 0), layoutParams3.height));
                    i10 += view3.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin;
                    i11 += view3.getMeasuredHeight() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                }
            }
            i9++;
            childCount = i4;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(i10 + getPaddingLeft() + getPaddingRight(), super.getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i11 + getPaddingTop() + getPaddingBottom(), super.getSuggestedMinimumHeight()), i3));
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return this.mNestedChild.a(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        if ((!this.mFooterLocked || f3 <= 0.0f) && !startFlingIfNeed(-f3) && !this.mNestedChild.b(f2, f3)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int i4 = this.mTotalUnconsumed;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.mTotalUnconsumed)) {
                int i6 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i5 = i6;
            } else {
                this.mTotalUnconsumed -= i3;
                i5 = i3;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i3 > 0 && this.mFooterLocked) {
            int i7 = i4 - i3;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
            i5 = i3;
        }
        this.mNestedChild.c(i2, i3 - i5, iArr, (int[]) null);
        iArr[1] = iArr[1] + i5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        vc.j jVar;
        uc.b bVar;
        ViewParent parent;
        vc.j jVar2;
        boolean f2 = this.mNestedChild.f(i2, i3, i4, i5, this.mParentOffsetInWindow);
        int i6 = i5 + this.mParentOffsetInWindow[1];
        if ((i6 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (jVar2 = this.mScrollBoundaryDecider) == null || jVar2.a(this.mRefreshContent.getView())))) || (i6 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (jVar = this.mScrollBoundaryDecider) == null || jVar.b(this.mRefreshContent.getView()))))) {
            uc.b bVar2 = this.mViceState;
            if (bVar2 == uc.b.None || bVar2.e) {
                tc.e eVar = this.mKernel;
                if (i6 > 0) {
                    bVar = uc.b.PullUpToLoad;
                } else {
                    bVar = uc.b.PullDownToRefresh;
                }
                eVar.d(bVar);
                if (!f2 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i7 = this.mTotalUnconsumed - i6;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
        }
        if (this.mFooterLocked && i3 < 0) {
            this.mFooterLocked = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.mNestedParent.b(view, view2, i2);
        this.mNestedChild.p(i2 & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0 && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.mNestedParent.d(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.r();
    }

    protected void overSpinner() {
        uc.b bVar = this.mState;
        if (bVar == uc.b.TwoLevel) {
            if (this.mCurrentVelocity > -1000 && this.mSpinner > getHeight() / 2) {
                ValueAnimator b2 = this.mKernel.b(getHeight());
                if (b2 != null) {
                    b2.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            }
            if (this.mIsBeingDragged) {
                this.mKernel.a();
                return;
            }
            return;
        }
        uc.b bVar2 = uc.b.Loading;
        if (bVar != bVar2 && (!this.mEnableFooterFollowWhenNoMoreData || !this.mFooterNoMoreData || !this.mFooterNoMoreDataEffective || this.mSpinner >= 0 || !isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            uc.b bVar3 = this.mState;
            uc.b bVar4 = uc.b.Refreshing;
            if (bVar3 == bVar4) {
                int i2 = this.mSpinner;
                int i3 = this.mHeaderHeight;
                if (i2 > i3) {
                    this.mKernel.b(i3);
                    return;
                } else {
                    if (i2 < 0) {
                        this.mKernel.b(0);
                        return;
                    }
                    return;
                }
            }
            if (bVar3 == uc.b.PullDownToRefresh) {
                this.mKernel.d(uc.b.PullDownCanceled);
                return;
            }
            if (bVar3 == uc.b.PullUpToLoad) {
                this.mKernel.d(uc.b.PullUpCanceled);
                return;
            }
            if (bVar3 == uc.b.ReleaseToRefresh) {
                this.mKernel.d(bVar4);
                return;
            }
            if (bVar3 == uc.b.ReleaseToLoad) {
                this.mKernel.d(bVar2);
                return;
            }
            if (bVar3 == uc.b.ReleaseToTwoLevel) {
                this.mKernel.d(uc.b.TwoLevelReleased);
                return;
            }
            if (bVar3 == uc.b.RefreshReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.b(this.mHeaderHeight);
                    return;
                }
                return;
            } else if (bVar3 == uc.b.LoadReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.b(-this.mFooterHeight);
                    return;
                }
                return;
            } else if (bVar3 == uc.b.LoadFinish) {
                Log.d("SmartRefreshLayout", "overSpinner 时 LoadFinish 状态无任何操作即可");
                return;
            } else {
                if (this.mSpinner != 0) {
                    this.mKernel.b(0);
                    return;
                }
                return;
            }
        }
        int i4 = this.mSpinner;
        int i5 = this.mFooterHeight;
        if (i4 < (-i5)) {
            this.mKernel.b(-i5);
        } else if (i4 > 0) {
            this.mKernel.b(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (d1.W(this.mRefreshContent.f())) {
            this.mEnableDisallowIntercept = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public tc.f resetNoMoreData() {
        return setNoMoreData(false);
    }

    public tc.f setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // tc.f
    public tc.f setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    public tc.f setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    public tc.f setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    public tc.f setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    public tc.f setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    public tc.f setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    public tc.f setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    public tc.f setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    public tc.f setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    public tc.f setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        tc.b bVar = this.mRefreshContent;
        if (bVar != null) {
            bVar.d(z);
        }
        return this;
    }

    @Override // tc.f
    public tc.f setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public tc.f setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    public tc.f setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    public tc.f setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    public tc.f setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    public tc.f setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    public tc.f setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    public tc.f setFixedFooterViewId(int i2) {
        this.mFixedFooterViewId = i2;
        return this;
    }

    public tc.f setFixedHeaderViewId(int i2) {
        this.mFixedHeaderViewId = i2;
        return this;
    }

    public tc.f setFooterHeight(float f2) {
        return setFooterHeightPx(wc.c.c(f2));
    }

    public tc.f setFooterHeightPx(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (i2 == this.mFooterHeight) {
            return this;
        }
        uc.a aVar = this.mFooterHeightStatus;
        uc.a aVar2 = uc.a.l;
        if (aVar.a(aVar2)) {
            this.mFooterHeight = i2;
            tc.a aVar3 = this.mRefreshFooter;
            if (aVar3 != null && this.mAttachedToWindow && this.mFooterHeightStatus.b) {
                uc.c spinnerStyle = aVar3.getSpinnerStyle();
                if (spinnerStyle != uc.c.h && !spinnerStyle.c) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    int i3 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i4 = marginLayoutParams.leftMargin;
                    int measuredHeight = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (spinnerStyle != uc.c.d) {
                        i3 = this.mFooterHeight;
                    }
                    int i5 = measuredHeight - i3;
                    view.layout(i4, i5, view.getMeasuredWidth() + i4, view.getMeasuredHeight() + i5);
                }
                float f2 = this.mFooterMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= this.mFooterHeight;
                }
                this.mFooterHeightStatus = aVar2;
                this.mRefreshFooter.onInitialized(this.mKernel, this.mFooterHeight, (int) f2);
            } else {
                this.mFooterHeightStatus = uc.a.k;
            }
        }
        return this;
    }

    public tc.f setFooterInsetStart(float f2) {
        this.mFooterInsetStart = wc.c.c(f2);
        return this;
    }

    public tc.f setFooterInsetStartPx(int i2) {
        this.mFooterInsetStart = i2;
        return this;
    }

    public tc.f setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        tc.a aVar = this.mRefreshFooter;
        if (aVar != null && this.mAttachedToWindow) {
            if (f2 < 10.0f) {
                f2 *= this.mFooterHeight;
            }
            aVar.onInitialized(this.mKernel, this.mFooterHeight, (int) f2);
        } else {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        }
        return this;
    }

    public tc.f setFooterTranslationViewId(int i2) {
        this.mFooterTranslationViewId = i2;
        return this;
    }

    public tc.f setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    public tc.f setHeaderHeight(float f2) {
        return setHeaderHeightPx(wc.c.c(f2));
    }

    public tc.f setHeaderHeightPx(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (i2 == this.mHeaderHeight) {
            return this;
        }
        uc.a aVar = this.mHeaderHeightStatus;
        uc.a aVar2 = uc.a.l;
        if (aVar.a(aVar2)) {
            this.mHeaderHeight = i2;
            tc.a aVar3 = this.mRefreshHeader;
            if (aVar3 != null && this.mAttachedToWindow && this.mHeaderHeightStatus.b) {
                uc.c spinnerStyle = aVar3.getSpinnerStyle();
                if (spinnerStyle != uc.c.h && !spinnerStyle.c) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    int i3 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i4 = marginLayoutParams.leftMargin;
                    int i5 = marginLayoutParams.topMargin + this.mHeaderInsetStart;
                    if (spinnerStyle == uc.c.d) {
                        i3 = this.mHeaderHeight;
                    }
                    int i6 = i5 - i3;
                    view.layout(i4, i6, view.getMeasuredWidth() + i4, view.getMeasuredHeight() + i6);
                }
                float f2 = this.mHeaderMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= this.mHeaderHeight;
                }
                this.mHeaderHeightStatus = aVar2;
                this.mRefreshHeader.onInitialized(this.mKernel, this.mHeaderHeight, (int) f2);
            } else {
                this.mHeaderHeightStatus = uc.a.k;
            }
        }
        return this;
    }

    @Override // tc.f
    public tc.f setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = wc.c.c(f2);
        return this;
    }

    public tc.f setHeaderInsetStartPx(int i2) {
        this.mHeaderInsetStart = i2;
        return this;
    }

    public tc.f setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null && this.mAttachedToWindow) {
            if (f2 < 10.0f) {
                f2 *= this.mHeaderHeight;
            }
            aVar.onInitialized(this.mKernel, this.mHeaderHeight, (int) f2);
        } else {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        }
        return this;
    }

    public tc.f setHeaderTranslationViewId(int i2) {
        this.mHeaderTranslationViewId = i2;
        return this;
    }

    @Override // tc.f
    public tc.f setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.n(z);
    }

    @Override // tc.f
    public tc.f setNoMoreData(boolean z) {
        uc.b bVar = this.mState;
        if (bVar == uc.b.Refreshing && z) {
            finishRefreshWithNoMoreData();
        } else if (bVar == uc.b.Loading && z) {
            finishLoadMoreWithNoMoreData();
        } else if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            tc.a aVar = this.mRefreshFooter;
            if (aVar instanceof tc.c) {
                if (((tc.c) aVar).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == uc.c.d && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // tc.f
    public tc.f setOnLoadMoreListener(vc.e eVar) {
        boolean z;
        this.mLoadMoreListener = eVar;
        if (!this.mEnableLoadMore && (this.mManualLoadMore || eVar == null)) {
            z = false;
        } else {
            z = true;
        }
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // tc.f
    public tc.f setOnRefreshListener(vc.g gVar) {
        this.mRefreshListener = gVar;
        return this;
    }

    public tc.f setOnRefreshLoadMoreListener(vc.h hVar) {
        boolean z;
        this.mRefreshListener = hVar;
        this.mLoadMoreListener = hVar;
        if (!this.mEnableLoadMore && (this.mManualLoadMore || hVar == null)) {
            z = false;
        } else {
            z = true;
        }
        this.mEnableLoadMore = z;
        return this;
    }

    public tc.f setPrimaryColors(int... iArr) {
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null) {
            aVar.setPrimaryColors(iArr);
        }
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null) {
            aVar2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    public tc.f setPrimaryColorsId(int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.a.getColor(getContext(), iArr[i2]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    public tc.f setReboundDuration(int i2) {
        this.mReboundDuration = i2;
        return this;
    }

    public tc.f setReboundInterpolator(Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    public tc.f setRefreshContent(View view) {
        return setRefreshContent(view, 0, 0);
    }

    public tc.f setRefreshFooter(tc.c cVar) {
        return setRefreshFooter(cVar, 0, 0);
    }

    public tc.f setRefreshHeader(tc.d dVar) {
        return setRefreshHeader(dVar, 0, 0);
    }

    public tc.f setScrollBoundaryDecider(vc.j jVar) {
        this.mScrollBoundaryDecider = jVar;
        tc.b bVar = this.mRefreshContent;
        if (bVar != null) {
            bVar.c(jVar);
        }
        return this;
    }

    protected void setStateDirectLoading(boolean z) {
        uc.b bVar = this.mState;
        uc.b bVar2 = uc.b.Loading;
        if (bVar != bVar2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(bVar2);
            vc.e eVar = this.mLoadMoreListener;
            if (eVar != null) {
                if (z) {
                    eVar.onLoadMore(this);
                }
            } else {
                finishLoadMore(HonorResultCode.ADVANCED_RECORD_SUCCESS);
            }
            tc.a aVar = this.mRefreshFooter;
            if (aVar != null) {
                float f2 = this.mFooterMaxDragRate;
                if (f2 < 10.0f) {
                    f2 *= this.mFooterHeight;
                }
                aVar.onStartAnimator(this, this.mFooterHeight, (int) f2);
            }
        }
    }

    protected void setStateLoading(boolean z) {
        a aVar = new a(z);
        notifyStateChanged(uc.b.LoadReleased);
        ValueAnimator b2 = this.mKernel.b(-this.mFooterHeight);
        if (b2 != null) {
            b2.addListener(aVar);
        }
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null) {
            float f2 = this.mFooterMaxDragRate;
            if (f2 < 10.0f) {
                f2 *= this.mFooterHeight;
            }
            aVar2.onReleased(this, this.mFooterHeight, (int) f2);
        }
        if (b2 == null) {
            aVar.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(boolean z) {
        b bVar = new b(z);
        notifyStateChanged(uc.b.RefreshReleased);
        ValueAnimator b2 = this.mKernel.b(this.mHeaderHeight);
        if (b2 != null) {
            b2.addListener(bVar);
        }
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null) {
            float f2 = this.mHeaderMaxDragRate;
            if (f2 < 10.0f) {
                f2 *= this.mHeaderHeight;
            }
            aVar.onReleased(this, this.mHeaderHeight, (int) f2);
        }
        if (b2 == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void setViceState(uc.b bVar) {
        uc.b bVar2 = this.mState;
        if (bVar2.d && bVar2.a != bVar.a) {
            notifyStateChanged(uc.b.None);
        }
        if (this.mViceState != bVar) {
            this.mViceState = bVar;
        }
    }

    protected boolean startFlingIfNeed(float f2) {
        if (f2 == 0.0f) {
            f2 = this.mCurrentVelocity;
        }
        if (Math.abs(f2) > this.mMinimumVelocity) {
            int i2 = this.mSpinner;
            if (i2 * f2 < 0.0f) {
                uc.b bVar = this.mState;
                if (bVar != uc.b.Refreshing && bVar != uc.b.Loading && (i2 >= 0 || !this.mFooterNoMoreData)) {
                    if (bVar.g) {
                        return true;
                    }
                } else {
                    this.animationRunnable = new j(f2).a();
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == uc.b.Loading && i2 >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == uc.b.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new e0(this);
        this.mNestedParent = new i0(this);
        uc.a aVar = uc.a.c;
        this.mHeaderHeightStatus = aVar;
        this.mFooterHeightStatus = aVar;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mTwoLevelBottomPullUpToCloseRate = 0.16666667f;
        this.mKernel = new l();
        uc.b bVar = uc.b.None;
        this.mState = bVar;
        this.mViceState = bVar;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mLastTimeOnActionDown = 0L;
        this.mLastTouchXOnActionDown = 0.0f;
        this.mLastTouchYOnActionDown = 0.0f;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new wc.c(wc.c.b);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = wc.c.c(60.0f);
        this.mHeaderHeight = wc.c.c(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        this.mDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i2 = R.styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i2, this.mEnableLoadMore);
        int i3 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i3, this.mHeaderHeight);
        int i4 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i4, this.mFooterHeight);
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i5 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i5, this.mEnableHeaderTranslationContent);
        int i6 = R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(i6, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z;
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z2;
        this.mNestedChild.n(z2);
        this.mManualLoadMore = this.mManualLoadMore || obtainStyledAttributes.hasValue(i2);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || obtainStyledAttributes.hasValue(i5);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || obtainStyledAttributes.hasValue(i6);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i3) ? uc.a.i : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i4) ? uc.a.i : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        obtainStyledAttributes.recycle();
    }

    public boolean autoLoadMore(int i2) {
        return autoLoadMore(i2, this.mReboundDuration, (this.mFooterMaxDragRate + this.mFooterTriggerRate) / 2.0f, false);
    }

    public boolean autoRefresh(int i2) {
        return autoRefresh(i2, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public tc.f finishLoadMore(int i2) {
        return finishLoadMore(i2, true, false);
    }

    @Override // tc.f
    public tc.f finishRefresh(int i2) {
        return finishRefresh(i2, true, Boolean.FALSE);
    }

    public tc.f setRefreshContent(View view, int i2, int i3) {
        tc.b bVar = this.mRefreshContent;
        if (bVar != null) {
            super.removeView(bVar.getView());
        }
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -1;
        }
        k kVar = new k(i2, i3);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof k) {
            kVar = (k) layoutParams;
        }
        super.addView(view, getChildCount(), kVar);
        this.mRefreshContent = new xc.a(view);
        if (this.mAttachedToWindow) {
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.c(this.mScrollBoundaryDecider);
            this.mRefreshContent.d(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.b(this.mKernel, findViewById, findViewById2);
        }
        tc.a aVar = this.mRefreshHeader;
        if (aVar != null && aVar.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null && aVar2.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
        return this;
    }

    public tc.f setRefreshFooter(tc.c cVar, int i2, int i3) {
        tc.a aVar;
        tc.a aVar2 = this.mRefreshFooter;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.mRefreshFooter = cVar;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = uc.a.c;
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -2;
        }
        k kVar = new k(i2, i3);
        ViewGroup.LayoutParams layoutParams = cVar.getView().getLayoutParams();
        if (layoutParams instanceof k) {
            kVar = (k) layoutParams;
        }
        if (this.mRefreshFooter.getSpinnerStyle().b) {
            super.addView(this.mRefreshFooter.getView(), getChildCount(), kVar);
        } else {
            super.addView(this.mRefreshFooter.getView(), 0, kVar);
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (aVar = this.mRefreshFooter) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public tc.f setRefreshHeader(tc.d dVar, int i2, int i3) {
        tc.a aVar;
        tc.a aVar2 = this.mRefreshHeader;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.mRefreshHeader = dVar;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = uc.a.c;
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -2;
        }
        k kVar = new k(i2, i3);
        ViewGroup.LayoutParams layoutParams = dVar.getView().getLayoutParams();
        if (layoutParams instanceof k) {
            kVar = (k) layoutParams;
        }
        if (this.mRefreshHeader.getSpinnerStyle().b) {
            super.addView(this.mRefreshHeader.getView(), getChildCount(), kVar);
        } else {
            super.addView(this.mRefreshHeader.getView(), 0, kVar);
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (aVar = this.mRefreshHeader) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public boolean autoLoadMore(int i2, final int i3, final float f2, final boolean z) {
        if (this.mState != uc.b.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.scwang.smart.refresh.layout.b
            @Override // java.lang.Runnable
            public final void run() {
                SmartRefreshLayout.this.i(i3, f2, z);
            }
        };
        setViceState(uc.b.Loading);
        if (i2 > 0) {
            this.mHandler.postDelayed(runnable, i2);
            return true;
        }
        runnable.run();
        return true;
    }

    public boolean autoRefresh(int i2, final int i3, final float f2, final boolean z) {
        if (this.mState != uc.b.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.scwang.smart.refresh.layout.a
            @Override // java.lang.Runnable
            public final void run() {
                SmartRefreshLayout.this.k(i3, f2, z);
            }
        };
        setViceState(uc.b.Refreshing);
        if (i2 > 0) {
            this.mHandler.postDelayed(runnable, i2);
            return true;
        }
        runnable.run();
        return true;
    }

    public tc.f finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    public tc.f finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    public tc.f finishLoadMore(int i2, boolean z, boolean z2) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        e eVar = new e(i3, z2, z);
        if (i4 > 0) {
            this.mHandler.postDelayed(eVar, i4);
        } else {
            eVar.run();
        }
        return this;
    }

    public tc.f finishRefresh(int i2, boolean z, Boolean bool) {
        int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        d dVar = new d(i3, bool, z);
        if (i4 > 0) {
            this.mHandler.postDelayed(dVar, i4);
        } else {
            dVar.run();
        }
        return this;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class k extends ViewGroup.MarginLayoutParams {
        public int a;
        public uc.c b;

        public k(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.a);
            int i = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.b = uc.c.i[obtainStyledAttributes.getInt(i, uc.c.d.a)];
            }
            obtainStyledAttributes.recycle();
        }

        public k(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = null;
        }
    }

    public static void setDefaultRefreshInitializer(vc.d dVar) {
    }

    public tc.f setOnMultiListener(vc.f fVar) {
        return this;
    }
}
