package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.skydoves.balloon.vectortext.VectorTextView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LayoutBalloonLibrarySkydovesBinding implements a {
    public final FrameLayout balloon;
    public final AppCompatImageView balloonArrow;
    public final CardView balloonCard;
    public final RelativeLayout balloonContent;
    public final VectorTextView balloonText;
    public final RelativeLayout balloonWrapper;
    private final FrameLayout rootView;

    private LayoutBalloonLibrarySkydovesBinding(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, CardView cardView, RelativeLayout relativeLayout, VectorTextView vectorTextView, RelativeLayout relativeLayout2) {
        this.rootView = frameLayout;
        this.balloon = frameLayout2;
        this.balloonArrow = appCompatImageView;
        this.balloonCard = cardView;
        this.balloonContent = relativeLayout;
        this.balloonText = vectorTextView;
        this.balloonWrapper = relativeLayout2;
    }

    public static LayoutBalloonLibrarySkydovesBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = 2131362053;
        AppCompatImageView a = b.a(view, 2131362053);
        if (a != null) {
            i = 2131362054;
            CardView a2 = b.a(view, 2131362054);
            if (a2 != null) {
                i = 2131362055;
                RelativeLayout relativeLayout = (RelativeLayout) b.a(view, 2131362055);
                if (relativeLayout != null) {
                    i = 2131362056;
                    VectorTextView vectorTextView = (VectorTextView) b.a(view, 2131362056);
                    if (vectorTextView != null) {
                        i = 2131362057;
                        RelativeLayout relativeLayout2 = (RelativeLayout) b.a(view, 2131362057);
                        if (relativeLayout2 != null) {
                            return new LayoutBalloonLibrarySkydovesBinding(frameLayout, frameLayout, a, a2, relativeLayout, vectorTextView, relativeLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutBalloonLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutBalloonLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131559197, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
