package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityCpMemorialBindingImpl extends ActivityCpMemorialBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(7);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title"}, new int[]{2}, new int[]{R.layout.include_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.statusView, 3);
        sparseIntArray.put(R.id.refreshLayout, 4);
        sparseIntArray.put(2131364510, 5);
        sparseIntArray.put(2131361922, 6);
    }

    public ActivityCpMemorialBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleBar(IncludeTitleBinding includeTitleBinding, int i) {
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
        return onChangeTitleBar((IncludeTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityCpMemorialBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (ImageView) objArr[6], (RecyclerView) objArr[5], (SmartRefreshLayout) objArr[4], (SuperStatusView) objArr[3], (IncludeTitleBinding) objArr[2]);
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
