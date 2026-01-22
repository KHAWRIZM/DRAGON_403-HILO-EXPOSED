package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogFirstChargeBindingImpl extends DialogFirstChargeBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131362100, 2);
        sparseIntArray.put(R.id.tabLayout, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(R.id.viewPage, 5);
        sparseIntArray.put(R.id.button, 6);
    }

    public DialogFirstChargeBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
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

    private DialogFirstChargeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[2], (TextView) objArr[6], (ConstraintLayout) objArr[1], (FrameLayout) objArr[0], (ViewPage2TabLayout) objArr[3], (ImageView) objArr[4], (ViewPager2) objArr[5]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
