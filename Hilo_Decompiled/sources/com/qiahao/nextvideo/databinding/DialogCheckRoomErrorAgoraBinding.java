package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCheckRoomErrorAgoraBinding extends ViewDataBinding {
    public final TextView clearAgoraId;
    public final TextView collectAgoraId;
    public final TextView getAgoraIdUserInfo;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerCurrentAgoraId;
    public final RecyclerView recyclerCurrentUserInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCheckRoomErrorAgoraBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.clearAgoraId = textView;
        this.collectAgoraId = textView2;
        this.getAgoraIdUserInfo = textView3;
        this.recyclerCurrentAgoraId = recyclerView;
        this.recyclerCurrentUserInfo = recyclerView2;
    }

    public static DialogCheckRoomErrorAgoraBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCheckRoomErrorAgoraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCheckRoomErrorAgoraBinding bind(View view, Object obj) {
        return (DialogCheckRoomErrorAgoraBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_check_room_error_agora);
    }

    @Deprecated
    public static DialogCheckRoomErrorAgoraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCheckRoomErrorAgoraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_check_room_error_agora, viewGroup, z, obj);
    }

    public static DialogCheckRoomErrorAgoraBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCheckRoomErrorAgoraBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCheckRoomErrorAgoraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_check_room_error_agora, (ViewGroup) null, false, obj);
    }
}
