package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomGiftBinding extends ViewDataBinding {
    public final ImageView background;
    public final LinearLayout buttonLayout;
    public final ConstraintLayout content;
    public final AppCompatTextView diamond;
    public final ImageView diamondImage;
    public final TextView giftName;
    public final ImageView icon3D;
    public final ImageView iconActivity;
    public final ImageView iconCp;
    public final ImageView iconMedal;
    public final ImageView iconWeek;
    public final AppCompatImageView image;
    public final StackLayout timeContainer;
    public final AppCompatTextView timeText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomGiftBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, ImageView imageView2, TextView textView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, AppCompatImageView appCompatImageView, StackLayout stackLayout, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.background = imageView;
        this.buttonLayout = linearLayout;
        this.content = constraintLayout;
        this.diamond = appCompatTextView;
        this.diamondImage = imageView2;
        this.giftName = textView;
        this.icon3D = imageView3;
        this.iconActivity = imageView4;
        this.iconCp = imageView5;
        this.iconMedal = imageView6;
        this.iconWeek = imageView7;
        this.image = appCompatImageView;
        this.timeContainer = stackLayout;
        this.timeText = appCompatTextView2;
    }

    public static ItemRoomGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomGiftBinding bind(View view, Object obj) {
        return (ItemRoomGiftBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_gift);
    }

    @Deprecated
    public static ItemRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_gift, viewGroup, z, obj);
    }

    public static ItemRoomGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_gift, (ViewGroup) null, false, obj);
    }
}
