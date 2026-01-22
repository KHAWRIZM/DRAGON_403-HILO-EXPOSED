package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class DialogImMessageClickBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView copy;
    public final TextView delete;
    public final View deleteView;
    protected View.OnClickListener mClick;
    public final TextView revocation;
    public final View revocationView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogImMessageClickBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2, TextView textView4, View view3) {
        super(obj, view, i);
        this.cancel = textView;
        this.copy = textView2;
        this.delete = textView3;
        this.deleteView = view2;
        this.revocation = textView4;
        this.revocationView = view3;
    }

    public static DialogImMessageClickBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogImMessageClickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogImMessageClickBinding bind(View view, Object obj) {
        return (DialogImMessageClickBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_im_message_click);
    }

    @Deprecated
    public static DialogImMessageClickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogImMessageClickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_im_message_click, viewGroup, z, obj);
    }

    public static DialogImMessageClickBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogImMessageClickBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogImMessageClickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_im_message_click, (ViewGroup) null, false, obj);
    }
}
