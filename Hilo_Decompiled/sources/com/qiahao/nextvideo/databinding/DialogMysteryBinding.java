package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMysteryBinding extends ViewDataBinding {
    public final ConstraintLayout buttonLayout;
    public final TextView checkDetails;
    public final ImageView downMic;
    public final ImageView exit;
    public final ImageView openMic;
    public final TextView subTitle;
    public final NickTextView title;
    public final CircleImageView userAvatar;
    public final ImageView userHeadImg;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMysteryBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView2, NickTextView nickTextView, CircleImageView circleImageView, ImageView imageView4) {
        super(obj, view, i);
        this.buttonLayout = constraintLayout;
        this.checkDetails = textView;
        this.downMic = imageView;
        this.exit = imageView2;
        this.openMic = imageView3;
        this.subTitle = textView2;
        this.title = nickTextView;
        this.userAvatar = circleImageView;
        this.userHeadImg = imageView4;
    }

    public static DialogMysteryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMysteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMysteryBinding bind(View view, Object obj) {
        return (DialogMysteryBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_mystery);
    }

    @Deprecated
    public static DialogMysteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMysteryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_mystery, viewGroup, z, obj);
    }

    public static DialogMysteryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMysteryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMysteryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_mystery, (ViewGroup) null, false, obj);
    }
}
