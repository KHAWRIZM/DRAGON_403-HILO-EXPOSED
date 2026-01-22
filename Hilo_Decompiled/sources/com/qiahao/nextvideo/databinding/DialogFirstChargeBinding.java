package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFirstChargeBinding extends ViewDataBinding {
    public final ImageView bg;
    public final TextView button;
    public final ConstraintLayout constraint;
    public final FrameLayout frameLayout;
    public final ViewPage2TabLayout tabLayout;
    public final ImageView title;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFirstChargeBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, FrameLayout frameLayout, ViewPage2TabLayout viewPage2TabLayout, ImageView imageView2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.bg = imageView;
        this.button = textView;
        this.constraint = constraintLayout;
        this.frameLayout = frameLayout;
        this.tabLayout = viewPage2TabLayout;
        this.title = imageView2;
        this.viewPage = viewPager2;
    }

    public static DialogFirstChargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFirstChargeBinding bind(View view, Object obj) {
        return (DialogFirstChargeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_first_charge);
    }

    @Deprecated
    public static DialogFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_first_charge, viewGroup, z, obj);
    }

    public static DialogFirstChargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFirstChargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_first_charge, (ViewGroup) null, false, obj);
    }
}
