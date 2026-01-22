package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatRoomFoodieRecordBinding extends ViewDataBinding {
    public final ImageView ivReward;
    public final LinearLayout llBet;
    public final LinearLayout llItem;
    public final TextView tvGold;
    public final TextView tvTime;
    public final View vLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatRoomFoodieRecordBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.ivReward = imageView;
        this.llBet = linearLayout;
        this.llItem = linearLayout2;
        this.tvGold = textView;
        this.tvTime = textView2;
        this.vLine = view2;
    }

    public static ItemChatRoomFoodieRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatRoomFoodieRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieRecordBinding bind(View view, Object obj) {
        return (ItemChatRoomFoodieRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_room_foodie_record);
    }

    @Deprecated
    public static ItemChatRoomFoodieRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatRoomFoodieRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_record, viewGroup, z, obj);
    }

    public static ItemChatRoomFoodieRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatRoomFoodieRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_record, (ViewGroup) null, false, obj);
    }
}
