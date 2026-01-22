package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityBaiShunBindingImpl extends ActivityBaiShunBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.backImageView, 1);
        sparseIntArray.put(2131362013, 2);
        sparseIntArray.put(R.id.moneyLayout, 3);
        sparseIntArray.put(R.id.img, 4);
        sparseIntArray.put(R.id.gemText, 5);
        sparseIntArray.put(2131361922, 6);
        sparseIntArray.put(R.id.gameLayout, 7);
        sparseIntArray.put(R.id.gameLevelImg, 8);
        sparseIntArray.put(R.id.gameText, 9);
        sparseIntArray.put(R.id.statusView, 10);
        sparseIntArray.put(R.id.refreshLayout, 11);
        sparseIntArray.put(2131364510, 12);
    }

    public ActivityBaiShunBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private ActivityBaiShunBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (ImageView) objArr[6], (QMUIRadiusImageView) objArr[2], (AppCompatImageView) objArr[1], (ConstraintLayout) objArr[7], (ImageView) objArr[8], (TextView) objArr[9], (TextView) objArr[5], (ImageView) objArr[4], (ConstraintLayout) objArr[3], (RecyclerView) objArr[12], (SmartRefreshLayout) objArr[11], (SuperStatusView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
