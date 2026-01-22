package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityBaiShunBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView add;
    public final QMUIRadiusImageView avatar;
    public final AppCompatImageView backImageView;
    public final ConstraintLayout gameLayout;
    public final ImageView gameLevelImg;
    public final TextView gameText;
    public final TextView gemText;
    public final ImageView img;
    public final ConstraintLayout moneyLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBaiShunBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3, ConstraintLayout constraintLayout2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.add = imageView;
        this.avatar = qMUIRadiusImageView;
        this.backImageView = appCompatImageView;
        this.gameLayout = constraintLayout;
        this.gameLevelImg = imageView2;
        this.gameText = textView;
        this.gemText = textView2;
        this.img = imageView3;
        this.moneyLayout = constraintLayout2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static ActivityBaiShunBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityBaiShunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityBaiShunBinding bind(View view, Object obj) {
        return (ActivityBaiShunBinding) ViewDataBinding.bind(obj, view, R.layout.activity_bai_shun);
    }

    @Deprecated
    public static ActivityBaiShunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityBaiShunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_bai_shun, viewGroup, z, obj);
    }

    public static ActivityBaiShunBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityBaiShunBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityBaiShunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_bai_shun, (ViewGroup) null, false, obj);
    }
}
