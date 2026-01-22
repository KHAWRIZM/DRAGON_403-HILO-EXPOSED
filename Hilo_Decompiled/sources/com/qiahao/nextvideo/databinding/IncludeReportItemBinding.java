package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeReportItemBinding extends ViewDataBinding {
    public final AppCompatTextView button;
    public final View line;
    public final ImageView svipType;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeReportItemBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, View view2, ImageView imageView) {
        super(obj, view, i);
        this.button = appCompatTextView;
        this.line = view2;
        this.svipType = imageView;
    }

    public static IncludeReportItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeReportItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeReportItemBinding bind(View view, Object obj) {
        return (IncludeReportItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_report_item);
    }

    @Deprecated
    public static IncludeReportItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeReportItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_report_item, viewGroup, z, obj);
    }

    public static IncludeReportItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeReportItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeReportItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_report_item, (ViewGroup) null, false, obj);
    }
}
