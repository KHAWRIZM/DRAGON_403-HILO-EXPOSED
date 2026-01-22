package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogInviteTakeMicGetDiamondBinding extends ViewDataBinding {
    public final ImageView close;
    public final TextView diamond;
    public final ImageView diamondDay;
    public final ImageView light2;
    public final TextView moreTask;
    public final TextView okButton;
    public final TextView tip1;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogInviteTakeMicGetDiamondBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.close = imageView;
        this.diamond = textView;
        this.diamondDay = imageView2;
        this.light2 = imageView3;
        this.moreTask = textView2;
        this.okButton = textView3;
        this.tip1 = textView4;
    }

    public static DialogInviteTakeMicGetDiamondBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogInviteTakeMicGetDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogInviteTakeMicGetDiamondBinding bind(View view, Object obj) {
        return (DialogInviteTakeMicGetDiamondBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_invite_take_mic_get_diamond);
    }

    @Deprecated
    public static DialogInviteTakeMicGetDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogInviteTakeMicGetDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_invite_take_mic_get_diamond, viewGroup, z, obj);
    }

    public static DialogInviteTakeMicGetDiamondBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogInviteTakeMicGetDiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogInviteTakeMicGetDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_invite_take_mic_get_diamond, (ViewGroup) null, false, obj);
    }
}
