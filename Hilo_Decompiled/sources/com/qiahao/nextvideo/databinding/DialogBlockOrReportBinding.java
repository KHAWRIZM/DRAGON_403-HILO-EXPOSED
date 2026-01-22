package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogBlockOrReportBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final IncludeReportItemBinding fiveLayout;
    public final IncludeReportItemBinding fourLayout;
    public final IncludeReportItemBinding oneLayout;
    public final IncludeReportItemBinding sevenLayout;
    public final IncludeReportItemBinding sixLayout;
    public final IncludeReportItemBinding threeLayout;
    public final IncludeReportItemBinding twoLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogBlockOrReportBinding(Object obj, View view, int i, AppCompatButton appCompatButton, IncludeReportItemBinding includeReportItemBinding, IncludeReportItemBinding includeReportItemBinding2, IncludeReportItemBinding includeReportItemBinding3, IncludeReportItemBinding includeReportItemBinding4, IncludeReportItemBinding includeReportItemBinding5, IncludeReportItemBinding includeReportItemBinding6, IncludeReportItemBinding includeReportItemBinding7) {
        super(obj, view, i);
        this.cancelButton = appCompatButton;
        this.fiveLayout = includeReportItemBinding;
        this.fourLayout = includeReportItemBinding2;
        this.oneLayout = includeReportItemBinding3;
        this.sevenLayout = includeReportItemBinding4;
        this.sixLayout = includeReportItemBinding5;
        this.threeLayout = includeReportItemBinding6;
        this.twoLayout = includeReportItemBinding7;
    }

    public static DialogBlockOrReportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogBlockOrReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogBlockOrReportBinding bind(View view, Object obj) {
        return (DialogBlockOrReportBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_block_or_report);
    }

    @Deprecated
    public static DialogBlockOrReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBlockOrReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_block_or_report, viewGroup, z, obj);
    }

    public static DialogBlockOrReportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogBlockOrReportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBlockOrReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_block_or_report, (ViewGroup) null, false, obj);
    }
}
