package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentTransferCenterHeadBinding extends ViewDataBinding {
    public final IncludeTransferTextBinding clientLayout;
    public final TextView diamond;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٥٧id;
    public final View line;
    public final View numberBg;
    public final TextView position;
    public final IncludeTransferTextBinding recharge;
    public final View saleDetail;
    public final AppCompatTextView saleDetailText;
    public final TextView sales;
    public final IncludeTransferTextBinding salesLayout;
    public final View selectBg;
    public final TextView time;
    public final ImageView timeIcon;
    public final TextView title;
    public final ConstraintLayout titleLayout;
    public final View twoLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTransferCenterHeadBinding(Object obj, View view, int i, IncludeTransferTextBinding includeTransferTextBinding, TextView textView, TextView textView2, View view2, View view3, TextView textView3, IncludeTransferTextBinding includeTransferTextBinding2, View view4, AppCompatTextView appCompatTextView, TextView textView4, IncludeTransferTextBinding includeTransferTextBinding3, View view5, TextView textView5, ImageView imageView, TextView textView6, ConstraintLayout constraintLayout, View view6) {
        super(obj, view, i);
        this.clientLayout = includeTransferTextBinding;
        this.diamond = textView;
        this.f٥٧id = textView2;
        this.line = view2;
        this.numberBg = view3;
        this.position = textView3;
        this.recharge = includeTransferTextBinding2;
        this.saleDetail = view4;
        this.saleDetailText = appCompatTextView;
        this.sales = textView4;
        this.salesLayout = includeTransferTextBinding3;
        this.selectBg = view5;
        this.time = textView5;
        this.timeIcon = imageView;
        this.title = textView6;
        this.titleLayout = constraintLayout;
        this.twoLine = view6;
    }

    public static FragmentTransferCenterHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentTransferCenterHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentTransferCenterHeadBinding bind(View view, Object obj) {
        return (FragmentTransferCenterHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_transfer_center_head);
    }

    @Deprecated
    public static FragmentTransferCenterHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTransferCenterHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer_center_head, viewGroup, z, obj);
    }

    public static FragmentTransferCenterHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentTransferCenterHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTransferCenterHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer_center_head, (ViewGroup) null, false, obj);
    }
}
