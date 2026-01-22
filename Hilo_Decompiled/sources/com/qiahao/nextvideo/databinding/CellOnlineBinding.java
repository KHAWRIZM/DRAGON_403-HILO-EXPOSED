package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.FitRatioFrameLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellOnlineBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final CorneredImageView backgroundCorneredImageView;
    public final FitRatioFrameLayout backgroundFitRatioFrameLayout;
    public final FrameLayout cellFeedParentContainer;
    public final SVGAImageView chatImageView;
    public final AppCompatImageView fromCountryImageView;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatImageView likeImageView;
    public final SVGAImageView likeSvgaImageView;
    public final AppCompatTextView nicknameTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellOnlineBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, CorneredImageView corneredImageView, FitRatioFrameLayout fitRatioFrameLayout, FrameLayout frameLayout, SVGAImageView sVGAImageView, AppCompatImageView appCompatImageView, ImageView imageView, ImageView imageView2, AppCompatImageView appCompatImageView2, SVGAImageView sVGAImageView2, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.backgroundCorneredImageView = corneredImageView;
        this.backgroundFitRatioFrameLayout = fitRatioFrameLayout;
        this.cellFeedParentContainer = frameLayout;
        this.chatImageView = sVGAImageView;
        this.fromCountryImageView = appCompatImageView;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.likeImageView = appCompatImageView2;
        this.likeSvgaImageView = sVGAImageView2;
        this.nicknameTextView = appCompatTextView;
    }

    public static CellOnlineBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellOnlineBinding bind(View view, Object obj) {
        return (CellOnlineBinding) ViewDataBinding.bind(obj, view, R.layout.cell_online);
    }

    @Deprecated
    public static CellOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_online, viewGroup, z, obj);
    }

    public static CellOnlineBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellOnlineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_online, (ViewGroup) null, false, obj);
    }
}
