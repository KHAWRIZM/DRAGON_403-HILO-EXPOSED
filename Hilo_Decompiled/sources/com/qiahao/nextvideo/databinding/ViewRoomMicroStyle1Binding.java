package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewRoomMicroStyle1Binding implements a {
    private final ConstraintLayout rootView;

    private ViewRoomMicroStyle1Binding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public static ViewRoomMicroStyle1Binding bind(View view) {
        if (view != null) {
            return new ViewRoomMicroStyle1Binding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ViewRoomMicroStyle1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRoomMicroStyle1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_micro_style_1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
