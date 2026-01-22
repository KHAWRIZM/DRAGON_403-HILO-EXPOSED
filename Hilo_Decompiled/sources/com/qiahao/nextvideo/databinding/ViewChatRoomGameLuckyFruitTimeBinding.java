package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewChatRoomGameLuckyFruitTimeBinding implements a {
    public final ImageView bgImage;
    private final ConstraintLayout rootView;
    public final ImageView timeNum1;
    public final ImageView timeNum2;

    private ViewChatRoomGameLuckyFruitTimeBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.bgImage = imageView;
        this.timeNum1 = imageView2;
        this.timeNum2 = imageView3;
    }

    public static ViewChatRoomGameLuckyFruitTimeBinding bind(View view) {
        int i = R.id.bg_image;
        ImageView imageView = (ImageView) b.a(view, R.id.bg_image);
        if (imageView != null) {
            i = R.id.time_num1;
            ImageView imageView2 = (ImageView) b.a(view, R.id.time_num1);
            if (imageView2 != null) {
                i = R.id.time_num2;
                ImageView imageView3 = (ImageView) b.a(view, R.id.time_num2);
                if (imageView3 != null) {
                    return new ViewChatRoomGameLuckyFruitTimeBinding((ConstraintLayout) view, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewChatRoomGameLuckyFruitTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewChatRoomGameLuckyFruitTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_chat_room_game_lucky_fruit_time, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
