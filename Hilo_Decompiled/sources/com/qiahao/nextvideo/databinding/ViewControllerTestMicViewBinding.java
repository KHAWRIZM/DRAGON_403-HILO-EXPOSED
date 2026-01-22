package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerTestMicViewBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final TextView changeType;
    public final NewMicroView microView;
    public final TextView selectPic;
    public final AppCompatTextView title;
    public final Toolbar toolbar;
    public final ImageView userAvatar;
    public final CircleImageView userAvatar1;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerTestMicViewBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView, NewMicroView newMicroView, TextView textView2, AppCompatTextView appCompatTextView, Toolbar toolbar, ImageView imageView, CircleImageView circleImageView) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.changeType = textView;
        this.microView = newMicroView;
        this.selectPic = textView2;
        this.title = appCompatTextView;
        this.toolbar = toolbar;
        this.userAvatar = imageView;
        this.userAvatar1 = circleImageView;
    }

    public static ViewControllerTestMicViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerTestMicViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerTestMicViewBinding bind(View view, Object obj) {
        return (ViewControllerTestMicViewBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_test_mic_view);
    }

    @Deprecated
    public static ViewControllerTestMicViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerTestMicViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_test_mic_view, viewGroup, z, obj);
    }

    public static ViewControllerTestMicViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerTestMicViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerTestMicViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_test_mic_view, (ViewGroup) null, false, obj);
    }
}
