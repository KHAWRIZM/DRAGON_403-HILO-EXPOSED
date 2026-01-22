package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
public class ItemPkMicroViewBindingImpl extends ItemPkMicroViewBinding {
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
        sparseIntArray.put(R.id.lock_micro, 5);
        sparseIntArray.put(2131365536, 6);
        sparseIntArray.put(R.id.user_mute, 7);
        sparseIntArray.put(R.id.micUserHeadSvga, 8);
        sparseIntArray.put(R.id.cpSvga, 9);
        sparseIntArray.put(R.id.mic_user_head_img, 10);
        sparseIntArray.put(R.id.user_vip, 11);
        sparseIntArray.put(2131363173, 12);
        sparseIntArray.put(R.id.iconSvip, 13);
        sparseIntArray.put(R.id.user_info_linear_layout, 14);
        sparseIntArray.put(2131365568, 15);
        sparseIntArray.put(R.id.userName, 16);
        sparseIntArray.put(R.id.face_svga, 17);
        sparseIntArray.put(R.id.personMicOff, 18);
        sparseIntArray.put(R.id.micOff, 19);
        sparseIntArray.put(R.id.musicSvga, 20);
        sparseIntArray.put(R.id.numberLayout, 21);
        sparseIntArray.put(R.id.fireImage, 22);
        sparseIntArray.put(R.id.number, 23);
    }

    public ItemPkMicroViewBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 24, sIncludes, sViewsWithIds));
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

    private ItemPkMicroViewBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[3], (SVGAImageView) objArr[9], (ImageView) objArr[4], (SVGAImageView) objArr[17], (ImageView) objArr[22], (ImageView) objArr[12], (ImageView) objArr[13], (View) objArr[2], (ImageView) objArr[5], (AppCompatImageView) objArr[19], (ImageView) objArr[10], (SVGAImageView) objArr[8], (SVGAImageView) objArr[20], (TextView) objArr[23], (LinearLayout) objArr[21], (AppCompatImageView) objArr[18], (PortraitAnimationView) objArr[1], (CircleImageView) objArr[6], (LinearLayout) objArr[14], (ImageView) objArr[7], (NickTextView) objArr[16], (ImageView) objArr[15], (ImageView) objArr[11]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
