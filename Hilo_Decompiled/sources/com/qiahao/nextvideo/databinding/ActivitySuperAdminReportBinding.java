package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySuperAdminReportBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatTextView description;
    public final AppCompatEditText editText;
    public final TextView harassment;
    public final AppCompatTextView lengthTextView;
    public final TextView official;
    public final TextView oneDay;
    public final TextView permanent;
    public final TextView privacy;
    public final AppCompatTextView reason;
    public final RecyclerView recyclerView;
    public final TextView submit;
    public final Group svipGroup;
    public final TextView threeDay;
    public final AppCompatTextView time;
    public final IncludeTitleWriteBinding titleBar;
    public final TextView twoDay;
    public final AppCompatTextView videoTip;
    public final TextView violation;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySuperAdminReportBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, TextView textView, AppCompatTextView appCompatTextView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView3, RecyclerView recyclerView, TextView textView6, Group group, TextView textView7, AppCompatTextView appCompatTextView4, IncludeTitleWriteBinding includeTitleWriteBinding, TextView textView8, AppCompatTextView appCompatTextView5, TextView textView9) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.description = appCompatTextView;
        this.editText = appCompatEditText;
        this.harassment = textView;
        this.lengthTextView = appCompatTextView2;
        this.official = textView2;
        this.oneDay = textView3;
        this.permanent = textView4;
        this.privacy = textView5;
        this.reason = appCompatTextView3;
        this.recyclerView = recyclerView;
        this.submit = textView6;
        this.svipGroup = group;
        this.threeDay = textView7;
        this.time = appCompatTextView4;
        this.titleBar = includeTitleWriteBinding;
        this.twoDay = textView8;
        this.videoTip = appCompatTextView5;
        this.violation = textView9;
    }

    public static ActivitySuperAdminReportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySuperAdminReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySuperAdminReportBinding bind(View view, Object obj) {
        return (ActivitySuperAdminReportBinding) ViewDataBinding.bind(obj, view, R.layout.activity_super_admin_report);
    }

    @Deprecated
    public static ActivitySuperAdminReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySuperAdminReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_admin_report, viewGroup, z, obj);
    }

    public static ActivitySuperAdminReportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySuperAdminReportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySuperAdminReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_admin_report, (ViewGroup) null, false, obj);
    }
}
