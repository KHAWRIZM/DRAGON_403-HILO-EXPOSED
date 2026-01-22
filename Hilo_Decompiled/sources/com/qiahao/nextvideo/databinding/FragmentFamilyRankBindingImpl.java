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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentFamilyRankBindingImpl extends FragmentFamilyRankBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(27);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate", "include_family_name_plate", "include_family_name_plate"}, new int[]{2, 3, 4}, new int[]{2131558989, 2131558989, 2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 5);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 6);
        sparseIntArray.put(R.id.rank_bg1, 7);
        sparseIntArray.put(R.id.rankAvatar1, 8);
        sparseIntArray.put(R.id.rankHeader1, 9);
        sparseIntArray.put(R.id.rankName1, 10);
        sparseIntArray.put(R.id.rankNumberLayout1, 11);
        sparseIntArray.put(R.id.rankNumber1, 12);
        sparseIntArray.put(R.id.rank_bg2, 13);
        sparseIntArray.put(R.id.rankAvatar2, 14);
        sparseIntArray.put(R.id.rankHeader2, 15);
        sparseIntArray.put(R.id.rankName2, 16);
        sparseIntArray.put(R.id.rankNumberLayout2, 17);
        sparseIntArray.put(R.id.rankNumber2, 18);
        sparseIntArray.put(R.id.rank_bg3, 19);
        sparseIntArray.put(R.id.rankAvatar3, 20);
        sparseIntArray.put(R.id.rankHeader3, 21);
        sparseIntArray.put(R.id.rankName3, 22);
        sparseIntArray.put(R.id.rankNumberLayout3, 23);
        sparseIntArray.put(R.id.rankNumber3, 24);
        sparseIntArray.put(R.id.statusView, 25);
        sparseIntArray.put(2131364510, 26);
    }

    public FragmentFamilyRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 27, sIncludes, sViewsWithIds));
    }

    private boolean onChangeRankNamePlate1(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRankNamePlate2(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRankNamePlate3(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.rankNamePlate1);
        ViewDataBinding.executeBindingsOn(this.rankNamePlate2);
        ViewDataBinding.executeBindingsOn(this.rankNamePlate3);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.rankNamePlate1.hasPendingBindings() || this.rankNamePlate2.hasPendingBindings() || this.rankNamePlate3.hasPendingBindings()) {
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
            this.mDirtyFlags = 8L;
        }
        this.rankNamePlate1.invalidateAll();
        this.rankNamePlate2.invalidateAll();
        this.rankNamePlate3.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeRankNamePlate2((IncludeFamilyNamePlateBinding) obj, i2);
            }
            return onChangeRankNamePlate1((IncludeFamilyNamePlateBinding) obj, i2);
        }
        return onChangeRankNamePlate3((IncludeFamilyNamePlateBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.rankNamePlate1.setLifecycleOwner(lifecycleOwner);
        this.rankNamePlate2.setLifecycleOwner(lifecycleOwner);
        this.rankNamePlate3.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentFamilyRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (CollapsingToolbarLayout) objArr[6], (PolygonImageView) objArr[8], (PolygonImageView) objArr[14], (PolygonImageView) objArr[20], (ImageView) objArr[7], (ImageView) objArr[13], (ImageView) objArr[19], (ImageView) objArr[9], (ImageView) objArr[15], (ImageView) objArr[21], (TextView) objArr[10], (TextView) objArr[16], (TextView) objArr[22], (IncludeFamilyNamePlateBinding) objArr[2], (IncludeFamilyNamePlateBinding) objArr[3], (IncludeFamilyNamePlateBinding) objArr[4], (TextView) objArr[12], (TextView) objArr[18], (TextView) objArr[24], (LinearLayout) objArr[11], (LinearLayout) objArr[17], (LinearLayout) objArr[23], (RecyclerView) objArr[26], (SmartRefreshLayout) objArr[5], (SuperStatusView) objArr[25]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.rankNamePlate1);
        setContainedBinding(this.rankNamePlate2);
        setContainedBinding(this.rankNamePlate3);
        setRootTag(view);
        invalidateAll();
    }
}
