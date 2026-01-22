package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogDailyRecordBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ImageView close;
    public final TextView dailyTitle;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogDailyRecordBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.bg = imageView;
        this.close = imageView2;
        this.dailyTitle = textView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static DialogDailyRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogDailyRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogDailyRecordBinding bind(View view, Object obj) {
        return (DialogDailyRecordBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_daily_record);
    }

    @Deprecated
    public static DialogDailyRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDailyRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_record, viewGroup, z, obj);
    }

    public static DialogDailyRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogDailyRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDailyRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_record, (ViewGroup) null, false, obj);
    }
}
