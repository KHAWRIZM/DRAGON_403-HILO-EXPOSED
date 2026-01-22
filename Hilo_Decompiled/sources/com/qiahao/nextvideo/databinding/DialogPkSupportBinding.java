package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPkSupportBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraint;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٥٤id;
    public final TextView name;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final ImageView reportButton;
    public final SuperStatusView statusView;
    public final TextView supportText;
    public final ImageView topImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPkSupportBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ImageView imageView, SuperStatusView superStatusView, TextView textView3, ImageView imageView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.constraint = constraintLayout;
        this.f٥٤id = textView;
        this.name = textView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.reportButton = imageView;
        this.statusView = superStatusView;
        this.supportText = textView3;
        this.topImage = imageView2;
    }

    public static DialogPkSupportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPkSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogPkSupportBinding bind(View view, Object obj) {
        return (DialogPkSupportBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_pk_support);
    }

    @Deprecated
    public static DialogPkSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPkSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_support, viewGroup, z, obj);
    }

    public static DialogPkSupportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPkSupportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPkSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_support, (ViewGroup) null, false, obj);
    }
}
