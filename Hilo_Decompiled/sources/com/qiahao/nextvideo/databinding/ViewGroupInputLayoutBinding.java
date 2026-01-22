package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGroupInputLayoutBinding extends ViewDataBinding {
    public final RoomEditText chatMessageInput1;
    public final ImageView picVideoBtn1;
    public final ImageView sendImage1;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroupInputLayoutBinding(Object obj, View view, int i, RoomEditText roomEditText, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.chatMessageInput1 = roomEditText;
        this.picVideoBtn1 = imageView;
        this.sendImage1 = imageView2;
    }

    public static ViewGroupInputLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGroupInputLayoutBinding bind(View view, Object obj) {
        return (ViewGroupInputLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.view_group_input_layout);
    }

    @Deprecated
    public static ViewGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGroupInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_group_input_layout, viewGroup, z, obj);
    }

    public static ViewGroupInputLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGroupInputLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGroupInputLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_group_input_layout, (ViewGroup) null, false, obj);
    }
}
