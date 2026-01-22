package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentCpBinding extends ViewDataBinding {
    public final HiloImageView avatar1;
    public final HiloImageView avatar2;
    public final TextView bindZone;
    public final TextView cpValue;
    public final TextView cpZone;
    public final ConstraintLayout endLayout;
    public final ImageView heart;
    public final View line;
    public final LinearLayout llDiamond;
    public final ImageView medal;
    public final NickTextView nickName1;
    public final NickTextView nickName2;
    public final TextView position;
    public final ImageView svga;
    public final HiloTabLayout tabLayout;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCpBinding(Object obj, View view, int i, HiloImageView hiloImageView, HiloImageView hiloImageView2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, ImageView imageView, View view2, LinearLayout linearLayout, ImageView imageView2, NickTextView nickTextView, NickTextView nickTextView2, TextView textView4, ImageView imageView3, HiloTabLayout hiloTabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.avatar1 = hiloImageView;
        this.avatar2 = hiloImageView2;
        this.bindZone = textView;
        this.cpValue = textView2;
        this.cpZone = textView3;
        this.endLayout = constraintLayout;
        this.heart = imageView;
        this.line = view2;
        this.llDiamond = linearLayout;
        this.medal = imageView2;
        this.nickName1 = nickTextView;
        this.nickName2 = nickTextView2;
        this.position = textView4;
        this.svga = imageView3;
        this.tabLayout = hiloTabLayout;
        this.viewPage = viewPager2;
    }

    public static FragmentCpBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentCpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentCpBinding bind(View view, Object obj) {
        return (FragmentCpBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_cp);
    }

    @Deprecated
    public static FragmentCpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cp, viewGroup, z, obj);
    }

    public static FragmentCpBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentCpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cp, (ViewGroup) null, false, obj);
    }
}
