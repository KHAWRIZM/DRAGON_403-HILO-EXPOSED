package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGoddessBindingImpl extends ActivityGoddessBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 1);
        sparseIntArray.put(R.id.linearLayout, 2);
        sparseIntArray.put(R.id.bar, 3);
        sparseIntArray.put(R.id.backImageView, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.endImage, 6);
        sparseIntArray.put(R.id.historyLayout, 7);
        sparseIntArray.put(2131364535, 8);
        sparseIntArray.put(R.id.statusView, 9);
        sparseIntArray.put(R.id.refreshLayout, 10);
        sparseIntArray.put(2131364510, 11);
    }

    public ActivityGoddessBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityGoddessBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[4], (View) objArr[3], (AppCompatImageView) objArr[6], (FrameLayout) objArr[7], (LinearLayoutCompat) objArr[2], (RecyclerView) objArr[11], (ImageView) objArr[8], (SmartRefreshLayout) objArr[10], (SuperStatusView) objArr[9], (AppCompatTextView) objArr[5], (LinearLayoutCompat) objArr[1]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
