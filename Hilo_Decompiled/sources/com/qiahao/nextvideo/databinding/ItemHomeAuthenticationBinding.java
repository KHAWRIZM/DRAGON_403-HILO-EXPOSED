package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemHomeAuthenticationBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraint;
    public final View line;
    public final QMUIRadiusImageView myAvatar;
    public final TextView newText;
    public final TextView nick;
    public final TextView online;
    public final ImageView supperBtn;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHomeAuthenticationBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, View view2, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView, TextView textView2, TextView textView3, ImageView imageView) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.avatar = qMUIRadiusImageView;
        this.constraint = constraintLayout;
        this.line = view2;
        this.myAvatar = qMUIRadiusImageView2;
        this.newText = textView;
        this.nick = textView2;
        this.online = textView3;
        this.supperBtn = imageView;
    }

    public static ItemHomeAuthenticationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemHomeAuthenticationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemHomeAuthenticationBinding bind(View view, Object obj) {
        return (ItemHomeAuthenticationBinding) ViewDataBinding.bind(obj, view, R.layout.item_home_authentication);
    }

    @Deprecated
    public static ItemHomeAuthenticationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHomeAuthenticationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_authentication, viewGroup, z, obj);
    }

    public static ItemHomeAuthenticationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemHomeAuthenticationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHomeAuthenticationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_authentication, (ViewGroup) null, false, obj);
    }
}
