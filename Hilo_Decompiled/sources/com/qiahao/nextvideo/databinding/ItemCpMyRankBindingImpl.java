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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemCpMyRankBindingImpl extends ItemCpMyRankBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user1_avatar_cimage_view, 1);
        sparseIntArray.put(R.id.icon_vip_1, 2);
        sparseIntArray.put(R.id.icon_noble_1, 3);
        sparseIntArray.put(R.id.user2_avatar_cimage_view, 4);
        sparseIntArray.put(R.id.icon_vip_2, 5);
        sparseIntArray.put(R.id.icon_noble_2, 6);
        sparseIntArray.put(R.id.user1_name, 7);
        sparseIntArray.put(R.id.user2_name, 8);
        sparseIntArray.put(R.id.ll_diamond, 9);
        sparseIntArray.put(R.id.cp_value, 10);
    }

    public ItemCpMyRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 11, sIncludes, sViewsWithIds));
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

    private ItemCpMyRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[10], (ImageView) objArr[3], (ImageView) objArr[6], (ImageView) objArr[2], (ImageView) objArr[5], (LinearLayout) objArr[9], (HiloImageView) objArr[1], (TextView) objArr[7], (HiloImageView) objArr[4], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
