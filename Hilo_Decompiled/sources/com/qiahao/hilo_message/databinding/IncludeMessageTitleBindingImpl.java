package com.qiahao.hilo_message.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.HiloGradeView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class IncludeMessageTitleBindingImpl extends IncludeMessageTitleBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{R.layout.include_family_name_plate});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.qiahao.hilo_message.R.id.name, 3);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.userTag, 4);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.wealthLevel, 5);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.charmLevel, 6);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.imgBeautyCode, 7);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.iconVip, 8);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.iv_new_user, 9);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.svip, 10);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.iconNoble, 11);
        sparseIntArray.put(com.qiahao.hilo_message.R.id.llMedal, 12);
    }

    public IncludeMessageTitleBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.familyNamePlate);
    }

    @Override // androidx.databinding.ViewDataBinding
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

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        this.familyNamePlate.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, Object obj) {
        return true;
    }

    private IncludeMessageTitleBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (HiloGradeView) objArr[6], (ConstraintLayout) objArr[0], (IncludeFamilyNamePlateBinding) objArr[2], (ImageView) objArr[11], (ImageView) objArr[8], (ImageView) objArr[7], (ImageView) objArr[9], (LinearLayout) objArr[12], (TextView) objArr[3], (ImageView) objArr[10], (LinearLayout) objArr[1], (ImageView) objArr[4], (HiloGradeView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.constraint.setTag(null);
        setContainedBinding(this.familyNamePlate);
        this.topLinear.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
