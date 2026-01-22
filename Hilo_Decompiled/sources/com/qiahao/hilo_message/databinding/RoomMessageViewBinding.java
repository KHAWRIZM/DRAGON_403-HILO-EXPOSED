package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.hilo_message.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomMessageViewBinding implements a {
    public final TextView all;
    public final TextView chat;
    public final RoomInputView chatInputLayout;
    public final FrameLayout chatTopView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private RoomMessageViewBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, RoomInputView roomInputView, FrameLayout frameLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.all = textView;
        this.chat = textView2;
        this.chatInputLayout = roomInputView;
        this.chatTopView = frameLayout;
        this.recyclerView = recyclerView;
    }

    public static RoomMessageViewBinding bind(View view) {
        RoomInputView a10;
        int i10 = R.id.all;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.chat;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null && (a10 = b.a(view, (i10 = R.id.chatInputLayout))) != null) {
                i10 = R.id.chatTopView;
                FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
                if (frameLayout != null) {
                    i10 = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                    if (recyclerView != null) {
                        return new RoomMessageViewBinding((ConstraintLayout) view, textView, textView2, a10, frameLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static RoomMessageViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RoomMessageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.room_message_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
