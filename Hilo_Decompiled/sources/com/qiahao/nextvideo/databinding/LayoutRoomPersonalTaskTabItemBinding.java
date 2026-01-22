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
public abstract class LayoutRoomPersonalTaskTabItemBinding extends ViewDataBinding {
    public final ImageView bg;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutRoomPersonalTaskTabItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.bg = imageView;
        this.title = textView;
    }

    public static LayoutRoomPersonalTaskTabItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutRoomPersonalTaskTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutRoomPersonalTaskTabItemBinding bind(View view, Object obj) {
        return (LayoutRoomPersonalTaskTabItemBinding) ViewDataBinding.bind(obj, view, R.layout.layout_room_personal_task_tab_item);
    }

    @Deprecated
    public static LayoutRoomPersonalTaskTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutRoomPersonalTaskTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_room_personal_task_tab_item, viewGroup, z, obj);
    }

    public static LayoutRoomPersonalTaskTabItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutRoomPersonalTaskTabItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutRoomPersonalTaskTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_room_personal_task_tab_item, (ViewGroup) null, false, obj);
    }
}
