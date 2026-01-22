package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemChatRoomFoodieBetChoiceBinding implements a {
    public final ImageView ivGold;
    public final RelativeLayout rlContainer;
    private final FrameLayout rootView;
    public final TextView tvBet;

    private ItemChatRoomFoodieBetChoiceBinding(FrameLayout frameLayout, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        this.rootView = frameLayout;
        this.ivGold = imageView;
        this.rlContainer = relativeLayout;
        this.tvBet = textView;
    }

    public static ItemChatRoomFoodieBetChoiceBinding bind(View view) {
        int i = R.id.ivGold;
        ImageView imageView = (ImageView) b.a(view, R.id.ivGold);
        if (imageView != null) {
            i = R.id.rlContainer;
            RelativeLayout relativeLayout = (RelativeLayout) b.a(view, R.id.rlContainer);
            if (relativeLayout != null) {
                i = R.id.tvBet;
                TextView textView = (TextView) b.a(view, R.id.tvBet);
                if (textView != null) {
                    return new ItemChatRoomFoodieBetChoiceBinding((FrameLayout) view, imageView, relativeLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChatRoomFoodieBetChoiceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChatRoomFoodieBetChoiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_chat_room_foodie_bet_choice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
