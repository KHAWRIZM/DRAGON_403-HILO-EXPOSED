package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ViewPagerLayoutManager extends LinearLayoutManager {
    private static final String TAG = "ViewPagerLayoutManager";
    private RecyclerView.OnChildAttachStateChangeListener mChildAttachStateChangeListener;
    private int mDrift;
    private boolean mIsLeftScroll;
    private OnViewPagerListener mOnViewPagerListener;
    private PagerSnapHelper mPagerSnapHelper;
    private RecyclerView mRecyclerView;

    public ViewPagerLayoutManager(Context context, int i) {
        super(context, i, false);
        this.mIsLeftScroll = false;
        this.mChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ViewPagerLayoutManager.1
            public void onChildViewAttachedToWindow(View view) {
                if (ViewPagerLayoutManager.this.mOnViewPagerListener != null && ViewPagerLayoutManager.this.getChildCount() == 1) {
                    ViewPagerLayoutManager.this.mOnViewPagerListener.onInitComplete();
                }
            }

            public void onChildViewDetachedFromWindow(View view) {
                if (ViewPagerLayoutManager.this.mDrift >= 0) {
                    if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                        ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(true, ViewPagerLayoutManager.this.getPosition(view));
                    }
                } else if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                    ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(false, ViewPagerLayoutManager.this.getPosition(view));
                }
            }
        };
        init();
    }

    private void init() {
        this.mPagerSnapHelper = new PagerSnapHelper();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onAttachedToWindow(recyclerView);
        this.mPagerSnapHelper.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnChildAttachStateChangeListener(this.mChildAttachStateChangeListener);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            int position = getPosition(this.mPagerSnapHelper.findSnapView(this));
            if (this.mOnViewPagerListener != null) {
                boolean z = true;
                if (getChildCount() == 1) {
                    OnViewPagerListener onViewPagerListener = this.mOnViewPagerListener;
                    if (position != getItemCount() - 1) {
                        z = false;
                    }
                    onViewPagerListener.onPageSelected(position, z, this.mIsLeftScroll);
                }
            }
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (i <= 0) {
            this.mIsLeftScroll = true;
        } else {
            this.mIsLeftScroll = false;
        }
        this.mDrift = i;
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = i;
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setOnViewPagerListener(OnViewPagerListener onViewPagerListener) {
        this.mOnViewPagerListener = onViewPagerListener;
    }
}
