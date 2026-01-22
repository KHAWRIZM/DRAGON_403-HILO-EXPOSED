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
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupSupportBinding extends ViewDataBinding {
    public final ImageView deleteButton;
    public final TextView emptyPosition;
    public final ConstraintLayout llAdd;
    public final ConstraintLayout llOwner;
    public final CircleImageView ownerAvatar;
    public final TextView ownerId;
    public final TextView ownerName;
    public final TextView position;
    public final ImageView supportAddUser;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupSupportBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CircleImageView circleImageView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2) {
        super(obj, view, i);
        this.deleteButton = imageView;
        this.emptyPosition = textView;
        this.llAdd = constraintLayout;
        this.llOwner = constraintLayout2;
        this.ownerAvatar = circleImageView;
        this.ownerId = textView2;
        this.ownerName = textView3;
        this.position = textView4;
        this.supportAddUser = imageView2;
    }

    public static ItemGroupSupportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupSupportBinding bind(View view, Object obj) {
        return (ItemGroupSupportBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_support);
    }

    @Deprecated
    public static ItemGroupSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_support, viewGroup, z, obj);
    }

    public static ItemGroupSupportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupSupportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_support, (ViewGroup) null, false, obj);
    }
}
