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
public abstract class ItemAristocracyBinding extends ViewDataBinding {
    public final TextView text;
    public final ImageView viewImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAristocracyBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.text = textView;
        this.viewImage = imageView;
    }

    public static ItemAristocracyBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAristocracyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAristocracyBinding bind(View view, Object obj) {
        return (ItemAristocracyBinding) ViewDataBinding.bind(obj, view, R.layout.item_aristocracy);
    }

    @Deprecated
    public static ItemAristocracyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAristocracyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_aristocracy, viewGroup, z, obj);
    }

    public static ItemAristocracyBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAristocracyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAristocracyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_aristocracy, (ViewGroup) null, false, obj);
    }
}
