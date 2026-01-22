package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewLevelPkBindingImpl extends ViewLevelPkBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(7);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_pk_level", "include_pk_level", "include_pk_level"}, new int[]{2, 3, 4}, new int[]{R.layout.include_pk_level, R.layout.include_pk_level, R.layout.include_pk_level});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.progressBg, 5);
        sparseIntArray.put(2131364343, 6);
    }

    public ViewLevelPkBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
    }

    private boolean onChangeOneLevel(IncludePkLevelBinding includePkLevelBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeLevel(IncludePkLevelBinding includePkLevelBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoLevel(IncludePkLevelBinding includePkLevelBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.oneLevel);
        ViewDataBinding.executeBindingsOn(this.twoLevel);
        ViewDataBinding.executeBindingsOn(this.threeLevel);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneLevel.hasPendingBindings() || this.twoLevel.hasPendingBindings() || this.threeLevel.hasPendingBindings()) {
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
        this.oneLevel.invalidateAll();
        this.twoLevel.invalidateAll();
        this.threeLevel.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeTwoLevel((IncludePkLevelBinding) obj, i2);
            }
            return onChangeThreeLevel((IncludePkLevelBinding) obj, i2);
        }
        return onChangeOneLevel((IncludePkLevelBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneLevel.setLifecycleOwner(lifecycleOwner);
        this.twoLevel.setLifecycleOwner(lifecycleOwner);
        this.threeLevel.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewLevelPkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (IncludePkLevelBinding) objArr[2], (View) objArr[6], (View) objArr[5], (IncludePkLevelBinding) objArr[4], (IncludePkLevelBinding) objArr[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.oneLevel);
        setContainedBinding(this.threeLevel);
        setContainedBinding(this.twoLevel);
        setRootTag(view);
        invalidateAll();
    }
}
