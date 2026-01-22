package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerDeleteAccount2BindingImpl extends ViewControllerDeleteAccount2Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.linear_layout1, 1);
        sparseIntArray.put(2131365217, 2);
        sparseIntArray.put(R.id.back_image_view, 3);
        sparseIntArray.put(R.id.linear_layout2, 4);
        sparseIntArray.put(R.id.check_agreement, 5);
        sparseIntArray.put(R.id.check, 6);
        sparseIntArray.put(2131362220, 7);
        sparseIntArray.put(R.id.delete_my_account, 8);
    }

    public ViewControllerDeleteAccount2BindingImpl(f fVar, View view) {
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

    private ViewControllerDeleteAccount2BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[3], (TextView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[5], (TextView) objArr[8], (LinearLayout) objArr[1], (LinearLayout) objArr[4], (Toolbar) objArr[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
