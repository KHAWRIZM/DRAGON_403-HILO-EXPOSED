package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemVipCardBinding extends ViewDataBinding {
    public final ImageView cardImage;
    public final FrameLayout imageLayout;
    public final TextView subTitle;
    public final TextView time;
    public final TextView title;
    public final ImageView vipImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemVipCardBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView2) {
        super(obj, view, i);
        this.cardImage = imageView;
        this.imageLayout = frameLayout;
        this.subTitle = textView;
        this.time = textView2;
        this.title = textView3;
        this.vipImage = imageView2;
    }

    public static ItemVipCardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemVipCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemVipCardBinding bind(View view, Object obj) {
        return (ItemVipCardBinding) ViewDataBinding.bind(obj, view, R.layout.item_vip_card);
    }

    @Deprecated
    public static ItemVipCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVipCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_vip_card, viewGroup, z, obj);
    }

    public static ItemVipCardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemVipCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVipCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_vip_card, (ViewGroup) null, false, obj);
    }
}
