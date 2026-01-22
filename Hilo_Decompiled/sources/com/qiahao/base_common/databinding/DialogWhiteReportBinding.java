package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogWhiteReportBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final AppCompatButton confirmReportButton;
    public final AppCompatTextView descriptionText;
    public final AppCompatRadioButton firstRadioButton;
    public final AppCompatRadioButton fourRadioButton;
    public final RadioGroup reportTypesRadioGroup;
    public final AppCompatRadioButton secondRadioButton;
    public final AppCompatRadioButton threeRadioButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWhiteReportBinding(Object obj, View view, int i10, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatTextView appCompatTextView, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, RadioGroup radioGroup, AppCompatRadioButton appCompatRadioButton3, AppCompatRadioButton appCompatRadioButton4) {
        super(obj, view, i10);
        this.cancelButton = appCompatButton;
        this.confirmReportButton = appCompatButton2;
        this.descriptionText = appCompatTextView;
        this.firstRadioButton = appCompatRadioButton;
        this.fourRadioButton = appCompatRadioButton2;
        this.reportTypesRadioGroup = radioGroup;
        this.secondRadioButton = appCompatRadioButton3;
        this.threeRadioButton = appCompatRadioButton4;
    }

    public static DialogWhiteReportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogWhiteReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogWhiteReportBinding bind(View view, Object obj) {
        return (DialogWhiteReportBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_white_report);
    }

    @Deprecated
    public static DialogWhiteReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogWhiteReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_white_report, viewGroup, z10, obj);
    }

    public static DialogWhiteReportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogWhiteReportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWhiteReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_white_report, null, false, obj);
    }
}
