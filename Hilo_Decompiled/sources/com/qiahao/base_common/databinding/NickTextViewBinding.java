package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;
import com.qiahao.base_common.player.vap.VapPlayer;
import com.qiahao.base_common.wedgit.shineText.CenterGlowBreathingTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class NickTextViewBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final CenterGlowBreathingTextView text;
    public final VapPlayer videoPlayer;

    /* JADX INFO: Access modifiers changed from: protected */
    public NickTextViewBinding(Object obj, View view, int i10, ConstraintLayout constraintLayout, CenterGlowBreathingTextView centerGlowBreathingTextView, VapPlayer vapPlayer) {
        super(obj, view, i10);
        this.constraint = constraintLayout;
        this.text = centerGlowBreathingTextView;
        this.videoPlayer = vapPlayer;
    }

    public static NickTextViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static NickTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static NickTextViewBinding bind(View view, Object obj) {
        return (NickTextViewBinding) ViewDataBinding.bind(obj, view, R.layout.nick_text_view);
    }

    @Deprecated
    public static NickTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (NickTextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nick_text_view, viewGroup, z10, obj);
    }

    public static NickTextViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static NickTextViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NickTextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nick_text_view, null, false, obj);
    }
}
