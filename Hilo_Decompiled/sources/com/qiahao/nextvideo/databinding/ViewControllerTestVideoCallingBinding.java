package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerTestVideoCallingBinding extends ViewDataBinding {
    public final AppCompatImageView addTimeImageView;
    public final FrameLayout baseContent;
    public final AppCompatImageView giftsPanelImageView;
    public final SVGAImageView likeSvgaImageView;
    public final AppCompatImageView loveImageView;
    public final LinearLayoutCompat purchaseMenuContainer;
    public final SVGAImageView sendGiftSvgaImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerTestVideoCallingBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, SVGAImageView sVGAImageView, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, SVGAImageView sVGAImageView2) {
        super(obj, view, i);
        this.addTimeImageView = appCompatImageView;
        this.baseContent = frameLayout;
        this.giftsPanelImageView = appCompatImageView2;
        this.likeSvgaImageView = sVGAImageView;
        this.loveImageView = appCompatImageView3;
        this.purchaseMenuContainer = linearLayoutCompat;
        this.sendGiftSvgaImageView = sVGAImageView2;
    }

    public static ViewControllerTestVideoCallingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerTestVideoCallingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerTestVideoCallingBinding bind(View view, Object obj) {
        return (ViewControllerTestVideoCallingBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_test_video_calling);
    }

    @Deprecated
    public static ViewControllerTestVideoCallingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerTestVideoCallingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_test_video_calling, viewGroup, z, obj);
    }

    public static ViewControllerTestVideoCallingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerTestVideoCallingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerTestVideoCallingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_test_video_calling, (ViewGroup) null, false, obj);
    }
}
