package com.skydoves.balloon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.skydoves.balloon.R;
import com.skydoves.balloon.vectortext.VectorTextView;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
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
        CardView findViewById;
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.balloon_arrow;
        AppCompatImageView findViewById2 = view.findViewById(i);
        if (findViewById2 != null && (findViewById = view.findViewById((i = R.id.balloon_card))) != null) {
            i = R.id.balloon_content;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
            if (relativeLayout != null) {
                i = R.id.balloon_text;
                VectorTextView vectorTextView = (VectorTextView) view.findViewById(i);
                if (vectorTextView != null) {
                    i = R.id.balloon_wrapper;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                    if (relativeLayout2 != null) {
                        return new LayoutBalloonLibrarySkydovesBinding((FrameLayout) view, frameLayout, findViewById2, findViewById, relativeLayout, vectorTextView, relativeLayout2);
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
        View inflate = layoutInflater.inflate(R.layout.layout_balloon_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
