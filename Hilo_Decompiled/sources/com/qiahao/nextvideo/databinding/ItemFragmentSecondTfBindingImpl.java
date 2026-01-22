package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemFragmentSecondTfBindingImpl extends ItemFragmentSecondTfBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{1, 2, 3}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362013, 4);
        sparseIntArray.put(2131364012, 5);
        sparseIntArray.put(2131365528, 6);
        sparseIntArray.put(2131364936, 7);
        sparseIntArray.put(R.id.transfer, 8);
        sparseIntArray.put(2131363501, 9);
        sparseIntArray.put(R.id.numberBg, 10);
        sparseIntArray.put(2131363500, 11);
        sparseIntArray.put(R.id.twoLine, 12);
    }

    public ItemFragmentSecondTfBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeClientLayout(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRechargeLayout(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSalesLayout(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.salesLayout);
        ViewDataBinding.executeBindingsOn(this.rechargeLayout);
        ViewDataBinding.executeBindingsOn(this.clientLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.salesLayout.hasPendingBindings() || this.rechargeLayout.hasPendingBindings() || this.clientLayout.hasPendingBindings()) {
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
        this.salesLayout.invalidateAll();
        this.rechargeLayout.invalidateAll();
        this.clientLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeSalesLayout((IncludeTransferTextBinding) obj, i2);
            }
            return onChangeRechargeLayout((IncludeTransferTextBinding) obj, i2);
        }
        return onChangeClientLayout((IncludeTransferTextBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.salesLayout.setLifecycleOwner(lifecycleOwner);
        this.rechargeLayout.setLifecycleOwner(lifecycleOwner);
        this.clientLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ItemFragmentSecondTfBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (QMUIRadiusImageView) objArr[4], (IncludeTransferTextBinding) objArr[3], (ConstraintLayout) objArr[0], (View) objArr[11], (View) objArr[9], (TextView) objArr[5], (View) objArr[10], (IncludeTransferTextBinding) objArr[2], (IncludeTransferTextBinding) objArr[1], (TextView) objArr[7], (TextView) objArr[8], (View) objArr[12], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.clientLayout);
        this.constraintLayout.setTag(null);
        setContainedBinding(this.rechargeLayout);
        setContainedBinding(this.salesLayout);
        setRootTag(view);
        invalidateAll();
    }
}
