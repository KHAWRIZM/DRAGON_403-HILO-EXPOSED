package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemAllMedalBinding extends ViewDataBinding {
    public final LinearLayout content;
    public final ImageView medalImg;
    public final TextView medalTypeName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAllMedalBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.content = linearLayout;
        this.medalImg = imageView;
        this.medalTypeName = textView;
    }

    public static ItemAllMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAllMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAllMedalBinding bind(View view, Object obj) {
        return (ItemAllMedalBinding) ViewDataBinding.bind(obj, view, R.layout.item_all_medal);
    }

    @Deprecated
    public static ItemAllMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAllMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_all_medal, viewGroup, z, obj);
    }

    public static ItemAllMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAllMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAllMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_all_medal, (ViewGroup) null, false, obj);
    }
}
