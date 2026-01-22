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
public abstract class FragmentPromoterCenterHeadBinding extends ViewDataBinding {
    public final View monthBg;
    public final IncludeTransferTextBinding number;
    public final View oneLine;
    public final IncludeTransferTextBinding rechargeAmount;
    public final View saleDetail;
    public final AppCompatTextView saleDetailText;
    public final View selectBg;
    public final IncludeTransferTextBinding team;
    public final TextView time;
    public final ImageView timeIcon;
    public final TextView title;
    public final View twoLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPromoterCenterHeadBinding(Object obj, View view, int i, View view2, IncludeTransferTextBinding includeTransferTextBinding, View view3, IncludeTransferTextBinding includeTransferTextBinding2, View view4, AppCompatTextView appCompatTextView, View view5, IncludeTransferTextBinding includeTransferTextBinding3, TextView textView, ImageView imageView, TextView textView2, View view6) {
        super(obj, view, i);
        this.monthBg = view2;
        this.number = includeTransferTextBinding;
        this.oneLine = view3;
        this.rechargeAmount = includeTransferTextBinding2;
        this.saleDetail = view4;
        this.saleDetailText = appCompatTextView;
        this.selectBg = view5;
        this.team = includeTransferTextBinding3;
        this.time = textView;
        this.timeIcon = imageView;
        this.title = textView2;
        this.twoLine = view6;
    }

    public static FragmentPromoterCenterHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentPromoterCenterHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentPromoterCenterHeadBinding bind(View view, Object obj) {
        return (FragmentPromoterCenterHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_promoter_center_head);
    }

    @Deprecated
    public static FragmentPromoterCenterHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPromoterCenterHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_promoter_center_head, viewGroup, z, obj);
    }

    public static FragmentPromoterCenterHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentPromoterCenterHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPromoterCenterHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_promoter_center_head, (ViewGroup) null, false, obj);
    }
}
