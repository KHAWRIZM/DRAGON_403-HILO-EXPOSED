package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemBaiShunGameBinding extends ViewDataBinding {
    public final ImageView img;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemBaiShunGameBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.img = imageView;
    }

    public static ItemBaiShunGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemBaiShunGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemBaiShunGameBinding bind(View view, Object obj) {
        return (ItemBaiShunGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_bai_shun_game);
    }

    @Deprecated
    public static ItemBaiShunGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBaiShunGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bai_shun_game, viewGroup, z, obj);
    }

    public static ItemBaiShunGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemBaiShunGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBaiShunGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bai_shun_game, (ViewGroup) null, false, obj);
    }
}
