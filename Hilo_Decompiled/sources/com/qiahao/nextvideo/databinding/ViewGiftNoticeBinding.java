package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGiftNoticeBinding extends ViewDataBinding {
    public final AppCompatImageView bg;
    public final QMUIRadiusImageView2 circleImageView;
    public final AppCompatTextView comboGiftCountTipTextView;
    public final ConstraintLayout constraint;
    public final AppCompatTextView fromNicknameTextView;
    public final AppCompatImageView giftIconImageView;
    public final AppCompatTextView send;
    public final AppCompatTextView toNicknameTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGiftNoticeBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, QMUIRadiusImageView2 qMUIRadiusImageView2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.bg = appCompatImageView;
        this.circleImageView = qMUIRadiusImageView2;
        this.comboGiftCountTipTextView = appCompatTextView;
        this.constraint = constraintLayout;
        this.fromNicknameTextView = appCompatTextView2;
        this.giftIconImageView = appCompatImageView2;
        this.send = appCompatTextView3;
        this.toNicknameTextView = appCompatTextView4;
    }

    public static ViewGiftNoticeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGiftNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGiftNoticeBinding bind(View view, Object obj) {
        return (ViewGiftNoticeBinding) ViewDataBinding.bind(obj, view, R.layout.view_gift_notice);
    }

    @Deprecated
    public static ViewGiftNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGiftNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_notice, viewGroup, z, obj);
    }

    public static ViewGiftNoticeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGiftNoticeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGiftNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_notice, (ViewGroup) null, false, obj);
    }
}
