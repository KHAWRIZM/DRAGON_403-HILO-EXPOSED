package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomRecordBinding extends ViewDataBinding {
    public final TextView adminName;
    public final QMUIRadiusImageView avatar;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٦٥id;
    public final View line;
    public final TextView name;
    public final TextView time;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomRecordBinding(Object obj, View view, int i, TextView textView, QMUIRadiusImageView qMUIRadiusImageView, TextView textView2, View view2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.adminName = textView;
        this.avatar = qMUIRadiusImageView;
        this.f٦٥id = textView2;
        this.line = view2;
        this.name = textView3;
        this.time = textView4;
    }

    public static ItemRoomRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomRecordBinding bind(View view, Object obj) {
        return (ItemRoomRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_record);
    }

    @Deprecated
    public static ItemRoomRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_record, viewGroup, z, obj);
    }

    public static ItemRoomRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_record, (ViewGroup) null, false, obj);
    }
}
