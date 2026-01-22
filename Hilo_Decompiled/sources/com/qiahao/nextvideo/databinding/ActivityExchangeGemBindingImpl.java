package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityExchangeGemBindingImpl extends ActivityExchangeGemBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bar, 1);
        sparseIntArray.put(2131365217, 2);
        sparseIntArray.put(R.id.back_image_view, 3);
        sparseIntArray.put(R.id.exchangeTitle, 4);
        sparseIntArray.put(R.id.exchangeRecyclerView, 5);
        sparseIntArray.put(2131363500, 6);
        sparseIntArray.put(R.id.gemTitle, 7);
        sparseIntArray.put(R.id.beans_edit, 8);
        sparseIntArray.put(R.id.beans_balance, 9);
        sparseIntArray.put(R.id.diamond_edit, 10);
        sparseIntArray.put(R.id.diamond_balance, 11);
        sparseIntArray.put(R.id.exchange_diamonds, 12);
    }

    public ActivityExchangeGemBindingImpl(f fVar, View view) {
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

    private ActivityExchangeGemBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[3], (View) objArr[1], (TextView) objArr[9], (EditText) objArr[8], (TextView) objArr[11], (TextView) objArr[10], (TextView) objArr[12], (RecyclerView) objArr[5], (TextView) objArr[4], (TextView) objArr[7], (View) objArr[6], (Toolbar) objArr[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
