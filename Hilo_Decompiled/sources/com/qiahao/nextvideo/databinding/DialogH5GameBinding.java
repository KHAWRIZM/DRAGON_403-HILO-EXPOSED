package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogH5GameBinding extends ViewDataBinding {
    public final View bg;
    public final ImageView cloase;
    public final ImageView gameIcon;
    public final TextView gameTitle;
    public final View topBg;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogH5GameBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, TextView textView, View view3, WebView webView) {
        super(obj, view, i);
        this.bg = view2;
        this.cloase = imageView;
        this.gameIcon = imageView2;
        this.gameTitle = textView;
        this.topBg = view3;
        this.webView = webView;
    }

    public static DialogH5GameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogH5GameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogH5GameBinding bind(View view, Object obj) {
        return (DialogH5GameBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_h5_game);
    }

    @Deprecated
    public static DialogH5GameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogH5GameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_game, viewGroup, z, obj);
    }

    public static DialogH5GameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogH5GameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogH5GameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_game, (ViewGroup) null, false, obj);
    }
}
