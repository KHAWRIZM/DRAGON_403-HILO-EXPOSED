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
public abstract class CellHiloAssistantEnterCarBinding extends ViewDataBinding {
    public final TextView canJump;
    public final ImageView carPic;
    public final TextView carText;
    public final LinearLayout messageContainer;
    public final AppCompatTextView timeTextView;
    public final CircleImageView userAvatarCircleImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellHiloAssistantEnterCarBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView, CircleImageView circleImageView) {
        super(obj, view, i);
        this.canJump = textView;
        this.carPic = imageView;
        this.carText = textView2;
        this.messageContainer = linearLayout;
        this.timeTextView = appCompatTextView;
        this.userAvatarCircleImageView = circleImageView;
    }

    public static CellHiloAssistantEnterCarBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellHiloAssistantEnterCarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellHiloAssistantEnterCarBinding bind(View view, Object obj) {
        return (CellHiloAssistantEnterCarBinding) ViewDataBinding.bind(obj, view, R.layout.cell_hilo_assistant_enter_car);
    }

    @Deprecated
    public static CellHiloAssistantEnterCarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellHiloAssistantEnterCarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_enter_car, viewGroup, z, obj);
    }

    public static CellHiloAssistantEnterCarBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellHiloAssistantEnterCarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellHiloAssistantEnterCarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_enter_car, (ViewGroup) null, false, obj);
    }
}
