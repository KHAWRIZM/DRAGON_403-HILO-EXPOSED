package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemPowerRoomBindingImpl extends ItemPowerRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.room_avatar, 1);
        sparseIntArray.put(R.id.group_support_medal, 2);
        sparseIntArray.put(R.id.icon_count, 3);
        sparseIntArray.put(R.id.group_medal_and_power, 4);
        sparseIntArray.put(R.id.group_name, 5);
        sparseIntArray.put(R.id.ll_rocket, 6);
        sparseIntArray.put(R.id.rocket1, 7);
        sparseIntArray.put(R.id.rocket2, 8);
        sparseIntArray.put(R.id.rocket3, 9);
        sparseIntArray.put(R.id.rocket4, 10);
        sparseIntArray.put(R.id.rocket5, 11);
        sparseIntArray.put(R.id.group_announce, 12);
        sparseIntArray.put(R.id.linearLayout2, 13);
        sparseIntArray.put(R.id.person_number, 14);
        sparseIntArray.put(2131362971, 15);
    }

    public ItemPowerRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
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

    private ItemPowerRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[15], (TextView) objArr[12], (GroupMedalAndPowerLayout) objArr[4], (TextView) objArr[5], (ImageView) objArr[2], (ImageView) objArr[3], (LinearLayout) objArr[13], (LinearLayout) objArr[6], (TextView) objArr[14], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (ImageView) objArr[11], (RoundedImageView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
