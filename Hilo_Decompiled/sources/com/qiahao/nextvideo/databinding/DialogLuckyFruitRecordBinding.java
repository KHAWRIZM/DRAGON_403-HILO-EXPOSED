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
public abstract class DialogLuckyFruitRecordBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final TextView diamond;
    public final ImageView emptyView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final TextView recordRound;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final TextView title;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyFruitRecordBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView3, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.diamond = textView;
        this.emptyView = imageView2;
        this.luckyBoxContent = constraintLayout;
        this.recordRound = textView2;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.title = textView3;
        this.topLineView = view2;
    }

    public static DialogLuckyFruitRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyFruitRecordBinding bind(View view, Object obj) {
        return (DialogLuckyFruitRecordBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_fruit_record);
    }

    @Deprecated
    public static DialogLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyFruitRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_record, viewGroup, z, obj);
    }

    public static DialogLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyFruitRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_fruit_record, (ViewGroup) null, false, obj);
    }
}
