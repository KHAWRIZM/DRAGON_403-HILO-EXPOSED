package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemDiscoverBroadCastBinding extends ViewDataBinding {
    public final LinearLayout allContent;
    public final QMUIRadiusImageView avatar;
    public final LinearLayout backContent;
    public final TextView content;

    /* renamed from: top, reason: collision with root package name */
    public final ImageView f٥٨top;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDiscoverBroadCastBinding(Object obj, View view, int i, LinearLayout linearLayout, QMUIRadiusImageView qMUIRadiusImageView, LinearLayout linearLayout2, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.allContent = linearLayout;
        this.avatar = qMUIRadiusImageView;
        this.backContent = linearLayout2;
        this.content = textView;
        this.f٥٨top = imageView;
    }

    public static ItemDiscoverBroadCastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDiscoverBroadCastBinding bind(View view, Object obj) {
        return (ItemDiscoverBroadCastBinding) ViewDataBinding.bind(obj, view, R.layout.item_discover_broad_cast);
    }

    @Deprecated
    public static ItemDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiscoverBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_broad_cast, viewGroup, z, obj);
    }

    public static ItemDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiscoverBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_broad_cast, (ViewGroup) null, false, obj);
    }
}
