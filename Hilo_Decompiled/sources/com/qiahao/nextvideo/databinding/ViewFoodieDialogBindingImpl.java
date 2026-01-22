package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.overlayView.CustomOverlayView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.foodie.FoodieBigRewardView;
import com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout;
import com.qiahao.nextvideo.view.RatioImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewFoodieDialogBindingImpl extends ViewFoodieDialogBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.ivMusic, 2);
        sparseIntArray.put(R.id.ivRule, 3);
        sparseIntArray.put(R.id.ivBack, 4);
        sparseIntArray.put(R.id.tvTodayRound, 5);
        sparseIntArray.put(R.id.tvBonus, 6);
        sparseIntArray.put(R.id.ivStage, 7);
        sparseIntArray.put(R.id.rlRanking, 8);
        sparseIntArray.put(R.id.tvRanking, 9);
        sparseIntArray.put(R.id.vLineRank, 10);
        sparseIntArray.put(R.id.tvRankFirst, 11);
        sparseIntArray.put(R.id.ivRankFirstAvatar, 12);
        sparseIntArray.put(R.id.tvRankFirstName, 13);
        sparseIntArray.put(R.id.tvRankValue, 14);
        sparseIntArray.put(R.id.ivRankArrow, 15);
        sparseIntArray.put(R.id.rlResult, 16);
        sparseIntArray.put(R.id.tvResult, 17);
        sparseIntArray.put(R.id.vLineResult, 18);
        sparseIntArray.put(R.id.rvResult, 19);
        sparseIntArray.put(R.id.clBalance, 20);
        sparseIntArray.put(R.id.ivAvatar, 21);
        sparseIntArray.put(R.id.ivAddBalance, 22);
        sparseIntArray.put(R.id.tvName, 23);
        sparseIntArray.put(R.id.ivGoldIcon, 24);
        sparseIntArray.put(R.id.tvBalance, 25);
        sparseIntArray.put(R.id.clRevenue, 26);
        sparseIntArray.put(R.id.tvRevenueTitle, 27);
        sparseIntArray.put(R.id.tvIcon, 28);
        sparseIntArray.put(R.id.tvRevenue, 29);
        sparseIntArray.put(R.id.clHistory, 30);
        sparseIntArray.put(R.id.tvMyHistory, 31);
        sparseIntArray.put(R.id.ivHistoryArrowRight, 32);
        sparseIntArray.put(R.id.ivWood, 33);
        sparseIntArray.put(R.id.tvGameTips, 34);
        sparseIntArray.put(R.id.vegetableRewardView, 35);
        sparseIntArray.put(R.id.meatRewardView, 36);
        sparseIntArray.put(R.id.rvJetton, 37);
        sparseIntArray.put(R.id.ivShelf, 38);
        sparseIntArray.put(R.id.vCenterRef, 39);
        sparseIntArray.put(R.id.foodieWheel, 40);
        sparseIntArray.put(2131364565, 41);
        sparseIntArray.put(R.id.overlay, 42);
    }

    public ViewFoodieDialogBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 43, sIncludes, sViewsWithIds));
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

    private ViewFoodieDialogBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[30], (ConstraintLayout) objArr[26], (ConstraintLayout) objArr[1], (FoodieWheelLayout) objArr[40], (ImageView) objArr[22], (QMUIRadiusImageView) objArr[21], (ImageView) objArr[4], (ImageView) objArr[24], (ImageView) objArr[32], (ImageView) objArr[2], (ImageView) objArr[15], (QMUIRadiusImageView) objArr[12], (ImageView) objArr[3], (ImageView) objArr[38], (RatioImageView) objArr[7], (RatioImageView) objArr[33], (FoodieBigRewardView) objArr[36], (CustomOverlayView) objArr[42], (TextView) objArr[41], (RelativeLayout) objArr[8], (RelativeLayout) objArr[16], (ConstraintLayout) objArr[0], (RecyclerView) objArr[37], (RecyclerView) objArr[19], (TextView) objArr[25], (TextView) objArr[6], (TextView) objArr[34], (ImageView) objArr[28], (TextView) objArr[31], (TextView) objArr[23], (TextView) objArr[11], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[9], (TextView) objArr[17], (TextView) objArr[29], (TextView) objArr[27], (TextView) objArr[5], (View) objArr[39], (View) objArr[10], (View) objArr[18], (FoodieBigRewardView) objArr[35]);
        this.mDirtyFlags = -1L;
        this.root.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
