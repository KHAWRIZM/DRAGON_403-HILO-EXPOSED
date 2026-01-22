package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFragmentPromoterCenterBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraintLayout;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٦٠id;
    public final IncludeTransferTextBinding invite;
    public final View monthBg;
    public final TextView name;
    public final View oneLine;
    public final IncludeTransferTextBinding pass;
    public final IncludeTransferTextBinding topUp;
    public final View twoLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFragmentPromoterCenterBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView, IncludeTransferTextBinding includeTransferTextBinding, View view2, TextView textView2, View view3, IncludeTransferTextBinding includeTransferTextBinding2, IncludeTransferTextBinding includeTransferTextBinding3, View view4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.constraintLayout = constraintLayout;
        this.f٦٠id = textView;
        this.invite = includeTransferTextBinding;
        this.monthBg = view2;
        this.name = textView2;
        this.oneLine = view3;
        this.pass = includeTransferTextBinding2;
        this.topUp = includeTransferTextBinding3;
        this.twoLine = view4;
    }

    public static ItemFragmentPromoterCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFragmentPromoterCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFragmentPromoterCenterBinding bind(View view, Object obj) {
        return (ItemFragmentPromoterCenterBinding) ViewDataBinding.bind(obj, view, R.layout.item_fragment_promoter_center);
    }

    @Deprecated
    public static ItemFragmentPromoterCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFragmentPromoterCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_promoter_center, viewGroup, z, obj);
    }

    public static ItemFragmentPromoterCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFragmentPromoterCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFragmentPromoterCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_promoter_center, (ViewGroup) null, false, obj);
    }
}
