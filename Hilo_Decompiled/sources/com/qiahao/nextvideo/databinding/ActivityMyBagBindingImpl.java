package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityMyBagBindingImpl extends ActivityMyBagBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(9);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title"}, new int[]{2}, new int[]{R.layout.include_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 3);
        sparseIntArray.put(2131365624, 4);
        sparseIntArray.put(R.id.bottom_bg, 5);
        sparseIntArray.put(R.id.text_use, 6);
        sparseIntArray.put(R.id.text_send, 7);
        sparseIntArray.put(R.id.use, 8);
    }

    public ActivityMyBagBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleLayout(IncludeTitleBinding includeTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleLayout.hasPendingBindings()) {
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
            this.mDirtyFlags = 2L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTitleLayout((IncludeTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityMyBagBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (View) objArr[5], (SlidingTabLayout) objArr[3], (TextView) objArr[7], (TextView) objArr[6], (IncludeTitleBinding) objArr[2], (TextView) objArr[8], (ViewPager) objArr[4]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(view);
        invalidateAll();
    }
}
