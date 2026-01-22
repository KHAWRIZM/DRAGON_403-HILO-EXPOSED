package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewPowerRankFlipperHolderBindingImpl extends ViewPowerRankFlipperHolderBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.fl_top1, 1);
        sparseIntArray.put(R.id.top1_avatar, 2);
        sparseIntArray.put(R.id.fl_top2, 3);
        sparseIntArray.put(R.id.top2_avatar, 4);
        sparseIntArray.put(R.id.fl_top3, 5);
        sparseIntArray.put(R.id.top3_avatar, 6);
    }

    public ViewPowerRankFlipperHolderBindingImpl(f fVar, View view) {
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

    private ViewPowerRankFlipperHolderBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[5], (PolygonImageView) objArr[2], (PolygonImageView) objArr[4], (PolygonImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
