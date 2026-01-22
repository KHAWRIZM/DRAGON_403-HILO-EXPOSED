package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloChatStrangeLayoutBinding extends ViewDataBinding {
    public final TextView atmosphere;
    public final StrangeInputView chatInputLayout;
    public final MessageRecyclerView chatMessageLayout;
    public final ImageView image1;
    public final ImageView image2;
    public final ImageView image3;
    public final ImageView image4;
    public final View line;
    public final View process;
    public final View processBg;
    public final TextView proressNumber;
    public final ConstraintLayout strangeLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloChatStrangeLayoutBinding(Object obj, View view, int i, TextView textView, StrangeInputView strangeInputView, MessageRecyclerView messageRecyclerView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view2, View view3, View view4, TextView textView2, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.atmosphere = textView;
        this.chatInputLayout = strangeInputView;
        this.chatMessageLayout = messageRecyclerView;
        this.image1 = imageView;
        this.image2 = imageView2;
        this.image3 = imageView3;
        this.image4 = imageView4;
        this.line = view2;
        this.process = view3;
        this.processBg = view4;
        this.proressNumber = textView2;
        this.strangeLayout = constraintLayout;
    }

    public static HiloChatStrangeLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloChatStrangeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloChatStrangeLayoutBinding bind(View view, Object obj) {
        return (HiloChatStrangeLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_chat_strange_layout);
    }

    @Deprecated
    public static HiloChatStrangeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloChatStrangeLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_strange_layout, viewGroup, z, obj);
    }

    public static HiloChatStrangeLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloChatStrangeLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloChatStrangeLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_strange_layout, (ViewGroup) null, false, obj);
    }
}
