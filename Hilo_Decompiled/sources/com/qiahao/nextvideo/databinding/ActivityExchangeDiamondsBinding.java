package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityExchangeDiamondsBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final TextView beansBalance;
    public final EditText beansEdit;
    public final TextView diamondBalance;
    public final TextView diamondEdit;
    public final TextView exchangeDiamonds;
    public final LinearLayout linearLayout;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityExchangeDiamondsBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView, EditText editText, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.beansBalance = textView;
        this.beansEdit = editText;
        this.diamondBalance = textView2;
        this.diamondEdit = textView3;
        this.exchangeDiamonds = textView4;
        this.linearLayout = linearLayout;
        this.toolbar = toolbar;
    }

    public static ActivityExchangeDiamondsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityExchangeDiamondsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityExchangeDiamondsBinding bind(View view, Object obj) {
        return (ActivityExchangeDiamondsBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exchange_diamonds);
    }

    @Deprecated
    public static ActivityExchangeDiamondsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityExchangeDiamondsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_diamonds, viewGroup, z, obj);
    }

    public static ActivityExchangeDiamondsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityExchangeDiamondsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityExchangeDiamondsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_diamonds, (ViewGroup) null, false, obj);
    }
}
