package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerVipBindingImpl extends ViewControllerVipBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_root, 1);
        sparseIntArray.put(2131362440, 2);
        sparseIntArray.put(R.id.banner_view, 3);
        sparseIntArray.put(R.id.get_vip, 4);
        sparseIntArray.put(R.id.get_vip_or_vip_end_time, 5);
        sparseIntArray.put(R.id.month_money_or_end_time, 6);
        sparseIntArray.put(R.id.next_time, 7);
        sparseIntArray.put(2131365027, 8);
        sparseIntArray.put(R.id.description_text, 9);
    }

    public ViewControllerVipBindingImpl(f fVar, View view) {
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

    private ViewControllerVipBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (BannerViewPager) objArr[3], (ConstraintLayout) objArr[1], (LinearLayout) objArr[2], (TextView) objArr[9], (FrameLayout) objArr[0], (LinearLayout) objArr[4], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
