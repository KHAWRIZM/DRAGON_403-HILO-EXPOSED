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
public final class ViewRoomMicroStyle8Binding implements a {
    public final MiddleItemMicroView microView1;
    public final MiddleItemMicroView microView2;
    public final MiddleItemMicroView microView3;
    public final MiddleItemMicroView microView4;
    public final MiddleItemMicroView microView5;
    public final MiddleItemMicroView microView6;
    public final MiddleItemMicroView microView7;
    public final MiddleItemMicroView microView8;
    private final ConstraintLayout rootView;

    private ViewRoomMicroStyle8Binding(ConstraintLayout constraintLayout, MiddleItemMicroView middleItemMicroView, MiddleItemMicroView middleItemMicroView2, MiddleItemMicroView middleItemMicroView3, MiddleItemMicroView middleItemMicroView4, MiddleItemMicroView middleItemMicroView5, MiddleItemMicroView middleItemMicroView6, MiddleItemMicroView middleItemMicroView7, MiddleItemMicroView middleItemMicroView8) {
        this.rootView = constraintLayout;
        this.microView1 = middleItemMicroView;
        this.microView2 = middleItemMicroView2;
        this.microView3 = middleItemMicroView3;
        this.microView4 = middleItemMicroView4;
        this.microView5 = middleItemMicroView5;
        this.microView6 = middleItemMicroView6;
        this.microView7 = middleItemMicroView7;
        this.microView8 = middleItemMicroView8;
    }

    public static ViewRoomMicroStyle8Binding bind(View view) {
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
                            i = R.id.micro_view6;
                            MiddleItemMicroView middleItemMicroView6 = (MiddleItemMicroView) b.a(view, R.id.micro_view6);
                            if (middleItemMicroView6 != null) {
                                i = R.id.micro_view7;
                                MiddleItemMicroView middleItemMicroView7 = (MiddleItemMicroView) b.a(view, R.id.micro_view7);
                                if (middleItemMicroView7 != null) {
                                    i = R.id.micro_view8;
                                    MiddleItemMicroView middleItemMicroView8 = (MiddleItemMicroView) b.a(view, R.id.micro_view8);
                                    if (middleItemMicroView8 != null) {
                                        return new ViewRoomMicroStyle8Binding((ConstraintLayout) view, middleItemMicroView, middleItemMicroView2, middleItemMicroView3, middleItemMicroView4, middleItemMicroView5, middleItemMicroView6, middleItemMicroView7, middleItemMicroView8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewRoomMicroStyle8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRoomMicroStyle8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_micro_style_8, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
