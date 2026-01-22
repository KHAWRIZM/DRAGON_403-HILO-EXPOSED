package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerAlertAgoraConfigureBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final AppCompatEditText channelIdEditText;
    public final AppCompatButton confirmButton;
    public final AppCompatEditText fromUserIdTextView;
    public final AppCompatEditText toUserIdTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerAlertAgoraConfigureBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, AppCompatButton appCompatButton2, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3) {
        super(obj, view, i);
        this.cancelButton = appCompatButton;
        this.channelIdEditText = appCompatEditText;
        this.confirmButton = appCompatButton2;
        this.fromUserIdTextView = appCompatEditText2;
        this.toUserIdTextView = appCompatEditText3;
    }

    public static ViewControllerAlertAgoraConfigureBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerAlertAgoraConfigureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerAlertAgoraConfigureBinding bind(View view, Object obj) {
        return (ViewControllerAlertAgoraConfigureBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_alert_agora_configure);
    }

    @Deprecated
    public static ViewControllerAlertAgoraConfigureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerAlertAgoraConfigureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_alert_agora_configure, viewGroup, z, obj);
    }

    public static ViewControllerAlertAgoraConfigureBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerAlertAgoraConfigureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerAlertAgoraConfigureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_alert_agora_configure, (ViewGroup) null, false, obj);
    }
}
