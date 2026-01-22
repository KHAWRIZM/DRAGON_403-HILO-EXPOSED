package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class PowerDetailViewControllerBindingImpl extends PowerDetailViewControllerBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 7);
        sparseIntArray.put(R.id.app_bar, 8);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 9);
        sparseIntArray.put(2131362433, 10);
        sparseIntArray.put(R.id.power_avatar_bg, 11);
        sparseIntArray.put(R.id.power_avatar, 12);
        sparseIntArray.put(R.id.power_name, 13);
        sparseIntArray.put(R.id.ll_number, 14);
        sparseIntArray.put(R.id.power_number, 15);
        sparseIntArray.put(2131365217, 16);
        sparseIntArray.put(R.id.title_text_view, 17);
        sparseIntArray.put(R.id.child_all_content, 18);
        sparseIntArray.put(R.id.recycler_room, 19);
    }

    public PowerDetailViewControllerBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.allPowerAvatar.setOnClickListener(onClickListener);
            this.backImageView.setOnClickListener(onClickListener);
            this.join.setOnClickListener(onClickListener);
            this.linearLayout2.setOnClickListener(onClickListener);
            this.managerList.setOnClickListener(onClickListener);
            this.moreBtn.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.PowerDetailViewControllerBinding
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

    private PowerDetailViewControllerBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[1], (AppBarLayout) objArr[8], (AppCompatImageView) objArr[5], (LinearLayout) objArr[18], (CollapsingToolbarLayout) objArr[9], (ConstraintLayout) objArr[10], (TextView) objArr[4], (LinearLayout) objArr[2], (LinearLayout) objArr[14], (RecyclerView) objArr[3], (ImageView) objArr[6], (PorterShapeImageView) objArr[12], (ImageView) objArr[11], (TextView) objArr[13], (TextView) objArr[15], (RecyclerView) objArr[19], (SmartRefreshLayout) objArr[7], (AppCompatTextView) objArr[17], (Toolbar) objArr[16]);
        this.mDirtyFlags = -1L;
        this.allPowerAvatar.setTag(null);
        this.backImageView.setTag(null);
        this.join.setTag(null);
        this.linearLayout2.setTag(null);
        this.managerList.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.moreBtn.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
