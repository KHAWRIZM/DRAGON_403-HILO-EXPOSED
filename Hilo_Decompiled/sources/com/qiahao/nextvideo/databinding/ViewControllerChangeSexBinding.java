package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerChangeSexBinding extends ViewDataBinding {
    public final AppCompatRadioButton boyRadioButton;
    public final AppCompatButton confirmButton;
    public final CardView contentBg;
    public final AppCompatTextView descriptionText;
    public final AppCompatRadioButton girlRadioButton;
    public final RadioGroup sexRadioGroup;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerChangeSexBinding(Object obj, View view, int i, AppCompatRadioButton appCompatRadioButton, AppCompatButton appCompatButton, CardView cardView, AppCompatTextView appCompatTextView, AppCompatRadioButton appCompatRadioButton2, RadioGroup radioGroup) {
        super(obj, view, i);
        this.boyRadioButton = appCompatRadioButton;
        this.confirmButton = appCompatButton;
        this.contentBg = cardView;
        this.descriptionText = appCompatTextView;
        this.girlRadioButton = appCompatRadioButton2;
        this.sexRadioGroup = radioGroup;
    }

    public static ViewControllerChangeSexBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerChangeSexBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerChangeSexBinding bind(View view, Object obj) {
        return (ViewControllerChangeSexBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_change_sex);
    }

    @Deprecated
    public static ViewControllerChangeSexBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerChangeSexBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_change_sex, viewGroup, z, obj);
    }

    public static ViewControllerChangeSexBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerChangeSexBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerChangeSexBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_change_sex, (ViewGroup) null, false, obj);
    }
}
