package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.FitRatioFrameLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupMyThemeBinding extends ViewDataBinding {
    public final QMUIRadiusImageView backgroundCorneredImageView;
    public final FitRatioFrameLayout backgroundFitRatioFrameLayout;
    public final LinearLayout backgroundTimeView;
    public final ImageView selectTheme;
    public final TextView textTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupMyThemeBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, FitRatioFrameLayout fitRatioFrameLayout, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.backgroundCorneredImageView = qMUIRadiusImageView;
        this.backgroundFitRatioFrameLayout = fitRatioFrameLayout;
        this.backgroundTimeView = linearLayout;
        this.selectTheme = imageView;
        this.textTime = textView;
    }

    public static ItemGroupMyThemeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupMyThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupMyThemeBinding bind(View view, Object obj) {
        return (ItemGroupMyThemeBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_my_theme);
    }

    @Deprecated
    public static ItemGroupMyThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupMyThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_my_theme, viewGroup, z, obj);
    }

    public static ItemGroupMyThemeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupMyThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupMyThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_my_theme, (ViewGroup) null, false, obj);
    }
}
