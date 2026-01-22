package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogSendGroupBroadcastBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final TextView confirmButton;
    public final EditText etContent;
    protected View.OnClickListener mClick;
    protected Integer mNumber;
    public final TextView textNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSendGroupBroadcastBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, EditText editText, TextView textView3) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.confirmButton = textView2;
        this.etContent = editText;
        this.textNumber = textView3;
    }

    public static DialogSendGroupBroadcastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogSendGroupBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Integer getNumber() {
        return this.mNumber;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setNumber(Integer num);

    @Deprecated
    public static DialogSendGroupBroadcastBinding bind(View view, Object obj) {
        return (DialogSendGroupBroadcastBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_send_group_broadcast);
    }

    @Deprecated
    public static DialogSendGroupBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSendGroupBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_send_group_broadcast, viewGroup, z, obj);
    }

    public static DialogSendGroupBroadcastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogSendGroupBroadcastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSendGroupBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_send_group_broadcast, (ViewGroup) null, false, obj);
    }
}
