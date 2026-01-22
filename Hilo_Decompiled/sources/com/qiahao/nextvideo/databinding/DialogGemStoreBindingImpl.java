package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogGemStoreBindingImpl extends DialogGemStoreBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(2131365189, 2);
        sparseIntArray.put(R.id.close, 3);
        sparseIntArray.put(R.id.contactUs, 4);
        sparseIntArray.put(R.id.gemLayout, 5);
        sparseIntArray.put(R.id.gemIcon, 6);
        sparseIntArray.put(R.id.gemNumber, 7);
        sparseIntArray.put(R.id.toRecharge, 8);
        sparseIntArray.put(R.id.exchange, 9);
        sparseIntArray.put(2131364510, 10);
    }

    public DialogGemStoreBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 11, sIncludes, sViewsWithIds));
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

    private DialogGemStoreBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[3], (ImageView) objArr[4], (TextView) objArr[9], (FrameLayout) objArr[0], (ImageView) objArr[6], (LinearLayout) objArr[5], (AppCompatTextView) objArr[7], (RecyclerView) objArr[10], (AppCompatTextView) objArr[2], (ImageView) objArr[8], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
