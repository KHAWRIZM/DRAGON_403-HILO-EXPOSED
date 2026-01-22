package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class LayoutRoomOnlineMemberBindingImpl extends LayoutRoomOnlineMemberBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.trophy, 3);
        sparseIntArray.put(R.id.trophySVGA, 4);
        sparseIntArray.put(R.id.trophy_room_rank_sum, 5);
        sparseIntArray.put(R.id.number_online_recycler, 6);
        sparseIntArray.put(R.id.numberImage, 7);
        sparseIntArray.put(R.id.lottieView, 8);
        sparseIntArray.put(R.id.number_sum, 9);
    }

    public LayoutRoomOnlineMemberBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.llOnlineSum.setOnClickListener(onClickListener);
            this.llRoomRank.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.LayoutRoomOnlineMemberBinding
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

    private LayoutRoomOnlineMemberBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[2], (LinearLayout) objArr[1], (LottieAnimationView) objArr[8], (ImageView) objArr[7], (RecyclerView) objArr[6], (TextView) objArr[9], (ImageView) objArr[3], (TextView) objArr[5], (SVGAImageView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.llOnlineSum.setTag(null);
        this.llRoomRank.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
