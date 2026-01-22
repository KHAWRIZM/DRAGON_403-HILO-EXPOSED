package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerRegionPreferenceBinding extends ViewDataBinding {
    public final AppCompatButton confirmButton;
    public final AppCompatCheckBox currentCountryCheckBox;
    public final AppCompatImageView currentCountryImageView;
    public final LinearLayoutCompat currentCountryLinearLayout;
    public final AppCompatTextView descriptionText;
    public final AppCompatCheckBox globalCheckBox;
    public final AppCompatImageView globalImageView;
    public final LinearLayoutCompat globalLinearLayout;
    public final AppCompatTextView regionPreferenceFeeTextView;
    public final AppCompatTextView userOfCurrentTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerRegionPreferenceBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatCheckBox appCompatCheckBox, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatCheckBox appCompatCheckBox2, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.confirmButton = appCompatButton;
        this.currentCountryCheckBox = appCompatCheckBox;
        this.currentCountryImageView = appCompatImageView;
        this.currentCountryLinearLayout = linearLayoutCompat;
        this.descriptionText = appCompatTextView;
        this.globalCheckBox = appCompatCheckBox2;
        this.globalImageView = appCompatImageView2;
        this.globalLinearLayout = linearLayoutCompat2;
        this.regionPreferenceFeeTextView = appCompatTextView2;
        this.userOfCurrentTextView = appCompatTextView3;
    }

    public static ViewControllerRegionPreferenceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerRegionPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerRegionPreferenceBinding bind(View view, Object obj) {
        return (ViewControllerRegionPreferenceBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_region_preference);
    }

    @Deprecated
    public static ViewControllerRegionPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerRegionPreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_region_preference, viewGroup, z, obj);
    }

    public static ViewControllerRegionPreferenceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerRegionPreferenceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerRegionPreferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_region_preference, (ViewGroup) null, false, obj);
    }
}
