package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyMemberBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final AppCompatImageView exitImage;
    public final TextView newMembers;
    public final LinearLayout newMembersLayout;
    public final TextView number;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final EditText searchEditText;
    public final LinearLayout searchLinearLayout;
    public final SuperStatusView statusView;
    public final TextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyMemberBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, LinearLayout linearLayout, TextView textView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, EditText editText, LinearLayout linearLayout2, SuperStatusView superStatusView, TextView textView3, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.exitImage = appCompatImageView2;
        this.newMembers = textView;
        this.newMembersLayout = linearLayout;
        this.number = textView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.searchEditText = editText;
        this.searchLinearLayout = linearLayout2;
        this.statusView = superStatusView;
        this.title = textView3;
        this.toolbar = toolbar;
    }

    public static ActivityFamilyMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyMemberBinding bind(View view, Object obj) {
        return (ActivityFamilyMemberBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_member);
    }

    @Deprecated
    public static ActivityFamilyMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_member, viewGroup, z, obj);
    }

    public static ActivityFamilyMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_member, (ViewGroup) null, false, obj);
    }
}
