package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityBillBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final IncludeBillItemBinding beans;
    public final IncludeBillItemBinding coins;
    public final IncludeBillItemBinding diamond;
    public final IncludeBillItemBinding recharge;
    public final IncludeTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBillBinding(Object obj, View view, int i, FrameLayout frameLayout, IncludeBillItemBinding includeBillItemBinding, IncludeBillItemBinding includeBillItemBinding2, IncludeBillItemBinding includeBillItemBinding3, IncludeBillItemBinding includeBillItemBinding4, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.beans = includeBillItemBinding;
        this.coins = includeBillItemBinding2;
        this.diamond = includeBillItemBinding3;
        this.recharge = includeBillItemBinding4;
        this.titleLayout = includeTitleBinding;
    }

    public static ActivityBillBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityBillBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityBillBinding bind(View view, Object obj) {
        return (ActivityBillBinding) ViewDataBinding.bind(obj, view, R.layout.activity_bill);
    }

    @Deprecated
    public static ActivityBillBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityBillBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_bill, viewGroup, z, obj);
    }

    public static ActivityBillBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityBillBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityBillBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_bill, (ViewGroup) null, false, obj);
    }
}
