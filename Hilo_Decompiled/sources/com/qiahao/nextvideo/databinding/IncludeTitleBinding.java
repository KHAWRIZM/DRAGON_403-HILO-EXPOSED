package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeTitleBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final View bar;
    public final AppCompatImageView endImage;
    public final LinearLayoutCompat linearLayout;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeTitleBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, View view2, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.endImage = appCompatImageView2;
        this.linearLayout = linearLayoutCompat;
        this.title = appCompatTextView;
    }

    public static IncludeTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeTitleBinding bind(View view, Object obj) {
        return (IncludeTitleBinding) ViewDataBinding.bind(obj, view, R.layout.include_title);
    }

    @Deprecated
    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_title, viewGroup, z, obj);
    }

    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_title, (ViewGroup) null, false, obj);
    }
}
