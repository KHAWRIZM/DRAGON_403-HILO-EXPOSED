package com.qiahao.nextvideo.view.youtube;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewYouTuVideoBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/view/youtube/CustomPlayerUiController;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "context", "Landroid/content/Context;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;", "playerTracker", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/YouTubePlayerTracker;", "mFadeViewHelper", "Lcom/qiahao/nextvideo/view/youtube/FadeViewHelper;", "isPlaying", "", "isHasAddVideo", "initViews", "", "onReady", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "updateState", "refreshVideoView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomPlayerUiController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomPlayerUiController.kt\ncom/qiahao/nextvideo/view/youtube/CustomPlayerUiController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,109:1\n61#2,9:110\n61#2,9:119\n*S KotlinDebug\n*F\n+ 1 CustomPlayerUiController.kt\ncom/qiahao/nextvideo/view/youtube/CustomPlayerUiController\n*L\n42#1:110,9\n54#1:119,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CustomPlayerUiController extends AbstractYouTubePlayerListener {

    @Nullable
    private final ViewYouTuVideoBinding binding;

    @NotNull
    private final Context context;
    private boolean isHasAddVideo;
    private boolean isPlaying;

    @Nullable
    private FadeViewHelper mFadeViewHelper;

    @NotNull
    private final YouTubePlayerTracker playerTracker;

    @NotNull
    private final YouTubePlayer youTubePlayer;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayerConstants.PlayerState.VIDEO_CUED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlayerConstants.PlayerState.BUFFERING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CustomPlayerUiController(@NotNull Context context, @Nullable ViewYouTuVideoBinding viewYouTuVideoBinding, @NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.context = context;
        this.binding = viewYouTuVideoBinding;
        this.youTubePlayer = youTubePlayer;
        this.playerTracker = new YouTubePlayerTracker();
        initViews();
    }

    private final void initViews() {
        final View view;
        YouTuBeSeekBar youTuBeSeekBar;
        final ImageView imageView;
        YouTuBeSeekBar youTuBeSeekBar2;
        ConstraintLayout constraintLayout;
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.binding;
        if (viewYouTuVideoBinding != null && (constraintLayout = viewYouTuVideoBinding.constraint) != null) {
            this.mFadeViewHelper = new FadeViewHelper(constraintLayout);
        }
        this.youTubePlayer.addListener(this.playerTracker);
        ViewYouTuVideoBinding viewYouTuVideoBinding2 = this.binding;
        if (viewYouTuVideoBinding2 != null && (youTuBeSeekBar2 = viewYouTuVideoBinding2.seekbar) != null) {
            this.youTubePlayer.addListener(youTuBeSeekBar2);
        }
        FadeViewHelper fadeViewHelper = this.mFadeViewHelper;
        if (fadeViewHelper != null) {
            this.youTubePlayer.addListener(fadeViewHelper);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding3 = this.binding;
        final long j = 800;
        if (viewYouTuVideoBinding3 != null && (imageView = viewYouTuVideoBinding3.playPauseButton) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.youtube.CustomPlayerUiController$initViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    boolean z;
                    YouTubePlayer youTubePlayer;
                    YouTubePlayer youTubePlayer2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        z = this.isPlaying;
                        if (z) {
                            youTubePlayer2 = this.youTubePlayer;
                            youTubePlayer2.pause();
                        } else {
                            youTubePlayer = this.youTubePlayer;
                            youTubePlayer.play();
                        }
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding4 = this.binding;
        if (viewYouTuVideoBinding4 != null && (youTuBeSeekBar = viewYouTuVideoBinding4.seekbar) != null) {
            youTuBeSeekBar.setYoutubePlayerSeekBarListener(new YouTubePlayerSeekBarListener() { // from class: com.qiahao.nextvideo.view.youtube.CustomPlayerUiController$initViews$5
                @Override // com.qiahao.nextvideo.view.youtube.YouTubePlayerSeekBarListener
                public void seekTo(float time) {
                    YouTubePlayer youTubePlayer;
                    youTubePlayer = CustomPlayerUiController.this.youTubePlayer;
                    youTubePlayer.seekTo(time);
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding5 = this.binding;
        if (viewYouTuVideoBinding5 != null && (view = viewYouTuVideoBinding5.panel) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.youtube.CustomPlayerUiController$initViews$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FadeViewHelper fadeViewHelper2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        fadeViewHelper2 = this.mFadeViewHelper;
                        if (fadeViewHelper2 != null) {
                            fadeViewHelper2.toggleVisibility();
                        }
                    }
                }
            });
        }
    }

    private final void updateState(PlayerConstants.PlayerState state) {
        ImageView imageView;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 6) {
                    this.isPlaying = false;
                }
            } else {
                this.isPlaying = false;
            }
        } else {
            this.isPlaying = true;
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.binding;
        if (viewYouTuVideoBinding != null && (imageView = viewYouTuVideoBinding.playPauseButton) != null) {
            Context context = this.context;
            if (!this.isPlaying) {
                i = R.drawable.you_tu_be_start;
            } else {
                i = R.drawable.you_tu_be_stop;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
        }
    }

    @Nullable
    public final ViewYouTuVideoBinding getBinding() {
        return this.binding;
    }

    public void onReady(@NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onStateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState state) {
        ImageView imageView;
        ImageView imageView2;
        ViewYouTuVideoBinding viewYouTuVideoBinding;
        ImageView imageView3;
        View view;
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        updateState(state);
        ViewYouTuVideoBinding viewYouTuVideoBinding2 = this.binding;
        if (viewYouTuVideoBinding2 != null && (view = viewYouTuVideoBinding2.panel) != null) {
            view.setBackgroundColor(androidx.core.content.a.getColor(this.context, android.R.color.transparent));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                if (i == 5 && (viewYouTuVideoBinding = this.binding) != null && (imageView3 = viewYouTuVideoBinding.playPauseButton) != null) {
                    imageView3.setVisibility(0);
                    return;
                }
                return;
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding3 = this.binding;
            if (viewYouTuVideoBinding3 != null && (imageView2 = viewYouTuVideoBinding3.playPauseButton) != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding4 = this.binding;
        if (viewYouTuVideoBinding4 != null && (imageView = viewYouTuVideoBinding4.playPauseButton) != null) {
            imageView.setVisibility(0);
        }
    }

    public final void refreshVideoView() {
        View view;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        View view2;
        ImageView imageView2;
        TextView textView3;
        TextView textView4;
        if (!this.isHasAddVideo) {
            ViewYouTuVideoBinding viewYouTuVideoBinding = this.binding;
            if (viewYouTuVideoBinding != null && (textView4 = viewYouTuVideoBinding.title) != null) {
                textView4.setVisibility(0);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding2 = this.binding;
            if (viewYouTuVideoBinding2 != null && (textView3 = viewYouTuVideoBinding2.addVideo) != null) {
                textView3.setVisibility(0);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding3 = this.binding;
            if (viewYouTuVideoBinding3 != null && (imageView2 = viewYouTuVideoBinding3.videoList) != null) {
                imageView2.setVisibility(8);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding4 = this.binding;
            if (viewYouTuVideoBinding4 != null && (view2 = viewYouTuVideoBinding4.panel) != null) {
                view2.setBackgroundColor(androidx.core.content.a.getColor(this.context, android.R.color.black));
                return;
            }
            return;
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding5 = this.binding;
        if (viewYouTuVideoBinding5 != null && (textView2 = viewYouTuVideoBinding5.title) != null) {
            textView2.setVisibility(8);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding6 = this.binding;
        if (viewYouTuVideoBinding6 != null && (textView = viewYouTuVideoBinding6.addVideo) != null) {
            textView.setVisibility(8);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding7 = this.binding;
        if (viewYouTuVideoBinding7 != null && (imageView = viewYouTuVideoBinding7.videoList) != null) {
            imageView.setVisibility(0);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding8 = this.binding;
        if (viewYouTuVideoBinding8 != null && (view = viewYouTuVideoBinding8.panel) != null) {
            view.setBackgroundColor(androidx.core.content.a.getColor(this.context, android.R.color.transparent));
        }
    }
}
