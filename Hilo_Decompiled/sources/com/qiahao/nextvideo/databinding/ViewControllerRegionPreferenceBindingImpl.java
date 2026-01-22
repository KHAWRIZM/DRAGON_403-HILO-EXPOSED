package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerRegionPreferenceBindingImpl extends ViewControllerRegionPreferenceBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.description_text, 1);
        sparseIntArray.put(R.id.global_linear_layout, 2);
        sparseIntArray.put(R.id.global_image_view, 3);
        sparseIntArray.put(R.id.global_check_box, 4);
        sparseIntArray.put(R.id.current_country_linear_layout, 5);
        sparseIntArray.put(R.id.current_country_image_view, 6);
        sparseIntArray.put(R.id.user_of_current_text_view, 7);
        sparseIntArray.put(R.id.region_preference_fee_text_view, 8);
        sparseIntArray.put(R.id.current_country_check_box, 9);
        sparseIntArray.put(2131362424, 10);
    }

    public ViewControllerRegionPreferenceBindingImpl(f fVar, View view) {
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

    private ViewControllerRegionPreferenceBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatButton) objArr[10], (AppCompatCheckBox) objArr[9], (AppCompatImageView) objArr[6], (LinearLayoutCompat) objArr[5], (AppCompatTextView) objArr[1], (AppCompatCheckBox) objArr[4], (AppCompatImageView) objArr[3], (LinearLayoutCompat) objArr[2], (AppCompatTextView) objArr[8], (AppCompatTextView) objArr[7]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
