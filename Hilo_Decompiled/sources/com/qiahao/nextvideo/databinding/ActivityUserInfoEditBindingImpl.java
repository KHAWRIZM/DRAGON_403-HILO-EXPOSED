package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityUserInfoEditBindingImpl extends ActivityUserInfoEditBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 1);
        sparseIntArray.put(R.id.back_image_view, 2);
        sparseIntArray.put(R.id.imge, 3);
        sparseIntArray.put(R.id.user_head_circle_image_view_frame_layout, 4);
        sparseIntArray.put(R.id.user_head_circle_image_view, 5);
        sparseIntArray.put(R.id.pic_recycler, 6);
        sparseIntArray.put(R.id.nickname_cell_linear_layout, 7);
        sparseIntArray.put(R.id.nickname_text_view, 8);
        sparseIntArray.put(R.id.country_cell_linear_layout, 9);
        sparseIntArray.put(R.id.country_symbol_image_view, 10);
        sparseIntArray.put(R.id.country_text_view, 11);
        sparseIntArray.put(R.id.signature_cell_linear_layout, 12);
        sparseIntArray.put(R.id.signature_text_view, 13);
        sparseIntArray.put(R.id.sex_cell_linear_layout, 14);
        sparseIntArray.put(R.id.sex_text_view, 15);
        sparseIntArray.put(R.id.show_age_switch_view, 16);
    }

    public ActivityUserInfoEditBindingImpl(f fVar, View view) {
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

    private ActivityUserInfoEditBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[2], (LinearLayoutCompat) objArr[9], (AppCompatImageView) objArr[10], (AppCompatTextView) objArr[11], (AppCompatImageView) objArr[3], (LinearLayoutCompat) objArr[7], (AppCompatTextView) objArr[8], (RecyclerView) objArr[6], (LinearLayoutCompat) objArr[14], (AppCompatTextView) objArr[15], (SwitchButton) objArr[16], (LinearLayoutCompat) objArr[12], (AppCompatTextView) objArr[13], (Toolbar) objArr[1], (CircleImageView) objArr[5], (FrameLayout) objArr[4]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
