package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewRoomRocketEnterBinding extends ViewDataBinding {
    public final ImageView imgRocket;
    public final ProgressBar progressBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewRoomRocketEnterBinding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar) {
        super(obj, view, i);
        this.imgRocket = imageView;
        this.progressBar = progressBar;
    }

    public static ViewRoomRocketEnterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewRoomRocketEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewRoomRocketEnterBinding bind(View view, Object obj) {
        return (ViewRoomRocketEnterBinding) ViewDataBinding.bind(obj, view, R.layout.view_room_rocket_enter);
    }

    @Deprecated
    public static ViewRoomRocketEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewRoomRocketEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_room_rocket_enter, viewGroup, z, obj);
    }

    public static ViewRoomRocketEnterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewRoomRocketEnterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewRoomRocketEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_room_rocket_enter, (ViewGroup) null, false, obj);
    }
}
