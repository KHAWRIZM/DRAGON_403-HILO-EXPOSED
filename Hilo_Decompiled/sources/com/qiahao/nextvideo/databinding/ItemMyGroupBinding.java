package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMyGroupBinding extends ViewDataBinding {
    public final ImageView gameImage;
    public final TextView groupAnnounce;
    public final TextView groupName;
    public final ImageView iconCount;
    public final LinearLayout linearLayout2;
    public final LinearLayout llRocket;
    public final TextView onMicNumber;
    public final TextView personNumber;
    public final ImageView rocket1;
    public final ImageView rocket2;
    public final ImageView rocket3;
    public final ImageView rocket4;
    public final ImageView rocket5;
    public final RoundedImageView roomAvatar;
    public final ImageView roomImageHead;
    public final SVGAImageView roomSvga;
    public final LinearLayout userAvatarList;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMyGroupBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, TextView textView4, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RoundedImageView roundedImageView, ImageView imageView8, SVGAImageView sVGAImageView, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.gameImage = imageView;
        this.groupAnnounce = textView;
        this.groupName = textView2;
        this.iconCount = imageView2;
        this.linearLayout2 = linearLayout;
        this.llRocket = linearLayout2;
        this.onMicNumber = textView3;
        this.personNumber = textView4;
        this.rocket1 = imageView3;
        this.rocket2 = imageView4;
        this.rocket3 = imageView5;
        this.rocket4 = imageView6;
        this.rocket5 = imageView7;
        this.roomAvatar = roundedImageView;
        this.roomImageHead = imageView8;
        this.roomSvga = sVGAImageView;
        this.userAvatarList = linearLayout3;
    }

    public static ItemMyGroupBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMyGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMyGroupBinding bind(View view, Object obj) {
        return (ItemMyGroupBinding) ViewDataBinding.bind(obj, view, R.layout.item_my_group);
    }

    @Deprecated
    public static ItemMyGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMyGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_group, viewGroup, z, obj);
    }

    public static ItemMyGroupBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMyGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMyGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_group, (ViewGroup) null, false, obj);
    }
}
