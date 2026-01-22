package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitySplashBinding implements a {
    public final AppCompatImageView bgLaunchImageView;
    private final FrameLayout rootView;

    private ActivitySplashBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView) {
        this.rootView = frameLayout;
        this.bgLaunchImageView = appCompatImageView;
    }

    public static ActivitySplashBinding bind(View view) {
        AppCompatImageView a = b.a(view, R.id.bg_launch_image_view);
        if (a != null) {
            return new ActivitySplashBinding((FrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bg_launch_image_view)));
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
