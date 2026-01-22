package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGemDetailsBinding extends ViewDataBinding {
    public final AppCompatTextView number;
    public final AppCompatTextView time;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGemDetailsBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.number = appCompatTextView;
        this.time = appCompatTextView2;
        this.title = appCompatTextView3;
    }

    public static ItemGemDetailsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGemDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGemDetailsBinding bind(View view, Object obj) {
        return (ItemGemDetailsBinding) ViewDataBinding.bind(obj, view, R.layout.item_gem_details);
    }

    @Deprecated
    public static ItemGemDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGemDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_details, viewGroup, z, obj);
    }

    public static ItemGemDetailsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGemDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGemDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_details, (ViewGroup) null, false, obj);
    }
}
