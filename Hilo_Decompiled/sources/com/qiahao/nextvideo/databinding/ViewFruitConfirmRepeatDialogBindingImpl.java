package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewFruitConfirmRepeatDialogBindingImpl extends ViewFruitConfirmRepeatDialogBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365408, 1);
        sparseIntArray.put(R.id.diamondIcon, 2);
        sparseIntArray.put(R.id.diamond, 3);
        sparseIntArray.put(R.id.ivCheckBox, 4);
        sparseIntArray.put(R.id.tvDontShowNext, 5);
        sparseIntArray.put(R.id.tvConfirm, 6);
        sparseIntArray.put(R.id.tvCancel, 7);
    }

    public ViewFruitConfirmRepeatDialogBindingImpl(f fVar, View view) {
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

    private ViewFruitConfirmRepeatDialogBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (TextView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (AppCompatTextView) objArr[5], (AppCompatTextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.constraint.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
