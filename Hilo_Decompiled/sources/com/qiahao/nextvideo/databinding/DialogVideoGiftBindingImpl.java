package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupSendGiftLinearLayout;
import com.qiahao.nextvideo.ui.reusable.views.PageIndicator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogVideoGiftBindingImpl extends DialogVideoGiftBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gift_view_all, 1);
        sparseIntArray.put(R.id.statusView, 2);
        sparseIntArray.put(2131364510, 3);
        sparseIntArray.put(R.id.page_indicator, 4);
        sparseIntArray.put(R.id.send_gift_linear_layout, 5);
        sparseIntArray.put(R.id.diamondText, 6);
        sparseIntArray.put(R.id.rechargeText, 7);
        sparseIntArray.put(R.id.rechargeIcon, 8);
    }

    public DialogVideoGiftBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
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

    private DialogVideoGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[6], (LinearLayout) objArr[1], (PageIndicator) objArr[4], (ImageView) objArr[8], (TextView) objArr[7], (RecyclerView) objArr[3], (ConstraintLayout) objArr[0], (GroupSendGiftLinearLayout) objArr[5], (SuperStatusView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.rootBack.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
