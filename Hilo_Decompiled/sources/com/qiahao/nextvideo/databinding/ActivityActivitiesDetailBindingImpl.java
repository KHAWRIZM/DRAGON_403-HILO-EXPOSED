package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityActivitiesDetailBindingImpl extends ActivityActivitiesDetailBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 1);
        sparseIntArray.put(R.id.bar, 2);
        sparseIntArray.put(R.id.backImageView, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(R.id.more, 5);
        sparseIntArray.put(R.id.refreshLayout, 6);
        sparseIntArray.put(R.id.common_id_content_container, 7);
        sparseIntArray.put(2131365217, 8);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 9);
        sparseIntArray.put(R.id.centerImage, 10);
        sparseIntArray.put(2131364906, 11);
        sparseIntArray.put(2131364905, 12);
        sparseIntArray.put(2131364904, 13);
        sparseIntArray.put(2131365159, 14);
        sparseIntArray.put(2131365154, 15);
        sparseIntArray.put(2131362440, 16);
        sparseIntArray.put(R.id.subContent, 17);
        sparseIntArray.put(R.id.headerImage, 18);
        sparseIntArray.put(R.id.nickName, 19);
        sparseIntArray.put(R.id.idText, 20);
        sparseIntArray.put(2131363056, 21);
        sparseIntArray.put(R.id.centerLayout, 22);
        sparseIntArray.put(R.id.rankBg, 23);
        sparseIntArray.put(R.id.trophyLayout, 24);
        sparseIntArray.put(R.id.trophyNumber, 25);
        sparseIntArray.put(R.id.peopleLayout, 26);
        sparseIntArray.put(R.id.peopleNumber, 27);
        sparseIntArray.put(R.id.statusView, 28);
        sparseIntArray.put(2131364510, 29);
        sparseIntArray.put(R.id.buttonLayout, 30);
        sparseIntArray.put(2131363295, 31);
        sparseIntArray.put(2131363296, 32);
        sparseIntArray.put(2131363297, 33);
    }

    public ActivityActivitiesDetailBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 34, sIncludes, sViewsWithIds));
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

    private ActivityActivitiesDetailBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[3], (View) objArr[2], (FrameLayout) objArr[30], (QMUIRadiusImageView2) objArr[10], (ConstraintLayout) objArr[22], (CollapsingToolbarLayout) objArr[9], (CoordinatorLayout) objArr[7], (AppCompatTextView) objArr[16], (TextView) objArr[21], (QMUIRadiusImageView2) objArr[18], (TextView) objArr[20], (LinearLayout) objArr[31], (ImageView) objArr[32], (TextView) objArr[33], (ImageView) objArr[5], (TextView) objArr[19], (LinearLayout) objArr[26], (TextView) objArr[27], (ImageView) objArr[23], (RecyclerView) objArr[29], (SmartRefreshLayout) objArr[6], (AppCompatTextView) objArr[13], (ImageView) objArr[12], (LinearLayout) objArr[11], (SuperStatusView) objArr[28], (AppCompatTextView) objArr[17], (AppCompatTextView) objArr[15], (ImageView) objArr[14], (TextView) objArr[4], (AppBarLayout) objArr[8], (ConstraintLayout) objArr[1], (LinearLayout) objArr[24], (TextView) objArr[25]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
