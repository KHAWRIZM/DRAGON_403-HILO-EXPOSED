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
public class FragmentTransferCenterHeadBindingImpl extends FragmentTransferCenterHeadBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(18);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{1, 2, 3}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.selectBg, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.timeIcon, 6);
        sparseIntArray.put(2131365152, 7);
        sparseIntArray.put(R.id.numberBg, 8);
        sparseIntArray.put(2131363500, 9);
        sparseIntArray.put(R.id.twoLine, 10);
        sparseIntArray.put(R.id.saleDetail, 11);
        sparseIntArray.put(R.id.saleDetailText, 12);
        sparseIntArray.put(2131365196, 13);
        sparseIntArray.put(2131364298, 14);
        sparseIntArray.put(R.id.f١١id, 15);
        sparseIntArray.put(R.id.sales, 16);
        sparseIntArray.put(R.id.diamond, 17);
    }

    public FragmentTransferCenterHeadBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
    }

    private boolean onChangeClientLayout(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRecharge(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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
        ViewDataBinding.executeBindingsOn(this.recharge);
        ViewDataBinding.executeBindingsOn(this.clientLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.salesLayout.hasPendingBindings() || this.recharge.hasPendingBindings() || this.clientLayout.hasPendingBindings()) {
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
        this.recharge.invalidateAll();
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
            return onChangeClientLayout((IncludeTransferTextBinding) obj, i2);
        }
        return onChangeRecharge((IncludeTransferTextBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.salesLayout.setLifecycleOwner(lifecycleOwner);
        this.recharge.setLifecycleOwner(lifecycleOwner);
        this.clientLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentTransferCenterHeadBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (IncludeTransferTextBinding) objArr[3], (TextView) objArr[17], (TextView) objArr[15], (View) objArr[9], (View) objArr[8], (TextView) objArr[14], (IncludeTransferTextBinding) objArr[2], (View) objArr[11], (AppCompatTextView) objArr[12], (TextView) objArr[16], (IncludeTransferTextBinding) objArr[1], (View) objArr[4], (TextView) objArr[7], (ImageView) objArr[6], (TextView) objArr[5], (ConstraintLayout) objArr[13], (View) objArr[10]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.clientLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.recharge);
        setContainedBinding(this.salesLayout);
        setRootTag(view);
        invalidateAll();
    }
}
