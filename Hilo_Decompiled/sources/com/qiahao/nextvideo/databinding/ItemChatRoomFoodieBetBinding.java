package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemChatRoomFoodieBetBinding implements a {
    public final ImageView bet;
    public final TextView betGold;
    private final ConstraintLayout rootView;

    private ItemChatRoomFoodieBetBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.bet = imageView;
        this.betGold = textView;
    }

    public static ItemChatRoomFoodieBetBinding bind(View view) {
        int i = R.id.bet;
        ImageView imageView = (ImageView) b.a(view, R.id.bet);
        if (imageView != null) {
            i = R.id.bet_gold;
            TextView textView = (TextView) b.a(view, R.id.bet_gold);
            if (textView != null) {
                return new ItemChatRoomFoodieBetBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChatRoomFoodieBetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChatRoomFoodieBetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_chat_room_foodie_bet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
