package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class VideoTipBinding extends ViewDataBinding {
    public final AppCompatTextView contentTextView;
    public final AppCompatButton okButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoTipBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton) {
        super(obj, view, i);
        this.contentTextView = appCompatTextView;
        this.okButton = appCompatButton;
    }

    public static VideoTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static VideoTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static VideoTipBinding bind(View view, Object obj) {
        return (VideoTipBinding) ViewDataBinding.bind(obj, view, R.layout.video_tip);
    }

    @Deprecated
    public static VideoTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.video_tip, viewGroup, z, obj);
    }

    public static VideoTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static VideoTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.video_tip, (ViewGroup) null, false, obj);
    }
}
