package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatRoomFoodieRankingBinding extends ViewDataBinding {
    public final QMUIRadiusImageView civAvatar;
    public final FrameLayout flRank;
    public final ImageView ivRank;
    public final TextView tvGold;
    public final TextView tvNickName;
    public final TextView tvRank;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatRoomFoodieRankingBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.civAvatar = qMUIRadiusImageView;
        this.flRank = frameLayout;
        this.ivRank = imageView;
        this.tvGold = textView;
        this.tvNickName = textView2;
        this.tvRank = textView3;
    }

    public static ItemChatRoomFoodieRankingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatRoomFoodieRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieRankingBinding bind(View view, Object obj) {
        return (ItemChatRoomFoodieRankingBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_room_foodie_ranking);
    }

    @Deprecated
    public static ItemChatRoomFoodieRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatRoomFoodieRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_ranking, viewGroup, z, obj);
    }

    public static ItemChatRoomFoodieRankingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieRankingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatRoomFoodieRankingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_ranking, (ViewGroup) null, false, obj);
    }
}
