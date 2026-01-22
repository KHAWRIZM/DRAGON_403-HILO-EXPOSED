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
public class GiftBannerView3BindingImpl extends GiftBannerView3Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cpUpgradesLayout, 1);
        sparseIntArray.put(R.id.cpUpgradesSVGA, 2);
        sparseIntArray.put(R.id.rightAvatar2, 3);
        sparseIntArray.put(R.id.leftAvatar2, 4);
        sparseIntArray.put(R.id.leftName2, 5);
        sparseIntArray.put(R.id.addText, 6);
        sparseIntArray.put(R.id.rightName2, 7);
        sparseIntArray.put(R.id.content2, 8);
        sparseIntArray.put(R.id.model2, 9);
    }

    public GiftBannerView3BindingImpl(f fVar, View view) {
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

    private GiftBannerView3BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[6], (TextView) objArr[8], (ConstraintLayout) objArr[1], (SVGAImageView) objArr[2], (QMUIRadiusImageView) objArr[4], (TextView) objArr[5], (ImageView) objArr[9], (QMUIRadiusImageView) objArr[3], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
