package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogImCleanMessageBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView delete;
    protected View.OnClickListener mClick;
    public final TextView markRead;
    public final View markReadView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogImCleanMessageBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.cancel = textView;
        this.delete = textView2;
        this.markRead = textView3;
        this.markReadView = view2;
    }

    public static DialogImCleanMessageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogImCleanMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogImCleanMessageBinding bind(View view, Object obj) {
        return (DialogImCleanMessageBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_im_clean_message);
    }

    @Deprecated
    public static DialogImCleanMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogImCleanMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_im_clean_message, viewGroup, z, obj);
    }

    public static DialogImCleanMessageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogImCleanMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogImCleanMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_im_clean_message, (ViewGroup) null, false, obj);
    }
}
