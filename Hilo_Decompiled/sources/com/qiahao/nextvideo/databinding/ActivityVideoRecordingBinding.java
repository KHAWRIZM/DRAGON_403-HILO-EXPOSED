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
public abstract class ActivityVideoRecordingBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final LinearLayout tabLayout;
    public final BackgroundTabLayout tabSegment;
    public final IncludeTitleBinding titleBar;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityVideoRecordingBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, BackgroundTabLayout backgroundTabLayout, IncludeTitleBinding includeTitleBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.tabLayout = linearLayout;
        this.tabSegment = backgroundTabLayout;
        this.titleBar = includeTitleBinding;
        this.viewPage = viewPager2;
    }

    public static ActivityVideoRecordingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityVideoRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityVideoRecordingBinding bind(View view, Object obj) {
        return (ActivityVideoRecordingBinding) ViewDataBinding.bind(obj, view, R.layout.activity_video_recording);
    }

    @Deprecated
    public static ActivityVideoRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityVideoRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_recording, viewGroup, z, obj);
    }

    public static ActivityVideoRecordingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityVideoRecordingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityVideoRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_recording, (ViewGroup) null, false, obj);
    }
}
