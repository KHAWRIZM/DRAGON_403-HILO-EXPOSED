package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogUserMenuBindingImpl extends DialogUserMenuBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362040, 1);
        sparseIntArray.put(R.id.pinned_button, 2);
        sparseIntArray.put(R.id.pinned_line, 3);
        sparseIntArray.put(2131364339, 4);
        sparseIntArray.put(2131364342, 5);
        sparseIntArray.put(2131362629, 6);
        sparseIntArray.put(2131362632, 7);
        sparseIntArray.put(R.id.svipLayout, 8);
        sparseIntArray.put(R.id.svip_button, 9);
        sparseIntArray.put(2131364585, 10);
        sparseIntArray.put(2131362128, 11);
        sparseIntArray.put(2131362224, 12);
    }

    public DialogUserMenuBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private DialogUserMenuBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[1], (TextView) objArr[11], (AppCompatButton) objArr[12], (TextView) objArr[6], (View) objArr[7], (TextView) objArr[2], (View) objArr[3], (TextView) objArr[4], (View) objArr[5], (TextView) objArr[10], (TextView) objArr[9], (ConstraintLayout) objArr[8]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
