package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupLuckyBoxWinningBinding extends ViewDataBinding {
    public final TextView winDiamond;
    public final TextView winTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupLuckyBoxWinningBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.winDiamond = textView;
        this.winTime = textView2;
    }

    public static ItemGroupLuckyBoxWinningBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupLuckyBoxWinningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxWinningBinding bind(View view, Object obj) {
        return (ItemGroupLuckyBoxWinningBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_lucky_box_winning);
    }

    @Deprecated
    public static ItemGroupLuckyBoxWinningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupLuckyBoxWinningBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_winning, viewGroup, z, obj);
    }

    public static ItemGroupLuckyBoxWinningBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxWinningBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupLuckyBoxWinningBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_winning, (ViewGroup) null, false, obj);
    }
}
