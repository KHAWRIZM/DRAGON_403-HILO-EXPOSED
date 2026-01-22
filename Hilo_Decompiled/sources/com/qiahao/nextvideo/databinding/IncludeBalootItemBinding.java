package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeBalootItemBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView nickName;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeBalootItemBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.nickName = textView;
    }

    public static IncludeBalootItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeBalootItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeBalootItemBinding bind(View view, Object obj) {
        return (IncludeBalootItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_baloot_item);
    }

    @Deprecated
    public static IncludeBalootItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeBalootItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_baloot_item, viewGroup, z, obj);
    }

    public static IncludeBalootItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeBalootItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeBalootItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_baloot_item, (ViewGroup) null, false, obj);
    }
}
