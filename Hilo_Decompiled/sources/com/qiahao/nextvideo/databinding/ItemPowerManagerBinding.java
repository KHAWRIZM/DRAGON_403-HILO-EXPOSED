package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPowerManagerBinding extends ViewDataBinding {
    public final ImageView powerMedal;
    public final CircleImageView userAvatarCimageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPowerManagerBinding(Object obj, View view, int i, ImageView imageView, CircleImageView circleImageView) {
        super(obj, view, i);
        this.powerMedal = imageView;
        this.userAvatarCimageView = circleImageView;
    }

    public static ItemPowerManagerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPowerManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPowerManagerBinding bind(View view, Object obj) {
        return (ItemPowerManagerBinding) ViewDataBinding.bind(obj, view, R.layout.item_power_manager);
    }

    @Deprecated
    public static ItemPowerManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPowerManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_manager, viewGroup, z, obj);
    }

    public static ItemPowerManagerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPowerManagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPowerManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_manager, (ViewGroup) null, false, obj);
    }
}
