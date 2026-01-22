package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyBoxWinningRecordBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final ImageView emptyView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyBoxWinningRecordBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.emptyView = imageView2;
        this.luckyBoxContent = constraintLayout;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.topLineView = view2;
    }

    public static DialogLuckyBoxWinningRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyBoxWinningRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyBoxWinningRecordBinding bind(View view, Object obj) {
        return (DialogLuckyBoxWinningRecordBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_box_winning_record);
    }

    @Deprecated
    public static DialogLuckyBoxWinningRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyBoxWinningRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_winning_record, viewGroup, z, obj);
    }

    public static DialogLuckyBoxWinningRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyBoxWinningRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyBoxWinningRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_winning_record, (ViewGroup) null, false, obj);
    }
}
