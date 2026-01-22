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
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupNormalRankBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final TextView diamond;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final TextView listPosition;
    public final LinearLayout llDiamond;
    public final HiloImageView userAvatarCimageView;
    public final ShineTextView userId;
    public final NickTextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupNormalRankBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, LinearLayout linearLayout, HiloImageView hiloImageView, ShineTextView shineTextView, NickTextView nickTextView) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.diamond = textView;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.listPosition = textView2;
        this.llDiamond = linearLayout;
        this.userAvatarCimageView = hiloImageView;
        this.userId = shineTextView;
        this.userName = nickTextView;
    }

    public static ItemGroupNormalRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupNormalRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupNormalRankBinding bind(View view, Object obj) {
        return (ItemGroupNormalRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_normal_rank);
    }

    @Deprecated
    public static ItemGroupNormalRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupNormalRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_normal_rank, viewGroup, z, obj);
    }

    public static ItemGroupNormalRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupNormalRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupNormalRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_normal_rank, (ViewGroup) null, false, obj);
    }
}
