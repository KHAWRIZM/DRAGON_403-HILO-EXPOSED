package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemStrangeListBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final TextView name;
    public final View onlineStatus;
    public final TextView time;
    public final AppCompatButton unreadText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemStrangeListBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, TextView textView2, View view2, TextView textView3, AppCompatButton appCompatButton) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.name = textView2;
        this.onlineStatus = view2;
        this.time = textView3;
        this.unreadText = appCompatButton;
    }

    public static ItemStrangeListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemStrangeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemStrangeListBinding bind(View view, Object obj) {
        return (ItemStrangeListBinding) ViewDataBinding.bind(obj, view, R.layout.item_strange_list);
    }

    @Deprecated
    public static ItemStrangeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemStrangeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_strange_list, viewGroup, z, obj);
    }

    public static ItemStrangeListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemStrangeListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemStrangeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_strange_list, (ViewGroup) null, false, obj);
    }
}
