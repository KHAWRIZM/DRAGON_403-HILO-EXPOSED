package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentRealTaskBindingImpl extends FragmentRealTaskBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.realConstraint, 1);
        sparseIntArray.put(R.id.realPerson, 2);
        sparseIntArray.put(R.id.realLine, 3);
        sparseIntArray.put(R.id.realPersonIcon, 4);
        sparseIntArray.put(R.id.endLayout, 5);
        sparseIntArray.put(R.id.arrow, 6);
        sparseIntArray.put(R.id.goddess, 7);
        sparseIntArray.put(R.id.realText, 8);
        sparseIntArray.put(2131364717, 9);
        sparseIntArray.put(R.id.linearLayout, 10);
        sparseIntArray.put(R.id.daily_tasks_recycler, 11);
        sparseIntArray.put(R.id.growth_tasks_recycler, 12);
    }

    public FragmentRealTaskBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private FragmentRealTaskBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[6], (RecyclerView) objArr[11], (FrameLayout) objArr[5], (TextView) objArr[7], (RecyclerView) objArr[12], (LinearLayoutCompat) objArr[10], (ConstraintLayout) objArr[1], (View) objArr[3], (TextView) objArr[2], (ImageView) objArr[4], (TextView) objArr[8], (NestedScrollView) objArr[9]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
