package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.nextvideo.R;
import r1.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentCarromBagBindingImpl extends FragmentCarromBagBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(5);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_carrom_title", "include_carrom_title", "include_carrom_title"}, new int[]{1, 2, 3}, new int[]{R.layout.include_carrom_title, R.layout.include_carrom_title, R.layout.include_carrom_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.viewPage, 4);
    }

    public FragmentCarromBagBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangePower(IncludeCarromTitleBinding includeCarromTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePucks(IncludeCarromTitleBinding includeCarromTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeStriker(IncludeCarromTitleBinding includeCarromTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j & 8) != 0) {
            this.power.setImageRes(a.b(getRoot().getContext(), R.drawable.carrom_powers));
            this.power.setTitle(getRoot().getResources().getString(2131953711));
            this.pucks.setImageRes(a.b(getRoot().getContext(), R.drawable.carrom_pucks));
            this.pucks.setTitle(getRoot().getResources().getString(2131953806));
            this.striker.setImageRes(a.b(getRoot().getContext(), R.drawable.carrom_striker));
            this.striker.setTitle(getRoot().getResources().getString(2131954166));
        }
        ViewDataBinding.executeBindingsOn(this.striker);
        ViewDataBinding.executeBindingsOn(this.power);
        ViewDataBinding.executeBindingsOn(this.pucks);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.striker.hasPendingBindings() || this.power.hasPendingBindings() || this.pucks.hasPendingBindings()) {
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
            this.mDirtyFlags = 8L;
        }
        this.striker.invalidateAll();
        this.power.invalidateAll();
        this.pucks.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangePower((IncludeCarromTitleBinding) obj, i2);
            }
            return onChangeStriker((IncludeCarromTitleBinding) obj, i2);
        }
        return onChangePucks((IncludeCarromTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.striker.setLifecycleOwner(lifecycleOwner);
        this.power.setLifecycleOwner(lifecycleOwner);
        this.pucks.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentCarromBagBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (IncludeCarromTitleBinding) objArr[2], (IncludeCarromTitleBinding) objArr[3], (IncludeCarromTitleBinding) objArr[1], (ViewPager2) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.power);
        setContainedBinding(this.pucks);
        setContainedBinding(this.striker);
        setRootTag(view);
        invalidateAll();
    }
}
