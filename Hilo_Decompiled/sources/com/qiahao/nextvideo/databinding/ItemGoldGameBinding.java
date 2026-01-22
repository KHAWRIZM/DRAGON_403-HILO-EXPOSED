package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGoldGameBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final QMUIRadiusImageView2 image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGoldGameBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, QMUIRadiusImageView2 qMUIRadiusImageView2) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.image = qMUIRadiusImageView2;
    }

    public static ItemGoldGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGoldGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGoldGameBinding bind(View view, Object obj) {
        return (ItemGoldGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_gold_game);
    }

    @Deprecated
    public static ItemGoldGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoldGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gold_game, viewGroup, z, obj);
    }

    public static ItemGoldGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGoldGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoldGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gold_game, (ViewGroup) null, false, obj);
    }
}
