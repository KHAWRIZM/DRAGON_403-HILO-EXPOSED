package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogUnoEndBinding extends ViewDataBinding {
    public final TextView close;
    public final TextView playAgain;
    public final RecyclerView recyclerView;
    public final FrameLayout rootLayout;
    public final ImageView titleImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogUnoEndBinding(Object obj, View view, int i, TextView textView, TextView textView2, RecyclerView recyclerView, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i);
        this.close = textView;
        this.playAgain = textView2;
        this.recyclerView = recyclerView;
        this.rootLayout = frameLayout;
        this.titleImage = imageView;
    }

    public static DialogUnoEndBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogUnoEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogUnoEndBinding bind(View view, Object obj) {
        return (DialogUnoEndBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_uno_end);
    }

    @Deprecated
    public static DialogUnoEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUnoEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_uno_end, viewGroup, z, obj);
    }

    public static DialogUnoEndBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogUnoEndBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUnoEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_uno_end, (ViewGroup) null, false, obj);
    }
}
