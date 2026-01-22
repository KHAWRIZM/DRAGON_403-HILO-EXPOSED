package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludePkGoBinding extends ViewDataBinding {
    public final ImageView change;
    public final TextView go;
    public final Group group;
    public final TextView your;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludePkGoBinding(Object obj, View view, int i, ImageView imageView, TextView textView, Group group, TextView textView2) {
        super(obj, view, i);
        this.change = imageView;
        this.go = textView;
        this.group = group;
        this.your = textView2;
    }

    public static IncludePkGoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludePkGoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludePkGoBinding bind(View view, Object obj) {
        return (IncludePkGoBinding) ViewDataBinding.bind(obj, view, R.layout.include_pk_go);
    }

    @Deprecated
    public static IncludePkGoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludePkGoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_pk_go, viewGroup, z, obj);
    }

    public static IncludePkGoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludePkGoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludePkGoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_pk_go, (ViewGroup) null, false, obj);
    }
}
