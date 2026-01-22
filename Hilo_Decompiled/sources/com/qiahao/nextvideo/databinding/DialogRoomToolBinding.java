package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomToolBinding extends ViewDataBinding {
    public final LinearLayout animateEffect;
    public final LinearLayout clearMessage;
    public final LinearLayout llInviteUser;
    public final LinearLayout llToolsGlobalRoomBroadcast;
    public final LinearLayout llToolsMusic;
    public final LinearLayout llToolsRoomMemberMass;
    public final LinearLayout noiseReduction;
    public final ImageView noiseReductionImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomToolBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ImageView imageView) {
        super(obj, view, i);
        this.animateEffect = linearLayout;
        this.clearMessage = linearLayout2;
        this.llInviteUser = linearLayout3;
        this.llToolsGlobalRoomBroadcast = linearLayout4;
        this.llToolsMusic = linearLayout5;
        this.llToolsRoomMemberMass = linearLayout6;
        this.noiseReduction = linearLayout7;
        this.noiseReductionImage = imageView;
    }

    public static DialogRoomToolBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomToolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomToolBinding bind(View view, Object obj) {
        return (DialogRoomToolBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_tool);
    }

    @Deprecated
    public static DialogRoomToolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomToolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_tool, viewGroup, z, obj);
    }

    public static DialogRoomToolBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomToolBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomToolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_tool, (ViewGroup) null, false, obj);
    }
}
