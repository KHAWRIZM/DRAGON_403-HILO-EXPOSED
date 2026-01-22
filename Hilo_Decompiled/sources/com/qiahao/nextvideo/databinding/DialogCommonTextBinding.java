package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCommonTextBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final TextView confirmButton;
    public final TextView contentText;
    protected View.OnClickListener mClick;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCommonTextBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.confirmButton = textView2;
        this.contentText = textView3;
    }

    public static DialogCommonTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCommonTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCommonTextBinding bind(View view, Object obj) {
        return (DialogCommonTextBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_common_text);
    }

    @Deprecated
    public static DialogCommonTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCommonTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_text, viewGroup, z, obj);
    }

    public static DialogCommonTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCommonTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCommonTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_text, (ViewGroup) null, false, obj);
    }
}
