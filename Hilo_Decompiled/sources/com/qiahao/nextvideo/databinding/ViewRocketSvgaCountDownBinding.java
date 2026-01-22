package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewRocketSvgaCountDownBinding extends ViewDataBinding {
    public final SVGAImageView bigSvga;
    public final ImageView countDownText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewRocketSvgaCountDownBinding(Object obj, View view, int i, SVGAImageView sVGAImageView, ImageView imageView) {
        super(obj, view, i);
        this.bigSvga = sVGAImageView;
        this.countDownText = imageView;
    }

    public static ViewRocketSvgaCountDownBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewRocketSvgaCountDownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewRocketSvgaCountDownBinding bind(View view, Object obj) {
        return (ViewRocketSvgaCountDownBinding) ViewDataBinding.bind(obj, view, R.layout.view_rocket_svga_count_down);
    }

    @Deprecated
    public static ViewRocketSvgaCountDownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewRocketSvgaCountDownBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rocket_svga_count_down, viewGroup, z, obj);
    }

    public static ViewRocketSvgaCountDownBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewRocketSvgaCountDownBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewRocketSvgaCountDownBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rocket_svga_count_down, (ViewGroup) null, false, obj);
    }
}
