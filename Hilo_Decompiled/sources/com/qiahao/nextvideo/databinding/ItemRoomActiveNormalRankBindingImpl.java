package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemRoomActiveNormalRankBindingImpl extends ItemRoomActiveNormalRankBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131364298, 1);
        sparseIntArray.put(2131362013, 2);
        sparseIntArray.put(R.id.vip, 3);
        sparseIntArray.put(R.id.noble, 4);
        sparseIntArray.put(2131364012, 5);
        sparseIntArray.put(R.id.age_text_view, 6);
        sparseIntArray.put(2131365691, 7);
        sparseIntArray.put(2131362273, 8);
        sparseIntArray.put(R.id.user_id, 9);
        sparseIntArray.put(2131365152, 10);
    }

    public ItemRoomActiveNormalRankBindingImpl(f fVar, View view) {
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

    private ItemRoomActiveNormalRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[6], (HiloImageView) objArr[2], (HiloGradeView) objArr[8], (NickTextView) objArr[5], (ImageView) objArr[4], (TextView) objArr[1], (TextView) objArr[10], (ShineTextView) objArr[9], (ImageView) objArr[3], (HiloGradeView) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
