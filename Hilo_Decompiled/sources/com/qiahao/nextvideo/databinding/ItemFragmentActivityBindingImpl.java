package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemFragmentActivityBindingImpl extends ItemFragmentActivityBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.headerImage, 1);
        sparseIntArray.put(R.id.nickName, 2);
        sparseIntArray.put(R.id.idText, 3);
        sparseIntArray.put(R.id.number, 4);
        sparseIntArray.put(R.id.numberImage, 5);
        sparseIntArray.put(R.id.centerImage, 6);
        sparseIntArray.put(R.id.centerBg, 7);
        sparseIntArray.put(2131364906, 8);
        sparseIntArray.put(2131364905, 9);
        sparseIntArray.put(2131364904, 10);
        sparseIntArray.put(2131365159, 11);
        sparseIntArray.put(2131365154, 12);
        sparseIntArray.put(2131365189, 13);
        sparseIntArray.put(2131363295, 14);
        sparseIntArray.put(2131363296, 15);
        sparseIntArray.put(2131363297, 16);
    }

    public ItemFragmentActivityBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
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

    private ItemFragmentActivityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[7], (QMUIRadiusImageView2) objArr[6], (QMUIRadiusImageView2) objArr[1], (ShineTextView) objArr[3], (LinearLayout) objArr[14], (ImageView) objArr[15], (TextView) objArr[16], (TextView) objArr[2], (TextView) objArr[4], (ImageView) objArr[5], (AppCompatTextView) objArr[10], (ImageView) objArr[9], (LinearLayout) objArr[8], (AppCompatTextView) objArr[12], (ImageView) objArr[11], (AppCompatTextView) objArr[13]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
