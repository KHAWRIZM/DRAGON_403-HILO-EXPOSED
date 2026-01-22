package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomPowerJoinBindingImpl extends DialogRoomPowerJoinBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 1);
        sparseIntArray.put(R.id.close, 2);
        sparseIntArray.put(R.id.micImage, 3);
        sparseIntArray.put(R.id.mixText, 4);
        sparseIntArray.put(R.id.messageImage, 5);
        sparseIntArray.put(R.id.messageText, 6);
        sparseIntArray.put(R.id.pictureImage, 7);
        sparseIntArray.put(R.id.pictureText, 8);
        sparseIntArray.put(2131363387, 9);
        sparseIntArray.put(R.id.freeJoin, 10);
    }

    public DialogRoomPowerJoinBindingImpl(f fVar, View view) {
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

    private DialogRoomPowerJoinBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[2], (AppCompatTextView) objArr[10], (AppCompatTextView) objArr[9], (AppCompatImageView) objArr[5], (AppCompatTextView) objArr[6], (AppCompatImageView) objArr[3], (AppCompatTextView) objArr[4], (AppCompatImageView) objArr[7], (AppCompatTextView) objArr[8], (AppCompatTextView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
