package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityFamilyMemberBindingImpl extends ActivityFamilyMemberBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 1);
        sparseIntArray.put(R.id.backImageView, 2);
        sparseIntArray.put(2131365189, 3);
        sparseIntArray.put(R.id.exitImage, 4);
        sparseIntArray.put(R.id.searchLinearLayout, 5);
        sparseIntArray.put(R.id.search_edit_text, 6);
        sparseIntArray.put(R.id.newMembersLayout, 7);
        sparseIntArray.put(R.id.newMembers, 8);
        sparseIntArray.put(R.id.number, 9);
        sparseIntArray.put(R.id.statusView, 10);
        sparseIntArray.put(R.id.refreshLayout, 11);
        sparseIntArray.put(2131364510, 12);
    }

    public ActivityFamilyMemberBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private ActivityFamilyMemberBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[2], (AppCompatImageView) objArr[4], (TextView) objArr[8], (LinearLayout) objArr[7], (TextView) objArr[9], (RecyclerView) objArr[12], (SmartRefreshLayout) objArr[11], (EditText) objArr[6], (LinearLayout) objArr[5], (SuperStatusView) objArr[10], (TextView) objArr[3], (Toolbar) objArr[1]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
