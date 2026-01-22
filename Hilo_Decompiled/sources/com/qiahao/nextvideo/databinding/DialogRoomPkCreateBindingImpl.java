package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomPkCreateBindingImpl extends DialogRoomPkCreateBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131365189, 2);
        sparseIntArray.put(R.id.helper, 3);
        sparseIntArray.put(2131363500, 4);
        sparseIntArray.put(R.id.topBg, 5);
        sparseIntArray.put(R.id.centerBg, 6);
        sparseIntArray.put(R.id.leftAvatarBg, 7);
        sparseIntArray.put(R.id.leftAvatar, 8);
        sparseIntArray.put(R.id.rightAvatarBg, 9);
        sparseIntArray.put(R.id.rightAvatar, 10);
        sparseIntArray.put(R.id.pkSearch, 11);
        sparseIntArray.put(R.id.leftId, 12);
        sparseIntArray.put(R.id.leftName, 13);
        sparseIntArray.put(R.id.pkBrawl, 14);
        sparseIntArray.put(R.id.startMatch, 15);
        sparseIntArray.put(R.id.matching, 16);
        sparseIntArray.put(2131362220, 17);
        sparseIntArray.put(R.id.matchGroup, 18);
        sparseIntArray.put(R.id.currentPK, 19);
        sparseIntArray.put(R.id.statusView, 20);
        sparseIntArray.put(R.id.refreshLayout, 21);
        sparseIntArray.put(2131364510, 22);
    }

    public DialogRoomPkCreateBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 23, sIncludes, sViewsWithIds));
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

    private DialogRoomPkCreateBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[17], (ImageView) objArr[6], (ConstraintLayout) objArr[1], (TextView) objArr[19], (ImageView) objArr[3], (QMUIRadiusImageView) objArr[8], (ImageView) objArr[7], (TextView) objArr[12], (TextView) objArr[13], (View) objArr[4], (Group) objArr[18], (TextView) objArr[16], (GradientTextView) objArr[14], (PKSearchView) objArr[11], (RecyclerView) objArr[22], (SmartRefreshLayout) objArr[21], (QMUIRadiusImageView) objArr[10], (ImageView) objArr[9], (TextView) objArr[15], (SuperStatusView) objArr[20], (TextView) objArr[2], (ImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
