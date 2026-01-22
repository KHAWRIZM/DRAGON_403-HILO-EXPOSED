package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGiftRecordBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView giftImg;
    public final View line;
    public final TextView name;
    public final TextView number;
    public final TextView time;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGiftRecordBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, View view2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.giftImg = imageView;
        this.line = view2;
        this.name = textView;
        this.number = textView2;
        this.time = textView3;
    }

    public static ItemGiftRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGiftRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGiftRecordBinding bind(View view, Object obj) {
        return (ItemGiftRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_gift_record);
    }

    @Deprecated
    public static ItemGiftRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGiftRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gift_record, viewGroup, z, obj);
    }

    public static ItemGiftRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGiftRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGiftRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gift_record, (ViewGroup) null, false, obj);
    }
}
