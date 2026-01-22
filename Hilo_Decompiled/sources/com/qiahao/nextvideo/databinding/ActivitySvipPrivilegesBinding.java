package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySvipPrivilegesBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final RecyclerView imageRecyclerView;
    public final RecyclerView recyclerView;
    public final AppCompatTextView title;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySvipPrivilegesBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.imageRecyclerView = recyclerView;
        this.recyclerView = recyclerView2;
        this.title = appCompatTextView;
        this.titleBar = includeTitleBinding;
    }

    public static ActivitySvipPrivilegesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySvipPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySvipPrivilegesBinding bind(View view, Object obj) {
        return (ActivitySvipPrivilegesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_svip_privileges);
    }

    @Deprecated
    public static ActivitySvipPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySvipPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_privileges, viewGroup, z, obj);
    }

    public static ActivitySvipPrivilegesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySvipPrivilegesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySvipPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_privileges, (ViewGroup) null, false, obj);
    }
}
