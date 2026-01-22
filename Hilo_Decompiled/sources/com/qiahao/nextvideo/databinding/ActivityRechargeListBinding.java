package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRechargeListBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final TextView chatOfficial;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRechargeListBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView, RecyclerView recyclerView, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.chatOfficial = textView;
        this.recyclerView = recyclerView;
        this.toolbar = toolbar;
    }

    public static ActivityRechargeListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRechargeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityRechargeListBinding bind(View view, Object obj) {
        return (ActivityRechargeListBinding) ViewDataBinding.bind(obj, view, R.layout.activity_recharge_list);
    }

    @Deprecated
    public static ActivityRechargeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRechargeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_recharge_list, viewGroup, z, obj);
    }

    public static ActivityRechargeListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRechargeListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRechargeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_recharge_list, (ViewGroup) null, false, obj);
    }
}
