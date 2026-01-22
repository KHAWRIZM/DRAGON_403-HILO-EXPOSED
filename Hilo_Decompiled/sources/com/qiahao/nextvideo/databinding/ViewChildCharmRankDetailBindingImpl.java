package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewChildCharmRankDetailBindingImpl extends ViewChildCharmRankDetailBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 1);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 2);
        sparseIntArray.put(R.id.top3_platform, 3);
        sparseIntArray.put(R.id.ll_top1, 4);
        sparseIntArray.put(R.id.top1_avatar, 5);
        sparseIntArray.put(R.id.icon_vip1, 6);
        sparseIntArray.put(R.id.icon_noble1, 7);
        sparseIntArray.put(R.id.svip1, 8);
        sparseIntArray.put(R.id.top1_name, 9);
        sparseIntArray.put(R.id.top1_id, 10);
        sparseIntArray.put(R.id.ll_diamond1, 11);
        sparseIntArray.put(R.id.top1_diamond, 12);
        sparseIntArray.put(R.id.top_1_medal, 13);
        sparseIntArray.put(R.id.ll_top2, 14);
        sparseIntArray.put(R.id.top2_avatar, 15);
        sparseIntArray.put(R.id.icon_vip2, 16);
        sparseIntArray.put(R.id.icon_noble2, 17);
        sparseIntArray.put(R.id.svip2, 18);
        sparseIntArray.put(R.id.top2_name, 19);
        sparseIntArray.put(R.id.top2_id, 20);
        sparseIntArray.put(R.id.ll_diamond2, 21);
        sparseIntArray.put(R.id.top2_diamond, 22);
        sparseIntArray.put(R.id.top_2_medal, 23);
        sparseIntArray.put(R.id.ll_top3, 24);
        sparseIntArray.put(R.id.top3_avatar, 25);
        sparseIntArray.put(R.id.icon_vip3, 26);
        sparseIntArray.put(R.id.icon_noble3, 27);
        sparseIntArray.put(R.id.svip3, 28);
        sparseIntArray.put(R.id.top3_name, 29);
        sparseIntArray.put(R.id.top3_id, 30);
        sparseIntArray.put(R.id.ll_diamond3, 31);
        sparseIntArray.put(R.id.top3_diamond, 32);
        sparseIntArray.put(R.id.top_3_medal, 33);
        sparseIntArray.put(R.id.recycler_rank, 34);
    }

    public ViewChildCharmRankDetailBindingImpl(f fVar, View view) {
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

    private ViewChildCharmRankDetailBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CollapsingToolbarLayout) objArr[2], (ImageView) objArr[7], (ImageView) objArr[17], (ImageView) objArr[27], (ImageView) objArr[6], (ImageView) objArr[16], (ImageView) objArr[26], (LinearLayout) objArr[11], (LinearLayout) objArr[21], (LinearLayout) objArr[31], (LinearLayout) objArr[4], (LinearLayout) objArr[14], (LinearLayout) objArr[24], (RecyclerView) objArr[34], (SmartRefreshLayout) objArr[1], (ImageView) objArr[8], (ImageView) objArr[18], (ImageView) objArr[28], (HiloImageView) objArr[5], (TextView) objArr[12], (CountryIDView) objArr[10], (MedalGridLayout) objArr[13], (NickTextView) objArr[9], (HiloImageView) objArr[15], (TextView) objArr[22], (CountryIDView) objArr[20], (MedalGridLayout) objArr[23], (NickTextView) objArr[19], (HiloImageView) objArr[25], (TextView) objArr[32], (CountryIDView) objArr[30], (MedalGridLayout) objArr[33], (NickTextView) objArr[29], (ImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
