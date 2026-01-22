package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerSvgaBindingImpl extends ViewControllerSvgaBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rocket_svga, 1);
        sparseIntArray.put(2131365217, 2);
        sparseIntArray.put(R.id.all_svga_button, 3);
        sparseIntArray.put(R.id.like_svga_button, 4);
        sparseIntArray.put(R.id.add_duration_svga_button, 5);
        sparseIntArray.put(R.id.svg_image_view, 6);
        sparseIntArray.put(R.id.like_image_view, 7);
        sparseIntArray.put(R.id.add_duration_svga_image_view, 8);
    }

    public ViewControllerSvgaBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
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

    private ViewControllerSvgaBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatButton) objArr[5], (SVGAImageView) objArr[8], (AppCompatButton) objArr[3], (SVGAImageView) objArr[7], (AppCompatButton) objArr[4], (RocketSvgaCountdownView) objArr[1], (SVGAImageView) objArr[6], (Toolbar) objArr[2]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
