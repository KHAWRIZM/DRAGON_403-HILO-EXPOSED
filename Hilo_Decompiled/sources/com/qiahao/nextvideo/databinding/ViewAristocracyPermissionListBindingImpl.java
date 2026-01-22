package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewAristocracyPermissionListBindingImpl extends ViewAristocracyPermissionListBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.permission_number, 1);
        sparseIntArray.put(R.id.aristocracyLayout8, 2);
        sparseIntArray.put(2131363201, 3);
        sparseIntArray.put(R.id.number, 4);
        sparseIntArray.put(R.id.aristocracyLayoutTitle, 5);
        sparseIntArray.put(R.id.aristocracyLayoutSubTitle, 6);
        sparseIntArray.put(R.id.receive, 7);
        sparseIntArray.put(R.id.aristocracyLayout9, 8);
        sparseIntArray.put(R.id.image9, 9);
        sparseIntArray.put(R.id.number9, 10);
        sparseIntArray.put(R.id.aristocracyLayoutTitle9, 11);
        sparseIntArray.put(R.id.aristocracyLayoutSubTitle9, 12);
        sparseIntArray.put(R.id.receive9, 13);
        sparseIntArray.put(2131364507, 14);
        sparseIntArray.put(R.id.tip2, 15);
    }

    public ViewAristocracyPermissionListBindingImpl(f fVar, View view) {
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

    private ViewAristocracyPermissionListBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[8], (TextView) objArr[6], (TextView) objArr[12], (TextView) objArr[5], (TextView) objArr[11], (ImageView) objArr[3], (ImageView) objArr[9], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[1], (TextView) objArr[7], (TextView) objArr[13], (RecyclerView) objArr[14], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
