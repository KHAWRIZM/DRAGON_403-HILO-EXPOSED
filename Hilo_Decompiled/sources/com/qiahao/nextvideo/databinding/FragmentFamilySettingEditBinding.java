package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFamilySettingEditBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final EditText editText;
    public final TextView save;
    public final TextView textNumber;
    public final TextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFamilySettingEditBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, EditText editText, TextView textView, TextView textView2, TextView textView3, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.editText = editText;
        this.save = textView;
        this.textNumber = textView2;
        this.title = textView3;
        this.toolbar = toolbar;
    }

    public static FragmentFamilySettingEditBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFamilySettingEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFamilySettingEditBinding bind(View view, Object obj) {
        return (FragmentFamilySettingEditBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_family_setting_edit);
    }

    @Deprecated
    public static FragmentFamilySettingEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFamilySettingEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_setting_edit, viewGroup, z, obj);
    }

    public static FragmentFamilySettingEditBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFamilySettingEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFamilySettingEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_setting_edit, (ViewGroup) null, false, obj);
    }
}
