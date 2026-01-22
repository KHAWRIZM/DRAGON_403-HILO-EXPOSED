package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemLuckyWheelSelectBinding extends ViewDataBinding {
    public final ConstraintLayout bgContent;
    public final TextView diamond;
    public final ImageView selectIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemLuckyWheelSelectBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.bgContent = constraintLayout;
        this.diamond = textView;
        this.selectIcon = imageView;
    }

    public static ItemLuckyWheelSelectBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemLuckyWheelSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemLuckyWheelSelectBinding bind(View view, Object obj) {
        return (ItemLuckyWheelSelectBinding) ViewDataBinding.bind(obj, view, R.layout.item_lucky_wheel_select);
    }

    @Deprecated
    public static ItemLuckyWheelSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLuckyWheelSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lucky_wheel_select, viewGroup, z, obj);
    }

    public static ItemLuckyWheelSelectBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemLuckyWheelSelectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLuckyWheelSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lucky_wheel_select, (ViewGroup) null, false, obj);
    }
}
