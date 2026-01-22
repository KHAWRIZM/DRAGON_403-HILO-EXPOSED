package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpCertificateBinding extends ViewDataBinding {
    public final ConstraintLayout backContent;
    public final TextView certificationTime;
    public final CircleImageView cpAvatar1;
    public final CircleImageView cpAvatar2;
    public final TextView cpNicke1;
    public final TextView cpNicke2;
    public final AppCompatTextView cpRankIndex;
    public final TextView cpValue;
    public final TextView createTime;
    public final LinearLayout llRank;
    public final TextView longTime;
    public final ImageView model;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpCertificateBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, CircleImageView circleImageView, CircleImageView circleImageView2, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView, TextView textView4, TextView textView5, LinearLayout linearLayout, TextView textView6, ImageView imageView) {
        super(obj, view, i);
        this.backContent = constraintLayout;
        this.certificationTime = textView;
        this.cpAvatar1 = circleImageView;
        this.cpAvatar2 = circleImageView2;
        this.cpNicke1 = textView2;
        this.cpNicke2 = textView3;
        this.cpRankIndex = appCompatTextView;
        this.cpValue = textView4;
        this.createTime = textView5;
        this.llRank = linearLayout;
        this.longTime = textView6;
        this.model = imageView;
    }

    public static DialogCpCertificateBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpCertificateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpCertificateBinding bind(View view, Object obj) {
        return (DialogCpCertificateBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_certificate);
    }

    @Deprecated
    public static DialogCpCertificateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpCertificateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_certificate, viewGroup, z, obj);
    }

    public static DialogCpCertificateBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpCertificateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpCertificateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_certificate, (ViewGroup) null, false, obj);
    }
}
