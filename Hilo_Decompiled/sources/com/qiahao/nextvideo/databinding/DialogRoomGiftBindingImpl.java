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
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupSendGiftLinearLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomGiftBindingImpl extends DialogRoomGiftBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gift_view_all, 1);
        sparseIntArray.put(R.id.diamondText, 2);
        sparseIntArray.put(R.id.rechargeText, 3);
        sparseIntArray.put(R.id.rechargeIcon, 4);
        sparseIntArray.put(R.id.svipLayout, 5);
        sparseIntArray.put(R.id.svipLeftImage, 6);
        sparseIntArray.put(R.id.svipLevel, 7);
        sparseIntArray.put(R.id.tabLayout, 8);
        sparseIntArray.put(R.id.bagImage, 9);
        sparseIntArray.put(R.id.viewPage, 10);
        sparseIntArray.put(R.id.send_gift_linear_layout, 11);
        sparseIntArray.put(R.id.select_member, 12);
        sparseIntArray.put(R.id.circle_avatar, 13);
        sparseIntArray.put(2131365557, 14);
        sparseIntArray.put(R.id.tip, 15);
        sparseIntArray.put(R.id.topLayout, 16);
        sparseIntArray.put(R.id.topFrameLayout, 17);
        sparseIntArray.put(R.id.topFrameBg, 18);
        sparseIntArray.put(R.id.oneLayout, 19);
        sparseIntArray.put(2131363201, 20);
        sparseIntArray.put(R.id.twoLayout, 21);
        sparseIntArray.put(R.id.imageOne, 22);
        sparseIntArray.put(R.id.imageTwo, 23);
    }

    public DialogRoomGiftBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 24, sIncludes, sViewsWithIds));
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

    private DialogRoomGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[9], (CircleImageView) objArr[13], (TextView) objArr[2], (LinearLayout) objArr[1], (QMUIRadiusImageView2) objArr[20], (QMUIRadiusImageView2) objArr[22], (QMUIRadiusImageView2) objArr[23], (ConstraintLayout) objArr[19], (ImageView) objArr[4], (TextView) objArr[3], (ConstraintLayout) objArr[0], (LinearLayout) objArr[12], (GroupSendGiftLinearLayout) objArr[11], (LinearLayout) objArr[5], (ImageView) objArr[6], (ImageView) objArr[7], (ViewPage2TabLayout) objArr[8], (ImageView) objArr[15], (ImageView) objArr[18], (FrameLayout) objArr[17], (ConstraintLayout) objArr[16], (ConstraintLayout) objArr[21], (TextView) objArr[14], (ViewPager2) objArr[10]);
        this.mDirtyFlags = -1L;
        this.rootBack.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
