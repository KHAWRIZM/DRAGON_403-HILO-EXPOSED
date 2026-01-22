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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogChangeCountryBindingImpl extends DialogChangeCountryBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 1);
        sparseIntArray.put(R.id.centerLayout, 2);
        sparseIntArray.put(R.id.oldCountry, 3);
        sparseIntArray.put(R.id.oldCountryName, 4);
        sparseIntArray.put(R.id.centerImage, 5);
        sparseIntArray.put(R.id.newCountry, 6);
        sparseIntArray.put(R.id.newCountryName, 7);
        sparseIntArray.put(R.id.changeGroup, 8);
        sparseIntArray.put(2131365152, 9);
        sparseIntArray.put(2131362440, 10);
        sparseIntArray.put(2131362424, 11);
        sparseIntArray.put(2131362224, 12);
    }

    public DialogChangeCountryBindingImpl(f fVar, View view) {
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

    private DialogChangeCountryBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[12], (ImageView) objArr[5], (ConstraintLayout) objArr[2], (Group) objArr[8], (TextView) objArr[11], (TextView) objArr[10], (ImageView) objArr[6], (TextView) objArr[7], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[9], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
