package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LayoutSvipUserEnterGroupRoomBinding implements a {
    public final HiloImageView avatar;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٦٨id;
    private final LinearLayout rootView;
    public final TextView subContent;
    public final SVGAImageView svga;
    public final TextView userEnterRoom;

    private LayoutSvipUserEnterGroupRoomBinding(LinearLayout linearLayout, HiloImageView hiloImageView, TextView textView, TextView textView2, SVGAImageView sVGAImageView, TextView textView3) {
        this.rootView = linearLayout;
        this.avatar = hiloImageView;
        this.f٦٨id = textView;
        this.subContent = textView2;
        this.svga = sVGAImageView;
        this.userEnterRoom = textView3;
    }

    public static LayoutSvipUserEnterGroupRoomBinding bind(View view) {
        int i = 2131362013;
        HiloImageView a = b.a(view, 2131362013);
        if (a != null) {
            i = R.id.f١١id;
            TextView textView = (TextView) b.a(view, R.id.f١١id);
            if (textView != null) {
                i = R.id.subContent;
                TextView textView2 = (TextView) b.a(view, R.id.subContent);
                if (textView2 != null) {
                    i = 2131364958;
                    SVGAImageView a2 = b.a(view, 2131364958);
                    if (a2 != null) {
                        i = R.id.user_enter_room;
                        TextView textView3 = (TextView) b.a(view, R.id.user_enter_room);
                        if (textView3 != null) {
                            return new LayoutSvipUserEnterGroupRoomBinding((LinearLayout) view, a, textView, textView2, a2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutSvipUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSvipUserEnterGroupRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_svip_user_enter_group_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
