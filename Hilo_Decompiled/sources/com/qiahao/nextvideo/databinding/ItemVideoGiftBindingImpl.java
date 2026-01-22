package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemVideoGiftBindingImpl extends ItemVideoGiftBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363201, 1);
        sparseIntArray.put(R.id.giftName, 2);
        sparseIntArray.put(R.id.diamondImage, 3);
        sparseIntArray.put(R.id.diamond, 4);
        sparseIntArray.put(R.id.time_container, 5);
        sparseIntArray.put(R.id.timeText, 6);
        sparseIntArray.put(R.id.iconCp, 7);
        sparseIntArray.put(R.id.iconWeek, 8);
        sparseIntArray.put(R.id.iconMedal, 9);
        sparseIntArray.put(R.id.background, 10);
    }

    public ItemVideoGiftBindingImpl(f fVar, View view) {
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

    private ItemVideoGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[10], (ConstraintLayout) objArr[0], (AppCompatTextView) objArr[4], (ImageView) objArr[3], (TextView) objArr[2], (ImageView) objArr[7], (ImageView) objArr[9], (ImageView) objArr[8], (AppCompatImageView) objArr[1], (StackLayout) objArr[5], (AppCompatTextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.content.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
