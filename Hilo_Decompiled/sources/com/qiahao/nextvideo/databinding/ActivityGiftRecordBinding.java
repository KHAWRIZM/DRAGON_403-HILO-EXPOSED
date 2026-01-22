package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGiftRecordBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final View line;
    public final LinearLayout tabLayout;
    public final ViewPage2TabLayout tabSegment;
    public final IncludeTitleBinding titleBar;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGiftRecordBinding(Object obj, View view, int i, FrameLayout frameLayout, View view2, LinearLayout linearLayout, ViewPage2TabLayout viewPage2TabLayout, IncludeTitleBinding includeTitleBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.line = view2;
        this.tabLayout = linearLayout;
        this.tabSegment = viewPage2TabLayout;
        this.titleBar = includeTitleBinding;
        this.viewPage = viewPager2;
    }

    public static ActivityGiftRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGiftRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGiftRecordBinding bind(View view, Object obj) {
        return (ActivityGiftRecordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_gift_record);
    }

    @Deprecated
    public static ActivityGiftRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGiftRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gift_record, viewGroup, z, obj);
    }

    public static ActivityGiftRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGiftRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGiftRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gift_record, (ViewGroup) null, false, obj);
    }
}
