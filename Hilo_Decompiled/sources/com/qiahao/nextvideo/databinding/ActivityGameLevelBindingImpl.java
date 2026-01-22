package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGameLevelBindingImpl extends ActivityGameLevelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.appbar, 2);
        sparseIntArray.put(R.id.top_bg, 3);
        sparseIntArray.put(R.id.buttonBg, 4);
        sparseIntArray.put(R.id.bannerView, 5);
        sparseIntArray.put(R.id.svipPrivileges, 6);
        sparseIntArray.put(R.id.collapse_toolbar, 7);
        sparseIntArray.put(R.id.backImageView, 8);
        sparseIntArray.put(2131365189, 9);
        sparseIntArray.put(R.id.help, 10);
        sparseIntArray.put(2131364510, 11);
    }

    public ActivityGameLevelBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private ActivityGameLevelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppBarLayout) objArr[2], (AppCompatImageView) objArr[8], (BannerViewPager) objArr[5], (ImageView) objArr[4], (Toolbar) objArr[7], (CoordinatorLayout) objArr[1], (AppCompatImageView) objArr[10], (RecyclerView) objArr[11], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[9], (ImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
