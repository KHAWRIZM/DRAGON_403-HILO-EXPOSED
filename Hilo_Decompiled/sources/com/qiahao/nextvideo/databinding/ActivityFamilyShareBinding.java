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
public abstract class ActivityFamilyShareBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final TextView cancel;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final EditText searchEditText;
    public final LinearLayout searchLinearLayout;
    public final TextView shareBtn;
    public final SuperStatusView statusView;
    public final TextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyShareBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, TextView textView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, EditText editText, LinearLayout linearLayout, TextView textView2, SuperStatusView superStatusView, TextView textView3, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.cancel = textView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.searchEditText = editText;
        this.searchLinearLayout = linearLayout;
        this.shareBtn = textView2;
        this.statusView = superStatusView;
        this.title = textView3;
        this.toolbar = toolbar;
    }

    public static ActivityFamilyShareBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyShareBinding bind(View view, Object obj) {
        return (ActivityFamilyShareBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_share);
    }

    @Deprecated
    public static ActivityFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_share, viewGroup, z, obj);
    }

    public static ActivityFamilyShareBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_share, (ViewGroup) null, false, obj);
    }
}
