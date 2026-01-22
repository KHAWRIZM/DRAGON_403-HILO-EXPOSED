package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentTransferCenterBindingImpl extends FragmentTransferCenterBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_transfer_text", "include_transfer_text", "include_transfer_text"}, new int[]{2, 3, 4}, new int[]{R.layout.include_transfer_text, R.layout.include_transfer_text, R.layout.include_transfer_text});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.banner, 5);
        sparseIntArray.put(R.id.thisView, 6);
        sparseIntArray.put(R.id.thisText, 7);
        sparseIntArray.put(R.id.monthBg, 8);
        sparseIntArray.put(R.id.oneLine, 9);
        sparseIntArray.put(R.id.twoLine, 10);
        sparseIntArray.put(R.id.tabLayout, 11);
        sparseIntArray.put(2131365624, 12);
    }

    public FragmentTransferCenterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeClients(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDiamonds(IncludeTransferTextBinding includeTransferTextBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSales(IncludeTransferTextBinding includeTransferTextBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.sales);
        ViewDataBinding.executeBindingsOn(this.diamonds);
        ViewDataBinding.executeBindingsOn(this.clients);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.sales.hasPendingBindings() || this.diamonds.hasPendingBindings() || this.clients.hasPendingBindings()) {
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
        this.sales.invalidateAll();
        this.diamonds.invalidateAll();
        this.clients.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeClients((IncludeTransferTextBinding) obj, i2);
            }
            return onChangeDiamonds((IncludeTransferTextBinding) obj, i2);
        }
        return onChangeSales((IncludeTransferTextBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.sales.setLifecycleOwner(lifecycleOwner);
        this.diamonds.setLifecycleOwner(lifecycleOwner);
        this.clients.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentTransferCenterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (FrameLayout) objArr[0], (BannerViewPager) objArr[5], (IncludeTransferTextBinding) objArr[4], (IncludeTransferTextBinding) objArr[3], (View) objArr[8], (View) objArr[9], (IncludeTransferTextBinding) objArr[2], (SlidingTabLayout) objArr[11], (AppCompatTextView) objArr[7], (View) objArr[6], (View) objArr[10], (ViewPager) objArr[12]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setContainedBinding(this.clients);
        setContainedBinding(this.diamonds);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.sales);
        setRootTag(view);
        invalidateAll();
    }
}
