package com.skydoves.balloon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skydoves.balloon.R;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class LayoutBalloonOverlayLibrarySkydovesBinding implements a {
    public final BalloonAnchorOverlayView balloonOverlayView;
    private final BalloonAnchorOverlayView rootView;

    private LayoutBalloonOverlayLibrarySkydovesBinding(BalloonAnchorOverlayView balloonAnchorOverlayView, BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        this.rootView = balloonAnchorOverlayView;
        this.balloonOverlayView = balloonAnchorOverlayView2;
    }

    public static LayoutBalloonOverlayLibrarySkydovesBinding bind(View view) {
        if (view != null) {
            BalloonAnchorOverlayView balloonAnchorOverlayView = (BalloonAnchorOverlayView) view;
            return new LayoutBalloonOverlayLibrarySkydovesBinding(balloonAnchorOverlayView, balloonAnchorOverlayView);
        }
        throw new NullPointerException("rootView");
    }

    public static LayoutBalloonOverlayLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutBalloonOverlayLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_balloon_overlay_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public BalloonAnchorOverlayView getRoot() {
        return this.rootView;
    }
}
