package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomViewContactWrapperBinding extends ViewDataBinding {
    public final DialogMessageListBinding content;
    public final ConstraintLayout title;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomViewContactWrapperBinding(Object obj, View view, int i, DialogMessageListBinding dialogMessageListBinding, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.content = dialogMessageListBinding;
        this.title = constraintLayout;
    }

    public static RoomViewContactWrapperBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomViewContactWrapperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomViewContactWrapperBinding bind(View view, Object obj) {
        return (RoomViewContactWrapperBinding) ViewDataBinding.bind(obj, view, R.layout.room_view_contact_wrapper);
    }

    @Deprecated
    public static RoomViewContactWrapperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomViewContactWrapperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_view_contact_wrapper, viewGroup, z, obj);
    }

    public static RoomViewContactWrapperBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomViewContactWrapperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomViewContactWrapperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_view_contact_wrapper, (ViewGroup) null, false, obj);
    }
}
