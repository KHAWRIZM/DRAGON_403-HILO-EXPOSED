package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentCarromBagBinding extends ViewDataBinding {
    public final IncludeCarromTitleBinding power;
    public final IncludeCarromTitleBinding pucks;
    public final IncludeCarromTitleBinding striker;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCarromBagBinding(Object obj, View view, int i, IncludeCarromTitleBinding includeCarromTitleBinding, IncludeCarromTitleBinding includeCarromTitleBinding2, IncludeCarromTitleBinding includeCarromTitleBinding3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.power = includeCarromTitleBinding;
        this.pucks = includeCarromTitleBinding2;
        this.striker = includeCarromTitleBinding3;
        this.viewPage = viewPager2;
    }

    public static FragmentCarromBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentCarromBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentCarromBagBinding bind(View view, Object obj) {
        return (FragmentCarromBagBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_carrom_bag);
    }

    @Deprecated
    public static FragmentCarromBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCarromBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_carrom_bag, viewGroup, z, obj);
    }

    public static FragmentCarromBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentCarromBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCarromBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_carrom_bag, (ViewGroup) null, false, obj);
    }
}
