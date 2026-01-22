package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class LayoutPowerRankWeekBindingImpl extends LayoutPowerRankWeekBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 1);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 2);
        sparseIntArray.put(R.id.ll_top1, 3);
        sparseIntArray.put(R.id.top1_avatar, 4);
        sparseIntArray.put(R.id.icon_vip1, 5);
        sparseIntArray.put(R.id.icon_noble1, 6);
        sparseIntArray.put(R.id.svip1, 7);
        sparseIntArray.put(R.id.top1_name, 8);
        sparseIntArray.put(R.id.top1_id, 9);
        sparseIntArray.put(R.id.ll_diamond1, 10);
        sparseIntArray.put(R.id.top1_diamond, 11);
        sparseIntArray.put(R.id.top_1_medal, 12);
        sparseIntArray.put(R.id.ll_top2, 13);
        sparseIntArray.put(R.id.top2_avatar, 14);
        sparseIntArray.put(R.id.icon_vip2, 15);
        sparseIntArray.put(R.id.icon_noble2, 16);
        sparseIntArray.put(R.id.svip2, 17);
        sparseIntArray.put(R.id.top2_name, 18);
        sparseIntArray.put(R.id.top2_id, 19);
        sparseIntArray.put(R.id.ll_diamond2, 20);
        sparseIntArray.put(R.id.top2_diamond, 21);
        sparseIntArray.put(R.id.top_2_medal, 22);
        sparseIntArray.put(R.id.ll_top3, 23);
        sparseIntArray.put(R.id.top3_avatar, 24);
        sparseIntArray.put(R.id.icon_vip3, 25);
        sparseIntArray.put(R.id.icon_noble3, 26);
        sparseIntArray.put(R.id.svip3, 27);
        sparseIntArray.put(R.id.top3_name, 28);
        sparseIntArray.put(R.id.top3_id, 29);
        sparseIntArray.put(R.id.ll_diamond3, 30);
        sparseIntArray.put(R.id.top3_diamond, 31);
        sparseIntArray.put(R.id.top_3_medal, 32);
        sparseIntArray.put(R.id.recycler_view, 33);
        sparseIntArray.put(R.id.empty_tip_text_view, 34);
    }

    public LayoutPowerRankWeekBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 35, sIncludes, sViewsWithIds));
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

    private LayoutPowerRankWeekBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CollapsingToolbarLayout) objArr[2], (AppCompatTextView) objArr[34], (ImageView) objArr[6], (ImageView) objArr[16], (ImageView) objArr[26], (ImageView) objArr[5], (ImageView) objArr[15], (ImageView) objArr[25], (LinearLayout) objArr[10], (LinearLayout) objArr[20], (LinearLayout) objArr[30], (LinearLayout) objArr[3], (LinearLayout) objArr[13], (LinearLayout) objArr[23], (RecyclerView) objArr[33], (SmartRefreshLayout) objArr[1], (ImageView) objArr[7], (ImageView) objArr[17], (ImageView) objArr[27], (CircleImageView) objArr[4], (TextView) objArr[11], (ShineTextView) objArr[9], (MedalGridLayout) objArr[12], (TextView) objArr[8], (CircleImageView) objArr[14], (TextView) objArr[21], (ShineTextView) objArr[19], (MedalGridLayout) objArr[22], (TextView) objArr[18], (CircleImageView) objArr[24], (TextView) objArr[31], (ShineTextView) objArr[29], (MedalGridLayout) objArr[32], (TextView) objArr[28]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
