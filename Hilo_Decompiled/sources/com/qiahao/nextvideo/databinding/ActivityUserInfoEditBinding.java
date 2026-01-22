package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityUserInfoEditBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayoutCompat countryCellLinearLayout;
    public final AppCompatImageView countrySymbolImageView;
    public final AppCompatTextView countryTextView;
    public final AppCompatImageView imge;
    public final LinearLayoutCompat nicknameCellLinearLayout;
    public final AppCompatTextView nicknameTextView;
    public final RecyclerView picRecycler;
    public final LinearLayoutCompat sexCellLinearLayout;
    public final AppCompatTextView sexTextView;
    public final SwitchButton showAgeSwitchView;
    public final LinearLayoutCompat signatureCellLinearLayout;
    public final AppCompatTextView signatureTextView;
    public final Toolbar toolbar;
    public final CircleImageView userHeadCircleImageView;
    public final FrameLayout userHeadCircleImageViewFrameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityUserInfoEditBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, AppCompatTextView appCompatTextView2, RecyclerView recyclerView, LinearLayoutCompat linearLayoutCompat3, AppCompatTextView appCompatTextView3, SwitchButton switchButton, LinearLayoutCompat linearLayoutCompat4, AppCompatTextView appCompatTextView4, Toolbar toolbar, CircleImageView circleImageView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.countryCellLinearLayout = linearLayoutCompat;
        this.countrySymbolImageView = appCompatImageView2;
        this.countryTextView = appCompatTextView;
        this.imge = appCompatImageView3;
        this.nicknameCellLinearLayout = linearLayoutCompat2;
        this.nicknameTextView = appCompatTextView2;
        this.picRecycler = recyclerView;
        this.sexCellLinearLayout = linearLayoutCompat3;
        this.sexTextView = appCompatTextView3;
        this.showAgeSwitchView = switchButton;
        this.signatureCellLinearLayout = linearLayoutCompat4;
        this.signatureTextView = appCompatTextView4;
        this.toolbar = toolbar;
        this.userHeadCircleImageView = circleImageView;
        this.userHeadCircleImageViewFrameLayout = frameLayout2;
    }

    public static ActivityUserInfoEditBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityUserInfoEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityUserInfoEditBinding bind(View view, Object obj) {
        return (ActivityUserInfoEditBinding) ViewDataBinding.bind(obj, view, R.layout.activity_user_info_edit);
    }

    @Deprecated
    public static ActivityUserInfoEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityUserInfoEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_info_edit, viewGroup, z, obj);
    }

    public static ActivityUserInfoEditBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityUserInfoEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityUserInfoEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_info_edit, (ViewGroup) null, false, obj);
    }
}
