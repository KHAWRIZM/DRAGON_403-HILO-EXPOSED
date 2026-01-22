package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCpRankBinding extends ViewDataBinding {
    public final TextView cpValue;
    public final ImageView iconNoble1;
    public final ImageView iconNoble2;
    public final ImageView iconVip1;
    public final ImageView iconVip2;
    public final TextView listPosition;
    public final LinearLayout llDiamond;
    public final HiloImageView user1AvatarCimageView;
    public final MedalGridLayout user1Medal;
    public final TextView user1Name;
    public final HiloImageView user2AvatarCimageView;
    public final MedalGridLayout user2Medal;
    public final TextView user2Name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpRankBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, LinearLayout linearLayout, HiloImageView hiloImageView, MedalGridLayout medalGridLayout, TextView textView3, HiloImageView hiloImageView2, MedalGridLayout medalGridLayout2, TextView textView4) {
        super(obj, view, i);
        this.cpValue = textView;
        this.iconNoble1 = imageView;
        this.iconNoble2 = imageView2;
        this.iconVip1 = imageView3;
        this.iconVip2 = imageView4;
        this.listPosition = textView2;
        this.llDiamond = linearLayout;
        this.user1AvatarCimageView = hiloImageView;
        this.user1Medal = medalGridLayout;
        this.user1Name = textView3;
        this.user2AvatarCimageView = hiloImageView2;
        this.user2Medal = medalGridLayout2;
        this.user2Name = textView4;
    }

    public static ItemCpRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpRankBinding bind(View view, Object obj) {
        return (ItemCpRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_rank);
    }

    @Deprecated
    public static ItemCpRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_rank, viewGroup, z, obj);
    }

    public static ItemCpRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_rank, (ViewGroup) null, false, obj);
    }
}
