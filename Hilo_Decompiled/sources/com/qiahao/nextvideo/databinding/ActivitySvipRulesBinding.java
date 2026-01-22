package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySvipRulesBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final IncludeSvipRulesBinding rulesFour;
    public final IncludeSvipRulesBinding rulesOne;
    public final IncludeSvipRulesBinding rulesThree;
    public final IncludeSvipRulesBinding rulesTwo;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySvipRulesBinding(Object obj, View view, int i, FrameLayout frameLayout, IncludeSvipRulesBinding includeSvipRulesBinding, IncludeSvipRulesBinding includeSvipRulesBinding2, IncludeSvipRulesBinding includeSvipRulesBinding3, IncludeSvipRulesBinding includeSvipRulesBinding4, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.rulesFour = includeSvipRulesBinding;
        this.rulesOne = includeSvipRulesBinding2;
        this.rulesThree = includeSvipRulesBinding3;
        this.rulesTwo = includeSvipRulesBinding4;
        this.titleBar = includeTitleBinding;
    }

    public static ActivitySvipRulesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySvipRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySvipRulesBinding bind(View view, Object obj) {
        return (ActivitySvipRulesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_svip_rules);
    }

    @Deprecated
    public static ActivitySvipRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySvipRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_rules, viewGroup, z, obj);
    }

    public static ActivitySvipRulesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySvipRulesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySvipRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_rules, (ViewGroup) null, false, obj);
    }
}
