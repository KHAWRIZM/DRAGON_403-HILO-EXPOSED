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
public class ItemFragmentPromoterCenterBindingImpl extends ItemFragmentPromoterCenterBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(10);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{1, 2, 3}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362013, 4);
        sparseIntArray.put(2131364012, 5);
        sparseIntArray.put(R.id.f١١id, 6);
        sparseIntArray.put(R.id.monthBg, 7);
        sparseIntArray.put(R.id.oneLine, 8);
        sparseIntArray.put(R.id.twoLine, 9);
    }

    public ItemFragmentPromoterCenterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeInvite(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePass(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTopUp(IncludeTransferTextBinding includeTransferTextBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.invite);
        ViewDataBinding.executeBindingsOn(this.pass);
        ViewDataBinding.executeBindingsOn(this.topUp);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.invite.hasPendingBindings() || this.pass.hasPendingBindings() || this.topUp.hasPendingBindings()) {
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
        this.invite.invalidateAll();
        this.pass.invalidateAll();
        this.topUp.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangePass((IncludeTransferTextBinding) obj, i2);
            }
            return onChangeInvite((IncludeTransferTextBinding) obj, i2);
        }
        return onChangeTopUp((IncludeTransferTextBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.invite.setLifecycleOwner(lifecycleOwner);
        this.pass.setLifecycleOwner(lifecycleOwner);
        this.topUp.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ItemFragmentPromoterCenterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (QMUIRadiusImageView) objArr[4], (ConstraintLayout) objArr[0], (TextView) objArr[6], (IncludeTransferTextBinding) objArr[1], (View) objArr[7], (TextView) objArr[5], (View) objArr[8], (IncludeTransferTextBinding) objArr[2], (IncludeTransferTextBinding) objArr[3], (View) objArr[9]);
        this.mDirtyFlags = -1L;
        this.constraintLayout.setTag(null);
        setContainedBinding(this.invite);
        setContainedBinding(this.pass);
        setContainedBinding(this.topUp);
        setRootTag(view);
        invalidateAll();
    }
}
