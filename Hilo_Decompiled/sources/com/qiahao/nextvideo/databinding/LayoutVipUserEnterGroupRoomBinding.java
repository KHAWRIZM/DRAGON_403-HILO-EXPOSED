package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LayoutVipUserEnterGroupRoomBinding implements a {
    public final View backGroup;
    private final LinearLayout rootView;
    public final TextView userEnterRoom;

    private LayoutVipUserEnterGroupRoomBinding(LinearLayout linearLayout, View view, TextView textView) {
        this.rootView = linearLayout;
        this.backGroup = view;
        this.userEnterRoom = textView;
    }

    public static LayoutVipUserEnterGroupRoomBinding bind(View view) {
        int i = R.id.back_group;
        View a = b.a(view, R.id.back_group);
        if (a != null) {
            i = R.id.user_enter_room;
            TextView textView = (TextView) b.a(view, R.id.user_enter_room);
            if (textView != null) {
                return new LayoutVipUserEnterGroupRoomBinding((LinearLayout) view, a, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutVipUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutVipUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_vip_user_enter_group_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
