package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentSecondHeadBinding extends ViewDataBinding {
    public final IncludeTransferTextBinding clientLayout;
    public final View line;
    public final View numberBg;
    public final IncludeTransferTextBinding recharge;
    public final View saleDetail;
    public final AppCompatTextView saleDetailText;
    public final IncludeTransferTextBinding salesLayout;
    public final View selectBg;
    public final TextView time;
    public final ImageView timeIcon;
    public final TextView title;
    public final View twoLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSecondHeadBinding(Object obj, View view, int i, IncludeTransferTextBinding includeTransferTextBinding, View view2, View view3, IncludeTransferTextBinding includeTransferTextBinding2, View view4, AppCompatTextView appCompatTextView, IncludeTransferTextBinding includeTransferTextBinding3, View view5, TextView textView, ImageView imageView, TextView textView2, View view6) {
        super(obj, view, i);
        this.clientLayout = includeTransferTextBinding;
        this.line = view2;
        this.numberBg = view3;
        this.recharge = includeTransferTextBinding2;
        this.saleDetail = view4;
        this.saleDetailText = appCompatTextView;
        this.salesLayout = includeTransferTextBinding3;
        this.selectBg = view5;
        this.time = textView;
        this.timeIcon = imageView;
        this.title = textView2;
        this.twoLine = view6;
    }

    public static FragmentSecondHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentSecondHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentSecondHeadBinding bind(View view, Object obj) {
        return (FragmentSecondHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_second_head);
    }

    @Deprecated
    public static FragmentSecondHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSecondHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_second_head, viewGroup, z, obj);
    }

    public static FragmentSecondHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentSecondHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSecondHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_second_head, (ViewGroup) null, false, obj);
    }
}
