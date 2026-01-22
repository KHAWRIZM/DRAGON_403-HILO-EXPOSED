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
public class ViewGameUnoBindingImpl extends ViewGameUnoBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(29);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_uno_item", "include_uno_item", "include_uno_item"}, new int[]{3, 4, 5}, new int[]{R.layout.include_uno_item, R.layout.include_uno_item, R.layout.include_uno_item});
        iVar.a(2, new String[]{"include_uno_item", "include_uno_item", "include_uno_item"}, new int[]{6, 7, 8}, new int[]{R.layout.include_uno_item, R.layout.include_uno_item, R.layout.include_uno_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gameTitleLayout, 9);
        sparseIntArray.put(R.id.moneyLayout, 10);
        sparseIntArray.put(R.id.diamondTwo, 11);
        sparseIntArray.put(R.id.diamond, 12);
        sparseIntArray.put(R.id.diamondText, 13);
        sparseIntArray.put(2131361922, 14);
        sparseIntArray.put(R.id.close, 15);
        sparseIntArray.put(R.id.information, 16);
        sparseIntArray.put(R.id.sound, 17);
        sparseIntArray.put(R.id.unoGameLayout, 18);
        sparseIntArray.put(R.id.prepareLayout, 19);
        sparseIntArray.put(R.id.gameLogo, 20);
        sparseIntArray.put(R.id.prepareTop, 21);
        sparseIntArray.put(R.id.betText, 22);
        sparseIntArray.put(R.id.betDiamond, 23);
        sparseIntArray.put(R.id.pieces, 24);
        sparseIntArray.put(R.id.change, 25);
        sparseIntArray.put(R.id.waitLayout, 26);
        sparseIntArray.put(R.id.waitText, 27);
        sparseIntArray.put(R.id.button, 28);
    }

    public ViewGameUnoBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 29, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFiveUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFourUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSixUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoUser(IncludeUnoItemBinding includeUnoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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
        ViewDataBinding.executeBindingsOn(this.threeUser);
        ViewDataBinding.executeBindingsOn(this.fourUser);
        ViewDataBinding.executeBindingsOn(this.fiveUser);
        ViewDataBinding.executeBindingsOn(this.sixUser);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneUser.hasPendingBindings() || this.twoUser.hasPendingBindings() || this.threeUser.hasPendingBindings() || this.fourUser.hasPendingBindings() || this.fiveUser.hasPendingBindings() || this.sixUser.hasPendingBindings()) {
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
            this.mDirtyFlags = 64L;
        }
        this.oneUser.invalidateAll();
        this.twoUser.invalidateAll();
        this.threeUser.invalidateAll();
        this.fourUser.invalidateAll();
        this.fiveUser.invalidateAll();
        this.sixUser.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeFiveUser((IncludeUnoItemBinding) obj, i2);
                        }
                        return onChangeTwoUser((IncludeUnoItemBinding) obj, i2);
                    }
                    return onChangeSixUser((IncludeUnoItemBinding) obj, i2);
                }
                return onChangeThreeUser((IncludeUnoItemBinding) obj, i2);
            }
            return onChangeFourUser((IncludeUnoItemBinding) obj, i2);
        }
        return onChangeOneUser((IncludeUnoItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneUser.setLifecycleOwner(lifecycleOwner);
        this.twoUser.setLifecycleOwner(lifecycleOwner);
        this.threeUser.setLifecycleOwner(lifecycleOwner);
        this.fourUser.setLifecycleOwner(lifecycleOwner);
        this.fiveUser.setLifecycleOwner(lifecycleOwner);
        this.sixUser.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewGameUnoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 6, (ImageView) objArr[14], (TextView) objArr[23], (LinearLayout) objArr[22], (TextView) objArr[28], (ImageView) objArr[25], (ImageView) objArr[15], (ImageView) objArr[12], (TextView) objArr[13], (ImageView) objArr[11], (IncludeUnoItemBinding) objArr[7], (IncludeUnoItemBinding) objArr[6], (SVGAImageView) objArr[20], (ConstraintLayout) objArr[9], (ImageView) objArr[16], (ConstraintLayout) objArr[10], (IncludeUnoItemBinding) objArr[3], (TextView) objArr[24], (ConstraintLayout) objArr[19], (ConstraintLayout) objArr[21], (IncludeUnoItemBinding) objArr[8], (ImageView) objArr[17], (IncludeUnoItemBinding) objArr[5], (IncludeUnoItemBinding) objArr[4], (FrameLayout) objArr[18], (LinearLayoutCompat) objArr[1], (LinearLayoutCompat) objArr[2], (ConstraintLayout) objArr[26], (TextView) objArr[27]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.fiveUser);
        setContainedBinding(this.fourUser);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.oneUser);
        setContainedBinding(this.sixUser);
        setContainedBinding(this.threeUser);
        setContainedBinding(this.twoUser);
        this.userLayout.setTag(null);
        this.userLayoutTwo.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
