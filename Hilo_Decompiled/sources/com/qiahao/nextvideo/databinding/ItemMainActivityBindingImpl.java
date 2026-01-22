package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.StaticGradientTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemMainActivityBindingImpl extends ItemMainActivityBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(17);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_main_activity_item", "include_main_activity_item", "include_main_activity_item", "include_main_activity_item"}, new int[]{2, 3, 4, 5}, new int[]{R.layout.include_main_activity_item, R.layout.include_main_activity_item, R.layout.include_main_activity_item, R.layout.include_main_activity_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362100, 6);
        sparseIntArray.put(R.id.topBg, 7);
        sparseIntArray.put(R.id.countDown, 8);
        sparseIntArray.put(R.id.help, 9);
        sparseIntArray.put(R.id.topTitle, 10);
        sparseIntArray.put(2131364936, 11);
        sparseIntArray.put(R.id.diamondBg, 12);
        sparseIntArray.put(R.id.gold, 13);
        sparseIntArray.put(R.id.diamondImage, 14);
        sparseIntArray.put(R.id.confirmBg, 15);
        sparseIntArray.put(R.id.confirmText, 16);
    }

    public ItemMainActivityBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFourItem(IncludeMainActivityItemBinding includeMainActivityItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneItem(IncludeMainActivityItemBinding includeMainActivityItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeItem(IncludeMainActivityItemBinding includeMainActivityItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoItem(IncludeMainActivityItemBinding includeMainActivityItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.oneItem);
        ViewDataBinding.executeBindingsOn(this.twoItem);
        ViewDataBinding.executeBindingsOn(this.threeItem);
        ViewDataBinding.executeBindingsOn(this.fourItem);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneItem.hasPendingBindings() || this.twoItem.hasPendingBindings() || this.threeItem.hasPendingBindings() || this.fourItem.hasPendingBindings()) {
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
            this.mDirtyFlags = 16L;
        }
        this.oneItem.invalidateAll();
        this.twoItem.invalidateAll();
        this.threeItem.invalidateAll();
        this.fourItem.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeFourItem((IncludeMainActivityItemBinding) obj, i2);
                }
                return onChangeTwoItem((IncludeMainActivityItemBinding) obj, i2);
            }
            return onChangeOneItem((IncludeMainActivityItemBinding) obj, i2);
        }
        return onChangeThreeItem((IncludeMainActivityItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneItem.setLifecycleOwner(lifecycleOwner);
        this.twoItem.setLifecycleOwner(lifecycleOwner);
        this.threeItem.setLifecycleOwner(lifecycleOwner);
        this.fourItem.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ItemMainActivityBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 4, (ImageView) objArr[6], (ImageView) objArr[15], (StaticGradientTextView) objArr[16], (TextView) objArr[8], (View) objArr[12], (ImageView) objArr[14], (IncludeMainActivityItemBinding) objArr[5], (ImageView) objArr[13], (ImageView) objArr[9], (IncludeMainActivityItemBinding) objArr[2], (TextView) objArr[11], (IncludeMainActivityItemBinding) objArr[4], (View) objArr[7], (ImageView) objArr[10], (IncludeMainActivityItemBinding) objArr[3]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.fourItem);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout2;
        constraintLayout2.setTag(null);
        setContainedBinding(this.oneItem);
        setContainedBinding(this.threeItem);
        setContainedBinding(this.twoItem);
        setRootTag(view);
        invalidateAll();
    }
}
