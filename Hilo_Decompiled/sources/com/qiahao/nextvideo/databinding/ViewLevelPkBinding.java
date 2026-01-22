package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewLevelPkBinding extends ViewDataBinding {
    public final IncludePkLevelBinding oneLevel;
    public final View progress;
    public final View progressBg;
    public final IncludePkLevelBinding threeLevel;
    public final IncludePkLevelBinding twoLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewLevelPkBinding(Object obj, View view, int i, IncludePkLevelBinding includePkLevelBinding, View view2, View view3, IncludePkLevelBinding includePkLevelBinding2, IncludePkLevelBinding includePkLevelBinding3) {
        super(obj, view, i);
        this.oneLevel = includePkLevelBinding;
        this.progress = view2;
        this.progressBg = view3;
        this.threeLevel = includePkLevelBinding2;
        this.twoLevel = includePkLevelBinding3;
    }

    public static ViewLevelPkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewLevelPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewLevelPkBinding bind(View view, Object obj) {
        return (ViewLevelPkBinding) ViewDataBinding.bind(obj, view, R.layout.view_level_pk);
    }

    @Deprecated
    public static ViewLevelPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLevelPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_level_pk, viewGroup, z, obj);
    }

    public static ViewLevelPkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewLevelPkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLevelPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_level_pk, (ViewGroup) null, false, obj);
    }
}
