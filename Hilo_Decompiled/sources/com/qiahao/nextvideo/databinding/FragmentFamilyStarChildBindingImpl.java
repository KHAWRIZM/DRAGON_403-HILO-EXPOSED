package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentFamilyStarChildBindingImpl extends FragmentFamilyStarChildBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 1);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 2);
        sparseIntArray.put(R.id.topBg, 3);
        sparseIntArray.put(R.id.top3_platform, 4);
        sparseIntArray.put(R.id.ll_top1, 5);
        sparseIntArray.put(R.id.top1_avatar, 6);
        sparseIntArray.put(R.id.top1_name, 7);
        sparseIntArray.put(R.id.top1_id, 8);
        sparseIntArray.put(R.id.ll_diamond1, 9);
        sparseIntArray.put(R.id.diamondImage1, 10);
        sparseIntArray.put(R.id.top1_diamond, 11);
        sparseIntArray.put(R.id.ll_top2, 12);
        sparseIntArray.put(R.id.top2_avatar, 13);
        sparseIntArray.put(R.id.top2_name, 14);
        sparseIntArray.put(R.id.top2_id, 15);
        sparseIntArray.put(R.id.ll_diamond2, 16);
        sparseIntArray.put(R.id.diamondImage2, 17);
        sparseIntArray.put(R.id.top2_diamond, 18);
        sparseIntArray.put(R.id.ll_top3, 19);
        sparseIntArray.put(R.id.top3_avatar, 20);
        sparseIntArray.put(R.id.top3_name, 21);
        sparseIntArray.put(R.id.top3_id, 22);
        sparseIntArray.put(R.id.ll_diamond3, 23);
        sparseIntArray.put(R.id.diamondImage3, 24);
        sparseIntArray.put(R.id.top3_diamond, 25);
        sparseIntArray.put(R.id.statusView, 26);
        sparseIntArray.put(2131364510, 27);
    }

    public FragmentFamilyStarChildBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 28, sIncludes, sViewsWithIds));
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

    private FragmentFamilyStarChildBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CollapsingToolbarLayout) objArr[2], (ImageView) objArr[10], (ImageView) objArr[17], (ImageView) objArr[24], (LinearLayout) objArr[9], (LinearLayout) objArr[16], (LinearLayout) objArr[23], (LinearLayout) objArr[5], (LinearLayout) objArr[12], (LinearLayout) objArr[19], (RecyclerView) objArr[27], (SmartRefreshLayout) objArr[1], (SuperStatusView) objArr[26], (CircleImageView) objArr[6], (TextView) objArr[11], (ShineTextView) objArr[8], (TextView) objArr[7], (CircleImageView) objArr[13], (TextView) objArr[18], (ShineTextView) objArr[15], (TextView) objArr[14], (CircleImageView) objArr[20], (TextView) objArr[25], (ShineTextView) objArr[22], (TextView) objArr[21], (ImageView) objArr[4], (ImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
