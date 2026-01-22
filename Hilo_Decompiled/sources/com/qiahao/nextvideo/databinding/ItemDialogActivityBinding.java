package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemDialogActivityBinding extends ViewDataBinding {
    public final QMUIRadiusImageView2 centerImage;
    public final AppCompatTextView incomeContent;
    public final ImageView incomeImage;
    public final LinearLayout incomeLayout;
    public final AppCompatTextView peopleContent;
    public final ImageView peopleImage;
    public final LinearLayout peopleLayout;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final AppCompatTextView subscribeContent;
    public final ImageView subscribeImage;
    public final AppCompatTextView timeContent;
    public final ImageView timeImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDialogActivityBinding(Object obj, View view, int i, QMUIRadiusImageView2 qMUIRadiusImageView2, AppCompatTextView appCompatTextView, ImageView imageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView2, ImageView imageView2, LinearLayout linearLayout2, AppCompatTextView appCompatTextView3, ImageView imageView3, LinearLayout linearLayout3, AppCompatTextView appCompatTextView4, ImageView imageView4, AppCompatTextView appCompatTextView5, ImageView imageView5) {
        super(obj, view, i);
        this.centerImage = qMUIRadiusImageView2;
        this.incomeContent = appCompatTextView;
        this.incomeImage = imageView;
        this.incomeLayout = linearLayout;
        this.peopleContent = appCompatTextView2;
        this.peopleImage = imageView2;
        this.peopleLayout = linearLayout2;
        this.stateContent = appCompatTextView3;
        this.stateImage = imageView3;
        this.stateLayout = linearLayout3;
        this.subscribeContent = appCompatTextView4;
        this.subscribeImage = imageView4;
        this.timeContent = appCompatTextView5;
        this.timeImage = imageView5;
    }

    public static ItemDialogActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDialogActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDialogActivityBinding bind(View view, Object obj) {
        return (ItemDialogActivityBinding) ViewDataBinding.bind(obj, view, R.layout.item_dialog_activity);
    }

    @Deprecated
    public static ItemDialogActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDialogActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_dialog_activity, viewGroup, z, obj);
    }

    public static ItemDialogActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDialogActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDialogActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_dialog_activity, (ViewGroup) null, false, obj);
    }
}
