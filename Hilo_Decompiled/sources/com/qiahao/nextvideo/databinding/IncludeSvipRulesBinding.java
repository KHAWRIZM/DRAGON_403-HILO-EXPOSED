package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeSvipRulesBinding extends ViewDataBinding {
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeSvipRulesBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.subTitle = textView;
        this.title = textView2;
    }

    public static IncludeSvipRulesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeSvipRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeSvipRulesBinding bind(View view, Object obj) {
        return (IncludeSvipRulesBinding) ViewDataBinding.bind(obj, view, R.layout.include_svip_rules);
    }

    @Deprecated
    public static IncludeSvipRulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeSvipRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_svip_rules, viewGroup, z, obj);
    }

    public static IncludeSvipRulesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeSvipRulesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeSvipRulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_svip_rules, (ViewGroup) null, false, obj);
    }
}
