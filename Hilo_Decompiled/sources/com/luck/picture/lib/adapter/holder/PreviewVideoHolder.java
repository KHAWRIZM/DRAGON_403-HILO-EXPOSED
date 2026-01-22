package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.MediaPlayerEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.IntentUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PreviewVideoHolder extends BasePreviewHolder {
    private boolean isPlayed;
    public ImageView ivPlayButton;
    private final OnPlayerListener mPlayerListener;
    public ProgressBar progress;
    public View videoPlayer;

    public PreviewVideoHolder(View view) {
        super(view);
        int i10;
        this.isPlayed = false;
        this.mPlayerListener = new OnPlayerListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.5
            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerEnd() {
                PreviewVideoHolder.this.playerDefaultUI();
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerError() {
                PreviewVideoHolder.this.playerDefaultUI();
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerLoading() {
                PreviewVideoHolder.this.progress.setVisibility(0);
            }

            @Override // com.luck.picture.lib.interfaces.OnPlayerListener
            public void onPlayerReady() {
                PreviewVideoHolder.this.playerIngUI();
            }
        };
        this.ivPlayButton = (ImageView) view.findViewById(R.id.iv_play_video);
        this.progress = (ProgressBar) view.findViewById(R.id.progress);
        ImageView imageView = this.ivPlayButton;
        if (this.selectorConfig.isPreviewZoomEffect) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        imageView.setVisibility(i10);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.videoPlayerEngine == null) {
            selectorConfig.videoPlayerEngine = new MediaPlayerEngine();
        }
        View onCreateVideoPlayer = this.selectorConfig.videoPlayerEngine.onCreateVideoPlayer(view.getContext());
        this.videoPlayer = onCreateVideoPlayer;
        if (onCreateVideoPlayer != null) {
            if (onCreateVideoPlayer.getLayoutParams() == null) {
                this.videoPlayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.indexOfChild(this.videoPlayer) != -1) {
                viewGroup.removeView(this.videoPlayer);
            }
            viewGroup.addView(this.videoPlayer, 0);
            this.videoPlayer.setVisibility(8);
            return;
        }
        throw new NullPointerException("onCreateVideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlay() {
        if (this.isPlayed) {
            if (isPlaying()) {
                onPause();
                return;
            } else {
                onResume();
                return;
            }
        }
        startPlay();
    }

    private void onResume() {
        this.ivPlayButton.setVisibility(8);
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onResume(this.videoPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerDefaultUI() {
        this.isPlayed = false;
        this.ivPlayButton.setVisibility(0);
        this.progress.setVisibility(8);
        this.coverImageView.setVisibility(0);
        this.videoPlayer.setVisibility(8);
        BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = this.mPreviewEventListener;
        if (onPreviewEventListener != null) {
            onPreviewEventListener.onPreviewVideoTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerIngUI() {
        this.progress.setVisibility(8);
        this.ivPlayButton.setVisibility(8);
        this.coverImageView.setVisibility(8);
        this.videoPlayer.setVisibility(0);
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void bindData(LocalMedia localMedia, int i10) {
        super.bindData(localMedia, i10);
        setScaleDisplaySize(localMedia);
        this.ivPlayButton.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.selectorConfig.isPauseResumePlay) {
                    previewVideoHolder.dispatchPlay();
                } else {
                    previewVideoHolder.startPlay();
                }
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.selectorConfig.isPauseResumePlay) {
                    previewVideoHolder.dispatchPlay();
                    return;
                }
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = previewVideoHolder.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void findViews(View view) {
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public boolean isPlaying() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null && videoPlayerEngine.isPlaying(this.videoPlayer)) {
            return true;
        }
        return false;
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void loadImage(LocalMedia localMedia, int i10, int i11) {
        if (this.selectorConfig.imageEngine != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i10 == -1 && i11 == -1) {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), availablePath, this.coverImageView);
            } else {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), this.coverImageView, availablePath, i10, i11);
            }
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onClickBackPressed() {
        this.coverImageView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.1
            @Override // com.luck.picture.lib.photoview.OnViewTapListener
            public void onViewTap(View view, float f10, float f11) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewVideoHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onLongPressDownload(localMedia);
                    return false;
                }
                return false;
            }
        });
    }

    public void onPause() {
        this.ivPlayButton.setVisibility(0);
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPause(this.videoPlayer);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void onViewAttachedToWindow() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPlayerAttachedToWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.addPlayListener(this.mPlayerListener);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void onViewDetachedFromWindow() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPlayerDetachedFromWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.removePlayListener(this.mPlayerListener);
        }
        playerDefaultUI();
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void release() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.removePlayListener(this.mPlayerListener);
            this.selectorConfig.videoPlayerEngine.destroy(this.videoPlayer);
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void resumePausePlay() {
        if (isPlaying()) {
            onPause();
        } else {
            onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    public void setScaleDisplaySize(LocalMedia localMedia) {
        super.setScaleDisplaySize(localMedia);
        if (!this.selectorConfig.isPreviewZoomEffect && this.screenWidth < this.screenHeight) {
            ViewGroup.LayoutParams layoutParams = this.videoPlayer.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = this.screenWidth;
                layoutParams2.height = this.screenAppInHeight;
                layoutParams2.gravity = 17;
                return;
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = this.screenWidth;
                layoutParams3.height = this.screenAppInHeight;
                layoutParams3.addRule(13);
                return;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.width = this.screenWidth;
                layoutParams4.height = this.screenAppInHeight;
                layoutParams4.gravity = 17;
                return;
            }
            if (layoutParams instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).width = this.screenWidth;
                ((ViewGroup.MarginLayoutParams) bVar).height = this.screenAppInHeight;
                bVar.f٢٣١٥i = 0;
                bVar.f٢٣٢١l = 0;
            }
        }
    }

    public void startPlay() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.isUseSystemVideoPlayer) {
            IntentUtils.startSystemPlayerVideo(this.itemView.getContext(), this.media.getAvailablePath());
            return;
        }
        if (this.videoPlayer != null) {
            if (selectorConfig.videoPlayerEngine != null) {
                this.progress.setVisibility(0);
                this.ivPlayButton.setVisibility(8);
                this.mPreviewEventListener.onPreviewVideoTitle(this.media.getFileName());
                this.isPlayed = true;
                this.selectorConfig.videoPlayerEngine.onStarPlayer(this.videoPlayer, this.media);
                return;
            }
            return;
        }
        throw new NullPointerException("VideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
    }
}
