package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemDailyEarnDiamondTaskBinding extends ViewDataBinding {
    public final TextView diamondText;
    public final TextView earnTakeButton;
    public final ImageView image1;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDailyEarnDiamondTaskBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, TextView textView3) {
        super(obj, view, i);
        this.diamondText = textView;
        this.earnTakeButton = textView2;
        this.image1 = imageView;
        this.text1 = textView3;
    }

    public static ItemDailyEarnDiamondTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDailyEarnDiamondTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDailyEarnDiamondTaskBinding bind(View view, Object obj) {
        return (ItemDailyEarnDiamondTaskBinding) ViewDataBinding.bind(obj, view, R.layout.item_daily_earn_diamond_task);
    }

    @Deprecated
    public static ItemDailyEarnDiamondTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDailyEarnDiamondTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_daily_earn_diamond_task, viewGroup, z, obj);
    }

    public static ItemDailyEarnDiamondTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDailyEarnDiamondTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDailyEarnDiamondTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_daily_earn_diamond_task, (ViewGroup) null, false, obj);
    }
}
