package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.wedgit.BackgroundTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyRecordingBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final LinearLayout tabLayout;
    public final BackgroundTabLayout tabSegment;
    public final IncludeTitleBinding titleBar;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyRecordingBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, BackgroundTabLayout backgroundTabLayout, IncludeTitleBinding includeTitleBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.tabLayout = linearLayout;
        this.tabSegment = backgroundTabLayout;
        this.titleBar = includeTitleBinding;
        this.viewPage = viewPager2;
    }

    public static ActivityFamilyRecordingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyRecordingBinding bind(View view, Object obj) {
        return (ActivityFamilyRecordingBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_recording);
    }

    @Deprecated
    public static ActivityFamilyRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_recording, viewGroup, z, obj);
    }

    public static ActivityFamilyRecordingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyRecordingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_recording, (ViewGroup) null, false, obj);
    }
}
