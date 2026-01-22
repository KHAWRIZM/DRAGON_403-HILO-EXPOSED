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
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogVerificationBindingImpl extends DialogVerificationBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 1);
        sparseIntArray.put(2131362440, 2);
        sparseIntArray.put(R.id.whatsLayout, 3);
        sparseIntArray.put(2131363202, 4);
        sparseIntArray.put(2131365027, 5);
        sparseIntArray.put(R.id.recommend, 6);
        sparseIntArray.put(R.id.select1, 7);
        sparseIntArray.put(R.id.smsLayout, 8);
        sparseIntArray.put(2131363203, 9);
        sparseIntArray.put(2131365036, 10);
        sparseIntArray.put(R.id.select2, 11);
        sparseIntArray.put(2131362419, 12);
        sparseIntArray.put(2131362220, 13);
    }

    public DialogVerificationBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private DialogVerificationBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[13], (TextView) objArr[12], (AppCompatTextView) objArr[2], (ImageView) objArr[4], (ImageView) objArr[9], (TextView) objArr[6], (View) objArr[7], (View) objArr[11], (ConstraintLayout) objArr[8], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[1], (ConstraintLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
