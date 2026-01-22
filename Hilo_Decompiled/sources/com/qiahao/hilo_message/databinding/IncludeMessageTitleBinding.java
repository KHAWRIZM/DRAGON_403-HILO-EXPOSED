package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class IncludeMessageTitleBinding extends ViewDataBinding {
    public final HiloGradeView charmLevel;
    public final ConstraintLayout constraint;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final ImageView imgBeautyCode;
    public final ImageView ivNewUser;
    public final LinearLayout llMedal;
    public final TextView name;
    public final ImageView svip;
    public final LinearLayout topLinear;
    public final ImageView userTag;
    public final HiloGradeView wealthLevel;

    public IncludeMessageTitleBinding(Object obj, View view, int i10, HiloGradeView hiloGradeView, ConstraintLayout constraintLayout, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView, ImageView imageView5, LinearLayout linearLayout2, ImageView imageView6, HiloGradeView hiloGradeView2) {
        super(obj, view, i10);
        this.charmLevel = hiloGradeView;
        this.constraint = constraintLayout;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.imgBeautyCode = imageView3;
        this.ivNewUser = imageView4;
        this.llMedal = linearLayout;
        this.name = textView;
        this.svip = imageView5;
        this.topLinear = linearLayout2;
        this.userTag = imageView6;
        this.wealthLevel = hiloGradeView2;
    }

    public static IncludeMessageTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeMessageTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static IncludeMessageTitleBinding bind(View view, Object obj) {
        return (IncludeMessageTitleBinding) ViewDataBinding.bind(obj, view, R.layout.include_message_title);
    }

    @Deprecated
    public static IncludeMessageTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (IncludeMessageTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_message_title, viewGroup, z10, obj);
    }

    public static IncludeMessageTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeMessageTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMessageTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_message_title, null, false, obj);
    }
}
