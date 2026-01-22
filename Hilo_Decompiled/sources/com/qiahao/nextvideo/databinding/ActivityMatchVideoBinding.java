package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
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
public abstract class ActivityMatchVideoBinding extends ViewDataBinding {
    public final ConstraintLayout avatarLayout;
    public final ConstraintLayout buttonLayout;
    public final ImageView call;
    public final ImageView change;
    public final CircleProgress circleProgress;
    public final ImageView closeCamera;
    public final FrameLayout countDownBoxFrameLayout;
    public final TextView countryName;
    public final FrameLayout exitLayout;
    public final AppCompatImageView exitVideoCallImageView;
    public final ImageView flower;
    public final LinearLayoutCompat giftContainer;
    public final ImageView iconCount;
    public final ImageView kiss;
    public final SVGAImageView likeSvgaImageView;
    public final FrameLayout localVideoViewContainer;
    public final ImageView love;
    public final QMUIRadiusImageView2 meAvatar;
    public final QMUIRadiusImageView2 meShelter;
    public final ConstraintLayout meVideoLayout;
    public final AppCompatTextView nickName;
    public final View placeholder;
    public final FrameLayout praise;
    public final ImageView praiseImage;
    public final LightQueueCombinationPlayer queuePlayer;
    public final QMUIRadiusImageView2 remoteAvatar;
    public final SVGAImageView remoteShelter;
    public final ConstraintLayout remoteVideoLayout;
    public final FrameLayout remoteVideoViewContainer;
    public final AppCompatImageView reportDialogBackgroundImageView;
    public final ImageView reportImageView;
    public final ImageView sendGift;
    public final FrameLayout tipsViewContainer;
    public final Toolbar toolbar;
    public final CircleImageView userAvatar;
    public final DrawableTextView videoCallCountdownTextView;
    public final SquareProgressView videoCallingCountingSquareProgressBar;
    public final VideoIM videoIM;
    public final ImageView vipImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMatchVideoBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, CircleProgress circleProgress, ImageView imageView3, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, ImageView imageView4, LinearLayoutCompat linearLayoutCompat, ImageView imageView5, ImageView imageView6, SVGAImageView sVGAImageView, FrameLayout frameLayout3, ImageView imageView7, QMUIRadiusImageView2 qMUIRadiusImageView2, QMUIRadiusImageView2 qMUIRadiusImageView22, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView, View view2, FrameLayout frameLayout4, ImageView imageView8, LightQueueCombinationPlayer lightQueueCombinationPlayer, QMUIRadiusImageView2 qMUIRadiusImageView23, SVGAImageView sVGAImageView2, ConstraintLayout constraintLayout4, FrameLayout frameLayout5, AppCompatImageView appCompatImageView2, ImageView imageView9, ImageView imageView10, FrameLayout frameLayout6, Toolbar toolbar, CircleImageView circleImageView, DrawableTextView drawableTextView, SquareProgressView squareProgressView, VideoIM videoIM, ImageView imageView11) {
        super(obj, view, i);
        this.avatarLayout = constraintLayout;
        this.buttonLayout = constraintLayout2;
        this.call = imageView;
        this.change = imageView2;
        this.circleProgress = circleProgress;
        this.closeCamera = imageView3;
        this.countDownBoxFrameLayout = frameLayout;
        this.countryName = textView;
        this.exitLayout = frameLayout2;
        this.exitVideoCallImageView = appCompatImageView;
        this.flower = imageView4;
        this.giftContainer = linearLayoutCompat;
        this.iconCount = imageView5;
        this.kiss = imageView6;
        this.likeSvgaImageView = sVGAImageView;
        this.localVideoViewContainer = frameLayout3;
        this.love = imageView7;
        this.meAvatar = qMUIRadiusImageView2;
        this.meShelter = qMUIRadiusImageView22;
        this.meVideoLayout = constraintLayout3;
        this.nickName = appCompatTextView;
        this.placeholder = view2;
        this.praise = frameLayout4;
        this.praiseImage = imageView8;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.remoteAvatar = qMUIRadiusImageView23;
        this.remoteShelter = sVGAImageView2;
        this.remoteVideoLayout = constraintLayout4;
        this.remoteVideoViewContainer = frameLayout5;
        this.reportDialogBackgroundImageView = appCompatImageView2;
        this.reportImageView = imageView9;
        this.sendGift = imageView10;
        this.tipsViewContainer = frameLayout6;
        this.toolbar = toolbar;
        this.userAvatar = circleImageView;
        this.videoCallCountdownTextView = drawableTextView;
        this.videoCallingCountingSquareProgressBar = squareProgressView;
        this.videoIM = videoIM;
        this.vipImage = imageView11;
    }

    public static ActivityMatchVideoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMatchVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityMatchVideoBinding bind(View view, Object obj) {
        return (ActivityMatchVideoBinding) ViewDataBinding.bind(obj, view, R.layout.activity_match_video);
    }

    @Deprecated
    public static ActivityMatchVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMatchVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_match_video, viewGroup, z, obj);
    }

    public static ActivityMatchVideoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMatchVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMatchVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_match_video, (ViewGroup) null, false, obj);
    }
}
