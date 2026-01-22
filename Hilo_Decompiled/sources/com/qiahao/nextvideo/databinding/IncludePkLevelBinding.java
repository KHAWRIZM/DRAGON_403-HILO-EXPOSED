package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludePkLevelBinding extends ViewDataBinding {
    public final View centerView;
    public final TextView levelDiamond;
    public final TextView levelTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludePkLevelBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.centerView = view2;
        this.levelDiamond = textView;
        this.levelTitle = textView2;
    }

    public static IncludePkLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludePkLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludePkLevelBinding bind(View view, Object obj) {
        return (IncludePkLevelBinding) ViewDataBinding.bind(obj, view, R.layout.include_pk_level);
    }

    @Deprecated
    public static IncludePkLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludePkLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_pk_level, viewGroup, z, obj);
    }

    public static IncludePkLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludePkLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludePkLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_pk_level, (ViewGroup) null, false, obj);
    }
}
