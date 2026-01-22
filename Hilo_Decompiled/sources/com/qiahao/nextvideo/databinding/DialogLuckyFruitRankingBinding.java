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
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyFruitRankingBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final ImageView emptyView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final ImageView rule;
    public final SmartRefreshLayout smartRefreshLayout;
    public final TextView title;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyFruitRankingBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, RecyclerView recyclerView, ImageView imageView3, SmartRefreshLayout smartRefreshLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.emptyView = imageView2;
        this.luckyBoxContent = constraintLayout;
        this.recyclerView = recyclerView;
        this.rule = imageView3;
        this.smartRefreshLayout = smartRefreshLayout;
        this.title = textView;
        this.topLineView = view2;
    }

    public static DialogLuckyFruitRankingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyFruitRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyFruitRankingBinding bind(View view, Object obj) {
        return (DialogLuckyFruitRankingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_fruit_ranking);
    }

    @Deprecated
    public static DialogLuckyFruitRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyFruitRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_ranking, viewGroup, z, obj);
    }

    public static DialogLuckyFruitRankingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyFruitRankingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyFruitRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_ranking, (ViewGroup) null, false, obj);
    }
}
