package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGemStoreBinding extends ViewDataBinding {
    public final ImageView close;
    public final ImageView contactUs;
    public final TextView exchange;
    public final FrameLayout frameLayout;
    public final ImageView gemIcon;
    public final LinearLayout gemLayout;
    public final AppCompatTextView gemNumber;
    public final RecyclerView recyclerView;
    public final AppCompatTextView title;
    public final ImageView toRecharge;
    public final View topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGemStoreBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, FrameLayout frameLayout, ImageView imageView3, LinearLayout linearLayout, AppCompatTextView appCompatTextView, RecyclerView recyclerView, AppCompatTextView appCompatTextView2, ImageView imageView4, View view2) {
        super(obj, view, i);
        this.close = imageView;
        this.contactUs = imageView2;
        this.exchange = textView;
        this.frameLayout = frameLayout;
        this.gemIcon = imageView3;
        this.gemLayout = linearLayout;
        this.gemNumber = appCompatTextView;
        this.recyclerView = recyclerView;
        this.title = appCompatTextView2;
        this.toRecharge = imageView4;
        this.topBg = view2;
    }

    public static DialogGemStoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGemStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogGemStoreBinding bind(View view, Object obj) {
        return (DialogGemStoreBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_gem_store);
    }

    @Deprecated
    public static DialogGemStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGemStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gem_store, viewGroup, z, obj);
    }

    public static DialogGemStoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGemStoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGemStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gem_store, (ViewGroup) null, false, obj);
    }
}
