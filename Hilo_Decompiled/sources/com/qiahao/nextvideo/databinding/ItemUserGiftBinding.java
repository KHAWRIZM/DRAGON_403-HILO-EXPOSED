package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemUserGiftBinding extends ViewDataBinding {
    public final TextView giftNum;
    public final AppCompatImageView image;
    public final ConstraintLayout rootContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemUserGiftBinding(Object obj, View view, int i, TextView textView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.giftNum = textView;
        this.image = appCompatImageView;
        this.rootContainer = constraintLayout;
    }

    public static ItemUserGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemUserGiftBinding bind(View view, Object obj) {
        return (ItemUserGiftBinding) ViewDataBinding.bind(obj, view, R.layout.item_user_gift);
    }

    @Deprecated
    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_gift, viewGroup, z, obj);
    }

    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_gift, (ViewGroup) null, false, obj);
    }
}
