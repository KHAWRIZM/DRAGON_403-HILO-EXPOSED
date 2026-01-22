package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMicOperateClickBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView lockMute;
    public final View lockMuteLine;
    public final View lockTheMicLine;
    protected View.OnClickListener mClick;
    public final TextView takeTheMic;
    public final TextView theMic;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMicOperateClickBinding(Object obj, View view, int i, TextView textView, TextView textView2, View view2, View view3, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.cancel = textView;
        this.lockMute = textView2;
        this.lockMuteLine = view2;
        this.lockTheMicLine = view3;
        this.takeTheMic = textView3;
        this.theMic = textView4;
    }

    public static DialogMicOperateClickBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMicOperateClickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogMicOperateClickBinding bind(View view, Object obj) {
        return (DialogMicOperateClickBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_mic_operate_click);
    }

    @Deprecated
    public static DialogMicOperateClickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMicOperateClickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_mic_operate_click, viewGroup, z, obj);
    }

    public static DialogMicOperateClickBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMicOperateClickBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMicOperateClickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_mic_operate_click, (ViewGroup) null, false, obj);
    }
}
