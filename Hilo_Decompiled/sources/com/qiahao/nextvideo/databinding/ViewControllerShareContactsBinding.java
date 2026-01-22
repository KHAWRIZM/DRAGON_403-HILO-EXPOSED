package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerShareContactsBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final CommonTabLayout commonTabLayout;
    protected View.OnClickListener mClick;
    public final Toolbar titleBar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerShareContactsBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, CommonTabLayout commonTabLayout, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.commonTabLayout = commonTabLayout;
        this.titleBar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerShareContactsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerShareContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ViewControllerShareContactsBinding bind(View view, Object obj) {
        return (ViewControllerShareContactsBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_share_contacts);
    }

    @Deprecated
    public static ViewControllerShareContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerShareContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_share_contacts, viewGroup, z, obj);
    }

    public static ViewControllerShareContactsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerShareContactsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerShareContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_share_contacts, (ViewGroup) null, false, obj);
    }
}
