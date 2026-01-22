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
public abstract class ActivityRoomRecordBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final LinearLayout tabLayout;
    public final ViewPage2TabLayout tabSegment;
    public final IncludeTitleBinding titleBar;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRoomRecordBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, ViewPage2TabLayout viewPage2TabLayout, IncludeTitleBinding includeTitleBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.tabLayout = linearLayout;
        this.tabSegment = viewPage2TabLayout;
        this.titleBar = includeTitleBinding;
        this.viewPage = viewPager2;
    }

    public static ActivityRoomRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRoomRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityRoomRecordBinding bind(View view, Object obj) {
        return (ActivityRoomRecordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_room_record);
    }

    @Deprecated
    public static ActivityRoomRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRoomRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_record, viewGroup, z, obj);
    }

    public static ActivityRoomRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRoomRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRoomRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_record, (ViewGroup) null, false, obj);
    }
}
