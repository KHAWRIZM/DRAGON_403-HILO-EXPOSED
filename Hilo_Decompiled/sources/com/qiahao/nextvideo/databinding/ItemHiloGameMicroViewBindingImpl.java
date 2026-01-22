package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemHiloGameMicroViewBindingImpl extends ItemHiloGameMicroViewBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.speak_wave, 1);
        sparseIntArray.put(R.id.localTip, 2);
        sparseIntArray.put(R.id.base_micro, 3);
        sparseIntArray.put(R.id.emptyMicImage, 4);
        sparseIntArray.put(R.id.emptyMicSVGA, 5);
        sparseIntArray.put(R.id.lock_micro, 6);
        sparseIntArray.put(2131365536, 7);
        sparseIntArray.put(R.id.user_mute, 8);
        sparseIntArray.put(R.id.mic_user_head_img, 9);
        sparseIntArray.put(R.id.face_svga, 10);
        sparseIntArray.put(R.id.personMicOff, 11);
        sparseIntArray.put(R.id.micOff, 12);
        sparseIntArray.put(R.id.musicSvga, 13);
        sparseIntArray.put(R.id.userTagLayout, 14);
        sparseIntArray.put(2131364298, 15);
        sparseIntArray.put(R.id.userTag, 16);
        sparseIntArray.put(R.id.micIcon, 17);
    }

    public ItemHiloGameMicroViewBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
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

    private ItemHiloGameMicroViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[3], (ImageView) objArr[4], (SVGAImageView) objArr[5], (SVGAImageView) objArr[10], (View) objArr[2], (ImageView) objArr[6], (ImageView) objArr[17], (AppCompatImageView) objArr[12], (ImageView) objArr[9], (SVGAImageView) objArr[13], (AppCompatImageView) objArr[11], (TextView) objArr[15], (PortraitAnimationView) objArr[1], (CircleImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[16], (ConstraintLayout) objArr[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
