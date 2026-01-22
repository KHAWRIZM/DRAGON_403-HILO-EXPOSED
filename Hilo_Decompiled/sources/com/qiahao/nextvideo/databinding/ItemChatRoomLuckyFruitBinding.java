package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemChatRoomLuckyFruitBinding implements a {
    public final FrameLayout flGold;
    public final ImageView image;
    public final TextView name;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvGold;
    public final View viewSelectNor;
    public final View viewSelected;

    private ItemChatRoomLuckyFruitBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, ProgressBar progressBar, TextView textView2, View view, View view2) {
        this.rootView = constraintLayout;
        this.flGold = frameLayout;
        this.image = imageView;
        this.name = textView;
        this.progressBar = progressBar;
        this.tvGold = textView2;
        this.viewSelectNor = view;
        this.viewSelected = view2;
    }

    public static ItemChatRoomLuckyFruitBinding bind(View view) {
        int i = R.id.fl_gold;
        FrameLayout frameLayout = (FrameLayout) b.a(view, R.id.fl_gold);
        if (frameLayout != null) {
            i = 2131363201;
            ImageView imageView = (ImageView) b.a(view, 2131363201);
            if (imageView != null) {
                i = 2131364012;
                TextView textView = (TextView) b.a(view, 2131364012);
                if (textView != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) b.a(view, R.id.progress_bar);
                    if (progressBar != null) {
                        i = R.id.tv_gold;
                        TextView textView2 = (TextView) b.a(view, R.id.tv_gold);
                        if (textView2 != null) {
                            i = R.id.view_select_nor;
                            View a = b.a(view, R.id.view_select_nor);
                            if (a != null) {
                                i = R.id.view_selected;
                                View a2 = b.a(view, R.id.view_selected);
                                if (a2 != null) {
                                    return new ItemChatRoomLuckyFruitBinding((ConstraintLayout) view, frameLayout, imageView, textView, progressBar, textView2, a, a2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChatRoomLuckyFruitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChatRoomLuckyFruitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_chat_room_lucky_fruit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
