package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentWalletGoldBindingImpl extends FragmentWalletGoldBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 1);
        sparseIntArray.put(2131363201, 2);
        sparseIntArray.put(R.id.beans_count_tick_text_view, 3);
        sparseIntArray.put(R.id.banner, 4);
        sparseIntArray.put(R.id.recharge, 5);
        sparseIntArray.put(2131364510, 6);
        sparseIntArray.put(R.id.contact_us_text_view, 7);
    }

    public FragmentWalletGoldBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 8, sIncludes, sViewsWithIds));
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

    private FragmentWalletGoldBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (BannerViewPager) objArr[4], (DiamondTickTextView) objArr[3], (AppCompatTextView) objArr[7], (ImageView) objArr[2], (TextView) objArr[5], (RecyclerView) objArr[6], (ConstraintLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
