package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatRoomLuckyFruitRecordBinding extends ViewDataBinding {
    public final RecyclerView fruitResultRecyclerView;
    public final View line;
    public final LinearLayout llWin;
    public final TextView lostView;
    public final TextView mine;
    public final TextView recordDate;
    public final TextView recordRound;
    public final ImageView winImage;
    public final TextView winningTip;
    public final TextView wonDiamond;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatRoomLuckyFruitRecordBinding(Object obj, View view, int i, RecyclerView recyclerView, View view2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.fruitResultRecyclerView = recyclerView;
        this.line = view2;
        this.llWin = linearLayout;
        this.lostView = textView;
        this.mine = textView2;
        this.recordDate = textView3;
        this.recordRound = textView4;
        this.winImage = imageView;
        this.winningTip = textView5;
        this.wonDiamond = textView6;
    }

    public static ItemChatRoomLuckyFruitRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatRoomLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatRoomLuckyFruitRecordBinding bind(View view, Object obj) {
        return (ItemChatRoomLuckyFruitRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_room_lucky_fruit_record);
    }

    @Deprecated
    public static ItemChatRoomLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatRoomLuckyFruitRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_lucky_fruit_record, viewGroup, z, obj);
    }

    public static ItemChatRoomLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatRoomLuckyFruitRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatRoomLuckyFruitRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_room_lucky_fruit_record, (ViewGroup) null, false, obj);
    }
}
