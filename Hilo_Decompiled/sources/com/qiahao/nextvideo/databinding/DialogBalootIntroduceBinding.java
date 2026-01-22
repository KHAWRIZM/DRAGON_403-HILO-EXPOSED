package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogBalootIntroduceBinding extends ViewDataBinding {
    public final TextView confirm;
    public final TextView direction;
    public final TextView directionText;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogBalootIntroduceBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.confirm = textView;
        this.direction = textView2;
        this.directionText = textView3;
    }

    public static DialogBalootIntroduceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogBalootIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogBalootIntroduceBinding bind(View view, Object obj) {
        return (DialogBalootIntroduceBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_baloot_introduce);
    }

    @Deprecated
    public static DialogBalootIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBalootIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_baloot_introduce, viewGroup, z, obj);
    }

    public static DialogBalootIntroduceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogBalootIntroduceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBalootIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_baloot_introduce, (ViewGroup) null, false, obj);
    }
}
