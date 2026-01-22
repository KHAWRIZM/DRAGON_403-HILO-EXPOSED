package com.tencent.qcloud.tuikit.tuichat.classicui.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class EmojiIndicatorView extends LinearLayout {
    private Bitmap bmpNomal;
    private Bitmap bmpSelect;
    private Context mContext;
    private int mHeight;
    private ArrayList<ImageView> mImageViews;
    private int mMaxHeight;
    private AnimatorSet mPlayByInAnimatorSet;
    private AnimatorSet mPlayByOutAnimatorSet;
    private AnimatorSet mPlayToAnimatorSet;

    public EmojiIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeight = 16;
        this.mContext = context;
        setOrientation(0);
        this.mMaxHeight = ScreenUtil.dip2px(this.mHeight);
        this.bmpSelect = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_select);
        this.bmpNomal = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_nomal);
    }

    public void init(int i) {
        this.mImageViews = new ArrayList<>();
        removeAllViews();
        for (int i2 = 0; i2 < i; i2++) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            int i3 = this.mMaxHeight;
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            ImageView imageView = new ImageView(this.mContext);
            if (i2 == 0) {
                imageView.setImageBitmap(this.bmpSelect);
                relativeLayout.addView(imageView, layoutParams2);
            } else {
                imageView.setImageBitmap(this.bmpNomal);
                relativeLayout.addView(imageView, layoutParams2);
            }
            addView(relativeLayout, layoutParams);
            this.mImageViews.add(imageView);
        }
    }

    public void playBy(int i, int i2) {
        boolean z;
        int i3 = 0;
        if (i < 0 || i2 < 0 || i2 == i) {
            i = 0;
            i2 = 0;
        }
        if (i < 0) {
            z = true;
            i2 = 0;
        } else {
            i3 = i;
            z = false;
        }
        final ImageView imageView = this.mImageViews.get(i3);
        final ImageView imageView2 = this.mImageViews.get(i2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleX, 1.0f, 0.25f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleY, 1.0f, 0.25f);
        AnimatorSet animatorSet = this.mPlayByOutAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mPlayByOutAnimatorSet.cancel();
            this.mPlayByOutAnimatorSet = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPlayByOutAnimatorSet = animatorSet2;
        animatorSet2.play(ofFloat).with(ofFloat2);
        this.mPlayByOutAnimatorSet.setDuration(100L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView2, AnimationUtilitiesKt.propertyNameInScaleX, 0.25f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView2, AnimationUtilitiesKt.propertyNameInScaleY, 0.25f, 1.0f);
        AnimatorSet animatorSet3 = this.mPlayByInAnimatorSet;
        if (animatorSet3 != null && animatorSet3.isRunning()) {
            this.mPlayByInAnimatorSet.cancel();
            this.mPlayByInAnimatorSet = null;
        }
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.mPlayByInAnimatorSet = animatorSet4;
        animatorSet4.play(ofFloat3).with(ofFloat4);
        this.mPlayByInAnimatorSet.setDuration(100L);
        if (z) {
            this.mPlayByInAnimatorSet.start();
        } else {
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.EmojiIndicatorView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    imageView.setImageBitmap(EmojiIndicatorView.this.bmpNomal);
                    ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleX, 1.0f);
                    ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleY, 1.0f);
                    AnimatorSet animatorSet5 = new AnimatorSet();
                    animatorSet5.play(ofFloat5).with(ofFloat6);
                    animatorSet5.start();
                    imageView2.setImageBitmap(EmojiIndicatorView.this.bmpSelect);
                    EmojiIndicatorView.this.mPlayByInAnimatorSet.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.mPlayByOutAnimatorSet.start();
        }
    }

    public void playTo(int i) {
        Iterator<ImageView> it = this.mImageViews.iterator();
        while (it.hasNext()) {
            it.next().setImageBitmap(this.bmpNomal);
        }
        this.mImageViews.get(i).setImageBitmap(this.bmpSelect);
        ImageView imageView = this.mImageViews.get(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleX, 0.25f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, AnimationUtilitiesKt.propertyNameInScaleY, 0.25f, 1.0f);
        AnimatorSet animatorSet = this.mPlayToAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mPlayToAnimatorSet.cancel();
            this.mPlayToAnimatorSet = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPlayToAnimatorSet = animatorSet2;
        animatorSet2.play(ofFloat).with(ofFloat2);
        this.mPlayToAnimatorSet.setDuration(100L);
        this.mPlayToAnimatorSet.start();
    }

    public void setIndicatorCount(int i) {
        ArrayList<ImageView> arrayList = this.mImageViews;
        if (arrayList != null && i <= arrayList.size()) {
            for (int i2 = 0; i2 < this.mImageViews.size(); i2++) {
                if (i2 >= i) {
                    this.mImageViews.get(i2).setVisibility(8);
                    ((View) this.mImageViews.get(i2).getParent()).setVisibility(8);
                } else {
                    this.mImageViews.get(i2).setVisibility(0);
                    ((View) this.mImageViews.get(i2).getParent()).setVisibility(0);
                }
            }
        }
    }

    public EmojiIndicatorView(Context context) {
        this(context, null);
    }
}
