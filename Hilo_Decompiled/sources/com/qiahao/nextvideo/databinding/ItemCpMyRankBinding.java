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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCpMyRankBinding extends ViewDataBinding {
    public final TextView cpValue;
    public final ImageView iconNoble1;
    public final ImageView iconNoble2;
    public final ImageView iconVip1;
    public final ImageView iconVip2;
    public final LinearLayout llDiamond;
    public final HiloImageView user1AvatarCimageView;
    public final TextView user1Name;
    public final HiloImageView user2AvatarCimageView;
    public final TextView user2Name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpMyRankBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, HiloImageView hiloImageView, TextView textView2, HiloImageView hiloImageView2, TextView textView3) {
        super(obj, view, i);
        this.cpValue = textView;
        this.iconNoble1 = imageView;
        this.iconNoble2 = imageView2;
        this.iconVip1 = imageView3;
        this.iconVip2 = imageView4;
        this.llDiamond = linearLayout;
        this.user1AvatarCimageView = hiloImageView;
        this.user1Name = textView2;
        this.user2AvatarCimageView = hiloImageView2;
        this.user2Name = textView3;
    }

    public static ItemCpMyRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpMyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpMyRankBinding bind(View view, Object obj) {
        return (ItemCpMyRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_my_rank);
    }

    @Deprecated
    public static ItemCpMyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpMyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_my_rank, viewGroup, z, obj);
    }

    public static ItemCpMyRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpMyRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpMyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_my_rank, (ViewGroup) null, false, obj);
    }
}
