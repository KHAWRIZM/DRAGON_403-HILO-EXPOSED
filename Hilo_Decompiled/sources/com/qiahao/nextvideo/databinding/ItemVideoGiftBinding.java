package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemVideoGiftBinding extends ViewDataBinding {
    public final ImageView background;
    public final ConstraintLayout content;
    public final AppCompatTextView diamond;
    public final ImageView diamondImage;
    public final TextView giftName;
    public final ImageView iconCp;
    public final ImageView iconMedal;
    public final ImageView iconWeek;
    public final AppCompatImageView image;
    public final StackLayout timeContainer;
    public final AppCompatTextView timeText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemVideoGiftBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, ImageView imageView2, TextView textView, ImageView imageView3, ImageView imageView4, ImageView imageView5, AppCompatImageView appCompatImageView, StackLayout stackLayout, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.background = imageView;
        this.content = constraintLayout;
        this.diamond = appCompatTextView;
        this.diamondImage = imageView2;
        this.giftName = textView;
        this.iconCp = imageView3;
        this.iconMedal = imageView4;
        this.iconWeek = imageView5;
        this.image = appCompatImageView;
        this.timeContainer = stackLayout;
        this.timeText = appCompatTextView2;
    }

    public static ItemVideoGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemVideoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemVideoGiftBinding bind(View view, Object obj) {
        return (ItemVideoGiftBinding) ViewDataBinding.bind(obj, view, R.layout.item_video_gift);
    }

    @Deprecated
    public static ItemVideoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_gift, viewGroup, z, obj);
    }

    public static ItemVideoGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemVideoGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_gift, (ViewGroup) null, false, obj);
    }
}
