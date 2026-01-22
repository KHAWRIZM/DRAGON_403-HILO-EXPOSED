package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewEnvelopeNumberBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final TextView fourText;
    public final TextView oneText;
    public final TextView threeText;
    public final TextView twoText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEnvelopeNumberBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.fourText = textView;
        this.oneText = textView2;
        this.threeText = textView3;
        this.twoText = textView4;
    }

    public static ViewEnvelopeNumberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewEnvelopeNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewEnvelopeNumberBinding bind(View view, Object obj) {
        return (ViewEnvelopeNumberBinding) ViewDataBinding.bind(obj, view, R.layout.view_envelope_number);
    }

    @Deprecated
    public static ViewEnvelopeNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewEnvelopeNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_envelope_number, viewGroup, z, obj);
    }

    public static ViewEnvelopeNumberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewEnvelopeNumberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewEnvelopeNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_envelope_number, (ViewGroup) null, false, obj);
    }
}
