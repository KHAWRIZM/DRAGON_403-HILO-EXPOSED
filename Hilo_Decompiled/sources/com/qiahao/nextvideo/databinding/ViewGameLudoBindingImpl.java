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
public class ViewGameLudoBindingImpl extends ViewGameLudoBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(28);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_ludo_item", "include_ludo_item", "include_ludo_item", "include_ludo_item"}, new int[]{2, 3, 4, 5}, new int[]{R.layout.include_ludo_item, R.layout.include_ludo_item, R.layout.include_ludo_item, R.layout.include_ludo_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gameTitleLayout, 6);
        sparseIntArray.put(R.id.moneyLayout, 7);
        sparseIntArray.put(R.id.diamondTwo, 8);
        sparseIntArray.put(R.id.diamond, 9);
        sparseIntArray.put(R.id.diamondText, 10);
        sparseIntArray.put(2131361922, 11);
        sparseIntArray.put(R.id.close, 12);
        sparseIntArray.put(R.id.information, 13);
        sparseIntArray.put(R.id.sound, 14);
        sparseIntArray.put(R.id.ludoGameLayout, 15);
        sparseIntArray.put(R.id.prepareLayout, 16);
        sparseIntArray.put(R.id.gameLogo, 17);
        sparseIntArray.put(R.id.prepareTop, 18);
        sparseIntArray.put(R.id.betText, 19);
        sparseIntArray.put(R.id.betDiamond, 20);
        sparseIntArray.put(R.id.quick, 21);
        sparseIntArray.put(R.id.pieces, 22);
        sparseIntArray.put(R.id.magic, 23);
        sparseIntArray.put(R.id.change, 24);
        sparseIntArray.put(R.id.waitLayout, 25);
        sparseIntArray.put(R.id.waitText, 26);
        sparseIntArray.put(R.id.button, 27);
    }

    public ViewGameLudoBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 28, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFourUser(IncludeLudoItemBinding includeLudoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneUser(IncludeLudoItemBinding includeLudoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeUser(IncludeLudoItemBinding includeLudoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoUser(IncludeLudoItemBinding includeLudoItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneUser.hasPendingBindings() || this.twoUser.hasPendingBindings() || this.threeUser.hasPendingBindings() || this.fourUser.hasPendingBindings()) {
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
        this.oneUser.invalidateAll();
        this.twoUser.invalidateAll();
        this.threeUser.invalidateAll();
        this.fourUser.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeTwoUser((IncludeLudoItemBinding) obj, i2);
                }
                return onChangeThreeUser((IncludeLudoItemBinding) obj, i2);
            }
            return onChangeFourUser((IncludeLudoItemBinding) obj, i2);
        }
        return onChangeOneUser((IncludeLudoItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneUser.setLifecycleOwner(lifecycleOwner);
        this.twoUser.setLifecycleOwner(lifecycleOwner);
        this.threeUser.setLifecycleOwner(lifecycleOwner);
        this.fourUser.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewGameLudoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 4, (ImageView) objArr[11], (TextView) objArr[20], (LinearLayout) objArr[19], (TextView) objArr[27], (ImageView) objArr[24], (ImageView) objArr[12], (ImageView) objArr[9], (TextView) objArr[10], (ImageView) objArr[8], (IncludeLudoItemBinding) objArr[5], (SVGAImageView) objArr[17], (ConstraintLayout) objArr[6], (ImageView) objArr[13], (FrameLayout) objArr[15], (TextView) objArr[23], (ConstraintLayout) objArr[7], (IncludeLudoItemBinding) objArr[2], (TextView) objArr[22], (ConstraintLayout) objArr[16], (ConstraintLayout) objArr[18], (TextView) objArr[21], (ImageView) objArr[14], (IncludeLudoItemBinding) objArr[4], (IncludeLudoItemBinding) objArr[3], (LinearLayoutCompat) objArr[1], (ConstraintLayout) objArr[25], (TextView) objArr[26]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.fourUser);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.oneUser);
        setContainedBinding(this.threeUser);
        setContainedBinding(this.twoUser);
        this.userLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
