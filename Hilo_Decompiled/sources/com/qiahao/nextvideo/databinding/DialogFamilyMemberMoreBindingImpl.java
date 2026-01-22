package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogFamilyMemberMoreBindingImpl extends DialogFamilyMemberMoreBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362040, 1);
        sparseIntArray.put(2131364339, 2);
        sparseIntArray.put(2131364342, 3);
        sparseIntArray.put(R.id.quick, 4);
        sparseIntArray.put(R.id.quick_line, 5);
        sparseIntArray.put(R.id.setAdmin, 6);
        sparseIntArray.put(R.id.setAdminLine, 7);
        sparseIntArray.put(R.id.notAdmin, 8);
        sparseIntArray.put(R.id.notAdminLine, 9);
        sparseIntArray.put(2131362802, 10);
        sparseIntArray.put(2131362224, 11);
    }

    public DialogFamilyMemberMoreBindingImpl(f fVar, View view) {
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

    private DialogFamilyMemberMoreBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[1], (AppCompatButton) objArr[11], (AppCompatButton) objArr[10], (AppCompatButton) objArr[8], (View) objArr[9], (AppCompatButton) objArr[2], (View) objArr[3], (AppCompatButton) objArr[4], (View) objArr[5], (AppCompatButton) objArr[6], (View) objArr[7]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
