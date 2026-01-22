package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogStrangeLikeBindingImpl extends DialogStrangeLikeBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.topBg, 2);
        sparseIntArray.put(R.id.close, 3);
        sparseIntArray.put(R.id.leftAvatar, 4);
        sparseIntArray.put(R.id.rightAvatar, 5);
        sparseIntArray.put(R.id.centerImage, 6);
        sparseIntArray.put(2131365189, 7);
        sparseIntArray.put(2131362440, 8);
        sparseIntArray.put(R.id.like, 9);
        sparseIntArray.put(R.id.likeSvga, 10);
    }

    public DialogStrangeLikeBindingImpl(f fVar, View view) {
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

    private DialogStrangeLikeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[6], (ImageView) objArr[3], (ConstraintLayout) objArr[1], (TextView) objArr[8], (FrameLayout) objArr[0], (QMUIRadiusImageView) objArr[4], (TextView) objArr[9], (SVGAImageView) objArr[10], (QMUIRadiusImageView) objArr[5], (TextView) objArr[7], (View) objArr[2]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
