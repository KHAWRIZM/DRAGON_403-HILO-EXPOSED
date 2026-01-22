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
public abstract class ViewTaskItemBinding extends ViewDataBinding {
    public final TextView buttonText;
    public final ImageView completeImg;
    public final ImageView moneyImg;
    public final TextView topText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewTaskItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.buttonText = textView;
        this.completeImg = imageView;
        this.moneyImg = imageView2;
        this.topText = textView2;
    }

    public static ViewTaskItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewTaskItemBinding bind(View view, Object obj) {
        return (ViewTaskItemBinding) ViewDataBinding.bind(obj, view, R.layout.view_task_item);
    }

    @Deprecated
    public static ViewTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewTaskItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_task_item, viewGroup, z, obj);
    }

    public static ViewTaskItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewTaskItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewTaskItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_task_item, (ViewGroup) null, false, obj);
    }
}
