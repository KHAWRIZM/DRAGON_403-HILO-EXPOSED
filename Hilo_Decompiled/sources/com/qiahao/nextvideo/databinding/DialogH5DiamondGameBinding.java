package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogH5DiamondGameBinding extends ViewDataBinding {
    public final View bg;
    public final RecyclerView recyclerView;
    public final View topBg;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogH5DiamondGameBinding(Object obj, View view, int i, View view2, RecyclerView recyclerView, View view3, WebView webView) {
        super(obj, view, i);
        this.bg = view2;
        this.recyclerView = recyclerView;
        this.topBg = view3;
        this.webView = webView;
    }

    public static DialogH5DiamondGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogH5DiamondGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogH5DiamondGameBinding bind(View view, Object obj) {
        return (DialogH5DiamondGameBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_h5_diamond_game);
    }

    @Deprecated
    public static DialogH5DiamondGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogH5DiamondGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_diamond_game, viewGroup, z, obj);
    }

    public static DialogH5DiamondGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogH5DiamondGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogH5DiamondGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_diamond_game, (ViewGroup) null, false, obj);
    }
}
