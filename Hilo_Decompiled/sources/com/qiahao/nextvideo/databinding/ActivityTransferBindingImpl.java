package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityTransferBindingImpl extends ActivityTransferBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 1);
        sparseIntArray.put(R.id.bar, 2);
        sparseIntArray.put(R.id.backImageView, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(R.id.promoter, 5);
        sparseIntArray.put(R.id.detail, 6);
        sparseIntArray.put(R.id.diamondLayout, 7);
        sparseIntArray.put(2131363500, 8);
        sparseIntArray.put(R.id.diamondTitle, 9);
        sparseIntArray.put(R.id.diamond, 10);
        sparseIntArray.put(R.id.powderTitle, 11);
        sparseIntArray.put(R.id.gemIcon, 12);
        sparseIntArray.put(R.id.gem, 13);
        sparseIntArray.put(R.id.buyDiamond, 14);
        sparseIntArray.put(R.id.agencyCenter, 15);
        sparseIntArray.put(R.id.secondLayout, 16);
        sparseIntArray.put(R.id.rechargeId, 17);
        sparseIntArray.put(R.id.rechargeOtherId, 18);
        sparseIntArray.put(R.id.userBg, 19);
        sparseIntArray.put(2131362013, 20);
        sparseIntArray.put(R.id.nickName, 21);
        sparseIntArray.put(2131365528, 22);
        sparseIntArray.put(R.id.userGroup, 23);
        sparseIntArray.put(R.id.avatarNo, 24);
        sparseIntArray.put(R.id.transferId, 25);
        sparseIntArray.put(R.id.select, 26);
        sparseIntArray.put(R.id.arrow, 27);
        sparseIntArray.put(R.id.userGroupNo, 28);
        sparseIntArray.put(R.id.tabLayout, 29);
        sparseIntArray.put(2131365624, 30);
        sparseIntArray.put(R.id.transferSendButton, 31);
        sparseIntArray.put(R.id.transferInvite, 32);
    }

    public ActivityTransferBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 33, sIncludes, sViewsWithIds));
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

    private ActivityTransferBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (TextView) objArr[15], (AppCompatImageView) objArr[27], (QMUIRadiusImageView) objArr[20], (QMUIRadiusImageView) objArr[24], (AppCompatImageView) objArr[3], (View) objArr[2], (TextView) objArr[14], (AppCompatImageView) objArr[6], (AppCompatTextView) objArr[10], (ConstraintLayout) objArr[7], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[13], (ImageView) objArr[12], (View) objArr[8], (NickTextView) objArr[21], (AppCompatTextView) objArr[11], (AppCompatImageView) objArr[5], (AppCompatTextView) objArr[17], (AppCompatTextView) objArr[18], (TextView) objArr[16], (TextView) objArr[26], (SlidingTabLayout) objArr[29], (AppCompatTextView) objArr[4], (LinearLayoutCompat) objArr[1], (TextView) objArr[25], (TextView) objArr[32], (TextView) objArr[31], (View) objArr[19], (Group) objArr[23], (Group) objArr[28], (TextView) objArr[22], (ViewPager) objArr[30]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
