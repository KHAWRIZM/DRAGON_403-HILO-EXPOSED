package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class SvipFootBinding extends ViewDataBinding {
    public final ImageView img;

    /* JADX INFO: Access modifiers changed from: protected */
    public SvipFootBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.img = imageView;
    }

    public static SvipFootBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static SvipFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static SvipFootBinding bind(View view, Object obj) {
        return (SvipFootBinding) ViewDataBinding.bind(obj, view, R.layout.svip_foot);
    }

    @Deprecated
    public static SvipFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SvipFootBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.svip_foot, viewGroup, z, obj);
    }

    public static SvipFootBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static SvipFootBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SvipFootBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.svip_foot, (ViewGroup) null, false, obj);
    }
}
