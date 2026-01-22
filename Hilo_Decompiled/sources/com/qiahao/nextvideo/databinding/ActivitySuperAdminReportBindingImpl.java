package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivitySuperAdminReportBindingImpl extends ActivitySuperAdminReportBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(20);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title_write"}, new int[]{2}, new int[]{R.layout.include_title_write});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365152, 3);
        sparseIntArray.put(R.id.oneDay, 4);
        sparseIntArray.put(R.id.twoDay, 5);
        sparseIntArray.put(R.id.threeDay, 6);
        sparseIntArray.put(R.id.permanent, 7);
        sparseIntArray.put(R.id.svipGroup, 8);
        sparseIntArray.put(R.id.reason, 9);
        sparseIntArray.put(R.id.harassment, 10);
        sparseIntArray.put(R.id.privacy, 11);
        sparseIntArray.put(R.id.violation, 12);
        sparseIntArray.put(R.id.official, 13);
        sparseIntArray.put(R.id.description, 14);
        sparseIntArray.put(R.id.editText, 15);
        sparseIntArray.put(R.id.lengthTextView, 16);
        sparseIntArray.put(R.id.videoTip, 17);
        sparseIntArray.put(2131364510, 18);
        sparseIntArray.put(R.id.submit, 19);
    }

    public ActivitySuperAdminReportBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
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

    private ActivitySuperAdminReportBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (AppCompatTextView) objArr[14], (AppCompatEditText) objArr[15], (TextView) objArr[10], (AppCompatTextView) objArr[16], (TextView) objArr[13], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[11], (AppCompatTextView) objArr[9], (RecyclerView) objArr[18], (TextView) objArr[19], (Group) objArr[8], (TextView) objArr[6], (AppCompatTextView) objArr[3], (IncludeTitleWriteBinding) objArr[2], (TextView) objArr[5], (AppCompatTextView) objArr[17], (TextView) objArr[12]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}
