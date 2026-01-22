package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerPowerTeamBindingImpl extends ViewControllerPowerTeamBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 1);
        sparseIntArray.put(R.id.back_image_view, 2);
        sparseIntArray.put(R.id.common_id_toolbar_title, 3);
        sparseIntArray.put(R.id.cl_medal_week, 4);
        sparseIntArray.put(R.id.common_tab_layout, 5);
        sparseIntArray.put(R.id.ic_question, 6);
        sparseIntArray.put(2131365640, 7);
        sparseIntArray.put(R.id.owner_recycle_view, 8);
        sparseIntArray.put(R.id.assistant_recycle_view, 9);
    }

    public ViewControllerPowerTeamBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
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

    private ViewControllerPowerTeamBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (RecyclerView) objArr[9], (AppCompatImageView) objArr[2], (ConstraintLayout) objArr[0], (ConstraintLayout) objArr[4], (AppCompatTextView) objArr[3], (CommonTabLayout) objArr[5], (ImageView) objArr[6], (RecyclerView) objArr[8], (Toolbar) objArr[1], (ViewPager) objArr[7]);
        this.mDirtyFlags = -1L;
        this.bgContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
