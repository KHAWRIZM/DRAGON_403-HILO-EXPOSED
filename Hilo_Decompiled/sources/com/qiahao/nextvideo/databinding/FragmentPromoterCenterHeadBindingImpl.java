package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentPromoterCenterHeadBindingImpl extends FragmentPromoterCenterHeadBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{1, 2, 3}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.selectBg, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.timeIcon, 6);
        sparseIntArray.put(2131365152, 7);
        sparseIntArray.put(R.id.monthBg, 8);
        sparseIntArray.put(R.id.oneLine, 9);
        sparseIntArray.put(R.id.twoLine, 10);
        sparseIntArray.put(R.id.saleDetail, 11);
        sparseIntArray.put(R.id.saleDetailText, 12);
    }

    public FragmentPromoterCenterHeadBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private FragmentPromoterCenterHeadBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (View) objArr[8], (IncludeTransferTextBinding) objArr[2], (View) objArr[9], (IncludeTransferTextBinding) objArr[3], (View) objArr[11], (AppCompatTextView) objArr[12], (View) objArr[4], (IncludeTransferTextBinding) objArr[1], (TextView) objArr[7], (ImageView) objArr[6], (TextView) objArr[5], (View) objArr[10]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.number);
        setContainedBinding(this.rechargeAmount);
        setContainedBinding(this.team);
        setRootTag(view);
        invalidateAll();
    }
}
