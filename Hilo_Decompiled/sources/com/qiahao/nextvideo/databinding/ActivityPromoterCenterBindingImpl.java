package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityPromoterCenterBindingImpl extends ActivityPromoterCenterBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(16);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{2, 3, 4}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 5);
        sparseIntArray.put(R.id.bar, 6);
        sparseIntArray.put(R.id.backImageView, 7);
        sparseIntArray.put(2131365189, 8);
        sparseIntArray.put(R.id.thisView, 9);
        sparseIntArray.put(R.id.thisText, 10);
        sparseIntArray.put(R.id.monthBg, 11);
        sparseIntArray.put(R.id.oneLine, 12);
        sparseIntArray.put(R.id.twoLine, 13);
        sparseIntArray.put(R.id.tabLayout, 14);
        sparseIntArray.put(2131365624, 15);
    }

    public ActivityPromoterCenterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
    }

    private boolean onChangeNumber(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRechargeAmount(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTeam(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.team);
        ViewDataBinding.executeBindingsOn(this.number);
        ViewDataBinding.executeBindingsOn(this.rechargeAmount);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.team.hasPendingBindings() || this.number.hasPendingBindings() || this.rechargeAmount.hasPendingBindings()) {
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
        this.team.invalidateAll();
        this.number.invalidateAll();
        this.rechargeAmount.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeNumber((IncludeTransferTextBinding) obj, i2);
            }
            return onChangeTeam((IncludeTransferTextBinding) obj, i2);
        }
        return onChangeRechargeAmount((IncludeTransferTextBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.team.setLifecycleOwner(lifecycleOwner);
        this.number.setLifecycleOwner(lifecycleOwner);
        this.rechargeAmount.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityPromoterCenterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (FrameLayout) objArr[0], (AppCompatImageView) objArr[7], (View) objArr[6], (View) objArr[11], (IncludeTransferTextBinding) objArr[3], (View) objArr[12], (IncludeTransferTextBinding) objArr[4], (SlidingTabLayout) objArr[14], (IncludeTransferTextBinding) objArr[2], (AppCompatTextView) objArr[10], (View) objArr[9], (AppCompatTextView) objArr[8], (LinearLayoutCompat) objArr[5], (View) objArr[13], (ViewPager) objArr[15]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.number);
        setContainedBinding(this.rechargeAmount);
        setContainedBinding(this.team);
        setRootTag(view);
        invalidateAll();
    }
}
