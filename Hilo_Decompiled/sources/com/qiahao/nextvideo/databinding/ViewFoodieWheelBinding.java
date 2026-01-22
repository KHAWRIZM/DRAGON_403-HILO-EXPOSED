package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.foodie.FoodieItemView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewFoodieWheelBinding implements a {
    public final ConstraintLayout flResult;
    public final FoodieItemView foodieItem0;
    public final FoodieItemView foodieItem1;
    public final FoodieItemView foodieItem2;
    public final FoodieItemView foodieItem3;
    public final FoodieItemView foodieItem4;
    public final FoodieItemView foodieItem5;
    public final FoodieItemView foodieItem6;
    public final FoodieItemView foodieItem7;
    public final ImageView ivCenterMarquee;
    public final ImageView ivCenterTop;
    public final ImageView ivDog;
    private final ConstraintLayout rootView;
    public final TextView tvCountDownTime;
    public final TextView tvResult;
    public final TextView tvResult2;
    public final TextView tvSelectTips;
    public final View vCenter;

    private ViewFoodieWheelBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FoodieItemView foodieItemView, FoodieItemView foodieItemView2, FoodieItemView foodieItemView3, FoodieItemView foodieItemView4, FoodieItemView foodieItemView5, FoodieItemView foodieItemView6, FoodieItemView foodieItemView7, FoodieItemView foodieItemView8, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.rootView = constraintLayout;
        this.flResult = constraintLayout2;
        this.foodieItem0 = foodieItemView;
        this.foodieItem1 = foodieItemView2;
        this.foodieItem2 = foodieItemView3;
        this.foodieItem3 = foodieItemView4;
        this.foodieItem4 = foodieItemView5;
        this.foodieItem5 = foodieItemView6;
        this.foodieItem6 = foodieItemView7;
        this.foodieItem7 = foodieItemView8;
        this.ivCenterMarquee = imageView;
        this.ivCenterTop = imageView2;
        this.ivDog = imageView3;
        this.tvCountDownTime = textView;
        this.tvResult = textView2;
        this.tvResult2 = textView3;
        this.tvSelectTips = textView4;
        this.vCenter = view;
    }

    public static ViewFoodieWheelBinding bind(View view) {
        int i = R.id.flResult;
        ConstraintLayout a = b.a(view, R.id.flResult);
        if (a != null) {
            i = R.id.foodieItem0;
            FoodieItemView foodieItemView = (FoodieItemView) b.a(view, R.id.foodieItem0);
            if (foodieItemView != null) {
                i = R.id.foodieItem1;
                FoodieItemView foodieItemView2 = (FoodieItemView) b.a(view, R.id.foodieItem1);
                if (foodieItemView2 != null) {
                    i = R.id.foodieItem2;
                    FoodieItemView foodieItemView3 = (FoodieItemView) b.a(view, R.id.foodieItem2);
                    if (foodieItemView3 != null) {
                        i = R.id.foodieItem3;
                        FoodieItemView foodieItemView4 = (FoodieItemView) b.a(view, R.id.foodieItem3);
                        if (foodieItemView4 != null) {
                            i = R.id.foodieItem4;
                            FoodieItemView foodieItemView5 = (FoodieItemView) b.a(view, R.id.foodieItem4);
                            if (foodieItemView5 != null) {
                                i = R.id.foodieItem5;
                                FoodieItemView foodieItemView6 = (FoodieItemView) b.a(view, R.id.foodieItem5);
                                if (foodieItemView6 != null) {
                                    i = R.id.foodieItem6;
                                    FoodieItemView foodieItemView7 = (FoodieItemView) b.a(view, R.id.foodieItem6);
                                    if (foodieItemView7 != null) {
                                        i = R.id.foodieItem7;
                                        FoodieItemView foodieItemView8 = (FoodieItemView) b.a(view, R.id.foodieItem7);
                                        if (foodieItemView8 != null) {
                                            i = R.id.ivCenterMarquee;
                                            ImageView imageView = (ImageView) b.a(view, R.id.ivCenterMarquee);
                                            if (imageView != null) {
                                                i = R.id.ivCenterTop;
                                                ImageView imageView2 = (ImageView) b.a(view, R.id.ivCenterTop);
                                                if (imageView2 != null) {
                                                    i = R.id.ivDog;
                                                    ImageView imageView3 = (ImageView) b.a(view, R.id.ivDog);
                                                    if (imageView3 != null) {
                                                        i = R.id.tvCountDownTime;
                                                        TextView textView = (TextView) b.a(view, R.id.tvCountDownTime);
                                                        if (textView != null) {
                                                            i = R.id.tvResult;
                                                            TextView textView2 = (TextView) b.a(view, R.id.tvResult);
                                                            if (textView2 != null) {
                                                                i = R.id.tvResult2;
                                                                TextView textView3 = (TextView) b.a(view, R.id.tvResult2);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvSelectTips;
                                                                    TextView textView4 = (TextView) b.a(view, R.id.tvSelectTips);
                                                                    if (textView4 != null) {
                                                                        i = R.id.vCenter;
                                                                        View a2 = b.a(view, R.id.vCenter);
                                                                        if (a2 != null) {
                                                                            return new ViewFoodieWheelBinding((ConstraintLayout) view, a, foodieItemView, foodieItemView2, foodieItemView3, foodieItemView4, foodieItemView5, foodieItemView6, foodieItemView7, foodieItemView8, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, a2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewFoodieWheelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewFoodieWheelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_foodie_wheel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
