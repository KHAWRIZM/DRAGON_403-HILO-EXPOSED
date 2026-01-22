package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.view.d1;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SlideSelectTouchListener implements RecyclerView.OnItemTouchListener {
    private boolean isActive;
    private int mBottomBoundFrom;
    private int mBottomBoundTo;
    private int mEnd;
    private int mHeaderViewCount;
    private boolean mInBottomSpot;
    private boolean mInTopSpot;
    private int mLastEnd;
    private int mLastStart;
    private float mLastX;
    private float mLastY;
    private RecyclerView mRecyclerView;
    private int mScrollDistance;
    private OverScroller mScroller;
    private OnSlideSelectListener mSelectListener;
    private int mStart;
    private int mTopBoundFrom;
    private int mTopBoundTo;
    private final Runnable mScrollRunnable = new Runnable() { // from class: com.luck.picture.lib.widget.SlideSelectTouchListener.1
        @Override // java.lang.Runnable
        public void run() {
            if (SlideSelectTouchListener.this.mScroller != null && SlideSelectTouchListener.this.mScroller.computeScrollOffset()) {
                SlideSelectTouchListener slideSelectTouchListener = SlideSelectTouchListener.this;
                slideSelectTouchListener.scrollBy(slideSelectTouchListener.mScrollDistance);
                d1.i0(SlideSelectTouchListener.this.mRecyclerView, SlideSelectTouchListener.this.mScrollRunnable);
            }
        }
    };
    private int mMaxScrollDistance = 16;
    private int mAutoScrollDistance = (int) (Resources.getSystem().getDisplayMetrics().density * 56.0f);
    private int mTouchRegionTopOffset = 0;
    private int mTouchRegionBottomOffset = 0;
    private boolean mScrollAboveTopRegion = true;
    private boolean mScrollBelowTopRegion = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface OnAdvancedSlideSelectListener extends OnSlideSelectListener {
        void onSelectionFinished(int i10);

        void onSelectionStarted(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface OnSlideSelectListener {
        void onSelectChange(int i10, int i11, boolean z10);
    }

    public SlideSelectTouchListener() {
        reset();
    }

    private void changeSelectedRange(RecyclerView recyclerView, MotionEvent motionEvent) {
        changeSelectedRange(recyclerView, motionEvent.getX(), motionEvent.getY());
    }

    private void initScroller(Context context) {
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(context, new LinearInterpolator());
        }
    }

    private void notifySelectRangeChange() {
        int i10;
        int i11;
        if (this.mSelectListener != null && (i10 = this.mStart) != -1 && (i11 = this.mEnd) != -1) {
            int min = Math.min(i10, i11);
            int max = Math.max(this.mStart, this.mEnd);
            if (min < 0) {
                return;
            }
            int i12 = this.mLastStart;
            if (i12 != -1 && this.mLastEnd != -1) {
                if (min > i12) {
                    this.mSelectListener.onSelectChange(i12, min - 1, false);
                } else if (min < i12) {
                    this.mSelectListener.onSelectChange(min, i12 - 1, true);
                }
                int i13 = this.mLastEnd;
                if (max > i13) {
                    this.mSelectListener.onSelectChange(i13 + 1, max, true);
                } else if (max < i13) {
                    this.mSelectListener.onSelectChange(max + 1, i13, false);
                }
            } else if (max - min == 1) {
                this.mSelectListener.onSelectChange(min, min, true);
            } else {
                this.mSelectListener.onSelectChange(min, max, true);
            }
            this.mLastStart = min;
            this.mLastEnd = max;
        }
    }

    private void processAutoScroll(MotionEvent motionEvent) {
        int y10 = (int) motionEvent.getY();
        int i10 = this.mTopBoundFrom;
        if (y10 >= i10 && y10 <= this.mTopBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            int i11 = this.mTopBoundTo;
            int i12 = this.mTopBoundFrom;
            this.mScrollDistance = (int) (this.mMaxScrollDistance * (((i11 - i12) - (y10 - i12)) / (i11 - i12)) * (-1.0f));
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
                return;
            }
            return;
        }
        if (this.mScrollAboveTopRegion && y10 < i10) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance * (-1);
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
                return;
            }
            return;
        }
        if (y10 >= this.mBottomBoundFrom && y10 <= this.mBottomBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            float f10 = y10;
            int i13 = this.mBottomBoundFrom;
            this.mScrollDistance = (int) (this.mMaxScrollDistance * ((f10 - i13) / (this.mBottomBoundTo - i13)));
            if (!this.mInBottomSpot) {
                this.mInBottomSpot = true;
                startAutoScroll();
                return;
            }
            return;
        }
        if (this.mScrollBelowTopRegion && y10 > this.mBottomBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance;
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
                return;
            }
            return;
        }
        this.mInBottomSpot = false;
        this.mInTopSpot = false;
        this.mLastX = Float.MIN_VALUE;
        this.mLastY = Float.MIN_VALUE;
        stopAutoScroll();
    }

    private void reset() {
        setActive(false);
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionFinished(this.mEnd);
        }
        this.mStart = -1;
        this.mEnd = -1;
        this.mLastStart = -1;
        this.mLastEnd = -1;
        this.mInTopSpot = false;
        this.mInBottomSpot = false;
        this.mLastX = Float.MIN_VALUE;
        this.mLastY = Float.MIN_VALUE;
        stopAutoScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollBy(int i10) {
        int max;
        if (i10 > 0) {
            max = Math.min(i10, this.mMaxScrollDistance);
        } else {
            max = Math.max(i10, -this.mMaxScrollDistance);
        }
        this.mRecyclerView.scrollBy(0, max);
        float f10 = this.mLastX;
        if (f10 != Float.MIN_VALUE) {
            float f11 = this.mLastY;
            if (f11 != Float.MIN_VALUE) {
                changeSelectedRange(this.mRecyclerView, f10, f11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.isActive && recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() != 0) {
            int action = motionEvent.getAction();
            if (action == 0 || action == 5) {
                reset();
            }
            this.mRecyclerView = recyclerView;
            int height = recyclerView.getHeight();
            int i10 = this.mTouchRegionTopOffset;
            this.mTopBoundFrom = i10;
            int i11 = this.mAutoScrollDistance;
            this.mTopBoundTo = i10 + i11;
            int i12 = this.mTouchRegionBottomOffset;
            this.mBottomBoundFrom = (height + i12) - i11;
            this.mBottomBoundTo = height + i12;
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.isActive) {
            reset();
            return;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action != 2) {
                if (action != 3 && action != 6) {
                    return;
                }
            } else {
                if (!this.mInTopSpot && !this.mInBottomSpot) {
                    changeSelectedRange(recyclerView, motionEvent);
                }
                processAutoScroll(motionEvent);
                return;
            }
        }
        reset();
    }

    public void setActive(boolean z10) {
        this.isActive = z10;
    }

    public SlideSelectTouchListener setRecyclerViewHeaderCount(int i10) {
        this.mHeaderViewCount = i10;
        return this;
    }

    public void startAutoScroll() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        initScroller(recyclerView.getContext());
        if (this.mScroller.isFinished()) {
            this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
            OverScroller overScroller = this.mScroller;
            overScroller.startScroll(0, overScroller.getCurrY(), 0, 5000, 100000);
            d1.i0(this.mRecyclerView, this.mScrollRunnable);
        }
    }

    public void startSlideSelection(int i10) {
        setActive(true);
        this.mStart = i10;
        this.mEnd = i10;
        this.mLastStart = i10;
        this.mLastEnd = i10;
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionStarted(i10);
        }
    }

    public void stopAutoScroll() {
        try {
            OverScroller overScroller = this.mScroller;
            if (overScroller != null && !overScroller.isFinished()) {
                this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
                this.mScroller.abortAnimation();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public SlideSelectTouchListener withBottomOffset(int i10) {
        this.mTouchRegionBottomOffset = i10;
        return this;
    }

    public SlideSelectTouchListener withMaxScrollDistance(int i10) {
        this.mMaxScrollDistance = i10;
        return this;
    }

    public SlideSelectTouchListener withScrollAboveTopRegion(boolean z10) {
        this.mScrollAboveTopRegion = z10;
        return this;
    }

    public SlideSelectTouchListener withScrollBelowTopRegion(boolean z10) {
        this.mScrollBelowTopRegion = z10;
        return this;
    }

    public SlideSelectTouchListener withSelectListener(OnSlideSelectListener onSlideSelectListener) {
        this.mSelectListener = onSlideSelectListener;
        return this;
    }

    public SlideSelectTouchListener withTopOffset(int i10) {
        this.mTouchRegionTopOffset = i10;
        return this;
    }

    public SlideSelectTouchListener withTouchRegion(int i10) {
        this.mAutoScrollDistance = i10;
        return this;
    }

    private void changeSelectedRange(RecyclerView recyclerView, float f10, float f11) {
        int childAdapterPosition;
        View findChildViewUnder = recyclerView.findChildViewUnder(f10, f11);
        if (findChildViewUnder == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(findChildViewUnder) - this.mHeaderViewCount) == -1 || this.mEnd == childAdapterPosition) {
            return;
        }
        this.mEnd = childAdapterPosition;
        notifySelectRangeChange();
    }
}
