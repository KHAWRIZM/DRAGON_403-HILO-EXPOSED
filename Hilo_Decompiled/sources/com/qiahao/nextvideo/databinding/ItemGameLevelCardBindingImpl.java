package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qiahao.nextvideo.ui.svip.TriangleView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemGameLevelCardBindingImpl extends ItemGameLevelCardBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131362100, 2);
        sparseIntArray.put(R.id.medalImg, 3);
        sparseIntArray.put(2131364012, 4);
        sparseIntArray.put(2131364343, 5);
        sparseIntArray.put(R.id.tipLayout, 6);
        sparseIntArray.put(2131365026, 7);
        sparseIntArray.put(2131365349, 8);
        sparseIntArray.put(R.id.date, 9);
        sparseIntArray.put(2131364936, 10);
        sparseIntArray.put(R.id.number, 11);
        sparseIntArray.put(2131363072, 12);
        sparseIntArray.put(R.id.defaultText, 13);
    }

    public ItemGameLevelCardBindingImpl(f fVar, View view) {
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

    private ItemGameLevelCardBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[2], (ConstraintLayout) objArr[1], (TextView) objArr[9], (TextView) objArr[13], (Group) objArr[12], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[11], (CustomProgressView) objArr[5], (TextView) objArr[10], (TextView) objArr[7], (ConstraintLayout) objArr[6], (TriangleView) objArr[8]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
