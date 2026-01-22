package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SplashAdvertisingViewBindingImpl extends SplashAdvertisingViewBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bg_advertising_image_view, 1);
        sparseIntArray.put(R.id.cp_week_layout, 2);
        sparseIntArray.put(R.id.cp_bg, 3);
        sparseIntArray.put(R.id.fl_cp_avatar1, 4);
        sparseIntArray.put(R.id.cp_avatar1, 5);
        sparseIntArray.put(R.id.fl_cp_avatar2, 6);
        sparseIntArray.put(R.id.cp_avatar2, 7);
        sparseIntArray.put(R.id.cp_nick_1, 8);
        sparseIntArray.put(R.id.cp_center, 9);
        sparseIntArray.put(R.id.cp_nick_2, 10);
        sparseIntArray.put(R.id.week_star_layout, 11);
        sparseIntArray.put(R.id.week_star_bg, 12);
        sparseIntArray.put(R.id.week_star_avatar, 13);
        sparseIntArray.put(R.id.week_star_avatar_bg, 14);
        sparseIntArray.put(R.id.crown, 15);
        sparseIntArray.put(R.id.text_week_star, 16);
        sparseIntArray.put(R.id.week_star_nick, 17);
        sparseIntArray.put(R.id.countryLayout, 18);
        sparseIntArray.put(R.id.countryBg, 19);
        sparseIntArray.put(R.id.countryImage, 20);
        sparseIntArray.put(R.id.count_text, 21);
    }

    public SplashAdvertisingViewBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 22, sIncludes, sViewsWithIds));
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

    private SplashAdvertisingViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[1], (ConstraintLayout) objArr[0], (TextView) objArr[21], (ImageView) objArr[19], (CircleImageView) objArr[20], (ConstraintLayout) objArr[18], (CircleImageView) objArr[5], (CircleImageView) objArr[7], (ImageView) objArr[3], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[10], (ConstraintLayout) objArr[2], (ImageView) objArr[15], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[6], (ImageView) objArr[16], (CircleImageView) objArr[13], (ImageView) objArr[14], (ImageView) objArr[12], (ConstraintLayout) objArr[11], (TextView) objArr[17]);
        this.mDirtyFlags = -1L;
        this.bgContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
