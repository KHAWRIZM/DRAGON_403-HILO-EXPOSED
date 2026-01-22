package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CellFansBindingImpl extends CellFansBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rootLinear, 1);
        sparseIntArray.put(R.id.icon_circle_image_view, 2);
        sparseIntArray.put(2131363182, 3);
        sparseIntArray.put(R.id.unread_pot_view, 4);
        sparseIntArray.put(R.id.icon_circle_l_2_b_image_view, 5);
        sparseIntArray.put(R.id.textFrameLayout, 6);
        sparseIntArray.put(R.id.title_text_view, 7);
        sparseIntArray.put(R.id.textShade, 8);
        sparseIntArray.put(R.id.title_right_tag_text_view, 9);
        sparseIntArray.put(R.id.nickname_text_view, 10);
        sparseIntArray.put(R.id.subtitle_left_icon_image_view, 11);
        sparseIntArray.put(2131364944, 12);
        sparseIntArray.put(R.id.end_top_text_view, 13);
        sparseIntArray.put(R.id.time_vertical_line_view, 14);
        sparseIntArray.put(R.id.time_text_view, 15);
        sparseIntArray.put(R.id.end_icon_image_view, 16);
        sparseIntArray.put(R.id.end_text_view, 17);
        sparseIntArray.put(R.id.video_call_button, 18);
        sparseIntArray.put(R.id.like_call_button, 19);
        sparseIntArray.put(2131363173, 20);
    }

    public CellFansBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 21, sIncludes, sViewsWithIds));
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

    private CellFansBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[16], (AppCompatTextView) objArr[17], (AppCompatTextView) objArr[13], (QMUIRadiusImageView) objArr[2], (AppCompatImageView) objArr[5], (ImageView) objArr[20], (ImageView) objArr[3], (AppCompatButton) objArr[19], (AppCompatTextView) objArr[10], (LinearLayoutCompat) objArr[1], (AppCompatImageView) objArr[11], (AppCompatTextView) objArr[12], (ConstraintLayout) objArr[6], (ImageView) objArr[8], (AppCompatTextView) objArr[15], (View) objArr[14], (GenderAgeTextView) objArr[9], (AppCompatTextView) objArr[7], (View) objArr[4], (AppCompatButton) objArr[18]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
