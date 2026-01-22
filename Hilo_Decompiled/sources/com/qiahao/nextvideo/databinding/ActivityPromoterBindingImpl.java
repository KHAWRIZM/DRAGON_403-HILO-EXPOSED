package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
public class ActivityPromoterBindingImpl extends ActivityPromoterBinding {
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
        sparseIntArray.put(R.id.leaderTitle, 5);
        sparseIntArray.put(R.id.diamondLayout, 6);
        sparseIntArray.put(R.id.leaderAvatar, 7);
        sparseIntArray.put(R.id.leaderName, 8);
        sparseIntArray.put(R.id.leaderID, 9);
        sparseIntArray.put(R.id.connect, 10);
        sparseIntArray.put(R.id.promoterSubTitle, 11);
        sparseIntArray.put(R.id.rechargeId, 12);
        sparseIntArray.put(R.id.rechargeOtherId, 13);
        sparseIntArray.put(R.id.userBg, 14);
        sparseIntArray.put(2131362013, 15);
        sparseIntArray.put(R.id.nickName, 16);
        sparseIntArray.put(2131365528, 17);
        sparseIntArray.put(R.id.userGroup, 18);
        sparseIntArray.put(R.id.avatarNo, 19);
        sparseIntArray.put(R.id.transferId, 20);
        sparseIntArray.put(R.id.select, 21);
        sparseIntArray.put(R.id.arrow, 22);
        sparseIntArray.put(R.id.userGroupNo, 23);
        sparseIntArray.put(R.id.tabLayout, 24);
        sparseIntArray.put(2131365624, 25);
        sparseIntArray.put(R.id.transferInvite, 26);
    }

    public ActivityPromoterBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 27, sIncludes, sViewsWithIds));
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

    private ActivityPromoterBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[22], (QMUIRadiusImageView) objArr[15], (QMUIRadiusImageView) objArr[19], (AppCompatImageView) objArr[3], (View) objArr[2], (TextView) objArr[10], (ConstraintLayout) objArr[6], (QMUIRadiusImageView) objArr[7], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[5], (NickTextView) objArr[16], (TextView) objArr[11], (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[13], (TextView) objArr[21], (SlidingTabLayout) objArr[24], (AppCompatTextView) objArr[4], (LinearLayoutCompat) objArr[1], (TextView) objArr[20], (TextView) objArr[26], (View) objArr[14], (Group) objArr[18], (Group) objArr[23], (TextView) objArr[17], (ViewPager) objArr[25]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
