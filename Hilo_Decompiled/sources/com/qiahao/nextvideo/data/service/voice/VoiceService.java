package com.qiahao.nextvideo.data.service.voice;

import android.media.MediaPlayer;
import android.net.Uri;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.model.DownloadProgressModel;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.utilities.FileManager;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import la.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.g;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\rR%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001c8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010$0$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceService;", "", "<init>", "()V", "Landroid/net/Uri;", "uri", "", "play", "(Landroid/net/Uri;)V", "onAudioPlaying", "Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;", Constants.KEY_MODEL, "playVoice", "(Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;)V", "stopAll", "Landroid/media/MediaPlayer;", "player", "Landroid/media/MediaPlayer;", "Ljava/util/Timer;", "timer", "Ljava/util/Timer;", "Lnd/a;", "disposeBag", "Lnd/a;", "Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;", "getModel", "()Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;", "setModel", "Lla/b;", "Lcom/qiahao/nextvideo/data/service/voice/VoiceStatus;", "kotlin.jvm.PlatformType", "voiceStatusRelay", "Lla/b;", "getVoiceStatusRelay", "()Lla/b;", "Lla/c;", "", "voiceErrorRelay", "Lla/c;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVoiceService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceService.kt\ncom/qiahao/nextvideo/data/service/voice/VoiceService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VoiceService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final VoiceService shared;

    @NotNull
    private nd.a disposeBag = new nd.a();

    @Nullable
    private VoiceModel model;

    @Nullable
    private MediaPlayer player;

    @Nullable
    private Timer timer;

    @NotNull
    private final c voiceErrorRelay;

    @NotNull
    private final la.b voiceStatusRelay;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceService$Companion;", "", "<init>", "()V", "shared", "Lcom/qiahao/nextvideo/data/service/voice/VoiceService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/voice/VoiceService;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VoiceService getShared() {
            return VoiceService.shared;
        }

        private Companion() {
        }
    }

    static {
        VoiceService voiceService = new VoiceService();
        voiceService.voiceStatusRelay.accept(VoiceStatus.INSTANCE.getIDLE());
        shared = voiceService;
    }

    public VoiceService() {
        la.b e = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.voiceStatusRelay = e;
        c e2 = c.e();
        Intrinsics.checkNotNullExpressionValue(e2, "create(...)");
        this.voiceErrorRelay = e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAudioPlaying() {
        Integer num;
        MediaPlayer mediaPlayer = this.player;
        Integer num2 = null;
        if (mediaPlayer != null) {
            num = Integer.valueOf(mediaPlayer.getCurrentPosition());
        } else {
            num = null;
        }
        MediaPlayer mediaPlayer2 = this.player;
        if (mediaPlayer2 != null) {
            num2 = Integer.valueOf(mediaPlayer2.getDuration());
        }
        VoiceModel voiceModel = this.model;
        if (num != null && num2 != null && voiceModel != null) {
            this.voiceStatusRelay.accept(new VoiceStatus(voiceModel.getId(), VoiceStatusState.PLAYING, num.intValue() / Math.max(1.0f, num2.intValue())));
        }
    }

    private final void play(Uri uri) {
        MediaPlayer create = MediaPlayer.create(ActivityLifecycleManager.INSTANCE.currentActivity(), uri);
        if (create == null) {
            return;
        }
        create.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.qiahao.nextvideo.data.service.voice.a
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                VoiceService.play$lambda$2(VoiceService.this, mediaPlayer);
            }
        });
        create.setVolume(1.0f, 1.0f);
        create.start();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.qiahao.nextvideo.data.service.voice.VoiceService$play$2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    VoiceService.this.onAudioPlaying();
                } catch (IllegalStateException unused) {
                }
            }
        }, 0L, 100L);
        this.player = create;
        this.timer = timer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(VoiceService voiceService, MediaPlayer mediaPlayer) {
        VoiceConfig voiceConfig;
        Uri uri;
        VoiceModel voiceModel = voiceService.model;
        if (voiceModel != null && (voiceConfig = voiceModel.getVoiceConfig()) != null && voiceConfig.isLooping()) {
            VoiceModel voiceModel2 = voiceService.model;
            if (voiceModel2 != null && (uri = voiceModel2.getUri()) != null) {
                voiceService.play(uri);
                return;
            }
            return;
        }
        voiceService.stopAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVoice$lambda$0(VoiceService voiceService, File file) {
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
        voiceService.play(fromFile);
    }

    @Nullable
    public final VoiceModel getModel() {
        return this.model;
    }

    @NotNull
    public final la.b getVoiceStatusRelay() {
        return this.voiceStatusRelay;
    }

    public final void playVoice(@NotNull VoiceModel model) {
        Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
        stopAll();
        this.model = model;
        Uri uri = model.getUri();
        String url = model.getUrl();
        if (uri != null) {
            play(uri);
            return;
        }
        if (url != null && !StringsKt.isBlank(url)) {
            this.voiceStatusRelay.accept(new VoiceStatus(model.getId(), VoiceStatusState.LOADING, 0.0f));
            final File tempVoiceFile = FileManager.INSTANCE.getTempVoiceFile();
            BaseServer baseServer = BaseServer.INSTANCE;
            Intrinsics.checkNotNull(url);
            nd.c subscribe = baseServer.download(url, tempVoiceFile).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new g() { // from class: com.qiahao.nextvideo.data.service.voice.VoiceService$playVoice$1
                public final void accept(DownloadProgressModel downloadProgressModel) {
                    Intrinsics.checkNotNullParameter(downloadProgressModel, "it");
                }
            }, new g() { // from class: com.qiahao.nextvideo.data.service.voice.VoiceService$playVoice$2
                public final void accept(Throwable th) {
                    c cVar;
                    Intrinsics.checkNotNullParameter(th, "it");
                    cVar = VoiceService.this.voiceErrorRelay;
                    cVar.accept(th);
                    VoiceService.this.getVoiceStatusRelay().accept(VoiceStatus.INSTANCE.getIDLE());
                }
            }, new pd.a() { // from class: com.qiahao.nextvideo.data.service.voice.b
                public final void run() {
                    VoiceService.playVoice$lambda$0(VoiceService.this, tempVoiceFile);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
            RxUtilsKt.addTo(subscribe, this.disposeBag);
        }
    }

    public final void setModel(@Nullable VoiceModel voiceModel) {
        this.model = voiceModel;
    }

    public final void stopAll() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.disposeBag.d();
            MediaPlayer mediaPlayer2 = this.player;
            if (mediaPlayer2 != null) {
                mediaPlayer2.reset();
            }
            MediaPlayer mediaPlayer3 = this.player;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setOnCompletionListener(null);
                try {
                    mediaPlayer3.stop();
                } catch (IllegalStateException unused) {
                } catch (Throwable th) {
                    mediaPlayer3.release();
                    throw th;
                }
                mediaPlayer3.release();
            }
            this.player = null;
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
            }
            this.timer = null;
            this.voiceStatusRelay.accept(VoiceStatus.INSTANCE.getIDLE());
            this.model = null;
        }
    }
}
