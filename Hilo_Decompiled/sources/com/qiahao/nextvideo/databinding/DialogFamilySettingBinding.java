package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFamilySettingBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFamilySettingBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static DialogFamilySettingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFamilySettingBinding bind(View view, Object obj) {
        return (DialogFamilySettingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_family_setting);
    }

    @Deprecated
    public static DialogFamilySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_setting, viewGroup, z, obj);
    }

    public static DialogFamilySettingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFamilySettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFamilySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_setting, (ViewGroup) null, false, obj);
    }
}
