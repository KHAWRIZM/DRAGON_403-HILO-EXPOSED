package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCpMemorialItemBinding extends ViewDataBinding {
    public final ImageView addImage;
    public final TextView day;
    public final ConstraintLayout rootLayout;
    public final TextView time;
    public final LinearLayout timeLayout;
    public final TextView timeNumber;
    public final TextView timeTitle;
    public final TextView title;
    public final TextView today;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpMemorialItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.addImage = imageView;
        this.day = textView;
        this.rootLayout = constraintLayout;
        this.time = textView2;
        this.timeLayout = linearLayout;
        this.timeNumber = textView3;
        this.timeTitle = textView4;
        this.title = textView5;
        this.today = textView6;
    }

    public static ItemCpMemorialItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpMemorialItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpMemorialItemBinding bind(View view, Object obj) {
        return (ItemCpMemorialItemBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_memorial_item);
    }

    @Deprecated
    public static ItemCpMemorialItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpMemorialItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_memorial_item, viewGroup, z, obj);
    }

    public static ItemCpMemorialItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpMemorialItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpMemorialItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_memorial_item, (ViewGroup) null, false, obj);
    }
}
