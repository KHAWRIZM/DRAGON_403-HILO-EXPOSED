package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellHiloAssistantBeansHolderType1Binding extends ViewDataBinding {
    public final ImageView imgDiamond;
    public final LinearLayout messageContainer;
    public final AppCompatTextView subtitleTextView;
    public final AppCompatTextView timeTextView;
    public final CircleImageView userAvatarCircleImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellHiloAssistantBeansHolderType1Binding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CircleImageView circleImageView) {
        super(obj, view, i);
        this.imgDiamond = imageView;
        this.messageContainer = linearLayout;
        this.subtitleTextView = appCompatTextView;
        this.timeTextView = appCompatTextView2;
        this.userAvatarCircleImageView = circleImageView;
    }

    public static CellHiloAssistantBeansHolderType1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellHiloAssistantBeansHolderType1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellHiloAssistantBeansHolderType1Binding bind(View view, Object obj) {
        return (CellHiloAssistantBeansHolderType1Binding) ViewDataBinding.bind(obj, view, R.layout.cell_hilo_assistant_beans_holder_type1);
    }

    @Deprecated
    public static CellHiloAssistantBeansHolderType1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellHiloAssistantBeansHolderType1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_beans_holder_type1, viewGroup, z, obj);
    }

    public static CellHiloAssistantBeansHolderType1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellHiloAssistantBeansHolderType1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellHiloAssistantBeansHolderType1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_beans_holder_type1, (ViewGroup) null, false, obj);
    }
}
