package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemRoomPersonalTaskListAdapterBindingImpl extends ItemRoomPersonalTaskListAdapterBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_task_icon, 1);
        sparseIntArray.put(R.id.tv_task_name, 2);
        sparseIntArray.put(R.id.task_progress, 3);
        sparseIntArray.put(R.id.start_dot_view, 4);
        sparseIntArray.put(R.id.center_dot_view, 5);
        sparseIntArray.put(R.id.end_dot_view, 6);
        sparseIntArray.put(R.id.tv_start_time_text, 7);
        sparseIntArray.put(R.id.tv_center_time_text, 8);
        sparseIntArray.put(R.id.tv_end_time_text, 9);
        sparseIntArray.put(R.id.start_diamond_container, 10);
        sparseIntArray.put(R.id.tv_start_diamond, 11);
        sparseIntArray.put(R.id.center_diamond_container, 12);
        sparseIntArray.put(R.id.tv_center_diamond, 13);
        sparseIntArray.put(R.id.end_diamond_container, 14);
        sparseIntArray.put(R.id.tv_end_diamond, 15);
        sparseIntArray.put(R.id.go_btn, 16);
        sparseIntArray.put(R.id.anim_diamond, 17);
        sparseIntArray.put(R.id.tv_score, 18);
    }

    public ItemRoomPersonalTaskListAdapterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 19, sIncludes, sViewsWithIds));
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

    private ItemRoomPersonalTaskListAdapterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[17], (LinearLayout) objArr[12], (View) objArr[5], (LinearLayout) objArr[14], (View) objArr[6], (TextView) objArr[16], (ConstraintLayout) objArr[0], (ImageView) objArr[1], (LinearLayout) objArr[10], (View) objArr[4], (ProgressBar) objArr[3], (TextView) objArr[13], (TextView) objArr[8], (TextView) objArr[15], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.itemContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
