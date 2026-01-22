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
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityStrangeMatchBindingImpl extends ActivityStrangeMatchBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.matchSvga, 1);
        sparseIntArray.put(R.id.close, 2);
        sparseIntArray.put(R.id.setting, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(2131362440, 5);
        sparseIntArray.put(R.id.match, 6);
        sparseIntArray.put(R.id.centerLayout, 7);
        sparseIntArray.put(2131362013, 8);
        sparseIntArray.put(R.id.next, 9);
        sparseIntArray.put(R.id.avatarTip, 10);
        sparseIntArray.put(2131364012, 11);
        sparseIntArray.put(R.id.nameTip, 12);
        sparseIntArray.put(R.id.settingGroup, 13);
    }

    public ActivityStrangeMatchBindingImpl(f fVar, View view) {
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

    private ActivityStrangeMatchBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (QMUIRadiusImageView) objArr[8], (TextView) objArr[10], (ConstraintLayout) objArr[7], (ImageView) objArr[2], (TextView) objArr[5], (TextView) objArr[6], (SVGAImageView) objArr[1], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[9], (ImageView) objArr[3], (Group) objArr[13], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
