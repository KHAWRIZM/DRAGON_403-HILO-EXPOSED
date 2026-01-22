package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityMedalManageBindingImpl extends ActivityMedalManageBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(6);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title_write"}, new int[]{2}, new int[]{R.layout.include_title_write});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 3);
        sparseIntArray.put(R.id.topTitle, 4);
        sparseIntArray.put(2131364510, 5);
    }

    public ActivityMedalManageBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleBar(IncludeTitleWriteBinding includeTitleWriteBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.titleBar);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleBar.hasPendingBindings()) {
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
            this.mDirtyFlags = 2L;
        }
        this.titleBar.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTitleBar((IncludeTitleWriteBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityMedalManageBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (ConstraintLayout) objArr[1], (RecyclerView) objArr[5], (IncludeTitleWriteBinding) objArr[2], (View) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.constraint.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}
