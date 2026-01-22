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
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemHomeAuthenticationBindingImpl extends ItemHomeAuthenticationBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131362013, 2);
        sparseIntArray.put(R.id.newText, 3);
        sparseIntArray.put(2131363500, 4);
        sparseIntArray.put(R.id.online, 5);
        sparseIntArray.put(R.id.supperBtn, 6);
        sparseIntArray.put(R.id.ageTextView, 7);
        sparseIntArray.put(R.id.myAvatar, 8);
        sparseIntArray.put(2131364058, 9);
    }

    public ItemHomeAuthenticationBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
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

    private ItemHomeAuthenticationBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[7], (QMUIRadiusImageView) objArr[2], (ConstraintLayout) objArr[1], (View) objArr[4], (QMUIRadiusImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[5], (ImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
