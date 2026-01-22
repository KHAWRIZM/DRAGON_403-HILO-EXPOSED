package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeGameHeadBindingImpl extends FragmentHomeGameHeadBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.empty, 1);
        sparseIntArray.put(R.id.ludo, 2);
        sparseIntArray.put(R.id.uno, 3);
        sparseIntArray.put(R.id.ludoImg, 4);
        sparseIntArray.put(R.id.ludoText, 5);
        sparseIntArray.put(R.id.unoImg, 6);
        sparseIntArray.put(R.id.unoText, 7);
        sparseIntArray.put(2131363072, 8);
        sparseIntArray.put(R.id.gameRecyclerView, 9);
        sparseIntArray.put(R.id.findTitle, 10);
    }

    public FragmentHomeGameHeadBindingImpl(f fVar, View view) {
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FragmentHomeGameHeadBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, r0 != null ? BaseStatusEmptyBinding.bind((View) r0) : null, (TextView) objArr[10], (RecyclerView) objArr[9], (Group) objArr[8], (ImageView) objArr[2], (TextView) objArr[4], (TextView) objArr[5], (ImageView) objArr[3], (TextView) objArr[6], (TextView) objArr[7]);
        Object obj = objArr[1];
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
