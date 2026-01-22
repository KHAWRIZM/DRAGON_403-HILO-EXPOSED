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
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSearchGroupViewBinding extends ViewDataBinding {
    public final ImageView countryImage;
    public final TextView groupAnnounce;
    public final TextView groupName;
    public final LinearLayout llCountry;
    public final LinearLayout llGroupAnnounce;
    public final LinearLayout llNumber;
    public final ImageView numberImage;
    public final TextView personNumber;
    public final RoundedImageView userAvatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSearchGroupViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, TextView textView3, RoundedImageView roundedImageView) {
        super(obj, view, i);
        this.countryImage = imageView;
        this.groupAnnounce = textView;
        this.groupName = textView2;
        this.llCountry = linearLayout;
        this.llGroupAnnounce = linearLayout2;
        this.llNumber = linearLayout3;
        this.numberImage = imageView2;
        this.personNumber = textView3;
        this.userAvatar = roundedImageView;
    }

    public static ItemSearchGroupViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSearchGroupViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSearchGroupViewBinding bind(View view, Object obj) {
        return (ItemSearchGroupViewBinding) ViewDataBinding.bind(obj, view, R.layout.item_search_group_view);
    }

    @Deprecated
    public static ItemSearchGroupViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchGroupViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_group_view, viewGroup, z, obj);
    }

    public static ItemSearchGroupViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSearchGroupViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchGroupViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_group_view, (ViewGroup) null, false, obj);
    }
}
