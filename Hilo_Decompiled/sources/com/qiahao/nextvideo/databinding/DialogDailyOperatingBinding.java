package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogDailyOperatingBinding extends ViewDataBinding {
    public final ConstraintLayout content;
    public final ImageView dismissView;
    public final RoundedImageView imgPic;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogDailyOperatingBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, RoundedImageView roundedImageView) {
        super(obj, view, i);
        this.content = constraintLayout;
        this.dismissView = imageView;
        this.imgPic = roundedImageView;
    }

    public static DialogDailyOperatingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogDailyOperatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogDailyOperatingBinding bind(View view, Object obj) {
        return (DialogDailyOperatingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_daily_operating);
    }

    @Deprecated
    public static DialogDailyOperatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDailyOperatingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_operating, viewGroup, z, obj);
    }

    public static DialogDailyOperatingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogDailyOperatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDailyOperatingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_operating, (ViewGroup) null, false, obj);
    }
}
