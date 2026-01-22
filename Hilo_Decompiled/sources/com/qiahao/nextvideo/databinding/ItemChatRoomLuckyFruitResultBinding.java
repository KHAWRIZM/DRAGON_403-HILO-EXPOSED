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
public final class ItemChatRoomLuckyFruitResultBinding implements a {
    public final ImageView image;
    public final ImageView isNew;
    private final ConstraintLayout rootView;

    private ItemChatRoomLuckyFruitResultBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.image = imageView;
        this.isNew = imageView2;
    }

    public static ItemChatRoomLuckyFruitResultBinding bind(View view) {
        int i = 2131363201;
        ImageView imageView = (ImageView) b.a(view, 2131363201);
        if (imageView != null) {
            i = R.id.is_new;
            ImageView imageView2 = (ImageView) b.a(view, R.id.is_new);
            if (imageView2 != null) {
                return new ItemChatRoomLuckyFruitResultBinding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChatRoomLuckyFruitResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChatRoomLuckyFruitResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_chat_room_lucky_fruit_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
