package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityShareContactsBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final CommonTabLayout commonTabLayout;
    protected View.OnClickListener mClick;
    public final TextView selectAll;
    public final Toolbar titleBar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityShareContactsBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, CommonTabLayout commonTabLayout, TextView textView, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.commonTabLayout = commonTabLayout;
        this.selectAll = textView;
        this.titleBar = toolbar;
        this.viewPager = viewPager;
    }

    public static ActivityShareContactsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityShareContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityShareContactsBinding bind(View view, Object obj) {
        return (ActivityShareContactsBinding) ViewDataBinding.bind(obj, view, R.layout.activity_share_contacts);
    }

    @Deprecated
    public static ActivityShareContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityShareContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_share_contacts, viewGroup, z, obj);
    }

    public static ActivityShareContactsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityShareContactsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityShareContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_share_contacts, (ViewGroup) null, false, obj);
    }
}
