package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.StaticGradientTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMainActivityBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ImageView confirmBg;
    public final StaticGradientTextView confirmText;
    public final TextView countDown;
    public final View diamondBg;
    public final ImageView diamondImage;
    public final IncludeMainActivityItemBinding fourItem;
    public final ImageView gold;
    public final ImageView help;
    public final IncludeMainActivityItemBinding oneItem;
    public final TextView subTitle;
    public final IncludeMainActivityItemBinding threeItem;
    public final View topBg;
    public final ImageView topTitle;
    public final IncludeMainActivityItemBinding twoItem;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMainActivityBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, StaticGradientTextView staticGradientTextView, TextView textView, View view2, ImageView imageView3, IncludeMainActivityItemBinding includeMainActivityItemBinding, ImageView imageView4, ImageView imageView5, IncludeMainActivityItemBinding includeMainActivityItemBinding2, TextView textView2, IncludeMainActivityItemBinding includeMainActivityItemBinding3, View view3, ImageView imageView6, IncludeMainActivityItemBinding includeMainActivityItemBinding4) {
        super(obj, view, i);
        this.bg = imageView;
        this.confirmBg = imageView2;
        this.confirmText = staticGradientTextView;
        this.countDown = textView;
        this.diamondBg = view2;
        this.diamondImage = imageView3;
        this.fourItem = includeMainActivityItemBinding;
        this.gold = imageView4;
        this.help = imageView5;
        this.oneItem = includeMainActivityItemBinding2;
        this.subTitle = textView2;
        this.threeItem = includeMainActivityItemBinding3;
        this.topBg = view3;
        this.topTitle = imageView6;
        this.twoItem = includeMainActivityItemBinding4;
    }

    public static ItemMainActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMainActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMainActivityBinding bind(View view, Object obj) {
        return (ItemMainActivityBinding) ViewDataBinding.bind(obj, view, R.layout.item_main_activity);
    }

    @Deprecated
    public static ItemMainActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_main_activity, viewGroup, z, obj);
    }

    public static ItemMainActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMainActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_main_activity, (ViewGroup) null, false, obj);
    }
}
