package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivitySvipBindingImpl extends ActivitySvipBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362438, 1);
        sparseIntArray.put(R.id.appbar, 2);
        sparseIntArray.put(R.id.top_bg, 3);
        sparseIntArray.put(R.id.bannerView, 4);
        sparseIntArray.put(R.id.svipPrivileges, 5);
        sparseIntArray.put(R.id.svipNumber, 6);
        sparseIntArray.put(R.id.gift_1_container, 7);
        sparseIntArray.put(R.id.iv_gift_1, 8);
        sparseIntArray.put(R.id.tv_gift_number_1, 9);
        sparseIntArray.put(R.id.tv_gift_title_1, 10);
        sparseIntArray.put(R.id.tv_gift_collection_time_1, 11);
        sparseIntArray.put(R.id.tv_gift_sub_title_1, 12);
        sparseIntArray.put(R.id.gift_2_container, 13);
        sparseIntArray.put(R.id.iv_gift_2, 14);
        sparseIntArray.put(R.id.tv_gift_number_2, 15);
        sparseIntArray.put(R.id.tv_gift_title_2, 16);
        sparseIntArray.put(R.id.tv_gift_collection_time_2, 17);
        sparseIntArray.put(R.id.tv_gift_sub_title_2, 18);
        sparseIntArray.put(R.id.gift_3_container, 19);
        sparseIntArray.put(R.id.iv_gift_3, 20);
        sparseIntArray.put(R.id.tv_gift_number_3, 21);
        sparseIntArray.put(R.id.tv_gift_title_3, 22);
        sparseIntArray.put(R.id.tv_gift_collection_time_3, 23);
        sparseIntArray.put(R.id.tv_gift_sub_title_3, 24);
        sparseIntArray.put(R.id.gift_3_receive_btn, 25);
        sparseIntArray.put(R.id.collapse_toolbar, 26);
        sparseIntArray.put(R.id.backImageView, 27);
        sparseIntArray.put(2131365189, 28);
        sparseIntArray.put(R.id.help, 29);
        sparseIntArray.put(2131364510, 30);
    }

    public ActivitySvipBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivitySvipBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppBarLayout) objArr[2], (AppCompatImageView) objArr[27], (BannerViewPager) objArr[4], (Toolbar) objArr[26], (CoordinatorLayout) objArr[1], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[13], (ConstraintLayout) objArr[19], (TextView) objArr[25], (AppCompatImageView) objArr[29], (SVGAImageView) objArr[8], (SVGAImageView) objArr[14], (SVGAImageView) objArr[20], (RecyclerView) objArr[30], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[5], (AppCompatTextView) objArr[28], (SVGAImageView) objArr[3], (TextView) objArr[11], (TextView) objArr[17], (TextView) objArr[23], (TextView) objArr[9], (TextView) objArr[15], (TextView) objArr[21], (TextView) objArr[12], (TextView) objArr[18], (TextView) objArr[24], (TextView) objArr[10], (TextView) objArr[16], (TextView) objArr[22]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
