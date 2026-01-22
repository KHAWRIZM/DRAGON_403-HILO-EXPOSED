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
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyRoomBinding extends ViewDataBinding {
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final ImageView gameImage;
    public final TextView groupAnnounce;
    public final GroupMedalAndPowerLayout groupMedalAndPower;
    public final TextView groupName;
    public final ImageView groupSupportMedal;
    public final ImageView iconCount;
    public final LinearLayout linearLayout2;
    public final LinearLayout llRocket;
    public final TextView personNumber;
    public final ImageView rocket1;
    public final ImageView rocket2;
    public final ImageView rocket3;
    public final ImageView rocket4;
    public final ImageView rocket5;
    public final RoundedImageView roomAvatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyRoomBinding(Object obj, View view, int i, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, ImageView imageView, TextView textView, GroupMedalAndPowerLayout groupMedalAndPowerLayout, TextView textView2, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RoundedImageView roundedImageView) {
        super(obj, view, i);
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.gameImage = imageView;
        this.groupAnnounce = textView;
        this.groupMedalAndPower = groupMedalAndPowerLayout;
        this.groupName = textView2;
        this.groupSupportMedal = imageView2;
        this.iconCount = imageView3;
        this.linearLayout2 = linearLayout;
        this.llRocket = linearLayout2;
        this.personNumber = textView3;
        this.rocket1 = imageView4;
        this.rocket2 = imageView5;
        this.rocket3 = imageView6;
        this.rocket4 = imageView7;
        this.rocket5 = imageView8;
        this.roomAvatar = roundedImageView;
    }

    public static ItemFamilyRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyRoomBinding bind(View view, Object obj) {
        return (ItemFamilyRoomBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_room);
    }

    @Deprecated
    public static ItemFamilyRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_room, viewGroup, z, obj);
    }

    public static ItemFamilyRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_room, (ViewGroup) null, false, obj);
    }
}
