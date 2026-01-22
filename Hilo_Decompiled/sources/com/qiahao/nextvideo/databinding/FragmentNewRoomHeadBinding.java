package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentNewRoomHeadBinding extends ViewDataBinding {
    public final BaseStatusEmptyBinding empty;
    public final TextView newRoom;
    public final TextView newUser;
    public final RecyclerView newUserRecyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentNewRoomHeadBinding(Object obj, View view, int i, BaseStatusEmptyBinding baseStatusEmptyBinding, TextView textView, TextView textView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.empty = baseStatusEmptyBinding;
        this.newRoom = textView;
        this.newUser = textView2;
        this.newUserRecyclerView = recyclerView;
    }

    public static FragmentNewRoomHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentNewRoomHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentNewRoomHeadBinding bind(View view, Object obj) {
        return (FragmentNewRoomHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_new_room_head);
    }

    @Deprecated
    public static FragmentNewRoomHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentNewRoomHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_new_room_head, viewGroup, z, obj);
    }

    public static FragmentNewRoomHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentNewRoomHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentNewRoomHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_new_room_head, (ViewGroup) null, false, obj);
    }
}
