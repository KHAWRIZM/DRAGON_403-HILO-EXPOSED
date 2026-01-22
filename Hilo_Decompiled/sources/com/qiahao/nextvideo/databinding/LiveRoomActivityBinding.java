package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LiveRoomActivityBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    public LiveRoomActivityBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
    }

    public static LiveRoomActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LiveRoomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LiveRoomActivityBinding bind(View view, Object obj) {
        return (LiveRoomActivityBinding) ViewDataBinding.bind(obj, view, R.layout.live_room_activity);
    }

    @Deprecated
    public static LiveRoomActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LiveRoomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.live_room_activity, viewGroup, z, obj);
    }

    public static LiveRoomActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LiveRoomActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LiveRoomActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.live_room_activity, (ViewGroup) null, false, obj);
    }
}
