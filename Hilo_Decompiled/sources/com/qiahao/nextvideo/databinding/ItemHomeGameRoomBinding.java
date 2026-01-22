package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemHomeGameRoomBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final ImageView arrow;
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraint;
    public final ImageView countryImg;
    public final ImageView gameIcon;
    public final LinearLayout linearLayout;
    public final TextView name;
    public final ImageView svipType;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHomeGameRoomBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, ImageView imageView4, HiloGradeView hiloGradeView) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.arrow = imageView;
        this.avatar = qMUIRadiusImageView;
        this.constraint = constraintLayout;
        this.countryImg = imageView2;
        this.gameIcon = imageView3;
        this.linearLayout = linearLayout;
        this.name = textView;
        this.svipType = imageView4;
        this.wealthLevel = hiloGradeView;
    }

    public static ItemHomeGameRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemHomeGameRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemHomeGameRoomBinding bind(View view, Object obj) {
        return (ItemHomeGameRoomBinding) ViewDataBinding.bind(obj, view, R.layout.item_home_game_room);
    }

    @Deprecated
    public static ItemHomeGameRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHomeGameRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_game_room, viewGroup, z, obj);
    }

    public static ItemHomeGameRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemHomeGameRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHomeGameRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_home_game_room, (ViewGroup) null, false, obj);
    }
}
