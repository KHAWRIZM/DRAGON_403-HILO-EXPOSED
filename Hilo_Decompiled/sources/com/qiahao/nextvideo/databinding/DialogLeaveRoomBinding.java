package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLeaveRoomBinding extends ViewDataBinding {
    public final ConstraintLayout bgRoot;
    public final ImageView close;
    public final TextView closeText;
    public final LinearLayout lineLayout1;
    public final LinearLayout lineLayout2;
    public final ImageView small;
    public final TextView smallText;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLeaveRoomBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.bgRoot = constraintLayout;
        this.close = imageView;
        this.closeText = textView;
        this.lineLayout1 = linearLayout;
        this.lineLayout2 = linearLayout2;
        this.small = imageView2;
        this.smallText = textView2;
    }

    public static DialogLeaveRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLeaveRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogLeaveRoomBinding bind(View view, Object obj) {
        return (DialogLeaveRoomBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_leave_room);
    }

    @Deprecated
    public static DialogLeaveRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLeaveRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_leave_room, viewGroup, z, obj);
    }

    public static DialogLeaveRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLeaveRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLeaveRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_leave_room, (ViewGroup) null, false, obj);
    }
}
