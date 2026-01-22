package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewRoomGameBinding extends ViewDataBinding {
    public final ImageView add;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final ConstraintLayout gameTitleLayout;
    public final FrameLayout gameView;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final ImageView sound;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewRoomGameBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView4, ConstraintLayout constraintLayout2, ImageView imageView5) {
        super(obj, view, i);
        this.add = imageView;
        this.diamond = imageView2;
        this.diamondText = textView;
        this.diamondTwo = imageView3;
        this.gameTitleLayout = constraintLayout;
        this.gameView = frameLayout;
        this.information = imageView4;
        this.moneyLayout = constraintLayout2;
        this.sound = imageView5;
    }

    public static ViewRoomGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewRoomGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewRoomGameBinding bind(View view, Object obj) {
        return (ViewRoomGameBinding) ViewDataBinding.bind(obj, view, R.layout.view_room_game);
    }

    @Deprecated
    public static ViewRoomGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewRoomGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_room_game, viewGroup, z, obj);
    }

    public static ViewRoomGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewRoomGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewRoomGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_room_game, (ViewGroup) null, false, obj);
    }
}
