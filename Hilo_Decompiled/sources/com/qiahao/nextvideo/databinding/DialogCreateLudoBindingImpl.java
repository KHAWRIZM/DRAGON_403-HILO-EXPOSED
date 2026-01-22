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
public class DialogCreateLudoBindingImpl extends DialogCreateLudoBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 14);
        sparseIntArray.put(R.id.moneyLayout, 15);
        sparseIntArray.put(R.id.diamondImg, 16);
        sparseIntArray.put(R.id.diamondText, 17);
        sparseIntArray.put(R.id.bet, 18);
        sparseIntArray.put(2131364958, 19);
    }

    public DialogCreateLudoBindingImpl(f fVar, View view) {
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
            this.add.setOnClickListener(onClickListener);
            this.autoMatch.setOnClickListener(onClickListener);
            this.autoText.setOnClickListener(onClickListener);
            this.classic.setOnClickListener(onClickListener);
            this.close.setOnClickListener(onClickListener);
            this.createButton.setOnClickListener(onClickListener);
            this.fourSelect.setOnClickListener(onClickListener);
            this.magic.setOnClickListener(onClickListener);
            this.magicIcon.setOnClickListener(onClickListener);
            this.magicSelect.setOnClickListener(onClickListener);
            this.minus.setOnClickListener(onClickListener);
            this.quick.setOnClickListener(onClickListener);
            this.twoSelect.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogCreateLudoBinding
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

    private DialogCreateLudoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[5], (ImageView) objArr[1], (AppCompatTextView) objArr[2], (TextView) objArr[18], (TextView) objArr[11], (ImageView) objArr[13], (ConstraintLayout) objArr[14], (AppCompatTextView) objArr[3], (ImageView) objArr[16], (TextView) objArr[17], (TextView) objArr[9], (TextView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[8], (ImageView) objArr[4], (ConstraintLayout) objArr[15], (TextView) objArr[12], (FrameLayout) objArr[0], (SVGAImageView) objArr[19], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.add.setTag(null);
        this.autoMatch.setTag(null);
        this.autoText.setTag(null);
        this.classic.setTag(null);
        this.close.setTag(null);
        this.createButton.setTag(null);
        this.fourSelect.setTag(null);
        this.magic.setTag(null);
        this.magicIcon.setTag(null);
        this.magicSelect.setTag(null);
        this.minus.setTag(null);
        this.quick.setTag(null);
        this.rootLayout.setTag(null);
        this.twoSelect.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
