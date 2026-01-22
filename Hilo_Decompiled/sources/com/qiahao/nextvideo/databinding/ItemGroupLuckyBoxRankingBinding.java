package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupLuckyBoxRankingBinding extends ViewDataBinding {
    public final CircleImageView circleAvatar;
    public final TextView diamond;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٦٣id;
    public final TextView nickName;
    public final ImageView topPositionImageView;
    public final TextView topPositionText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupLuckyBoxRankingBinding(Object obj, View view, int i, CircleImageView circleImageView, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4) {
        super(obj, view, i);
        this.circleAvatar = circleImageView;
        this.diamond = textView;
        this.f٦٣id = textView2;
        this.nickName = textView3;
        this.topPositionImageView = imageView;
        this.topPositionText = textView4;
    }

    public static ItemGroupLuckyBoxRankingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxRankingBinding bind(View view, Object obj) {
        return (ItemGroupLuckyBoxRankingBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_lucky_box_ranking);
    }

    @Deprecated
    public static ItemGroupLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupLuckyBoxRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_ranking, viewGroup, z, obj);
    }

    public static ItemGroupLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxRankingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupLuckyBoxRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box_ranking, (ViewGroup) null, false, obj);
    }
}
