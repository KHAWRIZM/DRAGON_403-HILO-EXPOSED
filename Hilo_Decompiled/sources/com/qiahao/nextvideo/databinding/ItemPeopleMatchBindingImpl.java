package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemPeopleMatchBindingImpl extends ItemPeopleMatchBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362013, 1);
        sparseIntArray.put(2131363182, 2);
        sparseIntArray.put(2131363173, 3);
        sparseIntArray.put(2131365557, 4);
        sparseIntArray.put(R.id.gameIcon, 5);
        sparseIntArray.put(R.id.video_call_button, 6);
        sparseIntArray.put(R.id.like_call_button, 7);
        sparseIntArray.put(R.id.ll_level, 8);
        sparseIntArray.put(R.id.country_image, 9);
        sparseIntArray.put(R.id.age_text_view, 10);
        sparseIntArray.put(2131365691, 11);
        sparseIntArray.put(2131362273, 12);
        sparseIntArray.put(R.id.activity_level, 13);
    }

    public ItemPeopleMatchBindingImpl(f fVar, View view) {
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

    private ItemPeopleMatchBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[13], (GenderAgeTextView) objArr[10], (CircleImageView) objArr[1], (HiloGradeView) objArr[12], (ImageView) objArr[9], (ImageView) objArr[5], (ImageView) objArr[3], (ImageView) objArr[2], (AppCompatButton) objArr[7], (LinearLayout) objArr[8], (TextView) objArr[4], (AppCompatButton) objArr[6], (HiloGradeView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
