package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogYouTuListBinding extends ViewDataBinding {
    public final TextView addVideo;
    public final ConstraintLayout constraint;
    public final Group emptyGroup;
    public final ImageView emptyImage;
    public final TextView emptyText;
    public final ImageView helper;
    public final RecyclerView recyclerView;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogYouTuListBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, Group group, ImageView imageView, TextView textView2, ImageView imageView2, RecyclerView recyclerView, TextView textView3) {
        super(obj, view, i);
        this.addVideo = textView;
        this.constraint = constraintLayout;
        this.emptyGroup = group;
        this.emptyImage = imageView;
        this.emptyText = textView2;
        this.helper = imageView2;
        this.recyclerView = recyclerView;
        this.title = textView3;
    }

    public static DialogYouTuListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogYouTuListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogYouTuListBinding bind(View view, Object obj) {
        return (DialogYouTuListBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_you_tu_list);
    }

    @Deprecated
    public static DialogYouTuListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogYouTuListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_list, viewGroup, z, obj);
    }

    public static DialogYouTuListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogYouTuListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogYouTuListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_list, (ViewGroup) null, false, obj);
    }
}
