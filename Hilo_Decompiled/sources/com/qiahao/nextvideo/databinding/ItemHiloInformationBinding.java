package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemHiloInformationBinding extends ViewDataBinding {
    public final TextView canJump;
    public final View canJumpLine;
    public final ImageView imageView;
    public final AppCompatTextView informationCreateDateTextView;
    public final AppCompatTextView subtitleTextView;
    public final TextView timeTextView;
    public final AppCompatTextView titleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHiloInformationBinding(Object obj, View view, int i, TextView textView, View view2, ImageView imageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.canJump = textView;
        this.canJumpLine = view2;
        this.imageView = imageView;
        this.informationCreateDateTextView = appCompatTextView;
        this.subtitleTextView = appCompatTextView2;
        this.timeTextView = textView2;
        this.titleTextView = appCompatTextView3;
    }

    public static ItemHiloInformationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemHiloInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemHiloInformationBinding bind(View view, Object obj) {
        return (ItemHiloInformationBinding) ViewDataBinding.bind(obj, view, R.layout.item_hilo_information);
    }

    @Deprecated
    public static ItemHiloInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHiloInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_hilo_information, viewGroup, z, obj);
    }

    public static ItemHiloInformationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemHiloInformationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHiloInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_hilo_information, (ViewGroup) null, false, obj);
    }
}
