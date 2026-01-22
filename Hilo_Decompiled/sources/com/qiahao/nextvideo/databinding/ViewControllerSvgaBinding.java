package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerSvgaBinding extends ViewDataBinding {
    public final AppCompatButton addDurationSvgaButton;
    public final SVGAImageView addDurationSvgaImageView;
    public final AppCompatButton allSvgaButton;
    public final SVGAImageView likeImageView;
    public final AppCompatButton likeSvgaButton;
    public final RocketSvgaCountdownView rocketSvga;
    public final SVGAImageView svgImageView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerSvgaBinding(Object obj, View view, int i, AppCompatButton appCompatButton, SVGAImageView sVGAImageView, AppCompatButton appCompatButton2, SVGAImageView sVGAImageView2, AppCompatButton appCompatButton3, RocketSvgaCountdownView rocketSvgaCountdownView, SVGAImageView sVGAImageView3, Toolbar toolbar) {
        super(obj, view, i);
        this.addDurationSvgaButton = appCompatButton;
        this.addDurationSvgaImageView = sVGAImageView;
        this.allSvgaButton = appCompatButton2;
        this.likeImageView = sVGAImageView2;
        this.likeSvgaButton = appCompatButton3;
        this.rocketSvga = rocketSvgaCountdownView;
        this.svgImageView = sVGAImageView3;
        this.toolbar = toolbar;
    }

    public static ViewControllerSvgaBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerSvgaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerSvgaBinding bind(View view, Object obj) {
        return (ViewControllerSvgaBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_svga);
    }

    @Deprecated
    public static ViewControllerSvgaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerSvgaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_svga, viewGroup, z, obj);
    }

    public static ViewControllerSvgaBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerSvgaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerSvgaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_svga, (ViewGroup) null, false, obj);
    }
}
