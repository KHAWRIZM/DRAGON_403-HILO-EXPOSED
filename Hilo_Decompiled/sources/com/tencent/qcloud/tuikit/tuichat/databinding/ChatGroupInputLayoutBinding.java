package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ChatGroupInputLayoutBinding extends ViewDataBinding {
    public final FrameLayout chatBtn;
    public final ImageView chatBtnInput;
    public final LinearLayout chatClickInput;
    public final ImageView chatImage;
    public final LinearLayout contentBack;
    public final ImageView faceBtn;
    public final ImageView gameBtn;
    public final SVGAImageView giftBtn;
    public final View hasMessageRedDoc;
    public final ImageView inputImage;
    public final TextView inputText;
    public final ImageView micBtn;
    public final ImageView roomSoundBtn;
    public final ImageView toolBtn;

    /* JADX INFO: Access modifiers changed from: protected */
    public ChatGroupInputLayoutBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, SVGAImageView sVGAImageView, View view2, ImageView imageView5, TextView textView, ImageView imageView6, ImageView imageView7, ImageView imageView8) {
        super(obj, view, i);
        this.chatBtn = frameLayout;
        this.chatBtnInput = imageView;
        this.chatClickInput = linearLayout;
        this.chatImage = imageView2;
        this.contentBack = linearLayout2;
        this.faceBtn = imageView3;
        this.gameBtn = imageView4;
        this.giftBtn = sVGAImageView;
        this.hasMessageRedDoc = view2;
        this.inputImage = imageView5;
        this.inputText = textView;
        this.micBtn = imageView6;
        this.roomSoundBtn = imageView7;
        this.toolBtn = imageView8;
    }

    public static ChatGroupInputLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ChatGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ChatGroupInputLayoutBinding bind(View view, Object obj) {
        return (ChatGroupInputLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.chat_group_input_layout);
    }

    @Deprecated
    public static ChatGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ChatGroupInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_group_input_layout, viewGroup, z, obj);
    }

    public static ChatGroupInputLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ChatGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ChatGroupInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_group_input_layout, (ViewGroup) null, false, obj);
    }
}
