package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMatchPermissionsBinding extends ViewDataBinding {
    public final AppCompatButton allowButton;
    public final LinearLayoutCompat bgRoot;
    public final FrameLayout cameraFrameLayout;
    public final AppCompatTextView cameraGoToSettingsTextView;
    public final AppCompatTextView descriptionText;
    public final FrameLayout microphoneFrameLayout;
    public final AppCompatTextView microphoneGoToSettingsTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMatchPermissionsBinding(Object obj, View view, int i, AppCompatButton appCompatButton, LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, FrameLayout frameLayout2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.allowButton = appCompatButton;
        this.bgRoot = linearLayoutCompat;
        this.cameraFrameLayout = frameLayout;
        this.cameraGoToSettingsTextView = appCompatTextView;
        this.descriptionText = appCompatTextView2;
        this.microphoneFrameLayout = frameLayout2;
        this.microphoneGoToSettingsTextView = appCompatTextView3;
    }

    public static DialogMatchPermissionsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMatchPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMatchPermissionsBinding bind(View view, Object obj) {
        return (DialogMatchPermissionsBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_match_permissions);
    }

    @Deprecated
    public static DialogMatchPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMatchPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_match_permissions, viewGroup, z, obj);
    }

    public static DialogMatchPermissionsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMatchPermissionsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMatchPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_match_permissions, (ViewGroup) null, false, obj);
    }
}
