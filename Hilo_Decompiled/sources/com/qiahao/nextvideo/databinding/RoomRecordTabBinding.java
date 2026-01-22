package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomRecordTabBinding extends ViewDataBinding {
    public final View bg;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomRecordTabBinding(Object obj, View view, int i, View view2, TextView textView) {
        super(obj, view, i);
        this.bg = view2;
        this.title = textView;
    }

    public static RoomRecordTabBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomRecordTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomRecordTabBinding bind(View view, Object obj) {
        return (RoomRecordTabBinding) ViewDataBinding.bind(obj, view, R.layout.room_record_tab);
    }

    @Deprecated
    public static RoomRecordTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomRecordTabBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_record_tab, viewGroup, z, obj);
    }

    public static RoomRecordTabBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomRecordTabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomRecordTabBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_record_tab, (ViewGroup) null, false, obj);
    }
}
