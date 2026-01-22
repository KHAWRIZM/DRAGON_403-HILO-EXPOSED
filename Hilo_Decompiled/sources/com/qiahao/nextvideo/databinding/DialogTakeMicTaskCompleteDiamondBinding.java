package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogTakeMicTaskCompleteDiamondBinding extends ViewDataBinding {
    public final ImageView close;
    public final TextView diamond;
    public final ImageView diamondDay;
    public final ImageView light2;
    public final TextView okButton;
    public final TextView tip1;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogTakeMicTaskCompleteDiamondBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.close = imageView;
        this.diamond = textView;
        this.diamondDay = imageView2;
        this.light2 = imageView3;
        this.okButton = textView2;
        this.tip1 = textView3;
    }

    public static DialogTakeMicTaskCompleteDiamondBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogTakeMicTaskCompleteDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogTakeMicTaskCompleteDiamondBinding bind(View view, Object obj) {
        return (DialogTakeMicTaskCompleteDiamondBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_take_mic_task_complete_diamond);
    }

    @Deprecated
    public static DialogTakeMicTaskCompleteDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogTakeMicTaskCompleteDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_take_mic_task_complete_diamond, viewGroup, z, obj);
    }

    public static DialogTakeMicTaskCompleteDiamondBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogTakeMicTaskCompleteDiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTakeMicTaskCompleteDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_take_mic_task_complete_diamond, (ViewGroup) null, false, obj);
    }
}
