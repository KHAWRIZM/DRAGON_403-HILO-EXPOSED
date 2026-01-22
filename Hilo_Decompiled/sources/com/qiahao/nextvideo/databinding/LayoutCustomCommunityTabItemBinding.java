package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutCustomCommunityTabItemBinding extends ViewDataBinding {
    public final TextView redNumber;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutCustomCommunityTabItemBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.redNumber = textView;
        this.title = textView2;
    }

    public static LayoutCustomCommunityTabItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutCustomCommunityTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutCustomCommunityTabItemBinding bind(View view, Object obj) {
        return (LayoutCustomCommunityTabItemBinding) ViewDataBinding.bind(obj, view, R.layout.layout_custom_community_tab_item);
    }

    @Deprecated
    public static LayoutCustomCommunityTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutCustomCommunityTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_custom_community_tab_item, viewGroup, z, obj);
    }

    public static LayoutCustomCommunityTabItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutCustomCommunityTabItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutCustomCommunityTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_custom_community_tab_item, (ViewGroup) null, false, obj);
    }
}
