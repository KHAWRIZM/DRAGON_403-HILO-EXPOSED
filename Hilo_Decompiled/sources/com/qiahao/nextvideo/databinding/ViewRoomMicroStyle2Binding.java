package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.MiddleItemMicroView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewRoomMicroStyle2Binding implements a {
    public final MiddleItemMicroView microView1;
    public final MiddleItemMicroView microView2;
    private final ConstraintLayout rootView;

    private ViewRoomMicroStyle2Binding(ConstraintLayout constraintLayout, MiddleItemMicroView middleItemMicroView, MiddleItemMicroView middleItemMicroView2) {
        this.rootView = constraintLayout;
        this.microView1 = middleItemMicroView;
        this.microView2 = middleItemMicroView2;
    }

    public static ViewRoomMicroStyle2Binding bind(View view) {
        int i = R.id.micro_view1;
        MiddleItemMicroView middleItemMicroView = (MiddleItemMicroView) b.a(view, R.id.micro_view1);
        if (middleItemMicroView != null) {
            i = R.id.micro_view2;
            MiddleItemMicroView middleItemMicroView2 = (MiddleItemMicroView) b.a(view, R.id.micro_view2);
            if (middleItemMicroView2 != null) {
                return new ViewRoomMicroStyle2Binding((ConstraintLayout) view, middleItemMicroView, middleItemMicroView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewRoomMicroStyle2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRoomMicroStyle2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_micro_style_2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
