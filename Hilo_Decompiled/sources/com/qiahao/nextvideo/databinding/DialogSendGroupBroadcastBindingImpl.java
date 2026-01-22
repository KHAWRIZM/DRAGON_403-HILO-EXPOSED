package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import t2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogSendGroupBroadcastBindingImpl extends DialogSendGroupBroadcastBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.text_number, 4);
    }

    public DialogSendGroupBroadcastBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 5, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Integer num = this.mNumber;
        View.OnClickListener onClickListener = this.mClick;
        long j2 = 5 & j;
        if (j2 != 0) {
            i = ViewDataBinding.safeUnbox(num);
        } else {
            i = 0;
        }
        if ((j & 6) != 0) {
            this.cancelButton.setOnClickListener(onClickListener);
            this.confirmButton.setOnClickListener(onClickListener);
        }
        if (j2 != 0) {
            b.b(this.etContent, i);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.DialogSendGroupBroadcastBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.DialogSendGroupBroadcastBinding
    public void setNumber(Integer num) {
        this.mNumber = num;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (5 == i) {
            setNumber((Integer) obj);
        } else if (2 == i) {
            setClick((View.OnClickListener) obj);
        } else {
            return false;
        }
        return true;
    }

    private DialogSendGroupBroadcastBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2], (EditText) objArr[1], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.bgRoot.setTag(null);
        this.cancelButton.setTag(null);
        this.confirmButton.setTag(null);
        this.etContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
