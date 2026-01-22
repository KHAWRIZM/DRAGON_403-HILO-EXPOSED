package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeNumberDiceBinding extends ViewDataBinding {
    public final View diceButton;
    public final TextView textDice;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeNumberDiceBinding(Object obj, View view, int i, View view2, TextView textView) {
        super(obj, view, i);
        this.diceButton = view2;
        this.textDice = textView;
    }

    public static IncludeNumberDiceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeNumberDiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeNumberDiceBinding bind(View view, Object obj) {
        return (IncludeNumberDiceBinding) ViewDataBinding.bind(obj, view, R.layout.include_number_dice);
    }

    @Deprecated
    public static IncludeNumberDiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeNumberDiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_number_dice, viewGroup, z, obj);
    }

    public static IncludeNumberDiceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeNumberDiceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeNumberDiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_number_dice, (ViewGroup) null, false, obj);
    }
}
