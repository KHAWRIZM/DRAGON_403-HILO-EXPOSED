package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HomeMatchRecycleView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeMatchingBindingImpl extends FragmentHomeMatchingBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.matchingPendingViewWrapperContainer, 1);
        sparseIntArray.put(R.id.topLinearLayout, 2);
        sparseIntArray.put(R.id.diamondTextView, 3);
        sparseIntArray.put(R.id.gemTextView, 4);
        sparseIntArray.put(R.id.statusView, 5);
        sparseIntArray.put(R.id.refreshLayout, 6);
        sparseIntArray.put(2131364510, 7);
        sparseIntArray.put(R.id.foundGuysSvgaContainer, 8);
        sparseIntArray.put(R.id.foundGuysSvgaImageView, 9);
        sparseIntArray.put(R.id.textShowMating, 10);
        sparseIntArray.put(R.id.endTextView, 11);
        sparseIntArray.put(R.id.chest, 12);
        sparseIntArray.put(R.id.matchGroup, 13);
    }

    public FragmentHomeMatchingBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private FragmentHomeMatchingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[12], (TextView) objArr[3], (AppCompatTextView) objArr[11], (ConstraintLayout) objArr[8], (SVGAImageView) objArr[9], (TextView) objArr[4], (Group) objArr[13], (FrameLayout) objArr[1], (HomeMatchRecycleView) objArr[7], (SmartRefreshLayout) objArr[6], (ConstraintLayout) objArr[0], (SuperStatusView) objArr[5], (AppCompatTextView) objArr[10], (LinearLayout) objArr[2]);
        this.mDirtyFlags = -1L;
        this.rootContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
