package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerOpenSourceBinding extends ViewDataBinding {
    public final ImageView bgPic;
    public final TextView dailyOperationFirst;
    public final TextView dailyOperationMore;
    public final TextView nextPic;
    public final TextView startDownLoad;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerOpenSourceBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.bgPic = imageView;
        this.dailyOperationFirst = textView;
        this.dailyOperationMore = textView2;
        this.nextPic = textView3;
        this.startDownLoad = textView4;
    }

    public static ViewControllerOpenSourceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerOpenSourceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerOpenSourceBinding bind(View view, Object obj) {
        return (ViewControllerOpenSourceBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_open_source);
    }

    @Deprecated
    public static ViewControllerOpenSourceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerOpenSourceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_open_source, viewGroup, z, obj);
    }

    public static ViewControllerOpenSourceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerOpenSourceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerOpenSourceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_open_source, (ViewGroup) null, false, obj);
    }
}
