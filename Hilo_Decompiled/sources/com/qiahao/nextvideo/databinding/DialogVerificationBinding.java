package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogVerificationBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;
    public final ImageView image1;
    public final ImageView image2;
    public final TextView recommend;
    public final View select1;
    public final View select2;
    public final ConstraintLayout smsLayout;
    public final TextView text1;
    public final TextView text2;
    public final TextView title;
    public final ConstraintLayout whatsLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogVerificationBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, ImageView imageView, ImageView imageView2, TextView textView3, View view2, View view3, ConstraintLayout constraintLayout, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
        this.image1 = imageView;
        this.image2 = imageView2;
        this.recommend = textView3;
        this.select1 = view2;
        this.select2 = view3;
        this.smsLayout = constraintLayout;
        this.text1 = textView4;
        this.text2 = textView5;
        this.title = textView6;
        this.whatsLayout = constraintLayout2;
    }

    public static DialogVerificationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogVerificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogVerificationBinding bind(View view, Object obj) {
        return (DialogVerificationBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_verification);
    }

    @Deprecated
    public static DialogVerificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogVerificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_verification, viewGroup, z, obj);
    }

    public static DialogVerificationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogVerificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogVerificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_verification, (ViewGroup) null, false, obj);
    }
}
