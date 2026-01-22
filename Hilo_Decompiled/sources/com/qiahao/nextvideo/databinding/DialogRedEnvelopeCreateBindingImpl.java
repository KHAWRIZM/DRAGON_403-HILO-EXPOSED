package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRedEnvelopeCreateBindingImpl extends DialogRedEnvelopeCreateBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.buttonBg, 1);
        sparseIntArray.put(R.id.topBg, 2);
        sparseIntArray.put(R.id.buttonedRedBg, 3);
        sparseIntArray.put(R.id.room, 4);
        sparseIntArray.put(R.id.world, 5);
        sparseIntArray.put(R.id.coins, 6);
        sparseIntArray.put(R.id.coinsNumber, 7);
        sparseIntArray.put(R.id.quantity, 8);
        sparseIntArray.put(R.id.quantityNumber, 9);
        sparseIntArray.put(2131364778, 10);
        sparseIntArray.put(R.id.bottomBg, 11);
        sparseIntArray.put(R.id.diamond, 12);
        sparseIntArray.put(R.id.recharge, 13);
        sparseIntArray.put(R.id.arrow, 14);
        sparseIntArray.put(R.id.list, 15);
        sparseIntArray.put(R.id.helper, 16);
    }

    public DialogRedEnvelopeCreateBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
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

    private DialogRedEnvelopeCreateBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[14], (ImageView) objArr[11], (ImageView) objArr[1], (ImageView) objArr[3], (TextView) objArr[6], (EnvelopeNumberView) objArr[7], (TextView) objArr[12], (FrameLayout) objArr[0], (ImageView) objArr[16], (ImageView) objArr[15], (TextView) objArr[8], (EnvelopeNumberView) objArr[9], (TextView) objArr[13], (TextView) objArr[4], (TextView) objArr[10], (ImageView) objArr[2], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
