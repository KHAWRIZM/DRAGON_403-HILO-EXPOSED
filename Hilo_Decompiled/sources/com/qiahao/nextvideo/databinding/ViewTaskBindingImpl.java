package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewTaskBindingImpl extends ViewTaskBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(14);
        sIncludes = iVar;
        iVar.a(0, new String[]{"view_task_item", "view_task_item", "view_task_item", "view_task_item", "view_task_item", "view_task_item", "view_task_item"}, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{R.layout.view_task_item, R.layout.view_task_item, R.layout.view_task_item, R.layout.view_task_item, R.layout.view_task_item, R.layout.view_task_item, R.layout.view_task_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363501, 8);
        sparseIntArray.put(R.id.line2, 9);
        sparseIntArray.put(2131363503, 10);
        sparseIntArray.put(R.id.line4, 11);
        sparseIntArray.put(R.id.line5, 12);
        sparseIntArray.put(R.id.line6, 13);
    }

    public ViewTaskBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
    }

    private boolean onChangeDayLayout1(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout2(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout3(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout4(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout5(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout6(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDayLayout7(ViewTaskItemBinding viewTaskItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.dayLayout1);
        ViewDataBinding.executeBindingsOn(this.dayLayout2);
        ViewDataBinding.executeBindingsOn(this.dayLayout3);
        ViewDataBinding.executeBindingsOn(this.dayLayout4);
        ViewDataBinding.executeBindingsOn(this.dayLayout5);
        ViewDataBinding.executeBindingsOn(this.dayLayout6);
        ViewDataBinding.executeBindingsOn(this.dayLayout7);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.dayLayout1.hasPendingBindings() || this.dayLayout2.hasPendingBindings() || this.dayLayout3.hasPendingBindings() || this.dayLayout4.hasPendingBindings() || this.dayLayout5.hasPendingBindings() || this.dayLayout6.hasPendingBindings() || this.dayLayout7.hasPendingBindings()) {
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
            this.mDirtyFlags = 128L;
        }
        this.dayLayout1.invalidateAll();
        this.dayLayout2.invalidateAll();
        this.dayLayout3.invalidateAll();
        this.dayLayout4.invalidateAll();
        this.dayLayout5.invalidateAll();
        this.dayLayout6.invalidateAll();
        this.dayLayout7.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeDayLayout1((ViewTaskItemBinding) obj, i2);
            case 1:
                return onChangeDayLayout3((ViewTaskItemBinding) obj, i2);
            case 2:
                return onChangeDayLayout2((ViewTaskItemBinding) obj, i2);
            case 3:
                return onChangeDayLayout5((ViewTaskItemBinding) obj, i2);
            case 4:
                return onChangeDayLayout4((ViewTaskItemBinding) obj, i2);
            case 5:
                return onChangeDayLayout7((ViewTaskItemBinding) obj, i2);
            case 6:
                return onChangeDayLayout6((ViewTaskItemBinding) obj, i2);
            default:
                return false;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.dayLayout1.setLifecycleOwner(lifecycleOwner);
        this.dayLayout2.setLifecycleOwner(lifecycleOwner);
        this.dayLayout3.setLifecycleOwner(lifecycleOwner);
        this.dayLayout4.setLifecycleOwner(lifecycleOwner);
        this.dayLayout5.setLifecycleOwner(lifecycleOwner);
        this.dayLayout6.setLifecycleOwner(lifecycleOwner);
        this.dayLayout7.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewTaskBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (ViewTaskItemBinding) objArr[1], (ViewTaskItemBinding) objArr[2], (ViewTaskItemBinding) objArr[3], (ViewTaskItemBinding) objArr[4], (ViewTaskItemBinding) objArr[5], (ViewTaskItemBinding) objArr[6], (ViewTaskItemBinding) objArr[7], (View) objArr[8], (View) objArr[9], (View) objArr[10], (View) objArr[11], (View) objArr[12], (View) objArr[13], (ConstraintLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.dayLayout1);
        setContainedBinding(this.dayLayout2);
        setContainedBinding(this.dayLayout3);
        setContainedBinding(this.dayLayout4);
        setContainedBinding(this.dayLayout5);
        setContainedBinding(this.dayLayout6);
        setContainedBinding(this.dayLayout7);
        this.rootLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
