package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.PageIndicator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentRoomBagBinding extends ViewDataBinding {
    public final PageIndicator pageIndicator;
    public final RecyclerView recyclerView;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRoomBagBinding(Object obj, View view, int i, PageIndicator pageIndicator, RecyclerView recyclerView, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.pageIndicator = pageIndicator;
        this.recyclerView = recyclerView;
        this.statusView = superStatusView;
    }

    public static FragmentRoomBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRoomBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentRoomBagBinding bind(View view, Object obj) {
        return (FragmentRoomBagBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_room_bag);
    }

    @Deprecated
    public static FragmentRoomBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRoomBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_bag, viewGroup, z, obj);
    }

    public static FragmentRoomBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRoomBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRoomBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_bag, (ViewGroup) null, false, obj);
    }
}
