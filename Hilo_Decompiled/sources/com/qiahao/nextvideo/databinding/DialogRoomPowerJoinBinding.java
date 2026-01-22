package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomPowerJoinBinding extends ViewDataBinding {
    public final AppCompatImageView close;
    public final AppCompatTextView freeJoin;
    public final AppCompatTextView join;
    public final AppCompatImageView messageImage;
    public final AppCompatTextView messageText;
    public final AppCompatImageView micImage;
    public final AppCompatTextView mixText;
    public final AppCompatImageView pictureImage;
    public final AppCompatTextView pictureText;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomPowerJoinBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView4, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        super(obj, view, i);
        this.close = appCompatImageView;
        this.freeJoin = appCompatTextView;
        this.join = appCompatTextView2;
        this.messageImage = appCompatImageView2;
        this.messageText = appCompatTextView3;
        this.micImage = appCompatImageView3;
        this.mixText = appCompatTextView4;
        this.pictureImage = appCompatImageView4;
        this.pictureText = appCompatTextView5;
        this.title = appCompatTextView6;
    }

    public static DialogRoomPowerJoinBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomPowerJoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomPowerJoinBinding bind(View view, Object obj) {
        return (DialogRoomPowerJoinBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_power_join);
    }

    @Deprecated
    public static DialogRoomPowerJoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomPowerJoinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_power_join, viewGroup, z, obj);
    }

    public static DialogRoomPowerJoinBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomPowerJoinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomPowerJoinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_power_join, (ViewGroup) null, false, obj);
    }
}
