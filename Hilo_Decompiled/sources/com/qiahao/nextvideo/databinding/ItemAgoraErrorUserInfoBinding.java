package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemAgoraErrorUserInfoBinding extends ViewDataBinding {
    public final ImageView iconVip;
    public final CircleImageView userAvatarCimageView;
    public final TextView userId;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAgoraErrorUserInfoBinding(Object obj, View view, int i, ImageView imageView, CircleImageView circleImageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.iconVip = imageView;
        this.userAvatarCimageView = circleImageView;
        this.userId = textView;
        this.userName = textView2;
    }

    public static ItemAgoraErrorUserInfoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAgoraErrorUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAgoraErrorUserInfoBinding bind(View view, Object obj) {
        return (ItemAgoraErrorUserInfoBinding) ViewDataBinding.bind(obj, view, R.layout.item_agora_error_user_info);
    }

    @Deprecated
    public static ItemAgoraErrorUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAgoraErrorUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_agora_error_user_info, viewGroup, z, obj);
    }

    public static ItemAgoraErrorUserInfoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAgoraErrorUserInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAgoraErrorUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_agora_error_user_info, (ViewGroup) null, false, obj);
    }
}
