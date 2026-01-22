package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeTransferTextBinding extends ViewDataBinding {
    public final TextView number;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeTransferTextBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.number = textView;
        this.title = textView2;
    }

    public static IncludeTransferTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeTransferTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeTransferTextBinding bind(View view, Object obj) {
        return (IncludeTransferTextBinding) ViewDataBinding.bind(obj, view, R.layout.include_transfer_text);
    }

    @Deprecated
    public static IncludeTransferTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeTransferTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_transfer_text, viewGroup, z, obj);
    }

    public static IncludeTransferTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeTransferTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeTransferTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_transfer_text, (ViewGroup) null, false, obj);
    }
}
