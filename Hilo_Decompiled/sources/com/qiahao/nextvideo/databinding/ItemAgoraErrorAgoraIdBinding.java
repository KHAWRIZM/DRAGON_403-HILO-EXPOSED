package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemAgoraErrorAgoraIdBinding extends ViewDataBinding {
    public final TextView agoraId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAgoraErrorAgoraIdBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.agoraId = textView;
    }

    public static ItemAgoraErrorAgoraIdBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAgoraErrorAgoraIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAgoraErrorAgoraIdBinding bind(View view, Object obj) {
        return (ItemAgoraErrorAgoraIdBinding) ViewDataBinding.bind(obj, view, R.layout.item_agora_error_agora_id);
    }

    @Deprecated
    public static ItemAgoraErrorAgoraIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAgoraErrorAgoraIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_agora_error_agora_id, viewGroup, z, obj);
    }

    public static ItemAgoraErrorAgoraIdBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAgoraErrorAgoraIdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAgoraErrorAgoraIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_agora_error_agora_id, (ViewGroup) null, false, obj);
    }
}
