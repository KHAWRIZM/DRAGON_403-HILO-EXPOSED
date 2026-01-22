package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemActivityBinding extends ViewDataBinding {
    public final AppCompatTextView content;
    public final ImageView contentImage;
    public final QMUIRadiusImageView2 countryIcon;
    public final ImageView image;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final AppCompatTextView timeContent;
    public final ImageView timeImage;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemActivityBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, ImageView imageView, QMUIRadiusImageView2 qMUIRadiusImageView2, ImageView imageView2, AppCompatTextView appCompatTextView2, ImageView imageView3, LinearLayout linearLayout, AppCompatTextView appCompatTextView3, ImageView imageView4, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.content = appCompatTextView;
        this.contentImage = imageView;
        this.countryIcon = qMUIRadiusImageView2;
        this.image = imageView2;
        this.stateContent = appCompatTextView2;
        this.stateImage = imageView3;
        this.stateLayout = linearLayout;
        this.timeContent = appCompatTextView3;
        this.timeImage = imageView4;
        this.title = appCompatTextView4;
    }

    public static ItemActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemActivityBinding bind(View view, Object obj) {
        return (ItemActivityBinding) ViewDataBinding.bind(obj, view, R.layout.item_activity);
    }

    @Deprecated
    public static ItemActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_activity, viewGroup, z, obj);
    }

    public static ItemActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_activity, (ViewGroup) null, false, obj);
    }
}
