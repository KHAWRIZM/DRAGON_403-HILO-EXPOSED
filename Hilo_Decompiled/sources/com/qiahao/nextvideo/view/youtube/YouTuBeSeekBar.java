package com.qiahao.nextvideo.view.youtube;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.databinding.g;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewYouTuBeBinding;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0012\u0010#\u001a\u00020$2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0003J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\fJ \u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u00105\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u000207H\u0017J\u0018\u0010:\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010;\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0016J\u0018\u0010=\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0016J\u0018\u0010A\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0016J\u0018\u0010D\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010H\u001a\u00020IH\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/view/youtube/YouTuBeSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewYouTuBeBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewYouTuBeBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewYouTuBeBinding;)V", "newSeekBarProgress", "seekBarTouchStarted", "", "isPlaying", "showBufferingProgress", "getShowBufferingProgress", "()Z", "setShowBufferingProgress", "(Z)V", "youtubePlayerSeekBarListener", "Lcom/qiahao/nextvideo/view/youtube/YouTubePlayerSeekBarListener;", "getYoutubePlayerSeekBarListener", "()Lcom/qiahao/nextvideo/view/youtube/YouTubePlayerSeekBarListener;", "setYoutubePlayerSeekBarListener", "(Lcom/qiahao/nextvideo/view/youtube/YouTubePlayerSeekBarListener;)V", "initView", "", "updateState", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "resetUi", "refreshTime", "currentTime", "onProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "onStateChange", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "", "onVideoDuration", "duration", "onVideoLoadedFraction", "loadedFraction", "onReady", "onVideoId", "videoId", "", "onApiChange", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onError", BaseMonitor.COUNT_ERROR, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuBeSeekBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener, YouTubePlayerListener {

    @Nullable
    private ViewYouTuBeBinding binding;
    private boolean isPlaying;
    private int newSeekBarProgress;
    private boolean seekBarTouchStarted;
    private boolean showBufferingProgress;

    @Nullable
    private YouTubePlayerSeekBarListener youtubePlayerSeekBarListener;

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTuBeSeekBar(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"SetTextI18n"})
    private final void initView(AttributeSet attr) {
        AppCompatSeekBar appCompatSeekBar;
        TextView textView;
        TextView textView2;
        AppCompatSeekBar appCompatSeekBar2;
        Drawable thumb;
        TextView textView3;
        TextView textView4;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attr, R.styleable.YouTubePlayerSeekBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(2131165272));
        int color = obtainStyledAttributes.getColor(0, androidx.core.content.a.getColor(getContext(), 2131099976));
        obtainStyledAttributes.recycle();
        ViewYouTuBeBinding viewYouTuBeBinding = (ViewYouTuBeBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_you_tu_be, this, true);
        this.binding = viewYouTuBeBinding;
        if (viewYouTuBeBinding != null && (textView4 = viewYouTuBeBinding.currentTime) != null) {
            textView4.setTextSize(0, dimensionPixelSize);
        }
        ViewYouTuBeBinding viewYouTuBeBinding2 = this.binding;
        if (viewYouTuBeBinding2 != null && (textView3 = viewYouTuBeBinding2.durationTime) != null) {
            textView3.setTextSize(0, dimensionPixelSize);
        }
        ViewYouTuBeBinding viewYouTuBeBinding3 = this.binding;
        if (viewYouTuBeBinding3 != null && (appCompatSeekBar2 = viewYouTuBeBinding3.seekBar) != null && (thumb = appCompatSeekBar2.getThumb()) != null) {
            h2.b.n(thumb, color);
        }
        ViewYouTuBeBinding viewYouTuBeBinding4 = this.binding;
        if (viewYouTuBeBinding4 != null && (textView2 = viewYouTuBeBinding4.currentTime) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(this, 2131952056));
        }
        ViewYouTuBeBinding viewYouTuBeBinding5 = this.binding;
        if (viewYouTuBeBinding5 != null && (textView = viewYouTuBeBinding5.durationTime) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131952056));
        }
        ViewYouTuBeBinding viewYouTuBeBinding6 = this.binding;
        if (viewYouTuBeBinding6 != null && (appCompatSeekBar = viewYouTuBeBinding6.seekBar) != null) {
            appCompatSeekBar.setOnSeekBarChangeListener(this);
        }
    }

    private final void resetUi() {
        TextView textView;
        AppCompatSeekBar appCompatSeekBar;
        AppCompatSeekBar appCompatSeekBar2;
        ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
        if (viewYouTuBeBinding != null && (appCompatSeekBar2 = viewYouTuBeBinding.seekBar) != null) {
            appCompatSeekBar2.setProgress(0);
        }
        ViewYouTuBeBinding viewYouTuBeBinding2 = this.binding;
        if (viewYouTuBeBinding2 != null && (appCompatSeekBar = viewYouTuBeBinding2.seekBar) != null) {
            appCompatSeekBar.setMax(0);
        }
        ViewYouTuBeBinding viewYouTuBeBinding3 = this.binding;
        if (viewYouTuBeBinding3 != null && (textView = viewYouTuBeBinding3.durationTime) != null) {
            textView.post(new Runnable() { // from class: com.qiahao.nextvideo.view.youtube.b
                @Override // java.lang.Runnable
                public final void run() {
                    YouTuBeSeekBar.resetUi$lambda$1(YouTuBeSeekBar.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetUi$lambda$1(YouTuBeSeekBar youTuBeSeekBar) {
        TextView textView;
        ViewYouTuBeBinding viewYouTuBeBinding = youTuBeSeekBar.binding;
        if (viewYouTuBeBinding != null && (textView = viewYouTuBeBinding.durationTime) != null) {
            textView.setText("");
        }
    }

    private final void updateState(PlayerConstants.PlayerState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        resetUi();
                        return;
                    }
                    return;
                }
                this.isPlaying = true;
                return;
            }
            this.isPlaying = false;
            return;
        }
        this.isPlaying = false;
    }

    @Nullable
    public final ViewYouTuBeBinding getBinding() {
        return this.binding;
    }

    public final boolean getShowBufferingProgress() {
        return this.showBufferingProgress;
    }

    @Nullable
    public final YouTubePlayerSeekBarListener getYoutubePlayerSeekBarListener() {
        return this.youtubePlayerSeekBarListener;
    }

    public void onApiChange(@NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public void onCurrentSecond(@NotNull YouTubePlayer youTubePlayer, float second) {
        AppCompatSeekBar appCompatSeekBar;
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        if (this.seekBarTouchStarted) {
            return;
        }
        if (this.newSeekBarProgress > 0 && !Intrinsics.areEqual(DateUtils.formatTime((int) second), DateUtils.formatTime(this.newSeekBarProgress))) {
            return;
        }
        this.newSeekBarProgress = -1;
        ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
        if (viewYouTuBeBinding != null && (appCompatSeekBar = viewYouTuBeBinding.seekBar) != null) {
            appCompatSeekBar.setProgress((int) second);
        }
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

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        TextView textView;
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
        if (viewYouTuBeBinding != null && (textView = viewYouTuBeBinding.currentTime) != null) {
            textView.setText(DateUtils.formatTime(progress));
        }
    }

    public void onReady(@NotNull YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.seekBarTouchStarted = true;
    }

    public void onStateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        this.newSeekBarProgress = -1;
        updateState(state);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (this.isPlaying) {
            this.newSeekBarProgress = seekBar.getProgress();
        }
        YouTubePlayerSeekBarListener youTubePlayerSeekBarListener = this.youtubePlayerSeekBarListener;
        if (youTubePlayerSeekBarListener != null) {
            youTubePlayerSeekBarListener.seekTo(seekBar.getProgress());
        }
        this.seekBarTouchStarted = false;
    }

    @SuppressLint({"SetTextI18n"})
    public void onVideoDuration(@NotNull YouTubePlayer youTubePlayer, float duration) {
        AppCompatSeekBar appCompatSeekBar;
        TextView textView;
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
        if (viewYouTuBeBinding != null && (textView = viewYouTuBeBinding.durationTime) != null) {
            textView.setText("/" + DateUtils.formatTime((int) duration));
        }
        ViewYouTuBeBinding viewYouTuBeBinding2 = this.binding;
        if (viewYouTuBeBinding2 != null && (appCompatSeekBar = viewYouTuBeBinding2.seekBar) != null) {
            appCompatSeekBar.setMax((int) duration);
        }
    }

    public void onVideoId(@NotNull YouTubePlayer youTubePlayer, @NotNull String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    public void onVideoLoadedFraction(@NotNull YouTubePlayer youTubePlayer, float loadedFraction) {
        AppCompatSeekBar appCompatSeekBar;
        AppCompatSeekBar appCompatSeekBar2;
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        int i = 0;
        if (this.showBufferingProgress) {
            ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
            if (viewYouTuBeBinding != null && (appCompatSeekBar2 = viewYouTuBeBinding.seekBar) != null) {
                if (viewYouTuBeBinding != null && appCompatSeekBar2 != null) {
                    i = appCompatSeekBar2.getMax();
                }
                appCompatSeekBar2.setSecondaryProgress((int) (loadedFraction * i));
                return;
            }
            return;
        }
        ViewYouTuBeBinding viewYouTuBeBinding2 = this.binding;
        if (viewYouTuBeBinding2 != null && (appCompatSeekBar = viewYouTuBeBinding2.seekBar) != null) {
            appCompatSeekBar.setSecondaryProgress(0);
        }
    }

    public final void refreshTime(int currentTime) {
        AppCompatSeekBar appCompatSeekBar;
        TextView textView;
        ViewYouTuBeBinding viewYouTuBeBinding = this.binding;
        if (viewYouTuBeBinding != null && (textView = viewYouTuBeBinding.currentTime) != null) {
            textView.setText(DateUtils.formatTime(currentTime));
        }
        ViewYouTuBeBinding viewYouTuBeBinding2 = this.binding;
        if (viewYouTuBeBinding2 != null && (appCompatSeekBar = viewYouTuBeBinding2.seekBar) != null) {
            appCompatSeekBar.setProgress(currentTime);
        }
    }

    public final void setBinding(@Nullable ViewYouTuBeBinding viewYouTuBeBinding) {
        this.binding = viewYouTuBeBinding;
    }

    public final void setShowBufferingProgress(boolean z) {
        this.showBufferingProgress = z;
    }

    public final void setYoutubePlayerSeekBarListener(@Nullable YouTubePlayerSeekBarListener youTubePlayerSeekBarListener) {
        this.youtubePlayerSeekBarListener = youTubePlayerSeekBarListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTuBeSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTuBeSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.newSeekBarProgress = -1;
        this.showBufferingProgress = true;
        initView(attributeSet);
    }
}
