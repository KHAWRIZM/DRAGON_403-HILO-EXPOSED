package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentCpChildBindingImpl extends FragmentCpChildBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(9);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_cp_item", "include_cp_item", "include_cp_item"}, new int[]{2, 3, 4}, new int[]{R.layout.include_cp_item, R.layout.include_cp_item, R.layout.include_cp_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.refreshLayout, 5);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 6);
        sparseIntArray.put(R.id.statusView, 7);
        sparseIntArray.put(2131364510, 8);
    }

    public FragmentCpChildBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTop1(IncludeCpItemBinding includeCpItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTop2(IncludeCpItemBinding includeCpItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTop3(IncludeCpItemBinding includeCpItemBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.top1);
        ViewDataBinding.executeBindingsOn(this.top2);
        ViewDataBinding.executeBindingsOn(this.top3);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.top1.hasPendingBindings() || this.top2.hasPendingBindings() || this.top3.hasPendingBindings()) {
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
        this.top1.invalidateAll();
        this.top2.invalidateAll();
        this.top3.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeTop1((IncludeCpItemBinding) obj, i2);
            }
            return onChangeTop2((IncludeCpItemBinding) obj, i2);
        }
        return onChangeTop3((IncludeCpItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.top1.setLifecycleOwner(lifecycleOwner);
        this.top2.setLifecycleOwner(lifecycleOwner);
        this.top3.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentCpChildBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (CollapsingToolbarLayout) objArr[6], (RecyclerView) objArr[8], (SmartRefreshLayout) objArr[5], (SuperStatusView) objArr[7], (IncludeCpItemBinding) objArr[2], (IncludeCpItemBinding) objArr[3], (IncludeCpItemBinding) objArr[4]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        setContainedBinding(this.top1);
        setContainedBinding(this.top2);
        setContainedBinding(this.top3);
        setRootTag(view);
        invalidateAll();
    }
}
