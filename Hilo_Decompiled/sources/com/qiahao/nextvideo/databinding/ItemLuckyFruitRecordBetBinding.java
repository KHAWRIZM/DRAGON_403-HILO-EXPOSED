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
public abstract class ItemLuckyFruitRecordBetBinding extends ViewDataBinding {
    public final TextView diamond;
    public final ImageView imageFruit;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemLuckyFruitRecordBetBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.diamond = textView;
        this.imageFruit = imageView;
    }

    public static ItemLuckyFruitRecordBetBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemLuckyFruitRecordBetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemLuckyFruitRecordBetBinding bind(View view, Object obj) {
        return (ItemLuckyFruitRecordBetBinding) ViewDataBinding.bind(obj, view, R.layout.item_lucky_fruit_record_bet);
    }

    @Deprecated
    public static ItemLuckyFruitRecordBetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLuckyFruitRecordBetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lucky_fruit_record_bet, viewGroup, z, obj);
    }

    public static ItemLuckyFruitRecordBetBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemLuckyFruitRecordBetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLuckyFruitRecordBetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_lucky_fruit_record_bet, (ViewGroup) null, false, obj);
    }
}
