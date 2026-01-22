package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemBigMicroViewBindingImpl extends ItemBigMicroViewBinding {
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
        sparseIntArray.put(R.id.emptyMicImage, 4);
        sparseIntArray.put(R.id.emptyMicSVGA, 5);
        sparseIntArray.put(R.id.lock_micro, 6);
        sparseIntArray.put(2131365536, 7);
        sparseIntArray.put(R.id.user_mute, 8);
        sparseIntArray.put(R.id.mic_user_head_svga, 9);
        sparseIntArray.put(R.id.cpSvga, 10);
        sparseIntArray.put(R.id.mic_user_head_img, 11);
        sparseIntArray.put(R.id.user_vip, 12);
        sparseIntArray.put(2131363173, 13);
        sparseIntArray.put(R.id.iconSvip, 14);
        sparseIntArray.put(R.id.user_info_linear_layout, 15);
        sparseIntArray.put(2131365568, 16);
        sparseIntArray.put(2131365557, 17);
        sparseIntArray.put(R.id.face_svga, 18);
        sparseIntArray.put(R.id.personMicOff, 19);
        sparseIntArray.put(R.id.micOff, 20);
        sparseIntArray.put(R.id.musicSvga, 21);
    }

    public ItemBigMicroViewBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 22, sIncludes, sViewsWithIds));
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

    private ItemBigMicroViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[3], (SVGAImageView) objArr[10], (ImageView) objArr[4], (SVGAImageView) objArr[5], (SVGAImageView) objArr[18], (ImageView) objArr[13], (ImageView) objArr[14], (View) objArr[2], (ImageView) objArr[6], (AppCompatImageView) objArr[20], (ImageView) objArr[11], (SVGAImageView) objArr[9], (SVGAImageView) objArr[21], (AppCompatImageView) objArr[19], (PortraitAnimationView) objArr[1], (CircleImageView) objArr[7], (LinearLayout) objArr[15], (ImageView) objArr[8], (NickTextView) objArr[17], (ImageView) objArr[16], (ImageView) objArr[12]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
