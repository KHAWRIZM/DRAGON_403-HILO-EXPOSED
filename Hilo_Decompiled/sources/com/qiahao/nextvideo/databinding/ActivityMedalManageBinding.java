package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityMedalManageBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ConstraintLayout constraint;
    public final RecyclerView recyclerView;
    public final IncludeTitleWriteBinding titleBar;
    public final View topBg;
    public final TextView topTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMedalManageBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, RecyclerView recyclerView, IncludeTitleWriteBinding includeTitleWriteBinding, View view2, TextView textView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.constraint = constraintLayout;
        this.recyclerView = recyclerView;
        this.titleBar = includeTitleWriteBinding;
        this.topBg = view2;
        this.topTitle = textView;
    }

    public static ActivityMedalManageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMedalManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityMedalManageBinding bind(View view, Object obj) {
        return (ActivityMedalManageBinding) ViewDataBinding.bind(obj, view, R.layout.activity_medal_manage);
    }

    @Deprecated
    public static ActivityMedalManageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMedalManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_medal_manage, viewGroup, z, obj);
    }

    public static ActivityMedalManageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMedalManageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMedalManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_medal_manage, (ViewGroup) null, false, obj);
    }
}
