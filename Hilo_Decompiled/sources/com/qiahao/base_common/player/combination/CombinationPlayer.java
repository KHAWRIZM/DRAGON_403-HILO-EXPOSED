package com.qiahao.base_common.player.combination;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.player.IPlayer;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerException;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.combination.ICombinationPlayer;
import com.qiahao.base_common.player.svga.ISVGAPlayer;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.player.svga.SVGAPlayer;
import com.qiahao.base_common.player.vap.IVapPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.vap.VapPlayer;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.player.video.VideoPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u000fB+\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u0011J\u0010\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\b\u00106\u001a\u00020\u001fH\u0016J\n\u00107\u001a\u0004\u0018\u00010$H\u0016J\u0012\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010:\u001a\u00020*2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\b\u0010<\u001a\u00020*H\u0016J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u001fH\u0004J\u0018\u0010?\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010>\u001a\u00020\u001fH\u0004J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0014J\u0018\u0010C\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010D\u001a\u00020\u001fH\u0016J\u0010\u0010E\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010F\u001a\u00020\u0004H\u0002J\b\u0010G\u001a\u00020*H\u0007J\b\u0010H\u001a\u00020*H\u0016R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/qiahao/base_common/player/combination/CombinationPlayer;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/base_common/player/combination/ICombinationPlayer;", "Lcom/oudi/utils/log/ILog;", "Lcom/qiahao/base_common/player/PlayerEventListener;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "svgePlayer", "Lcom/qiahao/base_common/player/svga/SVGAPlayer;", "vapPlayer", "Lcom/qiahao/base_common/player/vap/VapPlayer;", "videoPlayer", "Lcom/qiahao/base_common/player/video/VideoPlayer;", "currentPlayer", "Lcom/qiahao/base_common/player/IPlayer;", "getCurrentPlayer", "()Lcom/qiahao/base_common/player/IPlayer;", "setCurrentPlayer", "(Lcom/qiahao/base_common/player/IPlayer;)V", "currentState", "Lcom/qiahao/base_common/player/PlayerState;", "playWhenReady", "", "Ljava/lang/Boolean;", "currentSource", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "playerEventListener", "childPlayerEventListener", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bindingLifeCycle", "", "prepare", "source", "stop", "reset", "getView", "Landroid/view/View;", "getSVGAPlayerNotNull", "Lcom/qiahao/base_common/player/svga/ISVGAPlayer;", "getVapPlayerNotNull", "Lcom/qiahao/base_common/player/vap/IVapPlayer;", "getVideoPlayerNotNull", "getCurrentState", "getCurrentSource", "setPlayerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPlayWhenReady", "getPlayWhenReady", "restart", "postState", "state", "postPlayerStateChanged", "postError", "exception", "Lcom/qiahao/base_common/player/PlayerException;", "onPlayerStateChanged", "playbackState", "onPlayerError", "getChildPlayerEventListenerNotNull", "onDestroy", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CombinationPlayer extends FrameLayout implements ICombinationPlayer, ILog, PlayerEventListener, LifecycleObserver {

    @Nullable
    private PlayerEventListener childPlayerEventListener;

    @Nullable
    private IPlayer currentPlayer;

    @Nullable
    private PlayerMediaSource currentSource;

    @Nullable
    private PlayerState currentState;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @Nullable
    private Boolean playWhenReady;

    @Nullable
    private PlayerEventListener playerEventListener;

    @Nullable
    private SVGAPlayer svgePlayer;

    @Nullable
    private VapPlayer vapPlayer;

    @Nullable
    private VideoPlayer videoPlayer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CombinationPlayer(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final PlayerEventListener getChildPlayerEventListenerNotNull() {
        if (this.childPlayerEventListener == null) {
            this.childPlayerEventListener = new PlayerEventListener() { // from class: com.qiahao.base_common.player.combination.CombinationPlayer$getChildPlayerEventListenerNotNull$1
                @Override // com.qiahao.base_common.player.PlayerEventListener
                public void onPlayerError(PlayerException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    PlayerEventListener.DefaultImpls.onPlayerError(this, error);
                    CombinationPlayer.this.postError(error);
                }

                @Override // com.qiahao.base_common.player.PlayerEventListener
                public void onPlayerStateChanged(boolean playWhenReady, PlayerState state) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    PlayerEventListener.DefaultImpls.onPlayerStateChanged(this, playWhenReady, state);
                    CombinationPlayer.this.postPlayerStateChanged(playWhenReady, state);
                }
            };
        }
        PlayerEventListener playerEventListener = this.childPlayerEventListener;
        Intrinsics.checkNotNull(playerEventListener);
        return playerEventListener;
    }

    private final ISVGAPlayer getSVGAPlayerNotNull() {
        View view;
        if (this.svgePlayer == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SVGAPlayer sVGAPlayer = new SVGAPlayer(context);
            this.svgePlayer = sVGAPlayer;
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null) {
                sVGAPlayer.bindingLifeCycle(lifecycleOwner);
            }
            SVGAPlayer sVGAPlayer2 = this.svgePlayer;
            if (sVGAPlayer2 != null) {
                view = sVGAPlayer2.getView();
            } else {
                view = null;
            }
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        SVGAPlayer sVGAPlayer3 = this.svgePlayer;
        Intrinsics.checkNotNull(sVGAPlayer3);
        return sVGAPlayer3;
    }

    private final IVapPlayer getVapPlayerNotNull() {
        View view;
        if (this.vapPlayer == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            VapPlayer vapPlayer = new VapPlayer(context);
            this.vapPlayer = vapPlayer;
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null) {
                vapPlayer.bindingLifeCycle(lifecycleOwner);
            }
            VapPlayer vapPlayer2 = this.vapPlayer;
            if (vapPlayer2 != null) {
                view = vapPlayer2.getView();
            } else {
                view = null;
            }
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        VapPlayer vapPlayer3 = this.vapPlayer;
        Intrinsics.checkNotNull(vapPlayer3);
        return vapPlayer3;
    }

    private final IPlayer getVideoPlayerNotNull() {
        View view;
        if (this.videoPlayer == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            VideoPlayer videoPlayer = new VideoPlayer(context);
            this.videoPlayer = videoPlayer;
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null) {
                videoPlayer.bindingLifeCycle(lifecycleOwner);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                view = videoPlayer2.getView();
            } else {
                view = null;
            }
            addView(view, layoutParams);
        }
        VideoPlayer videoPlayer3 = this.videoPlayer;
        Intrinsics.checkNotNull(videoPlayer3);
        return videoPlayer3;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void bindingLifeCycle(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        ICombinationPlayer.DefaultImpls.bindingLifeCycle(this, lifecycleOwner);
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
        SVGAPlayer sVGAPlayer = this.svgePlayer;
        if (sVGAPlayer != null) {
            sVGAPlayer.bindingLifeCycle(lifecycleOwner);
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.bindingLifeCycle(lifecycleOwner);
        }
        VapPlayer vapPlayer = this.vapPlayer;
        if (vapPlayer != null) {
            vapPlayer.bindingLifeCycle(lifecycleOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @Nullable
    public PlayerMediaSource getCurrentSource() {
        PlayerMediaSource playerMediaSource = this.currentSource;
        if (playerMediaSource == null) {
            IPlayer iPlayer = this.currentPlayer;
            if (iPlayer != null) {
                return iPlayer.getCurrentSource();
            }
            return null;
        }
        return playerMediaSource;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @NotNull
    /* renamed from: getCurrentState */
    public PlayerState getPlayerState() {
        PlayerState playerState = this.currentState;
        if (playerState == null) {
            return PlayerState.IDLE;
        }
        return playerState;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    public boolean getPlayWhenReady() {
        Boolean bool = this.playWhenReady;
        if (bool == null) {
            IPlayer iPlayer = this.currentPlayer;
            if (iPlayer != null) {
                bool = Boolean.valueOf(iPlayer.getPlayWhenReady());
            } else {
                bool = null;
            }
            if (bool == null) {
                return true;
            }
        }
        return bool.booleanValue();
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        ICombinationPlayer.DefaultImpls.onCleared(this);
        ILog.DefaultImpls.logD$default(this, "onCleared()", null, false, 6, null);
        SVGAPlayer sVGAPlayer = this.svgePlayer;
        if (sVGAPlayer != null) {
            sVGAPlayer.onCleared();
        }
        VapPlayer vapPlayer = this.vapPlayer;
        if (vapPlayer != null) {
            vapPlayer.onCleared();
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.onCleared();
        }
        this.playerEventListener = null;
        this.childPlayerEventListener = null;
        this.lifecycleOwner = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        onCleared();
    }

    @Override // com.qiahao.base_common.player.PlayerEventListener
    public void onPlayerError(@NotNull PlayerException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.onPlayerError(exception);
        }
    }

    @Override // com.qiahao.base_common.player.PlayerEventListener
    public void onPlayerStateChanged(boolean playWhenReady, @NotNull PlayerState playbackState) {
        Intrinsics.checkNotNullParameter(playbackState, "playbackState");
        PlayerEventListener.DefaultImpls.onPlayerStateChanged(this, playWhenReady, playbackState);
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.onPlayerStateChanged(playWhenReady, playbackState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postError(@NotNull PlayerException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        onPlayerError(exception);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void postPlayerStateChanged(boolean playWhenReady, @NotNull PlayerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == getPlayerState() && playWhenReady == getPlayWhenReady()) {
            return;
        }
        this.currentState = state;
        this.playWhenReady = Boolean.valueOf(playWhenReady);
        onPlayerStateChanged(playWhenReady, state);
    }

    protected final void postState(@NotNull PlayerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        postPlayerStateChanged(getPlayWhenReady(), state);
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void prepare(@NotNull PlayerMediaSource source) {
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(source, "source");
        ILog.DefaultImpls.logE$default((ILog) this, "prepare() source:" + source, (String) null, false, 6, (Object) null);
        this.currentSource = source;
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            iPlayer.setPlayerEventListener(null);
        }
        postState(PlayerState.BUFFERING);
        IPlayer iPlayer2 = this.currentPlayer;
        if (iPlayer2 != null) {
            iPlayer2.stop(true);
        }
        IPlayer iPlayer3 = this.currentPlayer;
        if (iPlayer3 != null && (view2 = iPlayer3.getView()) != null) {
            view2.setVisibility(8);
        }
        if (source instanceof SVGAMediaSource) {
            this.currentPlayer = getSVGAPlayerNotNull();
        } else if (source instanceof VapMediaSource) {
            this.currentPlayer = getVapPlayerNotNull();
        } else if (source instanceof VideoMediaSource) {
            this.currentPlayer = getVideoPlayerNotNull();
        } else {
            ILog.DefaultImpls.logE$default((ILog) this, "prepare() 不支持数据源", (String) null, false, 6, (Object) null);
            this.currentPlayer = null;
            postError(new PlayerException(0, "不支持数据源"));
        }
        IPlayer iPlayer4 = this.currentPlayer;
        if (iPlayer4 != null && (view = iPlayer4.getView()) != null) {
            view.setVisibility(0);
        }
        IPlayer iPlayer5 = this.currentPlayer;
        if (iPlayer5 != null) {
            iPlayer5.setPlayerEventListener(getChildPlayerEventListenerNotNull());
        }
        IPlayer iPlayer6 = this.currentPlayer;
        if (iPlayer6 != null) {
            iPlayer6.prepare(source);
        }
    }

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    public void restart() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            iPlayer.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCurrentPlayer(@Nullable IPlayer iPlayer) {
        this.currentPlayer = iPlayer;
    }

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    public void setPlayWhenReady(boolean playWhenReady) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            iPlayer.setPlayWhenReady(playWhenReady);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayerEventListener(@Nullable PlayerEventListener listener) {
        this.playerEventListener = listener;
    }

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    public void stop(boolean reset) {
        IPlayer iPlayer;
        View view;
        if (reset && (iPlayer = this.currentPlayer) != null && (view = iPlayer.getView()) != null) {
            view.setVisibility(8);
        }
        IPlayer iPlayer2 = this.currentPlayer;
        if (iPlayer2 != null) {
            iPlayer2.stop(reset);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public CombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
