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
public abstract class ItemDailyRecordBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final TextView name;
    public final TextView time;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDailyRecordBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.name = textView2;
        this.time = textView3;
    }

    public static ItemDailyRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDailyRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDailyRecordBinding bind(View view, Object obj) {
        return (ItemDailyRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_daily_record);
    }

    @Deprecated
    public static ItemDailyRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDailyRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_daily_record, viewGroup, z, obj);
    }

    public static ItemDailyRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDailyRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDailyRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_daily_record, (ViewGroup) null, false, obj);
    }
}
