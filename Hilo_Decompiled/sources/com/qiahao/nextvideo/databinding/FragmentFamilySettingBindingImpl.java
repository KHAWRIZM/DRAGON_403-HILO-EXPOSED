package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentFamilySettingBindingImpl extends FragmentFamilySettingBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(17);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 3);
        sparseIntArray.put(R.id.backImageView, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.profileLayout, 6);
        sparseIntArray.put(2131362013, 7);
        sparseIntArray.put(R.id.imge, 8);
        sparseIntArray.put(R.id.familyNameLayout, 9);
        sparseIntArray.put(R.id.arrow, 10);
        sparseIntArray.put(R.id.familyName, 11);
        sparseIntArray.put(R.id.namePlateArrow, 12);
        sparseIntArray.put(R.id.declareLayout, 13);
        sparseIntArray.put(R.id.declareArrow, 14);
        sparseIntArray.put(R.id.declare, 15);
        sparseIntArray.put(2131362625, 16);
    }

    public FragmentFamilySettingBindingImpl(f fVar, View view) {
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

    private FragmentFamilySettingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (ImageView) objArr[10], (PolygonImageView) objArr[7], (AppCompatImageView) objArr[4], (TextView) objArr[15], (ImageView) objArr[14], (ConstraintLayout) objArr[13], (TextView) objArr[16], (TextView) objArr[11], (ConstraintLayout) objArr[9], (IncludeFamilyNamePlateBinding) objArr[2], (AppCompatImageView) objArr[8], (ImageView) objArr[12], (ConstraintLayout) objArr[1], (FrameLayout) objArr[6], (TextView) objArr[5], (Toolbar) objArr[3]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.familyNamePlate);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.namePlateLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
