package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFragmentActivityBinding extends ViewDataBinding {
    public final ImageView centerBg;
    public final QMUIRadiusImageView2 centerImage;
    public final QMUIRadiusImageView2 headerImage;
    public final ShineTextView idText;
    public final LinearLayout interested;
    public final ImageView interestedImage;
    public final TextView interestedText;
    public final TextView nickName;
    public final TextView number;
    public final ImageView numberImage;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final AppCompatTextView timeContent;
    public final ImageView timeImage;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFragmentActivityBinding(Object obj, View view, int i, ImageView imageView, QMUIRadiusImageView2 qMUIRadiusImageView2, QMUIRadiusImageView2 qMUIRadiusImageView22, ShineTextView shineTextView, LinearLayout linearLayout, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, ImageView imageView3, AppCompatTextView appCompatTextView, ImageView imageView4, LinearLayout linearLayout2, AppCompatTextView appCompatTextView2, ImageView imageView5, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.centerBg = imageView;
        this.centerImage = qMUIRadiusImageView2;
        this.headerImage = qMUIRadiusImageView22;
        this.idText = shineTextView;
        this.interested = linearLayout;
        this.interestedImage = imageView2;
        this.interestedText = textView;
        this.nickName = textView2;
        this.number = textView3;
        this.numberImage = imageView3;
        this.stateContent = appCompatTextView;
        this.stateImage = imageView4;
        this.stateLayout = linearLayout2;
        this.timeContent = appCompatTextView2;
        this.timeImage = imageView5;
        this.title = appCompatTextView3;
    }

    public static ItemFragmentActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFragmentActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFragmentActivityBinding bind(View view, Object obj) {
        return (ItemFragmentActivityBinding) ViewDataBinding.bind(obj, view, R.layout.item_fragment_activity);
    }

    @Deprecated
    public static ItemFragmentActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFragmentActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_activity, viewGroup, z, obj);
    }

    public static ItemFragmentActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFragmentActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFragmentActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_activity, (ViewGroup) null, false, obj);
    }
}
