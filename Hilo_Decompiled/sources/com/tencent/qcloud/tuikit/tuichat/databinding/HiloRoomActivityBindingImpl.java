package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloRoomActivityBindingImpl extends HiloRoomActivityBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.image, 1);
        sparseIntArray.put(R.id.stateLayout, 2);
        sparseIntArray.put(R.id.stateImage, 3);
        sparseIntArray.put(R.id.stateContent, 4);
        sparseIntArray.put(R.id.timeImage, 5);
        sparseIntArray.put(R.id.timeContent, 6);
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.interested, 8);
        sparseIntArray.put(R.id.interestedImage, 9);
        sparseIntArray.put(R.id.interestedText, 10);
    }

    public HiloRoomActivityBindingImpl(f fVar, View view) {
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

    private HiloRoomActivityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[8], (ImageView) objArr[9], (TextView) objArr[10], (AppCompatTextView) objArr[4], (ImageView) objArr[3], (LinearLayout) objArr[2], (AppCompatTextView) objArr[6], (ImageView) objArr[5], (AppCompatTextView) objArr[7]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
