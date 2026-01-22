package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewCpLevelBindingImpl extends ViewCpLevelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.levelBg, 1);
        sparseIntArray.put(R.id.level0, 2);
        sparseIntArray.put(R.id.levelText0, 3);
        sparseIntArray.put(R.id.level1, 4);
        sparseIntArray.put(R.id.levelText1, 5);
        sparseIntArray.put(R.id.level2, 6);
        sparseIntArray.put(R.id.levelText2, 7);
        sparseIntArray.put(R.id.level3, 8);
        sparseIntArray.put(R.id.levelText3, 9);
        sparseIntArray.put(R.id.level4, 10);
        sparseIntArray.put(R.id.levelText4, 11);
        sparseIntArray.put(R.id.level5, 12);
        sparseIntArray.put(R.id.levelText5, 13);
        sparseIntArray.put(R.id.level6, 14);
        sparseIntArray.put(R.id.levelText6, 15);
        sparseIntArray.put(R.id.level7, 16);
        sparseIntArray.put(R.id.levelText7, 17);
        sparseIntArray.put(R.id.currentLevel, 18);
        sparseIntArray.put(R.id.currentLevelTip, 19);
    }

    public ViewCpLevelBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
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

    private ViewCpLevelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[18], (TextView) objArr[19], (ImageView) objArr[2], (ImageView) objArr[4], (ImageView) objArr[6], (ImageView) objArr[8], (ImageView) objArr[10], (ImageView) objArr[12], (ImageView) objArr[14], (ImageView) objArr[16], (View) objArr[1], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[17], (ConstraintLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.rootLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
