package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentPopularBindingImpl extends FragmentPopularBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.common_id_content_container, 1);
        sparseIntArray.put(2131365217, 2);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 3);
        sparseIntArray.put(R.id.bannerView, 4);
        sparseIntArray.put(R.id.statusView, 5);
        sparseIntArray.put(2131364510, 6);
    }

    public FragmentPopularBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
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

    private FragmentPopularBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (BannerViewPager) objArr[4], (CollapsingToolbarLayout) objArr[3], (CoordinatorLayout) objArr[1], (RecyclerView) objArr[6], (SmartRefreshLayout) objArr[0], (SuperStatusView) objArr[5], (AppBarLayout) objArr[2]);
        this.mDirtyFlags = -1L;
        this.refreshLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
