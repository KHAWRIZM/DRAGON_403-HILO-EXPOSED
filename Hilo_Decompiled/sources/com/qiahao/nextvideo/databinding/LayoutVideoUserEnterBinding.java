package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LayoutVideoUserEnterBinding implements a {
    public final LightQueueCombinationPlayer queuePlayer;
    private final LinearLayout rootView;
    public final TextView userEnterRoom;

    private LayoutVideoUserEnterBinding(LinearLayout linearLayout, LightQueueCombinationPlayer lightQueueCombinationPlayer, TextView textView) {
        this.rootView = linearLayout;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.userEnterRoom = textView;
    }

    public static LayoutVideoUserEnterBinding bind(View view) {
        int i = R.id.queuePlayer;
        LightQueueCombinationPlayer a = b.a(view, R.id.queuePlayer);
        if (a != null) {
            i = R.id.user_enter_room;
            TextView textView = (TextView) b.a(view, R.id.user_enter_room);
            if (textView != null) {
                return new LayoutVideoUserEnterBinding((LinearLayout) view, a, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutVideoUserEnterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutVideoUserEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_video_user_enter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
