package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatRoomFoodieCircleResultBinding extends ViewDataBinding {
    public final ImageView ivBg;
    public final ImageView ivResult;
    public final TextView tvNew;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatRoomFoodieCircleResultBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.ivBg = imageView;
        this.ivResult = imageView2;
        this.tvNew = textView;
    }

    public static ItemChatRoomFoodieCircleResultBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatRoomFoodieCircleResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieCircleResultBinding bind(View view, Object obj) {
        return (ItemChatRoomFoodieCircleResultBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_room_foodie_circle_result);
    }

    @Deprecated
    public static ItemChatRoomFoodieCircleResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatRoomFoodieCircleResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_circle_result, viewGroup, z, obj);
    }

    public static ItemChatRoomFoodieCircleResultBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatRoomFoodieCircleResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatRoomFoodieCircleResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_foodie_circle_result, (ViewGroup) null, false, obj);
    }
}
