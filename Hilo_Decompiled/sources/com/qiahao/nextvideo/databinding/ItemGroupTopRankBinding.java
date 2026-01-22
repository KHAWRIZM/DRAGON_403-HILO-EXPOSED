package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupTopRankBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final ImageView iconNoble;
    public final ImageView iconVip1;
    public final HiloImageView top1Avatar;
    public final TextView top1Diamond;
    public final ImageView top1DiamondIcon;
    public final ShineTextView top1Id;
    public final NickTextView top1Name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupTopRankBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, ImageView imageView, ImageView imageView2, HiloImageView hiloImageView, TextView textView, ImageView imageView3, ShineTextView shineTextView, NickTextView nickTextView) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.iconNoble = imageView;
        this.iconVip1 = imageView2;
        this.top1Avatar = hiloImageView;
        this.top1Diamond = textView;
        this.top1DiamondIcon = imageView3;
        this.top1Id = shineTextView;
        this.top1Name = nickTextView;
    }

    public static ItemGroupTopRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupTopRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupTopRankBinding bind(View view, Object obj) {
        return (ItemGroupTopRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_top_rank);
    }

    @Deprecated
    public static ItemGroupTopRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupTopRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_top_rank, viewGroup, z, obj);
    }

    public static ItemGroupTopRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupTopRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupTopRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_top_rank, (ViewGroup) null, false, obj);
    }
}
