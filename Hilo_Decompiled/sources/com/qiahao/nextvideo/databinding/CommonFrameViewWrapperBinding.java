package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CommonFrameViewWrapperBinding extends ViewDataBinding {
    public final FrameLayout contentFrame;
    public final ConstraintLayout rootBack;
    public final ConstraintLayout rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonFrameViewWrapperBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.contentFrame = frameLayout;
        this.rootBack = constraintLayout;
        this.rootView = constraintLayout2;
    }

    public static CommonFrameViewWrapperBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CommonFrameViewWrapperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CommonFrameViewWrapperBinding bind(View view, Object obj) {
        return (CommonFrameViewWrapperBinding) ViewDataBinding.bind(obj, view, R.layout.common_frame_view_wrapper);
    }

    @Deprecated
    public static CommonFrameViewWrapperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CommonFrameViewWrapperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.common_frame_view_wrapper, viewGroup, z, obj);
    }

    public static CommonFrameViewWrapperBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CommonFrameViewWrapperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CommonFrameViewWrapperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.common_frame_view_wrapper, (ViewGroup) null, false, obj);
    }
}
