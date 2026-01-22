package com.qiahao.nextvideo.view.youtube;

import android.animation.Animator;
import android.os.Handler;
import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u00101\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0016J\u0018\u00103\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u00104\u001a\u00020\u001fH\u0016J\u0018\u00105\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020\u001fH\u0016J\u0018\u00107\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/view/youtube/FadeViewHelper;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "targetView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getTargetView", "()Landroid/view/View;", "isPlaying", "", "canFade", "isVisible", "fadeOut", "Ljava/lang/Runnable;", "isDisabled", "()Z", "setDisabled", "(Z)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "fadeOutDelay", "getFadeOutDelay", "setFadeOutDelay", "toggleVisibility", "", "fade", "finalAlpha", "", "updateState", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onStateChange", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onReady", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onError", BaseMonitor.COUNT_ERROR, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onApiChange", "onCurrentSecond", "second", "onVideoDuration", "duration", "onVideoLoadedFraction", "loadedFraction", "onVideoId", "videoId", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FadeViewHelper implements YouTubePlayerListener {
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final long DEFAULT_FADE_OUT_DELAY = 3000;
    private long animationDuration;
    private boolean canFade;

    @NotNull
    private Runnable fadeOut;
    private long fadeOutDelay;
    private boolean isDisabled;
    private boolean isPlaying;
    private boolean isVisible;

    @NotNull
    private final View targetView;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            try {
                iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PlayerConstants.PlayerState.VIDEO_CUED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PlayerConstants.PlayerState.BUFFERING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PlayerConstants.PlayerState.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FadeViewHelper(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "targetView");
        this.targetView = view;
        this.isVisible = true;
        this.fadeOut = new Runnable() { // from class: com.qiahao.nextvideo.view.youtube.a
            @Override // java.lang.Runnable
            public final void run() {
                FadeViewHelper.this.fade(0.0f);
            }
        };
        this.animationDuration = 300L;
        this.fadeOutDelay = DEFAULT_FADE_OUT_DELAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fade(final float finalAlpha) {
        boolean z;
        if (this.canFade && !this.isDisabled) {
            if (finalAlpha == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            this.isVisible = !z;
            if (finalAlpha == 1.0f && this.isPlaying) {
                Handler handler = this.targetView.getHandler();
                if (handler != null) {
                    handler.postDelayed(this.fadeOut, this.fadeOutDelay);
                }
            } else {
                Handler handler2 = this.targetView.getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(this.fadeOut);
                }
            }
            this.targetView.animate().alpha(finalAlpha).setDuration(this.animationDuration).setListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.view.youtube.FadeViewHelper$fade$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    if (finalAlpha == 0.0f) {
                        this.getTargetView().setVisibility(8);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    if (finalAlpha == 1.0f) {
                        this.getTargetView().setVisibility(0);
                    }
                }
            }).start();
        }
    }

    private final void updateState(PlayerConstants.PlayerState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.isPlaying = true;
                    return;
                }
                return;
            }
            this.isPlaying = false;
            return;
        }
        this.isPlaying = false;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final long getFadeOutDelay() {
        return this.fadeOutDelay;
    }

    @NotNull
    public final View getTargetView() {
        return this.targetView;
    }

    /* renamed from: isDisabled, reason: from getter */
    public final boolean getIsDisabled() {
        return this.isDisabled;
    }

    public void onApiChange(@NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onCurrentSecond(@NotNull YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onError(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerError error) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
    }

    public void onPlaybackQualityChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackQuality, "playbackQuality");
    }

    public void onPlaybackRateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackRate, "playbackRate");
    }

    public void onReady(@NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onStateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        updateState(state);
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                fade(1.0f);
                return;
            case 2:
            case 3:
            case 5:
                this.canFade = true;
                if (state == PlayerConstants.PlayerState.PLAYING) {
                    Handler handler = this.targetView.getHandler();
                    if (handler != null) {
                        handler.postDelayed(this.fadeOut, this.fadeOutDelay);
                        return;
                    }
                    return;
                }
                Handler handler2 = this.targetView.getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(this.fadeOut);
                    return;
                }
                return;
            case 4:
            case 6:
                fade(1.0f);
                this.canFade = false;
                return;
            case 7:
                fade(1.0f);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public void onVideoDuration(@NotNull YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onVideoId(@NotNull YouTubePlayer youTubePlayer, @NotNull String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    public void onVideoLoadedFraction(@NotNull YouTubePlayer youTubePlayer, float loadedFraction) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final void setDisabled(boolean z) {
        this.isDisabled = z;
    }

    public final void setFadeOutDelay(long j) {
        this.fadeOutDelay = j;
    }

    public final void toggleVisibility() {
        float f;
        if (this.isVisible) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        fade(f);
    }
}
