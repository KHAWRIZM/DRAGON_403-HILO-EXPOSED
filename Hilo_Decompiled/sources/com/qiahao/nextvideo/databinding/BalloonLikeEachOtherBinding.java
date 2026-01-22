package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BalloonLikeEachOtherBinding extends ViewDataBinding {
    public final AppCompatImageView dismissImageView;
    public final CircleImageView leftCircleImageView;
    public final AppCompatImageView likeIconImageView;
    public final CircleImageView rightCircleImageView;
    public final SVGAImageView svgaImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public BalloonLikeEachOtherBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, CircleImageView circleImageView, AppCompatImageView appCompatImageView2, CircleImageView circleImageView2, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.dismissImageView = appCompatImageView;
        this.leftCircleImageView = circleImageView;
        this.likeIconImageView = appCompatImageView2;
        this.rightCircleImageView = circleImageView2;
        this.svgaImageView = sVGAImageView;
    }

    public static BalloonLikeEachOtherBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static BalloonLikeEachOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static BalloonLikeEachOtherBinding bind(View view, Object obj) {
        return (BalloonLikeEachOtherBinding) ViewDataBinding.bind(obj, view, R.layout.balloon_like_each_other);
    }

    @Deprecated
    public static BalloonLikeEachOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BalloonLikeEachOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.balloon_like_each_other, viewGroup, z, obj);
    }

    public static BalloonLikeEachOtherBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static BalloonLikeEachOtherBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BalloonLikeEachOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.balloon_like_each_other, (ViewGroup) null, false, obj);
    }
}
