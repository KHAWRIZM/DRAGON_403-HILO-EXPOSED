package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemVideoImTextBinding extends ViewDataBinding {
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemVideoImTextBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.title = textView;
    }

    public static ItemVideoImTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemVideoImTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemVideoImTextBinding bind(View view, Object obj) {
        return (ItemVideoImTextBinding) ViewDataBinding.bind(obj, view, R.layout.item_video_im_text);
    }

    @Deprecated
    public static ItemVideoImTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoImTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_im_text, viewGroup, z, obj);
    }

    public static ItemVideoImTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemVideoImTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoImTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_im_text, (ViewGroup) null, false, obj);
    }
}
