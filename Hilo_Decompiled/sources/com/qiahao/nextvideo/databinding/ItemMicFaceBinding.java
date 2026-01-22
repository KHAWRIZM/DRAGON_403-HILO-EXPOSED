package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMicFaceBinding extends ViewDataBinding {
    public final ImageView faceImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMicFaceBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.faceImage = imageView;
    }

    public static ItemMicFaceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMicFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMicFaceBinding bind(View view, Object obj) {
        return (ItemMicFaceBinding) ViewDataBinding.bind(obj, view, R.layout.item_mic_face);
    }

    @Deprecated
    public static ItemMicFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMicFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mic_face, viewGroup, z, obj);
    }

    public static ItemMicFaceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMicFaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMicFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mic_face, (ViewGroup) null, false, obj);
    }
}
