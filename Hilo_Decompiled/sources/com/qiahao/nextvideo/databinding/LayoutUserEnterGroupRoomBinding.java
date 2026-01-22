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
public final class LayoutUserEnterGroupRoomBinding implements a {
    private final LinearLayout rootView;
    public final TextView userEnterRoom;

    private LayoutUserEnterGroupRoomBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.userEnterRoom = textView;
    }

    public static LayoutUserEnterGroupRoomBinding bind(View view) {
        TextView textView = (TextView) b.a(view, R.id.user_enter_room);
        if (textView != null) {
            return new LayoutUserEnterGroupRoomBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.user_enter_room)));
    }

    public static LayoutUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_user_enter_group_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
