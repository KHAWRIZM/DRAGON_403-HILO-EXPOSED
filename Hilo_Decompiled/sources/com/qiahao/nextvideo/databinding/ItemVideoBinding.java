package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemVideoBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final LinearLayoutCompat centerLayout;
    public final AppCompatImageView fromCountryImageView;
    public final ImageView iconVip;
    public final QMUIRadiusImageView2 image;
    public final AppCompatImageView likeImageView;
    public final AppCompatTextView name;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final AppCompatImageView videoImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemVideoBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, ImageView imageView, QMUIRadiusImageView2 qMUIRadiusImageView2, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ImageView imageView2, LinearLayout linearLayout, AppCompatImageView appCompatImageView3) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.centerLayout = linearLayoutCompat;
        this.fromCountryImageView = appCompatImageView;
        this.iconVip = imageView;
        this.image = qMUIRadiusImageView2;
        this.likeImageView = appCompatImageView2;
        this.name = appCompatTextView;
        this.stateContent = appCompatTextView2;
        this.stateImage = imageView2;
        this.stateLayout = linearLayout;
        this.videoImageView = appCompatImageView3;
    }

    public static ItemVideoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemVideoBinding bind(View view, Object obj) {
        return (ItemVideoBinding) ViewDataBinding.bind(obj, view, R.layout.item_video);
    }

    @Deprecated
    public static ItemVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video, viewGroup, z, obj);
    }

    public static ItemVideoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video, (ViewGroup) null, false, obj);
    }
}
