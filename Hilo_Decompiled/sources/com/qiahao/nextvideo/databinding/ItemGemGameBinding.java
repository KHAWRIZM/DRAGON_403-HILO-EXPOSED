package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGemGameBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;
    public final View topView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGemGameBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, View view2) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
        this.topView = view2;
    }

    public static ItemGemGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGemGameBinding bind(View view, Object obj) {
        return (ItemGemGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_gem_game);
    }

    @Deprecated
    public static ItemGemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_game, viewGroup, z, obj);
    }

    public static ItemGemGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGemGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_game, (ViewGroup) null, false, obj);
    }
}
