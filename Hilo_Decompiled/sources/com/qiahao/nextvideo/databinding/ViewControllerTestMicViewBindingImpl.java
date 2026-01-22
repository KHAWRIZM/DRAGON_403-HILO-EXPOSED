package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerTestMicViewBindingImpl extends ViewControllerTestMicViewBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 1);
        sparseIntArray.put(R.id.back_image_view, 2);
        sparseIntArray.put(2131365189, 3);
        sparseIntArray.put(R.id.change_type, 4);
        sparseIntArray.put(R.id.select_pic, 5);
        sparseIntArray.put(R.id.micro_view, 6);
        sparseIntArray.put(2131365536, 7);
        sparseIntArray.put(R.id.user_avatar1, 8);
    }

    public ViewControllerTestMicViewBindingImpl(f fVar, View view) {
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

    private ViewControllerTestMicViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[2], (TextView) objArr[4], (NewMicroView) objArr[6], (TextView) objArr[5], (AppCompatTextView) objArr[3], (Toolbar) objArr[1], (ImageView) objArr[7], (CircleImageView) objArr[8]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
