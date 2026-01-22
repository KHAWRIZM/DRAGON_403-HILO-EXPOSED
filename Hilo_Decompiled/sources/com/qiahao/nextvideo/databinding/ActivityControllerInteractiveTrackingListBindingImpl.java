package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityControllerInteractiveTrackingListBindingImpl extends ActivityControllerInteractiveTrackingListBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.linearLayout, 1);
        sparseIntArray.put(2131365217, 2);
        sparseIntArray.put(R.id.back_image_view, 3);
        sparseIntArray.put(R.id.common_tab_layout, 4);
        sparseIntArray.put(R.id.common_id_content_container, 5);
        sparseIntArray.put(R.id.common_id_recycler_view, 6);
        sparseIntArray.put(R.id.empty_tip_text_view, 7);
        sparseIntArray.put(R.id.view_pager2, 8);
        sparseIntArray.put(R.id.like_svga_image_view, 9);
    }

    public ActivityControllerInteractiveTrackingListBindingImpl(f fVar, View view) {
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

    private ActivityControllerInteractiveTrackingListBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[3], (FrameLayout) objArr[5], (RecyclerView) objArr[6], (SlidingTabLayout) objArr[4], (AppCompatTextView) objArr[7], (SVGAImageView) objArr[9], (LinearLayout) objArr[1], (Toolbar) objArr[2], (ViewPager) objArr[8]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
