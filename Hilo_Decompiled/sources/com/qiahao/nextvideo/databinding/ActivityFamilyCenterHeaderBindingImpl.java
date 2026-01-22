package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityFamilyCenterHeaderBindingImpl extends ActivityFamilyCenterHeaderBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(41);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{2131558989});
        iVar.a(1, new String[]{"include_family_item", "include_family_item", "include_family_item"}, new int[]{3, 4, 5}, new int[]{R.layout.include_family_item, R.layout.include_family_item, R.layout.include_family_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topImage, 6);
        sparseIntArray.put(2131362013, 7);
        sparseIntArray.put(R.id.familyHeader, 8);
        sparseIntArray.put(R.id.familyName, 9);
        sparseIntArray.put(R.id.familyWelcome, 10);
        sparseIntArray.put(R.id.familyWelcomeImage, 11);
        sparseIntArray.put(R.id.familyButton, 12);
        sparseIntArray.put(R.id.familyLevelLayout, 13);
        sparseIntArray.put(R.id.familyLevel, 14);
        sparseIntArray.put(R.id.monthlyRanking, 15);
        sparseIntArray.put(R.id.rankText, 16);
        sparseIntArray.put(2131364344, 17);
        sparseIntArray.put(R.id.exp, 18);
        sparseIntArray.put(R.id.gradeMedal, 19);
        sparseIntArray.put(R.id.levelLive, 20);
        sparseIntArray.put(R.id.familyMemberLayout, 21);
        sparseIntArray.put(R.id.familyMember, 22);
        sparseIntArray.put(2131361951, 23);
        sparseIntArray.put(R.id.allArrow, 24);
        sparseIntArray.put(R.id.memberRecycleView, 25);
        sparseIntArray.put(R.id.memberLive, 26);
        sparseIntArray.put(R.id.todayDetail, 27);
        sparseIntArray.put(R.id.dailyTitle, 28);
        sparseIntArray.put(R.id.diamondBg, 29);
        sparseIntArray.put(R.id.diamondNumber, 30);
        sparseIntArray.put(R.id.diamondText, 31);
        sparseIntArray.put(R.id.numberBg, 32);
        sparseIntArray.put(R.id.numberNumber, 33);
        sparseIntArray.put(R.id.numberText, 34);
        sparseIntArray.put(R.id.familyStar, 35);
        sparseIntArray.put(R.id.rankingTo, 36);
        sparseIntArray.put(R.id.rankingArrow, 37);
        sparseIntArray.put(R.id.starLive, 38);
        sparseIntArray.put(R.id.familyRoom, 39);
        sparseIntArray.put(R.id.statusView, 40);
    }

    public ActivityFamilyCenterHeaderBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 41, sIncludes, sViewsWithIds));
    }

    private boolean onChangeActive(IncludeFamilyItemBinding includeFamilyItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeCharm(IncludeFamilyItemBinding includeFamilyItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFamous(IncludeFamilyItemBinding includeFamilyItemBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.famous);
        ViewDataBinding.executeBindingsOn(this.active);
        ViewDataBinding.executeBindingsOn(this.charm);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.familyNamePlate.hasPendingBindings() || this.famous.hasPendingBindings() || this.active.hasPendingBindings() || this.charm.hasPendingBindings()) {
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
            this.mDirtyFlags = 16L;
        }
        this.familyNamePlate.invalidateAll();
        this.famous.invalidateAll();
        this.active.invalidateAll();
        this.charm.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
                }
                return onChangeActive((IncludeFamilyItemBinding) obj, i2);
            }
            return onChangeCharm((IncludeFamilyItemBinding) obj, i2);
        }
        return onChangeFamous((IncludeFamilyItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
        this.famous.setLifecycleOwner(lifecycleOwner);
        this.active.setLifecycleOwner(lifecycleOwner);
        this.charm.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityFamilyCenterHeaderBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 4, (IncludeFamilyItemBinding) objArr[4], (LinearLayout) objArr[23], (ImageView) objArr[24], (PolygonImageView) objArr[7], (IncludeFamilyItemBinding) objArr[5], (TextView) objArr[28], (View) objArr[29], (TextView) objArr[30], (TextView) objArr[31], (TextView) objArr[18], (ConstraintLayout) objArr[12], (ImageView) objArr[8], (TextView) objArr[14], (ConstraintLayout) objArr[13], (TextView) objArr[22], (ConstraintLayout) objArr[21], (AppCompatTextView) objArr[9], (IncludeFamilyNamePlateBinding) objArr[2], (TextView) objArr[39], (TextView) objArr[35], (ConstraintLayout) objArr[1], (AppCompatTextView) objArr[10], (ImageView) objArr[11], (IncludeFamilyItemBinding) objArr[3], (ImageView) objArr[19], (View) objArr[20], (View) objArr[26], (RecyclerView) objArr[25], (TextView) objArr[15], (View) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (ProgressBar) objArr[17], (TextView) objArr[16], (ImageView) objArr[37], (LinearLayout) objArr[36], (View) objArr[38], (SuperStatusView) objArr[40], (ConstraintLayout) objArr[27], (AppCompatImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.active);
        setContainedBinding(this.charm);
        setContainedBinding(this.familyNamePlate);
        this.familyStarLayout.setTag(null);
        setContainedBinding(this.famous);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
