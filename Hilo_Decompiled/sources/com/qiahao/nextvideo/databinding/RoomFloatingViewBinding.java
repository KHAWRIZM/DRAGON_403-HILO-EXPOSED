package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.RotateAnimationView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomFloatingViewBinding extends ViewDataBinding {
    public final CircleImageView avatarCircleImageView;
    public final AppCompatTextView currentStateTextView;
    public final AppCompatImageView dismissImageView;
    public final RotateAnimationView rotateAnimationView;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomFloatingViewBinding(Object obj, View view, int i, CircleImageView circleImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, RotateAnimationView rotateAnimationView) {
        super(obj, view, i);
        this.avatarCircleImageView = circleImageView;
        this.currentStateTextView = appCompatTextView;
        this.dismissImageView = appCompatImageView;
        this.rotateAnimationView = rotateAnimationView;
    }

    public static RoomFloatingViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomFloatingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomFloatingViewBinding bind(View view, Object obj) {
        return (RoomFloatingViewBinding) ViewDataBinding.bind(obj, view, R.layout.room_floating_view);
    }

    @Deprecated
    public static RoomFloatingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomFloatingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_floating_view, viewGroup, z, obj);
    }

    public static RoomFloatingViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomFloatingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomFloatingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_floating_view, (ViewGroup) null, false, obj);
    }
}
