package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogChangeCountryBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final ImageView centerImage;
    public final ConstraintLayout centerLayout;
    public final Group changeGroup;
    public final TextView confirmButton;
    public final TextView content;
    public final ImageView newCountry;
    public final TextView newCountryName;
    public final ImageView oldCountry;
    public final TextView oldCountryName;
    public final TextView time;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogChangeCountryBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, Group group, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, ImageView imageView3, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.centerImage = imageView;
        this.centerLayout = constraintLayout;
        this.changeGroup = group;
        this.confirmButton = textView2;
        this.content = textView3;
        this.newCountry = imageView2;
        this.newCountryName = textView4;
        this.oldCountry = imageView3;
        this.oldCountryName = textView5;
        this.time = textView6;
        this.title = textView7;
    }

    public static DialogChangeCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogChangeCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogChangeCountryBinding bind(View view, Object obj) {
        return (DialogChangeCountryBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_change_country);
    }

    @Deprecated
    public static DialogChangeCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogChangeCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_change_country, viewGroup, z, obj);
    }

    public static DialogChangeCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogChangeCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogChangeCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_change_country, (ViewGroup) null, false, obj);
    }
}
