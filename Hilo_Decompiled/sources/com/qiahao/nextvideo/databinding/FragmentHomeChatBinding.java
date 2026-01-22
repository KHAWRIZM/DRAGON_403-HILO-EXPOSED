package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.ViewSelector;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeChatBinding extends ViewDataBinding {
    public final ImageView clearUnread;
    public final LinearLayout container;
    public final FrameLayout notificationPermissionTipsContainer;
    public final CommonTabLayout segmentTabLayout;
    public final ConstraintLayout title;
    public final ImageView topBg;
    public final ViewSelector viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeChatBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, CommonTabLayout commonTabLayout, ConstraintLayout constraintLayout, ImageView imageView2, ViewSelector viewSelector) {
        super(obj, view, i);
        this.clearUnread = imageView;
        this.container = linearLayout;
        this.notificationPermissionTipsContainer = frameLayout;
        this.segmentTabLayout = commonTabLayout;
        this.title = constraintLayout;
        this.topBg = imageView2;
        this.viewPager = viewSelector;
    }

    public static FragmentHomeChatBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeChatBinding bind(View view, Object obj) {
        return (FragmentHomeChatBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_chat);
    }

    @Deprecated
    public static FragmentHomeChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_chat, viewGroup, z, obj);
    }

    public static FragmentHomeChatBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeChatBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_chat, (ViewGroup) null, false, obj);
    }
}
