package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewChildCpRankDetailBindingImpl extends ViewChildCpRankDetailBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 1);
        sparseIntArray.put(R.id.ll_top1, 2);
        sparseIntArray.put(R.id.heart_bg, 3);
        sparseIntArray.put(R.id.top1_cp1_avatar, 4);
        sparseIntArray.put(R.id.top1_cp1_bg, 5);
        sparseIntArray.put(R.id.top1_cp1_vip, 6);
        sparseIntArray.put(R.id.top1_cp1_noble, 7);
        sparseIntArray.put(R.id.top1_cp1_user_name, 8);
        sparseIntArray.put(R.id.top1_cp1_medal, 9);
        sparseIntArray.put(R.id.top1_cp2_avatar, 10);
        sparseIntArray.put(R.id.top1_cp2_bg, 11);
        sparseIntArray.put(R.id.top1_cp2_vip, 12);
        sparseIntArray.put(R.id.top1_cp2_noble, 13);
        sparseIntArray.put(R.id.top1_cp2_user_name, 14);
        sparseIntArray.put(R.id.top1_cp2_medal, 15);
        sparseIntArray.put(R.id.top1_cp_value, 16);
        sparseIntArray.put(R.id.ll_top2, 17);
        sparseIntArray.put(R.id.heart_bg2, 18);
        sparseIntArray.put(R.id.top2_cp1_avatar, 19);
        sparseIntArray.put(R.id.top2_cp1_bg, 20);
        sparseIntArray.put(R.id.top2_cp1_vip, 21);
        sparseIntArray.put(R.id.top2_cp1_noble, 22);
        sparseIntArray.put(R.id.top2_cp1_user_name, 23);
        sparseIntArray.put(R.id.top2_cp1_medal, 24);
        sparseIntArray.put(R.id.top2_cp2_avatar, 25);
        sparseIntArray.put(R.id.top2_cp2_bg, 26);
        sparseIntArray.put(R.id.top2_cp2_vip, 27);
        sparseIntArray.put(R.id.top2_cp2_noble, 28);
        sparseIntArray.put(R.id.top2_cp2_user_name, 29);
        sparseIntArray.put(R.id.top2_cp2_medal, 30);
        sparseIntArray.put(R.id.top2_cp_value, 31);
        sparseIntArray.put(R.id.ll_top3, 32);
        sparseIntArray.put(R.id.heart_bg3, 33);
        sparseIntArray.put(R.id.top3_cp1_avatar, 34);
        sparseIntArray.put(R.id.top3_cp1_bg, 35);
        sparseIntArray.put(R.id.top3_cp1_vip, 36);
        sparseIntArray.put(R.id.top3_cp1_noble, 37);
        sparseIntArray.put(R.id.top3_cp1_user_name, 38);
        sparseIntArray.put(R.id.top3_cp1_medal, 39);
        sparseIntArray.put(R.id.top3_cp2_avatar, 40);
        sparseIntArray.put(R.id.top3_cp2_bg, 41);
        sparseIntArray.put(R.id.top3_cp2_vip, 42);
        sparseIntArray.put(R.id.top3_cp2_user_name, 43);
        sparseIntArray.put(R.id.top3_cp2_noble, 44);
        sparseIntArray.put(R.id.top3_cp2_medal, 45);
        sparseIntArray.put(R.id.top3_cp_value, 46);
        sparseIntArray.put(R.id.recycler_rank, 47);
        sparseIntArray.put(R.id.empty_tip_text_view, 48);
    }

    public ViewChildCpRankDetailBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 49, sIncludes, sViewsWithIds));
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

    private ViewChildCpRankDetailBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatTextView) objArr[48], (SVGAImageView) objArr[3], (SVGAImageView) objArr[18], (SVGAImageView) objArr[33], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[17], (ConstraintLayout) objArr[32], (RecyclerView) objArr[47], (SmartRefreshLayout) objArr[1], (HiloImageView) objArr[4], (ImageView) objArr[5], (MedalGridLayout) objArr[9], (ImageView) objArr[7], (TextView) objArr[8], (ImageView) objArr[6], (HiloImageView) objArr[10], (ImageView) objArr[11], (MedalGridLayout) objArr[15], (ImageView) objArr[13], (TextView) objArr[14], (ImageView) objArr[12], (TextView) objArr[16], (HiloImageView) objArr[19], (ImageView) objArr[20], (MedalGridLayout) objArr[24], (ImageView) objArr[22], (TextView) objArr[23], (ImageView) objArr[21], (HiloImageView) objArr[25], (ImageView) objArr[26], (MedalGridLayout) objArr[30], (ImageView) objArr[28], (TextView) objArr[29], (ImageView) objArr[27], (TextView) objArr[31], (HiloImageView) objArr[34], (ImageView) objArr[35], (MedalGridLayout) objArr[39], (ImageView) objArr[37], (TextView) objArr[38], (ImageView) objArr[36], (HiloImageView) objArr[40], (ImageView) objArr[41], (MedalGridLayout) objArr[45], (ImageView) objArr[44], (TextView) objArr[43], (ImageView) objArr[42], (TextView) objArr[46]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
