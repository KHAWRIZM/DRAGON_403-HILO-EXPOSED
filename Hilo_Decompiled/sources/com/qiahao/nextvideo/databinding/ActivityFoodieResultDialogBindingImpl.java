package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityFoodieResultDialogBindingImpl extends ActivityFoodieResultDialogBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.frameLayout, 1);
        sparseIntArray.put(R.id.tvRound, 2);
        sparseIntArray.put(R.id.tvCountDown, 3);
        sparseIntArray.put(R.id.ivResult, 4);
        sparseIntArray.put(R.id.ivFork, 5);
        sparseIntArray.put(R.id.ivKnife, 6);
        sparseIntArray.put(R.id.ivDog, 7);
        sparseIntArray.put(R.id.ivLongSilk, 8);
        sparseIntArray.put(R.id.tvTipsReward, 9);
        sparseIntArray.put(R.id.tvReward, 10);
        sparseIntArray.put(R.id.tvTipsBet, 11);
        sparseIntArray.put(R.id.tvBet, 12);
        sparseIntArray.put(R.id.tvRankingTips, 13);
        sparseIntArray.put(R.id.ivStartSilk, 14);
        sparseIntArray.put(R.id.ivEndSilk, 15);
        sparseIntArray.put(R.id.clGoldPlace, 16);
        sparseIntArray.put(R.id.civGoldAvatar, 17);
        sparseIntArray.put(R.id.ivGoldCrown, 18);
        sparseIntArray.put(R.id.ivGoldBrand, 19);
        sparseIntArray.put(R.id.tvGoldTag, 20);
        sparseIntArray.put(R.id.tvGoldName, 21);
        sparseIntArray.put(R.id.tvGoldRank, 22);
        sparseIntArray.put(R.id.clSilverPlace, 23);
        sparseIntArray.put(R.id.civSilverAvatar, 24);
        sparseIntArray.put(R.id.ivSilverCrown, 25);
        sparseIntArray.put(R.id.ivSilverBrand, 26);
        sparseIntArray.put(R.id.tvSilverTag, 27);
        sparseIntArray.put(R.id.tvSilverName, 28);
        sparseIntArray.put(R.id.tvSilverRank, 29);
        sparseIntArray.put(R.id.clBronzePlace, 30);
        sparseIntArray.put(R.id.civBronzeAvatar, 31);
        sparseIntArray.put(R.id.ivBronzeCrown, 32);
        sparseIntArray.put(R.id.ivBronzeBrand, 33);
        sparseIntArray.put(R.id.tvBronzeTag, 34);
        sparseIntArray.put(R.id.tvBronzeName, 35);
        sparseIntArray.put(R.id.tvBronzeRank, 36);
        sparseIntArray.put(R.id.svgaImageView, 37);
    }

    public ActivityFoodieResultDialogBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 38, sIncludes, sViewsWithIds));
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

    private ActivityFoodieResultDialogBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[31], (QMUIRadiusImageView) objArr[17], (QMUIRadiusImageView) objArr[24], (ConstraintLayout) objArr[30], (ConstraintLayout) objArr[16], (ConstraintLayout) objArr[23], (FrameLayout) objArr[1], (ImageView) objArr[33], (ImageView) objArr[32], (ImageView) objArr[7], (ImageView) objArr[15], (ImageView) objArr[5], (ImageView) objArr[19], (ImageView) objArr[18], (ImageView) objArr[6], (ImageView) objArr[8], (ImageView) objArr[4], (ImageView) objArr[26], (ImageView) objArr[25], (ImageView) objArr[14], (FrameLayout) objArr[0], (SVGAImageView) objArr[37], (TextView) objArr[12], (TextView) objArr[35], (TextView) objArr[36], (TextView) objArr[34], (TextView) objArr[3], (TextView) objArr[21], (TextView) objArr[22], (TextView) objArr[20], (TextView) objArr[13], (TextView) objArr[10], (TextView) objArr[2], (TextView) objArr[28], (TextView) objArr[29], (TextView) objArr[27], (TextView) objArr[11], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.parentContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
