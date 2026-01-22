package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemGameMicroViewBindingImpl extends ItemGameMicroViewBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.speak_wave, 1);
        sparseIntArray.put(R.id.local_tip, 2);
        sparseIntArray.put(R.id.base_micro, 3);
        sparseIntArray.put(R.id.lock_micro, 4);
        sparseIntArray.put(2131365536, 5);
        sparseIntArray.put(R.id.user_mute, 6);
        sparseIntArray.put(R.id.mic_user_head_svga, 7);
        sparseIntArray.put(R.id.mic_user_head_img, 8);
        sparseIntArray.put(R.id.face_svga, 9);
        sparseIntArray.put(R.id.personMicOff, 10);
        sparseIntArray.put(R.id.micOff, 11);
    }

    public ItemGameMicroViewBindingImpl(f fVar, View view) {
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

    private ItemGameMicroViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[3], (SVGAImageView) objArr[9], (View) objArr[2], (ImageView) objArr[4], (AppCompatImageView) objArr[11], (ImageView) objArr[8], (SVGAImageView) objArr[7], (AppCompatImageView) objArr[10], (PortraitAnimationView) objArr[1], (CircleImageView) objArr[5], (ImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
