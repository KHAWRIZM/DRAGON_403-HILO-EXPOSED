package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemGiftWallBindingImpl extends ItemGiftWallBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_back_group, 1);
        sparseIntArray.put(R.id.receiver_avatar, 2);
        sparseIntArray.put(R.id.receiver_icon_vip, 3);
        sparseIntArray.put(R.id.receiver_icon_noble, 4);
        sparseIntArray.put(R.id.send_avatar, 5);
        sparseIntArray.put(R.id.send_icon_vip, 6);
        sparseIntArray.put(R.id.send_icon_noble, 7);
        sparseIntArray.put(2131363032, 8);
        sparseIntArray.put(R.id.gift_pic_number, 9);
        sparseIntArray.put(R.id.user_name1, 10);
        sparseIntArray.put(R.id.user_name2, 11);
    }

    public ItemGiftWallBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private ItemGiftWallBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[8], (ImageView) objArr[9], (HiloImageView) objArr[2], (ImageView) objArr[4], (ImageView) objArr[3], (HiloImageView) objArr[5], (ImageView) objArr[7], (ImageView) objArr[6], (TextView) objArr[10], (TextView) objArr[11], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
