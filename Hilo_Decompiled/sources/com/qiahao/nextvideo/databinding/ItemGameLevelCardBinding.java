package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qiahao.nextvideo.ui.svip.TriangleView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGameLevelCardBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ConstraintLayout constraint;
    public final TextView date;
    public final TextView defaultText;
    public final Group group;
    public final ImageView medalImg;
    public final TextView name;
    public final TextView number;
    public final CustomProgressView progress;
    public final TextView subTitle;
    public final TextView text;
    public final ConstraintLayout tipLayout;
    public final TriangleView triangle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameLevelCardBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, Group group, ImageView imageView2, TextView textView3, TextView textView4, CustomProgressView customProgressView, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2, TriangleView triangleView) {
        super(obj, view, i);
        this.bg = imageView;
        this.constraint = constraintLayout;
        this.date = textView;
        this.defaultText = textView2;
        this.group = group;
        this.medalImg = imageView2;
        this.name = textView3;
        this.number = textView4;
        this.progress = customProgressView;
        this.subTitle = textView5;
        this.text = textView6;
        this.tipLayout = constraintLayout2;
        this.triangle = triangleView;
    }

    public static ItemGameLevelCardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameLevelCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameLevelCardBinding bind(View view, Object obj) {
        return (ItemGameLevelCardBinding) ViewDataBinding.bind(obj, view, R.layout.item_game_level_card);
    }

    @Deprecated
    public static ItemGameLevelCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameLevelCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_level_card, viewGroup, z, obj);
    }

    public static ItemGameLevelCardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameLevelCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameLevelCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_level_card, (ViewGroup) null, false, obj);
    }
}
