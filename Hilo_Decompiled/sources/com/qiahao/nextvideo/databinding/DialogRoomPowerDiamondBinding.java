package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomPowerDiamondBinding extends ViewDataBinding {
    public final AppCompatImageView close;
    public final AppCompatTextView confirm;
    public final AppCompatEditText editText;
    public final AppCompatImageView image;
    public final AppCompatTextView number;
    public final AppCompatTextView subTitle;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomPowerDiamondBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.close = appCompatImageView;
        this.confirm = appCompatTextView;
        this.editText = appCompatEditText;
        this.image = appCompatImageView2;
        this.number = appCompatTextView2;
        this.subTitle = appCompatTextView3;
        this.title = appCompatTextView4;
    }

    public static DialogRoomPowerDiamondBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomPowerDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomPowerDiamondBinding bind(View view, Object obj) {
        return (DialogRoomPowerDiamondBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_power_diamond);
    }

    @Deprecated
    public static DialogRoomPowerDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomPowerDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_power_diamond, viewGroup, z, obj);
    }

    public static DialogRoomPowerDiamondBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomPowerDiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomPowerDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_power_diamond, (ViewGroup) null, false, obj);
    }
}
