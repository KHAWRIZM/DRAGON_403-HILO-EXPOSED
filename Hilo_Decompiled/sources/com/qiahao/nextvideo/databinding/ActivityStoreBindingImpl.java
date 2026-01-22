package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityStoreBindingImpl extends ActivityStoreBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.base_root, 1);
        sparseIntArray.put(R.id.title_bg_back, 2);
        sparseIntArray.put(2131365217, 3);
        sparseIntArray.put(R.id.back_image_view, 4);
        sparseIntArray.put(R.id.my_bag, 5);
        sparseIntArray.put(2131365536, 6);
        sparseIntArray.put(R.id.img_avatar_head, 7);
        sparseIntArray.put(R.id.svga_avatar_head, 8);
        sparseIntArray.put(R.id.tabLayout, 9);
        sparseIntArray.put(2131365640, 10);
        sparseIntArray.put(R.id.bottom_bg, 11);
        sparseIntArray.put(R.id.diamondIcon, 12);
        sparseIntArray.put(R.id.diamond_day, 13);
        sparseIntArray.put(R.id.text_bay, 14);
        sparseIntArray.put(R.id.text_send, 15);
        sparseIntArray.put(R.id.relationSend, 16);
    }

    public ActivityStoreBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
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

    private ActivityStoreBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[4], (ConstraintLayout) objArr[1], (View) objArr[11], (TextView) objArr[13], (ImageView) objArr[12], (ImageView) objArr[7], (AppCompatTextView) objArr[5], (TextView) objArr[16], (SVGAImageView) objArr[8], (SlidingTabLayout) objArr[9], (TextView) objArr[14], (TextView) objArr[15], (View) objArr[2], (Toolbar) objArr[3], (CircleImageView) objArr[6], (ViewPager) objArr[10]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
