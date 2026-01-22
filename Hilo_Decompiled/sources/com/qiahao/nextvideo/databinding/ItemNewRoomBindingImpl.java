package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemNewRoomBindingImpl extends ItemNewRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(R.id.headTopBg, 2);
        sparseIntArray.put(R.id.headButtonBg, 3);
        sparseIntArray.put(R.id.hot, 4);
        sparseIntArray.put(R.id.gameIcon, 5);
        sparseIntArray.put(R.id.oneAvatar, 6);
        sparseIntArray.put(R.id.twoAvatar, 7);
        sparseIntArray.put(R.id.threeAvatar, 8);
        sparseIntArray.put(R.id.number, 9);
        sparseIntArray.put(R.id.hotNumber, 10);
        sparseIntArray.put(R.id.flowIcon, 11);
        sparseIntArray.put(R.id.countryIcon, 12);
        sparseIntArray.put(2131364012, 13);
        sparseIntArray.put(R.id.des, 14);
    }

    public ItemNewRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 15, sIncludes, sViewsWithIds));
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

    private ItemNewRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (ImageView) objArr[12], (TextView) objArr[14], (ImageView) objArr[11], (ImageView) objArr[5], (View) objArr[3], (View) objArr[2], (ImageView) objArr[4], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[9], (QMUIRadiusImageView) objArr[6], (QMUIRadiusImageView) objArr[8], (RoundCornerImageView) objArr[1], (QMUIRadiusImageView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.constraint.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
