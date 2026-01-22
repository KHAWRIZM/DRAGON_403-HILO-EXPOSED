package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivitySecondTransferBindingImpl extends ActivitySecondTransferBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 1);
        sparseIntArray.put(R.id.bar, 2);
        sparseIntArray.put(R.id.backImageView, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(2131365027, 5);
        sparseIntArray.put(2131365036, 6);
        sparseIntArray.put(R.id.userBg, 7);
        sparseIntArray.put(2131362013, 8);
        sparseIntArray.put(R.id.nickName, 9);
        sparseIntArray.put(2131365528, 10);
        sparseIntArray.put(2131364510, 11);
        sparseIntArray.put(R.id.transferSendButton, 12);
    }

    public ActivitySecondTransferBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private ActivitySecondTransferBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (QMUIRadiusImageView) objArr[8], (AppCompatImageView) objArr[3], (View) objArr[2], (NickTextView) objArr[9], (RecyclerView) objArr[11], (TextView) objArr[5], (TextView) objArr[6], (AppCompatTextView) objArr[4], (LinearLayoutCompat) objArr[1], (TextView) objArr[12], (View) objArr[7], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
