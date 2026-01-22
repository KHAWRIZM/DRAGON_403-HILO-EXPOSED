package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.GameItemMicroView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomMicroGameBinding extends ViewDataBinding {
    public final ImageView centerImg;
    public final GameItemMicroView microView1;
    public final GameItemMicroView microView2;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomMicroGameBinding(Object obj, View view, int i, ImageView imageView, GameItemMicroView gameItemMicroView, GameItemMicroView gameItemMicroView2) {
        super(obj, view, i);
        this.centerImg = imageView;
        this.microView1 = gameItemMicroView;
        this.microView2 = gameItemMicroView2;
    }

    public static RoomMicroGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomMicroGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomMicroGameBinding bind(View view, Object obj) {
        return (RoomMicroGameBinding) ViewDataBinding.bind(obj, view, R.layout.room_micro_game);
    }

    @Deprecated
    public static RoomMicroGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomMicroGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_micro_game, viewGroup, z, obj);
    }

    public static RoomMicroGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomMicroGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomMicroGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_micro_game, (ViewGroup) null, false, obj);
    }
}
