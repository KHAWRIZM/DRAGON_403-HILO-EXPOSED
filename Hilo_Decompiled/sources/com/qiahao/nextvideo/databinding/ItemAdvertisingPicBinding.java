package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemAdvertisingPicBinding implements a {
    public final AppCompatImageView adImageView;
    public final ConstraintLayout bodyView;
    public final Group group3;
    public final QMUIRadiusImageView oneImage;
    private final ConstraintLayout rootView;
    public final QMUIRadiusImageView threeImage1;
    public final QMUIRadiusImageView threeImage2;
    public final QMUIRadiusImageView threeImage3;
    public final ImageView threeImageHead1;
    public final ImageView threeImageHead2;
    public final ImageView threeImageHead3;
    public final QMUIRadiusImageView twoImage1;
    public final QMUIRadiusImageView twoImage2;

    private ItemAdvertisingPicBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, Group group, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, QMUIRadiusImageView qMUIRadiusImageView3, QMUIRadiusImageView qMUIRadiusImageView4, ImageView imageView, ImageView imageView2, ImageView imageView3, QMUIRadiusImageView qMUIRadiusImageView5, QMUIRadiusImageView qMUIRadiusImageView6) {
        this.rootView = constraintLayout;
        this.adImageView = appCompatImageView;
        this.bodyView = constraintLayout2;
        this.group3 = group;
        this.oneImage = qMUIRadiusImageView;
        this.threeImage1 = qMUIRadiusImageView2;
        this.threeImage2 = qMUIRadiusImageView3;
        this.threeImage3 = qMUIRadiusImageView4;
        this.threeImageHead1 = imageView;
        this.threeImageHead2 = imageView2;
        this.threeImageHead3 = imageView3;
        this.twoImage1 = qMUIRadiusImageView5;
        this.twoImage2 = qMUIRadiusImageView6;
    }

    public static ItemAdvertisingPicBinding bind(View view) {
        int i = R.id.ad_image_view;
        AppCompatImageView a = b.a(view, R.id.ad_image_view);
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.group3;
            Group a2 = b.a(view, R.id.group3);
            if (a2 != null) {
                i = R.id.oneImage;
                QMUIRadiusImageView a3 = b.a(view, R.id.oneImage);
                if (a3 != null) {
                    i = R.id.threeImage1;
                    QMUIRadiusImageView a4 = b.a(view, R.id.threeImage1);
                    if (a4 != null) {
                        i = R.id.threeImage2;
                        QMUIRadiusImageView a5 = b.a(view, R.id.threeImage2);
                        if (a5 != null) {
                            i = R.id.threeImage3;
                            QMUIRadiusImageView a6 = b.a(view, R.id.threeImage3);
                            if (a6 != null) {
                                i = R.id.threeImageHead1;
                                ImageView imageView = (ImageView) b.a(view, R.id.threeImageHead1);
                                if (imageView != null) {
                                    i = R.id.threeImageHead2;
                                    ImageView imageView2 = (ImageView) b.a(view, R.id.threeImageHead2);
                                    if (imageView2 != null) {
                                        i = R.id.threeImageHead3;
                                        ImageView imageView3 = (ImageView) b.a(view, R.id.threeImageHead3);
                                        if (imageView3 != null) {
                                            i = R.id.twoImage1;
                                            QMUIRadiusImageView a7 = b.a(view, R.id.twoImage1);
                                            if (a7 != null) {
                                                i = R.id.twoImage2;
                                                QMUIRadiusImageView a8 = b.a(view, R.id.twoImage2);
                                                if (a8 != null) {
                                                    return new ItemAdvertisingPicBinding(constraintLayout, a, constraintLayout, a2, a3, a4, a5, a6, imageView, imageView2, imageView3, a7, a8);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemAdvertisingPicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAdvertisingPicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_advertising_pic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
