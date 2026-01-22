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
public class DialogJoinedLevelBindingImpl extends DialogJoinedLevelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.radio_group, 6);
        sparseIntArray.put(R.id.ll_level_edit, 7);
        sparseIntArray.put(R.id.level_edit, 8);
    }

    public DialogJoinedLevelBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
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
            this.joinPublic.setOnClickListener(onClickListener);
            this.joinedLevel.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogJoinedLevelBinding
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

    private DialogJoinedLevelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[3], (View) objArr[1], (View) objArr[2], (EditText) objArr[8], (LinearLayout) objArr[7], (LinearLayout) objArr[6], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.bgRoot.setTag(null);
        this.cancelButton.setTag(null);
        this.confirmButton.setTag(null);
        this.joinPublic.setTag(null);
        this.joinedLevel.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
