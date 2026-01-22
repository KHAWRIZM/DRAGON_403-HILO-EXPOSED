package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.FitRatioFrameLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupThemeBinding extends ViewDataBinding {
    public final CorneredImageView backgroundCorneredImageView;
    public final FitRatioFrameLayout backgroundFitRatioFrameLayout;
    public final ImageView selectTheme;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupThemeBinding(Object obj, View view, int i, CorneredImageView corneredImageView, FitRatioFrameLayout fitRatioFrameLayout, ImageView imageView) {
        super(obj, view, i);
        this.backgroundCorneredImageView = corneredImageView;
        this.backgroundFitRatioFrameLayout = fitRatioFrameLayout;
        this.selectTheme = imageView;
    }

    public static ItemGroupThemeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupThemeBinding bind(View view, Object obj) {
        return (ItemGroupThemeBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_theme);
    }

    @Deprecated
    public static ItemGroupThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_theme, viewGroup, z, obj);
    }

    public static ItemGroupThemeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_theme, (ViewGroup) null, false, obj);
    }
}
