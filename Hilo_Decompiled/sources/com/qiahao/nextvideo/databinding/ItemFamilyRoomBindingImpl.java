package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemFamilyRoomBindingImpl extends ItemFamilyRoomBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(17);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_family_name_plate"}, new int[]{1}, new int[]{2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.room_avatar, 2);
        sparseIntArray.put(R.id.group_support_medal, 3);
        sparseIntArray.put(R.id.icon_count, 4);
        sparseIntArray.put(R.id.group_medal_and_power, 5);
        sparseIntArray.put(R.id.group_name, 6);
        sparseIntArray.put(R.id.ll_rocket, 7);
        sparseIntArray.put(R.id.rocket1, 8);
        sparseIntArray.put(R.id.rocket2, 9);
        sparseIntArray.put(R.id.rocket3, 10);
        sparseIntArray.put(R.id.rocket4, 11);
        sparseIntArray.put(R.id.rocket5, 12);
        sparseIntArray.put(R.id.group_announce, 13);
        sparseIntArray.put(R.id.linearLayout2, 14);
        sparseIntArray.put(R.id.person_number, 15);
        sparseIntArray.put(2131362971, 16);
    }

    public ItemFamilyRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.familyNamePlate);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.familyNamePlate.hasPendingBindings()) {
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
            this.mDirtyFlags = 2L;
        }
        this.familyNamePlate.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ItemFamilyRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (IncludeFamilyNamePlateBinding) objArr[1], (ImageView) objArr[16], (TextView) objArr[13], (GroupMedalAndPowerLayout) objArr[5], (TextView) objArr[6], (ImageView) objArr[3], (ImageView) objArr[4], (LinearLayout) objArr[14], (LinearLayout) objArr[7], (TextView) objArr[15], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (ImageView) objArr[11], (ImageView) objArr[12], (RoundedImageView) objArr[2]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.familyNamePlate);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
