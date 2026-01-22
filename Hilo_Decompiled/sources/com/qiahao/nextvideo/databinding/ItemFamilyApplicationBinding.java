package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyApplicationBinding extends ViewDataBinding {
    public final TextView agree;
    public final TextView agreed;
    public final Group agreedGroup;
    public final Group applyGroup;
    public final ConstraintLayout constraintLayout;
    public final View line;
    public final AppCompatTextView memberType;
    public final TextView refuse;
    public final TextView time;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyApplicationBinding(Object obj, View view, int i, TextView textView, TextView textView2, Group group, Group group2, ConstraintLayout constraintLayout, View view2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, QMUIRadiusImageView qMUIRadiusImageView, TextView textView5) {
        super(obj, view, i);
        this.agree = textView;
        this.agreed = textView2;
        this.agreedGroup = group;
        this.applyGroup = group2;
        this.constraintLayout = constraintLayout;
        this.line = view2;
        this.memberType = appCompatTextView;
        this.refuse = textView3;
        this.time = textView4;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.userName = textView5;
    }

    public static ItemFamilyApplicationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyApplicationBinding bind(View view, Object obj) {
        return (ItemFamilyApplicationBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_application);
    }

    @Deprecated
    public static ItemFamilyApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_application, viewGroup, z, obj);
    }

    public static ItemFamilyApplicationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyApplicationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_application, (ViewGroup) null, false, obj);
    }
}
