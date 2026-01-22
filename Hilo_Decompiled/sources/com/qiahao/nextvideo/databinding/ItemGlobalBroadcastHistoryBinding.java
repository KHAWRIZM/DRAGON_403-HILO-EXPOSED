package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGlobalBroadcastHistoryBinding extends ViewDataBinding {
    public final ConstraintLayout bgContent;
    public final TextView broadCastText;
    public final LinearLayoutCompat buttonLayout;
    public final ImageView countryImage;
    public final TextView createTime;
    public final ImageView iconNoble;
    public final ImageView iconVip1;
    public final ImageView sex;

    /* renamed from: top, reason: collision with root package name */
    public final ImageView f٦٢top;
    public final CircleImageView userAvatar;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGlobalBroadcastHistoryBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, LinearLayoutCompat linearLayoutCompat, ImageView imageView, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, CircleImageView circleImageView, TextView textView3) {
        super(obj, view, i);
        this.bgContent = constraintLayout;
        this.broadCastText = textView;
        this.buttonLayout = linearLayoutCompat;
        this.countryImage = imageView;
        this.createTime = textView2;
        this.iconNoble = imageView2;
        this.iconVip1 = imageView3;
        this.sex = imageView4;
        this.f٦٢top = imageView5;
        this.userAvatar = circleImageView;
        this.userName = textView3;
    }

    public static ItemGlobalBroadcastHistoryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGlobalBroadcastHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGlobalBroadcastHistoryBinding bind(View view, Object obj) {
        return (ItemGlobalBroadcastHistoryBinding) ViewDataBinding.bind(obj, view, R.layout.item_global_broadcast_history);
    }

    @Deprecated
    public static ItemGlobalBroadcastHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGlobalBroadcastHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_global_broadcast_history, viewGroup, z, obj);
    }

    public static ItemGlobalBroadcastHistoryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGlobalBroadcastHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGlobalBroadcastHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_global_broadcast_history, (ViewGroup) null, false, obj);
    }
}
