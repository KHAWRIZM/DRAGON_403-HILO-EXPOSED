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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.wedgit.CircleProgress;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.DrawableTextView;
import com.qiahao.nextvideo.ui.reusable.views.squareprogressbar.SquareProgressView;
import com.qiahao.nextvideo.ui.videocall.videoIM.VideoIM;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityMatchVideoBindingImpl extends ActivityMatchVideoBinding {
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
        sparseIntArray.put(2131365217, 9);
        sparseIntArray.put(R.id.avatarLayout, 10);
        sparseIntArray.put(R.id.userAvatar, 11);
        sparseIntArray.put(R.id.nickName, 12);
        sparseIntArray.put(R.id.icon_count, 13);
        sparseIntArray.put(R.id.countryName, 14);
        sparseIntArray.put(R.id.vipImage, 15);
        sparseIntArray.put(R.id.exitLayout, 16);
        sparseIntArray.put(R.id.exitVideoCallImageView, 17);
        sparseIntArray.put(R.id.report_image_view, 18);
        sparseIntArray.put(R.id.local_video_view_container, 19);
        sparseIntArray.put(R.id.video_call_countdown_text_view, 20);
        sparseIntArray.put(R.id.count_down_box_frame_layout, 21);
        sparseIntArray.put(R.id.video_calling_counting_square_progress_bar, 22);
        sparseIntArray.put(R.id.meVideoLayout, 23);
        sparseIntArray.put(R.id.meAvatar, 24);
        sparseIntArray.put(R.id.meShelter, 25);
        sparseIntArray.put(R.id.change, 26);
        sparseIntArray.put(R.id.closeCamera, 27);
        sparseIntArray.put(R.id.buttonLayout, 28);
        sparseIntArray.put(R.id.placeholder, 29);
        sparseIntArray.put(R.id.praise, 30);
        sparseIntArray.put(R.id.praiseImage, 31);
        sparseIntArray.put(R.id.circleProgress, 32);
        sparseIntArray.put(R.id.flower, 33);
        sparseIntArray.put(2131363640, 34);
        sparseIntArray.put(R.id.kiss, 35);
        sparseIntArray.put(R.id.call, 36);
        sparseIntArray.put(R.id.sendGift, 37);
        sparseIntArray.put(R.id.queuePlayer, 38);
        sparseIntArray.put(R.id.like_svga_image_view, 39);
    }

    public ActivityMatchVideoBindingImpl(f fVar, View view) {
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

    private ActivityMatchVideoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[28], (ImageView) objArr[36], (ImageView) objArr[26], (CircleProgress) objArr[32], (ImageView) objArr[27], (FrameLayout) objArr[21], (TextView) objArr[14], (FrameLayout) objArr[16], (AppCompatImageView) objArr[17], (ImageView) objArr[33], (LinearLayoutCompat) objArr[8], (ImageView) objArr[13], (ImageView) objArr[35], (SVGAImageView) objArr[39], (FrameLayout) objArr[19], (ImageView) objArr[34], (QMUIRadiusImageView2) objArr[24], (QMUIRadiusImageView2) objArr[25], (ConstraintLayout) objArr[23], (AppCompatTextView) objArr[12], (View) objArr[29], (FrameLayout) objArr[30], (ImageView) objArr[31], (LightQueueCombinationPlayer) objArr[38], (QMUIRadiusImageView2) objArr[5], (SVGAImageView) objArr[6], (ConstraintLayout) objArr[4], (FrameLayout) objArr[1], (AppCompatImageView) objArr[3], (ImageView) objArr[18], (ImageView) objArr[37], (FrameLayout) objArr[2], (Toolbar) objArr[9], (CircleImageView) objArr[11], (DrawableTextView) objArr[20], (SquareProgressView) objArr[22], (VideoIM) objArr[7], (ImageView) objArr[15]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
