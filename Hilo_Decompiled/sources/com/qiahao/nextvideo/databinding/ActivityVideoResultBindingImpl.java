package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityVideoResultBindingImpl extends ActivityVideoResultBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bar, 1);
        sparseIntArray.put(R.id.backImageView, 2);
        sparseIntArray.put(R.id.reportImage, 3);
        sparseIntArray.put(R.id.userAvatar, 4);
        sparseIntArray.put(R.id.vip, 5);
        sparseIntArray.put(R.id.nickName, 6);
        sparseIntArray.put(R.id.linearLayout, 7);
        sparseIntArray.put(R.id.ageTextView, 8);
        sparseIntArray.put(R.id.countryImage, 9);
        sparseIntArray.put(R.id.countryName, 10);
        sparseIntArray.put(2131365152, 11);
        sparseIntArray.put(R.id.callDuration, 12);
        sparseIntArray.put(R.id.revenueLayout, 13);
        sparseIntArray.put(R.id.revenueText, 14);
        sparseIntArray.put(R.id.revenueNum, 15);
        sparseIntArray.put(R.id.revenueIcon, 16);
        sparseIntArray.put(R.id.proceedsLayout, 17);
        sparseIntArray.put(R.id.proceedsText, 18);
        sparseIntArray.put(R.id.proceedsNum, 19);
        sparseIntArray.put(R.id.proceedsIcon, 20);
    }

    public ActivityVideoResultBindingImpl(f fVar, View view) {
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

    private ActivityVideoResultBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[8], (AppCompatImageView) objArr[2], (View) objArr[1], (AppCompatTextView) objArr[12], (ImageView) objArr[9], (AppCompatTextView) objArr[10], (LinearLayoutCompat) objArr[7], (AppCompatTextView) objArr[6], (ImageView) objArr[20], (ConstraintLayout) objArr[17], (AppCompatTextView) objArr[19], (AppCompatTextView) objArr[18], (AppCompatImageView) objArr[3], (ImageView) objArr[16], (ConstraintLayout) objArr[13], (AppCompatTextView) objArr[15], (AppCompatTextView) objArr[14], (AppCompatTextView) objArr[11], (CircleImageView) objArr[4], (AppCompatImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
