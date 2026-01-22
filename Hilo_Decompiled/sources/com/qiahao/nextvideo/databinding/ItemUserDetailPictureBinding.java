package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemUserDetailPictureBinding implements a {
    public final ConstraintLayout bodyView;
    public final AppCompatImageView imgEmpty;
    public final CorneredImageView imgPic;
    public final AppCompatImageView imgPicEditOrDelete;
    private final ConstraintLayout rootView;

    private ItemUserDetailPictureBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, CorneredImageView corneredImageView, AppCompatImageView appCompatImageView2) {
        this.rootView = constraintLayout;
        this.bodyView = constraintLayout2;
        this.imgEmpty = appCompatImageView;
        this.imgPic = corneredImageView;
        this.imgPicEditOrDelete = appCompatImageView2;
    }

    public static ItemUserDetailPictureBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.img_empty;
        AppCompatImageView a = b.a(view, R.id.img_empty);
        if (a != null) {
            i = R.id.img_pic;
            CorneredImageView corneredImageView = (CorneredImageView) b.a(view, R.id.img_pic);
            if (corneredImageView != null) {
                i = R.id.img_pic_edit_or_delete;
                AppCompatImageView a2 = b.a(view, R.id.img_pic_edit_or_delete);
                if (a2 != null) {
                    return new ItemUserDetailPictureBinding(constraintLayout, constraintLayout, a, corneredImageView, a2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemUserDetailPictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUserDetailPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_user_detail_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
