package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemRoomGiftBindingImpl extends ItemRoomGiftBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363201, 1);
        sparseIntArray.put(R.id.giftName, 2);
        sparseIntArray.put(R.id.buttonLayout, 3);
        sparseIntArray.put(R.id.diamondImage, 4);
        sparseIntArray.put(R.id.diamond, 5);
        sparseIntArray.put(R.id.time_container, 6);
        sparseIntArray.put(R.id.timeText, 7);
        sparseIntArray.put(R.id.iconCp, 8);
        sparseIntArray.put(R.id.iconWeek, 9);
        sparseIntArray.put(R.id.iconMedal, 10);
        sparseIntArray.put(R.id.icon3D, 11);
        sparseIntArray.put(R.id.iconActivity, 12);
        sparseIntArray.put(R.id.background, 13);
    }

    public ItemRoomGiftBindingImpl(f fVar, View view) {
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

    private ItemRoomGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[13], (LinearLayout) objArr[3], (ConstraintLayout) objArr[0], (AppCompatTextView) objArr[5], (ImageView) objArr[4], (TextView) objArr[2], (ImageView) objArr[11], (ImageView) objArr[12], (ImageView) objArr[8], (ImageView) objArr[10], (ImageView) objArr[9], (AppCompatImageView) objArr[1], (StackLayout) objArr[6], (AppCompatTextView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.content.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
