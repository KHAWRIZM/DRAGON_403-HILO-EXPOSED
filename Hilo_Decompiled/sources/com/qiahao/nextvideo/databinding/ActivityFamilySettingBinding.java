package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilySettingBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final FrameLayout frameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilySettingBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.frameLayout = frameLayout2;
    }

    public static ActivityFamilySettingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilySettingBinding bind(View view, Object obj) {
        return (ActivityFamilySettingBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_setting);
    }

    @Deprecated
    public static ActivityFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_setting, viewGroup, z, obj);
    }

    public static ActivityFamilySettingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilySettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_setting, (ViewGroup) null, false, obj);
    }
}
