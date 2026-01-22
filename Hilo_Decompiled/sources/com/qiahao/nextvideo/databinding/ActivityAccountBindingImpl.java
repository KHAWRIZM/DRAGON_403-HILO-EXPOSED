package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityAccountBindingImpl extends ActivityAccountBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(8);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title", "include_account_item", "include_account_item", "include_account_item", "include_account_item"}, new int[]{2, 3, 4, 5, 6}, new int[]{R.layout.include_title, R.layout.include_account_item, R.layout.include_account_item, R.layout.include_account_item, R.layout.include_account_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.loginFrameLayout, 7);
    }

    public ActivityAccountBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangeDeleteAccount(IncludeAccountItemBinding includeAccountItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFacebook(IncludeAccountItemBinding includeAccountItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeGoogle(IncludeAccountItemBinding includeAccountItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePhone(IncludeAccountItemBinding includeAccountItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTitleBar(IncludeTitleBinding includeTitleBinding, int i) {
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
            IncludeAccountItemBinding includeAccountItemBinding = this.deleteAccount;
            Boolean bool = Boolean.FALSE;
            includeAccountItemBinding.setShowLine(bool);
            this.deleteAccount.setTitle(getRoot().getResources().getString(2131952538));
            IncludeAccountItemBinding includeAccountItemBinding2 = this.facebook;
            Boolean bool2 = Boolean.TRUE;
            includeAccountItemBinding2.setShowLine(bool2);
            this.facebook.setTitle(getRoot().getResources().getString(2131952662));
            this.google.setShowLine(bool);
            this.google.setTitle(getRoot().getResources().getString(2131952926));
            this.phone.setShowLine(bool2);
            this.phone.setTitle(getRoot().getResources().getString(2131953624));
        }
        ViewDataBinding.executeBindingsOn(this.titleBar);
        ViewDataBinding.executeBindingsOn(this.phone);
        ViewDataBinding.executeBindingsOn(this.facebook);
        ViewDataBinding.executeBindingsOn(this.google);
        ViewDataBinding.executeBindingsOn(this.deleteAccount);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleBar.hasPendingBindings() || this.phone.hasPendingBindings() || this.facebook.hasPendingBindings() || this.google.hasPendingBindings() || this.deleteAccount.hasPendingBindings()) {
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
        this.titleBar.invalidateAll();
        this.phone.invalidateAll();
        this.facebook.invalidateAll();
        this.google.invalidateAll();
        this.deleteAccount.invalidateAll();
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
                        return onChangeDeleteAccount((IncludeAccountItemBinding) obj, i2);
                    }
                    return onChangeFacebook((IncludeAccountItemBinding) obj, i2);
                }
                return onChangePhone((IncludeAccountItemBinding) obj, i2);
            }
            return onChangeTitleBar((IncludeTitleBinding) obj, i2);
        }
        return onChangeGoogle((IncludeAccountItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
        this.phone.setLifecycleOwner(lifecycleOwner);
        this.facebook.setLifecycleOwner(lifecycleOwner);
        this.google.setLifecycleOwner(lifecycleOwner);
        this.deleteAccount.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityAccountBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 5, (FrameLayout) objArr[0], (IncludeAccountItemBinding) objArr[6], (IncludeAccountItemBinding) objArr[4], (IncludeAccountItemBinding) objArr[5], (FrameLayout) objArr[7], (IncludeAccountItemBinding) objArr[3], (IncludeTitleBinding) objArr[2]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setContainedBinding(this.deleteAccount);
        setContainedBinding(this.facebook);
        setContainedBinding(this.google);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[1];
        this.mboundView1 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        setContainedBinding(this.phone);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}
