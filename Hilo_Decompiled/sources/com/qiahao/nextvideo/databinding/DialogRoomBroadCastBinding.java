package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomBroadCastBinding extends ViewDataBinding {
    public final TextView broadCastText;
    public final ConstraintLayout clContent;
    public final ImageView close;
    public final TextView enterRoom;
    public final TextView groupId;
    public final TextView groupName;
    public final RoundedImageView imageGroup;
    protected View.OnClickListener mClick;
    public final TextView onlineNumber;
    public final CircleImageView sex;
    public final CircleImageView userAvatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomBroadCastBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, RoundedImageView roundedImageView, TextView textView5, CircleImageView circleImageView, CircleImageView circleImageView2) {
        super(obj, view, i);
        this.broadCastText = textView;
        this.clContent = constraintLayout;
        this.close = imageView;
        this.enterRoom = textView2;
        this.groupId = textView3;
        this.groupName = textView4;
        this.imageGroup = roundedImageView;
        this.onlineNumber = textView5;
        this.sex = circleImageView;
        this.userAvatar = circleImageView2;
    }

    public static DialogRoomBroadCastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogRoomBroadCastBinding bind(View view, Object obj) {
        return (DialogRoomBroadCastBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_broad_cast);
    }

    @Deprecated
    public static DialogRoomBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_broad_cast, viewGroup, z, obj);
    }

    public static DialogRoomBroadCastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomBroadCastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_broad_cast, (ViewGroup) null, false, obj);
    }
}
