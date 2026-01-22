package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemFamilySearchMemberBindingImpl extends ItemFamilySearchMemberBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_avatar_cimage_view, 1);
        sparseIntArray.put(2131365557, 2);
        sparseIntArray.put(R.id.svipType, 3);
        sparseIntArray.put(R.id.memberType, 4);
        sparseIntArray.put(R.id.age_text_view, 5);
        sparseIntArray.put(2131365691, 6);
        sparseIntArray.put(2131362273, 7);
        sparseIntArray.put(R.id.activity_level, 8);
        sparseIntArray.put(R.id.user_id, 9);
        sparseIntArray.put(2131363500, 10);
    }

    public ItemFamilySearchMemberBindingImpl(f fVar, View view) {
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

    private ItemFamilySearchMemberBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[8], (GenderAgeTextView) objArr[5], (HiloGradeView) objArr[7], (View) objArr[10], (TextView) objArr[4], (ImageView) objArr[3], (QMUIRadiusImageView) objArr[1], (ShineTextView) objArr[9], (TextView) objArr[2], (HiloGradeView) objArr[6]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
