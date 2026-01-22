package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemRedEnvelopeRecordBindingImpl extends ItemRedEnvelopeRecordBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365196, 1);
        sparseIntArray.put(2131365189, 2);
        sparseIntArray.put(2131365152, 3);
        sparseIntArray.put(R.id.arrowLayout, 4);
        sparseIntArray.put(R.id.arrowText, 5);
        sparseIntArray.put(R.id.arrowImg, 6);
        sparseIntArray.put(R.id.diamond, 7);
        sparseIntArray.put(R.id.diamondImg, 8);
        sparseIntArray.put(2131363500, 9);
    }

    public ItemRedEnvelopeRecordBindingImpl(f fVar, View view) {
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

    private ItemRedEnvelopeRecordBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[6], (LinearLayout) objArr[4], (TextView) objArr[5], (TextView) objArr[7], (ImageView) objArr[8], (View) objArr[9], (TextView) objArr[3], (TextView) objArr[2], (FrameLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
