package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloMessageRelationInviteBindingImpl extends HiloMessageRelationInviteBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_user_icon_view, 1);
        sparseIntArray.put(R.id.right_user_icon_view, 2);
        sparseIntArray.put(R.id.msg_content_ll, 3);
        sparseIntArray.put(R.id.image, 4);
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.subTitle, 6);
        sparseIntArray.put(R.id.join, 7);
    }

    public HiloMessageRelationInviteBindingImpl(f fVar, View view) {
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

    private HiloMessageRelationInviteBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (ImageView) objArr[4], (TextView) objArr[7], (UserIconView) objArr[1], (LinearLayout) objArr[3], (UserIconView) objArr[2], (TextView) objArr[6], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.allContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
