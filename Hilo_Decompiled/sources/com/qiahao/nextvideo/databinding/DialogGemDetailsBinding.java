package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGemDetailsBinding extends ViewDataBinding {
    public final ImageView back;
    public final ImageView close;
    public final AppCompatTextView gemNumber;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final AppCompatTextView title;
    public final View topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGemDetailsBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, AppCompatTextView appCompatTextView2, View view2) {
        super(obj, view, i);
        this.back = imageView;
        this.close = imageView2;
        this.gemNumber = appCompatTextView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.title = appCompatTextView2;
        this.topBg = view2;
    }

    public static DialogGemDetailsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGemDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogGemDetailsBinding bind(View view, Object obj) {
        return (DialogGemDetailsBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_gem_details);
    }

    @Deprecated
    public static DialogGemDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGemDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gem_details, viewGroup, z, obj);
    }

    public static DialogGemDetailsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGemDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGemDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gem_details, (ViewGroup) null, false, obj);
    }
}
