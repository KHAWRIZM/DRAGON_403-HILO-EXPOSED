package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGameLevelRulesBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView fiveText;
    public final TextView fourText;
    public final IncludeSvipRulesBinding rulesOne;
    public final IncludeSvipRulesBinding rulesThree;
    public final IncludeSvipRulesBinding rulesTwo;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGameLevelRulesBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, TextView textView2, IncludeSvipRulesBinding includeSvipRulesBinding, IncludeSvipRulesBinding includeSvipRulesBinding2, IncludeSvipRulesBinding includeSvipRulesBinding3, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.fiveText = textView;
        this.fourText = textView2;
        this.rulesOne = includeSvipRulesBinding;
        this.rulesThree = includeSvipRulesBinding2;
        this.rulesTwo = includeSvipRulesBinding3;
        this.titleBar = includeTitleBinding;
    }

    public static ActivityGameLevelRulesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGameLevelRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGameLevelRulesBinding bind(View view, Object obj) {
        return (ActivityGameLevelRulesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_game_level_rules);
    }

    @Deprecated
    public static ActivityGameLevelRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGameLevelRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_level_rules, viewGroup, z, obj);
    }

    public static ActivityGameLevelRulesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGameLevelRulesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGameLevelRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_level_rules, (ViewGroup) null, false, obj);
    }
}
