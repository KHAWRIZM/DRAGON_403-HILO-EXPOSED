package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomUserEnterBinding extends ViewDataBinding {
    public final TextView contentText;
    public final NickTextView nick;

    public RoomCustomUserEnterBinding(Object obj, View view, int i10, TextView textView, NickTextView nickTextView) {
        super(obj, view, i10);
        this.contentText = textView;
        this.nick = nickTextView;
    }

    public static RoomCustomUserEnterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomUserEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomUserEnterBinding bind(View view, Object obj) {
        return (RoomCustomUserEnterBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_user_enter);
    }

    @Deprecated
    public static RoomCustomUserEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomUserEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_user_enter, viewGroup, z10, obj);
    }

    public static RoomCustomUserEnterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomUserEnterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomUserEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_user_enter, null, false, obj);
    }
}
