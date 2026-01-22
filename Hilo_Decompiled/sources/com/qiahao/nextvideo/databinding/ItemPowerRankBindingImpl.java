package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemPowerRankBindingImpl extends ItemPowerRankBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.top1_all_view, 1);
        sparseIntArray.put(R.id.top1_title, 2);
        sparseIntArray.put(R.id.top_1_text, 3);
        sparseIntArray.put(R.id.top2_all_view, 4);
        sparseIntArray.put(R.id.top2_title, 5);
        sparseIntArray.put(R.id.top_2_text, 6);
        sparseIntArray.put(R.id.top3_all_view, 7);
        sparseIntArray.put(R.id.top3_title, 8);
        sparseIntArray.put(R.id.top_3_text, 9);
        sparseIntArray.put(R.id.list_position, 10);
        sparseIntArray.put(R.id.user_avatar_irregular_view, 11);
        sparseIntArray.put(R.id.user_avatar_irregular_view_bg, 12);
        sparseIntArray.put(R.id.room_name, 13);
        sparseIntArray.put(R.id.number_member, 14);
        sparseIntArray.put(R.id.age_text_view, 15);
        sparseIntArray.put(R.id.ll_diamond, 16);
        sparseIntArray.put(R.id.diamond, 17);
        sparseIntArray.put(2131362160, 18);
    }

    public ItemPowerRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 19, sIncludes, sViewsWithIds));
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

    private ItemPowerRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[15], (View) objArr[18], (LinearLayout) objArr[0], (TextView) objArr[17], (TextView) objArr[10], (LinearLayout) objArr[16], (TextView) objArr[14], (TextView) objArr[13], (ConstraintLayout) objArr[1], (TextView) objArr[3], (ImageView) objArr[2], (ConstraintLayout) objArr[4], (TextView) objArr[6], (ImageView) objArr[5], (ConstraintLayout) objArr[7], (TextView) objArr[9], (ImageView) objArr[8], (PorterShapeImageView) objArr[11], (ImageView) objArr[12]);
        this.mDirtyFlags = -1L;
        this.contentBg.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
