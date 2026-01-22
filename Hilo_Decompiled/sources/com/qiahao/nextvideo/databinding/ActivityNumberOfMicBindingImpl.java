package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityNumberOfMicBindingImpl extends ActivityNumberOfMicBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 21);
        sparseIntArray.put(2131365189, 22);
        sparseIntArray.put(R.id.mic_type_image, 23);
    }

    public ActivityNumberOfMicBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 24, sIncludes, sViewsWithIds));
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
            this.confirm.setOnClickListener(onClickListener);
            this.text1.setOnClickListener(onClickListener);
            this.text10.setOnClickListener(onClickListener);
            this.text11.setOnClickListener(onClickListener);
            this.text12.setOnClickListener(onClickListener);
            this.text13.setOnClickListener(onClickListener);
            this.text15.setOnClickListener(onClickListener);
            this.text16.setOnClickListener(onClickListener);
            this.text17.setOnClickListener(onClickListener);
            this.text18.setOnClickListener(onClickListener);
            this.text2.setOnClickListener(onClickListener);
            this.text20.setOnClickListener(onClickListener);
            this.text3.setOnClickListener(onClickListener);
            this.text4.setOnClickListener(onClickListener);
            this.text5.setOnClickListener(onClickListener);
            this.text6.setOnClickListener(onClickListener);
            this.text7.setOnClickListener(onClickListener);
            this.text8.setOnClickListener(onClickListener);
            this.text9.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.ActivityNumberOfMicBinding
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

    private ActivityNumberOfMicBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[1], (TextView) objArr[20], (RoundedImageView) objArr[23], (TextView) objArr[2], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[3], (TextView) objArr[19], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[10], (AppCompatTextView) objArr[22], (Toolbar) objArr[21]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.confirm.setTag(null);
        this.text1.setTag(null);
        this.text10.setTag(null);
        this.text11.setTag(null);
        this.text12.setTag(null);
        this.text13.setTag(null);
        this.text15.setTag(null);
        this.text16.setTag(null);
        this.text17.setTag(null);
        this.text18.setTag(null);
        this.text2.setTag(null);
        this.text20.setTag(null);
        this.text3.setTag(null);
        this.text4.setTag(null);
        this.text5.setTag(null);
        this.text6.setTag(null);
        this.text7.setTag(null);
        this.text8.setTag(null);
        this.text9.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
