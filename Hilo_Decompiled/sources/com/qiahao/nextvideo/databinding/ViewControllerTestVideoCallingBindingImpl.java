package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerTestVideoCallingBindingImpl extends ViewControllerTestVideoCallingBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.purchase_menu_container, 1);
        sparseIntArray.put(R.id.love_image_view, 2);
        sparseIntArray.put(R.id.gifts_panel_image_view, 3);
        sparseIntArray.put(R.id.add_time_image_view, 4);
        sparseIntArray.put(R.id.like_svga_image_view, 5);
        sparseIntArray.put(R.id.send_gift_svga_image_view, 6);
    }

    public ViewControllerTestVideoCallingBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
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

    private ViewControllerTestVideoCallingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[4], (FrameLayout) objArr[0], (AppCompatImageView) objArr[3], (SVGAImageView) objArr[5], (AppCompatImageView) objArr[2], (LinearLayoutCompat) objArr[1], (SVGAImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.baseContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
