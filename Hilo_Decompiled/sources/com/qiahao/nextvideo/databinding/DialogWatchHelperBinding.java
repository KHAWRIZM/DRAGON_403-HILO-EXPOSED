package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogWatchHelperBinding extends ViewDataBinding {
    public final ImageView centerImage;
    public final ImageView close;
    public final TextView confirm;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final TextView content1;
    public final FrameLayout frameLayout;
    public final ImageView image2;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWatchHelperBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, FrameLayout frameLayout, ImageView imageView3, TextView textView4) {
        super(obj, view, i);
        this.centerImage = imageView;
        this.close = imageView2;
        this.confirm = textView;
        this.constraint = constraintLayout;
        this.content = textView2;
        this.content1 = textView3;
        this.frameLayout = frameLayout;
        this.image2 = imageView3;
        this.title = textView4;
    }

    public static DialogWatchHelperBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogWatchHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogWatchHelperBinding bind(View view, Object obj) {
        return (DialogWatchHelperBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_watch_helper);
    }

    @Deprecated
    public static DialogWatchHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogWatchHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_watch_helper, viewGroup, z, obj);
    }

    public static DialogWatchHelperBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogWatchHelperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWatchHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_watch_helper, (ViewGroup) null, false, obj);
    }
}
