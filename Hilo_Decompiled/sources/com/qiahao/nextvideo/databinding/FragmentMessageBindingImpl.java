package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.chat.HorizontalInteractiveView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentMessageBindingImpl extends FragmentMessageBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smartRefreshLayout, 1);
        sparseIntArray.put(R.id.common_id_content_container, 2);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 3);
        sparseIntArray.put(R.id.horizontal_interactiveView, 4);
        sparseIntArray.put(2131363510, 5);
        sparseIntArray.put(2131364510, 6);
        sparseIntArray.put(R.id.empty_tip_text_view, 7);
        sparseIntArray.put(R.id.bottom_view, 8);
    }

    public FragmentMessageBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
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

    private FragmentMessageBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[8], (CollapsingToolbarLayout) objArr[3], (CoordinatorLayout) objArr[2], (LinearLayoutCompat) objArr[0], (AppCompatTextView) objArr[7], (HorizontalInteractiveView) objArr[4], (LinearLayout) objArr[5], (RecyclerView) objArr[6], (SmartRefreshLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
