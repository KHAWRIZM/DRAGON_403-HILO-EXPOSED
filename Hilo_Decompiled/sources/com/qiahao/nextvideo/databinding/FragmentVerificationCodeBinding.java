package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentVerificationCodeBinding extends ViewDataBinding {
    public final Button confirmButton;
    public final QMUIRadiusImageView2 countryIcon;
    public final TextView countryPhone;
    public final View line;
    public final AppCompatEditText password;
    public final ConstraintLayout passwordLayout;
    public final AppCompatEditText phoneNumber;
    public final LinearLayout selectCountryLayout;
    public final TextView sendButton;
    public final TextView tip;
    public final IncludeTitleBinding titleBar;
    public final AppCompatEditText verificationCode;
    public final ImageView viewPassword;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentVerificationCodeBinding(Object obj, View view, int i, Button button, QMUIRadiusImageView2 qMUIRadiusImageView2, TextView textView, View view2, AppCompatEditText appCompatEditText, ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText2, LinearLayout linearLayout, TextView textView2, TextView textView3, IncludeTitleBinding includeTitleBinding, AppCompatEditText appCompatEditText3, ImageView imageView) {
        super(obj, view, i);
        this.confirmButton = button;
        this.countryIcon = qMUIRadiusImageView2;
        this.countryPhone = textView;
        this.line = view2;
        this.password = appCompatEditText;
        this.passwordLayout = constraintLayout;
        this.phoneNumber = appCompatEditText2;
        this.selectCountryLayout = linearLayout;
        this.sendButton = textView2;
        this.tip = textView3;
        this.titleBar = includeTitleBinding;
        this.verificationCode = appCompatEditText3;
        this.viewPassword = imageView;
    }

    public static FragmentVerificationCodeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentVerificationCodeBinding bind(View view, Object obj) {
        return (FragmentVerificationCodeBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_verification_code);
    }

    @Deprecated
    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentVerificationCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verification_code, viewGroup, z, obj);
    }

    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentVerificationCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verification_code, (ViewGroup) null, false, obj);
    }
}
