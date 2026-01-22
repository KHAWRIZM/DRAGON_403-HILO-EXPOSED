package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemGlobalBroadcastHistoryBindingImpl extends ItemGlobalBroadcastHistoryBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365536, 1);
        sparseIntArray.put(R.id.icon_vip_1, 2);
        sparseIntArray.put(2131363173, 3);
        sparseIntArray.put(R.id.broad_cast_text, 4);
        sparseIntArray.put(R.id.buttonLayout, 5);
        sparseIntArray.put(2131365220, 6);
        sparseIntArray.put(R.id.countryImage, 7);
        sparseIntArray.put(R.id.sex, 8);
        sparseIntArray.put(2131365557, 9);
        sparseIntArray.put(R.id.create_time, 10);
    }

    public ItemGlobalBroadcastHistoryBindingImpl(f fVar, View view) {
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

    private ItemGlobalBroadcastHistoryBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (TextView) objArr[4], (LinearLayoutCompat) objArr[5], (ImageView) objArr[7], (TextView) objArr[10], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[8], (ImageView) objArr[6], (CircleImageView) objArr[1], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.bgContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
