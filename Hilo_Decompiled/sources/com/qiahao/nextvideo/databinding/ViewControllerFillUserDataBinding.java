package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerFillUserDataBinding extends ViewDataBinding {
    public final AppCompatButton birthdayEditButton;
    public final View birthdayEditButtonDivideView;
    public final AppCompatRadioButton boyRadioButton;
    public final FrameLayout container;
    public final View countryEditButtonDivideView;
    public final AppCompatTextView femaleTextView;
    public final LinearLayoutCompat genderTitleContainer;
    public final AppCompatRadioButton girlRadioButton;
    public final AppCompatTextView maleTextView;
    public final AppCompatEditText nameEditText;
    public final View nameEditTextDivideView;
    public final AppCompatButton nextButton;
    public final AppCompatTextView registerTipsTextView;
    public final AppCompatButton selectCountry;
    public final RadioGroup sexRadioGroup;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerFillUserDataBinding(Object obj, View view, int i, AppCompatButton appCompatButton, View view2, AppCompatRadioButton appCompatRadioButton, FrameLayout frameLayout, View view3, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, AppCompatRadioButton appCompatRadioButton2, AppCompatTextView appCompatTextView2, AppCompatEditText appCompatEditText, View view4, AppCompatButton appCompatButton2, AppCompatTextView appCompatTextView3, AppCompatButton appCompatButton3, RadioGroup radioGroup) {
        super(obj, view, i);
        this.birthdayEditButton = appCompatButton;
        this.birthdayEditButtonDivideView = view2;
        this.boyRadioButton = appCompatRadioButton;
        this.container = frameLayout;
        this.countryEditButtonDivideView = view3;
        this.femaleTextView = appCompatTextView;
        this.genderTitleContainer = linearLayoutCompat;
        this.girlRadioButton = appCompatRadioButton2;
        this.maleTextView = appCompatTextView2;
        this.nameEditText = appCompatEditText;
        this.nameEditTextDivideView = view4;
        this.nextButton = appCompatButton2;
        this.registerTipsTextView = appCompatTextView3;
        this.selectCountry = appCompatButton3;
        this.sexRadioGroup = radioGroup;
    }

    public static ViewControllerFillUserDataBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerFillUserDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerFillUserDataBinding bind(View view, Object obj) {
        return (ViewControllerFillUserDataBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_fill_user_data);
    }

    @Deprecated
    public static ViewControllerFillUserDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerFillUserDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_fill_user_data, viewGroup, z, obj);
    }

    public static ViewControllerFillUserDataBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerFillUserDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerFillUserDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_fill_user_data, (ViewGroup) null, false, obj);
    }
}
