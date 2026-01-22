package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemDialogActivityBindingImpl extends ItemDialogActivityBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.centerImage, 1);
        sparseIntArray.put(2131364906, 2);
        sparseIntArray.put(2131364905, 3);
        sparseIntArray.put(2131364904, 4);
        sparseIntArray.put(R.id.incomeLayout, 5);
        sparseIntArray.put(R.id.incomeImage, 6);
        sparseIntArray.put(R.id.incomeContent, 7);
        sparseIntArray.put(R.id.peopleLayout, 8);
        sparseIntArray.put(R.id.peopleImage, 9);
        sparseIntArray.put(R.id.peopleContent, 10);
        sparseIntArray.put(2131365159, 11);
        sparseIntArray.put(2131365154, 12);
        sparseIntArray.put(R.id.subscribeImage, 13);
        sparseIntArray.put(R.id.subscribeContent, 14);
    }

    public ItemDialogActivityBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 15, sIncludes, sViewsWithIds));
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

    private ItemDialogActivityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView2) objArr[1], (AppCompatTextView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[5], (AppCompatTextView) objArr[10], (ImageView) objArr[9], (LinearLayout) objArr[8], (AppCompatTextView) objArr[4], (ImageView) objArr[3], (LinearLayout) objArr[2], (AppCompatTextView) objArr[14], (ImageView) objArr[13], (AppCompatTextView) objArr[12], (ImageView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
