package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewPowerMedalBindingImpl extends ViewPowerMedalBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.medal_o, 1);
        sparseIntArray.put(R.id.text_medal_o, 2);
        sparseIntArray.put(R.id.medal_n, 3);
        sparseIntArray.put(R.id.text_medal_n, 4);
        sparseIntArray.put(R.id.medal_m, 5);
        sparseIntArray.put(R.id.text_medal_m, 6);
        sparseIntArray.put(R.id.medal_l, 7);
        sparseIntArray.put(R.id.text_medal_l, 8);
        sparseIntArray.put(R.id.medal_k, 9);
        sparseIntArray.put(R.id.text_medal_k, 10);
        sparseIntArray.put(R.id.medal_j, 11);
        sparseIntArray.put(R.id.text_medal_j, 12);
        sparseIntArray.put(R.id.medal_i, 13);
        sparseIntArray.put(R.id.text_medal_i, 14);
        sparseIntArray.put(R.id.medal_h, 15);
        sparseIntArray.put(R.id.text_medal_h, 16);
        sparseIntArray.put(R.id.medal_g, 17);
        sparseIntArray.put(R.id.text_medal_g, 18);
        sparseIntArray.put(R.id.medal_f, 19);
        sparseIntArray.put(R.id.text_medal_f, 20);
        sparseIntArray.put(R.id.medal_e, 21);
        sparseIntArray.put(R.id.text_medal_e, 22);
        sparseIntArray.put(R.id.medal_d, 23);
        sparseIntArray.put(R.id.text_medal_d, 24);
        sparseIntArray.put(R.id.medal_c, 25);
        sparseIntArray.put(R.id.text_medal_c, 26);
        sparseIntArray.put(R.id.medal_b, 27);
        sparseIntArray.put(R.id.text_medal_b, 28);
        sparseIntArray.put(R.id.medal_a, 29);
        sparseIntArray.put(R.id.text_medal_a, 30);
    }

    public ViewPowerMedalBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
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

    private ViewPowerMedalBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[29], (ImageView) objArr[27], (ImageView) objArr[25], (ImageView) objArr[23], (ImageView) objArr[21], (ImageView) objArr[19], (ImageView) objArr[17], (ImageView) objArr[15], (ImageView) objArr[13], (ImageView) objArr[11], (ImageView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[5], (ImageView) objArr[3], (ImageView) objArr[1], (TextView) objArr[30], (TextView) objArr[28], (TextView) objArr[26], (TextView) objArr[24], (TextView) objArr[22], (TextView) objArr[20], (TextView) objArr[18], (TextView) objArr[16], (TextView) objArr[14], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
