package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewSearchGroupUserBindingImpl extends ViewSearchGroupUserBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.base_root, 1);
        sparseIntArray.put(R.id.search_linear_layout, 2);
        sparseIntArray.put(R.id.search_edit_text, 3);
        sparseIntArray.put(2131362220, 4);
        sparseIntArray.put(R.id.common_tab_layout, 5);
        sparseIntArray.put(2131365640, 6);
    }

    public ViewSearchGroupUserBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
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

    private ViewSearchGroupUserBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (ConstraintLayout) objArr[1], (TextView) objArr[4], (CommonTabLayout) objArr[5], (EditText) objArr[3], (LinearLayout) objArr[2], (ViewPager) objArr[6]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
