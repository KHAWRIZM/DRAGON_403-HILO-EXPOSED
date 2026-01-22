package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogNumberOfDiceBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final TextView confirmButton;
    public final IncludeNumberDiceBinding fiveDice;
    public final IncludeNumberDiceBinding fourDice;
    public final View line;
    public final IncludeNumberDiceBinding oneDice;
    public final IncludeNumberDiceBinding oneNiceDice;
    public final IncludeNumberDiceBinding oneSixDice;
    public final LinearLayout radioGroup;
    public final IncludeNumberDiceBinding threeDice;
    public final TextView title;
    public final IncludeNumberDiceBinding twoDice;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogNumberOfDiceBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, IncludeNumberDiceBinding includeNumberDiceBinding, IncludeNumberDiceBinding includeNumberDiceBinding2, View view2, IncludeNumberDiceBinding includeNumberDiceBinding3, IncludeNumberDiceBinding includeNumberDiceBinding4, IncludeNumberDiceBinding includeNumberDiceBinding5, LinearLayout linearLayout2, IncludeNumberDiceBinding includeNumberDiceBinding6, TextView textView3, IncludeNumberDiceBinding includeNumberDiceBinding7) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.confirmButton = textView2;
        this.fiveDice = includeNumberDiceBinding;
        this.fourDice = includeNumberDiceBinding2;
        this.line = view2;
        this.oneDice = includeNumberDiceBinding3;
        this.oneNiceDice = includeNumberDiceBinding4;
        this.oneSixDice = includeNumberDiceBinding5;
        this.radioGroup = linearLayout2;
        this.threeDice = includeNumberDiceBinding6;
        this.title = textView3;
        this.twoDice = includeNumberDiceBinding7;
    }

    public static DialogNumberOfDiceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogNumberOfDiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogNumberOfDiceBinding bind(View view, Object obj) {
        return (DialogNumberOfDiceBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_number_of_dice);
    }

    @Deprecated
    public static DialogNumberOfDiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogNumberOfDiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_of_dice, viewGroup, z, obj);
    }

    public static DialogNumberOfDiceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogNumberOfDiceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogNumberOfDiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_of_dice, (ViewGroup) null, false, obj);
    }
}
