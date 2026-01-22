package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupLuckyBoxBigRewardBinding extends ViewDataBinding {
    public final ImageButton image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupLuckyBoxBigRewardBinding(Object obj, View view, int i, ImageButton imageButton) {
        super(obj, view, i);
        this.image = imageButton;
    }

    public static ItemGroupLuckyBoxBigRewardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupLuckyBoxBigRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBigRewardBinding bind(View view, Object obj) {
        return (ItemGroupLuckyBoxBigRewardBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_lucky_box_big_reward);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBigRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupLuckyBoxBigRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_big_reward, viewGroup, z, obj);
    }

    public static ItemGroupLuckyBoxBigRewardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBigRewardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupLuckyBoxBigRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_big_reward, (ViewGroup) null, false, obj);
    }
}
