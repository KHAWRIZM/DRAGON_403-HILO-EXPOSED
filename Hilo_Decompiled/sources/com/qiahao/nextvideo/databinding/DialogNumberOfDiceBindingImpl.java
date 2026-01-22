package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogNumberOfDiceBindingImpl extends DialogNumberOfDiceBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_number_dice", "include_number_dice", "include_number_dice", "include_number_dice", "include_number_dice", "include_number_dice", "include_number_dice"}, new int[]{2, 3, 4, 5, 6, 7, 8}, new int[]{R.layout.include_number_dice, R.layout.include_number_dice, R.layout.include_number_dice, R.layout.include_number_dice, R.layout.include_number_dice, R.layout.include_number_dice, R.layout.include_number_dice});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 9);
        sparseIntArray.put(2131363500, 10);
        sparseIntArray.put(2131362424, 11);
        sparseIntArray.put(2131362224, 12);
    }

    public DialogNumberOfDiceBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFiveDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFourDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneNiceDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeOneSixDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeThreeDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTwoDice(IncludeNumberDiceBinding includeNumberDiceBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.oneDice);
        ViewDataBinding.executeBindingsOn(this.twoDice);
        ViewDataBinding.executeBindingsOn(this.threeDice);
        ViewDataBinding.executeBindingsOn(this.fourDice);
        ViewDataBinding.executeBindingsOn(this.fiveDice);
        ViewDataBinding.executeBindingsOn(this.oneNiceDice);
        ViewDataBinding.executeBindingsOn(this.oneSixDice);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.oneDice.hasPendingBindings() || this.twoDice.hasPendingBindings() || this.threeDice.hasPendingBindings() || this.fourDice.hasPendingBindings() || this.fiveDice.hasPendingBindings() || this.oneNiceDice.hasPendingBindings() || this.oneSixDice.hasPendingBindings()) {
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
            this.mDirtyFlags = 128L;
        }
        this.oneDice.invalidateAll();
        this.twoDice.invalidateAll();
        this.threeDice.invalidateAll();
        this.fourDice.invalidateAll();
        this.fiveDice.invalidateAll();
        this.oneNiceDice.invalidateAll();
        this.oneSixDice.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeOneDice((IncludeNumberDiceBinding) obj, i2);
            case 1:
                return onChangeFourDice((IncludeNumberDiceBinding) obj, i2);
            case 2:
                return onChangeOneSixDice((IncludeNumberDiceBinding) obj, i2);
            case 3:
                return onChangeFiveDice((IncludeNumberDiceBinding) obj, i2);
            case 4:
                return onChangeTwoDice((IncludeNumberDiceBinding) obj, i2);
            case 5:
                return onChangeOneNiceDice((IncludeNumberDiceBinding) obj, i2);
            case 6:
                return onChangeThreeDice((IncludeNumberDiceBinding) obj, i2);
            default:
                return false;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.oneDice.setLifecycleOwner(lifecycleOwner);
        this.twoDice.setLifecycleOwner(lifecycleOwner);
        this.threeDice.setLifecycleOwner(lifecycleOwner);
        this.fourDice.setLifecycleOwner(lifecycleOwner);
        this.fiveDice.setLifecycleOwner(lifecycleOwner);
        this.oneNiceDice.setLifecycleOwner(lifecycleOwner);
        this.oneSixDice.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private DialogNumberOfDiceBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (LinearLayout) objArr[0], (TextView) objArr[12], (TextView) objArr[11], (IncludeNumberDiceBinding) objArr[6], (IncludeNumberDiceBinding) objArr[5], (View) objArr[10], (IncludeNumberDiceBinding) objArr[2], (IncludeNumberDiceBinding) objArr[7], (IncludeNumberDiceBinding) objArr[8], (LinearLayout) objArr[1], (IncludeNumberDiceBinding) objArr[4], (TextView) objArr[9], (IncludeNumberDiceBinding) objArr[3]);
        this.mDirtyFlags = -1L;
        this.bgRoot.setTag(null);
        setContainedBinding(this.fiveDice);
        setContainedBinding(this.fourDice);
        setContainedBinding(this.oneDice);
        setContainedBinding(this.oneNiceDice);
        setContainedBinding(this.oneSixDice);
        this.radioGroup.setTag(null);
        setContainedBinding(this.threeDice);
        setContainedBinding(this.twoDice);
        setRootTag(view);
        invalidateAll();
    }
}
