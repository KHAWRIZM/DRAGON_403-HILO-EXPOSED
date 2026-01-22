package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloChatStrangeInputLayoutBinding extends ViewDataBinding {
    public final TIMMentionEditText chatMessageInput;
    public final Button chatVoiceInput;
    public final ImageView emoji;
    public final ImageView game;
    public final ImageView gift;
    public final ImageView image;
    public final ImageView moreBtn;
    public final RelativeLayout moreGroups;
    public final ImageView sendBtn;
    public final View topLine;
    public final ImageView video;
    public final ImageView voiceInputSwitch;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloChatStrangeInputLayoutBinding(Object obj, View view, int i, TIMMentionEditText tIMMentionEditText, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout, ImageView imageView6, View view2, ImageView imageView7, ImageView imageView8) {
        super(obj, view, i);
        this.chatMessageInput = tIMMentionEditText;
        this.chatVoiceInput = button;
        this.emoji = imageView;
        this.game = imageView2;
        this.gift = imageView3;
        this.image = imageView4;
        this.moreBtn = imageView5;
        this.moreGroups = relativeLayout;
        this.sendBtn = imageView6;
        this.topLine = view2;
        this.video = imageView7;
        this.voiceInputSwitch = imageView8;
    }

    public static HiloChatStrangeInputLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloChatStrangeInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloChatStrangeInputLayoutBinding bind(View view, Object obj) {
        return (HiloChatStrangeInputLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_chat_strange_input_layout);
    }

    @Deprecated
    public static HiloChatStrangeInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloChatStrangeInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_strange_input_layout, viewGroup, z, obj);
    }

    public static HiloChatStrangeInputLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloChatStrangeInputLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloChatStrangeInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_strange_input_layout, (ViewGroup) null, false, obj);
    }
}
