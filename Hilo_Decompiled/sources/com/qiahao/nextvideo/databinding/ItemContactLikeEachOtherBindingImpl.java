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
public class ItemContactLikeEachOtherBindingImpl extends ItemContactLikeEachOtherBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_avatar_cimage_view, 1);
        sparseIntArray.put(2131363182, 2);
        sparseIntArray.put(2131363173, 3);
        sparseIntArray.put(R.id.online_status, 4);
        sparseIntArray.put(2131365557, 5);
        sparseIntArray.put(R.id.heart_free, 6);
        sparseIntArray.put(R.id.ll_level, 7);
        sparseIntArray.put(R.id.country_image, 8);
        sparseIntArray.put(R.id.age_text_view, 9);
        sparseIntArray.put(2131365691, 10);
        sparseIntArray.put(2131362273, 11);
        sparseIntArray.put(R.id.activity_level, 12);
        sparseIntArray.put(R.id.icon_selection, 13);
    }

    public ItemContactLikeEachOtherBindingImpl(f fVar, View view) {
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

    private ItemContactLikeEachOtherBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[12], (GenderAgeTextView) objArr[9], (HiloGradeView) objArr[11], (ImageView) objArr[8], (ImageView) objArr[6], (ImageView) objArr[3], (ImageView) objArr[13], (ImageView) objArr[2], (LinearLayout) objArr[7], (View) objArr[4], (CircleImageView) objArr[1], (TextView) objArr[5], (HiloGradeView) objArr[10]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
