package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;
import com.qiahao.base_common.ui.wheel.WheelItemView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogSelectPickerBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final WheelItemView selectView;
    public final LinearLayout timepicker;
    public final FrameLayout title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSelectPickerBinding(Object obj, View view, int i10, TextView textView, TextView textView2, WheelItemView wheelItemView, LinearLayout linearLayout, FrameLayout frameLayout) {
        super(obj, view, i10);
        this.cancel = textView;
        this.confirm = textView2;
        this.selectView = wheelItemView;
        this.timepicker = linearLayout;
        this.title = frameLayout;
    }

    public static DialogSelectPickerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogSelectPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogSelectPickerBinding bind(View view, Object obj) {
        return (DialogSelectPickerBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_select_picker);
    }

    @Deprecated
    public static DialogSelectPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogSelectPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_select_picker, viewGroup, z10, obj);
    }

    public static DialogSelectPickerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogSelectPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSelectPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_select_picker, null, false, obj);
    }
}
