package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewGameBackgammonBindingImpl extends ViewGameBackgammonBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(25);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_jackaro_item", "include_jackaro_item"}, new int[]{2, 3}, new int[]{R.layout.include_jackaro_item, R.layout.include_jackaro_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gameTitleLayout, 4);
        sparseIntArray.put(R.id.moneyLayout, 5);
        sparseIntArray.put(R.id.diamondTwo, 6);
        sparseIntArray.put(R.id.diamond, 7);
        sparseIntArray.put(R.id.diamondText, 8);
        sparseIntArray.put(2131361922, 9);
        sparseIntArray.put(R.id.close, 10);
        sparseIntArray.put(R.id.information, 11);
        sparseIntArray.put(R.id.sound, 12);
        sparseIntArray.put(R.id.backgammonGameLayout, 13);
        sparseIntArray.put(R.id.prepareLayout, 14);
        sparseIntArray.put(R.id.gameLogo, 15);
        sparseIntArray.put(R.id.prepareTop, 16);
        sparseIntArray.put(R.id.betText, 17);
        sparseIntArray.put(R.id.betDiamond, 18);
        sparseIntArray.put(R.id.quick, 19);
        sparseIntArray.put(R.id.change, 20);
        sparseIntArray.put(R.id.vs, 21);
        sparseIntArray.put(R.id.waitLayout, 22);
        sparseIntArray.put(R.id.waitText, 23);
        sparseIntArray.put(R.id.button, 24);
    }

    public ViewGameBackgammonBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
    }

    private boolean onChangeOneUser(IncludeJackaroItemBinding includeJackaroItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoUser(IncludeJackaroItemBinding includeJackaroItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.oneUser);
        ViewDataBinding.executeBindingsOn(this.twoUser);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneUser.hasPendingBindings() || this.twoUser.hasPendingBindings()) {
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
            this.mDirtyFlags = 4L;
        }
        this.oneUser.invalidateAll();
        this.twoUser.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeTwoUser((IncludeJackaroItemBinding) obj, i2);
        }
        return onChangeOneUser((IncludeJackaroItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneUser.setLifecycleOwner(lifecycleOwner);
        this.twoUser.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewGameBackgammonBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (ImageView) objArr[9], (FrameLayout) objArr[13], (TextView) objArr[18], (LinearLayout) objArr[17], (TextView) objArr[24], (ImageView) objArr[20], (ImageView) objArr[10], (ImageView) objArr[7], (TextView) objArr[8], (ImageView) objArr[6], (SVGAImageView) objArr[15], (ConstraintLayout) objArr[4], (ImageView) objArr[11], (ConstraintLayout) objArr[5], (IncludeJackaroItemBinding) objArr[2], (ConstraintLayout) objArr[14], (ConstraintLayout) objArr[16], (TextView) objArr[19], (ImageView) objArr[12], (IncludeJackaroItemBinding) objArr[3], (LinearLayoutCompat) objArr[1], (ImageView) objArr[21], (ConstraintLayout) objArr[22], (TextView) objArr[23]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.oneUser);
        setContainedBinding(this.twoUser);
        this.userLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
