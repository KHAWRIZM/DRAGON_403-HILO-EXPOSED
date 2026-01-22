package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityExchangeGemBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final View bar;
    public final TextView beansBalance;
    public final EditText beansEdit;
    public final TextView diamondBalance;
    public final TextView diamondEdit;
    public final TextView exchangeDiamonds;
    public final RecyclerView exchangeRecyclerView;
    public final TextView exchangeTitle;
    public final TextView gemTitle;
    public final View line;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityExchangeGemBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, View view2, TextView textView, EditText editText, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, TextView textView5, TextView textView6, View view3, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.beansBalance = textView;
        this.beansEdit = editText;
        this.diamondBalance = textView2;
        this.diamondEdit = textView3;
        this.exchangeDiamonds = textView4;
        this.exchangeRecyclerView = recyclerView;
        this.exchangeTitle = textView5;
        this.gemTitle = textView6;
        this.line = view3;
        this.toolbar = toolbar;
    }

    public static ActivityExchangeGemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityExchangeGemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityExchangeGemBinding bind(View view, Object obj) {
        return (ActivityExchangeGemBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exchange_gem);
    }

    @Deprecated
    public static ActivityExchangeGemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityExchangeGemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_gem, viewGroup, z, obj);
    }

    public static ActivityExchangeGemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityExchangeGemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityExchangeGemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_gem, (ViewGroup) null, false, obj);
    }
}
