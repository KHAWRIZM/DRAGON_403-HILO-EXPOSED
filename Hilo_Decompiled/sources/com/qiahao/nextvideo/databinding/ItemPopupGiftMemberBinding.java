package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPopupGiftMemberBinding extends ViewDataBinding {
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPopupGiftMemberBinding(Object obj, View view, int i, CircleImageView circleImageView, TextView textView) {
        super(obj, view, i);
        this.userAvatarCimageView = circleImageView;
        this.userName = textView;
    }

    public static ItemPopupGiftMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPopupGiftMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPopupGiftMemberBinding bind(View view, Object obj) {
        return (ItemPopupGiftMemberBinding) ViewDataBinding.bind(obj, view, R.layout.item_popup_gift_member);
    }

    @Deprecated
    public static ItemPopupGiftMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPopupGiftMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_popup_gift_member, viewGroup, z, obj);
    }

    public static ItemPopupGiftMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPopupGiftMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPopupGiftMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_popup_gift_member, (ViewGroup) null, false, obj);
    }
}
