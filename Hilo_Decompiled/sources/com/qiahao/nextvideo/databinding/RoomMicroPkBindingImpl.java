package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.PKItemMicroView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RoomMicroPkBindingImpl extends RoomMicroPkBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.microView1, 1);
        sparseIntArray.put(R.id.microView2, 2);
        sparseIntArray.put(R.id.microView3, 3);
        sparseIntArray.put(R.id.microView4, 4);
        sparseIntArray.put(R.id.microView5, 5);
        sparseIntArray.put(R.id.microView6, 6);
        sparseIntArray.put(R.id.microView7, 7);
        sparseIntArray.put(R.id.microView8, 8);
        sparseIntArray.put(R.id.microView9, 9);
        sparseIntArray.put(R.id.microView10, 10);
    }

    public RoomMicroPkBindingImpl(f fVar, View view) {
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

    private RoomMicroPkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (PKItemMicroView) objArr[1], (PKItemMicroView) objArr[10], (PKItemMicroView) objArr[2], (PKItemMicroView) objArr[3], (PKItemMicroView) objArr[4], (PKItemMicroView) objArr[5], (PKItemMicroView) objArr[6], (PKItemMicroView) objArr[7], (PKItemMicroView) objArr[8], (PKItemMicroView) objArr[9]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
