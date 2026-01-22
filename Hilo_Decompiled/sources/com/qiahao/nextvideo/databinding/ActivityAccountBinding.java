package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityAccountBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final IncludeAccountItemBinding deleteAccount;
    public final IncludeAccountItemBinding facebook;
    public final IncludeAccountItemBinding google;
    public final FrameLayout loginFrameLayout;
    public final IncludeAccountItemBinding phone;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAccountBinding(Object obj, View view, int i, FrameLayout frameLayout, IncludeAccountItemBinding includeAccountItemBinding, IncludeAccountItemBinding includeAccountItemBinding2, IncludeAccountItemBinding includeAccountItemBinding3, FrameLayout frameLayout2, IncludeAccountItemBinding includeAccountItemBinding4, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.deleteAccount = includeAccountItemBinding;
        this.facebook = includeAccountItemBinding2;
        this.google = includeAccountItemBinding3;
        this.loginFrameLayout = frameLayout2;
        this.phone = includeAccountItemBinding4;
        this.titleBar = includeTitleBinding;
    }

    public static ActivityAccountBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityAccountBinding bind(View view, Object obj) {
        return (ActivityAccountBinding) ViewDataBinding.bind(obj, view, R.layout.activity_account);
    }

    @Deprecated
    public static ActivityAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account, viewGroup, z, obj);
    }

    public static ActivityAccountBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityAccountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account, (ViewGroup) null, false, obj);
    }
}
