package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyExitBinding extends ViewDataBinding {
    public final View line;
    public final TextView time;
    public final AppCompatTextView type;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final ShineTextView userId;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyExitBinding(Object obj, View view, int i, View view2, TextView textView, AppCompatTextView appCompatTextView, QMUIRadiusImageView qMUIRadiusImageView, ShineTextView shineTextView, TextView textView2) {
        super(obj, view, i);
        this.line = view2;
        this.time = textView;
        this.type = appCompatTextView;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.userId = shineTextView;
        this.userName = textView2;
    }

    public static ItemFamilyExitBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyExitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyExitBinding bind(View view, Object obj) {
        return (ItemFamilyExitBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_exit);
    }

    @Deprecated
    public static ItemFamilyExitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyExitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_exit, viewGroup, z, obj);
    }

    public static ItemFamilyExitBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyExitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyExitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_exit, (ViewGroup) null, false, obj);
    }
}
