package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.HomeRoomBannerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeRoomBindingImpl extends FragmentHomeRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(2131365189, 2);
        sparseIntArray.put(R.id.tab_layout, 3);
        sparseIntArray.put(R.id.search, 4);
        sparseIntArray.put(2131365640, 5);
        sparseIntArray.put(R.id.bottom_view, 6);
        sparseIntArray.put(R.id.banner, 7);
    }

    public FragmentHomeRoomBindingImpl(f fVar, View view) {
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

    private FragmentHomeRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HomeRoomBannerView) objArr[7], (View) objArr[6], (ConstraintLayout) objArr[0], (ImageView) objArr[4], (SlidingTabLayout) objArr[3], (ConstraintLayout) objArr[2], (ImageView) objArr[1], (ViewPager) objArr[5]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
