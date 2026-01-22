package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGemBinding extends ViewDataBinding {
    public final ImageView gemIcon;
    public final AppCompatTextView number;
    public final TextView rechargeText;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGemBinding(Object obj, View view, int i, ImageView imageView, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.gemIcon = imageView;
        this.number = appCompatTextView;
        this.rechargeText = textView;
        this.title = appCompatTextView2;
    }

    public static ItemGemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGemBinding bind(View view, Object obj) {
        return (ItemGemBinding) ViewDataBinding.bind(obj, view, R.layout.item_gem);
    }

    @Deprecated
    public static ItemGemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem, viewGroup, z, obj);
    }

    public static ItemGemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem, (ViewGroup) null, false, obj);
    }
}
