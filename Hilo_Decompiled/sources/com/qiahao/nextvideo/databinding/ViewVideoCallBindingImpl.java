package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewVideoCallBindingImpl extends ViewVideoCallBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.large_box_video_container, 1);
        sparseIntArray.put(R.id.topLayout, 2);
        sparseIntArray.put(R.id.avatar_image_view, 3);
        sparseIntArray.put(R.id.nickname_text_view, 4);
        sparseIntArray.put(R.id.country_flag_image_view, 5);
        sparseIntArray.put(R.id.country_province_text_view, 6);
        sparseIntArray.put(R.id.pending_description_text_view, 7);
        sparseIntArray.put(R.id.hangup_image_view, 8);
        sparseIntArray.put(R.id.accept_image_view, 9);
        sparseIntArray.put(R.id.cover_image_view, 10);
    }

    public ViewVideoCallBindingImpl(f fVar, View view) {
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

    private ViewVideoCallBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[9], (QMUIRadiusImageView) objArr[3], (AppCompatImageView) objArr[5], (AppCompatTextView) objArr[6], (AppCompatImageView) objArr[10], (ImageView) objArr[8], (FrameLayout) objArr[1], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[7], (LinearLayoutCompat) objArr[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
