package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutTestShapeImageViewBinding extends ViewDataBinding {
    public final FrameLayout contentBg;
    public final Button showSplash;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutTestShapeImageViewBinding(Object obj, View view, int i, FrameLayout frameLayout, Button button) {
        super(obj, view, i);
        this.contentBg = frameLayout;
        this.showSplash = button;
    }

    public static LayoutTestShapeImageViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutTestShapeImageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutTestShapeImageViewBinding bind(View view, Object obj) {
        return (LayoutTestShapeImageViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_test_shape_image_view);
    }

    @Deprecated
    public static LayoutTestShapeImageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutTestShapeImageViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_test_shape_image_view, viewGroup, z, obj);
    }

    public static LayoutTestShapeImageViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutTestShapeImageViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutTestShapeImageViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_test_shape_image_view, (ViewGroup) null, false, obj);
    }
}
