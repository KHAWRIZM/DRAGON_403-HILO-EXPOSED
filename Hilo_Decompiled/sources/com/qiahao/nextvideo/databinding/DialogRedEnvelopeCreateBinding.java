package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRedEnvelopeCreateBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final ImageView bottomBg;
    public final ImageView buttonBg;
    public final ImageView buttonedRedBg;
    public final TextView coins;
    public final EnvelopeNumberView coinsNumber;
    public final TextView diamond;
    public final FrameLayout frameLayout;
    public final ImageView helper;
    public final ImageView list;
    public final TextView quantity;
    public final EnvelopeNumberView quantityNumber;
    public final TextView recharge;
    public final TextView room;
    public final TextView send;
    public final ImageView topBg;
    public final TextView world;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRedEnvelopeCreateBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, EnvelopeNumberView envelopeNumberView, TextView textView2, FrameLayout frameLayout, ImageView imageView5, ImageView imageView6, TextView textView3, EnvelopeNumberView envelopeNumberView2, TextView textView4, TextView textView5, TextView textView6, ImageView imageView7, TextView textView7) {
        super(obj, view, i);
        this.arrow = imageView;
        this.bottomBg = imageView2;
        this.buttonBg = imageView3;
        this.buttonedRedBg = imageView4;
        this.coins = textView;
        this.coinsNumber = envelopeNumberView;
        this.diamond = textView2;
        this.frameLayout = frameLayout;
        this.helper = imageView5;
        this.list = imageView6;
        this.quantity = textView3;
        this.quantityNumber = envelopeNumberView2;
        this.recharge = textView4;
        this.room = textView5;
        this.send = textView6;
        this.topBg = imageView7;
        this.world = textView7;
    }

    public static DialogRedEnvelopeCreateBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRedEnvelopeCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRedEnvelopeCreateBinding bind(View view, Object obj) {
        return (DialogRedEnvelopeCreateBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_red_envelope_create);
    }

    @Deprecated
    public static DialogRedEnvelopeCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRedEnvelopeCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_red_envelope_create, viewGroup, z, obj);
    }

    public static DialogRedEnvelopeCreateBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRedEnvelopeCreateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRedEnvelopeCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_red_envelope_create, (ViewGroup) null, false, obj);
    }
}
