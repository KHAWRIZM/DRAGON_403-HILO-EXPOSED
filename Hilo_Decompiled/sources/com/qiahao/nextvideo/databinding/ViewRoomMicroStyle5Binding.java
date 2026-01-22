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
public final class ViewRoomMicroStyle5Binding implements a {
    public final MiddleItemMicroView microView1;
    public final MiddleItemMicroView microView2;
    public final MiddleItemMicroView microView3;
    public final MiddleItemMicroView microView4;
    public final MiddleItemMicroView microView5;
    private final ConstraintLayout rootView;

    private ViewRoomMicroStyle5Binding(ConstraintLayout constraintLayout, MiddleItemMicroView middleItemMicroView, MiddleItemMicroView middleItemMicroView2, MiddleItemMicroView middleItemMicroView3, MiddleItemMicroView middleItemMicroView4, MiddleItemMicroView middleItemMicroView5) {
        this.rootView = constraintLayout;
        this.microView1 = middleItemMicroView;
        this.microView2 = middleItemMicroView2;
        this.microView3 = middleItemMicroView3;
        this.microView4 = middleItemMicroView4;
        this.microView5 = middleItemMicroView5;
    }

    public static ViewRoomMicroStyle5Binding bind(View view) {
        int i = R.id.micro_view1;
        MiddleItemMicroView middleItemMicroView = (MiddleItemMicroView) b.a(view, R.id.micro_view1);
        if (middleItemMicroView != null) {
            i = R.id.micro_view2;
            MiddleItemMicroView middleItemMicroView2 = (MiddleItemMicroView) b.a(view, R.id.micro_view2);
            if (middleItemMicroView2 != null) {
                i = R.id.micro_view3;
                MiddleItemMicroView middleItemMicroView3 = (MiddleItemMicroView) b.a(view, R.id.micro_view3);
                if (middleItemMicroView3 != null) {
                    i = R.id.micro_view4;
                    MiddleItemMicroView middleItemMicroView4 = (MiddleItemMicroView) b.a(view, R.id.micro_view4);
                    if (middleItemMicroView4 != null) {
                        i = R.id.micro_view5;
                        MiddleItemMicroView middleItemMicroView5 = (MiddleItemMicroView) b.a(view, R.id.micro_view5);
                        if (middleItemMicroView5 != null) {
                            return new ViewRoomMicroStyle5Binding((ConstraintLayout) view, middleItemMicroView, middleItemMicroView2, middleItemMicroView3, middleItemMicroView4, middleItemMicroView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewRoomMicroStyle5Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRoomMicroStyle5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_micro_style_5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
