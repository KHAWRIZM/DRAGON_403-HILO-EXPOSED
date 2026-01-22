package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeGameBindingImpl extends FragmentHomeGameBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(R.id.moneyLayout, 2);
        sparseIntArray.put(R.id.diamond, 3);
        sparseIntArray.put(R.id.diamondText, 4);
        sparseIntArray.put(2131361922, 5);
        sparseIntArray.put(R.id.statusView, 6);
        sparseIntArray.put(R.id.refreshLayout, 7);
        sparseIntArray.put(2131364510, 8);
        sparseIntArray.put(R.id.chest, 9);
        sparseIntArray.put(R.id.bannerBroadcast, 10);
    }

    public FragmentHomeGameBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 11, sIncludes, sViewsWithIds));
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

    private FragmentHomeGameBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[5], (BannerViewPager) objArr[10], (ImageView) objArr[9], (ImageView) objArr[3], (TextView) objArr[4], (ConstraintLayout) objArr[2], (RecyclerView) objArr[8], (SmartRefreshLayout) objArr[7], (ConstraintLayout) objArr[0], (SuperStatusView) objArr[6], (ImageView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.rootContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
