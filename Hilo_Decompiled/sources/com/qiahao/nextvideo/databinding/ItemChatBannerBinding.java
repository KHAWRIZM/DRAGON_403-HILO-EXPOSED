package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.chat.MessageBannerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatBannerBinding extends ViewDataBinding {
    public final MessageBannerView messageBanner;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatBannerBinding(Object obj, View view, int i, MessageBannerView messageBannerView) {
        super(obj, view, i);
        this.messageBanner = messageBannerView;
    }

    public static ItemChatBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatBannerBinding bind(View view, Object obj) {
        return (ItemChatBannerBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_banner);
    }

    @Deprecated
    public static ItemChatBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_banner, viewGroup, z, obj);
    }

    public static ItemChatBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_banner, (ViewGroup) null, false, obj);
    }
}
