package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomUserEnterBinding extends ViewDataBinding {
    public final TextView contentText;
    public final NickTextView nick;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomUserEnterBinding(Object obj, View view, int i, TextView textView, NickTextView nickTextView) {
        super(obj, view, i);
        this.contentText = textView;
        this.nick = nickTextView;
    }

    public static HiloRoomUserEnterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomUserEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomUserEnterBinding bind(View view, Object obj) {
        return (HiloRoomUserEnterBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_user_enter);
    }

    @Deprecated
    public static HiloRoomUserEnterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomUserEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_user_enter, viewGroup, z, obj);
    }

    public static HiloRoomUserEnterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomUserEnterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomUserEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_user_enter, (ViewGroup) null, false, obj);
    }
}
