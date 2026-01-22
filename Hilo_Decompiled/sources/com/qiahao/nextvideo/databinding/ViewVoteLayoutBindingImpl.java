package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewVoteLayoutBindingImpl extends ViewVoteLayoutBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.topBg, 2);
        sparseIntArray.put(2131362013, 3);
        sparseIntArray.put(R.id.avatarHeader, 4);
        sparseIntArray.put(2131364012, 5);
        sparseIntArray.put(R.id.voteText, 6);
        sparseIntArray.put(R.id.voteNumber, 7);
        sparseIntArray.put(R.id.voteButton, 8);
        sparseIntArray.put(R.id.avatar3, 9);
        sparseIntArray.put(2131362015, 10);
        sparseIntArray.put(2131362014, 11);
    }

    public ViewVoteLayoutBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private ViewVoteLayoutBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[3], (QMUIRadiusImageView) objArr[11], (QMUIRadiusImageView) objArr[10], (QMUIRadiusImageView) objArr[9], (ImageView) objArr[4], (ConstraintLayout) objArr[1], (TextView) objArr[5], (ImageView) objArr[2], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
