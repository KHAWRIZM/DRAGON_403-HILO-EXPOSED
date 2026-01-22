package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogDailyVipDiamondBindingImpl extends DialogDailyVipDiamondBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 1);
        sparseIntArray.put(R.id.contraint_1, 2);
        sparseIntArray.put(R.id.light_1, 3);
        sparseIntArray.put(R.id.match_times, 4);
        sparseIntArray.put(R.id.match_times_text, 5);
        sparseIntArray.put(R.id.contraint_2, 6);
        sparseIntArray.put(R.id.light_2, 7);
        sparseIntArray.put(R.id.diamond_day, 8);
        sparseIntArray.put(R.id.diamond_text, 9);
        sparseIntArray.put(R.id.ok_button, 10);
        sparseIntArray.put(R.id.online_svga, 11);
    }

    public DialogDailyVipDiamondBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private DialogDailyVipDiamondBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[6], (ImageView) objArr[8], (TextView) objArr[9], (ImageView) objArr[3], (ImageView) objArr[7], (ImageView) objArr[4], (TextView) objArr[5], (TextView) objArr[10], (SVGAImageView) objArr[11], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
