package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGroupCustomThemeBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView addThemeImage;
    public final AppCompatImageView backImageView;
    public final TextView customTheme;
    public final View customThemeBackGroup;
    public final TextView diamondAndTime;
    public final ImageView diamondImg;
    public final AppCompatImageView imge;
    protected View.OnClickListener mClick;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGroupCustomThemeBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, AppCompatImageView appCompatImageView, TextView textView, View view2, TextView textView2, ImageView imageView2, AppCompatImageView appCompatImageView2, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.addThemeImage = imageView;
        this.backImageView = appCompatImageView;
        this.customTheme = textView;
        this.customThemeBackGroup = view2;
        this.diamondAndTime = textView2;
        this.diamondImg = imageView2;
        this.imge = appCompatImageView2;
        this.titleBar = toolbar;
    }

    public static ActivityGroupCustomThemeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGroupCustomThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityGroupCustomThemeBinding bind(View view, Object obj) {
        return (ActivityGroupCustomThemeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_group_custom_theme);
    }

    @Deprecated
    public static ActivityGroupCustomThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGroupCustomThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_custom_theme, viewGroup, z, obj);
    }

    public static ActivityGroupCustomThemeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGroupCustomThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGroupCustomThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_custom_theme, (ViewGroup) null, false, obj);
    }
}
