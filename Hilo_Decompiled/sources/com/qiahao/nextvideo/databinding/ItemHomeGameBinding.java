package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemHomeGameBinding extends ViewDataBinding {
    public final ImageView img;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHomeGameBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.img = imageView;
    }

    public static ItemHomeGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemHomeGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemHomeGameBinding bind(View view, Object obj) {
        return (ItemHomeGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_home_game);
    }

    @Deprecated
    public static ItemHomeGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHomeGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_game, viewGroup, z, obj);
    }

    public static ItemHomeGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemHomeGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHomeGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_game, (ViewGroup) null, false, obj);
    }
}
