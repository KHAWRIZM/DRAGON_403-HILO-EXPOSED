package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentGroupThemeBinding extends ViewDataBinding {
    public final AppCompatTextView emptyTipTextView;
    public final RecyclerView recyclerManager;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentGroupThemeBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.emptyTipTextView = appCompatTextView;
        this.recyclerManager = recyclerView;
    }

    public static FragmentGroupThemeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentGroupThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentGroupThemeBinding bind(View view, Object obj) {
        return (FragmentGroupThemeBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_group_theme);
    }

    @Deprecated
    public static FragmentGroupThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentGroupThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_group_theme, viewGroup, z, obj);
    }

    public static FragmentGroupThemeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentGroupThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentGroupThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_group_theme, (ViewGroup) null, false, obj);
    }
}
