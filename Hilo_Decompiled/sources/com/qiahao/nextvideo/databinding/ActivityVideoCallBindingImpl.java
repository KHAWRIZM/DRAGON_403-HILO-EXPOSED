package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.wedgit.CircleProgress;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.videocall.videoIM.VideoIM;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityVideoCallBindingImpl extends ActivityVideoCallBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.remote_video_view_container, 1);
        sparseIntArray.put(R.id.tips_view_container, 2);
        sparseIntArray.put(R.id.report_dialog_background_image_view, 3);
        sparseIntArray.put(R.id.remoteVideoLayout, 4);
        sparseIntArray.put(R.id.remoteAvatar, 5);
        sparseIntArray.put(R.id.remoteShelter, 6);
        sparseIntArray.put(R.id.videoIM, 7);
        sparseIntArray.put(R.id.giftContainer, 8);
        sparseIntArray.put(R.id.top_container, 9);
        sparseIntArray.put(2131365217, 10);
        sparseIntArray.put(R.id.avatarLayout, 11);
        sparseIntArray.put(R.id.userAvatar, 12);
        sparseIntArray.put(R.id.nickName, 13);
        sparseIntArray.put(R.id.iconCount, 14);
        sparseIntArray.put(R.id.countryName, 15);
        sparseIntArray.put(R.id.vipImage, 16);
        sparseIntArray.put(R.id.videoCallCountdownTextView, 17);
        sparseIntArray.put(R.id.exitLayout, 18);
        sparseIntArray.put(R.id.exitVideoCallImageView, 19);
        sparseIntArray.put(R.id.report_image_view, 20);
        sparseIntArray.put(R.id.local_video_view_container, 21);
        sparseIntArray.put(R.id.meVideoLayout, 22);
        sparseIntArray.put(R.id.meAvatar, 23);
        sparseIntArray.put(R.id.meShelter, 24);
        sparseIntArray.put(R.id.change, 25);
        sparseIntArray.put(R.id.closeCamera, 26);
        sparseIntArray.put(R.id.buttonLayout, 27);
        sparseIntArray.put(R.id.praise, 28);
        sparseIntArray.put(R.id.praiseImage, 29);
        sparseIntArray.put(R.id.circleProgress, 30);
        sparseIntArray.put(R.id.flower, 31);
        sparseIntArray.put(2131363640, 32);
        sparseIntArray.put(R.id.kiss, 33);
        sparseIntArray.put(R.id.call, 34);
        sparseIntArray.put(R.id.placeholder, 35);
        sparseIntArray.put(R.id.sendGift, 36);
        sparseIntArray.put(R.id.queuePlayer, 37);
        sparseIntArray.put(R.id.like_svga_image_view, 38);
        sparseIntArray.put(R.id.imGroup, 39);
    }

    public ActivityVideoCallBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 40, sIncludes, sViewsWithIds));
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

    private ActivityVideoCallBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[11], (ConstraintLayout) objArr[27], (ImageView) objArr[34], (ImageView) objArr[25], (CircleProgress) objArr[30], (ImageView) objArr[26], (TextView) objArr[15], (FrameLayout) objArr[18], (AppCompatImageView) objArr[19], (ImageView) objArr[31], (LinearLayoutCompat) objArr[8], (ImageView) objArr[14], (Group) objArr[39], (ImageView) objArr[33], (SVGAImageView) objArr[38], (FrameLayout) objArr[21], (ImageView) objArr[32], (QMUIRadiusImageView2) objArr[23], (QMUIRadiusImageView2) objArr[24], (ConstraintLayout) objArr[22], (AppCompatTextView) objArr[13], (View) objArr[35], (FrameLayout) objArr[28], (ImageView) objArr[29], (LightQueueCombinationPlayer) objArr[37], (QMUIRadiusImageView2) objArr[5], (SVGAImageView) objArr[6], (ConstraintLayout) objArr[4], (FrameLayout) objArr[1], (AppCompatImageView) objArr[3], (ImageView) objArr[20], (ImageView) objArr[36], (FrameLayout) objArr[2], (Toolbar) objArr[10], (LinearLayoutCompat) objArr[9], (CircleImageView) objArr[12], (AppCompatTextView) objArr[17], (VideoIM) objArr[7], (ImageView) objArr[16]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
