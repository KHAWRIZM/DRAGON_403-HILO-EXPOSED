package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomPkInviteBindingImpl extends DialogRoomPkInviteBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131365189, 2);
        sparseIntArray.put(R.id.redBg, 3);
        sparseIntArray.put(R.id.rightAvatarBg, 4);
        sparseIntArray.put(R.id.rightAvatar, 5);
        sparseIntArray.put(R.id.pkSearch, 6);
        sparseIntArray.put(R.id.blueBg, 7);
        sparseIntArray.put(R.id.leftAvatarBg, 8);
        sparseIntArray.put(R.id.leftAvatar, 9);
        sparseIntArray.put(R.id.leftName, 10);
        sparseIntArray.put(R.id.leftId, 11);
        sparseIntArray.put(R.id.buttonLayout, 12);
        sparseIntArray.put(R.id.countryImg, 13);
        sparseIntArray.put(R.id.ageTextView, 14);
        sparseIntArray.put(R.id.svipType, 15);
        sparseIntArray.put(R.id.vs, 16);
        sparseIntArray.put(R.id.accept, 17);
    }

    public DialogRoomPkInviteBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
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

    private DialogRoomPkInviteBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[17], (GenderAgeTextView) objArr[14], (ImageView) objArr[7], (LinearLayout) objArr[12], (ConstraintLayout) objArr[1], (ImageView) objArr[13], (QMUIRadiusImageView) objArr[9], (ImageView) objArr[8], (TextView) objArr[11], (TextView) objArr[10], (PKSearchView) objArr[6], (ImageView) objArr[3], (QMUIRadiusImageView) objArr[5], (ImageView) objArr[4], (ImageView) objArr[15], (TextView) objArr[2], (ImageView) objArr[16]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
