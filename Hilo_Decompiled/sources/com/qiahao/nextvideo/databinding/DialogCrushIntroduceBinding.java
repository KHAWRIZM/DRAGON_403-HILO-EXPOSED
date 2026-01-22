package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCrushIntroduceBinding extends ViewDataBinding {
    public final TextView confirm;
    public final TextView direction;
    public final TextView directionText;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCrushIntroduceBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.confirm = textView;
        this.direction = textView2;
        this.directionText = textView3;
    }

    public static DialogCrushIntroduceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCrushIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCrushIntroduceBinding bind(View view, Object obj) {
        return (DialogCrushIntroduceBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_crush_introduce);
    }

    @Deprecated
    public static DialogCrushIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCrushIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_crush_introduce, viewGroup, z, obj);
    }

    public static DialogCrushIntroduceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCrushIntroduceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCrushIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_crush_introduce, (ViewGroup) null, false, obj);
    }
}
