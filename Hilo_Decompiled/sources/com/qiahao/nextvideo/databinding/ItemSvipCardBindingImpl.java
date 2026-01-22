package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemSvipCardBindingImpl extends ItemSvipCardBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131362100, 2);
        sparseIntArray.put(2131364343, 3);
        sparseIntArray.put(R.id.tipLayout, 4);
        sparseIntArray.put(R.id.gradingImage, 5);
        sparseIntArray.put(R.id.date, 6);
        sparseIntArray.put(2131364936, 7);
        sparseIntArray.put(R.id.grading, 8);
        sparseIntArray.put(R.id.number, 9);
        sparseIntArray.put(2131363072, 10);
        sparseIntArray.put(R.id.defaultText, 11);
        sparseIntArray.put(2131364958, 12);
    }

    public ItemSvipCardBindingImpl(f fVar, View view) {
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

    private ItemSvipCardBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[2], (ConstraintLayout) objArr[1], (TextView) objArr[6], (TextView) objArr[11], (TextView) objArr[8], (ImageView) objArr[5], (Group) objArr[10], (TextView) objArr[9], (CustomProgressView) objArr[3], (TextView) objArr[7], (SVGAImageView) objArr[12], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
