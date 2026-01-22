package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogNumberOfMicBindingImpl extends DialogNumberOfMicBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 6);
        sparseIntArray.put(R.id.radio_group, 7);
        sparseIntArray.put(R.id.ten_mic, 8);
        sparseIntArray.put(R.id.five_mic, 9);
        sparseIntArray.put(R.id.close_mic, 10);
        sparseIntArray.put(R.id.ll_level_edit, 11);
        sparseIntArray.put(R.id.level_edit, 12);
    }

    public DialogNumberOfMicBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.cancelButton.setOnClickListener(onClickListener);
            this.confirmButton.setOnClickListener(onClickListener);
            this.llCloseMic.setOnClickListener(onClickListener);
            this.llFiveMic.setOnClickListener(onClickListener);
            this.llTenMic.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogNumberOfMicBinding
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

    private DialogNumberOfMicBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[0], (TextView) objArr[5], (View) objArr[10], (TextView) objArr[4], (View) objArr[9], (EditText) objArr[12], (LinearLayout) objArr[3], (LinearLayout) objArr[2], (LinearLayout) objArr[11], (LinearLayout) objArr[1], (LinearLayout) objArr[7], (View) objArr[8], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.bgRoot.setTag(null);
        this.cancelButton.setTag(null);
        this.confirmButton.setTag(null);
        this.llCloseMic.setTag(null);
        this.llFiveMic.setTag(null);
        this.llTenMic.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
