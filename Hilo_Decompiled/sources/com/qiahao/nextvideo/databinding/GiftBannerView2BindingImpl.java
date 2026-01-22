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
public class GiftBannerView2BindingImpl extends GiftBannerView2Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cpGiftLayout, 1);
        sparseIntArray.put(R.id.cpGiftSVGA, 2);
        sparseIntArray.put(R.id.rightAvatar1, 3);
        sparseIntArray.put(R.id.leftAvatar1, 4);
        sparseIntArray.put(R.id.cpModel1, 5);
        sparseIntArray.put(R.id.name1, 6);
        sparseIntArray.put(R.id.id1, 7);
        sparseIntArray.put(R.id.content1, 8);
        sparseIntArray.put(R.id.gift1, 9);
        sparseIntArray.put(R.id.giftNumber1, 10);
    }

    public GiftBannerView2BindingImpl(f fVar, View view) {
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

    private GiftBannerView2BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[8], (ConstraintLayout) objArr[1], (SVGAImageView) objArr[2], (ImageView) objArr[5], (ImageView) objArr[9], (TextView) objArr[10], (TextView) objArr[7], (QMUIRadiusImageView) objArr[4], (TextView) objArr[6], (QMUIRadiusImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
