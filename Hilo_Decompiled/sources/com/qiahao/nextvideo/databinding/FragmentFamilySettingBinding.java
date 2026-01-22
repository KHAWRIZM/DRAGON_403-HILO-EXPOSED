package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFamilySettingBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final PolygonImageView avatar;
    public final AppCompatImageView backImageView;
    public final TextView declare;
    public final ImageView declareArrow;
    public final ConstraintLayout declareLayout;
    public final TextView delete;
    public final TextView familyName;
    public final ConstraintLayout familyNameLayout;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final AppCompatImageView imge;
    public final ImageView namePlateArrow;
    public final ConstraintLayout namePlateLayout;
    public final FrameLayout profileLayout;
    public final TextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFamilySettingBinding(Object obj, View view, int i, ImageView imageView, PolygonImageView polygonImageView, AppCompatImageView appCompatImageView, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, AppCompatImageView appCompatImageView2, ImageView imageView3, ConstraintLayout constraintLayout3, FrameLayout frameLayout, TextView textView4, Toolbar toolbar) {
        super(obj, view, i);
        this.arrow = imageView;
        this.avatar = polygonImageView;
        this.backImageView = appCompatImageView;
        this.declare = textView;
        this.declareArrow = imageView2;
        this.declareLayout = constraintLayout;
        this.delete = textView2;
        this.familyName = textView3;
        this.familyNameLayout = constraintLayout2;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.imge = appCompatImageView2;
        this.namePlateArrow = imageView3;
        this.namePlateLayout = constraintLayout3;
        this.profileLayout = frameLayout;
        this.title = textView4;
        this.toolbar = toolbar;
    }

    public static FragmentFamilySettingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFamilySettingBinding bind(View view, Object obj) {
        return (FragmentFamilySettingBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_family_setting);
    }

    @Deprecated
    public static FragmentFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_setting, viewGroup, z, obj);
    }

    public static FragmentFamilySettingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFamilySettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_setting, (ViewGroup) null, false, obj);
    }
}
