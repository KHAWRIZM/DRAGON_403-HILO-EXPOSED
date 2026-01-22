package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFamilyMemberMoreBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton exit;
    public final AppCompatButton notAdmin;
    public final View notAdminLine;
    public final AppCompatButton profileButton;
    public final View profileLine;
    public final AppCompatButton quick;
    public final View quickLine;
    public final AppCompatButton setAdmin;
    public final View setAdminLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFamilyMemberMoreBinding(Object obj, View view, int i, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, View view3, AppCompatButton appCompatButton4, View view4, AppCompatButton appCompatButton5, View view5, AppCompatButton appCompatButton6, View view6) {
        super(obj, view, i);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.exit = appCompatButton2;
        this.notAdmin = appCompatButton3;
        this.notAdminLine = view3;
        this.profileButton = appCompatButton4;
        this.profileLine = view4;
        this.quick = appCompatButton5;
        this.quickLine = view5;
        this.setAdmin = appCompatButton6;
        this.setAdminLine = view6;
    }

    public static DialogFamilyMemberMoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFamilyMemberMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFamilyMemberMoreBinding bind(View view, Object obj) {
        return (DialogFamilyMemberMoreBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_family_member_more);
    }

    @Deprecated
    public static DialogFamilyMemberMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFamilyMemberMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_member_more, viewGroup, z, obj);
    }

    public static DialogFamilyMemberMoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFamilyMemberMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFamilyMemberMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_member_more, (ViewGroup) null, false, obj);
    }
}
