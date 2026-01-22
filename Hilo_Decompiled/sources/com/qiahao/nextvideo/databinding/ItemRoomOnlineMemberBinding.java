package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomOnlineMemberBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatarCircle;
    public final ImageView iconNoble;
    public final ImageView iconSvip;
    public final ImageView iconVip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomOnlineMemberBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.avatarCircle = qMUIRadiusImageView;
        this.iconNoble = imageView;
        this.iconSvip = imageView2;
        this.iconVip = imageView3;
    }

    public static ItemRoomOnlineMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomOnlineMemberBinding bind(View view, Object obj) {
        return (ItemRoomOnlineMemberBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_online_member);
    }

    @Deprecated
    public static ItemRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomOnlineMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_online_member, viewGroup, z, obj);
    }

    public static ItemRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomOnlineMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_online_member, (ViewGroup) null, false, obj);
    }
}
