package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomAnimationEffectBinding extends ViewDataBinding {
    public final SwitchButton enterEffect;
    public final SwitchButton giftEffect;
    public final SwitchButton rocketEffect;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomAnimationEffectBinding(Object obj, View view, int i, SwitchButton switchButton, SwitchButton switchButton2, SwitchButton switchButton3) {
        super(obj, view, i);
        this.enterEffect = switchButton;
        this.giftEffect = switchButton2;
        this.rocketEffect = switchButton3;
    }

    public static DialogRoomAnimationEffectBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomAnimationEffectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomAnimationEffectBinding bind(View view, Object obj) {
        return (DialogRoomAnimationEffectBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_animation_effect);
    }

    @Deprecated
    public static DialogRoomAnimationEffectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomAnimationEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_animation_effect, viewGroup, z, obj);
    }

    public static DialogRoomAnimationEffectBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomAnimationEffectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomAnimationEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_animation_effect, (ViewGroup) null, false, obj);
    }
}
