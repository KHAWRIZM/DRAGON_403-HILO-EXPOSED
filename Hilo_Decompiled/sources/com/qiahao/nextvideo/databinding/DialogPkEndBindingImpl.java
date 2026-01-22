package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogPkEndBindingImpl extends DialogPkEndBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362100, 1);
        sparseIntArray.put(R.id.diamond, 2);
        sparseIntArray.put(R.id.roomBg, 3);
        sparseIntArray.put(2131362013, 4);
        sparseIntArray.put(2131364012, 5);
        sparseIntArray.put(R.id.oneAvatar, 6);
        sparseIntArray.put(R.id.oneDiamond, 7);
        sparseIntArray.put(R.id.twoAvatar, 8);
        sparseIntArray.put(R.id.twoDiamond, 9);
        sparseIntArray.put(R.id.threeAvatar, 10);
        sparseIntArray.put(R.id.threeDiamond, 11);
        sparseIntArray.put(R.id.close, 12);
        sparseIntArray.put(R.id.pkSvga, 13);
    }

    public DialogPkEndBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private DialogPkEndBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[12], (GradientTextView) objArr[2], (TextView) objArr[5], (QMUIRadiusImageView) objArr[6], (TextView) objArr[7], (SVGAImageView) objArr[13], (ImageView) objArr[3], (QMUIRadiusImageView) objArr[10], (TextView) objArr[11], (QMUIRadiusImageView) objArr[8], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
