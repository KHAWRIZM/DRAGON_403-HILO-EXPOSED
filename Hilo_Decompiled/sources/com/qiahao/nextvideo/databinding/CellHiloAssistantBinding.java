package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellHiloAssistantBinding extends ViewDataBinding {
    public final TextView canJump;
    public final ImageView imageView;
    public final LinearLayout messageContainer;
    public final AppCompatTextView subtitleTextView;
    public final AppCompatTextView timeTextView;
    public final CircleImageView userAvatarCircleImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellHiloAssistantBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CircleImageView circleImageView) {
        super(obj, view, i);
        this.canJump = textView;
        this.imageView = imageView;
        this.messageContainer = linearLayout;
        this.subtitleTextView = appCompatTextView;
        this.timeTextView = appCompatTextView2;
        this.userAvatarCircleImageView = circleImageView;
    }

    public static CellHiloAssistantBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellHiloAssistantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellHiloAssistantBinding bind(View view, Object obj) {
        return (CellHiloAssistantBinding) ViewDataBinding.bind(obj, view, R.layout.cell_hilo_assistant);
    }

    @Deprecated
    public static CellHiloAssistantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellHiloAssistantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant, viewGroup, z, obj);
    }

    public static CellHiloAssistantBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellHiloAssistantBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellHiloAssistantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant, (ViewGroup) null, false, obj);
    }
}
