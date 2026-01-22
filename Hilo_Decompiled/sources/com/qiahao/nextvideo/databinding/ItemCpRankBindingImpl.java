package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemCpRankBindingImpl extends ItemCpRankBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.list_position, 1);
        sparseIntArray.put(R.id.user1_avatar_cimage_view, 2);
        sparseIntArray.put(R.id.icon_vip_1, 3);
        sparseIntArray.put(R.id.icon_noble_1, 4);
        sparseIntArray.put(R.id.user2_avatar_cimage_view, 5);
        sparseIntArray.put(R.id.icon_vip_2, 6);
        sparseIntArray.put(R.id.icon_noble_2, 7);
        sparseIntArray.put(R.id.user1_name, 8);
        sparseIntArray.put(R.id.user1_medal, 9);
        sparseIntArray.put(R.id.user2_name, 10);
        sparseIntArray.put(R.id.user2_medal, 11);
        sparseIntArray.put(R.id.ll_diamond, 12);
        sparseIntArray.put(R.id.cp_value, 13);
    }

    public ItemCpRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private ItemCpRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[13], (ImageView) objArr[4], (ImageView) objArr[7], (ImageView) objArr[3], (ImageView) objArr[6], (TextView) objArr[1], (LinearLayout) objArr[12], (HiloImageView) objArr[2], (MedalGridLayout) objArr[9], (TextView) objArr[8], (HiloImageView) objArr[5], (MedalGridLayout) objArr[11], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
