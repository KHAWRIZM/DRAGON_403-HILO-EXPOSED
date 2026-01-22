package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomGameBinding extends ViewDataBinding {
    public final RecyclerView luckyRecyclerView;
    public final TextView luckyTitle;
    public final RecyclerView partyRecyclerView;
    public final TextView partyTitle;
    public final RecyclerView togetherRecyclerView;
    public final TextView togetherTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomGameBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView, RecyclerView recyclerView2, TextView textView2, RecyclerView recyclerView3, TextView textView3) {
        super(obj, view, i);
        this.luckyRecyclerView = recyclerView;
        this.luckyTitle = textView;
        this.partyRecyclerView = recyclerView2;
        this.partyTitle = textView2;
        this.togetherRecyclerView = recyclerView3;
        this.togetherTitle = textView3;
    }

    public static DialogRoomGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomGameBinding bind(View view, Object obj) {
        return (DialogRoomGameBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_game);
    }

    @Deprecated
    public static DialogRoomGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_game, viewGroup, z, obj);
    }

    public static DialogRoomGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_game, (ViewGroup) null, false, obj);
    }
}
