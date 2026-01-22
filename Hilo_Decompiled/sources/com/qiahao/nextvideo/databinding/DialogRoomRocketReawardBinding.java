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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomRocketReawardBinding extends ViewDataBinding {
    public final ImageView failureFace;
    public final TextView failureText;
    protected View.OnClickListener mClick;
    public final TextView okButton;
    public final ConstraintLayout rewardContent;
    public final ImageView winCongratulation;
    public final TextView winName;
    public final ImageView winReward;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomRocketReawardBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView3, ImageView imageView3) {
        super(obj, view, i);
        this.failureFace = imageView;
        this.failureText = textView;
        this.okButton = textView2;
        this.rewardContent = constraintLayout;
        this.winCongratulation = imageView2;
        this.winName = textView3;
        this.winReward = imageView3;
    }

    public static DialogRoomRocketReawardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomRocketReawardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogRoomRocketReawardBinding bind(View view, Object obj) {
        return (DialogRoomRocketReawardBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_rocket_reaward);
    }

    @Deprecated
    public static DialogRoomRocketReawardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomRocketReawardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_rocket_reaward, viewGroup, z, obj);
    }

    public static DialogRoomRocketReawardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomRocketReawardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomRocketReawardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_rocket_reaward, (ViewGroup) null, false, obj);
    }
}
