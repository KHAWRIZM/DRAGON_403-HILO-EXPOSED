package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewYouTuVideoBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.view.youtube.YouTuBeSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/qiahao/nextvideo/room/help/YouTuBeHelper$mListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onReady", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onCurrentSecond", "second", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuBeHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuBeHelper.kt\ncom/qiahao/nextvideo/room/help/YouTuBeHelper$mListener$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,446:1\n1#2:447\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuBeHelper$mListener$1 extends AbstractYouTubePlayerListener {
    final /* synthetic */ YouTuBeHelper this$0;

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YouTuBeHelper$mListener$1(YouTuBeHelper youTuBeHelper) {
        this.this$0 = youTuBeHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStateChange$lambda$0(YouTuBeHelper youTuBeHelper) {
        YouTuBeSeekBar youTuBeSeekBar;
        ViewYouTuVideoBinding mBinding = youTuBeHelper.getMBinding();
        if (mBinding != null && (youTuBeSeekBar = mBinding.seekbar) != null) {
            youTuBeSeekBar.refreshTime((int) youTuBeHelper.getMCurrentSecond());
        }
    }

    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        super.onCurrentSecond(youTubePlayer, second);
        this.this$0.setMCurrentSecond(second);
    }

    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        super.onReady(youTubePlayer);
        this.this$0.setMHasInit(true);
        this.this$0.setMYouTubePlayer(youTubePlayer);
        this.this$0.initView();
        if (this.this$0.getMHasPlay()) {
            this.this$0.refreshGameData();
            this.this$0.setMHasPlay(false);
        }
    }

    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        ImageView imageView;
        ImageView imageView2;
        ViewYouTuVideoBinding mBinding;
        ImageView imageView3;
        View view;
        ImageView imageView4;
        Drawable drawable;
        int i;
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomSmall()) {
            return;
        }
        int i2 = 0;
        if (this.this$0.getMDelayPaused() && state == PlayerConstants.PlayerState.PLAYING) {
            this.this$0.setMDelayPaused(false);
            YouTubePlayer mYouTubePlayer = this.this$0.getMYouTubePlayer();
            if (mYouTubePlayer != null) {
                mYouTubePlayer.pause();
            }
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            final YouTuBeHelper youTuBeHelper = this.this$0;
            hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.z8
                @Override // java.lang.Runnable
                public final void run() {
                    YouTuBeHelper$mListener$1.onStateChange$lambda$0(YouTuBeHelper.this);
                }
            }, 500L);
            return;
        }
        this.this$0.setMState(state);
        ViewYouTuVideoBinding mBinding2 = this.this$0.getMBinding();
        if (mBinding2 != null && (imageView4 = mBinding2.playPauseButton) != null) {
            Context context = this.this$0.getFragment().getContext();
            if (context != null) {
                if (PlayerConstants.PlayerState.PLAYING != state) {
                    i = R.drawable.you_tu_be_start;
                } else {
                    i = R.drawable.you_tu_be_stop;
                }
                drawable = androidx.core.content.a.getDrawable(context, i);
            } else {
                drawable = null;
            }
            imageView4.setImageDrawable(drawable);
        }
        Context context2 = this.this$0.getFragment().getContext();
        if (context2 != null) {
            int color = androidx.core.content.a.getColor(context2, android.R.color.transparent);
            ViewYouTuVideoBinding mBinding3 = this.this$0.getMBinding();
            if (mBinding3 != null && (view = mBinding3.panel) != null) {
                view.setBackgroundColor(color);
            }
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5 && (mBinding = this.this$0.getMBinding()) != null && (imageView3 = mBinding.playPauseButton) != null) {
                    if (!meetingRoomManager.checkOwnOrManager()) {
                        i2 = 8;
                    }
                    imageView3.setVisibility(i2);
                    return;
                }
                return;
            }
            ViewYouTuVideoBinding mBinding4 = this.this$0.getMBinding();
            if (mBinding4 != null && (imageView2 = mBinding4.playPauseButton) != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        ViewYouTuVideoBinding mBinding5 = this.this$0.getMBinding();
        if (mBinding5 != null && (imageView = mBinding5.playPauseButton) != null) {
            if (!meetingRoomManager.checkOwnOrManager()) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }
}
