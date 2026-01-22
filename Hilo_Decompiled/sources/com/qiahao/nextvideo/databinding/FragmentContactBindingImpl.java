package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentContactBindingImpl extends FragmentContactBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.common_id_swipe_refresh_layout, 1);
        sparseIntArray.put(R.id.common_id_content_container, 2);
        sparseIntArray.put(2131365217, 3);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 4);
        sparseIntArray.put(R.id.ll_i_like, 5);
        sparseIntArray.put(R.id.i_like, 6);
        sparseIntArray.put(R.id.i_like_unread, 7);
        sparseIntArray.put(R.id.ll_like_me, 8);
        sparseIntArray.put(R.id.like_me, 9);
        sparseIntArray.put(R.id.like_me_unread, 10);
        sparseIntArray.put(R.id.ll_visit, 11);
        sparseIntArray.put(R.id.visitor, 12);
        sparseIntArray.put(R.id.visit_unread, 13);
        sparseIntArray.put(R.id.common_id_recycler_view, 14);
        sparseIntArray.put(R.id.empty_tip_text_view, 15);
    }

    public FragmentContactBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
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

    private FragmentContactBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CollapsingToolbarLayout) objArr[4], (CoordinatorLayout) objArr[2], (RecyclerView) objArr[14], (SmartRefreshLayout) objArr[1], (LinearLayoutCompat) objArr[0], (AppCompatTextView) objArr[15], (TextView) objArr[6], (AppCompatTextView) objArr[7], (TextView) objArr[9], (AppCompatTextView) objArr[10], (LinearLayout) objArr[5], (LinearLayout) objArr[8], (LinearLayout) objArr[11], (AppBarLayout) objArr[3], (AppCompatTextView) objArr[13], (TextView) objArr[12]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
