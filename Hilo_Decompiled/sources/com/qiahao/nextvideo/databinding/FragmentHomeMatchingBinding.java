package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HomeMatchRecycleView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeMatchingBinding extends ViewDataBinding {
    public final ImageView chest;
    public final TextView diamondTextView;
    public final AppCompatTextView endTextView;
    public final ConstraintLayout foundGuysSvgaContainer;
    public final SVGAImageView foundGuysSvgaImageView;
    public final TextView gemTextView;
    public final Group matchGroup;
    public final FrameLayout matchingPendingViewWrapperContainer;
    public final HomeMatchRecycleView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final ConstraintLayout rootContainer;
    public final SuperStatusView statusView;
    public final AppCompatTextView textShowMating;
    public final LinearLayout topLinearLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeMatchingBinding(Object obj, View view, int i, ImageView imageView, TextView textView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, TextView textView2, Group group, FrameLayout frameLayout, HomeMatchRecycleView homeMatchRecycleView, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout2, SuperStatusView superStatusView, AppCompatTextView appCompatTextView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.chest = imageView;
        this.diamondTextView = textView;
        this.endTextView = appCompatTextView;
        this.foundGuysSvgaContainer = constraintLayout;
        this.foundGuysSvgaImageView = sVGAImageView;
        this.gemTextView = textView2;
        this.matchGroup = group;
        this.matchingPendingViewWrapperContainer = frameLayout;
        this.recyclerView = homeMatchRecycleView;
        this.refreshLayout = smartRefreshLayout;
        this.rootContainer = constraintLayout2;
        this.statusView = superStatusView;
        this.textShowMating = appCompatTextView2;
        this.topLinearLayout = linearLayout;
    }

    public static FragmentHomeMatchingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeMatchingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeMatchingBinding bind(View view, Object obj) {
        return (FragmentHomeMatchingBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_matching);
    }

    @Deprecated
    public static FragmentHomeMatchingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeMatchingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_matching, viewGroup, z, obj);
    }

    public static FragmentHomeMatchingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeMatchingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeMatchingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_matching, (ViewGroup) null, false, obj);
    }
}
