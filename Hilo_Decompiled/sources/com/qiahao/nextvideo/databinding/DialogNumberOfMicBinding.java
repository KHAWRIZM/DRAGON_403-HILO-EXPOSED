package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogNumberOfMicBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final View closeMic;
    public final TextView confirmButton;
    public final View fiveMic;
    public final EditText levelEdit;
    public final LinearLayout llCloseMic;
    public final LinearLayout llFiveMic;
    public final LinearLayout llLevelEdit;
    public final LinearLayout llTenMic;
    protected View.OnClickListener mClick;
    public final LinearLayout radioGroup;
    public final View tenMic;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogNumberOfMicBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, View view2, TextView textView2, View view3, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view4, TextView textView3) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.closeMic = view2;
        this.confirmButton = textView2;
        this.fiveMic = view3;
        this.levelEdit = editText;
        this.llCloseMic = linearLayout2;
        this.llFiveMic = linearLayout3;
        this.llLevelEdit = linearLayout4;
        this.llTenMic = linearLayout5;
        this.radioGroup = linearLayout6;
        this.tenMic = view4;
        this.title = textView3;
    }

    public static DialogNumberOfMicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogNumberOfMicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogNumberOfMicBinding bind(View view, Object obj) {
        return (DialogNumberOfMicBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_number_of_mic);
    }

    @Deprecated
    public static DialogNumberOfMicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogNumberOfMicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_of_mic, viewGroup, z, obj);
    }

    public static DialogNumberOfMicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogNumberOfMicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogNumberOfMicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_of_mic, (ViewGroup) null, false, obj);
    }
}
