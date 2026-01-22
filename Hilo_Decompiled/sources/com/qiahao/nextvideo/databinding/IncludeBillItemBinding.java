package com.qiahao.nextvideo.databinding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeBillItemBinding extends ViewDataBinding {
    public final ImageView image;
    protected Drawable mImageRes;
    protected String mTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeBillItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.image = imageView;
        this.title = textView;
    }

    public static IncludeBillItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeBillItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public Drawable getImageRes() {
        return this.mImageRes;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setImageRes(Drawable drawable);

    public abstract void setTitle(String str);

    @Deprecated
    public static IncludeBillItemBinding bind(View view, Object obj) {
        return (IncludeBillItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_bill_item);
    }

    @Deprecated
    public static IncludeBillItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeBillItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_bill_item, viewGroup, z, obj);
    }

    public static IncludeBillItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeBillItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeBillItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_bill_item, (ViewGroup) null, false, obj);
    }
}
