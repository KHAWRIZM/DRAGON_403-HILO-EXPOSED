package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.TurntableText;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogLuckyWheelBindingImpl extends DialogLuckyWheelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_lucky_wheel, 4);
        sparseIntArray.put(R.id.turnText, 5);
        sparseIntArray.put(R.id.bg_content_a, 6);
        sparseIntArray.put(R.id.bg_content_b, 7);
        sparseIntArray.put(R.id.ll_join, 8);
        sparseIntArray.put(R.id.join_diamond, 9);
        sparseIntArray.put(R.id.start_click, 10);
        sparseIntArray.put(R.id.out_bg, 11);
        sparseIntArray.put(R.id.out_avatar, 12);
        sparseIntArray.put(2131362818, 13);
        sparseIntArray.put(R.id.diamond, 14);
        sparseIntArray.put(R.id.person_number, 15);
        sparseIntArray.put(R.id.cl_win_layout, 16);
        sparseIntArray.put(R.id.svga_image_view, 17);
        sparseIntArray.put(R.id.winner_name, 18);
        sparseIntArray.put(R.id.winner_diamond, 19);
    }

    public DialogLuckyWheelBindingImpl(f fVar, View view) {
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
            this.centerPoint.setOnClickListener(onClickListener);
            this.closeLuckyWheel.setOnClickListener(onClickListener);
            this.smallLuckyWheel.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogLuckyWheelBinding
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

    private DialogLuckyWheelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[6], (ImageView) objArr[7], (ImageView) objArr[1], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[16], (ImageView) objArr[3], (AppCompatTextView) objArr[14], (ImageView) objArr[13], (AppCompatTextView) objArr[9], (LinearLayout) objArr[8], (CircleImageView) objArr[12], (ImageView) objArr[11], (AppCompatTextView) objArr[15], (ImageView) objArr[2], (TextView) objArr[10], (SVGAImageView) objArr[17], (TurntableText) objArr[5], (AppCompatTextView) objArr[19], (TextView) objArr[18]);
        this.mDirtyFlags = -1L;
        this.centerPoint.setTag(null);
        this.closeLuckyWheel.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.smallLuckyWheel.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
