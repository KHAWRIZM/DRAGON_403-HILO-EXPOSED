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
public class ItemGroupMemberOnlineBindingImpl extends ItemGroupMemberOnlineBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_avatar_cimage_view, 1);
        sparseIntArray.put(R.id.online_status, 2);
        sparseIntArray.put(2131363182, 3);
        sparseIntArray.put(2131363173, 4);
        sparseIntArray.put(2131365557, 5);
        sparseIntArray.put(R.id.ll_level, 6);
        sparseIntArray.put(2131365568, 7);
        sparseIntArray.put(R.id.country_image, 8);
        sparseIntArray.put(R.id.age_text_view, 9);
        sparseIntArray.put(R.id.wealthLevel, 10);
        sparseIntArray.put(R.id.charmLevel, 11);
        sparseIntArray.put(R.id.imag_mounts, 12);
    }

    public ItemGroupMemberOnlineBindingImpl(f fVar, View view) {
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

    private ItemGroupMemberOnlineBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[9], (HiloGradeView) objArr[11], (ImageView) objArr[8], (ImageView) objArr[4], (ImageView) objArr[3], (ImageView) objArr[12], (LinearLayout) objArr[6], (TextView) objArr[2], (CircleImageView) objArr[1], (TextView) objArr[5], (ImageView) objArr[7], (HiloGradeView) objArr[10]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
