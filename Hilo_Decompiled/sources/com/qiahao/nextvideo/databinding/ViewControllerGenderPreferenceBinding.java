package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerGenderPreferenceBinding extends ViewDataBinding {
    public final AppCompatRadioButton bothRadioButton;
    public final AppCompatButton confirmButton;
    public final AppCompatTextView descriptionText;
    public final AppCompatTextView femalePriceTextView;
    public final AppCompatRadioButton femaleRadioButton;
    public final RadioGroup genderPreferenceRadioGroup;
    public final AppCompatTextView malePriceTextView;
    public final AppCompatRadioButton maleRadioButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerGenderPreferenceBinding(Object obj, View view, int i, AppCompatRadioButton appCompatRadioButton, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatRadioButton appCompatRadioButton2, RadioGroup radioGroup, AppCompatTextView appCompatTextView3, AppCompatRadioButton appCompatRadioButton3) {
        super(obj, view, i);
        this.bothRadioButton = appCompatRadioButton;
        this.confirmButton = appCompatButton;
        this.descriptionText = appCompatTextView;
        this.femalePriceTextView = appCompatTextView2;
        this.femaleRadioButton = appCompatRadioButton2;
        this.genderPreferenceRadioGroup = radioGroup;
        this.malePriceTextView = appCompatTextView3;
        this.maleRadioButton = appCompatRadioButton3;
    }

    public static ViewControllerGenderPreferenceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerGenderPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerGenderPreferenceBinding bind(View view, Object obj) {
        return (ViewControllerGenderPreferenceBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_gender_preference);
    }

    @Deprecated
    public static ViewControllerGenderPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerGenderPreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_gender_preference, viewGroup, z, obj);
    }

    public static ViewControllerGenderPreferenceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerGenderPreferenceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerGenderPreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_gender_preference, (ViewGroup) null, false, obj);
    }
}
