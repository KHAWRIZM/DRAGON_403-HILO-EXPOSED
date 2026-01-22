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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RoomButtonPkBindingImpl extends RoomButtonPkBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.redPro, 1);
        sparseIntArray.put(R.id.bluePro, 2);
        sparseIntArray.put(R.id.redFire, 3);
        sparseIntArray.put(R.id.redNumber, 4);
        sparseIntArray.put(R.id.blueFire, 5);
        sparseIntArray.put(R.id.blueNumber, 6);
        sparseIntArray.put(R.id.buttonBg, 7);
        sparseIntArray.put(R.id.fireSVGA, 8);
        sparseIntArray.put(R.id.redThreeBg, 9);
        sparseIntArray.put(R.id.redThree, 10);
        sparseIntArray.put(R.id.redTwoBg, 11);
        sparseIntArray.put(R.id.redTwo, 12);
        sparseIntArray.put(R.id.redOneBg, 13);
        sparseIntArray.put(R.id.redOne, 14);
        sparseIntArray.put(R.id.blueThreeBg, 15);
        sparseIntArray.put(R.id.blueThree, 16);
        sparseIntArray.put(R.id.blueTwoBg, 17);
        sparseIntArray.put(R.id.blueTwo, 18);
        sparseIntArray.put(R.id.blueOneBg, 19);
        sparseIntArray.put(R.id.blueOne, 20);
        sparseIntArray.put(R.id.redClick, 21);
        sparseIntArray.put(R.id.blueClick, 22);
        sparseIntArray.put(R.id.chestSVGA, 23);
        sparseIntArray.put(R.id.level, 24);
    }

    public RoomButtonPkBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
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

    private RoomButtonPkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[22], (ImageView) objArr[5], (TextView) objArr[6], (QMUIRadiusImageView) objArr[20], (ImageView) objArr[19], (View) objArr[2], (QMUIRadiusImageView) objArr[16], (ImageView) objArr[15], (QMUIRadiusImageView) objArr[18], (ImageView) objArr[17], (View) objArr[7], (ImageView) objArr[23], (ImageView) objArr[8], (TextView) objArr[24], (View) objArr[21], (ImageView) objArr[3], (TextView) objArr[4], (QMUIRadiusImageView) objArr[14], (ImageView) objArr[13], (View) objArr[1], (QMUIRadiusImageView) objArr[10], (ImageView) objArr[9], (QMUIRadiusImageView) objArr[12], (ImageView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
