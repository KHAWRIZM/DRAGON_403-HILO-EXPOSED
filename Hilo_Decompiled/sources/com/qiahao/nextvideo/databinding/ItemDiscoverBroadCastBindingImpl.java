package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemDiscoverBroadCastBindingImpl extends ItemDiscoverBroadCastBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131361956, 1);
        sparseIntArray.put(2131362013, 2);
        sparseIntArray.put(2131365220, 3);
        sparseIntArray.put(2131362440, 4);
    }

    public ItemDiscoverBroadCastBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 5, sIncludes, sViewsWithIds));
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

    private ItemDiscoverBroadCastBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[1], (QMUIRadiusImageView) objArr[2], (LinearLayout) objArr[0], (TextView) objArr[4], (ImageView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.backContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
