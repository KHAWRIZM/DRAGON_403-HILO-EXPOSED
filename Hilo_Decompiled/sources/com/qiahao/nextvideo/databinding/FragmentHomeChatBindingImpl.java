package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.ViewSelector;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeChatBindingImpl extends FragmentHomeChatBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(2131362438, 2);
        sparseIntArray.put(2131365189, 3);
        sparseIntArray.put(R.id.segment_tab_layout, 4);
        sparseIntArray.put(R.id.clear_unread, 5);
        sparseIntArray.put(2131365640, 6);
        sparseIntArray.put(R.id.notification_permission_tips_container, 7);
    }

    public FragmentHomeChatBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 8, sIncludes, sViewsWithIds));
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

    private FragmentHomeChatBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[5], (LinearLayout) objArr[2], (FrameLayout) objArr[7], (CommonTabLayout) objArr[4], (ConstraintLayout) objArr[3], (ImageView) objArr[1], (ViewSelector) objArr[6]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
