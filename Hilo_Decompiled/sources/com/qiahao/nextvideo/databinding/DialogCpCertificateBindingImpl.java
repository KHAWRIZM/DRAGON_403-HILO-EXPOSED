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
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogCpCertificateBindingImpl extends DialogCpCertificateBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_rank, 1);
        sparseIntArray.put(R.id.cp_rank_index, 2);
        sparseIntArray.put(R.id.cp_avatar1, 3);
        sparseIntArray.put(R.id.cp_nicke_1, 4);
        sparseIntArray.put(R.id.cp_avatar2, 5);
        sparseIntArray.put(R.id.model, 6);
        sparseIntArray.put(R.id.cp_nicke_2, 7);
        sparseIntArray.put(R.id.cp_value, 8);
        sparseIntArray.put(R.id.certification_time, 9);
        sparseIntArray.put(R.id.create_time, 10);
        sparseIntArray.put(R.id.long_time, 11);
    }

    public DialogCpCertificateBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private DialogCpCertificateBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (TextView) objArr[9], (CircleImageView) objArr[3], (CircleImageView) objArr[5], (TextView) objArr[4], (TextView) objArr[7], (AppCompatTextView) objArr[2], (TextView) objArr[8], (TextView) objArr[10], (LinearLayout) objArr[1], (TextView) objArr[11], (ImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.backContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
