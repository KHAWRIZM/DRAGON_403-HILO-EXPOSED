package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyShareBinding extends ViewDataBinding {

    /* renamed from: id, reason: collision with root package name */
    public final ShineTextView f٥٩id;
    public final View line;
    public final ImageView select;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyShareBinding(Object obj, View view, int i, ShineTextView shineTextView, View view2, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, TextView textView) {
        super(obj, view, i);
        this.f٥٩id = shineTextView;
        this.line = view2;
        this.select = imageView;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.userName = textView;
    }

    public static ItemFamilyShareBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyShareBinding bind(View view, Object obj) {
        return (ItemFamilyShareBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_share);
    }

    @Deprecated
    public static ItemFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_share, viewGroup, z, obj);
    }

    public static ItemFamilyShareBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_share, (ViewGroup) null, false, obj);
    }
}
