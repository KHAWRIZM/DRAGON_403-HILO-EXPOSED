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
public class DialogOpenEnvelopeBindingImpl extends DialogOpenEnvelopeBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lightSvga, 1);
        sparseIntArray.put(2131362433, 2);
        sparseIntArray.put(2131362100, 3);
        sparseIntArray.put(2131362013, 4);
        sparseIntArray.put(R.id.openName, 5);
        sparseIntArray.put(R.id.openSubTitle, 6);
        sparseIntArray.put(R.id.openSvga, 7);
        sparseIntArray.put(R.id.openDiamondImg, 8);
        sparseIntArray.put(R.id.openDiamond, 9);
        sparseIntArray.put(2131365152, 10);
        sparseIntArray.put(R.id.envelopeDetail, 11);
        sparseIntArray.put(R.id.okBtn, 12);
        sparseIntArray.put(R.id.close, 13);
        sparseIntArray.put(R.id.flipSvga, 14);
    }

    public DialogOpenEnvelopeBindingImpl(f fVar, View view) {
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

    private DialogOpenEnvelopeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[4], (ImageView) objArr[3], (ImageView) objArr[13], (ConstraintLayout) objArr[2], (TextView) objArr[11], (SVGAImageView) objArr[14], (SVGAImageView) objArr[1], (TextView) objArr[12], (TextView) objArr[9], (ImageView) objArr[8], (TextView) objArr[5], (TextView) objArr[6], (SVGAImageView) objArr[7], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
