package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogStyledBinding extends ViewDataBinding {
    public final LinearLayout allContentContainer;
    public final StackLayout commonIdButtonContainer;
    public final FrameLayout commonIdContentContainer;
    public final FrameLayout dialogStyledOverallFramelayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogStyledBinding(Object obj, View view, int i, LinearLayout linearLayout, StackLayout stackLayout, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.allContentContainer = linearLayout;
        this.commonIdButtonContainer = stackLayout;
        this.commonIdContentContainer = frameLayout;
        this.dialogStyledOverallFramelayout = frameLayout2;
    }

    public static DialogStyledBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogStyledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogStyledBinding bind(View view, Object obj) {
        return (DialogStyledBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_styled);
    }

    @Deprecated
    public static DialogStyledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogStyledBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_styled, viewGroup, z, obj);
    }

    public static DialogStyledBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogStyledBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogStyledBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_styled, (ViewGroup) null, false, obj);
    }
}
