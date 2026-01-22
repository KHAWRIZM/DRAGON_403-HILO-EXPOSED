package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityCreateActivitiesBindingImpl extends ActivityCreateActivitiesBinding {
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
        sparseIntArray.put(R.id.centerLayout, 5);
        sparseIntArray.put(R.id.bannerSize, 6);
        sparseIntArray.put(R.id.imageLayout, 7);
        sparseIntArray.put(R.id.createDefaultImage, 8);
        sparseIntArray.put(R.id.createImage, 9);
        sparseIntArray.put(2131364510, 10);
        sparseIntArray.put(R.id.tipLayout, 11);
        sparseIntArray.put(R.id.imge, 12);
        sparseIntArray.put(R.id.activityTheme, 13);
        sparseIntArray.put(R.id.activityThemeEditText, 14);
        sparseIntArray.put(R.id.activityDes, 15);
        sparseIntArray.put(R.id.activityDesEditText, 16);
        sparseIntArray.put(R.id.desNumber, 17);
        sparseIntArray.put(R.id.activityType, 18);
        sparseIntArray.put(R.id.selectLayout, 19);
        sparseIntArray.put(R.id.selectTitle, 20);
        sparseIntArray.put(R.id.selectText, 21);
        sparseIntArray.put(R.id.activityTime, 22);
        sparseIntArray.put(R.id.beginTimeLayout, 23);
        sparseIntArray.put(R.id.beginTimeTitle, 24);
        sparseIntArray.put(R.id.beginTimeText, 25);
        sparseIntArray.put(R.id.timeDurationLayout, 26);
        sparseIntArray.put(R.id.timeDurationTitle, 27);
        sparseIntArray.put(R.id.timeDurationText, 28);
        sparseIntArray.put(2131363295, 29);
        sparseIntArray.put(2131363296, 30);
        sparseIntArray.put(2131363297, 31);
    }

    public ActivityCreateActivitiesBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 32, sIncludes, sViewsWithIds));
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

    private ActivityCreateActivitiesBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[15], (AppCompatEditText) objArr[16], (FrameLayout) objArr[0], (TextView) objArr[13], (AppCompatEditText) objArr[14], (TextView) objArr[22], (TextView) objArr[18], (AppCompatImageView) objArr[3], (TextView) objArr[6], (View) objArr[2], (FrameLayout) objArr[23], (AppCompatTextView) objArr[25], (AppCompatTextView) objArr[24], (NestedScrollView) objArr[5], (ImageView) objArr[8], (QMUIRadiusImageView2) objArr[9], (TextView) objArr[17], (FrameLayout) objArr[7], (AppCompatImageView) objArr[12], (LinearLayout) objArr[29], (ImageView) objArr[30], (TextView) objArr[31], (RecyclerView) objArr[10], (FrameLayout) objArr[19], (AppCompatTextView) objArr[21], (AppCompatTextView) objArr[20], (FrameLayout) objArr[26], (AppCompatTextView) objArr[28], (AppCompatTextView) objArr[27], (ConstraintLayout) objArr[11], (TextView) objArr[4], (ConstraintLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
