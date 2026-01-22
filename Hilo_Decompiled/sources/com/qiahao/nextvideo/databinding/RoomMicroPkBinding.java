package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.PKItemMicroView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomMicroPkBinding extends ViewDataBinding {
    public final PKItemMicroView microView1;
    public final PKItemMicroView microView10;
    public final PKItemMicroView microView2;
    public final PKItemMicroView microView3;
    public final PKItemMicroView microView4;
    public final PKItemMicroView microView5;
    public final PKItemMicroView microView6;
    public final PKItemMicroView microView7;
    public final PKItemMicroView microView8;
    public final PKItemMicroView microView9;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomMicroPkBinding(Object obj, View view, int i, PKItemMicroView pKItemMicroView, PKItemMicroView pKItemMicroView2, PKItemMicroView pKItemMicroView3, PKItemMicroView pKItemMicroView4, PKItemMicroView pKItemMicroView5, PKItemMicroView pKItemMicroView6, PKItemMicroView pKItemMicroView7, PKItemMicroView pKItemMicroView8, PKItemMicroView pKItemMicroView9, PKItemMicroView pKItemMicroView10) {
        super(obj, view, i);
        this.microView1 = pKItemMicroView;
        this.microView10 = pKItemMicroView2;
        this.microView2 = pKItemMicroView3;
        this.microView3 = pKItemMicroView4;
        this.microView4 = pKItemMicroView5;
        this.microView5 = pKItemMicroView6;
        this.microView6 = pKItemMicroView7;
        this.microView7 = pKItemMicroView8;
        this.microView8 = pKItemMicroView9;
        this.microView9 = pKItemMicroView10;
    }

    public static RoomMicroPkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomMicroPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomMicroPkBinding bind(View view, Object obj) {
        return (RoomMicroPkBinding) ViewDataBinding.bind(obj, view, R.layout.room_micro_pk);
    }

    @Deprecated
    public static RoomMicroPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomMicroPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_micro_pk, viewGroup, z, obj);
    }

    public static RoomMicroPkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomMicroPkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomMicroPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_micro_pk, (ViewGroup) null, false, obj);
    }
}
