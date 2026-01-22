package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.planet.PlanetsView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeMatchingHeadBinding extends ViewDataBinding {
    public final IncludeMatchBigItemBinding baiShun;
    public final IncludeMatchBigItemBinding broadcastLayout;
    public final IncludeMatchBigItemBinding chatLayout;
    public final IncludeMatchMinItemBinding fishingLayout;
    public final ImageView leftIcon;
    public final IncludeMatchBigItemBinding matchLayout;
    public final TextView number;
    public final TextView numberTitle;
    public final PlanetsView planetView;
    public final ImageView rightIcon;
    public final IncludeMatchMinItemBinding slotsLayout;
    public final IncludeMatchBigItemBinding videoLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeMatchingHeadBinding(Object obj, View view, int i, IncludeMatchBigItemBinding includeMatchBigItemBinding, IncludeMatchBigItemBinding includeMatchBigItemBinding2, IncludeMatchBigItemBinding includeMatchBigItemBinding3, IncludeMatchMinItemBinding includeMatchMinItemBinding, ImageView imageView, IncludeMatchBigItemBinding includeMatchBigItemBinding4, TextView textView, TextView textView2, PlanetsView planetsView, ImageView imageView2, IncludeMatchMinItemBinding includeMatchMinItemBinding2, IncludeMatchBigItemBinding includeMatchBigItemBinding5) {
        super(obj, view, i);
        this.baiShun = includeMatchBigItemBinding;
        this.broadcastLayout = includeMatchBigItemBinding2;
        this.chatLayout = includeMatchBigItemBinding3;
        this.fishingLayout = includeMatchMinItemBinding;
        this.leftIcon = imageView;
        this.matchLayout = includeMatchBigItemBinding4;
        this.number = textView;
        this.numberTitle = textView2;
        this.planetView = planetsView;
        this.rightIcon = imageView2;
        this.slotsLayout = includeMatchMinItemBinding2;
        this.videoLayout = includeMatchBigItemBinding5;
    }

    public static FragmentHomeMatchingHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeMatchingHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeMatchingHeadBinding bind(View view, Object obj) {
        return (FragmentHomeMatchingHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_matching_head);
    }

    @Deprecated
    public static FragmentHomeMatchingHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeMatchingHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_matching_head, viewGroup, z, obj);
    }

    public static FragmentHomeMatchingHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeMatchingHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeMatchingHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_matching_head, (ViewGroup) null, false, obj);
    }
}
