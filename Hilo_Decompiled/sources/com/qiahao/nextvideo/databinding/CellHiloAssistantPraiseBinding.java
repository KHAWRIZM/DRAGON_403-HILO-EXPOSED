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
public abstract class CellHiloAssistantPraiseBinding extends ViewDataBinding {
    public final LinearLayout messageContainer;
    public final ImageView praiseImage;
    public final AppCompatTextView subtitleTextView;
    public final AppCompatTextView timeTextView;
    public final CircleImageView userAvatarCircleImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellHiloAssistantPraiseBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CircleImageView circleImageView) {
        super(obj, view, i);
        this.messageContainer = linearLayout;
        this.praiseImage = imageView;
        this.subtitleTextView = appCompatTextView;
        this.timeTextView = appCompatTextView2;
        this.userAvatarCircleImageView = circleImageView;
    }

    public static CellHiloAssistantPraiseBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellHiloAssistantPraiseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellHiloAssistantPraiseBinding bind(View view, Object obj) {
        return (CellHiloAssistantPraiseBinding) ViewDataBinding.bind(obj, view, R.layout.cell_hilo_assistant_praise);
    }

    @Deprecated
    public static CellHiloAssistantPraiseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellHiloAssistantPraiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_praise, viewGroup, z, obj);
    }

    public static CellHiloAssistantPraiseBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellHiloAssistantPraiseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellHiloAssistantPraiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_hilo_assistant_praise, (ViewGroup) null, false, obj);
    }
}
