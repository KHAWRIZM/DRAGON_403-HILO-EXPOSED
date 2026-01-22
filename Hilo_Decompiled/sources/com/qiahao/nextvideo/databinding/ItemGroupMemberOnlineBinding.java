package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupMemberOnlineBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final HiloGradeView charmLevel;
    public final ImageView countryImage;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final ImageView imagMounts;
    public final LinearLayout llLevel;
    public final TextView onlineStatus;
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;
    public final ImageView userTag;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupMemberOnlineBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, HiloGradeView hiloGradeView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView, CircleImageView circleImageView, TextView textView2, ImageView imageView5, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.charmLevel = hiloGradeView;
        this.countryImage = imageView;
        this.iconNoble = imageView2;
        this.iconVip = imageView3;
        this.imagMounts = imageView4;
        this.llLevel = linearLayout;
        this.onlineStatus = textView;
        this.userAvatarCimageView = circleImageView;
        this.userName = textView2;
        this.userTag = imageView5;
        this.wealthLevel = hiloGradeView2;
    }

    public static ItemGroupMemberOnlineBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupMemberOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupMemberOnlineBinding bind(View view, Object obj) {
        return (ItemGroupMemberOnlineBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_member_online);
    }

    @Deprecated
    public static ItemGroupMemberOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupMemberOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_member_online, viewGroup, z, obj);
    }

    public static ItemGroupMemberOnlineBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupMemberOnlineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupMemberOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_member_online, (ViewGroup) null, false, obj);
    }
}
