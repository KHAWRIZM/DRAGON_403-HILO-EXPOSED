package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/room/help/GameMusicHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "isPlaying", "", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "", "playMusic", "resId", "", "isLooping", "isWait", "volume", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameMusicHelper {

    @NotNull
    private final Context context;
    private boolean isPlaying;

    @Nullable
    private MediaPlayer mMediaPlayer;

    public GameMusicHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public static /* synthetic */ void playMusic$default(GameMusicHelper gameMusicHelper, int i, boolean z, boolean z2, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            f = 1.0f;
        }
        gameMusicHelper.playMusic(i, z, z2, f);
    }

    public final void destroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void playMusic(int resId, boolean isLooping, boolean isWait, float volume) {
        if (isWait && this.isPlaying) {
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        MediaPlayer create = MediaPlayer.create(this.context, resId);
        this.mMediaPlayer = create;
        if (create != null) {
            create.setVolume(volume, volume);
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.qiahao.nextvideo.room.help.d5
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer3) {
                    GameMusicHelper.this.isPlaying = false;
                }
            });
        }
        MediaPlayer mediaPlayer3 = this.mMediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setLooping(isLooping);
        }
        MediaPlayer mediaPlayer4 = this.mMediaPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.start();
        }
        this.isPlaying = true;
    }
}
