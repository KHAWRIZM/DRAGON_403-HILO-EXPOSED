package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LayoutCpUserEnterGroupRoomBinding implements a {
    public final View backGroup;
    public final HiloImageView leftAvatar;
    public final ImageView model;
    public final HiloImageView rightAvatar;
    private final LinearLayout rootView;
    public final TextView userEnterRoom;

    private LayoutCpUserEnterGroupRoomBinding(LinearLayout linearLayout, View view, HiloImageView hiloImageView, ImageView imageView, HiloImageView hiloImageView2, TextView textView) {
        this.rootView = linearLayout;
        this.backGroup = view;
        this.leftAvatar = hiloImageView;
        this.model = imageView;
        this.rightAvatar = hiloImageView2;
        this.userEnterRoom = textView;
    }

    public static LayoutCpUserEnterGroupRoomBinding bind(View view) {
        int i = R.id.back_group;
        View a = b.a(view, R.id.back_group);
        if (a != null) {
            i = R.id.leftAvatar;
            HiloImageView a2 = b.a(view, R.id.leftAvatar);
            if (a2 != null) {
                i = R.id.model;
                ImageView imageView = (ImageView) b.a(view, R.id.model);
                if (imageView != null) {
                    i = R.id.rightAvatar;
                    HiloImageView a3 = b.a(view, R.id.rightAvatar);
                    if (a3 != null) {
                        i = R.id.user_enter_room;
                        TextView textView = (TextView) b.a(view, R.id.user_enter_room);
                        if (textView != null) {
                            return new LayoutCpUserEnterGroupRoomBinding((LinearLayout) view, a, a2, imageView, a3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutCpUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutCpUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_cp_user_enter_group_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
