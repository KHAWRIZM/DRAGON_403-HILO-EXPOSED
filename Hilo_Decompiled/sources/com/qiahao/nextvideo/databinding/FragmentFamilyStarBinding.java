package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFamilyStarBinding extends ViewDataBinding {
    public final HiloTabLayout tabLayout;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFamilyStarBinding(Object obj, View view, int i, HiloTabLayout hiloTabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.tabLayout = hiloTabLayout;
        this.viewPage = viewPager2;
    }

    public static FragmentFamilyStarBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFamilyStarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFamilyStarBinding bind(View view, Object obj) {
        return (FragmentFamilyStarBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_family_star);
    }

    @Deprecated
    public static FragmentFamilyStarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFamilyStarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_star, viewGroup, z, obj);
    }

    public static FragmentFamilyStarBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFamilyStarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFamilyStarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_star, (ViewGroup) null, false, obj);
    }
}
