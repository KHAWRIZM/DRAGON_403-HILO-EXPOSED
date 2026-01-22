package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewSendGiftLinearlayoutBinding extends ViewDataBinding {
    public final TextView giftNumber;
    public final ConstraintLayout giftNumberSelector;
    public final TextView giftSendButton;
    public final ImageView tip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewSendGiftLinearlayoutBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.giftNumber = textView;
        this.giftNumberSelector = constraintLayout;
        this.giftSendButton = textView2;
        this.tip = imageView;
    }

    public static ViewSendGiftLinearlayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewSendGiftLinearlayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewSendGiftLinearlayoutBinding bind(View view, Object obj) {
        return (ViewSendGiftLinearlayoutBinding) ViewDataBinding.bind(obj, view, R.layout.view_send_gift_linearlayout);
    }

    @Deprecated
    public static ViewSendGiftLinearlayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewSendGiftLinearlayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_send_gift_linearlayout, viewGroup, z, obj);
    }

    public static ViewSendGiftLinearlayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewSendGiftLinearlayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewSendGiftLinearlayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_send_gift_linearlayout, (ViewGroup) null, false, obj);
    }
}
