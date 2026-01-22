package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogNotificationPermissionBinding extends ViewDataBinding {
    public final AppCompatButton confirmButton;
    public final AppCompatTextView descriptionTextView;
    public final AppCompatImageView dismissImageView;
    public final AppCompatImageView userAvatarRepickImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogNotificationPermissionBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        super(obj, view, i);
        this.confirmButton = appCompatButton;
        this.descriptionTextView = appCompatTextView;
        this.dismissImageView = appCompatImageView;
        this.userAvatarRepickImageView = appCompatImageView2;
    }

    public static DialogNotificationPermissionBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogNotificationPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogNotificationPermissionBinding bind(View view, Object obj) {
        return (DialogNotificationPermissionBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_notification_permission);
    }

    @Deprecated
    public static DialogNotificationPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogNotificationPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notification_permission, viewGroup, z, obj);
    }

    public static DialogNotificationPermissionBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogNotificationPermissionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogNotificationPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notification_permission, (ViewGroup) null, false, obj);
    }
}
