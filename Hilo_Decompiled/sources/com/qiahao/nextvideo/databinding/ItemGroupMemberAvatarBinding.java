package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemGroupMemberAvatarBinding implements a {
    public final CircleImageView avatarCircle;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatImageView memberTag;
    public final View onlineStatus;
    private final ConstraintLayout rootView;

    private ItemGroupMemberAvatarBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, ImageView imageView, ImageView imageView2, AppCompatImageView appCompatImageView, View view) {
        this.rootView = constraintLayout;
        this.avatarCircle = circleImageView;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.memberTag = appCompatImageView;
        this.onlineStatus = view;
    }

    public static ItemGroupMemberAvatarBinding bind(View view) {
        int i = R.id.avatar_circle;
        CircleImageView circleImageView = (CircleImageView) b.a(view, R.id.avatar_circle);
        if (circleImageView != null) {
            i = 2131363173;
            ImageView imageView = (ImageView) b.a(view, 2131363173);
            if (imageView != null) {
                i = 2131363182;
                ImageView imageView2 = (ImageView) b.a(view, 2131363182);
                if (imageView2 != null) {
                    i = R.id.member_tag;
                    AppCompatImageView a = b.a(view, R.id.member_tag);
                    if (a != null) {
                        i = R.id.online_status;
                        View a2 = b.a(view, R.id.online_status);
                        if (a2 != null) {
                            return new ItemGroupMemberAvatarBinding((ConstraintLayout) view, circleImageView, imageView, imageView2, a, a2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemGroupMemberAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemGroupMemberAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_group_member_avatar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
