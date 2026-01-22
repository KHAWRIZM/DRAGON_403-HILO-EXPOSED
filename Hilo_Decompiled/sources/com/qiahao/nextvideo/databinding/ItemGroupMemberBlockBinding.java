package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupMemberBlockBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final ImageView removeUser;
    public final TextView time;
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupMemberBlockBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, ImageView imageView, TextView textView, CircleImageView circleImageView, TextView textView2) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.removeUser = imageView;
        this.time = textView;
        this.userAvatarCimageView = circleImageView;
        this.userName = textView2;
    }

    public static ItemGroupMemberBlockBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupMemberBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupMemberBlockBinding bind(View view, Object obj) {
        return (ItemGroupMemberBlockBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_member_block);
    }

    @Deprecated
    public static ItemGroupMemberBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupMemberBlockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_member_block, viewGroup, z, obj);
    }

    public static ItemGroupMemberBlockBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupMemberBlockBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupMemberBlockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_member_block, (ViewGroup) null, false, obj);
    }
}
