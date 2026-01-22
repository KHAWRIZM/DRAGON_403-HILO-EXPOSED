package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGameLevelRulesBindingImpl extends ActivityGameLevelRulesBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(8);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title", "include_svip_rules", "include_svip_rules", "include_svip_rules"}, new int[]{2, 3, 4, 5}, new int[]{R.layout.include_title, R.layout.include_svip_rules, R.layout.include_svip_rules, R.layout.include_svip_rules});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.fourText, 6);
        sparseIntArray.put(R.id.fiveText, 7);
    }

    public ActivityGameLevelRulesBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangeRulesOne(IncludeSvipRulesBinding includeSvipRulesBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRulesThree(IncludeSvipRulesBinding includeSvipRulesBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRulesTwo(IncludeSvipRulesBinding includeSvipRulesBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeTitleBar(IncludeTitleBinding includeTitleBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.titleBar);
        ViewDataBinding.executeBindingsOn(this.rulesOne);
        ViewDataBinding.executeBindingsOn(this.rulesTwo);
        ViewDataBinding.executeBindingsOn(this.rulesThree);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleBar.hasPendingBindings() || this.rulesOne.hasPendingBindings() || this.rulesTwo.hasPendingBindings() || this.rulesThree.hasPendingBindings()) {
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
        this.titleBar.invalidateAll();
        this.rulesOne.invalidateAll();
        this.rulesTwo.invalidateAll();
        this.rulesThree.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeTitleBar((IncludeTitleBinding) obj, i2);
                }
                return onChangeRulesTwo((IncludeSvipRulesBinding) obj, i2);
            }
            return onChangeRulesOne((IncludeSvipRulesBinding) obj, i2);
        }
        return onChangeRulesThree((IncludeSvipRulesBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
        this.rulesOne.setLifecycleOwner(lifecycleOwner);
        this.rulesTwo.setLifecycleOwner(lifecycleOwner);
        this.rulesThree.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityGameLevelRulesBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 4, (FrameLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[6], (IncludeSvipRulesBinding) objArr[3], (IncludeSvipRulesBinding) objArr[5], (IncludeSvipRulesBinding) objArr[4], (IncludeTitleBinding) objArr[2]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.rulesOne);
        setContainedBinding(this.rulesThree);
        setContainedBinding(this.rulesTwo);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}
