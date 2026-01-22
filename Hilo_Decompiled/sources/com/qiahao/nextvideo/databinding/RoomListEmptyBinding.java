package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomListEmptyBinding extends ViewDataBinding {
    public final ImageView emptyImage;
    public final TextView emptyText;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomListEmptyBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.emptyImage = imageView;
        this.emptyText = textView;
    }

    public static RoomListEmptyBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomListEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomListEmptyBinding bind(View view, Object obj) {
        return (RoomListEmptyBinding) ViewDataBinding.bind(obj, view, R.layout.room_list_empty);
    }

    @Deprecated
    public static RoomListEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomListEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_list_empty, viewGroup, z, obj);
    }

    public static RoomListEmptyBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomListEmptyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomListEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_list_empty, (ViewGroup) null, false, obj);
    }
}
