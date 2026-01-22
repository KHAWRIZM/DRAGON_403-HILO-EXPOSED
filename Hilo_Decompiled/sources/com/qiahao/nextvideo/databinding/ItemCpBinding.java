package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCpBinding extends ViewDataBinding {
    public final HiloImageView avatar1;
    public final HiloImageView avatar2;
    public final LinearLayout llDiamond;
    public final ImageView medal;
    public final NickTextView nickName1;
    public final NickTextView nickName2;
    public final TextView position;
    public final ImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpBinding(Object obj, View view, int i, HiloImageView hiloImageView, HiloImageView hiloImageView2, LinearLayout linearLayout, ImageView imageView, NickTextView nickTextView, NickTextView nickTextView2, TextView textView, ImageView imageView2) {
        super(obj, view, i);
        this.avatar1 = hiloImageView;
        this.avatar2 = hiloImageView2;
        this.llDiamond = linearLayout;
        this.medal = imageView;
        this.nickName1 = nickTextView;
        this.nickName2 = nickTextView2;
        this.position = textView;
        this.svga = imageView2;
    }

    public static ItemCpBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpBinding bind(View view, Object obj) {
        return (ItemCpBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp);
    }

    @Deprecated
    public static ItemCpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp, viewGroup, z, obj);
    }

    public static ItemCpBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp, (ViewGroup) null, false, obj);
    }
}
