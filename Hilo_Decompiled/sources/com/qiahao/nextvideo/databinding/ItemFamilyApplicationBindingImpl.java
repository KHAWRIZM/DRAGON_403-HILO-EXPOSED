package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemFamilyApplicationBindingImpl extends ItemFamilyApplicationBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_avatar_cimage_view, 1);
        sparseIntArray.put(2131365557, 2);
        sparseIntArray.put(2131365152, 3);
        sparseIntArray.put(R.id.constraintLayout, 4);
        sparseIntArray.put(R.id.agree, 5);
        sparseIntArray.put(R.id.refuse, 6);
        sparseIntArray.put(R.id.applyGroup, 7);
        sparseIntArray.put(R.id.agreed, 8);
        sparseIntArray.put(R.id.memberType, 9);
        sparseIntArray.put(R.id.agreedGroup, 10);
        sparseIntArray.put(2131363500, 11);
    }

    public ItemFamilyApplicationBindingImpl(f fVar, View view) {
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

    private ItemFamilyApplicationBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[5], (TextView) objArr[8], (Group) objArr[10], (Group) objArr[7], (ConstraintLayout) objArr[4], (View) objArr[11], (AppCompatTextView) objArr[9], (TextView) objArr[6], (TextView) objArr[3], (QMUIRadiusImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
