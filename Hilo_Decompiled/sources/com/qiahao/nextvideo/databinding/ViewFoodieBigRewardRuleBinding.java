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
public abstract class ViewFoodieBigRewardRuleBinding extends ViewDataBinding {
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView iv4;
    public final ImageView ivCross;
    public final TextView tvRule;
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieBigRewardRuleBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.iv1 = imageView;
        this.iv2 = imageView2;
        this.iv3 = imageView3;
        this.iv4 = imageView4;
        this.ivCross = imageView5;
        this.tvRule = textView;
        this.tvTitle = textView2;
    }

    public static ViewFoodieBigRewardRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieBigRewardRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieBigRewardRuleBinding bind(View view, Object obj) {
        return (ViewFoodieBigRewardRuleBinding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_big_reward_rule);
    }

    @Deprecated
    public static ViewFoodieBigRewardRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieBigRewardRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_big_reward_rule, viewGroup, z, obj);
    }

    public static ViewFoodieBigRewardRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieBigRewardRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieBigRewardRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_big_reward_rule, (ViewGroup) null, false, obj);
    }
}
