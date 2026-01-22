package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityFamilyCenterBindingImpl extends ActivityFamilyCenterBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.refreshLayout, 1);
        sparseIntArray.put(2131364510, 2);
        sparseIntArray.put(R.id.applyLayout, 3);
        sparseIntArray.put(R.id.applyButton, 4);
        sparseIntArray.put(2131365217, 5);
        sparseIntArray.put(R.id.back_image_view, 6);
        sparseIntArray.put(R.id.setting, 7);
        sparseIntArray.put(R.id.share, 8);
        sparseIntArray.put(R.id.svgaView, 9);
        sparseIntArray.put(2131365026, 10);
    }

    public ActivityFamilyCenterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 11, sIncludes, sViewsWithIds));
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

    private ActivityFamilyCenterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (TextView) objArr[4], (LinearLayout) objArr[3], (AppCompatImageView) objArr[6], (RecyclerView) objArr[2], (SmartRefreshLayout) objArr[1], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[8], (SVGAImageView) objArr[9], (TextView) objArr[10], (Toolbar) objArr[5]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
