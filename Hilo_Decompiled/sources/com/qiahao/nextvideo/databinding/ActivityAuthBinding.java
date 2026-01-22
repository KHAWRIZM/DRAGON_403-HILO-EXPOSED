package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityAuthBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAuthBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
    }

    public static ActivityAuthBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityAuthBinding bind(View view, Object obj) {
        return (ActivityAuthBinding) ViewDataBinding.bind(obj, view, R.layout.activity_auth);
    }

    @Deprecated
    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth, viewGroup, z, obj);
    }

    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth, (ViewGroup) null, false, obj);
    }
}
