package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import r1.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityBillBindingImpl extends ActivityBillBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(7);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title", "include_bill_item", "include_bill_item", "include_bill_item", "include_bill_item"}, new int[]{2, 3, 4, 5, 6}, new int[]{R.layout.include_title, R.layout.include_bill_item, R.layout.include_bill_item, R.layout.include_bill_item, R.layout.include_bill_item});
        sViewsWithIds = null;
    }

    public ActivityBillBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
    }

    private boolean onChangeBeans(IncludeBillItemBinding includeBillItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeCoins(IncludeBillItemBinding includeBillItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDiamond(IncludeBillItemBinding includeBillItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRecharge(IncludeBillItemBinding includeBillItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTitleLayout(IncludeTitleBinding includeTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j & 32) != 0) {
            this.beans.setImageRes(a.b(getRoot().getContext(), R.drawable.bill_beans));
            this.beans.setTitle(getRoot().getResources().getString(2131952098));
            this.coins.setImageRes(a.b(getRoot().getContext(), R.drawable.coins_icon));
            this.coins.setTitle(getRoot().getResources().getString(2131952277));
            this.diamond.setImageRes(a.b(getRoot().getContext(), R.drawable.bill_diamond));
            this.diamond.setTitle(getRoot().getResources().getString(2131952560));
            this.recharge.setImageRes(a.b(getRoot().getContext(), R.drawable.bill_recharge));
            this.recharge.setTitle(getRoot().getResources().getString(2131953857));
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
        ViewDataBinding.executeBindingsOn(this.diamond);
        ViewDataBinding.executeBindingsOn(this.beans);
        ViewDataBinding.executeBindingsOn(this.coins);
        ViewDataBinding.executeBindingsOn(this.recharge);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleLayout.hasPendingBindings() || this.diamond.hasPendingBindings() || this.beans.hasPendingBindings() || this.coins.hasPendingBindings() || this.recharge.hasPendingBindings()) {
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
            this.mDirtyFlags = 32L;
        }
        this.titleLayout.invalidateAll();
        this.diamond.invalidateAll();
        this.beans.invalidateAll();
        this.coins.invalidateAll();
        this.recharge.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeDiamond((IncludeBillItemBinding) obj, i2);
                    }
                    return onChangeCoins((IncludeBillItemBinding) obj, i2);
                }
                return onChangeBeans((IncludeBillItemBinding) obj, i2);
            }
            return onChangeTitleLayout((IncludeTitleBinding) obj, i2);
        }
        return onChangeRecharge((IncludeBillItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
        this.diamond.setLifecycleOwner(lifecycleOwner);
        this.beans.setLifecycleOwner(lifecycleOwner);
        this.coins.setLifecycleOwner(lifecycleOwner);
        this.recharge.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityBillBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 5, (FrameLayout) objArr[0], (IncludeBillItemBinding) objArr[4], (IncludeBillItemBinding) objArr[5], (IncludeBillItemBinding) objArr[3], (IncludeBillItemBinding) objArr[6], (IncludeTitleBinding) objArr[2]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setContainedBinding(this.beans);
        setContainedBinding(this.coins);
        setContainedBinding(this.diamond);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.recharge);
        setContainedBinding(this.titleLayout);
        setRootTag(view);
        invalidateAll();
    }
}
