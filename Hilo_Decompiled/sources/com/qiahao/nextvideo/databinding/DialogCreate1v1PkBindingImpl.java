package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.TriangleView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogCreate1v1PkBindingImpl extends DialogCreate1v1PkBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362100, 1);
        sparseIntArray.put(R.id.topView, 2);
        sparseIntArray.put(R.id.topImage, 3);
        sparseIntArray.put(R.id.helper, 4);
        sparseIntArray.put(R.id.close, 5);
        sparseIntArray.put(R.id.blueDefault, 6);
        sparseIntArray.put(R.id.blueSelect, 7);
        sparseIntArray.put(R.id.blueAvatar, 8);
        sparseIntArray.put(R.id.redDefault, 9);
        sparseIntArray.put(R.id.redSelect, 10);
        sparseIntArray.put(R.id.redAvatar, 11);
        sparseIntArray.put(R.id.vs, 12);
        sparseIntArray.put(R.id.blueNick, 13);
        sparseIntArray.put(R.id.blueHead, 14);
        sparseIntArray.put(R.id.redNick, 15);
        sparseIntArray.put(R.id.redHead, 16);
        sparseIntArray.put(R.id.memberBg, 17);
        sparseIntArray.put(2131365349, 18);
        sparseIntArray.put(R.id.selectTitle, 19);
        sparseIntArray.put(2131364510, 20);
        sparseIntArray.put(R.id.timeBg, 21);
        sparseIntArray.put(2131365152, 22);
        sparseIntArray.put(R.id.arrow, 23);
        sparseIntArray.put(R.id.selectTime, 24);
        sparseIntArray.put(R.id.startBg, 25);
        sparseIntArray.put(R.id.tick, 26);
        sparseIntArray.put(R.id.startPk, 27);
    }

    public DialogCreate1v1PkBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 28, sIncludes, sViewsWithIds));
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

    private DialogCreate1v1PkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[23], (ImageView) objArr[1], (QMUIRadiusImageView) objArr[8], (ImageView) objArr[6], (ImageView) objArr[14], (TextView) objArr[13], (ImageView) objArr[7], (ImageView) objArr[5], (ImageView) objArr[4], (View) objArr[17], (RecyclerView) objArr[20], (QMUIRadiusImageView) objArr[11], (ImageView) objArr[9], (ImageView) objArr[16], (TextView) objArr[15], (ImageView) objArr[10], (TextView) objArr[24], (TextView) objArr[19], (View) objArr[25], (TextView) objArr[27], (ImageView) objArr[26], (TextView) objArr[22], (View) objArr[21], (ImageView) objArr[3], (View) objArr[2], (TriangleView) objArr[18], (ImageView) objArr[12]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
