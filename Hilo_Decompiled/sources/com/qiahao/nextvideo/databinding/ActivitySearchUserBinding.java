package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySearchUserBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final AppCompatImageView helper;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final EditText searchEditText;
    public final LinearLayout searchLinearLayout;
    public final SuperStatusView statusView;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySearchUserBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, EditText editText, LinearLayout linearLayout, SuperStatusView superStatusView, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.helper = appCompatImageView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.searchEditText = editText;
        this.searchLinearLayout = linearLayout;
        this.statusView = superStatusView;
        this.title = appCompatTextView;
        this.topLayout = linearLayoutCompat;
    }

    public static ActivitySearchUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySearchUserBinding bind(View view, Object obj) {
        return (ActivitySearchUserBinding) ViewDataBinding.bind(obj, view, R.layout.activity_search_user);
    }

    @Deprecated
    public static ActivitySearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_user, viewGroup, z, obj);
    }

    public static ActivitySearchUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySearchUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_user, (ViewGroup) null, false, obj);
    }
}
