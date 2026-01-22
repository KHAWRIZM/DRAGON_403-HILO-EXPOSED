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
public abstract class IncludeMatchBigItemBinding extends ViewDataBinding {
    public final TextView button;
    public final ImageView image;
    protected String mButtonTitle;
    protected Drawable mImageSrc;
    protected String mSubTitle;
    protected String mTitle;
    protected Boolean mVisibilityButton;
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeMatchBigItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.button = textView;
        this.image = imageView;
        this.subTitle = textView2;
        this.title = textView3;
    }

    public static IncludeMatchBigItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeMatchBigItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public String getButtonTitle() {
        return this.mButtonTitle;
    }

    public Drawable getImageSrc() {
        return this.mImageSrc;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Boolean getVisibilityButton() {
        return this.mVisibilityButton;
    }

    public abstract void setButtonTitle(String str);

    public abstract void setImageSrc(Drawable drawable);

    public abstract void setSubTitle(String str);

    public abstract void setTitle(String str);

    public abstract void setVisibilityButton(Boolean bool);

    @Deprecated
    public static IncludeMatchBigItemBinding bind(View view, Object obj) {
        return (IncludeMatchBigItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_match_big_item);
    }

    @Deprecated
    public static IncludeMatchBigItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMatchBigItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_match_big_item, viewGroup, z, obj);
    }

    public static IncludeMatchBigItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeMatchBigItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMatchBigItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_match_big_item, (ViewGroup) null, false, obj);
    }
}
