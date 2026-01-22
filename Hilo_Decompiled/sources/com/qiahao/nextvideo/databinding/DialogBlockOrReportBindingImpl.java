package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogBlockOrReportBindingImpl extends DialogBlockOrReportBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;
    private final LinearLayoutCompat mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(10);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_report_item", "include_report_item", "include_report_item", "include_report_item", "include_report_item", "include_report_item", "include_report_item"}, new int[]{2, 3, 4, 5, 6, 7, 8}, new int[]{R.layout.include_report_item, R.layout.include_report_item, R.layout.include_report_item, R.layout.include_report_item, R.layout.include_report_item, R.layout.include_report_item, R.layout.include_report_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362224, 9);
    }

    public DialogBlockOrReportBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFiveLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFourLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSevenLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSixLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoLayout(IncludeReportItemBinding includeReportItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.oneLayout);
        ViewDataBinding.executeBindingsOn(this.twoLayout);
        ViewDataBinding.executeBindingsOn(this.threeLayout);
        ViewDataBinding.executeBindingsOn(this.fourLayout);
        ViewDataBinding.executeBindingsOn(this.fiveLayout);
        ViewDataBinding.executeBindingsOn(this.sixLayout);
        ViewDataBinding.executeBindingsOn(this.sevenLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneLayout.hasPendingBindings() || this.twoLayout.hasPendingBindings() || this.threeLayout.hasPendingBindings() || this.fourLayout.hasPendingBindings() || this.fiveLayout.hasPendingBindings() || this.sixLayout.hasPendingBindings() || this.sevenLayout.hasPendingBindings()) {
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
        this.oneLayout.invalidateAll();
        this.twoLayout.invalidateAll();
        this.threeLayout.invalidateAll();
        this.fourLayout.invalidateAll();
        this.fiveLayout.invalidateAll();
        this.sixLayout.invalidateAll();
        this.sevenLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeFiveLayout((IncludeReportItemBinding) obj, i2);
            case 1:
                return onChangeSixLayout((IncludeReportItemBinding) obj, i2);
            case 2:
                return onChangeOneLayout((IncludeReportItemBinding) obj, i2);
            case 3:
                return onChangeFourLayout((IncludeReportItemBinding) obj, i2);
            case 4:
                return onChangeThreeLayout((IncludeReportItemBinding) obj, i2);
            case 5:
                return onChangeSevenLayout((IncludeReportItemBinding) obj, i2);
            case 6:
                return onChangeTwoLayout((IncludeReportItemBinding) obj, i2);
            default:
                return false;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneLayout.setLifecycleOwner(lifecycleOwner);
        this.twoLayout.setLifecycleOwner(lifecycleOwner);
        this.threeLayout.setLifecycleOwner(lifecycleOwner);
        this.fourLayout.setLifecycleOwner(lifecycleOwner);
        this.fiveLayout.setLifecycleOwner(lifecycleOwner);
        this.sixLayout.setLifecycleOwner(lifecycleOwner);
        this.sevenLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private DialogBlockOrReportBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (AppCompatButton) objArr[9], (IncludeReportItemBinding) objArr[6], (IncludeReportItemBinding) objArr[5], (IncludeReportItemBinding) objArr[2], (IncludeReportItemBinding) objArr[8], (IncludeReportItemBinding) objArr[7], (IncludeReportItemBinding) objArr[4], (IncludeReportItemBinding) objArr[3]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.fiveLayout);
        setContainedBinding(this.fourLayout);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) objArr[1];
        this.mboundView1 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        setContainedBinding(this.oneLayout);
        setContainedBinding(this.sevenLayout);
        setContainedBinding(this.sixLayout);
        setContainedBinding(this.threeLayout);
        setContainedBinding(this.twoLayout);
        setRootTag(view);
        invalidateAll();
    }
}
