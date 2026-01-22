package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.chrisbanes.photoview.PhotoView;
import com.qiahao.hilo_message.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ActivityMediaViewBinding implements a {
    public final ImageView closeButton;
    public final FrameLayout contentContainer;
    public final ImageView downloadButton;
    public final ProgressBar loadingProgress;
    public final PhotoView photoView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout videoContainer;
    public final ImageView videoPlayButton;
    public final ImageView videoThumbnail;
    public final VideoView videoView;
    public final TextView viewOriginalBtn;

    private ActivityMediaViewBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, ProgressBar progressBar, PhotoView photoView, ConstraintLayout constraintLayout2, ImageView imageView3, ImageView imageView4, VideoView videoView, TextView textView) {
        this.rootView = constraintLayout;
        this.closeButton = imageView;
        this.contentContainer = frameLayout;
        this.downloadButton = imageView2;
        this.loadingProgress = progressBar;
        this.photoView = photoView;
        this.videoContainer = constraintLayout2;
        this.videoPlayButton = imageView3;
        this.videoThumbnail = imageView4;
        this.videoView = videoView;
        this.viewOriginalBtn = textView;
    }

    public static ActivityMediaViewBinding bind(View view) {
        int i10 = R.id.close_button;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = R.id.content_container;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.download_button;
                ImageView imageView2 = (ImageView) b.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.loading_progress;
                    ProgressBar progressBar = (ProgressBar) b.a(view, i10);
                    if (progressBar != null) {
                        i10 = R.id.photo_view;
                        PhotoView photoView = (PhotoView) b.a(view, i10);
                        if (photoView != null) {
                            i10 = R.id.video_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                            if (constraintLayout != null) {
                                i10 = R.id.video_play_button;
                                ImageView imageView3 = (ImageView) b.a(view, i10);
                                if (imageView3 != null) {
                                    i10 = R.id.video_thumbnail;
                                    ImageView imageView4 = (ImageView) b.a(view, i10);
                                    if (imageView4 != null) {
                                        i10 = R.id.video_view;
                                        VideoView videoView = (VideoView) b.a(view, i10);
                                        if (videoView != null) {
                                            i10 = R.id.view_original_btn;
                                            TextView textView = (TextView) b.a(view, i10);
                                            if (textView != null) {
                                                return new ActivityMediaViewBinding((ConstraintLayout) view, imageView, frameLayout, imageView2, progressBar, photoView, constraintLayout, imageView3, imageView4, videoView, textView);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static ActivityMediaViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMediaViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_media_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
