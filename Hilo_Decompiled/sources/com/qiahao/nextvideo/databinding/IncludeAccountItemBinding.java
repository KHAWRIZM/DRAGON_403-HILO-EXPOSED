package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeAccountItemBinding extends ViewDataBinding {
    public final AppCompatImageView arrow;
    public final View line;
    protected Boolean mShowLine;
    protected String mSubTitle;
    protected String mTitle;
    public final ImageView startImage;
    public final AppCompatTextView subTitle;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeAccountItemBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, View view2, ImageView imageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.arrow = appCompatImageView;
        this.line = view2;
        this.startImage = imageView;
        this.subTitle = appCompatTextView;
        this.title = appCompatTextView2;
    }

    public static IncludeAccountItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeAccountItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public Boolean getShowLine() {
        return this.mShowLine;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setShowLine(Boolean bool);

    public abstract void setSubTitle(String str);

    public abstract void setTitle(String str);

    @Deprecated
    public static IncludeAccountItemBinding bind(View view, Object obj) {
        return (IncludeAccountItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_account_item);
    }

    @Deprecated
    public static IncludeAccountItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeAccountItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_account_item, viewGroup, z, obj);
    }

    public static IncludeAccountItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeAccountItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeAccountItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_account_item, (ViewGroup) null, false, obj);
    }
}
