package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGameListBinding extends ViewDataBinding {
    public final ImageView gameIcon;
    public final TextView gameName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameListBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.gameIcon = imageView;
        this.gameName = textView;
    }

    public static ItemGameListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameListBinding bind(View view, Object obj) {
        return (ItemGameListBinding) ViewDataBinding.bind(obj, view, R.layout.item_game_list);
    }

    @Deprecated
    public static ItemGameListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_list, viewGroup, z, obj);
    }

    public static ItemGameListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_list, (ViewGroup) null, false, obj);
    }
}
