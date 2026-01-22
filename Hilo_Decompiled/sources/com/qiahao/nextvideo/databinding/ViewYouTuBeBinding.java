package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewYouTuBeBinding extends ViewDataBinding {
    public final TextView currentTime;
    public final TextView durationTime;
    public final AppCompatSeekBar seekBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewYouTuBeBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatSeekBar appCompatSeekBar) {
        super(obj, view, i);
        this.currentTime = textView;
        this.durationTime = textView2;
        this.seekBar = appCompatSeekBar;
    }

    public static ViewYouTuBeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewYouTuBeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewYouTuBeBinding bind(View view, Object obj) {
        return (ViewYouTuBeBinding) ViewDataBinding.bind(obj, view, R.layout.view_you_tu_be);
    }

    @Deprecated
    public static ViewYouTuBeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewYouTuBeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_be, viewGroup, z, obj);
    }

    public static ViewYouTuBeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewYouTuBeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewYouTuBeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_be, (ViewGroup) null, false, obj);
    }
}
