package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomActivityBinding extends ViewDataBinding {
    public final ImageView image;
    public final LinearLayout interested;
    public final ImageView interestedImage;
    public final TextView interestedText;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final AppCompatTextView timeContent;
    public final ImageView timeImage;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomActivityBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, AppCompatTextView appCompatTextView, ImageView imageView3, LinearLayout linearLayout2, AppCompatTextView appCompatTextView2, ImageView imageView4, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.image = imageView;
        this.interested = linearLayout;
        this.interestedImage = imageView2;
        this.interestedText = textView;
        this.stateContent = appCompatTextView;
        this.stateImage = imageView3;
        this.stateLayout = linearLayout2;
        this.timeContent = appCompatTextView2;
        this.timeImage = imageView4;
        this.title = appCompatTextView3;
    }

    public static HiloRoomActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomActivityBinding bind(View view, Object obj) {
        return (HiloRoomActivityBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_activity);
    }

    @Deprecated
    public static HiloRoomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_activity, viewGroup, z, obj);
    }

    public static HiloRoomActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_activity, (ViewGroup) null, false, obj);
    }
}
