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
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentRoomAndPersonalBinding extends ViewDataBinding {
    public final BaseStatusEmptyBinding emptyView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final RecyclerView taskRv;
    public final TextView tvTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRoomAndPersonalBinding(Object obj, View view, int i, BaseStatusEmptyBinding baseStatusEmptyBinding, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.emptyView = baseStatusEmptyBinding;
        this.smartRefreshLayout = smartRefreshLayout;
        this.taskRv = recyclerView;
        this.tvTime = textView;
    }

    public static FragmentRoomAndPersonalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRoomAndPersonalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentRoomAndPersonalBinding bind(View view, Object obj) {
        return (FragmentRoomAndPersonalBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_room_and_personal);
    }

    @Deprecated
    public static FragmentRoomAndPersonalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRoomAndPersonalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_and_personal, viewGroup, z, obj);
    }

    public static FragmentRoomAndPersonalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRoomAndPersonalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRoomAndPersonalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_and_personal, (ViewGroup) null, false, obj);
    }
}
