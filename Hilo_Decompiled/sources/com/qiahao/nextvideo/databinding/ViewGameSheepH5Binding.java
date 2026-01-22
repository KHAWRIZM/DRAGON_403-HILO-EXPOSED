package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGameSheepH5Binding extends ViewDataBinding {
    public final WebView playingWeb;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameSheepH5Binding(Object obj, View view, int i, WebView webView) {
        super(obj, view, i);
        this.playingWeb = webView;
    }

    public static ViewGameSheepH5Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameSheepH5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameSheepH5Binding bind(View view, Object obj) {
        return (ViewGameSheepH5Binding) ViewDataBinding.bind(obj, view, R.layout.view_game_sheep_h5);
    }

    @Deprecated
    public static ViewGameSheepH5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameSheepH5Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_sheep_h5, viewGroup, z, obj);
    }

    public static ViewGameSheepH5Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameSheepH5Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameSheepH5Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_sheep_h5, (ViewGroup) null, false, obj);
    }
}
