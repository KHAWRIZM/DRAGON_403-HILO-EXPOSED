package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemCurrentlyPkBindingImpl extends ItemCurrentlyPkBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.centerBg, 1);
        sparseIntArray.put(R.id.leftAvatarBg, 2);
        sparseIntArray.put(R.id.leftAvatar, 3);
        sparseIntArray.put(R.id.rightAvatarBg, 4);
        sparseIntArray.put(R.id.rightAvatar, 5);
        sparseIntArray.put(R.id.leftId, 6);
        sparseIntArray.put(R.id.leftName, 7);
        sparseIntArray.put(R.id.rightId, 8);
        sparseIntArray.put(R.id.rightName, 9);
        sparseIntArray.put(R.id.topLinearLayout, 10);
        sparseIntArray.put(R.id.diamond, 11);
        sparseIntArray.put(R.id.redClick, 12);
        sparseIntArray.put(R.id.blueClick, 13);
    }

    public ItemCurrentlyPkBindingImpl(f fVar, View view) {
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

    private ItemCurrentlyPkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[13], (ImageView) objArr[1], (TextView) objArr[11], (QMUIRadiusImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[6], (TextView) objArr[7], (View) objArr[12], (QMUIRadiusImageView) objArr[5], (ImageView) objArr[4], (TextView) objArr[8], (TextView) objArr[9], (LinearLayout) objArr[10]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
