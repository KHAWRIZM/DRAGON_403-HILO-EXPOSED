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
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomPkInviteBinding extends ViewDataBinding {
    public final TextView accept;
    public final GenderAgeTextView ageTextView;
    public final ImageView blueBg;
    public final LinearLayout buttonLayout;
    public final ConstraintLayout constraint;
    public final ImageView countryImg;
    public final QMUIRadiusImageView leftAvatar;
    public final ImageView leftAvatarBg;
    public final TextView leftId;
    public final TextView leftName;
    public final PKSearchView pkSearch;
    public final ImageView redBg;
    public final QMUIRadiusImageView rightAvatar;
    public final ImageView rightAvatarBg;
    public final ImageView svipType;
    public final TextView title;
    public final ImageView vs;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomPkInviteBinding(Object obj, View view, int i, TextView textView, GenderAgeTextView genderAgeTextView, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ImageView imageView2, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView3, TextView textView2, TextView textView3, PKSearchView pKSearchView, ImageView imageView4, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView5, ImageView imageView6, TextView textView4, ImageView imageView7) {
        super(obj, view, i);
        this.accept = textView;
        this.ageTextView = genderAgeTextView;
        this.blueBg = imageView;
        this.buttonLayout = linearLayout;
        this.constraint = constraintLayout;
        this.countryImg = imageView2;
        this.leftAvatar = qMUIRadiusImageView;
        this.leftAvatarBg = imageView3;
        this.leftId = textView2;
        this.leftName = textView3;
        this.pkSearch = pKSearchView;
        this.redBg = imageView4;
        this.rightAvatar = qMUIRadiusImageView2;
        this.rightAvatarBg = imageView5;
        this.svipType = imageView6;
        this.title = textView4;
        this.vs = imageView7;
    }

    public static DialogRoomPkInviteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomPkInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomPkInviteBinding bind(View view, Object obj) {
        return (DialogRoomPkInviteBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_pk_invite);
    }

    @Deprecated
    public static DialogRoomPkInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomPkInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_pk_invite, viewGroup, z, obj);
    }

    public static DialogRoomPkInviteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomPkInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomPkInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_pk_invite, (ViewGroup) null, false, obj);
    }
}
