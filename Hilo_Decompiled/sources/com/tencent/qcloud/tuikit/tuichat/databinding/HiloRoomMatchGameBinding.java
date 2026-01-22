package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomMatchGameBinding extends ViewDataBinding {
    public final TextView content;
    public final ImageView gameImage;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomMatchGameBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.content = textView;
        this.gameImage = imageView;
        this.image = imageView2;
    }

    public static HiloRoomMatchGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomMatchGameBinding bind(View view, Object obj) {
        return (HiloRoomMatchGameBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_match_game);
    }

    @Deprecated
    public static HiloRoomMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_match_game, viewGroup, z, obj);
    }

    public static HiloRoomMatchGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomMatchGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_match_game, (ViewGroup) null, false, obj);
    }
}
