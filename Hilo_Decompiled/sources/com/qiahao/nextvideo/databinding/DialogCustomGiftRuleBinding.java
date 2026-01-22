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
public abstract class DialogCustomGiftRuleBinding extends ViewDataBinding {
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView suTitle1;
    public final TextView suTitle2;
    public final TextView suTitle3;
    public final TextView title;
    public final TextView title1;
    public final TextView title2;
    public final TextView title3;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCustomGiftRuleBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.close = imageView;
        this.constraint = constraintLayout;
        this.suTitle1 = textView;
        this.suTitle2 = textView2;
        this.suTitle3 = textView3;
        this.title = textView4;
        this.title1 = textView5;
        this.title2 = textView6;
        this.title3 = textView7;
    }

    public static DialogCustomGiftRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCustomGiftRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCustomGiftRuleBinding bind(View view, Object obj) {
        return (DialogCustomGiftRuleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_custom_gift_rule);
    }

    @Deprecated
    public static DialogCustomGiftRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCustomGiftRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_custom_gift_rule, viewGroup, z, obj);
    }

    public static DialogCustomGiftRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCustomGiftRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCustomGiftRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_custom_gift_rule, (ViewGroup) null, false, obj);
    }
}
