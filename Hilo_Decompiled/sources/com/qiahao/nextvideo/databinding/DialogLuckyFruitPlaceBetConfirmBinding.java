package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyFruitPlaceBetConfirmBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final AppCompatButton confirmReportButton;
    public final LinearLayout llSelect;
    public final CheckBox selectView;
    public final TextView tip;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyFruitPlaceBetConfirmBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, LinearLayout linearLayout, CheckBox checkBox, TextView textView) {
        super(obj, view, i);
        this.cancelButton = appCompatButton;
        this.confirmReportButton = appCompatButton2;
        this.llSelect = linearLayout;
        this.selectView = checkBox;
        this.tip = textView;
    }

    public static DialogLuckyFruitPlaceBetConfirmBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyFruitPlaceBetConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogLuckyFruitPlaceBetConfirmBinding bind(View view, Object obj) {
        return (DialogLuckyFruitPlaceBetConfirmBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_fruit_place_bet_confirm);
    }

    @Deprecated
    public static DialogLuckyFruitPlaceBetConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyFruitPlaceBetConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_place_bet_confirm, viewGroup, z, obj);
    }

    public static DialogLuckyFruitPlaceBetConfirmBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyFruitPlaceBetConfirmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyFruitPlaceBetConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_place_bet_confirm, (ViewGroup) null, false, obj);
    }
}
