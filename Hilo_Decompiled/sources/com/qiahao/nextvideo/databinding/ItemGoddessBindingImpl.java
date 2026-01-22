package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemGoddessBindingImpl extends ItemGoddessBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363201, 1);
        sparseIntArray.put(2131364906, 2);
        sparseIntArray.put(2131364905, 3);
        sparseIntArray.put(2131364904, 4);
        sparseIntArray.put(R.id.priceText, 5);
        sparseIntArray.put(R.id.centerLayout, 6);
        sparseIntArray.put(R.id.age_text_view, 7);
        sparseIntArray.put(R.id.from_country_image_view, 8);
        sparseIntArray.put(2131363173, 9);
        sparseIntArray.put(2131363182, 10);
        sparseIntArray.put(2131364012, 11);
        sparseIntArray.put(R.id.videoImageView, 12);
        sparseIntArray.put(R.id.likeImageView, 13);
    }

    public ItemGoddessBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private ItemGoddessBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[7], (LinearLayoutCompat) objArr[6], (AppCompatImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (QMUIRadiusImageView2) objArr[1], (AppCompatImageView) objArr[13], (AppCompatTextView) objArr[11], (AppCompatTextView) objArr[5], (AppCompatTextView) objArr[4], (ImageView) objArr[3], (LinearLayout) objArr[2], (AppCompatImageView) objArr[12]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
