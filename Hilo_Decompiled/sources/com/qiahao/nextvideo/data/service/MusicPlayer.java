package com.qiahao.nextvideo.data.service;

import android.app.Application;
import android.media.SoundPool;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\"\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/service/MusicPlayer;", "Landroid/media/SoundPool$OnLoadCompleteListener;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "actionMusicPlayer", "Landroid/media/SoundPool;", "sourceDa", "", "currentStreamID", "getCurrentStreamID", "()I", "setCurrentStreamID", "(I)V", "playSound", "", "source", "playHitCardSound", "stopAll", "onLoadComplete", "soundPool", "sampleId", "status", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MusicPlayer implements SoundPool.OnLoadCompleteListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static MusicPlayer shared;

    @NotNull
    private SoundPool actionMusicPlayer;

    @NotNull
    private final Application context;
    private int currentStreamID;
    private int sourceDa;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/data/service/MusicPlayer$Companion;", "", "<init>", "()V", "shared", "Lcom/qiahao/nextvideo/data/service/MusicPlayer;", "getShared", "()Lcom/qiahao/nextvideo/data/service/MusicPlayer;", "setShared", "(Lcom/qiahao/nextvideo/data/service/MusicPlayer;)V", "init", "", "context", "Landroid/app/Application;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MusicPlayer getShared() {
            MusicPlayer musicPlayer = MusicPlayer.shared;
            if (musicPlayer != null) {
                return musicPlayer;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shared");
            return null;
        }

        public final void init(@NotNull Application context) {
            Intrinsics.checkNotNullParameter(context, "context");
            setShared(new MusicPlayer(context));
        }

        public final void setShared(@NotNull MusicPlayer musicPlayer) {
            Intrinsics.checkNotNullParameter(musicPlayer, "<set-?>");
            MusicPlayer.shared = musicPlayer;
        }

        private Companion() {
        }
    }

    public MusicPlayer(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.context = application;
        SoundPool soundPool = new SoundPool(10, 0, 5);
        this.actionMusicPlayer = soundPool;
        soundPool.setOnLoadCompleteListener(this);
        this.sourceDa = this.actionMusicPlayer.load(application, R.raw.shutter, 0);
    }

    private final void playSound(int source) {
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    public final int getCurrentStreamID() {
        return this.currentStreamID;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(@Nullable SoundPool soundPool, int sampleId, int status) {
        int i;
        if (soundPool != null) {
            i = soundPool.play(sampleId, 0.5f, 0.5f, 0, -1, 0.99f);
        } else {
            i = 0;
        }
        this.currentStreamID = i;
    }

    public final void playHitCardSound() {
        playSound(this.sourceDa);
    }

    public final void setCurrentStreamID(int i) {
        this.currentStreamID = i;
    }

    public final void stopAll() {
        int i = this.currentStreamID;
        if (i > 0) {
            this.actionMusicPlayer.stop(i);
        }
    }
}
