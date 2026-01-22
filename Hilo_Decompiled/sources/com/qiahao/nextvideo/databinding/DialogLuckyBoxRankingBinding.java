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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyBoxRankingBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final TextView countDownText;
    public final ImageView emptyView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyBoxRankingBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout, RecyclerView recyclerView, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.countDownText = textView;
        this.emptyView = imageView2;
        this.luckyBoxContent = constraintLayout;
        this.recyclerView = recyclerView;
        this.topLineView = view2;
    }

    public static DialogLuckyBoxRankingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyBoxRankingBinding bind(View view, Object obj) {
        return (DialogLuckyBoxRankingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_box_ranking);
    }

    @Deprecated
    public static DialogLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyBoxRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_ranking, viewGroup, z, obj);
    }

    public static DialogLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyBoxRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_ranking, (ViewGroup) null, false, obj);
    }
}
