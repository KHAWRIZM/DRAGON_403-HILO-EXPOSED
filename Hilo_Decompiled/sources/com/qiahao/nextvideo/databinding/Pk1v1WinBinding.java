package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class Pk1v1WinBinding extends ViewDataBinding {
    public final SVGAImageView pkEndSvga;
    public final ConstraintLayout winLayout;
    public final AppCompatTextView winnerDiamond;
    public final TextView winnerName;

    /* JADX INFO: Access modifiers changed from: protected */
    public Pk1v1WinBinding(Object obj, View view, int i, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, TextView textView) {
        super(obj, view, i);
        this.pkEndSvga = sVGAImageView;
        this.winLayout = constraintLayout;
        this.winnerDiamond = appCompatTextView;
        this.winnerName = textView;
    }

    public static Pk1v1WinBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static Pk1v1WinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static Pk1v1WinBinding bind(View view, Object obj) {
        return (Pk1v1WinBinding) ViewDataBinding.bind(obj, view, R.layout.pk1v1_win);
    }

    @Deprecated
    public static Pk1v1WinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (Pk1v1WinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pk1v1_win, viewGroup, z, obj);
    }

    public static Pk1v1WinBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static Pk1v1WinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (Pk1v1WinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pk1v1_win, (ViewGroup) null, false, obj);
    }
}
