package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerHomeDrawerHeadLayoutBindingImpl extends ViewControllerHomeDrawerHeadLayoutBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(R.id.topLinearLayout, 2);
        sparseIntArray.put(R.id.userHeadIconImageView, 3);
        sparseIntArray.put(R.id.iconVip, 4);
        sparseIntArray.put(R.id.iconNoble, 5);
        sparseIntArray.put(R.id.privilegeImageView, 6);
        sparseIntArray.put(R.id.nicknameTextView, 7);
        sparseIntArray.put(R.id.countryID, 8);
        sparseIntArray.put(R.id.ll_level, 9);
        sparseIntArray.put(2131365691, 10);
        sparseIntArray.put(2131362273, 11);
        sparseIntArray.put(R.id.activity_level, 12);
        sparseIntArray.put(R.id.increaseFansCountTextView, 13);
        sparseIntArray.put(R.id.likeCountContainer, 14);
        sparseIntArray.put(R.id.likeCountTextView, 15);
        sparseIntArray.put(R.id.likeTitle, 16);
        sparseIntArray.put(R.id.increaseVisitorCountTextView, 17);
        sparseIntArray.put(R.id.visitorsCountContainer, 18);
        sparseIntArray.put(R.id.visitorsCountTextView, 19);
        sparseIntArray.put(R.id.visitorTitle, 20);
        sparseIntArray.put(R.id.praiseCount, 21);
        sparseIntArray.put(R.id.praiseCountContainer, 22);
        sparseIntArray.put(R.id.praiseCountTextView, 23);
        sparseIntArray.put(R.id.praiseTitle, 24);
    }

    public ViewControllerHomeDrawerHeadLayoutBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
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

    private ViewControllerHomeDrawerHeadLayoutBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[12], (HiloGradeView) objArr[11], (CountryIDView) objArr[8], (ImageView) objArr[5], (ImageView) objArr[4], (AppCompatTextView) objArr[13], (AppCompatTextView) objArr[17], (LinearLayoutCompat) objArr[14], (AppCompatTextView) objArr[15], (AppCompatTextView) objArr[16], (LinearLayout) objArr[9], (NickTextView) objArr[7], (AppCompatTextView) objArr[21], (LinearLayoutCompat) objArr[22], (AppCompatTextView) objArr[23], (AppCompatTextView) objArr[24], (AppCompatImageView) objArr[6], (ImageView) objArr[1], (LinearLayoutCompat) objArr[2], (HiloImageView) objArr[3], (AppCompatTextView) objArr[20], (LinearLayoutCompat) objArr[18], (AppCompatTextView) objArr[19], (HiloGradeView) objArr[10]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
