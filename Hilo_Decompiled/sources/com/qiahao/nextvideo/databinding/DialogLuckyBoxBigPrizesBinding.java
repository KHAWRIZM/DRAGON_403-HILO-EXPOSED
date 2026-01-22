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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyBoxBigPrizesBinding extends ViewDataBinding {
    public final ImageView backImageView;
    public final ImageView emptyView;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyBoxBigPrizesBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, RecyclerView recyclerView, View view2) {
        super(obj, view, i);
        this.backImageView = imageView;
        this.emptyView = imageView2;
        this.luckyBoxContent = constraintLayout;
        this.recyclerView = recyclerView;
        this.topLineView = view2;
    }

    public static DialogLuckyBoxBigPrizesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyBoxBigPrizesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyBoxBigPrizesBinding bind(View view, Object obj) {
        return (DialogLuckyBoxBigPrizesBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_box_big_prizes);
    }

    @Deprecated
    public static DialogLuckyBoxBigPrizesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyBoxBigPrizesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_big_prizes, viewGroup, z, obj);
    }

    public static DialogLuckyBoxBigPrizesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyBoxBigPrizesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyBoxBigPrizesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box_big_prizes, (ViewGroup) null, false, obj);
    }
}
