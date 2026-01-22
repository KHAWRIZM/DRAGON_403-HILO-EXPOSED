package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemAristocracyBagBindingImpl extends ItemAristocracyBagBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.selectBg, 1);
        sparseIntArray.put(R.id.cardImage, 2);
        sparseIntArray.put(R.id.exclusiveLayout, 3);
        sparseIntArray.put(R.id.exclusiveText, 4);
        sparseIntArray.put(R.id.exclusiveNumber, 5);
        sparseIntArray.put(R.id.dayLayout, 6);
        sparseIntArray.put(R.id.dayText, 7);
        sparseIntArray.put(R.id.dayNumber, 8);
        sparseIntArray.put(R.id.number, 9);
    }

    public ItemAristocracyBagBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
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

    private ItemAristocracyBagBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[2], (ConstraintLayout) objArr[6], (TextView) objArr[8], (TextView) objArr[7], (ConstraintLayout) objArr[3], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[9], (ImageView) objArr[1]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
