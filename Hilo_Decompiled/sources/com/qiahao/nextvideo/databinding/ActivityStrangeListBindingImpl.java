package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityStrangeListBindingImpl extends ActivityStrangeListBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.linearLayout, 2);
        sparseIntArray.put(R.id.bar, 3);
        sparseIntArray.put(R.id.backImageView, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.refreshLayout, 6);
        sparseIntArray.put(R.id.numberLayout, 7);
        sparseIntArray.put(2131363500, 8);
        sparseIntArray.put(2131364936, 9);
        sparseIntArray.put(R.id.matchLayout, 10);
        sparseIntArray.put(R.id.strangeIcon, 11);
        sparseIntArray.put(R.id.masked_text, 12);
        sparseIntArray.put(R.id.end_arrow, 13);
        sparseIntArray.put(2131364510, 14);
    }

    public ActivityStrangeListBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 15, sIncludes, sViewsWithIds));
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

    private ActivityStrangeListBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[4], (View) objArr[3], (ConstraintLayout) objArr[1], (ImageView) objArr[13], (View) objArr[8], (LinearLayoutCompat) objArr[2], (TextView) objArr[12], (ConstraintLayout) objArr[10], (LinearLayout) objArr[7], (RecyclerView) objArr[14], (SmartRefreshLayout) objArr[6], (ImageView) objArr[11], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
