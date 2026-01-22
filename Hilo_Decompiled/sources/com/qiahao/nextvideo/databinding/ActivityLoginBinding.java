package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityLoginBinding extends ViewDataBinding {
    public final FrameLayout loginFrameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLoginBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.loginFrameLayout = frameLayout;
    }

    public static ActivityLoginBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityLoginBinding bind(View view, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.bind(obj, view, R.layout.activity_login);
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, viewGroup, z, obj);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, (ViewGroup) null, false, obj);
    }
}
