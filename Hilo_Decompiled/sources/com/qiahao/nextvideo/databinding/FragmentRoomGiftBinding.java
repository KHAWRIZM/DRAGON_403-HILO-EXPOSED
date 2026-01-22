package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentRoomGiftBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRoomGiftBinding(Object obj, View view, int i, RecyclerView recyclerView, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.statusView = superStatusView;
    }

    public static FragmentRoomGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentRoomGiftBinding bind(View view, Object obj) {
        return (FragmentRoomGiftBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_room_gift);
    }

    @Deprecated
    public static FragmentRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_gift, viewGroup, z, obj);
    }

    public static FragmentRoomGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRoomGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_gift, (ViewGroup) null, false, obj);
    }
}
