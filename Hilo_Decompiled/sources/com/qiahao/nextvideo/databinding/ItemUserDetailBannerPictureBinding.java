package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemUserDetailBannerPictureBinding implements a {
    public final ConstraintLayout bodyView;
    private final ConstraintLayout rootView;
    public final AppCompatImageView userProfilePictureImageView;

    private ItemUserDetailBannerPictureBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView) {
        this.rootView = constraintLayout;
        this.bodyView = constraintLayout2;
        this.userProfilePictureImageView = appCompatImageView;
    }

    public static ItemUserDetailBannerPictureBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        AppCompatImageView a = b.a(view, R.id.user_profile_picture_image_view);
        if (a != null) {
            return new ItemUserDetailBannerPictureBinding(constraintLayout, constraintLayout, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.user_profile_picture_image_view)));
    }

    public static ItemUserDetailBannerPictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUserDetailBannerPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_user_detail_banner_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
