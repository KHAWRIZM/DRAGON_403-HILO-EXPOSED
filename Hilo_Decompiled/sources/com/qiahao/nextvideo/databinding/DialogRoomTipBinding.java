package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomTipBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomTipBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
    }

    public static DialogRoomTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomTipBinding bind(View view, Object obj) {
        return (DialogRoomTipBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_tip);
    }

    @Deprecated
    public static DialogRoomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_tip, viewGroup, z, obj);
    }

    public static DialogRoomTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_tip, (ViewGroup) null, false, obj);
    }
}
