package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemContactLikeMeOtherBindingImpl extends ItemContactLikeMeOtherBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_avatar_cimage_view, 1);
        sparseIntArray.put(2131363182, 2);
        sparseIntArray.put(R.id.online_status, 3);
        sparseIntArray.put(2131365557, 4);
        sparseIntArray.put(R.id.heart_free, 5);
        sparseIntArray.put(R.id.ll_level, 6);
        sparseIntArray.put(R.id.country_image, 7);
        sparseIntArray.put(R.id.age_text_view, 8);
        sparseIntArray.put(2131365691, 9);
        sparseIntArray.put(2131362273, 10);
        sparseIntArray.put(R.id.activity_level, 11);
        sparseIntArray.put(R.id.icon_selection, 12);
    }

    public ItemContactLikeMeOtherBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private ItemContactLikeMeOtherBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[11], (GenderAgeTextView) objArr[8], (HiloGradeView) objArr[10], (ImageView) objArr[7], (ImageView) objArr[5], (ImageView) objArr[12], (ImageView) objArr[2], (LinearLayout) objArr[6], (View) objArr[3], (CircleImageView) objArr[1], (TextView) objArr[4], (HiloGradeView) objArr[9]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
