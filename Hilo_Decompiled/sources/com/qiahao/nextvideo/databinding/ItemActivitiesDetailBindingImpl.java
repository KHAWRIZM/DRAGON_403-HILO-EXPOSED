package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemActivitiesDetailBindingImpl extends ItemActivitiesDetailBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.list_position, 1);
        sparseIntArray.put(R.id.user_avatar_cimage_view, 2);
        sparseIntArray.put(2131363182, 3);
        sparseIntArray.put(2131363173, 4);
        sparseIntArray.put(2131364963, 5);
        sparseIntArray.put(2131365557, 6);
        sparseIntArray.put(R.id.age_text_view, 7);
        sparseIntArray.put(2131365691, 8);
        sparseIntArray.put(2131362273, 9);
        sparseIntArray.put(R.id.user_id, 10);
        sparseIntArray.put(2131363568, 11);
        sparseIntArray.put(R.id.ll_diamond, 12);
        sparseIntArray.put(R.id.diamond, 13);
        sparseIntArray.put(2131363500, 14);
    }

    public ItemActivitiesDetailBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 15, sIncludes, sViewsWithIds));
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

    private ItemActivitiesDetailBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[7], (HiloGradeView) objArr[9], (TextView) objArr[13], (ImageView) objArr[4], (ImageView) objArr[3], (View) objArr[14], (TextView) objArr[1], (LinearLayout) objArr[12], (MedalGridLayout) objArr[11], (ImageView) objArr[5], (HiloImageView) objArr[2], (ShineTextView) objArr[10], (NickTextView) objArr[6], (HiloGradeView) objArr[8]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
