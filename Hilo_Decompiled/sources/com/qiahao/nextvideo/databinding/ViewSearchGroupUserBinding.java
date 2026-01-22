package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewSearchGroupUserBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ConstraintLayout baseRoot;
    public final TextView cancel;
    public final CommonTabLayout commonTabLayout;
    public final EditText searchEditText;
    public final LinearLayout searchLinearLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewSearchGroupUserBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView, CommonTabLayout commonTabLayout, EditText editText, LinearLayout linearLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.baseRoot = constraintLayout;
        this.cancel = textView;
        this.commonTabLayout = commonTabLayout;
        this.searchEditText = editText;
        this.searchLinearLayout = linearLayout;
        this.viewPager = viewPager;
    }

    public static ViewSearchGroupUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewSearchGroupUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewSearchGroupUserBinding bind(View view, Object obj) {
        return (ViewSearchGroupUserBinding) ViewDataBinding.bind(obj, view, R.layout.view_search_group_user);
    }

    @Deprecated
    public static ViewSearchGroupUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewSearchGroupUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_group_user, viewGroup, z, obj);
    }

    public static ViewSearchGroupUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewSearchGroupUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewSearchGroupUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_group_user, (ViewGroup) null, false, obj);
    }
}
