package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityCountryBindingImpl extends ActivityCountryBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 1);
        sparseIntArray.put(R.id.back_image_view, 2);
        sparseIntArray.put(2131365189, 3);
        sparseIntArray.put(R.id.ic_question, 4);
        sparseIntArray.put(R.id.common_id_swipe_refresh_layout, 5);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 6);
        sparseIntArray.put(R.id.ll_top1, 7);
        sparseIntArray.put(R.id.topContainer1, 8);
        sparseIntArray.put(R.id.top1_avatar, 9);
        sparseIntArray.put(R.id.icon_vip1, 10);
        sparseIntArray.put(R.id.icon_noble1, 11);
        sparseIntArray.put(R.id.svip1, 12);
        sparseIntArray.put(R.id.top1_name, 13);
        sparseIntArray.put(R.id.top1_id, 14);
        sparseIntArray.put(R.id.top1_medal, 15);
        sparseIntArray.put(R.id.ll_top2, 16);
        sparseIntArray.put(R.id.topContainer2, 17);
        sparseIntArray.put(R.id.top2_avatar, 18);
        sparseIntArray.put(R.id.icon_vip2, 19);
        sparseIntArray.put(R.id.icon_noble2, 20);
        sparseIntArray.put(R.id.svip2, 21);
        sparseIntArray.put(R.id.top2_name, 22);
        sparseIntArray.put(R.id.top2_id, 23);
        sparseIntArray.put(R.id.top2_medal, 24);
        sparseIntArray.put(R.id.ll_top3, 25);
        sparseIntArray.put(R.id.topContainer3, 26);
        sparseIntArray.put(R.id.top3_avatar, 27);
        sparseIntArray.put(R.id.icon_vip3, 28);
        sparseIntArray.put(R.id.icon_noble3, 29);
        sparseIntArray.put(R.id.svip3, 30);
        sparseIntArray.put(R.id.top3_name, 31);
        sparseIntArray.put(R.id.top3_id, 32);
        sparseIntArray.put(R.id.top3_medal, 33);
        sparseIntArray.put(R.id.statusView, 34);
        sparseIntArray.put(R.id.common_id_recycler_view, 35);
        sparseIntArray.put(R.id.empty_tip_text_view, 36);
    }

    public ActivityCountryBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 37, sIncludes, sViewsWithIds));
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

    private ActivityCountryBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[2], (CollapsingToolbarLayout) objArr[6], (RecyclerView) objArr[35], (SmartRefreshLayout) objArr[5], (AppCompatTextView) objArr[36], (ImageView) objArr[4], (ImageView) objArr[11], (ImageView) objArr[20], (ImageView) objArr[29], (ImageView) objArr[10], (ImageView) objArr[19], (ImageView) objArr[28], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[16], (ConstraintLayout) objArr[25], (SuperStatusView) objArr[34], (ImageView) objArr[12], (ImageView) objArr[21], (ImageView) objArr[30], (AppCompatTextView) objArr[3], (Toolbar) objArr[1], (HiloImageView) objArr[9], (ShineTextView) objArr[14], (MedalGridLayout) objArr[15], (TextView) objArr[13], (HiloImageView) objArr[18], (ShineTextView) objArr[23], (MedalGridLayout) objArr[24], (TextView) objArr[22], (HiloImageView) objArr[27], (ShineTextView) objArr[32], (MedalGridLayout) objArr[33], (TextView) objArr[31], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[17], (ConstraintLayout) objArr[26]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
