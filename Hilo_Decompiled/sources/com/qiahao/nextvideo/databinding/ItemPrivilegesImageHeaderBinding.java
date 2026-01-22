package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPrivilegesImageHeaderBinding extends ViewDataBinding {
    public final View line;
    public final SwitchButton selectButton;
    public final TextView selectText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPrivilegesImageHeaderBinding(Object obj, View view, int i, View view2, SwitchButton switchButton, TextView textView) {
        super(obj, view, i);
        this.line = view2;
        this.selectButton = switchButton;
        this.selectText = textView;
    }

    public static ItemPrivilegesImageHeaderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPrivilegesImageHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPrivilegesImageHeaderBinding bind(View view, Object obj) {
        return (ItemPrivilegesImageHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.item_privileges_image_header);
    }

    @Deprecated
    public static ItemPrivilegesImageHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPrivilegesImageHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_image_header, viewGroup, z, obj);
    }

    public static ItemPrivilegesImageHeaderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPrivilegesImageHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPrivilegesImageHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_image_header, (ViewGroup) null, false, obj);
    }
}
