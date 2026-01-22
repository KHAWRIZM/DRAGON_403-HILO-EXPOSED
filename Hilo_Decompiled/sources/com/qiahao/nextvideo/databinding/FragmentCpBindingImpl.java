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
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentCpBindingImpl extends FragmentCpBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tabLayout, 1);
        sparseIntArray.put(R.id.viewPage, 2);
        sparseIntArray.put(2131364958, 3);
        sparseIntArray.put(2131363784, 4);
        sparseIntArray.put(2131364298, 5);
        sparseIntArray.put(2131363500, 6);
        sparseIntArray.put(2131362014, 7);
        sparseIntArray.put(R.id.nickName1, 8);
        sparseIntArray.put(2131362015, 9);
        sparseIntArray.put(R.id.nickName2, 10);
        sparseIntArray.put(R.id.endLayout, 11);
        sparseIntArray.put(R.id.llDiamond, 12);
        sparseIntArray.put(R.id.heart, 13);
        sparseIntArray.put(R.id.cp_value, 14);
        sparseIntArray.put(R.id.cpZone, 15);
        sparseIntArray.put(R.id.bindZone, 16);
    }

    public FragmentCpBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 17, sIncludes, sViewsWithIds));
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

    private FragmentCpBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloImageView) objArr[7], (HiloImageView) objArr[9], (TextView) objArr[16], (TextView) objArr[14], (TextView) objArr[15], (ConstraintLayout) objArr[11], (ImageView) objArr[13], (View) objArr[6], (LinearLayout) objArr[12], (ImageView) objArr[4], (NickTextView) objArr[8], (NickTextView) objArr[10], (TextView) objArr[5], (ImageView) objArr[3], (HiloTabLayout) objArr[1], (ViewPager2) objArr[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
