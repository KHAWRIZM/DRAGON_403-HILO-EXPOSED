package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CellBillBindingImpl extends CellBillBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.icon_circle_image_view, 1);
        sparseIntArray.put(R.id.icon_circle_l_2_b_image_view, 2);
        sparseIntArray.put(R.id.icon_circle_r_2_t_text_view, 3);
        sparseIntArray.put(R.id.title_text_view, 4);
        sparseIntArray.put(R.id.title_right_tag_text_view, 5);
        sparseIntArray.put(R.id.subtitle_left_icon_image_view, 6);
        sparseIntArray.put(2131364944, 7);
        sparseIntArray.put(R.id.end_icon_image_view, 8);
        sparseIntArray.put(R.id.end_text_view, 9);
        sparseIntArray.put(R.id.end_top_text_view, 10);
    }

    public CellBillBindingImpl(f fVar, View view) {
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

    private CellBillBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[8], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[10], (CorneredImageView) objArr[1], (AppCompatImageView) objArr[2], (AppCompatTextView) objArr[3], (AppCompatImageView) objArr[6], (AppCompatTextView) objArr[7], (GenderAgeTextView) objArr[5], (AppCompatTextView) objArr[4]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
