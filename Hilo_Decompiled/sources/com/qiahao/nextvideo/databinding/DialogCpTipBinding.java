package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpTipBinding extends ViewDataBinding {
    public final TextView confirm;
    public final ConstraintLayout constraintLayout;
    public final FrameLayout frameLayout;
    public final HiloImageView leftAvatar;
    public final HiloImageView rightAvatar;
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpTipBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, FrameLayout frameLayout, HiloImageView hiloImageView, HiloImageView hiloImageView2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.confirm = textView;
        this.constraintLayout = constraintLayout;
        this.frameLayout = frameLayout;
        this.leftAvatar = hiloImageView;
        this.rightAvatar = hiloImageView2;
        this.subTitle = textView2;
        this.title = textView3;
    }

    public static DialogCpTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpTipBinding bind(View view, Object obj) {
        return (DialogCpTipBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_tip);
    }

    @Deprecated
    public static DialogCpTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_tip, viewGroup, z, obj);
    }

    public static DialogCpTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_tip, (ViewGroup) null, false, obj);
    }
}
