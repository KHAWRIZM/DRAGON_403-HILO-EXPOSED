package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityFamilyRankBindingImpl extends ActivityFamilyRankBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(17);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.constraintLayout, 3);
        sparseIntArray.put(R.id.linearLayout, 4);
        sparseIntArray.put(R.id.bar, 5);
        sparseIntArray.put(R.id.backImageView, 6);
        sparseIntArray.put(2131365189, 7);
        sparseIntArray.put(R.id.helperImage, 8);
        sparseIntArray.put(R.id.activityImage, 9);
        sparseIntArray.put(R.id.tabLayout, 10);
        sparseIntArray.put(R.id.viewPage, 11);
        sparseIntArray.put(2131364298, 12);
        sparseIntArray.put(2131362013, 13);
        sparseIntArray.put(R.id.userName, 14);
        sparseIntArray.put(R.id.ll_diamond, 15);
        sparseIntArray.put(R.id.diamond, 16);
    }

    public ActivityFamilyRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
    }

    private boolean onChangeNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.namePlate);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.namePlate.hasPendingBindings()) {
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
        this.namePlate.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.namePlate.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityFamilyRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (AppCompatImageView) objArr[9], (FrameLayout) objArr[0], (PolygonImageView) objArr[13], (AppCompatImageView) objArr[6], (View) objArr[5], (ConstraintLayout) objArr[3], (TextView) objArr[16], (AppCompatImageView) objArr[8], (LinearLayoutCompat) objArr[4], (LinearLayout) objArr[15], (ConstraintLayout) objArr[1], (IncludeFamilyNamePlateBinding) objArr[2], (TextView) objArr[12], (HiloTabLayout) objArr[10], (AppCompatTextView) objArr[7], (TextView) objArr[14], (ViewPager2) objArr[11]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.myFamily.setTag(null);
        setContainedBinding(this.namePlate);
        setRootTag(view);
        invalidateAll();
    }
}
