package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogOtherGiftBindingImpl extends DialogOtherGiftBinding {
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
        sparseIntArray.put(R.id.tabLayout, 5);
        sparseIntArray.put(R.id.bagImage, 6);
        sparseIntArray.put(R.id.viewPage, 7);
        sparseIntArray.put(R.id.send_gift_linear_layout, 8);
        sparseIntArray.put(R.id.select_member, 9);
        sparseIntArray.put(R.id.circle_avatar, 10);
        sparseIntArray.put(2131365557, 11);
        sparseIntArray.put(R.id.tip, 12);
    }

    public DialogOtherGiftBindingImpl(f fVar, View view) {
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

    private DialogOtherGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[6], (CircleImageView) objArr[10], (TextView) objArr[2], (LinearLayout) objArr[1], (ImageView) objArr[4], (TextView) objArr[3], (ConstraintLayout) objArr[0], (LinearLayout) objArr[9], (GroupSendGiftLinearLayout) objArr[8], (ViewPage2TabLayout) objArr[5], (ImageView) objArr[12], (TextView) objArr[11], (ViewPager2) objArr[7]);
        this.mDirtyFlags = -1L;
        this.rootBack.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
