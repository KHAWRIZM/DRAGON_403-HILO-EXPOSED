package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomActivityBinding extends ViewDataBinding {
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

    public RoomCustomActivityBinding(Object obj, View view, int i10, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, AppCompatTextView appCompatTextView, ImageView imageView3, LinearLayout linearLayout2, AppCompatTextView appCompatTextView2, ImageView imageView4, AppCompatTextView appCompatTextView3) {
        super(obj, view, i10);
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

    public static RoomCustomActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomActivityBinding bind(View view, Object obj) {
        return (RoomCustomActivityBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_activity);
    }

    @Deprecated
    public static RoomCustomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_activity, viewGroup, z10, obj);
    }

    public static RoomCustomActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_activity, null, false, obj);
    }
}
