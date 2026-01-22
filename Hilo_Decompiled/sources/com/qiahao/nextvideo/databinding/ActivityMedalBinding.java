package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.wedgit.BackgroundTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityMedalBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView myMedal;
    public final LinearLayout tabLayout;
    public final BackgroundTabLayout tabSegment;
    public final IncludeTitleWriteBinding titleBar;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMedalBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, BackgroundTabLayout backgroundTabLayout, IncludeTitleWriteBinding includeTitleWriteBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.myMedal = textView;
        this.tabLayout = linearLayout;
        this.tabSegment = backgroundTabLayout;
        this.titleBar = includeTitleWriteBinding;
        this.viewPage = viewPager2;
    }

    public static ActivityMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityMedalBinding bind(View view, Object obj) {
        return (ActivityMedalBinding) ViewDataBinding.bind(obj, view, R.layout.activity_medal);
    }

    @Deprecated
    public static ActivityMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_medal, viewGroup, z, obj);
    }

    public static ActivityMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_medal, (ViewGroup) null, false, obj);
    }
}
