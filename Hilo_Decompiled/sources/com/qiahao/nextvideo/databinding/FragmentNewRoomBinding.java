package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentNewRoomBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final View topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentNewRoomBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, View view2) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.topBg = view2;
    }

    public static FragmentNewRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentNewRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentNewRoomBinding bind(View view, Object obj) {
        return (FragmentNewRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_new_room);
    }

    @Deprecated
    public static FragmentNewRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentNewRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_new_room, viewGroup, z, obj);
    }

    public static FragmentNewRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentNewRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentNewRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_new_room, (ViewGroup) null, false, obj);
    }
}
