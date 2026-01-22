package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.PKMicroView;
import com.qiahao.nextvideo.view.PKButtonView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGamePkBinding extends ViewDataBinding {
    public final IncludePkGoBinding blueGo;
    public final ImageView blueMic;
    public final PKButtonView button;
    public final PKMicroView leftMic;
    public final IncludePkGoBinding redGo;
    public final ImageView redMic;
    public final PKMicroView rightMic;
    public final TextView time;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGamePkBinding(Object obj, View view, int i, IncludePkGoBinding includePkGoBinding, ImageView imageView, PKButtonView pKButtonView, PKMicroView pKMicroView, IncludePkGoBinding includePkGoBinding2, ImageView imageView2, PKMicroView pKMicroView2, TextView textView) {
        super(obj, view, i);
        this.blueGo = includePkGoBinding;
        this.blueMic = imageView;
        this.button = pKButtonView;
        this.leftMic = pKMicroView;
        this.redGo = includePkGoBinding2;
        this.redMic = imageView2;
        this.rightMic = pKMicroView2;
        this.time = textView;
    }

    public static ViewGamePkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGamePkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGamePkBinding bind(View view, Object obj) {
        return (ViewGamePkBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_pk);
    }

    @Deprecated
    public static ViewGamePkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGamePkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_pk, viewGroup, z, obj);
    }

    public static ViewGamePkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGamePkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGamePkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_pk, (ViewGroup) null, false, obj);
    }
}
