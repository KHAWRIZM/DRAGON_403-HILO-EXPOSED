package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.FitRatioFrameLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CellOnlineBindingImpl extends CellOnlineBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.background_fit_ratio_frame_layout, 1);
        sparseIntArray.put(R.id.background_cornered_image_view, 2);
        sparseIntArray.put(R.id.nickname_text_view, 3);
        sparseIntArray.put(R.id.age_text_view, 4);
        sparseIntArray.put(R.id.from_country_image_view, 5);
        sparseIntArray.put(2131363173, 6);
        sparseIntArray.put(2131363182, 7);
        sparseIntArray.put(R.id.like_image_view, 8);
        sparseIntArray.put(R.id.chat_image_view, 9);
        sparseIntArray.put(R.id.like_svga_image_view, 10);
    }

    public CellOnlineBindingImpl(f fVar, View view) {
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

    private CellOnlineBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[4], (CorneredImageView) objArr[2], (FitRatioFrameLayout) objArr[1], (FrameLayout) objArr[0], (SVGAImageView) objArr[9], (AppCompatImageView) objArr[5], (ImageView) objArr[6], (ImageView) objArr[7], (AppCompatImageView) objArr[8], (SVGAImageView) objArr[10], (AppCompatTextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.cellFeedParentContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
