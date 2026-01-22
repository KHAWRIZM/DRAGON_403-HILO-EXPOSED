package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ItemGameBinding extends ViewDataBinding {
    public final ImageView image;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.image = imageView;
        this.title = textView;
    }

    public static ItemGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameBinding bind(View view, Object obj) {
        return (ItemGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_game);
    }

    @Deprecated
    public static ItemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game, viewGroup, z, obj);
    }

    public static ItemGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game, (ViewGroup) null, false, obj);
    }
}
