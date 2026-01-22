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
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemNewRoomBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final ImageView countryIcon;
    public final TextView des;
    public final ImageView flowIcon;
    public final ImageView gameIcon;
    public final View headButtonBg;
    public final View headTopBg;
    public final ImageView hot;
    public final TextView hotNumber;
    public final TextView name;
    public final TextView number;
    public final QMUIRadiusImageView oneAvatar;
    public final QMUIRadiusImageView threeAvatar;
    public final RoundCornerImageView topBg;
    public final QMUIRadiusImageView twoAvatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemNewRoomBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, View view2, View view3, ImageView imageView4, TextView textView2, TextView textView3, TextView textView4, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, RoundCornerImageView roundCornerImageView, QMUIRadiusImageView qMUIRadiusImageView3) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.countryIcon = imageView;
        this.des = textView;
        this.flowIcon = imageView2;
        this.gameIcon = imageView3;
        this.headButtonBg = view2;
        this.headTopBg = view3;
        this.hot = imageView4;
        this.hotNumber = textView2;
        this.name = textView3;
        this.number = textView4;
        this.oneAvatar = qMUIRadiusImageView;
        this.threeAvatar = qMUIRadiusImageView2;
        this.topBg = roundCornerImageView;
        this.twoAvatar = qMUIRadiusImageView3;
    }

    public static ItemNewRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemNewRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemNewRoomBinding bind(View view, Object obj) {
        return (ItemNewRoomBinding) ViewDataBinding.bind(obj, view, R.layout.item_new_room);
    }

    @Deprecated
    public static ItemNewRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNewRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_new_room, viewGroup, z, obj);
    }

    public static ItemNewRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemNewRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNewRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_new_room, (ViewGroup) null, false, obj);
    }
}
