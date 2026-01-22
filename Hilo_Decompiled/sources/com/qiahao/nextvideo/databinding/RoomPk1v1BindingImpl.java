package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RoomPk1v1BindingImpl extends RoomPk1v1Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayout, 1);
        sparseIntArray.put(2131365152, 2);
        sparseIntArray.put(R.id.blueWinLight, 3);
        sparseIntArray.put(R.id.blueSpeakWave, 4);
        sparseIntArray.put(R.id.blueAvatar, 5);
        sparseIntArray.put(R.id.blueWinHead, 6);
        sparseIntArray.put(R.id.redWinLight, 7);
        sparseIntArray.put(R.id.redSpeakWave, 8);
        sparseIntArray.put(R.id.redAvatar, 9);
        sparseIntArray.put(R.id.redWinHead, 10);
        sparseIntArray.put(2131364343, 11);
        sparseIntArray.put(R.id.blueFire, 12);
        sparseIntArray.put(R.id.bluePoint, 13);
        sparseIntArray.put(R.id.blueNick, 14);
        sparseIntArray.put(R.id.redFire, 15);
        sparseIntArray.put(2131364535, 16);
        sparseIntArray.put(R.id.redNick, 17);
        sparseIntArray.put(R.id.winText, 18);
        sparseIntArray.put(2131364958, 19);
    }

    public RoomPk1v1BindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
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

    private RoomPk1v1BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[5], (ImageView) objArr[12], (TextView) objArr[14], (TextView) objArr[13], (PortraitAnimationView) objArr[4], (ImageView) objArr[6], (ImageView) objArr[3], (ConstraintLayout) objArr[0], (CustomProgressView) objArr[11], (QMUIRadiusImageView) objArr[9], (ImageView) objArr[15], (TextView) objArr[17], (TextView) objArr[16], (PortraitAnimationView) objArr[8], (ImageView) objArr[10], (ImageView) objArr[7], (SVGAImageView) objArr[19], (TextView) objArr[2], (LinearLayout) objArr[1], (TextView) objArr[18]);
        this.mDirtyFlags = -1L;
        this.constraint.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
