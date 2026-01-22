package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerBuyAristocracyIdentityBindingImpl extends ViewControllerBuyAristocracyIdentityBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topSvga, 7);
        sparseIntArray.put(R.id.buttonSvga, 8);
        sparseIntArray.put(2131365217, 9);
        sparseIntArray.put(R.id.common_tab_layout, 10);
        sparseIntArray.put(R.id.tip_icon, 11);
        sparseIntArray.put(R.id.noble_level, 12);
        sparseIntArray.put(R.id.remain_time, 13);
        sparseIntArray.put(R.id.exclusive_privileges, 14);
        sparseIntArray.put(2131365640, 15);
        sparseIntArray.put(R.id.cl_buy, 16);
        sparseIntArray.put(R.id.diamond_text, 17);
        sparseIntArray.put(R.id.days, 18);
        sparseIntArray.put(R.id.tip, 19);
        sparseIntArray.put(R.id.tip1, 20);
    }

    public ViewControllerBuyAristocracyIdentityBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 21, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.backImageView.setOnClickListener(onClickListener);
            this.bag.setOnClickListener(onClickListener);
            this.card.setOnClickListener(onClickListener);
            this.delete.setOnClickListener(onClickListener);
            this.textBay.setOnClickListener(onClickListener);
            this.textSend.setOnClickListener(onClickListener);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.ViewControllerBuyAristocracyIdentityBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private ViewControllerBuyAristocracyIdentityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[1], (ImageView) objArr[4], (SVGAImageView) objArr[8], (ImageView) objArr[3], (ConstraintLayout) objArr[16], (SlidingTabLayout) objArr[10], (TextView) objArr[18], (ImageView) objArr[2], (TextView) objArr[17], (TextView) objArr[14], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[19], (TextView) objArr[20], (ImageView) objArr[11], (Toolbar) objArr[9], (SVGAImageView) objArr[7], (ViewPager) objArr[15]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.bag.setTag(null);
        this.card.setTag(null);
        this.delete.setTag(null);
        this.textBay.setTag(null);
        this.textSend.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
