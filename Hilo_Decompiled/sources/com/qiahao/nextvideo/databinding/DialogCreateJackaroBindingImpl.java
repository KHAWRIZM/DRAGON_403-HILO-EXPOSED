package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogCreateJackaroBindingImpl extends DialogCreateJackaroBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 10);
        sparseIntArray.put(R.id.moneyLayout, 11);
        sparseIntArray.put(R.id.diamondImg, 12);
        sparseIntArray.put(R.id.diamondText, 13);
        sparseIntArray.put(R.id.bet, 14);
        sparseIntArray.put(2131364958, 15);
    }

    public DialogCreateJackaroBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.add.setOnClickListener(onClickListener);
            this.autoMatch.setOnClickListener(onClickListener);
            this.autoText.setOnClickListener(onClickListener);
            this.baseMode.setOnClickListener(onClickListener);
            this.close.setOnClickListener(onClickListener);
            this.complexMode.setOnClickListener(onClickListener);
            this.createButton.setOnClickListener(onClickListener);
            this.minus.setOnClickListener(onClickListener);
            this.one.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogCreateJackaroBinding
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

    private DialogCreateJackaroBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[5], (ImageView) objArr[1], (AppCompatTextView) objArr[2], (TextView) objArr[6], (TextView) objArr[14], (ImageView) objArr[9], (TextView) objArr[7], (ConstraintLayout) objArr[10], (AppCompatTextView) objArr[3], (ImageView) objArr[12], (TextView) objArr[13], (ImageView) objArr[4], (ConstraintLayout) objArr[11], (TextView) objArr[8], (FrameLayout) objArr[0], (SVGAImageView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.add.setTag(null);
        this.autoMatch.setTag(null);
        this.autoText.setTag(null);
        this.baseMode.setTag(null);
        this.close.setTag(null);
        this.complexMode.setTag(null);
        this.createButton.setTag(null);
        this.minus.setTag(null);
        this.one.setTag(null);
        this.rootLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
