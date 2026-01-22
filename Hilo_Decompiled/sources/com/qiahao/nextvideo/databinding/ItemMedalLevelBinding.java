package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMedalLevelBinding extends ViewDataBinding {
    public final ConstraintLayout clMedalArrow;
    public final ImageView imgMedalLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMedalLevelBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.clMedalArrow = constraintLayout;
        this.imgMedalLevel = imageView;
    }

    public static ItemMedalLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMedalLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMedalLevelBinding bind(View view, Object obj) {
        return (ItemMedalLevelBinding) ViewDataBinding.bind(obj, view, R.layout.item_medal_level);
    }

    @Deprecated
    public static ItemMedalLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMedalLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal_level, viewGroup, z, obj);
    }

    public static ItemMedalLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMedalLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMedalLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal_level, (ViewGroup) null, false, obj);
    }
}
