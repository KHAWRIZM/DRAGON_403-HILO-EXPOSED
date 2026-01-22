package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.TaskView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentGoldTaskBindingImpl extends FragmentGoldTaskBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.goldLayout, 1);
        sparseIntArray.put(R.id.goldText, 2);
        sparseIntArray.put(2131363500, 3);
        sparseIntArray.put(2131364510, 4);
        sparseIntArray.put(R.id.taskLayout, 5);
        sparseIntArray.put(R.id.tabLayout, 6);
        sparseIntArray.put(R.id.taskView, 7);
        sparseIntArray.put(2131365189, 8);
        sparseIntArray.put(2131364936, 9);
        sparseIntArray.put(R.id.question, 10);
        sparseIntArray.put(R.id.signIn, 11);
    }

    public FragmentGoldTaskBindingImpl(f fVar, View view) {
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

    private FragmentGoldTaskBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[1], (TextView) objArr[2], (View) objArr[3], (ImageView) objArr[10], (RecyclerView) objArr[4], (TextView) objArr[11], (TextView) objArr[9], (CustomTabLayout) objArr[6], (ConstraintLayout) objArr[5], (TaskView) objArr[7], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
