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
public abstract class DialogLuckyFruitRuleBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final TextView tip1;
    public final TextView tip2;
    public final TextView tip3;
    public final TextView tip4;
    public final TextView tip5;
    public final TextView title;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyFruitRuleBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.luckyBoxContent = constraintLayout;
        this.tip1 = textView;
        this.tip2 = textView2;
        this.tip3 = textView3;
        this.tip4 = textView4;
        this.tip5 = textView5;
        this.title = textView6;
        this.topLineView = view2;
    }

    public static DialogLuckyFruitRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyFruitRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyFruitRuleBinding bind(View view, Object obj) {
        return (DialogLuckyFruitRuleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_fruit_rule);
    }

    @Deprecated
    public static DialogLuckyFruitRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyFruitRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_rule, viewGroup, z, obj);
    }

    public static DialogLuckyFruitRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyFruitRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyFruitRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_rule, (ViewGroup) null, false, obj);
    }
}
