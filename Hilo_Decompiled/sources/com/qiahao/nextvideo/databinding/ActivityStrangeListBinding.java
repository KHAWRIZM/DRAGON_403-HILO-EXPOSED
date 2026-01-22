package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityStrangeListBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final ConstraintLayout constraint;
    public final ImageView endArrow;
    public final View line;
    public final LinearLayoutCompat linearLayout;
    public final TextView maskedText;
    public final ConstraintLayout matchLayout;
    public final LinearLayout numberLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final ImageView strangeIcon;
    public final AppCompatTextView subTitle;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityStrangeListBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, ConstraintLayout constraintLayout, ImageView imageView, View view3, LinearLayoutCompat linearLayoutCompat, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ImageView imageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.constraint = constraintLayout;
        this.endArrow = imageView;
        this.line = view3;
        this.linearLayout = linearLayoutCompat;
        this.maskedText = textView;
        this.matchLayout = constraintLayout2;
        this.numberLayout = linearLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.strangeIcon = imageView2;
        this.subTitle = appCompatTextView;
        this.title = appCompatTextView2;
    }

    public static ActivityStrangeListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityStrangeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityStrangeListBinding bind(View view, Object obj) {
        return (ActivityStrangeListBinding) ViewDataBinding.bind(obj, view, R.layout.activity_strange_list);
    }

    @Deprecated
    public static ActivityStrangeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityStrangeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_strange_list, viewGroup, z, obj);
    }

    public static ActivityStrangeListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityStrangeListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityStrangeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_strange_list, (ViewGroup) null, false, obj);
    }
}
