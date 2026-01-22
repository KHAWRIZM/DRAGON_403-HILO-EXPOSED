package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemActivityBindingImpl extends ItemActivityBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363201, 1);
        sparseIntArray.put(2131364906, 2);
        sparseIntArray.put(2131364905, 3);
        sparseIntArray.put(2131364904, 4);
        sparseIntArray.put(2131365159, 5);
        sparseIntArray.put(2131365154, 6);
        sparseIntArray.put(R.id.contentImage, 7);
        sparseIntArray.put(2131362440, 8);
        sparseIntArray.put(R.id.countryIcon, 9);
        sparseIntArray.put(2131365189, 10);
    }

    public ItemActivityBindingImpl(f fVar, View view) {
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

    private ItemActivityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatTextView) objArr[8], (ImageView) objArr[7], (QMUIRadiusImageView2) objArr[9], (ImageView) objArr[1], (AppCompatTextView) objArr[4], (ImageView) objArr[3], (LinearLayout) objArr[2], (AppCompatTextView) objArr[6], (ImageView) objArr[5], (AppCompatTextView) objArr[10]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
