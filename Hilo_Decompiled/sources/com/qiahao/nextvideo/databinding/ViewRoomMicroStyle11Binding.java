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
public final class ViewRoomMicroStyle11Binding implements a {
    public final MiddleItemMicroView microView1;
    public final MiddleItemMicroView microView10;
    public final MiddleItemMicroView microView11;
    public final MiddleItemMicroView microView2;
    public final MiddleItemMicroView microView3;
    public final MiddleItemMicroView microView4;
    public final MiddleItemMicroView microView5;
    public final MiddleItemMicroView microView6;
    public final MiddleItemMicroView microView7;
    public final MiddleItemMicroView microView8;
    public final MiddleItemMicroView microView9;
    private final ConstraintLayout rootView;

    private ViewRoomMicroStyle11Binding(ConstraintLayout constraintLayout, MiddleItemMicroView middleItemMicroView, MiddleItemMicroView middleItemMicroView2, MiddleItemMicroView middleItemMicroView3, MiddleItemMicroView middleItemMicroView4, MiddleItemMicroView middleItemMicroView5, MiddleItemMicroView middleItemMicroView6, MiddleItemMicroView middleItemMicroView7, MiddleItemMicroView middleItemMicroView8, MiddleItemMicroView middleItemMicroView9, MiddleItemMicroView middleItemMicroView10, MiddleItemMicroView middleItemMicroView11) {
        this.rootView = constraintLayout;
        this.microView1 = middleItemMicroView;
        this.microView10 = middleItemMicroView2;
        this.microView11 = middleItemMicroView3;
        this.microView2 = middleItemMicroView4;
        this.microView3 = middleItemMicroView5;
        this.microView4 = middleItemMicroView6;
        this.microView5 = middleItemMicroView7;
        this.microView6 = middleItemMicroView8;
        this.microView7 = middleItemMicroView9;
        this.microView8 = middleItemMicroView10;
        this.microView9 = middleItemMicroView11;
    }

    public static ViewRoomMicroStyle11Binding bind(View view) {
        int i = R.id.micro_view1;
        MiddleItemMicroView middleItemMicroView = (MiddleItemMicroView) b.a(view, R.id.micro_view1);
        if (middleItemMicroView != null) {
            i = R.id.micro_view10;
            MiddleItemMicroView middleItemMicroView2 = (MiddleItemMicroView) b.a(view, R.id.micro_view10);
            if (middleItemMicroView2 != null) {
                i = R.id.micro_view11;
                MiddleItemMicroView middleItemMicroView3 = (MiddleItemMicroView) b.a(view, R.id.micro_view11);
                if (middleItemMicroView3 != null) {
                    i = R.id.micro_view2;
                    MiddleItemMicroView middleItemMicroView4 = (MiddleItemMicroView) b.a(view, R.id.micro_view2);
                    if (middleItemMicroView4 != null) {
                        i = R.id.micro_view3;
                        MiddleItemMicroView middleItemMicroView5 = (MiddleItemMicroView) b.a(view, R.id.micro_view3);
                        if (middleItemMicroView5 != null) {
                            i = R.id.micro_view4;
                            MiddleItemMicroView middleItemMicroView6 = (MiddleItemMicroView) b.a(view, R.id.micro_view4);
                            if (middleItemMicroView6 != null) {
                                i = R.id.micro_view5;
                                MiddleItemMicroView middleItemMicroView7 = (MiddleItemMicroView) b.a(view, R.id.micro_view5);
                                if (middleItemMicroView7 != null) {
                                    i = R.id.micro_view6;
                                    MiddleItemMicroView middleItemMicroView8 = (MiddleItemMicroView) b.a(view, R.id.micro_view6);
                                    if (middleItemMicroView8 != null) {
                                        i = R.id.micro_view7;
                                        MiddleItemMicroView middleItemMicroView9 = (MiddleItemMicroView) b.a(view, R.id.micro_view7);
                                        if (middleItemMicroView9 != null) {
                                            i = R.id.micro_view8;
                                            MiddleItemMicroView middleItemMicroView10 = (MiddleItemMicroView) b.a(view, R.id.micro_view8);
                                            if (middleItemMicroView10 != null) {
                                                i = R.id.micro_view9;
                                                MiddleItemMicroView middleItemMicroView11 = (MiddleItemMicroView) b.a(view, R.id.micro_view9);
                                                if (middleItemMicroView11 != null) {
                                                    return new ViewRoomMicroStyle11Binding((ConstraintLayout) view, middleItemMicroView, middleItemMicroView2, middleItemMicroView3, middleItemMicroView4, middleItemMicroView5, middleItemMicroView6, middleItemMicroView7, middleItemMicroView8, middleItemMicroView9, middleItemMicroView10, middleItemMicroView11);
                                                }
                                            }
                                        }
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

    public static ViewRoomMicroStyle11Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRoomMicroStyle11Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_micro_style_11, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
