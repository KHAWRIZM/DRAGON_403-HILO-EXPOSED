package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.TriangleView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCreate1v1PkBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final ImageView bg;
    public final QMUIRadiusImageView blueAvatar;
    public final ImageView blueDefault;
    public final ImageView blueHead;
    public final TextView blueNick;
    public final ImageView blueSelect;
    public final ImageView close;
    public final ImageView helper;
    public final View memberBg;
    public final RecyclerView recyclerView;
    public final QMUIRadiusImageView redAvatar;
    public final ImageView redDefault;
    public final ImageView redHead;
    public final TextView redNick;
    public final ImageView redSelect;
    public final TextView selectTime;
    public final TextView selectTitle;
    public final View startBg;
    public final TextView startPk;
    public final ImageView tick;
    public final TextView time;
    public final View timeBg;
    public final ImageView topImage;
    public final View topView;
    public final TriangleView triangle;
    public final ImageView vs;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreate1v1PkBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView3, ImageView imageView4, TextView textView, ImageView imageView5, ImageView imageView6, ImageView imageView7, View view2, RecyclerView recyclerView, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView8, ImageView imageView9, TextView textView2, ImageView imageView10, TextView textView3, TextView textView4, View view3, TextView textView5, ImageView imageView11, TextView textView6, View view4, ImageView imageView12, View view5, TriangleView triangleView, ImageView imageView13) {
        super(obj, view, i);
        this.arrow = imageView;
        this.bg = imageView2;
        this.blueAvatar = qMUIRadiusImageView;
        this.blueDefault = imageView3;
        this.blueHead = imageView4;
        this.blueNick = textView;
        this.blueSelect = imageView5;
        this.close = imageView6;
        this.helper = imageView7;
        this.memberBg = view2;
        this.recyclerView = recyclerView;
        this.redAvatar = qMUIRadiusImageView2;
        this.redDefault = imageView8;
        this.redHead = imageView9;
        this.redNick = textView2;
        this.redSelect = imageView10;
        this.selectTime = textView3;
        this.selectTitle = textView4;
        this.startBg = view3;
        this.startPk = textView5;
        this.tick = imageView11;
        this.time = textView6;
        this.timeBg = view4;
        this.topImage = imageView12;
        this.topView = view5;
        this.triangle = triangleView;
        this.vs = imageView13;
    }

    public static DialogCreate1v1PkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreate1v1PkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCreate1v1PkBinding bind(View view, Object obj) {
        return (DialogCreate1v1PkBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_1v1_pk);
    }

    @Deprecated
    public static DialogCreate1v1PkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreate1v1PkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_1v1_pk, viewGroup, z, obj);
    }

    public static DialogCreate1v1PkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreate1v1PkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreate1v1PkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_1v1_pk, (ViewGroup) null, false, obj);
    }
}
