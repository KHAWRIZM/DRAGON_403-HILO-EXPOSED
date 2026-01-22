package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerRongImTestBinding extends ViewDataBinding {
    public final AppCompatButton joinChatroomAButton;
    public final AppCompatButton joinChatroomBButton;
    public final AppCompatButton joinChatroomCButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerRongImTestBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3) {
        super(obj, view, i);
        this.joinChatroomAButton = appCompatButton;
        this.joinChatroomBButton = appCompatButton2;
        this.joinChatroomCButton = appCompatButton3;
    }

    public static ViewControllerRongImTestBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerRongImTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerRongImTestBinding bind(View view, Object obj) {
        return (ViewControllerRongImTestBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_rong_im_test);
    }

    @Deprecated
    public static ViewControllerRongImTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerRongImTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_rong_im_test, viewGroup, z, obj);
    }

    public static ViewControllerRongImTestBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerRongImTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerRongImTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_rong_im_test, (ViewGroup) null, false, obj);
    }
}
