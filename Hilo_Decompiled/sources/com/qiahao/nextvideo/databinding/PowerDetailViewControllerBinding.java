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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class PowerDetailViewControllerBinding extends ViewDataBinding {
    public final FrameLayout allPowerAvatar;
    public final AppBarLayout appBar;
    public final AppCompatImageView backImageView;
    public final LinearLayout childAllContent;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final ConstraintLayout constraint;
    public final TextView join;
    public final LinearLayout linearLayout2;
    public final LinearLayout llNumber;
    protected View.OnClickListener mClick;
    public final RecyclerView managerList;
    public final ImageView moreBtn;
    public final PorterShapeImageView powerAvatar;
    public final ImageView powerAvatarBg;
    public final TextView powerName;
    public final TextView powerNumber;
    public final RecyclerView recyclerRoom;
    public final SmartRefreshLayout smartRefreshLayout;
    public final AppCompatTextView titleTextView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public PowerDetailViewControllerBinding(Object obj, View view, int i, FrameLayout frameLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CollapsingToolbarLayout collapsingToolbarLayout, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ImageView imageView, PorterShapeImageView porterShapeImageView, ImageView imageView2, TextView textView2, TextView textView3, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.allPowerAvatar = frameLayout;
        this.appBar = appBarLayout;
        this.backImageView = appCompatImageView;
        this.childAllContent = linearLayout;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.constraint = constraintLayout;
        this.join = textView;
        this.linearLayout2 = linearLayout2;
        this.llNumber = linearLayout3;
        this.managerList = recyclerView;
        this.moreBtn = imageView;
        this.powerAvatar = porterShapeImageView;
        this.powerAvatarBg = imageView2;
        this.powerName = textView2;
        this.powerNumber = textView3;
        this.recyclerRoom = recyclerView2;
        this.smartRefreshLayout = smartRefreshLayout;
        this.titleTextView = appCompatTextView;
        this.toolbar = toolbar;
    }

    public static PowerDetailViewControllerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static PowerDetailViewControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static PowerDetailViewControllerBinding bind(View view, Object obj) {
        return (PowerDetailViewControllerBinding) ViewDataBinding.bind(obj, view, R.layout.power_detail_view_controller);
    }

    @Deprecated
    public static PowerDetailViewControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PowerDetailViewControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.power_detail_view_controller, viewGroup, z, obj);
    }

    public static PowerDetailViewControllerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static PowerDetailViewControllerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PowerDetailViewControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.power_detail_view_controller, (ViewGroup) null, false, obj);
    }
}
