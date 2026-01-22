package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class LayoutGlobalBroad11BindingImpl extends LayoutGlobalBroad11Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362013, 1);
        sparseIntArray.put(2131364012, 2);
        sparseIntArray.put(R.id.svipType, 3);
        sparseIntArray.put(2131363510, 4);
        sparseIntArray.put(2131365220, 5);
        sparseIntArray.put(2131363157, 6);
        sparseIntArray.put(2131362440, 7);
    }

    public LayoutGlobalBroad11BindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 8, sIncludes, sViewsWithIds));
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

    private LayoutGlobalBroad11BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[1], (ConstraintLayout) objArr[0], (TextView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[4], (TextView) objArr[2], (ImageView) objArr[3], (ImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.constraint.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
