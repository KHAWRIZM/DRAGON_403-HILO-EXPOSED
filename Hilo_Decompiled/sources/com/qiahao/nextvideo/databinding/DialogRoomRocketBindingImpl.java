package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomRocketBindingImpl extends DialogRoomRocketBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.imageView6, 9);
        sparseIntArray.put(R.id.bg_light, 10);
        sparseIntArray.put(R.id.big_rocket, 11);
        sparseIntArray.put(2131363501, 12);
        sparseIntArray.put(R.id.line2, 13);
        sparseIntArray.put(2131363503, 14);
        sparseIntArray.put(R.id.line4, 15);
        sparseIntArray.put(R.id.progress_content, 16);
        sparseIntArray.put(R.id.progress_bar, 17);
        sparseIntArray.put(2131363479, 18);
        sparseIntArray.put(R.id.big_reward, 19);
        sparseIntArray.put(R.id.small_reward1, 20);
        sparseIntArray.put(R.id.small_reward2, 21);
        sparseIntArray.put(R.id.small_reward3, 22);
        sparseIntArray.put(R.id.small_reward4, 23);
        sparseIntArray.put(R.id.top_contributors_content, 24);
        sparseIntArray.put(R.id.cl_top1, 25);
        sparseIntArray.put(R.id.top1_name, 26);
        sparseIntArray.put(R.id.cl_top2, 27);
        sparseIntArray.put(R.id.top2_name, 28);
        sparseIntArray.put(R.id.cl_top3, 29);
        sparseIntArray.put(R.id.top3_name, 30);
    }

    public DialogRoomRocketBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.smallBlueRocket.setOnClickListener(onClickListener);
            this.smallGreenRocket.setOnClickListener(onClickListener);
            this.smallOrangeRocket.setOnClickListener(onClickListener);
            this.smallPurpleRocket.setOnClickListener(onClickListener);
            this.smallRedRocket.setOnClickListener(onClickListener);
            this.top1Avatar.setOnClickListener(onClickListener);
            this.top2Avatar.setOnClickListener(onClickListener);
            this.top3Avatar.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogRoomRocketBinding
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

    private DialogRoomRocketBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[10], (ImageView) objArr[19], (ImageView) objArr[11], (ConstraintLayout) objArr[25], (ConstraintLayout) objArr[27], (ConstraintLayout) objArr[29], (ImageView) objArr[9], (ImageView) objArr[18], (ImageView) objArr[12], (ImageView) objArr[13], (ImageView) objArr[14], (ImageView) objArr[15], (ProgressBar) objArr[17], (ConstraintLayout) objArr[16], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[5], (ImageView) objArr[4], (ImageView) objArr[3], (ImageView) objArr[20], (ImageView) objArr[21], (ImageView) objArr[22], (ImageView) objArr[23], (QMUIRadiusImageView) objArr[6], (TextView) objArr[26], (QMUIRadiusImageView) objArr[7], (TextView) objArr[28], (QMUIRadiusImageView) objArr[8], (TextView) objArr[30], (ConstraintLayout) objArr[24]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.smallBlueRocket.setTag(null);
        this.smallGreenRocket.setTag(null);
        this.smallOrangeRocket.setTag(null);
        this.smallPurpleRocket.setTag(null);
        this.smallRedRocket.setTag(null);
        this.top1Avatar.setTag(null);
        this.top2Avatar.setTag(null);
        this.top3Avatar.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
