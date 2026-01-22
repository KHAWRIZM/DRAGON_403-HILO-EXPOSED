package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemAristocracyBagBinding extends ViewDataBinding {
    public final QMUIRadiusImageView cardImage;
    public final ConstraintLayout dayLayout;
    public final TextView dayNumber;
    public final TextView dayText;
    public final ConstraintLayout exclusiveLayout;
    public final TextView exclusiveNumber;
    public final TextView exclusiveText;
    public final TextView number;
    public final ImageView selectBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAristocracyBagBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView) {
        super(obj, view, i);
        this.cardImage = qMUIRadiusImageView;
        this.dayLayout = constraintLayout;
        this.dayNumber = textView;
        this.dayText = textView2;
        this.exclusiveLayout = constraintLayout2;
        this.exclusiveNumber = textView3;
        this.exclusiveText = textView4;
        this.number = textView5;
        this.selectBg = imageView;
    }

    public static ItemAristocracyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAristocracyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAristocracyBagBinding bind(View view, Object obj) {
        return (ItemAristocracyBagBinding) ViewDataBinding.bind(obj, view, R.layout.item_aristocracy_bag);
    }

    @Deprecated
    public static ItemAristocracyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAristocracyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_aristocracy_bag, viewGroup, z, obj);
    }

    public static ItemAristocracyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAristocracyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAristocracyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_aristocracy_bag, (ViewGroup) null, false, obj);
    }
}
