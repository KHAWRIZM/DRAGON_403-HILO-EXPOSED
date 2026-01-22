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
public abstract class DialogVideoInstructionsBinding extends ViewDataBinding {
    public final TextView confirm;
    public final AppCompatTextView content1;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogVideoInstructionsBinding(Object obj, View view, int i, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.confirm = textView;
        this.content1 = appCompatTextView;
        this.title = appCompatTextView2;
    }

    public static DialogVideoInstructionsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogVideoInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogVideoInstructionsBinding bind(View view, Object obj) {
        return (DialogVideoInstructionsBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_video_instructions);
    }

    @Deprecated
    public static DialogVideoInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogVideoInstructionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_video_instructions, viewGroup, z, obj);
    }

    public static DialogVideoInstructionsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogVideoInstructionsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogVideoInstructionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_video_instructions, (ViewGroup) null, false, obj);
    }
}
