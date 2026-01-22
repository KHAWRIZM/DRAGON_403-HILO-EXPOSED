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
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemChatRoomLuckyFruitRecordBindingImpl extends ItemChatRoomLuckyFruitRecordBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.record_round, 1);
        sparseIntArray.put(R.id.record_date, 2);
        sparseIntArray.put(2131363500, 3);
        sparseIntArray.put(R.id.winning_tip, 4);
        sparseIntArray.put(R.id.win_image, 5);
        sparseIntArray.put(R.id.ll_win, 6);
        sparseIntArray.put(R.id.won_diamond, 7);
        sparseIntArray.put(R.id.lost_view, 8);
        sparseIntArray.put(R.id.mine, 9);
        sparseIntArray.put(R.id.fruit_result_recyclerView, 10);
    }

    public ItemChatRoomLuckyFruitRecordBindingImpl(f fVar, View view) {
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

    private ItemChatRoomLuckyFruitRecordBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (RecyclerView) objArr[10], (View) objArr[3], (LinearLayout) objArr[6], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[2], (TextView) objArr[1], (ImageView) objArr[5], (TextView) objArr[4], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
